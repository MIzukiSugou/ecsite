package com.example.ecsite.domain.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.example.ecsite.app.config.InputErrorCheck;
import com.example.ecsite.app.form.GoodsDetailForm;
import com.example.ecsite.domain.mapper.GoodsDetailMapper;
import com.example.ecsite.domain.model.GoodsDetailInfo;
import com.example.ecsite.domain.model.MyPointInfo;

import lombok.RequiredArgsConstructor;

/**
 * 商品詳細画面のServiceクラスです。
 *
 * @author MizukiSugou
 */
@Service
@RequiredArgsConstructor
public class GoodsDetailService {

	/** 交換個数未入力エラーメッセージ */
	private static final String ERROR_EMPTY_AMOUNT = "交換する商品の個数を入力してください。";

	/** 交換個数未入力エラーメッセージ */
	private static final String ERROR_NUMBER_AMOUNT = "交換する商品の個数は、半角数値で入力してください。";

	/** 所持ポイント超過エラーメッセージ */
	private static final String ERROR_MAX_POINT = "ポイント残高が足りません。";

	/** 所持ポイント取得エラーメッセージ */
	private static final String ERROR_GET_MY_POINT = "システムエラーが発生しました。システム管理者に連絡してください。";

	/** 商品詳細情報取得エラーメッセージ */
	private static final String ERROR_GET_GOODS_INFO = "商品詳細情報の取得に失敗しました。";

	/** 交換最大数超過エラーメッセージ */
	private static final String ERROR_MAX_EXCHANGE_COUNT = "交換数が大きすぎます。";

	/** 共通処理Service */
	private final CommonService commonService;

	/** 商品詳細画面MyBatisマッパー */
	private final GoodsDetailMapper goodsDetailMapper;

	/**
	 * 商品情報の検索を行います。
	 *
	 * @param form 商品詳細フォーム
	 * @param goodsId 商品ID
	 */
	public void getGoodsInfo(GoodsDetailForm form, String goodsId) {

		// 商品詳細情報の取得
		GoodsDetailInfo goodsDetailInfo = goodsDetailMapper.selectGoodsInfo(goodsId);

		if (goodsDetailInfo != null) {

			form.setGoodsId(goodsId);
			form.setGoodsPoint(goodsDetailInfo.getGoodsPoint());
			form.setGoodsName(goodsDetailInfo.getGoodsName());
			form.setGoodsInfo1(goodsDetailInfo.getGoodsInfo1());
			form.setGoodsInfo2(goodsDetailInfo.getGoodsInfo2());
			form.setImagePath(goodsDetailInfo.getImagePath());
			form.setCategoryName(goodsDetailInfo.getCategoryName());
			if (goodsDetailInfo.getMaxExchangeCount() == null) {
				form.setMaxExchangeCount(new BigDecimal(-1));
			} else {
				form.setMaxExchangeCount(goodsDetailInfo.getMaxExchangeCount());
			}

		} else {
			// 商品詳細情報の取得に失敗した場合
			form.setErrorMessage(ERROR_GET_GOODS_INFO);
		}
	}

	/**
	 * 入力チェック処理を行います。
	 *
	 * @param form 商品詳細フォーム
	 * @param userId ログインユーザID
	 * @return true:入力エラー、false:入力正常
	 */
	public boolean checkInput(GoodsDetailForm form, String userId) {

		// 交換個数
		String exchangeAmount = form.getExchangeAmount();

		if (InputErrorCheck.checkBlankString(exchangeAmount) ||
				"0".equals(exchangeAmount) || "00".equals(exchangeAmount)) {
			// 交換個数が未入力または、0の場合
			form.setErrorMessage(ERROR_EMPTY_AMOUNT);
			return true;
		}

		if (InputErrorCheck.checkNumberString(exchangeAmount)) {
			// 交換個数が半角数字でない場合
			form.setErrorMessage(ERROR_NUMBER_AMOUNT);
			return true;
		}

		if (form.getMaxExchangeCount().compareTo(new BigDecimal(-1)) != 0) {

			BigDecimal totalExchangeCount = BigDecimal.ZERO;
			try {
				// 交換個数合計を算出
				totalExchangeCount = commonService.getTotalExchangeCount(userId, form.getGoodsId());

			} catch (Exception e) {
				// 交換数合計取得エラー
				form.setErrorMessage(ERROR_GET_MY_POINT);
				return true;
			}

			totalExchangeCount = totalExchangeCount.add(new BigDecimal(exchangeAmount));

			if (form.getMaxExchangeCount()
					.compareTo(totalExchangeCount) == -1) {
				// 交換個数合計が交換最大数を超過する場合
				form.setErrorMessage(ERROR_MAX_EXCHANGE_COUNT);
				return true;
			}
		}

		BigDecimal[] campaignInfo = null;
		try {
			// キャンペーン情報取得
			campaignInfo = commonService.getCampaignInfo(form.getGoodsId());

		} catch (Exception e) {
			// キャンペーン情報取得エラー
			form.setErrorMessage(ERROR_GET_MY_POINT);
			return true;
		}

		if (campaignInfo[0] != null) {
			// キャンペーン商品の場合
			campaignInfo[1] = campaignInfo[1].add(new BigDecimal(exchangeAmount));
			if (campaignInfo[0].compareTo(campaignInfo[1]) == -1) {
				// 交換個数が限定個数を超過する場合
				form.setErrorMessage(ERROR_MAX_EXCHANGE_COUNT);
				return true;
			}
		}

		// 所持ポイント取得処理
		if (getMyPoint(form, userId)) {
			// 所持ポイントの取得に失敗した場合
			form.setErrorMessage(ERROR_GET_MY_POINT);
			return true;
		}

		// 交換合計ポイント数
		form.setTotalExchagePoint(
				form.getGoodsPoint().multiply(new BigDecimal(exchangeAmount)));

		// 交換後所持ポイント数
		form.setAfterMyPoint(
				form.getBeforeMyPoint().subtract(form.getTotalExchagePoint()));

		if (form.getAfterMyPoint().compareTo(BigDecimal.ZERO) == -1) {
			// 交換合計ポイント数が所持ポイントを超過する場合
			form.setErrorMessage(ERROR_MAX_POINT);
			return true;
		}

		return false;
	}

	/**
	 * 所持ポイント取得処理を行います。
	 *
	 * @param form 商品詳細フォーム
	 * @param userId ログインユーザID
	 * @return true:取得エラー、false:取得正常
	 */
	private boolean getMyPoint(GoodsDetailForm form, String userId) {

		MyPointInfo myPointInfo = commonService.getMyPoint(userId);

		if (myPointInfo == null || myPointInfo.getBalancePoint() == null) {
			// 所持ポイントの取得に失敗した場合
			return true;
		}

		form.setBeforeMyPoint(myPointInfo.getBalancePoint());
		return false;
	}

	/**
	 * ポイント交換処理を行います。
	 *
	 * @param form 商品詳細フォーム
	 * @param userId ログインユーザID
	 */
    public void exchange(GoodsDetailForm form, String userId) {

		// ポイントマスタの更新
		goodsDetailMapper.updatePointMaster(
				form.getAfterMyPoint().toString(),
				form.getTotalExchagePoint().toString(),
				userId);

		// 交換予定の更新
		goodsDetailMapper.insertExchangePlan(userId,
				form.getGoodsId(),
				form.getExchangeAmount().toString());
	}
}
