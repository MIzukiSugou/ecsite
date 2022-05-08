package com.example.ecsite.domain.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecsite.app.form.PointDetailForm;
import com.example.ecsite.domain.model.GoodsInfo;
import com.example.ecsite.domain.model.MyPointInfo;
import com.example.ecsite.domain.model.RecommendationInfo;

import lombok.RequiredArgsConstructor;

/**
 * ポイント詳細画面のServiceクラスです。
 *
 * @author MizukiSugou
 */
@Service
@Transactional
@RequiredArgsConstructor
public class PointDetailService {

    /** 共通処理Service */
    private final CommonService commonService;

    /**
     * 初期処理を行います。
     *
     * @param form ポイント詳細フォーム
     * @param userId ログインユーザID
     */
    public void init(PointDetailForm form, String userId) {

        // ユーザの所持ポイント取得
        MyPointInfo userPoint = commonService.getMyPoint(userId);

        // ユーザの所持ポイントをフォームにセット
        if (userPoint != null) {
            form.setPrevBalancePoint(userPoint.getPrevBalancePoint());
            form.setAcquisitionPoint(userPoint.getAcquisitionPoint());
            form.setExpenditurePoint(userPoint.getExpenditurePoint());
            form.setBalancePoint(userPoint.getBalancePoint());
            form.setExchangeCount(userPoint.getExchangeCount());

        } else {
            form.setPrevBalancePoint(BigDecimal.ZERO);
            form.setAcquisitionPoint(BigDecimal.ZERO);
            form.setExpenditurePoint(BigDecimal.ZERO);
            form.setBalancePoint(BigDecimal.ZERO);
            form.setExchangeCount(BigDecimal.ZERO);
        }

        // おすすめ情報取得
        List<GoodsInfo> goodsList = commonService.getGoodsList(userId, null, null, null);

        if (goodsList == null) {
            // エラーの場合、終了
            return;
        }

        // 交換ポイントが残高ポイントを超える商品を抽出
        List<GoodsInfo> recommendation = new ArrayList<GoodsInfo>();
        for (GoodsInfo goodsInfo : goodsList) {
            if (goodsInfo.getGoodsPoint().compareTo(
                    form.getBalancePoint()) == 1) {
                recommendation.add(goodsInfo);
            }
        }

        // おすすめ情報をフォームにセット
        form.setRecommendationList(new ArrayList<RecommendationInfo>());
        int addCount = 1;
        while (addCount <= recommendation.size() && addCount <= 4) {
            // 4つのおすすめ情報をランダムに選択
            int rnd = (int) (Math.random() * recommendation.size());

            boolean isSet = false;
            for (Iterator<RecommendationInfo> it = form.getRecommendationList().iterator(); it.hasNext();) {
                // すでにフォームに設定済みのおすすめ情報かどうかを判定
                if (it.next().getGoodsId().equals(
                        recommendation.get(rnd).getGoodsId())) {
                    isSet = true;
                    break;
                }
            }
            if (isSet) {
                continue;
            }

            GoodsInfo goodsInfo = recommendation.get(rnd);
            RecommendationInfo recommendationInfo = new RecommendationInfo();
            recommendationInfo.setGoodsId(goodsInfo.getGoodsId());
            recommendationInfo.setGoodsName(goodsInfo.getGoodsName());
            recommendationInfo.setImagePath(goodsInfo.getImagePath());
            recommendationInfo.setGoodsPoint(goodsInfo.getGoodsPoint());

            BigDecimal remainderPoint = recommendationInfo.getGoodsPoint().subtract(form.getBalancePoint());
            recommendationInfo.setRemainderPoint(remainderPoint);

            form.getRecommendationList().add(recommendationInfo);

            addCount++;
        }
    }
}
