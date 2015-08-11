package com.almabani.common.enums;

public enum Gender implements Enumable{
	
	M("Gender_MALE", "M"), 
	F("Gender_FEMALE", "F");

	private String key;
	private String value;

	private Gender(String key, String value) {
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
