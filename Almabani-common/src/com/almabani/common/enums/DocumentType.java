package com.almabani.common.enums;

public enum DocumentType implements Enumable{

	N("DocumentType_NATIONAL", "N"),
	F("DocumentType_FOREIGN", "F");

	private String key;
	private String value;

	private DocumentType(String key, String value) {
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
