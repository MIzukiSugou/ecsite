package com.example.ecsite.app.form;

import java.math.BigDecimal;

/**
 * 商品詳細画面のフォームクラスです。
 *
 * @author MizukiSugou
 */
public class GoodsDetailForm {

    /** 交換ポイント */
    private BigDecimal goodsPoint = null;

    /** 商品名 */
    private String goodsName = null;

    /** 商品画像パス */
    private String imagePath = null;

    /** 商品説明1 */
    private String goodsInfo1 = null;

    /** 商品説明2 */
    private String goodsInfo2 = null;

    /** 商品ID */
    private String goodsId = null;

    /** 分類名 */
    private String categoryName = null;

    /** 交換個数 */
    private String exchangeAmount = null;

    /** エラーメッセージ */
    private String errorMessage = null;

    /** 合計交換ポイント */
    private BigDecimal totalExchagePoint = null;

    /** 交換前所持ポイント */
    private BigDecimal beforeMyPoint = null;

    /** 交換後所持ポイント */
    private BigDecimal afterMyPoint = null;

    /** 交換個数入力フラグ */
    private boolean inputExchage = false;

    /** 交換最大数 */
    private BigDecimal maxExchangeCount = null;

    /** 隠し交換ポイント */
    private BigDecimal hidGoodsPoint = null;

    /** 隠し商品名 */
    private String hidGoodsName = null;

    /** 隠し商品画像パス */
    private String hidImagePath = null;

    /** 隠し商品説明1 */
    private String hidGoodsInfo1 = null;

    /** 隠し商品説明2 */
    private String hidGoodsInfo2 = null;

    /** 隠し商品ID */
    private String hidGoodsId = null;

    /** 隠し分類名 */
    private String hidCategoryName = null;

    /** 隠し交換個数 */
    private String hidExchangeAmount = null;

    /** 隠し合計交換ポイント */
    private BigDecimal hidTotalExchagePoint = null;

    /** 隠し交換後所持ポイント */
    private BigDecimal hidAfterMyPoint = null;

    /** 隠し交換最大数 */
    private BigDecimal hidMaxExchangeCount = null;

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
     * 交換個数入力フラグを返します。
     *
     * @return 交換個数入力フラグ
     */
    public boolean isInputExchage() {
        return inputExchage;
    }

