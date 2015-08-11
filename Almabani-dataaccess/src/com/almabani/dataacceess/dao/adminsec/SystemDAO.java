package com.almabani.dataacceess.dao.adminsec;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.adminsec.SecSystem;
import com.almabani.dataaccess.dao.AbstractDAOInt;


  
@Repository
public interface SystemDAO extends AbstractDAOInt{

	Integer getCountOfSystem(Map<String, Object> filters);

	List<SecSystem> loadSystems(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters);

	SecSystem addOrUpdateSystem(SecSystem company);

	SecSystem getSystem(Long id);

	
	List<SecSystem> getAllSystems();
	
}
