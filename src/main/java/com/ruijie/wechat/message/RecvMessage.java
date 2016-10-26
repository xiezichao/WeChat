package com.ruijie.wechat.message;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.ruijie.wechat.util.xml.CDataAdapter;

public class RecvMessage {

	/**
	 * 开发者微信号
	 */
	private String ToUserName;

	/**
	 * 发送方帐号（一个OpenID）
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

	/**
	 * 消息id，64位整型
	 */
	private int MsgId;

	public RecvMessage() {
		super();
	}

	public RecvMessage(String toUserName, String fromUserName, int createTime, String msgType, int msgId) {
		super();
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
		MsgId = msgId;
	}

	public String getToUserName() {
		return ToUserName;
	}

	// @XmlCDATA
	@XmlJavaTypeAdapter(CDataAdapter.class)
	@XmlElement(name = "ToUserName")
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	// @XmlCDATA
	@XmlJavaTypeAdapter(CDataAdapter.class)
	@XmlElement(name = "FromUserName")
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public int getCreateTime() {
		return CreateTime;
	}

	@XmlElement(name = "CreateTime")
	public void setCreateTime(int createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	// @XmlCDATA
	@XmlJavaTypeAdapter(CDataAdapter.class)
	@XmlElement(name = "MsgType")
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public int getMsgId() {
		return MsgId;
	}

	@XmlElement(name = "MsgId")
	public void setMsgId(int msgId) {
		MsgId = msgId;
	}

}
