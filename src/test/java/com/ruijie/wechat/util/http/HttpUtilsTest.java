package com.ruijie.wechat.util.http;

import org.junit.Test;

public class HttpUtilsTest {
	@Test
	public void testGet(){
		String url = "https://www.baidu.com";
		String result = HttpUtilsV2.doGet(url);
		System.out.println(result);
		
	}
	
}	
