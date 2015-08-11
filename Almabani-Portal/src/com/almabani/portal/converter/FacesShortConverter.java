package com.almabani.portal.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.almabani.portal.webutils.WebUtils;

@FacesConverter("shortConverter")
public class FacesShortConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
    	Short shortValue = null;
		try {
			if(!value.equals(""))
				shortValue = Short.parseShort(value);
			
		} catch (NumberFormatException nfe) {
			WebUtils.fireErrorMessage("Value: " + value
					+ " contanis invalid data, This field support only numbers");
		}
		return shortValue!=null?shortValue:value;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.equals(0) ? null : ((Short) value).toString();
    }
    
}
