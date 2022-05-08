package com.example.ecsite.domain.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * キャンペーン情報を保持するモデルクラスです。
 *
 * @author MizukiSugou
 */
public class CampaignInfo {

    /** キャンペーン開始日 */
    private Date campaignStartDate = null;

    /** キャンペーン終了日 */
    private Date campaignEndDate = null;

    /** 限定個数 */
    private BigDecimal limitCount = null;

    /**
     * キャンペーン開始日を返します。
     *
     * @return キャンペーン開始日
     */
    public Date getCampaignStartDate() {
        return campaignStartDate;
    }

    /**
     * キャンペーン開始日を設定します。
     *
     * @param campaignStartDate キャンペーン開始日
     */
    public void setCampaignStartDate(Date campaignStartDate) {
        this.campaignStartDate = campaignStartDate;
    }

    /**
     * キャンペーン終了日を返します。
     *
     * @return キャンペーン終了日
     */
    public Date getCampaignEndDate() {
        return campaignEndDate;
    }

    /**
     * キャンペーン終了日を設定します。
     *
     * @param campaignEndDate キャンペーン終了日
     */
    public void setCampaignEndDate(Date campaignEndDate) {
        this.campaignEndDate = campaignEndDate;
    }

    /**
     * 限定個数を返します。
     *
     * @return 限定個数
     */
    public BigDecimal getLimitCount() {
        return limitCount;
    }

    /**
     * 限定個数を設定します。
     *
     * @param limitCount 限定個数
     */
    public void setLimitCount(BigDecimal limitCount) {
        this.limitCount = limitCount;
    }
}
