package com.example.ecsite.domain.model;

import java.math.BigDecimal;

/**
 * ポイント分類一覧を保持するモデルクラスです。
 *
 * @author MizukiSugou
 */
public class PointCategoryInfo {

    /** ポイント分類コード */
    private String pointCategoryCode = null;

    /** ポイント数 */
    private BigDecimal pointAmount = null;

    /**
     * ポイント分類コードを返します。
     *
     * @return ポイント分類コード
     */
    public String getPointCategoryCode() {
        return pointCategoryCode;
    }

    /**
     * ポイント分類コードを設定します。
     *
     * @param pointCategoryCode ポイント分類コード
     */
    public void setPointCategoryCode(String pointCategoryCode) {
        this.pointCategoryCode = pointCategoryCode;
    }

    /**
     * ポイント数を返します。
     *
     * @return ポイント数
     */
    public BigDecimal getPointAmount() {
        return pointAmount;
    }

    /**
     * ポイント数を設定します。
     *
     * @param pointAmount ポイント数
     */
    public void setPointAmount(BigDecimal pointAmount) {
        this.pointAmount = pointAmount;
    }
}
