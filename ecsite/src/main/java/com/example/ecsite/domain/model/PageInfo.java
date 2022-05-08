package com.example.ecsite.domain.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * ページング処理に必要な情報を保持するクラスです。
 *
 * @author MizukiSugou
 */
public class PageInfo {

    /** 商品件数合計 */
    private BigDecimal totalGoodsCount = null;

    /** ページ数合計 */
    private BigDecimal totalPageCount = null;

    /** 現在表示ページ数 */
    private BigDecimal pageCount = null;

    /** 現在表示商品数（開始） */
    private BigDecimal firstGoodsCount = null;

    /** 商品リスト */
    private List<GoodsInfo> goodsList = null;

    /**
     * 商品件数合計を返します。
     *
     * @return 商品件数合計
     */
    public BigDecimal getTotalGoodsCount() {
        return totalGoodsCount;
    }

    /**
     * 商品件数合計を設定します。
     *
     * @param totalGoodsCount 商品件数合計
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
}
