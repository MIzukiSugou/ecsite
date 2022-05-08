package com.example.ecsite.domain.service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecsite.app.config.CommonConst;
import com.example.ecsite.domain.mapper.CommonMapper;
import com.example.ecsite.domain.model.CampaignInfo;
import com.example.ecsite.domain.model.GenreInfo;
import com.example.ecsite.domain.model.GoodsInfo;
import com.example.ecsite.domain.model.MyPointInfo;
import com.example.ecsite.domain.model.PointCategoryInfo;

import lombok.RequiredArgsConstructor;

/**
 * 共通処理のServiceクラスです。
 *
 * @author MizukiSugou
 */
@Service
@Transactional
@RequiredArgsConstructor
public class CommonService {

    /** 共通MyBatisマッパー */
    private final CommonMapper commonMapper;

    /**
     * ジャンル一覧を取得します。
     *
     * @param session セッション情報
     * @return ジャンル一覧
     */
    @SuppressWarnings("unchecked")
    public List<GenreInfo> getGenreList(HttpSession session) {

        if (session.getAttribute(CommonConst.GET_GENRE_LIST) != null) {
            // セッションに格納済みの場合は、そのジャンル一覧を返却
            return (List<GenreInfo>) session.getAttribute(CommonConst.GET_GENRE_LIST);
        }

        // ジャンル一覧を取得
        List<GenreInfo> genreList = commonMapper.selectGenre();

        // ジャンル一覧をセッションに格納
        session.setAttribute(CommonConst.GET_GENRE_LIST, genreList);

        return genreList;
    }

    /**
     * ポイント分類一覧を取得します。
     *
     * @param session セッション情報
     * @return ポイント分類一覧
     */
    @SuppressWarnings("unchecked")
    public List<PointCategoryInfo> getPointCategoryList(HttpSession session) {

        if (session.getAttribute(CommonConst.GET_POINT_CATEGORY_LIST) != null) {
            // セッションに格納済みの場合は、そのジャンル一覧を返却
            return (List<PointCategoryInfo>) session.getAttribute(CommonConst.GET_POINT_CATEGORY_LIST);
        }

        // ポイント分類一覧を取得
        List<PointCategoryInfo> pointCategoryList = commonMapper.selectPointCategory();

        // ポイント分類一覧をセッションに格納
        session.setAttribute(CommonConst.GET_POINT_CATEGORY_LIST, pointCategoryList);

        return pointCategoryList;
    }

    /**
     * セッションタイムアウトのチェックを行います。
     *
     * @param session セッション情報
     * @return true:セッションタイムアウト false:セッション正常
     */
    public boolean checkSessionTimeOut(HttpSession session) {

        if (session == null ||
                session.getAttribute(CommonConst.LOGIN_USER_INFO) == null) {
            return true;
        }

        return false;
    }

    /**
     * 指定のユーザが参照可能な商品一覧を取得します。
     *
     * @param userId ユーザID（必須入力）
     * @param goodsId 商品ID（nullの場合、全商品を検索）
     * @param pointCategoryCode ポイント分類コード（nullの場合、全商品を検索）
     * @param goodsCategory 分類コード（nullの場合、全商品を検索）
     * @return 商品一覧(エラーの場合はnullを返却)
     */
    public List<GoodsInfo> getGoodsList(String userId, String goodsId,
            String pointCategoryCode, String goodsCategory) {
//
//        // 検索パラメータ
//        String searchGoodsId = null;
////        String searchGoodsId = "%";
//        if (goodsId != null) {
//            searchGoodsId = goodsId;
//        }
//        
//        String searchPoint = null;
////        String searchPoint = "0";
//        if (pointCategoryCode != null) {
//        	searchPoint = getPointAmount(pointCategoryCode);
//        }
//
//        String searchGoodsCategory = null;
////        String searchGoodsCategory = "%";
//        if (goodsCategory != null) {
//        	searchGoodsCategory = goodsCategory;
//        }
    	
    	String searchPoint = getPointAmount(pointCategoryCode);
    	String searchGoodsId =goodsId;
    	String searchGoodsCategory =goodsCategory;
    	
        // 商品情報取得
        List<GoodsInfo> goodsInfoList = commonMapper.selectGoodsInfo(
                userId, searchGoodsId, searchPoint, searchGoodsCategory);

        // 交換最大数判定
        List<GoodsInfo> workGoodsData1 = checkMaxExchange(userId, goodsInfoList);
        if (workGoodsData1 == null) {
            return null;
        }

        // 未公開商品の精査
        List<GoodsInfo> workGoodsData2 = checkGoodsPlan(workGoodsData1);
        if (workGoodsData2 == null) {
            return null;
        }

        // キャンペーン判定
        List<GoodsInfo> goodsList = checkCampaign(workGoodsData2);

        return goodsList;
    }

