package com.example.ecsite.app.form;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ログイン画面のフォームクラスです。
 *
 * @author MizukiSugou
 */
@Data
@AllArgsConstructor
public class LoginForm {

    /** ログインID */
    private String loginId = null;

    /** パスワード */
    private String password = null;

    /** エラーメッセージ */
    private String errorMessage = null;

}
