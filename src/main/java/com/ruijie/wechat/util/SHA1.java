package com.ruijie.wechat.util;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1 {
	
	/**
	 * SHA secure hash algorithm
	 */
	private static String SHA1 = "SHA-1";
	
	
	
	public static String digest(String message){
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(SHA1);
			md.update(message.getBytes(Charset.forName("UTF-8")));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	   
	    byte[] result = md.digest();
	 
	    StringBuffer sb = new StringBuffer();
	 
	    for (byte b : result) {
	        int i = b & 0xff;
	        if (i < 0xf) {
	            sb.append(0);
	        }
	        sb.append(Integer.toHexString(i));
	    }
	    return sb.toString();
	}
}
