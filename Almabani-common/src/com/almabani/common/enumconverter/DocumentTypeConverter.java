package com.almabani.common.enumconverter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.almabani.common.enums.DocumentType;

@Converter(autoApply = true)
public class DocumentTypeConverter implements AttributeConverter<DocumentType, String> {

	@Override
	public String convertToDatabaseColumn(DocumentType documentType) {
		return documentType == null ? null : documentType.getValue();
	}
	
	@Override
	public DocumentType convertToEntityAttribute(String value) {
		DocumentType documentType = null;
		for(DocumentType _documentType : DocumentType.values()){
			if(_documentType.getValue().equals(value)){
				documentType = _documentType;
			}
		}
		return documentType;
	}

}
