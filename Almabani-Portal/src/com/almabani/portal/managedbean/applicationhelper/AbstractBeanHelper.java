package com.almabani.portal.managedbean.applicationhelper;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.almabani.business.facade.AlmabaniFacade;

@ManagedBean
@ApplicationScoped
public abstract class AbstractBeanHelper  {

	@ManagedProperty(value = "#{almabaniFacadeImp}")
	protected AlmabaniFacade almabaniFacade;
	
	
	@ManagedProperty(value = "#{applicationScopeStore}")
	private ApplicationScopeStore applicationScopeStore;
	

	public AlmabaniFacade getAlmabaniFacade() {
		return almabaniFacade;
	}

	public void setAlmabaniFacade(AlmabaniFacade almabaniFacade) {
		this.almabaniFacade = almabaniFacade;
	}

	
	protected String getStringKey(java.lang.Long value) {
		StringBuffer sb = new StringBuffer();
		sb.append(value);
		return sb.toString();
	}
	
	protected java.lang.Long getKey(String value) {
		java.lang.Long key;
		key = Long.valueOf(value);
		return key;
	}

	public ApplicationScopeStore getApplicationScopeStore() {
		return applicationScopeStore;
	}

	public void setApplicationScopeStore(ApplicationScopeStore applicationScopeStore) {
		this.applicationScopeStore = applicationScopeStore;
	}
	
	
	
}
