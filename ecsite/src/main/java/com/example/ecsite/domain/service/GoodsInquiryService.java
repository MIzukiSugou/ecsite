package com.example.ecsite.domain.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecsite.app.config.CommonConst;
import com.example.ecsite.app.form.GoodsInquiryForm;
import com.example.ecsite.domain.model.GoodsInfo;
import com.example.ecsite.domain.model.MyPointInfo;
import com.example.ecsite.domain.model.PageInfo;
import com.example.ecsite.domain.model.UserInfo;

import lombok.RequiredArgsConstructor;

/**
 * 商品一覧画面のServiceクラスです。
 *
 * @author MizukiSugou
 */
@Service
@Transactional
@RequiredArgsConstructor
public class GoodsInquiryService {

    /** 初期ページフラグ */
    private static final int INIT_PAGE_FLG = 0;

    /** 次ページフラグ */
    private static final int NEXT_PAGE_FLG = 1;

    /** 前ページフラグ */
    private static final int PREV_PAGE_FLG = 2;

    /** 1ページの商品数 */
    private static final BigDecimal A_PAGE_AMOUNT = new BigDecimal(9);

    /** ページ情報保存キー */
    private static final String PAGE_INFO_PRESERVATION_KEY = "page_info_preservation_key";

    /** 共通処理Service */
    private final CommonService commonService;

    /**
     * 商品情報を検索します。
     *
     * @param form 商品一覧フォーム
     * @param session セッション情報
     */
    public void getGoodsInfo(GoodsInquiryForm form, HttpSession session) {

        // 商品情報の取得
        List<GoodsInfo> goodsList = getGoodsList(form, session);

        if (goodsList == null) {
            // エラーの場合、終了
            return;
        }

        if (goodsList.size() <= 0) {
            // 商品件数合計
            form.setTotalGoodsCount(BigDecimal.ZERO);
            // ページ数合計
            form.setTotalPageCount(BigDecimal.ZERO);
            // 現在表示ページ数
            form.setPageCount(BigDecimal.ZERO);
            // 現在表示商品数（開始）
            form.setFirstGoodsCount(BigDecimal.ZERO);
            // 現在表示商品数（終了）
            form.setLastGoodsCount(BigDecimal.ZERO);

        } else {
            PageInfo pageInfo = new PageInfo();
            // 商品件数合計
            pageInfo.setTotalGoodsCount(new BigDecimal(goodsList.size()));
            // ページ数合計
            pageInfo.setTotalPageCount(
                    pageInfo.getTotalGoodsCount().divide(A_PAGE_AMOUNT, 0, BigDecimal.ROUND_CEILING));
            pageInfo.setGoodsList(goodsList);

            // ページ情報の保存
            session.setAttribute(PAGE_INFO_PRESERVATION_KEY, pageInfo);

            // ページング処理
            pageControl(form, session, INIT_PAGE_FLG);
        }
    }

    /**
     * 商品情報を取得します。
     *
     * @param form 商品一覧フォーム
     * @param session セッション情報
     * @return 商品情報
     */
    private List<GoodsInfo> getGoodsList(GoodsInquiryForm form, HttpSession session) {

        // 検索条件の編集
        // 検索商品番号
        if (session.getAttribute(CommonConst.SEARCH_ID_KEY) != null) {
            form.setSearchGoodsId(
                    (String) session.getAttribute(CommonConst.SEARCH_ID_KEY));
            session.removeAttribute(CommonConst.SEARCH_ID_KEY);
        }
        String searchGoodsId = null;
        if (form.getSearchGoodsId() != null &&
                !"".equals(form.getSearchGoodsId())) {
            searchGoodsId = form.getSearchGoodsId();
        }

        // 検索ポイント数
        if (session.getAttribute(CommonConst.SEARCH_POINT_KEY) != null) {
            form.setSearchPointAmount(
                    (String) session.getAttribute(CommonConst.SEARCH_POINT_KEY));
            session.removeAttribute(CommonConst.SEARCH_POINT_KEY);
        }
        String searchPointAmount = null;
        if (form.getSearchPointAmount() != null &&
                !"".equals(form.getSearchPointAmount())) {
            searchPointAmount = form.getSearchPointAmount();
        }

        // 検索ジャンル
        if (session.getAttribute(CommonConst.SEARCH_GENRE_KEY) != null) {
            form.setSearchGenre(
                    (String) session.getAttribute(CommonConst.SEARCH_GENRE_KEY));
            session.removeAttribute(CommonConst.SEARCH_GENRE_KEY);
        }
        String searchGenre = null;
        if (form.getSearchGenre() != null &&
                !"".equals(form.getSearchGenre())) {
            searchGenre = form.getSearchGenre();
        }

        // ユーザID
        String userId = ((UserInfo) session.getAttribute(
                CommonConst.LOGIN_USER_INFO)).getUserId();

        // 検索クエリ実行
        List<GoodsInfo> goodsList = commonService.getGoodsList(userId, searchGoodsId, searchPointAmount, searchGenre);

        return goodsList;
    }

