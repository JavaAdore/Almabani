package com.almabani.portal.managedbean.applicationhelper;

import java.util.Date;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.almabani.business.facade.AlmabaniFacade;
import com.almabani.common.util.Utils;
import com.almabani.portal.constant.PortalConstants;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ApplicationScoped
public abstract class AbstractBeanHelper {

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

	public void setApplicationScopeStore(
			ApplicationScopeStore applicationScopeStore) {
		this.applicationScopeStore = applicationScopeStore;
	}

	protected void adjustDateToGreenWich(Map<String, Object> filters) {
		for (String key : filters.keySet()) {
			Object obj = filters.get(key);
			if (obj instanceof Date) {
				Integer deff = (Integer) WebUtils.extractFromSession(PortalConstants.DEFFERENT_HOURS_BETWEEN_USER_TIME_AND_GERENWICH_TIME);
				deff= (deff !=null)?deff:0;
				filters.put(key, Utils.addHours((Date) obj, deff*-1));
				
			}

		}
	}

}
