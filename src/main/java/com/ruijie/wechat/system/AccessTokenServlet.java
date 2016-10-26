package com.ruijie.wechat.system;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ruijie.wechat.common.token.AccessTokenFactory;
import com.ruijie.wechat.common.token.AccessTokenServer;

public class AccessTokenServlet extends HttpServlet{
	
	private static Log log = LogFactory.getLog(AccessTokenServlet.class);
	
	private static MpConfig mpConfig = MpConfig.getInstance();

	/**
	 * 
	 */
	private static final long serialVersionUID = 4091603176931599456L;
	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String appid = req.getParameter("appid");
		String appsecret = req.getParameter("appsecret");
		log.info("Receive from front, appid :" + appid + ", appsecret :" + appsecret);
		mpConfig.setAppid(appid);
		mpConfig.setAppsecret(appsecret);
		AccessTokenServer.startRefreshThread();
		log.info("AccessToken starting...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = null; 
		if(AccessTokenFactory.getAccessToken() != null){
			dispatcher = req.getRequestDispatcher("./OK.jsp");
			dispatcher.forward(req, resp);
		} else {
			req.setAttribute("appid", appid);
			req.setAttribute("appsecret", appsecret);
			dispatcher = req.getRequestDispatcher("./FAIL.jsp");
			dispatcher.forward(req, resp);
		}
		
		
		
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp){
		
	}
}
