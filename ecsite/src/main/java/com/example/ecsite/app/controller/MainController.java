package com.example.ecsite.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.ecsite.app.config.CommonConst;
import com.example.ecsite.domain.service.CommonService;

import lombok.RequiredArgsConstructor;

/**
 * メイン画面のControllerクラスです。
 *
 * @author MizukiSugou
 */
@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainController {

    /** 共通処理Service */
    private final CommonService commonService;

    /**
     * 初期表示を行います。
     *
     * @param model モデル情報
     * @param session セッション情報
     * @return メイン画面
     */
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String index(Model model, HttpSession session) {

        // セッションタイムアウトチェック
        if (commonService.checkSessionTimeOut(session)) {
            return "redirect:/" + CommonConst.TIME_OUT_REQUEST_PARAMETER;
        }

        return "main";
    }

    /**
     * ポイント詳細画面を表示します。
     *
     * @param model モデル情報
     * @return ポイント詳細画面
     */
    @RequestMapping(value = "/viewPointDetail", method = RequestMethod.POST)
    public String viewPointDetail(Model model) {
        return "forward:/pointDetail/index/";
    }
}
