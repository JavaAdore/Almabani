package com.almabani.portal.converter.admincor;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.almabani.common.entity.schema.admincor.State;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;

@ManagedBean
@ApplicationScoped
public class StateConverter extends AbstractBeanHelper implements Converter {

	public Object getAsObject(FacesContext facesContext, UIComponent component,
			String value) {
		if (value == null || value.length() == 0) {
			return null;
		}
		String [] identifiers = value.split("-");


		return almabaniFacade.getState(new Long(identifiers[0]) , identifiers[1]);
	}

	public String getAsString(FacesContext facesContext, UIComponent component,
			Object object) {
		if (object == null ) {
			return null;
		}
		if (object instanceof State) {
			State o = (State) object;   
			if(Utils.isNotNull(o.getStateId().getCountry()) && Utils.isNotNull(o.getStateId().getStateCode())){
			return o.getStateId().getCountry().getId()+"-"+o.getStateId().getStateCode();
			}
		} 
		return null;  
	}

}
