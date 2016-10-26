package com.ruijie.wechat.constants;

/**
 * @author R07562
 * 2016年10月20日
 * 微信公众号返回代码
 */
public class WeChatReturnCode {
	
	/**
	 * 请求成功
	 */
	public static int REQUEST_SUCCESS = 0;
	
	/**
	 * 系统繁忙，此时请开发者稍候再试
	 */
	public static int SYSTEM_BUSY = -1;
	
	/**
	 * 获取access_token时AppSecret错误，或者access_token无效。请开发者认真比对AppSecret的正确性，或查看是否正在为恰当的公众号调用接口
	 */
	public static int TOKEN_OR_APPSECRET_ERROR = 4001;
	
	/**
	 * 不合法的凭证类型
	 */
	public static int ILLEGAL_TOKEN = 40002;
	
	/**
	 * 不合法的OpenID，请开发者确认OpenID（该用户）是否已关注公众号，或是否是其他公众号的OpenID
	 */
	public static int ILLEGAL_OPENID = 40003;
	
	/**
	 * 不合法的access_token，请开发者认真比对access_token的有效性（如是否过期），或查看是否正在为恰当的公众号调用接口
	 */
	public static int ILLEGAL_ACCESS_TOKEN = 40014;
	
	/**
	 * access_token超时，请检查access_token的有效期，请参考基础支持-获取access_token中，对access_token的详细机制说明
	 */
	public static int ACCESSTOKEN_EXPIRE = 42001;
	
	
}
