package com.almabani.portal.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.almabani.portal.webutils.WebUtils;

@FacesConverter("longConverter")
public class FacesLongConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Long longValue = null;
		try {
			if(!value.equals(""))
				longValue = Long.parseLong(value);
			
		} catch (NumberFormatException nfe) {
			WebUtils.fireErrorMessage("Value: " + value
					+ " contanis invalid data, This field support only numbers");
		}
		return longValue!=null?longValue:value;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		return Long.compare((long) value, 0) == 0 ? null : ((Long) value).toString();
	}

}
