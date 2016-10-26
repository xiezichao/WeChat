package com.ruijie.wechat.message.text;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.ruijie.wechat.message.RecvMessage;
import com.ruijie.wechat.util.xml.CDataAdapter;

@XmlRootElement(name = "xml")
public class TextRecvMessage extends RecvMessage {

	public TextRecvMessage() {
		super();
	}

	public TextRecvMessage(String toUserName, String fromUserName, int createTime, String msgType, int msgId) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
	}

	public TextRecvMessage(String toUserName, String fromUserName, int createTime, String msgType, int msgId,
			String content) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
		this.Content = content;
	}

	/**
	 * 文本消息内容
	 */

	private String Content;

	public String getContent() {
		return Content;
	}

	// @XmlCDATA
	@XmlJavaTypeAdapter(CDataAdapter.class)
	@XmlElement(name = "Content")
	public void setContent(String content) {
		Content = content;
	}
}
