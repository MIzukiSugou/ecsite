package com.example.ecsite.app.form;

import java.math.BigDecimal;
import java.util.List;

import com.example.ecsite.domain.model.GenreInfo;
import com.example.ecsite.domain.model.GoodsInfo;
import com.example.ecsite.domain.model.PointCategoryInfo;

/**
 * 商品一覧画面のフォームクラスです。
 *
 * @author MizukiSugou
 */
public class GoodsInquiryForm {

    /** 所持ポイント */
    private BigDecimal myPoint = null;

    /** 検索ポイント数 */
    private String searchPointAmount = null;

    /** 検索ジャンル */
    private String searchGenre = null;

    /** 検索アイテム番号 */
    private String searchGoodsId = null;

    /** 商品件数合計 */
    private BigDecimal totalGoodsCount = null;

    /** ページ数合計 */
    private BigDecimal totalPageCount = null;

    /** 現在表示ページ数 */
    private BigDecimal pageCount = null;

    /** 現在表示商品数（開始） */
    private BigDecimal firstGoodsCount = null;

    /** 現在表示商品数（終了） */
    private BigDecimal lastGoodsCount = null;

    /** 商品リスト */
    private List<GoodsInfo> goodsList = null;

    /** ジャンル一覧リスト */
    private List<GenreInfo> genreList = null;

    /** 前のページリンク表示フラグ */
    private boolean showForwardLink = false;

    /** 次のページリンク表示フラグ */
    private boolean showNextLink = false;

    /** ポイント分類一覧リスト */
    private List<PointCategoryInfo> pointCategoryList = null;

    /**
     * ポイント分類一覧リストを返します。
     *
     * @return ポイント分類一覧リスト
     */
    public List<PointCategoryInfo> getPointCategoryList() {
        return pointCategoryList;
    }

    /**
     * ポイント分類一覧リストを設定します。
     *
     * @param pointCategoryList ポイント分類一覧リスト
     */
    public void setPointCategoryList(List<PointCategoryInfo> pointCategoryList) {
        this.pointCategoryList = pointCategoryList;
    }

    /**
     * 前のページリンク表示フラグを返します。
     *
     * @return 前のページリンク表示フラグ
     */
    public boolean isShowForwardLink() {
        return showForwardLink;
    }

    /**
     * 前のページリンク表示フラグを設定します。
     *
     * @param showForwardLink 前のページリンク表示フラグ
     */
    public void setShowForwardLink(boolean showForwardLink) {
        this.showForwardLink = showForwardLink;
    }

    /**
     * 次のページリンク表示フラグを返します。
     *
     * @return 次のページリンク表示フラグ
     */
    public boolean isShowNextLink() {
        return showNextLink;
    }

    /**
     * 次のページリンク表示フラグを設定します。
     *
     * @param showNextLink 次のページリンク表示フラグ
     */
    public void setShowNextLink(boolean showNextLink) {
        this.showNextLink = showNextLink;
    }

    /**
     * 所持ポイントを返します。
     *
     * @return 所持ポイント
     */
    public BigDecimal getMyPoint() {
        return myPoint;
    }

    /**
     * 所持ポイントを設定します。
     *
     * @param myPoint 所持ポイント
     */
    public void setMyPoint(BigDecimal myPoint) {
        this.myPoint = myPoint;
    }

    /**
     * 検索ポイント数を返します。
     *
     * @return 検索ポイント数
     */
    public String getSearchPointAmount() {
        return searchPointAmount;
    }

    /**
     * 検索ポイント数を設定します。
     *
     * @param searchPointAmount 検索ポイント数
     */
    public void setSearchPointAmount(String searchPointAmount) {
        this.searchPointAmount = searchPointAmount;
    }

    /**
     * 検索ジャンルを返します。
     *
     * @return 検索ジャンル
     */
    public String getSearchGenre() {
        return searchGenre;
    }

    /**
     * 検索ジャンルを設定します。
     *
     * @param searchGenre 検索ジャンル
     */
    public void setSearchGenre(String searchGenre) {
        this.searchGenre = searchGenre;
    }

    /**
     * 検索アイテム番号を返します。
     *
     * @return 検索アイテム番号
     */
    public String getSearchGoodsId() {
        return searchGoodsId;
    }

    /**
     * 検索アイテム番号を設定します。
     *
     * @param searchGoodsId 検索アイテム番号
     */
    public void setSearchGoodsId(String searchGoodsId) {
        this.searchGoodsId = searchGoodsId;
    }

    /**
     * 検索アイテム番号を返します。
     *
     * @return 検索アイテム番号
     */
    public BigDecimal getTotalGoodsCount() {
        return totalGoodsCount;
    }

    /**
     * 検索アイテム番号を設定します。
     *
     * @param totalGoodsCount 検索アイテム番号
     */
    public void setTotalGoodsCount(BigDecimal totalGoodsCount) {
        this.totalGoodsCount = totalGoodsCount;
    }

    /**
     * ページ数合計を返します。
     *
     * @return ページ数合計
     */
    public BigDecimal getTotalPageCount() {
        return totalPageCount;
    }

    /**
     * ページ数合計を設定します。
     *
     * @param totalPageCount ページ数合計
     */
    public void setTotalPageCount(BigDecimal totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    /**
     * 現在表示ページ数を返します。
     *
     * @return 現在表示ページ数
     */
    public BigDecimal getPageCount() {
        return pageCount;
    }

    /**
     * 現在表示ページ数を設定します。
     *
     * @param pageCount 現在表示ページ数
     */
    public void setPageCount(BigDecimal pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * 現在表示商品数（開始）を返します。
     *
     * @return 現在表示商品数（開始）
     */
    public BigDecimal getFirstGoodsCount() {
        return firstGoodsCount;
    }

    /**
     * 現在表示商品数（開始）を設定します。
     *
     * @param firstGoodsCount 現在表示商品数（開始）
     */
    public void setFirstGoodsCount(BigDecimal firstGoodsCount) {
        this.firstGoodsCount = firstGoodsCount;
    }

    /**
     * 現在表示商品数（終了）を返します。
     *
     * @return 現在表示商品数（終了）
     */
    public BigDecimal getLastGoodsCount() {
        return lastGoodsCount;
    }

    /**
     * 現在表示商品数（終了）を設定します。
     *
     * @param lastGoodsCount 現在表示商品数（終了）
     */
    public void setLastGoodsCount(BigDecimal lastGoodsCount) {
        this.lastGoodsCount = lastGoodsCount;
    }

    /**
     * 商品リストを返します。
     *
     * @return 商品リスト
     */
    public List<GoodsInfo> getGoodsList() {
        return goodsList;
    }

    /**
     * 商品リストを設定します。
     *
     * @param goodsList 商品リスト
     */
    public void setGoodsList(List<GoodsInfo> goodsList) {
        this.goodsList = goodsList;
    }

    /**
     * ジャンル一覧リストを返します。
     *
     * @return ジャンル一覧リスト
     */
    public List<GenreInfo> getGenreList() {
        return genreList;
    }

    /**
     * ジャンル一覧リストを設定します。
     *
     * @param genreList ジャンル一覧リスト
     */
    public void setGenreList(List<GenreInfo> genreList) {
        this.genreList = genreList;
    }
}
