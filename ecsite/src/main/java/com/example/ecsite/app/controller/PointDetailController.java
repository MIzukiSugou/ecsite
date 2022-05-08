package com.example.ecsite.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ecsite.app.config.CommonConst;
import com.example.ecsite.app.form.PointDetailForm;
import com.example.ecsite.domain.model.UserInfo;
import com.example.ecsite.domain.service.CommonService;
import com.example.ecsite.domain.service.PointDetailService;

import lombok.RequiredArgsConstructor;

/**
 * ポイント詳細画面のControllerクラスです。
 *
 * @author MizukiSugou
 */
@Controller
@RequestMapping("/pointDetail")
@RequiredArgsConstructor
public class PointDetailController {

    /** 検索種別判定文字列：ポイント数検索 */
    private static final String SEARCH_TYPE_POINT = "point";

    /** 検索種別判定文字列：アイテム番号検索 */
    private static final String SEARCH_TYPE_ID = "id";

    /** 検索種別判定文字列：ジャンル検索 */
    private static final String SEARCH_TYPE_GENRE = "genre";

    /** 共通処理Service */
    private final CommonService commonService;

    /** ポイント詳細画面Service */
    private final PointDetailService pointDetailService;

    /**
     * 初期表示を行います。
     *
     * @param model モデル情報
     * @param session セッション情報
     * @return ログイン画面またはポイント詳細画面
     */
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String index(Model model, HttpSession session) {

        PointDetailForm form = new PointDetailForm();

        // セッションタイムアウトチェック
        if (commonService.checkSessionTimeOut(session)) {
            return "redirect:/" + CommonConst.TIME_OUT_REQUEST_PARAMETER;
        }

        session.removeAttribute(CommonConst.SEARCH_POINT_KEY);
        session.removeAttribute(CommonConst.SEARCH_ID_KEY);
        session.removeAttribute(CommonConst.SEARCH_GENRE_KEY);

        // 初期処理
        pointDetailService.init(form, ((UserInfo) session.getAttribute(CommonConst.LOGIN_USER_INFO)).getUserId());

        // ジャンル一覧の取得
        form.setGenreList(commonService.getGenreList(session));

        // ポイント分類一覧の取得
        form.setPointCategoryList(commonService.getPointCategoryList(session));

        model.addAttribute("pointDetailForm", form);

        return "pointDetail";
    }

    /**
     * 、
     * リンク押下時の検索処理を行います。
     *
     * @param searchType 検索種別
     * @param searchCondition 検索条件
     * @param form ポイント詳細フォーム
     * @param model モデル情報
     * @param session セッション情報
     * @return 商品一覧画面
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchByLink(@RequestParam(name = "searchType", required = false) String searchType,
            @RequestParam(name = "searchCondition", required = false) String searchCondition,
            @ModelAttribute PointDetailForm form, Model model, HttpSession session) {

        if (!StringUtils.isEmpty(searchCondition)) {
            // 全アイテム一覧リンクまたはジャンル個別リンクでの検索時

            if (CommonConst.ALL_SEARCH_PARAMETER.equals(searchCondition)) {
                // 全アイテム一覧リンクでの検索時

                if (!StringUtils.isEmpty(searchType) && SEARCH_TYPE_POINT.equals(searchType)) {
                    // ポイント数での検索時
                    session.setAttribute(CommonConst.SEARCH_POINT_KEY, "");

                } else if (!StringUtils.isEmpty(searchType) && SEARCH_TYPE_ID.equals(searchType)) {
                    // アイテム番号での検索時
                    session.setAttribute(CommonConst.SEARCH_ID_KEY, "");

                } else if (!StringUtils.isEmpty(searchType) && SEARCH_TYPE_GENRE.equals(searchType)) {
                    // ジャンルでの検索時
                    session.setAttribute(CommonConst.SEARCH_GENRE_KEY, "");
                }

            } else {
                // ジャンル個別リンクでの検索時
                session.setAttribute(CommonConst.SEARCH_GENRE_KEY, searchCondition);
            }
        }

        return "forward:/goodsInquiry/index/";
    }

    /**
     * ポイント数の検索ボタン押下時の処理を行います。
     *
     * @param form ポイント詳細フォーム
     * @param model モデル情報
     * @param session セッション情報
     * @return 商品一覧画面
     */
    @RequestMapping(value = "/search", params = "searchPointButton", method = RequestMethod.POST)
    public String searchBySearchPointButton(@ModelAttribute PointDetailForm form, Model model, HttpSession session) {

        if (CommonConst.ALL_SEARCH_PARAMETER.equals(form.getSearchPoint())) {
            //すべてのポイントを選択時
            session.setAttribute(CommonConst.SEARCH_POINT_KEY, "");

        } else {
            session.setAttribute(CommonConst.SEARCH_POINT_KEY, form.getSearchPoint());
        }

        return "forward:/goodsInquiry/index/";
    }

    /**
     * アイテム番号の検索ボタン押下時の処理を行います。
     *
     * @param form ポイント詳細フォーム
     * @param model モデル情報
     * @param session セッション情報
     * @return 商品一覧画面
     */
    @RequestMapping(value = "/search", params = "searchIdButton", method = RequestMethod.POST)
    public String searchBySearchIdButton(@ModelAttribute PointDetailForm form, Model model, HttpSession session) {
        //アイテム番号の検索ボタン押下時の処理

        session.setAttribute(CommonConst.SEARCH_ID_KEY, form.getSearchId());

        return "forward:/goodsInquiry/index/";
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
}
