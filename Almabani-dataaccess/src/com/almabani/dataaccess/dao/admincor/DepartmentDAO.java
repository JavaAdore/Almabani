package com.almabani.dataaccess.dao.admincor;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.dataaccess.dao.AbstractDAOInt;


  
@Repository
public interface DepartmentDAO extends AbstractDAOInt{
	
	void persist(Department department);
	
	void update(Department department);
	
	Department getDepartment(Long id);

	List<Department> getDepartments();

	List<Department> getDepartments(Company company);

	List<Department> getLightDepartments(int companyId);

	List<Department> getAllLightDepartments();
}
