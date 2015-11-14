package com.almabani.business.serviceimp;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.ProjectEmployeeService;
import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.entity.schema.admincor.Employee;
import com.almabani.common.entity.schema.adminoam.ProjectEmployee;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.dataaccess.dao.adminoam.ProjectEmployeeDAO;

@Service
public class ProjectEmployeeServiceImp implements ProjectEmployeeService {

	@Autowired
	ProjectEmployeeDAO projectEmployeeDAO;

	@Override
	public List<ProjectEmployee> getProjectEmployee(Employee employee) {
		return projectEmployeeDAO.getProjectEmployee(employee);
	}

	@Override
	public List<ProjectEmployee> getProjectEmployee(List<Employee> employees) {
		return projectEmployeeDAO.getProjectEmployee(employees);
	}

	@Override
	public ProjectEmployee saveOrUpdate(ProjectEmployee projectEmployee)
			throws AlmabaniException {
		validateProjectEmployee(projectEmployee);
  
		if (projectEmployee.getId() == null) {
			;

			int numberOfAllocatedProjects = projectEmployeeDAO
					.getNumberOfProjectEmployees(projectEmployee.getProject(),
							projectEmployee.getEmployee());

			if (numberOfAllocatedProjects == 0) {
				projectEmployee = projectEmployeeDAO.persist(projectEmployee);
			} else {
				Set param = new HashSet();
				param.add(projectEmployee.getProject().getProjectCode());
				param.add(projectEmployee.getProjectJobTitle()
						.getProjectJobTitleDescription());

				throw new AlmabaniException(
						MessagesKeyStore.ALMABANI_EMPLOYEE_ALREADY_ALLOCATED_TO_THIS_PROJECT,
						null, param);
			}

		} else {
			ProjectEmployee frishlyFetchedProjectItem = projectEmployeeDAO
					.getProjectEmployee(projectEmployee.getId());
			if (projectEmployee.getProject().equals(
					frishlyFetchedProjectItem.getProject())) {
				return projectEmployee = projectEmployeeDAO
						.update(projectEmployee);
			} else {
				int numberOfAllocatedProjects = projectEmployeeDAO
						.getNumberOfProjectEmployees(
								projectEmployee.getProject(),
								projectEmployee.getEmployee());
				if (numberOfAllocatedProjects == 0) {
					projectEmployee = projectEmployeeDAO
							.persist(projectEmployee);
				} else {
					Set param = new HashSet();
					param.add(projectEmployee.getProject().getProjectCode());
					param.add(projectEmployee.getProjectJobTitle()
							.getProjectJobTitleDescription());

					throw new AlmabaniException(
							MessagesKeyStore.ALMABANI_EMPLOYEE_ALREADY_ALLOCATED_TO_THIS_PROJECT,
							null, param);
				}
			}

		}
		return projectEmployee;
	}

	private void validateProjectEmployee(ProjectEmployee projectEmployee)
			throws AlmabaniException {

		if (projectEmployee.getValidityBeginDate() != null
				&& projectEmployee.getValidityEndDate() != null) {
			if (projectEmployee.getValidityBeginDate().after(
					projectEmployee.getValidityEndDate())) {

				throw new AlmabaniException(
						MessagesKeyStore.ALMABANI_PROJECT_EMPLOYEE_END_VALIDITY_DATE_SHOULD_BE_BEFORE_START_VALIDITY_DATE);
			}

		}

	}

	@Override
	public Integer getNumberOfProjectEmployees(Map<String, Object> filters) {
		return projectEmployeeDAO.getNumberOfProjectEmployees(filters);
	}

	@Override
	public List<ProjectEmployee> loadProjectsAllocationEmployee(int first,
			int pageSize, String sortField, boolean ascending,
			Map<String, Object> filters) {
		return projectEmployeeDAO.loadProjectsAllocationEmployee(first,
				pageSize, sortField, ascending, filters);
	}

}
