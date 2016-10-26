package com.ruijie.wechat.common.token;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ruijie.wechat.common.api.WeChatMpApiImpl;
import com.ruijie.wechat.system.MpConfig;

public class AccessTokenServer {
	
	private static Log log = LogFactory.getLog(AccessTokenServer.class);
	/**
	 * Member Description
	 */
	private static volatile AccessToken accessToken;

	/**
	 * Member Description
	 */
	public static volatile boolean started = false;

	public static AccessToken getAccessToken() {
		if (accessToken == null) {
			try {
				accessToken = getToken();
			} catch (HttpException e) {
				return null;
			} catch (IOException e) {
				return null;
			}
		}
		if (accessToken != null && !started) {
			startRefreshThread();
		}
		return accessToken;
	}

	public static void refreshAccessToken(AccessToken token) {
		if (token != null) {
			accessToken = token;
		} else {
		}
	}

	public static void stopRefreshThread() {
		log.info("stop refresh access token thread in system ...");
		started = false;
	}

	public static void startRefreshThread() {
		if (started) {
			return;
		}
		started = true;
		// 启动定时更新线程
		new Thread(new AccessTokenRefreshThread()).start();
	}

	public static void refreshAccessToken() {
		try {
			AccessToken token = getToken();
			refreshAccessToken(token);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static AccessToken getToken() throws HttpException, IOException {
		log.info("Get request from Wechat server ...");
		WeChatMpApiImpl apiImpl = new WeChatMpApiImpl();
		return apiImpl.getAccessToken("client_credential", MpConfig.getInstance().getAppid(),
				MpConfig.getInstance().getAppsecret());
	}

	static class AccessTokenRefreshThread implements Runnable {

		public void run() {
			while (started) {
				try {
					if (null != accessToken) {
						Thread.sleep((accessToken.getExpires_in() - 200) * 1000); // 休眠7000秒
					} else {
						Thread.sleep(60 * 1000); // 如果access_token为null，60秒后再获取
					}
				} catch (InterruptedException e) {
					try {
						Thread.sleep(60 * 1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				// 更新Accesstoken
				refreshAccessToken();
				log.info("refresh access token in system ...");
			}

		}

	}
}
