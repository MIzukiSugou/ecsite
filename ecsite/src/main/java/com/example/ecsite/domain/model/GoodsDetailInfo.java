package com.example.ecsite.domain.model;

import java.math.BigDecimal;

/**
 * 商品詳細情報を保持するクラスです。
 *
 * @author MizukiSugou
 */
public class GoodsDetailInfo {

    /** 商品名 */
    private String goodsName = null;

    /** 交換ポイント */
    private BigDecimal goodsPoint = null;

    /** 商品説明1 */
    private String goodsInfo1 = null;

    /** 商品説明2 */
    private String goodsInfo2 = null;

    /** 商品画像パス */
    private String imagePath = null;

    /** 交換最大数 */
    private BigDecimal maxExchangeCount = null;

    /** 分類名 */
    private String categoryName = null;

    /**
     * 商品名を返します。
     *
     * @return 商品名
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 商品名を設定します。
     *
     * @param goodsName 商品名
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * 交換ポイントを返します。
     *
     * @return 交換ポイント
     */
    public BigDecimal getGoodsPoint() {
        return goodsPoint;
    }

    /**
     * 交換ポイントを設定します。
     *
     * @param goodsPoint 交換ポイント
     */
    public void setGoodsPoint(BigDecimal goodsPoint) {
        this.goodsPoint = goodsPoint;
    }

    /**
     * 商品説明1を返します。
     *
     * @return 商品説明1
     */
    public String getGoodsInfo1() {
        return goodsInfo1;
    }

    /**
     * 商品説明1を設定します。
     *
     * @param goodsInfo1 商品説明1
     */
    public void setGoodsInfo1(String goodsInfo1) {
        this.goodsInfo1 = goodsInfo1;
    }

    /**
     * 商品説明2を返します。
     *
     * @return 商品説明2
     */
    public String getGoodsInfo2() {
        return goodsInfo2;
    }

    /**
     * 商品説明2を設定します。
     *
     * @param goodsInfo2 商品説明2
     */
    public void setGoodsInfo2(String goodsInfo2) {
        this.goodsInfo2 = goodsInfo2;
    }

    /**
     * 商品画像パスを返します。
     *
     * @return 商品画像パス
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * 商品画像パスを設定します。
     *
     * @param imagePath 商品画像パス
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * 交換最大数を返します。
     *
     * @return 交換最大数
     */
    public BigDecimal getMaxExchangeCount() {
        return maxExchangeCount;
    }

    /**
     * 交換最大数を設定します。
     *
     * @param maxExchangeCount 交換最大数
     */
    public void setMaxExchangeCount(BigDecimal maxExchangeCount) {
        this.maxExchangeCount = maxExchangeCount;
    }

    /**
     * 分類名を返します。
     *
     * @return 分類名
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 分類名を設定します。
     *
     * @param categoryName 分類名
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
