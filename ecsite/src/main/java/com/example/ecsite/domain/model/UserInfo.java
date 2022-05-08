package com.example.ecsite.domain.model;

/**
 * ユーザ情報を保持するモデルクラスです。
 *
 * @author MizukiSugou
 */
public class UserInfo {

    /** ユーザID */
    private String userId = null;

    /** ユーザ名 姓（漢字） */
    private String familyNm = null;

    /** ユーザ名 名（漢字） */
    private String firstNm = null;

    /**
     * ユーザIDを返します。
     *
     * @return userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * ユーザIDを設定します。
     *
     * @param userId ユーザID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * ユーザ名 姓（漢字）を返します。
     *
     * @return ユーザ名 姓（漢字）
     */
    public String getFamilyNm() {
        return familyNm;
    }

    /**
     * ユーザ名 姓（漢字）を設定します。
     *
     * @param familyNm ユーザ名 姓（漢字）
     */
    public void setFamilyNm(String familyNm) {
        this.familyNm = familyNm;
    }

    /**
     * ユーザ名 名（漢字）を返します。
     *
     * @return ユーザ名 名（漢字）
     */
    public String getFirstNm() {
        return firstNm;
    }

    /**
     * ユーザ名 名（漢字）を設定します。
     *
     * @param firstNm ユーザ名 名（漢字）
     */
    public void setFirstNm(String firstNm) {
        this.firstNm = firstNm;
    }
}
