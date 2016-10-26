package com.ruijie.wechat.common.api;

import com.ruijie.wechat.common.token.AccessToken;

/**
 * @author R07562 微信公众号相关api
 */
public interface WechatMpApi {

	/**
	 * 获取微信公众号access_token
	 * 
	 * @param url
	 *            url
	 * @param appid
	 *            appid
	 * @param appsecret
	 *            appsecret
	 * @return result {"access_token":"ACCESS_TOKEN","expires_in":7200}
	 *         {"errcode":40013,"errmsg":"invalid appid"}
	 */
	AccessToken getAccessToken(String grantType, String appid, String appsecret);
	
	/**
	 * 获取用户信息接口
	 * @param url
	 * @param accessToken
	 * @return
	 */
	String getUserInfo(String accessToken, String openid, String lang); 

}
