package com.ruijie.wechat.reply;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ruijie.wechat.constants.WeChatConstant;
import com.ruijie.wechat.message.MessageType;
import com.ruijie.wechat.message.text.TextRecvMessage;
import com.ruijie.wechat.message.text.TextSendMessage;
import com.ruijie.wechat.util.SHA1;
import com.ruijie.wechat.util.xml.XmlUtil;

public class ServerReplyServlet extends HttpServlet {

	/**
	 * serial version ID
	 */
	private static final long serialVersionUID = -4755273156651842587L;

	private final static Log log = LogFactory.getLog(ServerReplyServlet.class);

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {

		PrintWriter printWriter = null;
		String resString = null;

		String ruijie = "<a href=\"http://www.ruijie.com.cn?openid=%s\">点我点我</a>";

		try {
			// FIXME 修改消息判断方法
			req.setCharacterEncoding(WeChatConstant.MP_CHARSET);
			resp.setCharacterEncoding(WeChatConstant.MP_CHARSET);
			printWriter = resp.getWriter();
			String reqStr = insputStream2String(req.getInputStream());
//			String tempStr = (String) XmlUtil.xml2Bean(reqStr, String.class);
			MessageType temp = (MessageType) XmlUtil.xml2Bean(reqStr, MessageType.class);
			switch (temp.getType()) {
			case IMAGE:
				break;
			case LINK:
				break;
			case LOCATION:
				break;
			case SHORTVIDEO:
				break;
			case TEXT:
				TextSendMessage sendMessage = new TextSendMessage();
				TextRecvMessage message = (TextRecvMessage) XmlUtil.xml2Bean(reqStr,
						TextRecvMessage.class);
				String textContent = message.getContent();
				if (textContent.equals("我要上网")) {
					sendMessage.setContent(String.format(ruijie, message.getFromUserName()));
				} else {
					sendMessage.setContent("暂不持之该输入...");
				}
				sendMessage.setCreateTime((int) new Date().getTime());
				sendMessage.setFromUserName(message.getToUserName());
				sendMessage.setToUserName(message.getFromUserName());
				sendMessage.setMsgType(message.getMsgType());
				resString = XmlUtil.Bean2Xml(sendMessage, TextSendMessage.class);
				break;
			case VIDEO:
				break;
			case VOICE:
				break;
			default:
				break;
			}

		} catch (IOException e) {
			log.error("IOException when get inputStream from request.");
			printWriter.close();
		} catch (JAXBException e) {
			e.printStackTrace();
			printWriter.close();
		} finally {
			printWriter.print(resString);
			printWriter.close();
		}

	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if (validateSignature(req)) {
			log.info("wechat signature check correct.");
			String echostr = req.getParameter(WeChatConstant.Echostr);
			PrintWriter out = resp.getWriter();
			out.write(echostr);
		}
		log.info("wechat signature check error.");
	}

	/**
	 * 验证微信服务器签名 token,timestamp,nonce 字典序排序后进行SHA1 结果与signature比较
	 * 
	 * @param req
	 * @return
	 */
	private boolean validateSignature(HttpServletRequest req) {

		String signature = req.getParameter(WeChatConstant.Signature);
		String token = WeChatConstant.Token;
		String timeStamp = req.getParameter(WeChatConstant.Timestamp);
		String nonce = req.getParameter(WeChatConstant.Nonce);

		String[] lists = new String[] { token, timeStamp, nonce };
		Arrays.sort(lists);
		StringBuilder builder = new StringBuilder();
		for (String string : lists) {
			builder.append(string);
		}
		String strSha = SHA1.digest(builder.toString());
		if (signature.equals(strSha)) {
			return true;
		}
		return false;

	}

	/**
	 *
	 * inputstream -> String
	 * @param ins
	 * @return
	 * @throws IOException
	 */
	private String insputStream2String(InputStream ins) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int i = -1;
		while ((i = ins.read()) != -1) {
			baos.write(i);
		}
		return baos.toString();
	}
}
