package com.almabani.portal.converter.adminoam;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.almabani.common.entity.schema.adminoam.ProjectJobTitle;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;

@ManagedBean
@ApplicationScoped
public class ProjectJobTitleConverter extends AbstractBeanHelper implements Converter {

	
	public Object getAsObject(FacesContext facesContext, UIComponent component,
			String value) {
		if (Utils.isEmptyStringOrNotNumericValue(value)) {
			return null;
		} 
		
		return almabaniFacade.getProjectJobTitle(getKey(value));
	}

	

	public String getAsString(FacesContext facesContext, UIComponent component,
			Object object) {
		if (object == null) {
			return null;
		}
		if (object instanceof ProjectJobTitle) {
			ProjectJobTitle o = (ProjectJobTitle) object;
			return getStringKey(o.getId());
		} 
		return null;
	}

}
