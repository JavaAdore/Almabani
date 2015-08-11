package com.almabani.dataacceess.dao.adminsec;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.adminsec.SecModule;
import com.almabani.common.entity.schema.adminsec.SecSubModule;
import com.almabani.dataaccess.dao.AbstractDAOInt;


  
@Repository
public interface SubModuleDAO extends AbstractDAOInt{

	Integer getCountOfSubModules(Map<String, Object> filters);

	List<SecSubModule> loadSubModules(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters);

	SecSubModule addOrUpdateSubModule(SecSubModule subModule);

	SecSubModule getSubModule(Long id);

	List<SecSubModule> getAllSubModules();

	List<SecSubModule> getSubModules(SecModule module);
	
}
