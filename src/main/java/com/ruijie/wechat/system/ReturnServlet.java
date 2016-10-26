package com.ruijie.wechat.system;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ruijie.wechat.common.token.AccessTokenServer;

public class ReturnServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 695020789916996276L;
	
	private static Log log = LogFactory.getLog(ReturnServlet.class);
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		log.info("stop access token refresh thread and return to the front page ...");
		AccessTokenServer.stopRefreshThread();
		RequestDispatcher dispatcher = req.getRequestDispatcher("./index.jsp");
		dispatcher.forward(req, res);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		doGet(req, res);
	}
}
