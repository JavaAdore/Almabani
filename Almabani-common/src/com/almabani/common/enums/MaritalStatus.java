package com.almabani.common.enums;

public enum MaritalStatus implements Enumable{

	I("MaritalStatus_SINGLE", "I"),
	E("MaritalStatus_ENGAGED", "E"),
	M("MaritalStatus_MARRIED", "M"),
	S("MaritalStatus_SEPARATED", "S"),
	D("MaritalStatus_DIVORCED", "D"),
	W("MaritalStatus_WIDOWED", "W"),
	O("MaritalStatus_OTHERS", "O");

	private String key;
	private String value;

	private MaritalStatus(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	@Override
	public String getKey(){
		return key;
	}
	
	@Override
	public String getValue(){
		return value;
	}

	@Override
	public String toString() {
		return key + ": " + value;
	}
}