    /**
     * 現在のポイント数を取得します。
     *
     * @param form 商品一覧フォーム
     * @param userId ログインユーザID
     */
    public void getMyPoint(GoodsInquiryForm form, String userId) {

        MyPointInfo myPointInfo = commonService.getMyPoint(userId);
        if (myPointInfo != null) {
            form.setMyPoint(myPointInfo.getBalancePoint());
        }
    }

    /**
     * ページング処理を行います。
     *
     * @param form 商品一覧フォーム
     * @param session セッション情報
     * @param type ページング種別
     */
    public void pageControl(GoodsInquiryForm form, HttpSession session, int type) {

        // ページ情報の取得
        PageInfo pageInfo = (PageInfo) session.getAttribute(PAGE_INFO_PRESERVATION_KEY);

        // 商品件数合計
        form.setTotalGoodsCount(pageInfo.getTotalGoodsCount());
        // ページ数合計
        form.setTotalPageCount(pageInfo.getTotalPageCount());

        // 現在表示ページ数
        BigDecimal pageCount = BigDecimal.ONE;
        switch (type) {
        case NEXT_PAGE_FLG:
            pageCount = pageInfo.getPageCount().add(BigDecimal.ONE);
            break;
        case PREV_PAGE_FLG:
            if (pageInfo.getPageCount().compareTo(BigDecimal.ONE) != 0) {
                pageCount = pageInfo.getPageCount().subtract(BigDecimal.ONE);
            }
            break;
        default:
            break;
        }
        pageInfo.setPageCount(pageCount);
        form.setPageCount(pageCount);

        // 現在表示商品数（開始）
        BigDecimal firstGoodsCount = BigDecimal.ONE;
        switch (type) {
        case NEXT_PAGE_FLG:
            firstGoodsCount = pageInfo.getFirstGoodsCount().add(A_PAGE_AMOUNT);
            break;
        case PREV_PAGE_FLG:
            if (pageInfo.getFirstGoodsCount().compareTo(BigDecimal.ONE) != 0) {
                firstGoodsCount = pageInfo.getFirstGoodsCount().subtract(A_PAGE_AMOUNT);
            }
            break;
        default:
            break;
        }
        pageInfo.setFirstGoodsCount(firstGoodsCount);
        form.setFirstGoodsCount(firstGoodsCount);

        if (pageInfo.getTotalPageCount().equals(pageInfo.getPageCount())) {
            // 最終ページを表示する場合
            // 現在表示商品数（終了）
            form.setLastGoodsCount(pageInfo.getTotalGoodsCount());
            // 次のページリンク表示フラグ
            form.setShowNextLink(false);

        } else {
            // 現在表示商品数（終了）
            form.setLastGoodsCount(
                    pageInfo.getFirstGoodsCount().add(A_PAGE_AMOUNT)
                            .subtract(new BigDecimal(1)));
            // 次のページリンク表示フラグ
            form.setShowNextLink(true);
        }

        if (pageInfo.getPageCount().equals(BigDecimal.ONE)) {
            // 1ページ目の場合
            // 前のページリンク表示フラグ
            form.setShowForwardLink(false);
        } else {
            // 前のページリンク表示フラグ
            form.setShowForwardLink(true);
        }

        List<GoodsInfo> goodsList = pageInfo.getGoodsList();
        form.setGoodsList(new ArrayList<GoodsInfo>());
        for (int i = pageInfo.getFirstGoodsCount().subtract(BigDecimal.ONE).intValue(), len = pageInfo
                .getFirstGoodsCount().add(A_PAGE_AMOUNT).subtract(BigDecimal.ONE).intValue(); i < len; i++) {
            GoodsInfo goodsInfo = new GoodsInfo();

            if (goodsList.size() > i) {
                goodsInfo = goodsList.get(i);
            }

            form.getGoodsList().add(goodsInfo);
        }

        // ページ情報の保存
        session.setAttribute(PAGE_INFO_PRESERVATION_KEY, pageInfo);
    }
}
