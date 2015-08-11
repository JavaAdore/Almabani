package com.almabani.common.enums;

public enum EmployeeContractType implements Enumable{

	C("EmployeeContractType_Contract", "C"),
	S("EmployeeContractType_Support", "S");

	private String key;
	private String value;

	private EmployeeContractType(String key, String value) {
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
