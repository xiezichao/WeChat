package com.ruijie.wechat.constants;

public class WeChatConstant {
	
	/**
	 * 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数
	 */
	public final static String Signature = "signature";
	
	/**
	 * 时间戳
	 */
	public final static String Timestamp = "timestamp";
	
	/**
	 * 随机数
	 */
	public final static String Nonce = "nonce";
	
	/**
	 * 	随机字符串
	 */
	public final static String Echostr = "echostr";
	
	/**
	 * 与微信公众号上配置一直，后期可以从配置文件中读取
	 */
	public final static String Token = "XZCtest";
	
	/**
	 * 接口调用凭证 accesstoken
	 */
	public final static String ACCESS_TOKEN = "access_token";
	
	/**
	 * 接口调用凭证accesstoken过期时间
	 */
	public final static String EXPIRES_IN = "expires_in";
	
	/**
	 * 返回错误代码
	 */
	public final static String ERRCODE = "errcode";
	
	/**
	 * 返回错误描述信息
	 */
	public final static String ERRMSG = "errmsg";
	
	/**
	 * 编码
	 */
	public final static String MP_CHARSET = "utf-8";
	
}
