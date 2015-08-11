package com.almabani.common.enums;

public enum Active implements Enumable{
	
	Y("Active_YES", "Y"), 
	N("Active_NO", "N");

	private String key;
	private String value;

	private Active(String key, String value) {
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
