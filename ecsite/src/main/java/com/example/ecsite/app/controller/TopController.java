package com.example.ecsite.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.ecsite.domain.service.CommonService;

import lombok.RequiredArgsConstructor;

/**
 * トップ画面のControllerクラスです。
 *
 * @author MizukiSugou
 */
@Controller
@RequiredArgsConstructor
public class TopController {

    /** 共通処理Service */
    private final CommonService commonService;

    /**
     * ログアウト処理を行います。
     *
     * @param model モデル情報
     * @param session セッション情報
     * @return ログイン画面
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(Model model, HttpSession session) {

        // ログアウト処理
        if (!commonService.checkSessionTimeOut(session)) {
            // セッションが有効な場合、無効にする
            session.invalidate();
        }

        return "redirect:/";
    }
}
