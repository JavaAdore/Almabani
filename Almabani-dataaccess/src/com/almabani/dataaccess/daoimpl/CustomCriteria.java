package com.almabani.dataaccess.daoimpl;

import java.io.Serializable;

public class CustomCriteria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String criteria;
	
	
	
	public CustomCriteria()
	{
		
	}
	public CustomCriteria(String criteria) {
		super();
		this.criteria = criteria;
	}

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

}
