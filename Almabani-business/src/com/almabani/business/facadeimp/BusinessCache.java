package com.almabani.business.facadeimp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.almabani.common.util.Utils;

@Service
@Scope("singleton")
public class BusinessCache implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<String,String> applicationsDescriptions = new HashMap<String,String>();
	
	
	
	public void addApplicationDescription(String applicationCode , String description)
	{
		applicationsDescriptions.put(applicationCode, description);
	}
	
	
	public String getApplicationDescription(String applicationCode)
	{
		String applicationDescription  = applicationsDescriptions.get(applicationCode);
		return Utils.getAbsoluteStringValue(applicationDescription);
	}
	
	
	
	public Map<String, String> getApplicationsDescriptions() {
		return applicationsDescriptions;
	}
	public void setApplicationsDescriptions(
			Map<String, String> applicationsDescriptions) {
		this.applicationsDescriptions = applicationsDescriptions;
	}
	

}
