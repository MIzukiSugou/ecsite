package com.example.ecsite.domain.mapper;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.ecsite.domain.model.UserInfo;

/**
 * ログイン画面のMyBatisマッパークラスです。
 *
 * @author MizukiSugou
 */
@Mapper
public interface LoginMapper {

    /**
     * ログインID/パスワードの存在をチェックします。
     *
     * @param userId ユーザID
     * @param password パスワード
     * @return レコード数
     */
    public BigDecimal checkLogin(@Param("userId") String userId, @Param("password") String password);

    /**
     * ユーザ情報を取得します。
     *
     * @param userId ユーザID
     * @return ユーザ情報
     */
    public UserInfo selectUser(@Param("userId") String userId);

    /**
     * ログイン情報を更新します。(失敗時)
     *
     * @param userId ユーザID
     */
    public void updateLoginFailure(@Param("userId") String userId);

    /**
     * ログイン情報を更新します。(成功時)
     *
     * @param userId ユーザID
     */
    public void updateLoginSuccess(@Param("userId") String userId);
}
