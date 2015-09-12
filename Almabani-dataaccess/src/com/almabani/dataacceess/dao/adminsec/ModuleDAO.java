package com.almabani.dataacceess.dao.adminsec;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminsec.SecModule;
import com.almabani.dataaccess.dao.AbstractDAOInt;


  
@Repository
public interface ModuleDAO extends AbstractDAOInt{

	Integer getCountOfModule(Map<String, Object> filters);

	List<SecModule> loadModules(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters);

	SecModule addOrUpdateModule(SecModule company);

	SecModule getModule(Long id);

	
	List<SecModule> getAllModules();

	List<SecModule> getAllModules(Company company);
	
}
