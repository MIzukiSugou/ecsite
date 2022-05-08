package com.example.ecsite.domain.model;

/**
 * ジャンル一覧を保持するモデルクラスです。
 *
 * @author MizukiSugou
 */
public class GenreInfo {

    /** ジャンルコード */
    private String genreCode = null;

    /** ジャンル名称 */
    private String genreName = null;

    /**
     * ジャンルコードを返します。
     *
     * @return genreCode ジャンルコード
     */
    public String getGenreCode() {
        return genreCode;
    }

    /**
     * ジャンルコードを設定します。
     *
     * @param genreCode ジャンルコード
     */
    public void setGenreCode(String genreCode) {
        this.genreCode = genreCode;
    }

    /**
     * ジャンル名称を返します。
     *
     * @return ジャンル名称
     */
    public String getGenreName() {
        return genreName;
    }

    /**
     * ジャンル名称を設定します。
     *
     * @param genreName ジャンル名称
     */
    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
