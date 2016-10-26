package com.ruijie.wechat.message;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.ruijie.wechat.util.xml.CDataAdapter;

@XmlRootElement(name = "xml")
public class MessageType {

	/**
	 * 消息类型
	 */
	private String msgType;

	public String getMsgType() {

		return msgType;
	}

	// @XmlCDATA
	@XmlJavaTypeAdapter(CDataAdapter.class)
	@XmlElement(name = "MsgType")
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public MsgType getType() {
		if (msgType.equals(MsgType.TEXT.getValue())) {
			return MsgType.TEXT;
		} else if (msgType.equals(MsgType.IMAGE.getValue())) {
			return MsgType.IMAGE;
		} else if (msgType.equals(MsgType.VOICE.getValue())) {
			return MsgType.VOICE;
		} else if (msgType.equals(MsgType.VIDEO.getValue())) {
			return MsgType.VIDEO;
		} else if (msgType.equals(MsgType.SHORTVIDEO.getValue())) {
			return MsgType.SHORTVIDEO;
		} else if (msgType.equals(MsgType.LINK.getValue())) {
			return MsgType.LINK;
		} else {
			return MsgType.LOCATION;
		}
	}
}
