package com.almabani.dataaccess.dao.admincor;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.DepartmentSection;
import com.almabani.common.entity.schema.admincor.Employee;
import com.almabani.dataaccess.dao.AbstractDAOInt;


  
@Repository
public interface EmployeeDAO extends AbstractDAOInt{
	
	void persist(Employee employee);
	
	void update(Employee employee);
	
	Employee getEmployee(Long id);

	List<Employee> getEmployees(DepartmentSection departmentSection);

	List<Employee> getAllEmployees();
}
