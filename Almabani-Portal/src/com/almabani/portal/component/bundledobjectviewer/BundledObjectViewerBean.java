package com.almabani.portal.component.bundledobjectviewer;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.almabani.common.util.Utils;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@RequestScoped
public class BundledObjectViewerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Map<String, String> bundledObjectToMap(Object obj) {
		if (Utils.isNotNull(obj)) {
			return WebUtils.bundledObjectToMap(obj);
		}
		return new HashMap<String, String>();

	} 

}
