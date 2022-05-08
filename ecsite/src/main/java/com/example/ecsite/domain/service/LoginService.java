package com.example.ecsite.domain.service;

import java.math.BigDecimal;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.ecsite.app.config.CommonConst;
import com.example.ecsite.app.form.LoginForm;
import com.example.ecsite.domain.mapper.LoginMapper;
import com.example.ecsite.domain.model.UserInfo;

import lombok.RequiredArgsConstructor;

/**
 * ログイン画面のServiceクラスです。
 *
 * @author MizukiSugou
 */
@Service
@RequiredArgsConstructor
public class LoginService {

    /** ログインエラーメッセージ */
    private static final String LOGIN_ERROR = "ログインIDまたはパスワードの入力に誤りがあります。";

    /** ログイン画面MyBatisマッパー */
    private final  LoginMapper loginMapper;

    /**
     * 入力チェックを行います。
     *
     * @param form ログインフォーム
     * @return true:エラー false:正常
     */
    public boolean checkInput(LoginForm form) {

        // ログインID
        String loginId = form.getLoginId();
        // パスワード
        String password = form.getPassword();

        BigDecimal count = loginMapper.checkLogin(loginId, password);
        if ((count).intValue() == 0) {
            // ユーザ情報が存在しない場合
            form.setErrorMessage(LOGIN_ERROR);

            // ログイン失敗時のユーザ情報更新クエリを実行
            loginMapper.updateLoginFailure(loginId);

            return true;
        }

        return false;
    }

    /**
     * ログイン処理を行います。
     *
     * @param form ログインフォーム
     * @param session セッション情報
     * @return true:失敗 false:成功
     */
    public boolean executeLogin(LoginForm form, HttpSession session) {

        // ログインID
        String loginId = form.getLoginId();

        // ユーザ情報の取得
        UserInfo userInfo = loginMapper.selectUser(loginId);
        if (userInfo == null) {
            // ユーザ情報が存在しない場合
            form.setErrorMessage(LOGIN_ERROR);

            return true;
        }

        // ユーザ情報をセッションに保存
        userInfo.setUserId(loginId);
        session.setAttribute(CommonConst.LOGIN_USER_INFO, userInfo);

        // ユーザ情報の更新
        loginMapper.updateLoginSuccess(loginId);

        return false;
    }
}
