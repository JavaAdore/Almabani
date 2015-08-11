package com.almabani.common.enumconverter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.almabani.common.enums.MaritalStatus;

@Converter(autoApply = true)
public class MaritalStatusConverter implements AttributeConverter<MaritalStatus, String> {

	@Override
	public String convertToDatabaseColumn(MaritalStatus maritalStatus) {
		return maritalStatus == null ? null : maritalStatus.getValue();
	}
	
	@Override
	public MaritalStatus convertToEntityAttribute(String value) {
		MaritalStatus maritalStatus=null;
		for(MaritalStatus _maritalStatus : MaritalStatus.values()){
			if(_maritalStatus.getValue().equals(value)){
				maritalStatus = _maritalStatus;
			}
		}
		return maritalStatus;
	}

}
