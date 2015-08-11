package com.almabani.common.enumconverter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.almabani.common.enums.EmployeeType;

@Converter(autoApply = true)
public class EmployeeTypeConverter implements AttributeConverter<EmployeeType, String> {

	@Override
	public String convertToDatabaseColumn(EmployeeType employeeType) {
		return employeeType == null ? null : employeeType.getValue();
	}
	
	@Override
	public EmployeeType convertToEntityAttribute(String value) {
		EmployeeType employeeType = null;
		for(EmployeeType _employeeType : EmployeeType.values()){
			if(_employeeType.getValue().equals(value)){
				employeeType = _employeeType;
			}
		}
		return employeeType;
	}

}
