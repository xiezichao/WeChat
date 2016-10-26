package com.ruijie.wechat.common.token;

public class AccessTokenFactory {
	
	/**
	 * 获取系统中维护的access token的具体值
	 *
	 * @return 获取access token实例对象 当系统中token为null时，返回null
	 */
	public static AccessToken getAccessToken() {
		return AccessTokenServer.getAccessToken();
	}
	
	/**
	 * 获取系统中维护的access token的具体值
	 *
	 * @return token具体值 当系统中token为null时，返回null
	 */
	public static String getAccessTokenStr(){
		AccessToken accessToken = AccessTokenServer.getAccessToken();
		if(accessToken != null){
			return accessToken.getAccess_token();
		}
		return null;
	}
}
