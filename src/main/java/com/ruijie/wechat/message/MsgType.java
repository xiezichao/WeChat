package com.ruijie.wechat.message;

public enum MsgType {

	TEXT("text"), IMAGE("image"), VOICE("voice"), VIDEO("video"), SHORTVIDEO("shortvideo"), LOCATION("location"), LINK(
			"link");

	private String value;

	private MsgType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
