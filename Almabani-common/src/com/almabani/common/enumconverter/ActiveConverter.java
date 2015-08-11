package com.almabani.common.enumconverter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.almabani.common.enums.Active;

@Converter(autoApply = true)
public class ActiveConverter implements AttributeConverter<Active, String> {

	@Override
	public String convertToDatabaseColumn(Active active) {
		return active == null ? null : active.getValue();
	}
	
	@Override
	public Active convertToEntityAttribute(String value) {
		Active active = null;
		for(Active _active : Active.values()){
			if(_active.getValue().equals(value)){
				active = _active;
			}
		}
		return active;
	}

}
