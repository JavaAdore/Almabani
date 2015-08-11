package com.almabani.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.common.entity.schema.admincor.DepartmentSection;

@Service
public interface DepartmentSectionService {
	
	DepartmentSection saveOrUpdate(DepartmentSection departmentSection);
	
	DepartmentSection getDepartmentSection(Long id);

	List<DepartmentSection> getDepartmentSections(Department department);

}
