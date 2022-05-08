package com.example.ecsite.app.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ecsite.app.config.CommonConst;
import com.example.ecsite.app.form.GoodsDetailForm;
import com.example.ecsite.domain.model.UserInfo;
import com.example.ecsite.domain.service.CommonService;
import com.example.ecsite.domain.service.GoodsDetailService;

import lombok.RequiredArgsConstructor;

/**
 * 商品詳細画面のControllerクラスです。
 *
 * @author MizukiSugou
 */
@Controller
@RequestMapping("/goodsDetail")
@RequiredArgsConstructor
public class GoodsDetailController {

    /** 共通処理Service */
    private final CommonService commonService;

    /** 商品詳細画面Service */
    private final GoodsDetailService goodsDetailService;

    /**
     *  初期表示を行います。
     *
     * @param goodsId 商品ID
     * @param model モデル情報
     * @param session セッション情報
     * @return ログイン画面または商品詳細画面
     */
    @RequestMapping(value = "/index", method = { RequestMethod.GET, RequestMethod.POST })
    public String index(@RequestParam(name = "goodsId", required = true) String goodsId, Model model,
            HttpSession session) {

        GoodsDetailForm form = new GoodsDetailForm();

        // セッションタイムアウトチェック
        if (commonService.checkSessionTimeOut(session)) {
            return "redirect:/" + CommonConst.TIME_OUT_REQUEST_PARAMETER;
        }

        // 商品情報の取得
        goodsDetailService.getGoodsInfo(form, goodsId);
        form.setExchangeAmount("0");
        form.setBeforeMyPoint(BigDecimal.ZERO);
        form.setAfterMyPoint(BigDecimal.ZERO);
        form.setTotalExchagePoint(BigDecimal.ZERO);
        form.setInputExchage(true);

        setDispDataToHidden(form);

        model.addAttribute("goodsDetailForm", form);

        return "goodsDetail";
    }

    /**
     * 交換ボタン押下時の処理を行います。
     *
     * @param form 商品詳細フォーム
     * @param model モデル情報
     * @param session セッション情報
     * @return ログイン画面または商品詳細画面
     */
    @RequestMapping(value = "/exchange", params = "exchangeButton", method = RequestMethod.POST)
    public String exchangeByExchangeButton(@ModelAttribute GoodsDetailForm form, Model model, HttpSession session) {

        // セッションタイムアウトチェック
        if (commonService.checkSessionTimeOut(session)) {
            return "redirect:/" + CommonConst.TIME_OUT_REQUEST_PARAMETER;
        }

        setHiddenDataToDisp(form);

        // 入力チェック
        if (goodsDetailService.checkInput(form, ((UserInfo) session.getAttribute(
                CommonConst.LOGIN_USER_INFO)).getUserId())) {
            // 入力エラー時
            form.setInputExchage(true);

        } else {
            // 入力正常時
            form.setInputExchage(false);

            // DB更新に使用するデータを隠し項目にセット
            form.setHidAfterMyPoint(form.getAfterMyPoint());
            form.setHidTotalExchagePoint(form.getTotalExchagePoint());
            form.setHidExchangeAmount(form.getExchangeAmount());
        }

        return "goodsDetail";
    }

    /**
     * 確認ボタン押下時の処理を行います。
     *
     * @param form 商品詳細フォーム
     * @param model モデル情報
     * @param session セッション情報
     * @return ログイン画面またはポイント詳細画面
     */
    @RequestMapping(value = "/exchange", params = "confirmationButton", method = RequestMethod.POST)
    public String confirmByConfirmationButton(@ModelAttribute GoodsDetailForm form, Model model, HttpSession session) {

        // セッションタイムアウトチェック
        if (commonService.checkSessionTimeOut(session)) {
            return "redirect:/" + CommonConst.TIME_OUT_REQUEST_PARAMETER;
        }

        // DB更新に使用するデータを隠し項目にセット
        form.setGoodsId(form.getHidGoodsId());
        form.setAfterMyPoint(form.getHidAfterMyPoint());
        form.setTotalExchagePoint(form.getHidTotalExchagePoint());
        form.setExchangeAmount(form.getHidExchangeAmount());

        // 商品の交換処理
        goodsDetailService.exchange(form, ((UserInfo) session.getAttribute(
                CommonConst.LOGIN_USER_INFO)).getUserId());

        return "forward:/pointDetail/index/";
    }

    /**
     * キャンセルボタン押下時の処理を行います。
     *
     * @param form 商品詳細フォーム
     * @param model モデル情報
     * @param session セッション情報
     * @return ログイン画面または商品詳細画面
     */
    @RequestMapping(value = "/exchange", params = "cancelButton", method = RequestMethod.POST)
    public String cancelByCancelButton(@ModelAttribute GoodsDetailForm form, Model model, HttpSession session) {

        // セッションタイムアウトチェック
        if (commonService.checkSessionTimeOut(session)) {
            return "redirect:/" + CommonConst.TIME_OUT_REQUEST_PARAMETER;
        }

        setHiddenDataToDisp(form);

        form.setExchangeAmount("0");
        form.setInputExchage(true);

        return "goodsDetail";
    }

    /**
     * 表示項目のデータを隠し項目用のフィールドにセットします。
     *
     * @param form 商品詳細フォーム
     */
    private void setDispDataToHidden(GoodsDetailForm form) {
        form.setHidGoodsPoint(form.getGoodsPoint());
        form.setHidGoodsName(form.getGoodsName());
        form.setHidImagePath(form.getImagePath());
        form.setHidGoodsInfo1(form.getGoodsInfo1());
        form.setHidGoodsInfo2(form.getGoodsInfo2());
        form.setHidGoodsId(form.getGoodsId());
        form.setHidCategoryName(form.getCategoryName());
        form.setHidMaxExchangeCount(form.getMaxExchangeCount());
    }

    /**
     * 隠し項目用のデータを表示項目のフィールドにセットします。
     *
     * @param form 商品詳細フォーム
     */
    private void setHiddenDataToDisp(GoodsDetailForm form) {
        form.setGoodsPoint(form.getHidGoodsPoint());
        form.setGoodsName(form.getHidGoodsName());
        form.setImagePath(form.getHidImagePath());
        form.setGoodsInfo1(form.getHidGoodsInfo1());
        form.setGoodsInfo2(form.getHidGoodsInfo2());
        form.setGoodsId(form.getHidGoodsId());
        form.setCategoryName(form.getHidCategoryName());
        form.setMaxExchangeCount(form.getHidMaxExchangeCount());
    }
}
