package com.almabani.common.dto.menu;

import java.io.Serializable;

public class ApplicationAccess implements Serializable{


	
	private static final long serialVersionUID = 1L;
	
	private String url;
	
	private Access access;
	
	private boolean displayInMenu;
	

	public ApplicationAccess(String url, Access access, boolean displayInMenu) {
		super();
		this.url = url;
		this.access = access;
		this.displayInMenu = displayInMenu;
	}

	public ApplicationAccess() {
		super();
	}

	public ApplicationAccess(String url, Access access) {
		super();
		this.url = url;
		this.access = access;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Access getAccess() {
		return access;
	}

	public void setAccess(Access access) {
		this.access = access;
	}

	public boolean isDisplayInMenu() {
		return displayInMenu;
	}

	public void setDisplayInMenu(boolean displayInMenu) {
		this.displayInMenu = displayInMenu;
	} 
	
	
	
	
}
	
	
	

	 
