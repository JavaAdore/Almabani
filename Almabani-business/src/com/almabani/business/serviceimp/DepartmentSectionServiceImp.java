package com.almabani.business.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.DepartmentSectionService;
import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.common.entity.schema.admincor.DepartmentSection;
import com.almabani.dataaccess.dao.admincor.DepartmentSectionDAO;

@Service
public class DepartmentSectionServiceImp implements DepartmentSectionService {
	
	@Autowired
	private DepartmentSectionDAO departmentSectionDAO;

	@Override
	public DepartmentSection saveOrUpdate(DepartmentSection departmentSection) {
		if(departmentSection.getId()!=null){
			departmentSectionDAO.persist(departmentSection);
		} else{
			departmentSectionDAO.update(departmentSection);
		}
		return departmentSection;
	}

	@Override
	public DepartmentSection getDepartmentSection(Long id) {
		return departmentSectionDAO.getDepartmentSection(id);
	}

	@Override
	public List<DepartmentSection> getDepartmentSections(Department department) {
		if(department.getId()!=null){
			return departmentSectionDAO.getDepartmentSections(department);
		} 
		return null;
	}

}
