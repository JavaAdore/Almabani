package com.almabani.dataaccess.dao.admincor;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.common.entity.schema.admincor.DepartmentSection;
import com.almabani.dataaccess.dao.AbstractDAOInt;


  
@Repository
public interface DepartmentSectionDAO extends AbstractDAOInt{
	
	void persist(DepartmentSection departmentSection);
	
	void update(DepartmentSection departmentSection);
	
	DepartmentSection getDepartmentSection(Long id);

	List<DepartmentSection> getDepartmentSections(Department department);
}
