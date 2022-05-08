package com.example.ecsite.domain.model;

import java.math.BigDecimal;

/**
 * おすすめ情報を保持するモデルクラスです。
 *
 * @author MizukiSugou
 */
public class RecommendationInfo {

    /** 残ポイント */
    private BigDecimal remainderPoint = null;

    /** 商品ID */
    private String goodsId = null;

    /** 商品名 */
    private String goodsName = null;

    /** 商品画像パス */
    private String imagePath = null;

    /** 商品交換ポイント */
    private BigDecimal goodsPoint = null;

    /**
     * 残ポイントを返します。
     *
     * @return 残ポイント
     */
    public BigDecimal getRemainderPoint() {
        return remainderPoint;
    }

    /**
     * 残ポイントを設定します。
     *
     * @param remainderPoint 残ポイント
     */
    public void setRemainderPoint(BigDecimal remainderPoint) {
        this.remainderPoint = remainderPoint;
    }

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
     * 商品交換ポイントを返します。
     *
     * @return 商品交換ポイント
     */
    public BigDecimal getGoodsPoint() {
        return goodsPoint;
    }

    /**
     * 商品交換ポイントを設定します。
     *
     * @param goodsPoint 商品交換ポイント
     */
    public void setGoodsPoint(BigDecimal goodsPoint) {
        this.goodsPoint = goodsPoint;
    }
}
