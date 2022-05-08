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
import com.example.ecsite.app.form.LoginForm;
import com.example.ecsite.domain.service.LoginService;

import lombok.RequiredArgsConstructor;

/**
 * ログイン画面のControllerクラスです。
 *
 * @author MizukiSugou
 */
@Controller
@RequestMapping({ "/", "/login" })
@RequiredArgsConstructor
public class LoginController {

    /** セッションタイムアウトエラーメッセージ */
    private static final String ERROR_SESSION_TIME_OUT = "セッションタイムアウトにより、ログアウトしました。";

    /** ログイン画面Service */
    private final LoginService loginService;

    /**
     * 初期表示を行います。
     *
     * @param model モデル情報
     * @return ログイン画面
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(@ModelAttribute LoginForm form,
    		@RequestParam(name = "logoutParam", required = false) String logoutParam,
    		Model model) {

        if (!StringUtils.isEmpty(logoutParam) && CommonConst.FORWARD_SESSION_TIME_OUT.equals(logoutParam)) {
            // セッションタイムアウトにより、ログアウトした場合
            form.setErrorMessage(ERROR_SESSION_TIME_OUT);
        }

        model.addAttribute("loginForm", form);

        return "login";
    }

    /**
     * ログイン処理を行います。
     *
     * @param form ログインフォーム
     * @param model モデル情報
     * @param session セッション情報
     * @return ログイン画面またはメニュー画面
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute LoginForm form, Model model, HttpSession session) {

        // 入力チェック
        if (loginService.checkInput(form)) {
            // 入力エラーの場合
            return "login";
        }

        // ログイン処理
        if (loginService.executeLogin(form, session)) {
            // 取得エラーの場合
            return "login";
        }

        return "forward:/main/index/";
    }
}
