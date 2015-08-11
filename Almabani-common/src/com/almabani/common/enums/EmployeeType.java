package com.almabani.common.enums;

public enum EmployeeType implements Enumable{

	E("EmployeeType_EMPLOYEE", "E"),
	T("EmployeeType_TRAINEE", "T"),
	C("EmployeeType_COMMISSION", "C"),
	P("EmployeeType_PART_TIME", "P");

	private String key;
	private String value;

	private EmployeeType(String key, String value) {
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
