package com.almabani.common.dto.menu;

import java.io.Serializable;
import java.util.List;

public class SubModule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String subModuleName;
	
	private List<Application> applications;

	

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public String getSubModuleName() {
		return subModuleName;
	}

	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}
	
	
	
}
