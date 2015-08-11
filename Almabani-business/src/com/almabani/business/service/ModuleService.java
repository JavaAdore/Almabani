package com.almabani.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.adminsec.SecModule;
import com.almabani.common.exception.AlmabaniException;

@Service
public interface ModuleService {

	Integer getCountOfSecModule(Map<String, Object> filters);

	List<SecModule> loadModules(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters);

	SecModule addModule(SecModule SecModule, CommonDriverMap commonDriverMap) throws AlmabaniException;

	SecModule getModule(Long id);

	SecModule updateModule(SecModule SecModule, CommonDriverMap commonDriverMap) throws AlmabaniException;
	
	List<SecModule> getAllModules();


}
