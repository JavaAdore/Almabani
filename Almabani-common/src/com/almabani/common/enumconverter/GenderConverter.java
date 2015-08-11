package com.almabani.common.enumconverter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.almabani.common.enums.Gender;

@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<Gender, String> {

	@Override
	public String convertToDatabaseColumn(Gender gender) {
		return gender == null ? null : gender.getValue();
	}
	
	@Override
	public Gender convertToEntityAttribute(String value) {
		Gender gender=null;
		for(Gender _gender : Gender.values()){
			if(_gender.getValue().equals(value)){
				gender = _gender;
			}
		}
		return gender;
	}

}
