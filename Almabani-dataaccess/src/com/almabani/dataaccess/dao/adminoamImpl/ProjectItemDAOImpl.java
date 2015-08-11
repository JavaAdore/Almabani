package com.almabani.dataaccess.dao.adminoamImpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.adminoam.OamProjectItem;
import com.almabani.dataaccess.dao.adminoam.ProjectItemDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class ProjectItemDAOImpl extends AbstractDAO implements ProjectItemDAO {
	
	private static final long serialVersionUID = 1L;

	@Override
	public List<OamProjectItem> getAllProjectItems() {
		return super.getAllEntities(OamProjectItem.class);
	}

	@Override
	public OamProjectItem getProjectItem(Long projectItemId) {
		return (OamProjectItem) super.getEntity(OamProjectItem.class	, projectItemId);
	}

	@Override
	public Integer getCountOfProjectItems(Map<String, Object> filters) {
		return super.getCountOfResults(OamProjectItem.class, filters);
	}

	@Override
	public List<OamProjectItem> loadProjectItems(int first, int pageSize,
			String sortField, boolean ascending, Map<String, Object> filters) {
		return super.lazyLoadEntities(OamProjectItem.class, first, pageSize, sortField, ascending, filters);
	}

	@Override
	public OamProjectItem persist(OamProjectItem oamProjectItem) {
		return (OamProjectItem) super.persist(oamProjectItem);
	}
	
	


}
