package com.ruijie.wechat.message;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.ruijie.wechat.util.xml.CDataAdapter;

public class SendMessage {

	/**
	 * 接收方帐号（收到的OpenID）
	 */
	private String ToUserName;
	
	/**
	 * 开发者微信号
	 */
	private String FromUserName;
	
	/**
	 * 消息创建时间 （整型）

	 */
	private int CreateTime;
	
	/**
	 * 消息类型
	 */
	private String MsgType;
	
	

	public SendMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SendMessage(String toUserName, String fromUserName, int createTime, String msgType) {
		super();
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
	}

	public String getToUserName() {
		return ToUserName;
	}
	
	@XmlElement(name="ToUserName")
	@XmlJavaTypeAdapter(CDataAdapter.class)
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	@XmlElement(name="FromUserName")
	@XmlJavaTypeAdapter(CDataAdapter.class)
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public int getCreateTime() {
		return CreateTime;
	}

	@XmlElement(name="CreateTime")
	public void setCreateTime(int createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	@XmlElement(name="MsgType")
	@XmlJavaTypeAdapter(CDataAdapter.class)
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	
	
}
