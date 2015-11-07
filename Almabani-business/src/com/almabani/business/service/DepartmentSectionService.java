package com.almabani.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.common.entity.schema.admincor.DepartmentSection;
import com.almabani.common.entity.schema.admincor.view.VComDepartmentSection;

@Service
public interface DepartmentSectionService {
	
	DepartmentSection saveOrUpdate(DepartmentSection departmentSection);
	
	DepartmentSection getDepartmentSection(Long id);

	List<DepartmentSection> getDepartmentSections(Department department);

	List<VComDepartmentSection> loadDepartmentSectionsView(Integer first,
			Integer pageSize, String sortField, boolean assending,
			Map<String, Object> filters);

	Integer getNumberOfDepartmentSectionsView(Map<String, Object> filters);

}