    /**
     * ポイント分類コードに該当するポイント数を取得します。
     *
     * @param pointCategoryCode ポイント分類コード
     * @return ポイント数
     */
    private String getPointAmount(String pointCategoryCode) {

        // ポイント分類コードに紐づくポイント数を取得
        BigDecimal searchPoint = commonMapper.selectPointCategoryPoint(pointCategoryCode);
        if (searchPoint == null) {
            // エラーが発生した場合
            return null;
        }

        return searchPoint.toString();
    }

    /**
     * 指定の商品リストから交換最大数を超過した商品を除外して返します。
     *
     * @param userId ログインユーザID
     * @param goodsInfoList 検査対象の商品リスト
     * @return 有効な商品リスト(エラーの場合はnullを返却)
     */
    private List<GoodsInfo> checkMaxExchange(String userId, List<GoodsInfo> goodsInfoList) {

        List<GoodsInfo> result = new ArrayList<GoodsInfo>();

        for (GoodsInfo goodsInfo : goodsInfoList) {

            BigDecimal exchangeTotal = commonMapper.selectExchangeTotalUser(goodsInfo.getGoodsId(), userId);
            if (exchangeTotal == null) {
                // エラーが発生した場合
                return null;
            }

            if (goodsInfo.getMaxExchangeCount() != null) {

                if ((exchangeTotal).compareTo(goodsInfo.getMaxExchangeCount()) == -1) {
                    // ユーザの交換予定個数、交換確定個数が、交換最大数を下回る場合
                    result.add(goodsInfo);
                }

            } else {
                // 交換最大数が未設定の商品
                result.add(goodsInfo);
            }
        }

        return result;
    }

    /**
     * 指定の商品リストから未公開商品を除去して返します。
     *
     * @param goodsList 検査対象の商品リスト
     * @return 有効な商品リスト(エラーの場合はnullを返却)
     */
    private List<GoodsInfo> checkGoodsPlan(List<GoodsInfo> goodsList) {

        List<GoodsInfo> result = new ArrayList<GoodsInfo>();

        for (GoodsInfo goodsInfo : goodsList) {

            BigDecimal goodsPlanCount = commonMapper.selectGoodsPlan(goodsInfo.getGoodsId());
            if (goodsPlanCount == null) {
                // エラーが発生した場合
                return null;
            }

            if ((goodsPlanCount).compareTo(BigDecimal.ZERO) == 0) {
                // 未公開商品でない場合
                result.add(goodsInfo);
            }
        }

        return result;
    }

