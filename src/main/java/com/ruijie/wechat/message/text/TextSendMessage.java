package com.ruijie.wechat.message.text;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.ruijie.wechat.message.SendMessage;
import com.ruijie.wechat.util.xml.CDataAdapter;

@XmlRootElement(name = "xml")
public class TextSendMessage extends SendMessage {
	
	/**
	 * 文本消息内容
	 */
	private String Content;
	
	public TextSendMessage() {
		super();
	}

	public TextSendMessage(String toUserName, String fromUserName, int createTime, String msgType) {
		super(toUserName, fromUserName, createTime, msgType);
	}

	public TextSendMessage(String content) {
		super();
		Content = content;
	}

	public String getContent() {
		return Content;
	}
	
	@XmlElement(name="Content")
	@XmlJavaTypeAdapter(CDataAdapter.class)
	public void setContent(String content) {
		Content = content;
	}
	
}
