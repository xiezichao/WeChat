package com.ruijie.wechat.util.http;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class HttpUtils {
	public static String post(String url, String json) throws HttpException,IOException{
        String responseBody = null;

        // 1.创建Httpclient实例
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(url);
        // 2.初始化调用参数


        if (!json.isEmpty()) {
                RequestEntity requestEntity = new StringRequestEntity(json,"text/xml","UTF-8");
                postMethod.setRequestEntity(requestEntity);
        }

        // 3.设置成了默认的恢复策略，在发生异常时候将自动重试3次，在这里你也可以设置成自定义的恢复策略
        postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler());
        try {
            // 4.执行http请求
            int statusCode = httpClient.executeMethod(postMethod);

            if (statusCode != HttpStatus.SC_OK) {
                return null;
            }
            // 5.获取响应
            responseBody = postMethod.getResponseBodyAsString();
        } catch (HttpException e) {
            // 网络异常
            System.out.println("Please check your provided http address!");
            throw e;
        } catch (IOException e) {
            throw e;
        } finally {
            // 6.释放连接
            postMethod.releaseConnection();
        }
        return responseBody;
    }
    
	/**
	 * Post.
	 *
	 * @param url the url
	 * @return the byte
	 * @throws IOException 
	 * @throws HttpException 
	 */
	public static String post(String url) throws HttpException, IOException{
		return post(url,"");
	}

	/**
	 * Post.
	 *
	 * @param url the url
	 * @param params the params
	 * @return the byte[]
	 */
	public static String post(String url, Map<String,String> params) {
		return null;
	}

	/**
	 * Gets the.
	 *
	 * @param url the url
	 * @return the byte[]
	 */
	public static String get(String url) throws HttpException,IOException {
		return get(url, null);
	}

	/**
	 * Gets the.
	 *
	 * @param url the url
	 * @param params the params
	 * @return the byte[]
	 */
	public static String get(String url, Map<String, String> params) throws HttpException,IOException {
		String responseBody = null;

		// 1.创建Httpclient实例
		HttpClient httpClient = new HttpClient();
		GetMethod getMethod = new GetMethod(url);
		// 2.初始化调用参数
		if (params != null && params.size() > 0) {
			NameValuePair[] pairArr = generateNameValuePair(params);
			getMethod.setQueryString(pairArr);
		}
		// 3.设置成了默认的恢复策略，在发生异常时候将自动重试3次，在这里你也可以设置成自定义的恢复策略
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());
		try {
			// 4.执行http请求
			int statusCode = httpClient.executeMethod(getMethod);

			if (statusCode != HttpStatus.SC_OK) {
				return null;
			}
			// 5.获取响应
			responseBody = getMethod.getResponseBodyAsString();
		} catch (HttpException e) {
			// 网络异常
			System.out.println("Please check your provided http address!");
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			// 6.释放连接
			getMethod.releaseConnection();
		}
		return responseBody;
	}


	/**
	 * Generate name value pair.
	 *
	 * @param params the params
	 * @return the name value pair[]
	 */
	private static NameValuePair[] generateNameValuePair(
			Map<String, String> params) {
		NameValuePair[] pairArr = new NameValuePair[params.size()];
		int index = 0;
		for (Map.Entry<String, String> entry : params.entrySet()) {
			pairArr[index++] = new NameValuePair(entry.getKey(),
					entry.getValue());
		}
		return pairArr;
	}
}
