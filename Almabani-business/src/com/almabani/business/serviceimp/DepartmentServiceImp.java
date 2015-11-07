package com.almabani.business.serviceimp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.DepartmentService;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.dataaccess.dao.admincor.DepartmentDAO;

@Service
public class DepartmentServiceImp implements DepartmentService {

	@Autowired
	private DepartmentDAO departmentDAO;


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

	@Override
	public List<Department> loadDepartments(int first, int pageSize,
			String sortField, boolean assending, Map<String, Object> filters) {
		return departmentDAO.loadDepartments(first, pageSize, sortField,
				assending, filters);
	}

	@Override
	public Integer getNumberOfDepartments(Map<String, Object> filters) {
		return departmentDAO.getNumberOfDepartments(filters);
	}

	@Override
	public Department addDepartment(Department department,
			CommonDriverMap commonDriverMap) {
		Date date = new Date();
		department.setLastModificationDate(date);
		department.setModificationMakerName(commonDriverMap
				.getCurrentUserCode());
		return departmentDAO.saveOrUpdate(department);
	}

	@Override
	public Department updateDepartment(Department department,
			CommonDriverMap commonDriverMap) {
		Date date = new Date();
		department.setLastModificationDate(date);
		department.setModificationMakerName(commonDriverMap
				.getCurrentUserCode());
		return departmentDAO.saveOrUpdate(department);
	}
}
