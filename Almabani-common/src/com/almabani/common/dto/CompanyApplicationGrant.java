package com.almabani.common.dto;

import com.almabani.common.entity.schema.adminsec.SecApplication;

public class CompanyApplicationGrant {
	
	
	private String indActive ="Y";
	
	private SecApplication application;
	
	private boolean granted;

	public String getIndActive() {
		return indActive;
	}

	public void setIndActive(String indActive) {
		this.indActive = indActive;
	}

	public SecApplication getApplication() {
		return application;
	}

	public void setApplication(SecApplication application) {
		this.application = application;
	}

	public boolean isGranted() {
		return granted;
	}

	public void setGranted(boolean granted) {
		this.granted = granted;
	}
	
	
	

}
