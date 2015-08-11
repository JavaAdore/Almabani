package com.almabani.business.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.EmployeeService;
import com.almabani.common.entity.schema.admincor.DepartmentSection;
import com.almabani.common.entity.schema.admincor.Employee;
import com.almabani.dataaccess.dao.admincor.EmployeeDAO;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Employee saveOrUpdate(Employee employee) {
		if(employee.getId() == null){
			employeeDAO.persist(employee);
		} else{
			employeeDAO.update(employee);
		}
		return employee;
	}

	@Override
	public Employee getEmployee(Long id) {
		return employeeDAO.getEmployee(id);
	}

	@Override
	public List<Employee> getEmployees(
			DepartmentSection selectedDepartmentSection) {
		return employeeDAO.getEmployees(selectedDepartmentSection);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

}
