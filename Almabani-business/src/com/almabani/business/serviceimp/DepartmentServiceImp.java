package com.almabani.business.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.DepartmentService;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.dataaccess.dao.admincor.DepartmentDAO;

@Service
public class DepartmentServiceImp implements DepartmentService {

	@Autowired
	private DepartmentDAO departmentDAO;

	@Override
	public Department saveOrUpdate(Department department) {
		if (department.getId() != null) {
			departmentDAO.persist(department);
		} else {
			departmentDAO.update(department);
		}
		return department;
	}

	@Override
	public Department getDepartment(Long id) {
		return departmentDAO.getDepartment(id);
	}

	@Override
	public List<Department> getDepartments() {
		return departmentDAO.getDepartments();
	}

	@Override
	public List<Department> getDepartments(Company company) {
		return departmentDAO.getDepartments(company);
	}

	@Override
	public List<Department> getLightDepartments(Company company) {
		return departmentDAO.getLightDepartments(company.getId().intValue());
	}

	@Override
	public List<Department> getLightDepartments() {
		return departmentDAO.getAllLightDepartments();
	}
}
