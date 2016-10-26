package com.ruijie.wechat.common.token;

/**
 * @author R07562 access_token是公众号的全局唯一票据，公众号调用各接口时都需使用access_token。开发者需要进行妥善保存。
 *         access_token的存储至少要保留512个字符空间。access_token的有效期目前为2个小时，需定时刷新，
 *         重复获取将导致上次获取的access_token失效。
 * 
 *         公众平台的API调用所需的access_token的使用及生成方式说明：
 * 
 *         1、为了保密appsecrect，第三方需要一个access_token获取和刷新的中控服务器。
 *         而其他业务逻辑服务器所使用的access_token均来自于该中控服务器，不应该各自去刷新，
 *         否则会造成access_token覆盖而影响业务；
 *         2、目前access_token的有效期通过返回的expire_in来传达，目前是7200秒之内的值。
 *         中控服务器需要根据这个有效时间提前去刷新新access_token。在刷新过程中，中控服务器对外输出的依然是老access_token，
 *         此时公众平台后台会保证在刷新短时间内，新老access_token都可用，这保证了第三方业务的平滑过渡；
 *         3、access_token的有效时间可能会在未来有调整，所以中控服务器不仅需要内部定时主动刷新，
 *         还需要提供被动刷新access_token的接口，这样便于业务服务器在API调用获知access_token已超时的情况下，
 *         可以触发access_token的刷新流程。
 *         如果第三方不使用中控服务器，而是选择各个业务逻辑点各自去刷新access_token，那么就可能会产生冲突，导致服务不稳定。
 * 
 *         公众号可以使用AppID和AppSecret调用本接口来获取access_token。AppID和AppSecret可在微信公众平台官网-
 *         开发者中心页中获得（需要已经成为开发者，且帐号没有异常状态）。注意调用所有微信接口时均需使用https协议。
 * 
 *         接口调用请求说明
 * 
 *         http请求方式: GET
 *         https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&
 *         appid=APPID&secret=APPSECRET 参数说明
 * 
 *         参数 是否必须 说明 grant_type 是 获取access_token填写client_credential appid 是
 *         第三方用户唯一凭证 secret 是 第三方用户唯一凭证密钥，即appsecret 返回说明
 * 
 *         正常情况下，微信会返回下述JSON数据包给公众号：
 * 
 *         {"access_token":"ACCESS_TOKEN","expires_in":7200} 参数 说明 access_token
 *         获取到的凭证 expires_in 凭证有效时间，单位：秒
 * 
 *         错误时微信会返回错误码等信息，JSON数据包示例如下（该示例为AppID无效错误）:
 * 
 *         {"errcode":40013,"errmsg":"invalid appid"}
 * 
 */
public class AccessToken {

	/**
	 * 获取到的凭证
	 */
	private String access_token = null;

	/**
	 * 凭证有效时间，单位：秒
	 */
	private int expires_in = 0;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

}
