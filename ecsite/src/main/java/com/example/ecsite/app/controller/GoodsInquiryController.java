package com.example.ecsite.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ecsite.app.config.CommonConst;
import com.example.ecsite.app.form.GoodsInquiryForm;
import com.example.ecsite.domain.model.UserInfo;
import com.example.ecsite.domain.service.CommonService;
import com.example.ecsite.domain.service.GoodsInquiryService;

import lombok.RequiredArgsConstructor;

/**
 * 商品一覧画面のControllerクラスです。
 *
 * @author MizukiSugou
 */
@Controller
@RequestMapping("/goodsInquiry")
@RequiredArgsConstructor
public class GoodsInquiryController {

    /** 次ページフラグ */
    private static final int NEXT_PAGE_FLG = 1;

    /** 前ページフラグ */
    private static final int PREV_PAGE_FLG = 2;

    /** 共通処理Service */
    private final CommonService commonService;

    /** 商品一覧画面Service */
    private final GoodsInquiryService goodsInquiryService;

    /**
     * 初期表示を行います。
     *
     * @param model モデル情報
     * @param session セッション情報
     * @return ログイン画面または商品一覧画面
     */
    @RequestMapping(value = "/index", method = { RequestMethod.GET, RequestMethod.POST })
    public String index(Model model, HttpSession session) {

        GoodsInquiryForm form = new GoodsInquiryForm();

        // セッションタイムアウトチェック
        if (commonService.checkSessionTimeOut(session)) {
            return "redirect:/" + CommonConst.TIME_OUT_REQUEST_PARAMETER;
        }

        searchGoodsInfo(form, session);

        model.addAttribute("goodsInquiryForm", form);

        return "goodsInquiry";
    }

    /**
     * ポイント数とジャンルを条件に検索処理を行います。
     *
     * @param form 商品一覧フォーム
     * @param model モデル情報
     * @param session セッション情報
     * @return ログイン画面または商品一覧画面
     */
    @RequestMapping(value = "/search", params = "searchPointAndGenreButton", method = RequestMethod.POST)
    public String searchByPointAndGenreButton(@ModelAttribute GoodsInquiryForm form, Model model, HttpSession session) {

        // セッションタイムアウトチェック
        if (commonService.checkSessionTimeOut(session)) {
            return "redirect:/" + CommonConst.TIME_OUT_REQUEST_PARAMETER;
        }

        form.setSearchGoodsId("");
        searchGoodsInfo(form, session);

        return "goodsInquiry";
    }

    /**
     * アイテム番号を条件に検索処理を行います。
     *
     * @param form 商品一覧フォーム
     * @param model モデル情報
     * @param session セッション情報
     * @return ログイン画面または商品一覧画面
     */
    @RequestMapping(value = "/search", params = "searchGoodsIdButton", method = RequestMethod.POST)
    public String searchByGoodsIdButton(@ModelAttribute GoodsInquiryForm form, Model model, HttpSession session) {
        // アイテム番号で検索する場合

        // セッションタイムアウトチェック
        if (commonService.checkSessionTimeOut(session)) {
            return "redirect:/" + CommonConst.TIME_OUT_REQUEST_PARAMETER;
        }

        form.setSearchGenre("");
        form.setSearchPointAmount("");
        searchGoodsInfo(form, session);

        return "goodsInquiry";
    }

    /**
     * ページング処理を行います。
     *
     * @param pageControl 遷移先ページ判定フラグ
     * @param form 商品一覧フォーム
     * @param model モデル情報
     * @param session セッション情報
     * @return ログイン画面または商品一覧画面
     */
    @RequestMapping(value = "/pageMove", method = RequestMethod.GET)
    public String pageMove(@RequestParam(name = "page_control", required = true) String pageControl,
            @ModelAttribute GoodsInquiryForm form, Model model, HttpSession session) {

        // セッションタイムアウトチェック
        if (commonService.checkSessionTimeOut(session)) {
            return "redirect:/" + CommonConst.TIME_OUT_REQUEST_PARAMETER;
        }

        // 遷移先のページを判定
        int type = "next".equals(pageControl) ? NEXT_PAGE_FLG : PREV_PAGE_FLG;
        goodsInquiryService.pageControl(form, session, type);

        // ジャンル一覧の取得
        form.setGenreList(commonService.getGenreList(session));

        // ポイント分類一覧の取得
        form.setPointCategoryList(commonService.getPointCategoryList(session));

        // 現在のポイント数の取得
        goodsInquiryService.getMyPoint(form,
                ((UserInfo) session.getAttribute(CommonConst.LOGIN_USER_INFO))
                        .getUserId());

        return "goodsInquiry";
    }

    /**
     * 商品詳細画面に遷移します。
     *
     * @return 商品詳細画面
     */
    @RequestMapping(value = "/viewGoodsDetail", method = RequestMethod.GET)
    public String viewGoodsDetail() {
        return "forward:/goodsDetail/index/";
    }

    /**
     * 商品情報とその他の表示情報を取得します。
     *
     * @param form 商品一覧フォーム
     * @param session セッション情報
     */
    private void searchGoodsInfo(GoodsInquiryForm form, HttpSession session) {

        // 商品情報の検索
        goodsInquiryService.getGoodsInfo(form, session);

        // ジャンル一覧の取得
        form.setGenreList(commonService.getGenreList(session));

        // ポイント分類一覧の取得
        form.setPointCategoryList(commonService.getPointCategoryList(session));

        // 現在のポイント数の取得
        goodsInquiryService.getMyPoint(form,
                ((UserInfo) session.getAttribute(CommonConst.LOGIN_USER_INFO))
                        .getUserId());
    }
}
