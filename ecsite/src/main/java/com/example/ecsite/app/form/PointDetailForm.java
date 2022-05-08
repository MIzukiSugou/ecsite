package com.example.ecsite.app.form;

import java.math.BigDecimal;
import java.util.List;

import com.example.ecsite.domain.model.GenreInfo;
import com.example.ecsite.domain.model.PointCategoryInfo;
import com.example.ecsite.domain.model.RecommendationInfo;

/**
 * ポイント詳細画面のフォームクラスです。
 *
 * @author MizukiSugou
 */
public class PointDetailForm {

    /** 前月ポイント残高 */
    private BigDecimal prevBalancePoint = null;

    /** 今月の獲得ポイント */
    private BigDecimal acquisitionPoint = null;

    /** 今月の消費ポイント */
    private BigDecimal expenditurePoint = null;

    /** 今月のポイント残高 */
    private BigDecimal balancePoint = null;

    /** 今月の交換回数 */
    private BigDecimal exchangeCount = null;

    /** おすすめ情報リスト */
    private List<RecommendationInfo> recommendationList = null;

    /** 検索ポイント数 */
    private String searchPoint = null;

    /** 検索アイテム番号 */
    private String searchId = null;

    /** ジャンル一覧リスト */
    private List<GenreInfo> genreList = null;

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
     * 前月ポイント残高を返します。
     *
     * @return 前月ポイント残高
     */
    public BigDecimal getPrevBalancePoint() {
        return prevBalancePoint;
    }

    /**
     * 前月ポイント残高を設定します。
     *
     * @param prevBalancePoint 前月ポイント残高
     */
    public void setPrevBalancePoint(BigDecimal prevBalancePoint) {
        this.prevBalancePoint = prevBalancePoint;
    }

    /**
     * 今月の獲得ポイントを返します。
     *
     * @return 今月の獲得ポイント
     */
    public BigDecimal getAcquisitionPoint() {
        return acquisitionPoint;
    }

    /**
     * 今月の獲得ポイントを設定します。
     *
     * @param acquisitionPoint 今月の獲得ポイント
     */
    public void setAcquisitionPoint(BigDecimal acquisitionPoint) {
        this.acquisitionPoint = acquisitionPoint;
    }

    /**
     * 今月の消費ポイントを返します。
     *
     * @return 今月の消費ポイント
     */
    public BigDecimal getExpenditurePoint() {
        return expenditurePoint;
    }

    /**
     * 今月の消費ポイントを設定します。
     *
     * @param expenditurePoint 今月の消費ポイント
     */
    public void setExpenditurePoint(BigDecimal expenditurePoint) {
        this.expenditurePoint = expenditurePoint;
    }

    /**
     * 今月のポイント残高を返します。
     *
     * @return 今月のポイント残高
     */
    public BigDecimal getBalancePoint() {
        return balancePoint;
    }

    /**
     * 今月のポイント残高を設定します。
     *
     * @param balancePoint 今月のポイント残高
     */
    public void setBalancePoint(BigDecimal balancePoint) {
        this.balancePoint = balancePoint;
    }

    /**
     * 今月の交換回数を返します。
     *
     * @return 今月の交換回数
     */
    public BigDecimal getExchangeCount() {
        return exchangeCount;
    }

    /**
     * 今月の交換回数を設定します。
     *
     * @param exchangeCount 今月の交換回数
     */
    public void setExchangeCount(BigDecimal exchangeCount) {
        this.exchangeCount = exchangeCount;
    }

    /**
     * おすすめ情報リストを返します。
     *
     * @return おすすめ情報リスト
     */
    public List<RecommendationInfo> getRecommendationList() {
        return recommendationList;
    }

    /**
     * おすすめ情報リストを設定します。
     *
     * @param recommendationList おすすめ情報リスト
     */
    public void setRecommendationList(List<RecommendationInfo> recommendationList) {
        this.recommendationList = recommendationList;
    }

    /**
     * 検索ポイント数を返します。
     *
     * @return 検索ポイント数
     */
    public String getSearchPoint() {
        return searchPoint;
    }

    /**
     * 検索ポイント数を設定します。
     *
     * @param searchPoint 検索ポイント数
     */
    public void setSearchPoint(String searchPoint) {
        this.searchPoint = searchPoint;
    }

    /**
     * 検索アイテム番号を返します。
     *
     * @return 検索アイテム番号
     */
    public String getSearchId() {
        return searchId;
    }

    /**
     * 検索アイテム番号を設定します。
     *
     * @param searchId 検索アイテム番号
     */
    public void setSearchId(String searchId) {
        this.searchId = searchId;
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
     *o
     * @param genreList ジャンル一覧リスト
     */
    public void setGenreList(List<GenreInfo> genreList) {
        this.genreList = genreList;
    }
}
