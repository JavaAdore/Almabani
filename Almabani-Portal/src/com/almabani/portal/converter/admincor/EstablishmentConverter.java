package com.almabani.portal.converter.admincor;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.almabani.common.entity.schema.admincor.Establishment;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;

@ManagedBean
@ApplicationScoped
public class EstablishmentConverter extends AbstractBeanHelper implements
		Converter {

	public Object getAsObject(FacesContext facesContext, UIComponent component,
			String value) {
		if (value == null|| value.equals("")) {
			return null;
		}

		return almabaniFacade.getEstablishment(getKey(value));
	}

	public String getAsString(FacesContext facesContext, UIComponent component,
			Object object) {
		if (object == null) {
			return null;
		}
		if (object instanceof Establishment) {
			Establishment o = (Establishment) object;
			return getStringKey(o.getId());

		}
		return null;
	}  

}
