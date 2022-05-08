package com.example.ecsite.domain.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.ecsite.domain.model.GoodsDetailInfo;

/**
 * 商品詳細画面MyBatisマッパークラスです。
 *
 * @author MizukiSugou
 */
@Repository
@Mapper
public interface GoodsDetailMapper {

    /**
     * 交換予定を登録します。
     *
     * @param userId ユーザID
     * @param goodsId 商品ID
     * @param exchangeAmount 交換個数
     */
    public void insertExchangePlan(
            @Param("userId") String userId,
            @Param("goodsId") String goodsId,
            @Param("exchangeAmount") String exchangeAmount);

    /**
     * ポイントマスタを更新します。
     *
     * @param balancePoint 残高ポイント
     * @param expenditurePoint 今月消費ポイント
     * @param userId ユーザID
     */
    public void updatePointMaster(
            @Param("balancePoint") String balancePoint,
            @Param("expenditurePoint") String expenditurePoint,
            @Param("userId") String userId);

    /**
     * 商品詳細情報を取得します。
     *
     * @param goodsId 商品ID
     * @return 商品詳細情報
     */
    public GoodsDetailInfo selectGoodsInfo(@Param("goodsId") String goodsId);
}