    /**
     * 交換個数入力フラグを設定します。
     *
     * @param inputExchage 交換個数入力フラグ
     */
    public void setInputExchage(boolean inputExchage) {
        this.inputExchage = inputExchage;
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
     * 交換ポイントを返します。
     *
     * @return 交換ポイント
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 交換ポイントを設定します。
     *
     * @param goodsName 交換ポイント
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

    /**
     * 交換個数を返します。
     *
     * @return 交換個数
     */
    public String getExchangeAmount() {
        return exchangeAmount;
    }

    /**
     * 交換個数を設定します。
     *
     * @param exchangeAmount 交換個数
     */
    public void setExchangeAmount(String exchangeAmount) {
        this.exchangeAmount = exchangeAmount;
    }

    /**
     * エラーメッセージを返します。
     *
     * @return エラーメッセージ
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * エラーメッセージを設定します。
     *
     * @param errorMessage エラーメッセージ
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * 合計交換ポイントを返します。
     *
     * @return 合計交換ポイント
     */
    public BigDecimal getTotalExchagePoint() {
        return totalExchagePoint;
    }

    /**
     * 合計交換ポイントを設定します。
     *
     * @param totalExchagePoint 合計交換ポイント
     */
    public void setTotalExchagePoint(BigDecimal totalExchagePoint) {
        this.totalExchagePoint = totalExchagePoint;
    }

    /**
     * 交換前所持ポイントを返します。
     *
     * @return 交換前所持ポイント
     */
    public BigDecimal getBeforeMyPoint() {
        return beforeMyPoint;
    }

    /**
     * 交換前所持ポイントを設定します。
     *
     * @param beforeMyPoint 交換前所持ポイント
     */
    public void setBeforeMyPoint(BigDecimal beforeMyPoint) {
        this.beforeMyPoint = beforeMyPoint;
    }

    /**
     * 交換後所持ポイントを返します。
     *
     * @return 交換後所持ポイント
     */
    public BigDecimal getAfterMyPoint() {
        return afterMyPoint;
    }

    /**
     * 交換後所持ポイントを設定します。
     *
     * @param afterMyPoint 交換後所持ポイント
     */
    public void setAfterMyPoint(BigDecimal afterMyPoint) {
        this.afterMyPoint = afterMyPoint;
    }

    /**
     * 隠し交換ポイントを返します。
     *
     * @return hidGoodsPoint
     */
    public BigDecimal getHidGoodsPoint() {
        return hidGoodsPoint;
    }

    /**
     * 隠し交換ポイントを設定します。
     *
     * @param hidGoodsPoint
     */
    public void setHidGoodsPoint(BigDecimal hidGoodsPoint) {
        this.hidGoodsPoint = hidGoodsPoint;
    }

    /**
     * 隠し商品名を返します。
     *
     * @return hidGoodsName
     */
    public String getHidGoodsName() {
        return hidGoodsName;
    }

    /**
     * 隠し商品名を設定します。
     *
     * @param hidGoodsName
     */
    public void setHidGoodsName(String hidGoodsName) {
        this.hidGoodsName = hidGoodsName;
    }

    /**
     * 隠し商品画像パスを返します。
     *
     * @return hidImagePath
     */
    public String getHidImagePath() {
        return hidImagePath;
    }

    /**
     * 隠し商品画像パスを設定します。
     *
     * @param hidImagePath
     */
    public void setHidImagePath(String hidImagePath) {
        this.hidImagePath = hidImagePath;
    }

    /**
     * 隠し商品説明1を返します。
     *
     * @return hidGoodsInfo1
     */
    public String getHidGoodsInfo1() {
        return hidGoodsInfo1;
    }

    /**
     * 隠し商品説明1を設定します。
     *
     * @param hidGoodsInfo1
     */
    public void setHidGoodsInfo1(String hidGoodsInfo1) {
        this.hidGoodsInfo1 = hidGoodsInfo1;
    }

    /**
     * 隠し商品説明2を返します。
     *
     * @return hidGoodsInfo2
     */
    public String getHidGoodsInfo2() {
        return hidGoodsInfo2;
    }

    /**
     * 隠し商品説明2を設定します。
     *
     * @param hidGoodsInfo2
     */
    public void setHidGoodsInfo2(String hidGoodsInfo2) {
        this.hidGoodsInfo2 = hidGoodsInfo2;
    }

    /**
     * 隠し商品IDを返します。
     *
     * @return hidGoodsId
     */
    public String getHidGoodsId() {
        return hidGoodsId;
    }

    /**
     * 隠し商品IDを設定します。
     *
     * @param hidGoodsId
     */
    public void setHidGoodsId(String hidGoodsId) {
        this.hidGoodsId = hidGoodsId;
    }

    /**
     * 隠し分類名を返します。
     *
     * @return hidCategoryName
     */
    public String getHidCategoryName() {
        return hidCategoryName;
    }

    /**
     * 隠し分類名を設定します。
     *
     * @param hidCategoryName
     */
    public void setHidCategoryName(String hidCategoryName) {
        this.hidCategoryName = hidCategoryName;
    }

    /**
     * 隠し交換個数を返します。
     *
     * @return hidExchangeAmount
     */
    public String getHidExchangeAmount() {
        return hidExchangeAmount;
    }

    /**
     * 隠し交換個数を設定します。
     *
     * @param hidExchangeAmount
     */
    public void setHidExchangeAmount(String hidExchangeAmount) {
        this.hidExchangeAmount = hidExchangeAmount;
    }

    /**
     * 隠し合計交換ポイントを返します。
     *
     * @return hidTotalExchagePoint
     */
    public BigDecimal getHidTotalExchagePoint() {
        return hidTotalExchagePoint;
    }

    /**
     * 隠し合計交換ポイントを設定します。
     *
     * @param hidTotalExchagePoint
     */
    public void setHidTotalExchagePoint(BigDecimal hidTotalExchagePoint) {
        this.hidTotalExchagePoint = hidTotalExchagePoint;
    }

    /**
     * 隠し交換後所持ポイントを返します。
     *
     * @return hidAfterMyPoint
     */
    public BigDecimal getHidAfterMyPoint() {
        return hidAfterMyPoint;
    }

    /**
     * 隠し交換後所持ポイントを設定します。
     *
     * @param hidAfterMyPoint
     */
    public void setHidAfterMyPoint(BigDecimal hidAfterMyPoint) {
        this.hidAfterMyPoint = hidAfterMyPoint;
    }

    /**
     * 隠し交換最大数を返します。
     *
     * @return hidMaxExchangeCount
     */
    public BigDecimal getHidMaxExchangeCount() {
        return hidMaxExchangeCount;
    }

    /**
     * 隠し交換最大数を設定します。
     *
     * @param hidMaxExchangeCount
     */
    public void setHidMaxExchangeCount(BigDecimal hidMaxExchangeCount) {
        this.hidMaxExchangeCount = hidMaxExchangeCount;
    }
}
