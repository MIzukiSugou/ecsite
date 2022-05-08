package com.example.ecsite.domain.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.ecsite.domain.model.CampaignInfo;
import com.example.ecsite.domain.model.GenreInfo;
import com.example.ecsite.domain.model.GoodsInfo;
import com.example.ecsite.domain.model.MyPointInfo;
import com.example.ecsite.domain.model.PointCategoryInfo;

/**
 * 共通MyBatisマッパークラスです。
 *
 * @author MizukiSugou
 */
@Mapper
public interface CommonMapper {

    /**
     * キャンペーン情報を取得します。
     *
     * @param goodsId 商品ID
     * @return キャンペーン情報リスト
     */
    public List<CampaignInfo> selectCampaign(@Param("goodsId") String goodsId);

    /**
     * 交換個数を取得します。
     *
     * @param goodsId 商品ID
     * @param userId ユーザID
     * @return 交換個数
     */
    public BigDecimal selectExchangeTotalUser(
            @Param("goodsId") String goodsId,
            @Param("userId") String userId);

    /**
     * ジャンル一覧を取得します。
     *
     * @return ジャンル一覧リスト
     */
    public List<GenreInfo> selectGenre();

    /**
     * 商品情報を取得します。
     *
     * @param userId ユーザID
     * @param goodsId 商品ID
     * @param goodsPoint 交換ポイント
     * @param goodsCategory 分類コード
     * @return 商品情報リスト
     */
    public List<GoodsInfo> selectGoodsInfo(
            @Param("userId") String userId,
            @Param("goodsId") String goodsId,
            @Param("goodsPoint") String goodsPoint,
            @Param("goodsCategory") String goodsCategory);

    /**
     * 未公開商品件数を取得します。
     *
     * @param goodsId 商品ID
     * @return 未公開商品件数
     */
    public BigDecimal selectGoodsPlan(@Param("goodsId") String goodsId);

    /**
     * 所持ポイントを取得します。
     *
     * @param userId ユーザID
     * @return 所持ポイント
     */
    public MyPointInfo selectMyPoint(@Param("userId") String userId);

    /**
     * ポイント分類一覧を取得します。
     *
     * @return ポイント分類一覧リスト
     */
    public List<PointCategoryInfo> selectPointCategory();

    /**
     * ポイント数を取得します。
     *
     * @param pointCategoryCode ポイント分類コード
     * @return ポイント数
     */
    public BigDecimal selectPointCategoryPoint(@Param("pointCategoryCode") String pointCategoryCode);

    /**
     * 交換予定個数を取得します。
     *
     * @param goodsId 商品ID
     * @param startDate キャンペーン開始日
     * @param endDate キャンペーン終了日
     * @return
     */
    public BigDecimal selectTotalAmountCampaign(
            @Param("goodsId") String goodsId,
            @Param("startDate") String startDate,
            @Param("endDate") String endDate);
}
