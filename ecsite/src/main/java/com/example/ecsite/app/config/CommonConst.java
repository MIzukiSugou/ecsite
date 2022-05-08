package com.example.ecsite.app.config;

/**
 * 共通定数クラスです。
 *
 * @author MizukiSugou
 */
public class CommonConst {

    /** ログインユーザのユーザ情報取得キー */
    public static final String LOGIN_USER_INFO = "login_user_info";

    /** フォワード文字列 セッションタイムアウト */
    public static final String FORWARD_SESSION_TIME_OUT = "session_time_out";

    /** 商品検索用ポイント数取得キー */
    public static final String SEARCH_POINT_KEY = "search_point_key";

    /** 商品検索用商品番号取得キー */
    public static final String SEARCH_ID_KEY = "search_id_key";

    /** 商品検索用ジャンル取得キー */
    public static final String SEARCH_GENRE_KEY = "search_genre_key";

    /** ジャンル一覧取得キー */
    public static final String GET_GENRE_LIST = "get_genre_list";

    /** ポイント分類一覧取得キー */
    public static final String GET_POINT_CATEGORY_LIST = "get_point_category_list";

    /** セッションタイムアウト時のリクエストパラメータ文字列 */
    public static final String TIME_OUT_REQUEST_PARAMETER = "?logoutParam=session_time_out";
    
    /** 全アイテム一覧リンク押下時のリクエストパラメータ文字列 */
    public static final String ALL_SEARCH_PARAMETER = "all";
}
