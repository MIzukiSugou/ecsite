package com.example.ecsite.domain.model;

import java.math.BigDecimal;

/**
 * 商品情報を保持するモデルクラスです。
 *
 * @author MizukiSugou
 */
public class GoodsInfo {

    /** 商品ID */
    private String goodsId = null;

    /** 交換ポイント */
    private BigDecimal goodsPoint = null;

    /** 画像パス */
    private String imagePath = null;

    /** 商品名 */
    private String goodsName = null;

    /** 交換最大数 */
    private BigDecimal maxExchangeCount = null;

    /**
     * 商品IDを返します。
     *
     * @return 商品ID
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * 商品IDを設定します。
     *
     * @param goodsId 商品ID
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
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
     * 画像パスを返します。
     *
     * @return 画像パス
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * 画像パスを設定します。
     *
     * @param imagePath 画像パス
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * 商品名を返します。
     *
     * @return goodsName 商品名
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
}
