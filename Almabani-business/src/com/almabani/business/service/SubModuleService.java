package com.almabani.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.adminsec.SecModule;
import com.almabani.common.entity.schema.adminsec.SecSubModule;
import com.almabani.common.exception.AlmabaniException;

@Service
public interface SubModuleService {

	Integer getCountOfSubModules(Map<String, Object> filters);

	List<SecSubModule> loadSubModules(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters);

	SecSubModule addSubModule(SecSubModule SecSubModule, CommonDriverMap commonDriverMap) throws AlmabaniException;

	SecSubModule getSubModule(Long id);

	SecSubModule updateSubModule(SecSubModule SecSubModule, CommonDriverMap commonDriverMap) throws AlmabaniException;
	
	List<SecSubModule> getAllSubModules();

	List<SecSubModule> getSubModules(SecModule module);


}
