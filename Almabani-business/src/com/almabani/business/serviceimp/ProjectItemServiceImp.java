package com.almabani.business.serviceimp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.ProjectItemService;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.common.entity.schema.adminoam.OamProjectItem;
import com.almabani.common.util.Utils;
import com.almabani.dataaccess.dao.adminoam.ProjectItemDAO;

@Service
public class ProjectItemServiceImp implements ProjectItemService {

	@Autowired
	private ProjectItemDAO projectItemDAO;

	@Override
	public Integer getCountOfProjectItems(Map<String, Object> filters) {
		return projectItemDAO.getCountOfProjectItems(filters);
	}

	@Override
	public List<OamProjectItem> loadProjectItems(int first, int pageSize,
			String sortField, boolean ascending, Map<String, Object> filters) {
		return projectItemDAO.loadProjectItems(first, pageSize, sortField,
				ascending, filters);
	}

	@Override
	public OamProjectItem updateProjectItem(OamProjectItem oamProjectItem,
			CommonDriverMap commonDriverMap) {
		Date date = new Date();
		oamProjectItem.setLastModificationDate(date);
		oamProjectItem.setModificationMakerName(commonDriverMap
				.getCurrentUserCode());
		return projectItemDAO.persist(oamProjectItem);
	}

	@Override
	public List<OamProjectItem> getAllProjectItems() {
		return projectItemDAO.getAllProjectItems();
	}

	@Override
	public OamProjectItem getProjectItem(Long projectItemId) {
		return projectItemDAO.getProjectItem(projectItemId);
	}

	@Override
	public OamProjectItem addProjectItem(OamProjectItem oamProjectItem,
			CommonDriverMap commonDriverMap) {
		Date date = new Date();
		oamProjectItem.setLastModificationDate(date);
		oamProjectItem.setModificationMakerName(commonDriverMap
				.getCurrentUserCode());
		return projectItemDAO.persist(oamProjectItem);
	}

	@Override
	public List<OamProjectItem> getAllProjectItems(Company company) {
		return projectItemDAO.getAllProjectItems(company);
	}

	@Override
	public List<OamProjectItem> getAllProjectItems(
			String projectItemNameOrDescription, Department department) {
		if(Utils.isEmptyString(projectItemNameOrDescription)){
			return projectItemDAO.getAllProjectItems(
					department);
		}else
		{
			return projectItemDAO.getAllProjectItems(projectItemNameOrDescription,
					department);
		}
	}

	@Override
	public Long getNumberofRemainingItems(OamProjectItem projectItem) {
		return projectItemDAO.getNumberofRemainingItems( projectItem);
	}

}
