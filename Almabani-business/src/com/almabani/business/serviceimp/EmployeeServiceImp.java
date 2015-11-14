package com.almabani.business.serviceimp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.EmployeeService;
import com.almabani.common.constant.DataAccessConstants;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.DepartmentSection;
import com.almabani.common.entity.schema.admincor.Employee;
import com.almabani.dataaccess.dao.admincor.EmployeeDAO;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Employee saveOrUpdate(Employee employee) {
		if (employee.getId() == null) {
			employee.setRegistrationDate(new Date());
			employeeDAO.persist(employee);
		} else {
			if (employee.getActive().equalsIgnoreCase(
					DataAccessConstants.IND_ACTIVE) == false) {
				Employee frishlyFetchedEmployee = employeeDAO
						.getEmployee(employee.getId());
				if (employee.getActive().equalsIgnoreCase(
						frishlyFetchedEmployee.getActive()) == false) {
					if (employee.getActive().equals(
							DataAccessConstants.IND_ACTIVE)) {
						employee.setInactivityBeginDate(null);
					} else {
						employee.setInactivityBeginDate(new Date());

					}
				}
			}
			employee = employeeDAO.update(employee);
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

	@Override
	public boolean isFederalIdentityCodeExist(String federalIdentityCode) {
		return employeeDAO.isFederalIdentityCodeExist(federalIdentityCode);
	}

	@Override
	public Integer getNumberOfEmployees(Map<String, Object> filters) {
		return employeeDAO.getNumberOfEmployees(filters);
	}

	@Override
	public List<Employee> loadEmployees(int first, int pageSize,
			String sortField, boolean ascending, Map<String, Object> filters) {
		return employeeDAO.loadEmployees(first, pageSize, sortField, ascending,
				filters);
	}

	@Override
	public List<Employee> getCompanyEmployees(Company company) {
		return employeeDAO.getCompanyEmployees(company);
	}

}
