package com.example.ecsite.domain.model;

import java.math.BigDecimal;

/**
 * ユーザの所持ポイント数を保持するモデルクラスです。
 *
 * @author MizukiSugou
 */
public class MyPointInfo {

    /** 残高ポイント */
    private BigDecimal balancePoint = null;

    /** 前月ポイント残高 */
    private BigDecimal prevBalancePoint = null;

    /** 今月取得ポイント */
    private BigDecimal acquisitionPoint = null;

    /** 今月消費ポイント */
    private BigDecimal expenditurePoint = null;

    /** 今月交換回数 */
    private BigDecimal exchangeCount = null;

    /**
     * 残高ポイントを返します。
     *
     * @return 残高ポイント
     */
    public BigDecimal getBalancePoint() {
        return balancePoint;
    }

    /**
     * 残高ポイントを設定します。
     *
     * @param balancePoint 残高ポイント
     */
    public void setBalancePoint(BigDecimal balancePoint) {
        this.balancePoint = balancePoint;
    }

    /**
     * 前月ポイント残高を返します。
     *
     * @return prevBalancePoint
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
     * 今月取得ポイントを返します。
     *
     * @return 今月取得ポイント
     */
    public BigDecimal getAcquisitionPoint() {
        return acquisitionPoint;
    }

    /**
     * 今月取得ポイントを設定します。
     *
     * @param acquisitionPoint 今月取得ポイント
     */
    public void setAcquisitionPoint(BigDecimal acquisitionPoint) {
        this.acquisitionPoint = acquisitionPoint;
    }

    /**
     * 今月消費ポイントを返します。
     *
     * @return 今月消費ポイント
     */
    public BigDecimal getExpenditurePoint() {
        return expenditurePoint;
    }

    /**
     * 今月消費ポイントを設定します。
     *
     * @param expenditurePoint 今月消費ポイント
     */
    public void setExpenditurePoint(BigDecimal expenditurePoint) {
        this.expenditurePoint = expenditurePoint;
    }

    /**
     * 今月交換回数を返します。
     *
     * @return 今月交換回数
     */
    public BigDecimal getExchangeCount() {
        return exchangeCount;
    }

    /**
     * 今月交換回数を設定します。
     *
     * @param exchangeCount 今月交換回数
     */
    public void setExchangeCount(BigDecimal exchangeCount) {
        this.exchangeCount = exchangeCount;
    }
}
