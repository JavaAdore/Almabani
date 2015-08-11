package com.almabani.dataaccess.dao.adminoam;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.adminoam.OamProjectItem;
import com.almabani.dataaccess.dao.AbstractDAOInt;
@Repository
public interface ProjectItemDAO extends AbstractDAOInt{

	List<OamProjectItem> getAllProjectItems();

	OamProjectItem getProjectItem(Long projectItemId);

	Integer getCountOfProjectItems(Map<String, Object> filters);

	List<OamProjectItem> loadProjectItems(int first, int pageSize,
			String sortField, boolean ascending, Map<String, Object> filters);

	OamProjectItem persist(OamProjectItem oamProjectItem);

	
	
}
