package com.almabani.portal.converter.adminoam;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;

@ManagedBean
@ApplicationScoped
public class QuotationConverter extends AbstractBeanHelper implements Converter {

	
	public Object getAsObject(FacesContext facesContext, UIComponent component,
			String value) {
		if (Utils.isEmptyStringOrNotNumericValue(value)) {
			return null;
		} 
		
		return almabaniFacade.getQuotataion(getKey(value));
	}

	

	public String getAsString(FacesContext facesContext, UIComponent component,
			Object object) {
		if (object == null) {
			return null;
		}
		if (object instanceof OamQuotation) {
			OamQuotation o = (OamQuotation) object;
			return getStringKey(o.getId());
		} 
		return null;
	}

}
