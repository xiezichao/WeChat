package com.ruijie.wechat.common.api;

import com.ruijie.wechat.common.token.AccessToken;
import com.ruijie.wechat.constants.WeChatConstant;
import com.ruijie.wechat.util.http.HttpUtilsV2;

import net.sf.json.JSONObject;

public class WeChatMpApiImpl implements WechatMpApi {

	/**
	 * 获取access_token地址，其中三个参数%s需要进行替换传参
	 */
	private static String ACCESSTOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=%s&appid=%s&secret=%s";

	
	public AccessToken getAccessToken(String grantType, String appid, String appsecret) {
		if (appid == null || appsecret == null) {
			return null;
		}
		AccessToken res = new AccessToken();
		String urlStr = String.format(ACCESSTOKEN, grantType, appid, appsecret);
		String httpStr = HttpUtilsV2.doGet(urlStr);
		if(httpStr != ""){
			JSONObject httpJson = JSONObject.fromObject(httpStr);
			if(!httpJson.isNullObject()){
				if(httpJson.containsKey(WeChatConstant.ERRCODE)){
					//FIXME throws exception
				} else {
					res.setAccess_token(httpJson.getString(WeChatConstant.ACCESS_TOKEN));
					res.setExpires_in(httpJson.getInt(WeChatConstant.EXPIRES_IN));
				}
			}
		}
		return res;
	}

	public String getUserInfo(String accessToken, String openid, String lang) {
		//FIXME get userinfo
		return null;
	}

}
