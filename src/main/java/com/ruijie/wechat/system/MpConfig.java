package com.ruijie.wechat.system;

/**
 * @author R07562
 * 2016年10月20日
 */
public class MpConfig {
	
	private String appid = "";
	
	private String appsecret = "";
	
	private static volatile MpConfig config = null;
	
	private MpConfig(){
	}
	
	public static MpConfig getInstance(){
		if(config == null){
			synchronized (MpConfig.class) {
				config = new MpConfig();
			}
		}
		return config;
	}
	

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAppsecret() {
		return appsecret;
	}

	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}
	
}
