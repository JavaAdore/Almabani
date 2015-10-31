package com.almabani.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminwkf.WokOccurrenceType;

@Service
public interface WokOccurencyTypeService {

	List<WokOccurrenceType> getWokOccurrenceTypeList(Company company);

	Object getOperatorsParamValue(Company company);

	Object getTechniciansParamValue(Company company);

	Object getCommuincatorsParamValue(Company company);

	Object getSafetyAgentsParamValue(Company company);

	WokOccurrenceType getOccurenceType(Long id);

	


	
}
