package com.almabani.portal.converter.adminwkf;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.almabani.common.entity.schema.adminwkf.WokDemand;
import com.almabani.common.entity.schema.adminwkf.WokOccurrenceType;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Occurs;

@ManagedBean
@ApplicationScoped
public class WokOccurenceTypeConverter extends AbstractBeanHelper implements Converter {

	
	public Object getAsObject(FacesContext facesContext, UIComponent component,
			String value) {
		if (Utils.isEmptyStringOrNotNumericValue(value)) {
			return null;
		}
		  
		return almabaniFacade.getOccurenceType(getKey(value));
	}

	

	public String getAsString(FacesContext facesContext, UIComponent component,
			Object object) {
		if (object == null) {
			return null;
		}
		if (object instanceof WokOccurrenceType) {
			WokOccurrenceType o = (WokOccurrenceType) object;
			return getStringKey(o.getId());
		} 
		return null;
	}

}
