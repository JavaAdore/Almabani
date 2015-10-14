package com.almabani.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.common.entity.schema.adminoam.OamProjectItem;

@Service
public interface ProjectItemService {


	Integer getCountOfProjectItems(Map<String, Object> filters);

	List<OamProjectItem> loadProjectItems(int first, int pageSize,
			String sortField, boolean b, Map<String, Object> filters);

	OamProjectItem updateProjectItem(OamProjectItem oamProjectItem,
			CommonDriverMap commonDriverMap);

	OamProjectItem addProjectItem(OamProjectItem oamProjectItem,
			CommonDriverMap commonDriverMap);

	List<OamProjectItem> getAllProjectItems();

	OamProjectItem getProjectItem(Long ProjectItemID);

	List<OamProjectItem> getAllProjectItems(Company company);

	List<OamProjectItem> getAllProjectItems(
			String projectItemNameOrDescription, Department department);

	Long getNumberofRemainingItems(OamProjectItem projectItem);

}
