package com.almabani.common.enumconverter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.almabani.common.enums.EmployeeContractType;

@Converter(autoApply = true)
public class EmployeeContractTypeConverter implements AttributeConverter<EmployeeContractType, String> {

	@Override
	public String convertToDatabaseColumn(EmployeeContractType employeeContractType) {
		return employeeContractType == null ? null : employeeContractType.getValue();
	}
	
	@Override
	public EmployeeContractType convertToEntityAttribute(String value) {
		EmployeeContractType employeeContractType = null;
		for(EmployeeContractType _employeeContractType : EmployeeContractType.values()){
			if(_employeeContractType.getValue().equals(value)){
				employeeContractType = _employeeContractType;
			}
		}
		return employeeContractType;
	}

}
