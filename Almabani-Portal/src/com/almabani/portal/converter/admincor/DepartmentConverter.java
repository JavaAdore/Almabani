package com.almabani.portal.converter.admincor;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;

@ManagedBean
@ApplicationScoped
public class DepartmentConverter extends AbstractBeanHelper implements
		Converter {

	public Object getAsObject(FacesContext facesContext, UIComponent component,
			String value) {
		if (Utils.isEmptyStringOrNotNumericValue(value)) {
			return null; 
		}

		return almabaniFacade.getDepartment(getKey(value));
	}

	public String getAsString(FacesContext facesContext, UIComponent component,
			Object object) {

		if (object == null) {
			return null;
		}
		if (object instanceof Department) {
			Department o = (Department) object;
			return getStringKey(o.getId());
		}
		return null;
	}  

}
