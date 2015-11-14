package com.almabani.common.enums;

public enum DocumentType implements Enumable {

	N("N", "DocumentType_NATIONAL"), F("F", "DocumentType_FOREIGN");

	private String key;
	private String value;

	private DocumentType(String key, String value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String getKey() {
		return key;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return key + ": " + value;
	}
}
