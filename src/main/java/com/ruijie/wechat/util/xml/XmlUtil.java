package com.ruijie.wechat.util.xml;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import com.ruijie.wechat.message.text.TextRecvMessage;
import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;

public class XmlUtil {

	/**
	 * 由xml字符串转换为bean对象
	 * 
	 * @param <T>
	 * @param xmlStr
	 *            xml字符串
	 * @param beanClass
	 *            bean的class对象
	 * @return bean对象
	 */
	@SuppressWarnings("unchecked")
	public static <T> Object xml2Bean(String xmlStr, Class<T> beanClass) {
		T t = null;
		try {
			JAXBContext context = JAXBContext.newInstance(beanClass);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			// unmarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			// marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			// 去掉xml头部
			// unmarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
			t = (T) unmarshaller.unmarshal(new StringReader(xmlStr));

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return t;
	}

	/**
	 * 由xml字符串转换为bean对象
	 * 
	 * @param <T>
	 * @param xmlStr
	 *            xml字符串
	 * @param beanClass
	 *            bean的class对象
	 * @return bean对象
	 */
	@SuppressWarnings("unchecked")
	public static <T> Object xml2Bean(InputStream xmlIns, Class<T> beanClass) {
		T t = null;
		try {
			JAXBContext context = JAXBContext.newInstance(beanClass);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			// unmarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			// marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			// 去掉xml头部
			// unmarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
			t = (T) unmarshaller.unmarshal(xmlIns);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return t;
	}

	/**
	 * bean对象转换为xml字符串
	 * 
	 * @param <T>
	 * @param obj
	 * @param beanClass
	 * @return xml字符串
	 * @throws JAXBException
	 */
	public static <T> String Bean2Xml(Object obj, Class<T> beanClass) throws JAXBException {

		JAXBContext context = JAXBContext.newInstance(beanClass);
		Marshaller marshaller = context.createMarshaller();

		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		// 去掉xml头部
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

		// FIXME CDATA
		marshaller.setProperty("com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler",
				new CharacterEscapeHandler() {

					public void escape(char[] ch, int start, int length, boolean isAttVal, Writer writer)
							throws IOException {
						writer.write(ch, start, length);
					}
				});

		StringWriter writer = new StringWriter();
		marshaller.marshal(obj, writer);
		return writer.toString();

	}

	@Test
	public void test2() {
		TextRecvMessage message = new TextRecvMessage();
		message.setContent("你好");
		message.setCreateTime(12345678);
		message.setFromUserName("a13613asdfas51df6aasdfadfa");
		message.setToUserName("6841a6sd1f6as1df3as51fda3s");
		message.setMsgId(98765432);
		message.setMsgType("text");
		try {
			System.out.println(XmlUtil.Bean2Xml(message, TextRecvMessage.class));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	// @Test
	// public void testUmmarshaller() {
	// String xmlString =
	// "<xml><URL><![CDATA[http://1efd4836.ngrok.io/WeChatServer/serverReply.do]]></URL><ToUserName><![CDATA[6816516513512]]></ToUserName><FromUserName><![CDATA[1651314861351]]></FromUserName><CreateTime>123456789</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[你好]]></Content><MsgId>123456987</MsgId></xml>";
	// TextRecvMessage message = (TextRecvMessage) xml2Bean(xmlString,
	// TextRecvMessage.class);
	// System.out.println(message.getMsgType());
	// }
}
