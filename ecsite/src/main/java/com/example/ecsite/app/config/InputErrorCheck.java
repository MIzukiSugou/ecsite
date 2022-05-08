package com.example.ecsite.app.config;

import java.util.regex.Pattern;

/**
 * 入力エラーチェックを行うクラスです。
 *
 * @author MizukiSugou
 */
public class InputErrorCheck {

    /**
     * 指定の文字列が未入力であるかどうかをチェックします。
     *
     * @param input 入力文字列
     * @return true:チェックエラー、false:チェック正常
     */
    public static boolean checkBlankString(String input) {

        if (input == null) {
            return true;
        }

        if (input.length() <= 0) {
            return true;
        }

        return false;
    }

    /**
     * 指定の文字列が指定の桁数であることをチェックします。
     *
     * @param input 入力文字列
     * @param length 文字数
     * @return true:チェックエラー、false:チェック正常
     */
    public static boolean checkLengthString(String input, int length) {

        if (checkBlankString(input)) {
            return false;
        }

        if (input.length() == length) {
            return false;
        }

        return true;
    }

    /**
     * 指定の文字列が数値であるかどうかをチェックします。
     *
     * @param input 入力文字列
     * @return true:チェックエラー、false:チェック正常
     */
    public static boolean checkNumberString(String input) {

        if (checkBlankString(input)) {
            return false;
        }

        if (Pattern.compile("^[0-9]*").matcher(input).matches()) {
            return false;
        }

        return true;
    }

    /**
     * 指定の文字列が半角英数字であるかどうかをチェックします。
     *
     * @param input 入力文字列
     * @return true:チェックエラー、false:チェック正常
     */
    public static boolean checkHankakuString(String input) {

        if (checkBlankString(input)) {
            return false;
        }

        if (Pattern.compile("^[0-9a-zA-Z]*").matcher(input).matches()) {
            return false;
        }

        return true;
    }
}
