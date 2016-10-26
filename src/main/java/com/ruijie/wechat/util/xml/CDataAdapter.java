package com.ruijie.wechat.util.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CDataAdapter extends XmlAdapter<String, String> {

	/*
	 * xml到bean
	 */
	@Override
	public String unmarshal(String v) throws Exception {
		return v;
	}

	/*
	 * bean到xml
	 */
	@Override
	public String marshal(String v) throws Exception {
		return "<![CDATA[" + v + "]]>";
	}

}
