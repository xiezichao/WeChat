package com.ruijie.wechat.util.http;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * @author R07562
 * http工具类
 */
public class HttpUtilsV2 {
	
	/**
	 * HTTP响应正常状态码
	 */
	private static final int HTTP_OK = 200;
	
	/**
	 * socket超时时间，http连接最长时长
	 */
	private static final int MAX_TIMEOUT = 9000;
	
	/**
	 * HttpClient配置参数
	 */
	private static RequestConfig requestConfig;
	
	private static String HTTP_CHARSET = "utf-8";
	
	static {
		RequestConfig.Builder builder = RequestConfig.custom();
		builder.setConnectTimeout(MAX_TIMEOUT);
		builder.setSocketTimeout(MAX_TIMEOUT);
		requestConfig = builder.build();
	}
	
	/**
	 * get请求
	 *
	 * @param url
	 * @param params
	 * @return
	 */
	public static String doGet(String url, Map<String, String> params){
		String result = "";
		if(url == null || url == ""){
			return result;
		}
		CloseableHttpClient client = HttpClients.createDefault();
		String getUrl = createGetParams(url,params);
		HttpGet get = new HttpGet(getUrl);
		get.setConfig(requestConfig);
		HttpResponse response = null;
		try {
			response = client.execute(get);
			if(response.getStatusLine().getStatusCode() == HTTP_OK){
				HttpEntity entity = response.getEntity();
				result = EntityUtils.toString(entity,Charset.forName(HTTP_CHARSET));
			} else {
				get.abort();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 *
	 * 根据url地址返回HTTPGet请求结果
	 *
	 * @param url 请求地址
	 * @return  当HTTP请求不成功时返回 ""，当成功时放回请求返回内容。
	 */
	public static String doGet(String url){
		Map<String, String> temp = new HashMap<String, String>();
		return doGet(url, temp);
	}
	
	/**
	 * post请求
	 * @param url url地址
	 * @param params post参数
	 * @return 当HTTP请求不成功时返回 ""，当成功时放回请求返回内容。
	 */
	public static String doPost(String url, Map<String, String> params){
		String result = "";
		if(url == null || url == ""){
			return result;
		}
		List<NameValuePair> postParams = createPostParams(params);
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		post.setEntity(new UrlEncodedFormEntity(postParams,Charset.forName(HTTP_CHARSET)));
		try {
			HttpResponse response = client.execute(post);
			if(response.getStatusLine().getStatusCode() == HTTP_OK){
				HttpEntity entity = response.getEntity();
				result = EntityUtils.toString(entity,Charset.forName(HTTP_CHARSET));
			} else {
				post.abort();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 *
	 * no parameters
	 * @param url url
	 * @return result
	 */
	public static String doPost(String url){
		Map<String, String> temp = new HashMap<String, String>();
		return doPost(url, temp);
	}
	
	/**
	 * @param params get请求参数
	 * @return 参数列表
	 */
	private static String createGetParams(String url, Map<String, String> params){
		StringBuilder res = new StringBuilder(url);
		if(params == null || params.isEmpty()){
			return res.toString();
		}
		res.append("?");
		Set<String> keySets = params.keySet();
		for (String string : keySets) {
			res.append(string);
			res.append("=");
			res.append(params.get(string));
			res.append("&");
		}
		return res.substring(0, res.length()-1);
	}
	
	/**
	 * 组装post参数
	 * @param params map参数
	 * @return post参数列表
	 */
	private static List<NameValuePair> createPostParams(Map<String, String> params){
		List<NameValuePair> result = new ArrayList<NameValuePair>();
		if(params == null || params.isEmpty()){
			return result;
		}
		Set<String> keySets = params.keySet();
		for (String string : keySets) {
			result.add(new BasicNameValuePair(string, params.get(string)));
		}
		return result;
	}
}
