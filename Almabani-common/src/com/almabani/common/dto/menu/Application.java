package com.almabani.common.dto.menu;

import java.io.Serializable;

import com.almabani.common.constant.DataAccessConstants;
import com.almabani.common.util.Utils;

public class Application implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	private String applicationCode;
	
	private String applicationName;
	
	private String applicationDescription;
	
	private String perfilCode ;
	
	private String url;
	
	public String display;
	

	
	
	
	public String getApplicationCode() {
		return applicationCode;
	}

	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPerfilCode() {
		return perfilCode;
	}

	public void setPerfilCode(String perfilCode) {
		this.perfilCode = perfilCode;
	}

	public String getApplicationDescription() {
		return applicationDescription;
	}

	public void setApplicationDescription(String applicationDescription) {
		this.applicationDescription = applicationDescription;
	}


	

	public boolean isDisplayInMenu() {
		return Utils.isNotEmptyString(display)
				&& display
						.equalsIgnoreCase(DataAccessConstants.IND_ACTIVE);
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	
}
