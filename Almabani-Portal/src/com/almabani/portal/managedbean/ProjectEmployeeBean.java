package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.entity.schema.admincor.Employee;
import com.almabani.common.entity.schema.admincor.Project;
import com.almabani.common.entity.schema.adminoam.AllocationType;
import com.almabani.common.entity.schema.adminoam.ProjectEmployee;
import com.almabani.common.entity.schema.adminoam.ProjectJobTitle;
import com.almabani.common.enums.EmployeeContractType;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class ProjectEmployeeBean extends AbstractBeanHelper implements
		Serializable {

	private static final long serialVersionUID = 72232710943044788L;

	ProjectEmployee projectEmployee4Create;

	List<AllocationType> allocationTypes;

	List<ProjectJobTitle> projectJobTitles;

	List<Project> projects;

	EmployeeContractType[] employeeContractTypes;

	ProjectEmployee selectedProjectEmployee;
	
	LazyDataModel<ProjectEmployee> projectsEmployeeCurrentList;
	
	private Employee employee4Details;

	@PostConstruct
	public void init() {
		allocationTypes = almabaniFacade.getAllAllocationTypes();
		projectJobTitles = almabaniFacade.getAllProjectJobTitles();
		projects = almabaniFacade.getAllProjects();
		employeeContractTypes = EmployeeContractType.values();
	}

	public void saveOrUpdate(ProjectEmployee projectEmployee) {
		projectEmployee.setModificationMakerName("Not yet!");
		projectEmployee.setLastModificationDate(new Date());
		projectEmployee.setValidityBeginDate(new Date());
		
		boolean isAlreadyExisitEntity = Utils.hasID(projectEmployee);
		
		almabaniFacade.saveOrUpdate(projectEmployee);
		WebUtils.fireInfoMessage(
				(isAlreadyExisitEntity) ? MessagesKeyStore.ALMABANI_GENERAL_UPDATED_SUCCESSFULLY
						: MessagesKeyStore.ALMABANI_GENERAL_ADDED_SUCCESSFULLY, 
				WebUtils.prepareParamSet(MessagesKeyStore.ALMABANI_PROJECT_EMPLOYEE));
	}

	public String extractFromBundle(String key) {
		return WebUtils.extractFromBundle(key);
	}

	public void prepareCreateProjectEmployee() {
		projectEmployee4Create = new ProjectEmployee();
		projectEmployee4Create.setEmployee(employee4Details);

	}
	
	public void employeeAllocations(Employee employee) {
		employee4Details = employee;
		projectsEmployeeCurrentList = new ProjectEmployeeLazyModel();
	}
	
	private class ProjectEmployeeLazyModel extends
			LazyDataModel<ProjectEmployee> implements Serializable {

		private static final long serialVersionUID = 1L;
		private Integer rowCount;

		List<ProjectEmployee> result;

		@Override
		public List<ProjectEmployee> load(int first, int pageSize,
				String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {

			injectEmployee(filters);
			rowCount = almabaniFacade.getNumberOfProjectEmployees(filters);

			result = (List<ProjectEmployee>) almabaniFacade
					.loadProjectsAllocationEmployee(first, pageSize, sortField,
							sortOrder == SortOrder.ASCENDING, filters);

			setRowCount(this.rowCount);

			return result;
		}

		private void injectEmployee(Map<String, Object> filters) {

			if (Utils.isNotNull(employee4Details)) {
				filters.put("employee", employee4Details);
			}
		}

		@Override
		public ProjectEmployee getRowData(String rowKey) {

			for (ProjectEmployee qoutation : result) {
				if (qoutation.getId().toString().equals(rowKey)) {
					selectedProjectEmployee = qoutation;
					return qoutation;
				}
			}

			return null;
		}

	}
	
	/**
	 * @return the projectEmployee4Create
	 */
	public ProjectEmployee getProjectEmployee4Create() {
		return projectEmployee4Create;
	}

	/**
	 * @param projectEmployee4Create the projectEmployee4Create to set
	 */
	public void setProjectEmployee4Create(ProjectEmployee projectEmployee4Create) {
		this.projectEmployee4Create = projectEmployee4Create;
	}

	/**
	 * @return the selectedProjectEmployee
	 */
	public ProjectEmployee getSelectedProjectEmployee() {
		return selectedProjectEmployee;
	}

	/**
	 * @param selectedProjectEmployee
	 *            the selectedProjectEmployee to set
	 */
	public void setSelectedProjectEmployee(
			ProjectEmployee selectedProjectEmployee) {
		this.selectedProjectEmployee = selectedProjectEmployee;
	}

	/**
	 * @return the allocationTypes
	 */
	public List<AllocationType> getAllocationTypes() {
		return allocationTypes;
	}

	/**
	 * @param allocationTypes
	 *            the allocationTypes to set
	 */
	public void setAllocationTypes(List<AllocationType> allocationTypes) {
		this.allocationTypes = allocationTypes;
	}

	/**
	 * @return the projectJobTitles
	 */
	public List<ProjectJobTitle> getProjectJobTitles() {
		return projectJobTitles;
	}

	/**
	 * @param projectJobTitles
	 *            the projectJobTitles to set
	 */
	public void setProjectJobTitles(List<ProjectJobTitle> projectJobTitles) {
		this.projectJobTitles = projectJobTitles;
	}

	/**
	 * @return the projects
	 */
	public List<Project> getProjects() {
		return projects;
	}

	/**
	 * @param projects
	 *            the projects to set
	 */
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	/**
	 * @return the employeeContractTypes
	 */
	public EmployeeContractType[] getEmployeeContractTypes() {
		return employeeContractTypes;
	}

	/**
	 * @param employeeContractTypes
	 *            the employeeContractTypes to set
	 */
	public void setEmployeeContractTypes(
			EmployeeContractType[] employeeContractTypes) {
		this.employeeContractTypes = employeeContractTypes;
	}
	
	/**
	 * @return the projectsEmployeeCurrentList
	 */
	public LazyDataModel<ProjectEmployee> getProjectsEmployeeCurrentList() {
		return projectsEmployeeCurrentList;
	}

	/**
	 * @param projectsEmployeeCurrentList the projectsEmployeeCurrentList to set
	 */
	public void setProjectsEmployeeCurrentList(
			LazyDataModel<ProjectEmployee> projectsEmployeeCurrentList) {
		this.projectsEmployeeCurrentList = projectsEmployeeCurrentList;
	}

	/**
	 * @return the employee4Details
	 */
	public Employee getEmployee4Details() {
		return employee4Details;
	}

	/**
	 * @param employee4Details
	 *            the employee4Details to set
	 */
	public void setEmployee4Details(Employee employee4Details) {
		this.employee4Details = employee4Details;
	}

}
