package com.almabani.dataaccess.dao.admincor;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.common.entity.schema.admincor.DepartmentSection;
import com.almabani.common.entity.schema.admincor.view.VComDepartmentSection;
import com.almabani.dataaccess.dao.AbstractDAOInt;


  
@Repository
public interface DepartmentSectionDAO extends AbstractDAOInt{
	
	void persist(DepartmentSection departmentSection);
	
	void update(DepartmentSection departmentSection);
	
	DepartmentSection getDepartmentSection(Long id);

	List<DepartmentSection> getDepartmentSections(Department department);

	List<VComDepartmentSection> loadDepartmentSectionsView(Integer first,
			Integer pageSize, String sortField, boolean assending,
			Map<String, Object> filters);

	Integer getNumberOfDepartmentSectionsView(Map<String, Object> filters);
}
