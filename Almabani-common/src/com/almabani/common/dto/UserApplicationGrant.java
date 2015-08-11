package com.almabani.common.dto;

import java.io.Serializable;

import com.almabani.common.entity.schema.adminsec.SecApplication;
import com.almabani.common.entity.schema.adminsec.SecApplicationGrants;
import com.almabani.common.entity.schema.adminsec.SecApplicationsCompany;
import com.almabani.common.entity.schema.adminsec.SecTypesPerfil;

public class UserApplicationGrant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean granted;

	private SecApplication application;

	private SecTypesPerfil prefilType;

	private SecApplicationsCompany secApplicationCompany;
	
	private String indActive;

	public UserApplicationGrant() {
		super();
	}

	public UserApplicationGrant(SecApplication application,
			SecApplicationsCompany secApplicationCompany ) {
		super();
		this.application = application;
		this.secApplicationCompany = secApplicationCompany;
	}

	public boolean isGranted() {
		return granted;
	}

	public void setGranted(boolean granted) {
		this.granted = granted;
	}

	public SecApplication getApplication() {
		return application;
	}

	public void setApplication(SecApplication application) {
		this.application = application;
	}

	public SecTypesPerfil getPrefilType() {
		return prefilType;
	}

	public void setPrefilType(SecTypesPerfil prefilType) {
		this.prefilType = prefilType;
	}

	public SecApplicationsCompany getSecApplicationCompany() {
		return secApplicationCompany;
	}

	public void setSecApplicationCompany(
			SecApplicationsCompany secApplicationCompany) {
		this.secApplicationCompany = secApplicationCompany;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((application == null) ? 0 : application.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;

		if (obj instanceof UserApplicationGrant) {
			UserApplicationGrant other = (UserApplicationGrant) obj;
			if (application == null) {
				if (other.application != null)
					return false;
			} else if (!application.equals(other.application)) {
				return false;
			} else {
				return true; 
			}
		} else if (obj instanceof SecApplicationGrants) {
			
			SecApplicationsCompany secApplicationsCompany = ((SecApplicationGrants)obj).getApplicationsCompany();
			
			if (secApplicationsCompany == null || secApplicationsCompany.getApplication() == null) {
				return false;
			}
			return application.equals(secApplicationsCompany.getApplication());
		}

		return false;
	}

	public String getIndActive() {
		return indActive;
	}

	public void setIndActive(String indActive) {
		this.indActive = indActive;
	}
}