    /**
     * 指定の商品をキャンペーン情報を突合して、有効な商品のみ抽出します。
     *
     * @param goodsList 検査対象の商品リスト
     * @return 有効な商品リスト
     */
    private List<GoodsInfo> checkCampaign(List<GoodsInfo> goodsList) {

        List<GoodsInfo> result = new ArrayList<GoodsInfo>();

        for (GoodsInfo goodsInfo : goodsList) {

            List<CampaignInfo> campaignInfoList = commonMapper.selectCampaign(goodsInfo.getGoodsId());

            if (campaignInfoList.size() > 0) {
                // キャンペーン商品の場合

                for (CampaignInfo campaignInfo : campaignInfoList) {
                    Date startDate = campaignInfo.getCampaignStartDate();
                    Date endDate = campaignInfo.getCampaignEndDate();
                    Date currentDate = new Date();

                    if (currentDate.compareTo(startDate) > 0 && currentDate.compareTo(endDate) < 0) {
                        // キャンペーン期間の場合

                        if (campaignInfo.getLimitCount() == null) {
                            // 限定個数が無い場合
                            result.add(goodsInfo);

                        } else {
                            // 限定個数をチェック
                            DateFormat df = new SimpleDateFormat("yyyyMMdd");

                            BigDecimal totalAmountCampaign = commonMapper.selectTotalAmountCampaign(
                                    goodsInfo.getGoodsId(), df.format(startDate), df.format(endDate));

                            if (totalAmountCampaign != null) {

                                if ((totalAmountCampaign).compareTo(campaignInfo.getLimitCount()) < 0) {
                                    // 交換数が、限定個数を下回る場合
                                    result.add(goodsInfo);
                                }

                            } else {
                                // 未交換の場合
                                result.add(goodsInfo);
                            }
                        }
                    }
                }

            } else {
                // キャンペーン商品でない場合
                result.add(goodsInfo);
            }
        }

        return result;
    }

    /**
     * ユーザの所持ポイントを取得します。
     *
     * @param userId ログインユーザID
     * @return ユーザの所持ポイント
     */
    public MyPointInfo getMyPoint(String userId) {

        MyPointInfo myPointInfo = commonMapper.selectMyPoint(userId);
        if (myPointInfo == null) {
            return null;
        }

        return myPointInfo;
    }

    /**
     * ユーザが交換した商品の総数を返します。
     *
     * @param userId ログインユーザID
     * @param goodsId 商品ID
     * @return ユーザが交換した商品の総数
     */
    public BigDecimal getTotalExchangeCount(String userId, String goodsId) {

        BigDecimal totalExchangeCount = commonMapper.selectExchangeTotalUser(goodsId, userId);
        if (totalExchangeCount == null) {
            return BigDecimal.ZERO;
        }

        return totalExchangeCount;
    }

    /**
     * 指定の商品をキャンペーン情報を突合して、限定個数とこれまでの交換個数合計を返します。
     *
     * @param goodsId 商品ID
     * @return [0]:限定個数、[1]:交換個数合計(キャンペーン商品でない場合は限定個数がnull)
     */
    public BigDecimal[] getCampaignInfo(String goodsId) {

        // キャンペーン情報の有無を確認
        List<CampaignInfo> campaignInfoList = commonMapper.selectCampaign(goodsId);

        BigDecimal[] result = new BigDecimal[2];

        if (campaignInfoList.size() > 0) {
            // キャンペーン商品の場合

            for (CampaignInfo campaignInfo : campaignInfoList) {
                Date startDate = campaignInfo.getCampaignStartDate();
                Date endDate = campaignInfo.getCampaignEndDate();
                Date currentDate = new Date();

                if (currentDate.compareTo(startDate) > 0 && currentDate.compareTo(endDate) < 0) {
                    // キャンペーン期間の場合

                    if (campaignInfo.getLimitCount() != null) {
                        // 限定個数をチェック
                        DateFormat df = new SimpleDateFormat("yyyyMMdd");

                        BigDecimal totalAmountCampaign = commonMapper.selectTotalAmountCampaign(
                                goodsId, df.format(startDate), df.format(endDate));

                        if (totalAmountCampaign != null) {

                            result[0] = campaignInfo.getLimitCount();
                            result[1] = totalAmountCampaign;

                        } else {
                            // 未交換の場合
                            result[0] = campaignInfo.getLimitCount();
                            result[1] = BigDecimal.ZERO;
                        }
                    }
                }
            }
        }

        return result;
    }
}
