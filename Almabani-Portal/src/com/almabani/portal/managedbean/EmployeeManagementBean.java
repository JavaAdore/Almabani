package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.entity.schema.admincor.DepartmentSection;
import com.almabani.common.entity.schema.admincor.Employee;
import com.almabani.common.entity.schema.admincor.Establishment;
import com.almabani.common.entity.schema.admincor.JobTitleType;
import com.almabani.common.entity.schema.admincor.Project;
import com.almabani.common.entity.schema.admincor.view.VComDepartmentSection;
import com.almabani.common.entity.schema.adminoam.AllocationType;
import com.almabani.common.entity.schema.adminoam.ProjectEmployee;
import com.almabani.common.entity.schema.adminoam.ProjectJobTitle;
import com.almabani.common.enums.Active;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class EmployeeManagementBean extends AbstractBeanHelper implements
		Serializable {

	private static final long serialVersionUID = 1L;

	public VComDepartmentSection selectedDepartmentSection;

	private LazyDataModel<VComDepartmentSection> departmentSections;

	private LazyDataModel<Employee> employees;

	public Employee selectedEmployee;

	private List<JobTitleType> jobTitleTypes;

	private List<Establishment> establishments;

	private ProjectEmployee projectEmployee;

	private Set<ProjectEmployee> employeeProjects;

	private List<Project> projects;

	private List<AllocationType> allocationTypes;

	private List<ProjectJobTitle> projectJobTitles;

	private Project selectedProject;

	@PostConstruct
	public void init() {
		initializeLazyModels();
	}

	private void initializeLazyModels() {

		initializeDepartmentSectionsLazyModel();
	}

	private void initializeDepartmentSectionsLazyModel() {

		departmentSections = new DepartmentSectionLazyModel();
		employees = new EmployeesLazyModel();
	}

	public void departmentSectionRowChanged(AjaxBehaviorEvent e) {
		selectedEmployee = null;
	}

	public void prepareCreateEmployee() {
		selectedEmployee = new Employee();

		loadInitialLists();
	}

	public void prepareCreateProjectEmployee() {
		projectEmployee = new ProjectEmployee();
		loadAvailableProjects();
		resetInitializedLists();
	}

	public void loadProjectEmployeeNeededLists() {
		selectedProject = projectEmployee.getProject();
		loadAvailableProjects();
		resetInitializedLists();
		loadProjectRelatedLists();

	}

	private void resetInitializedLists() {

		allocationTypes = new ArrayList();
		projectJobTitles = new ArrayList();
	}

	private void loadAvailableProjects() {

		projects = almabaniFacade.getProjects(selectedDepartmentSection
				.getCompany());
	}

	public void loadInitialLists() {
		loadJobTitleTypesList();
		loadEstablishmentsList();
	}

	private void loadEstablishmentsList() {
		establishments = almabaniFacade
				.getEstablishments(selectedDepartmentSection.getCompany());
	}

	private void loadJobTitleTypesList() {

		jobTitleTypes = almabaniFacade
				.getJobTitleTypes(selectedDepartmentSection.getCompany());
	}

	public void projectSelected(AjaxBehaviorEvent e) {

		selectedProject = (Project) ((SelectOneMenu) e.getSource()).getValue();
		loadProjectRelatedLists();
	}

	private void loadProjectRelatedLists() {
		if (Utils.isNotNull(selectedProject)) {
			allocationTypes = almabaniFacade
					.getAllocationTypes(selectedProject);
			projectJobTitles = almabaniFacade
					.getProjectJobTitles(selectedProject);
		}
	}

	private class DepartmentSectionLazyModel extends
			LazyDataModel<VComDepartmentSection> implements Serializable {

		private static final long serialVersionUID = 1L;
		List<VComDepartmentSection> result;

		private Integer rowCount;

		@Override
		public VComDepartmentSection getRowData(String rowKey) {

			for (VComDepartmentSection vComDepartmentSection : result) {
				if (vComDepartmentSection.getDepartmentSectionNumber()
						.toString().equals(rowKey)) {
					selectedDepartmentSection = vComDepartmentSection;
					return vComDepartmentSection;
				}
			}

			return null;
		}

		@Override
		public List<VComDepartmentSection> load(int first, int pageSize,
				String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {

			attachCompanyInCaseOfNoneAdminUser(filters);
			selectedDepartmentSection = null;
			selectedEmployee = null;
			rowCount = almabaniFacade
					.getNumberOfDepartmentSectionsView(filters);
			if (rowCount > 0) {
				result = (List<VComDepartmentSection>) almabaniFacade
						.loadDepartmentSectionsView(first, pageSize, sortField,
								sortOrder == SortOrder.ASCENDING, filters);
				setRowCount(this.rowCount);

				return result;
			}
			return new ArrayList();

		}

		private void attachCompanyInCaseOfNoneAdminUser(
				Map<String, Object> filters) {

			if (WebUtils.isAdminUser() == false) {
				filters.put("company", WebUtils.getCurrentLoggedUserCompany());
			}
		}

	}

	private class EmployeesLazyModel extends LazyDataModel<Employee> implements
			Serializable {
		private static final long serialVersionUID = 1L;
		List<Employee> result;

		Integer rowCount = null;

		public Employee getRowData(String rowKey) {
			for (Employee employee : result) {
				if (employee.getId().toString().equals(rowKey)) {
					selectedEmployee = employee;
					return employee;
				}
			}

			return null;

		}

		@Override
		public List<Employee> load(int first, int pageSize, String sortField,
				SortOrder sortOrder, Map<String, Object> filters) {

			if (Utils.isNotNull(selectedDepartmentSection)) {

				attachDepartmentSection(filters);

				rowCount = almabaniFacade.getNumberOfEmployeesView(filters);
				result = (List<Employee>) almabaniFacade.loadEmployees(first,
						pageSize, sortField, sortOrder == SortOrder.ASCENDING,
						filters);
				setRowCount(this.rowCount);

				return result;
			}
			return new ArrayList<Employee>();

		}

		private void attachDepartmentSection(Map<String, Object> filters) {
			filters.put("departmentSection", new DepartmentSection(
					selectedDepartmentSection.getDepartmentSectionNumber()));

		}
	}

	public void loadEmployeeProjects(Employee employee) {
		selectedEmployee = employee;
		employeeProjects = new HashSet(
				almabaniFacade.getProjectEmployee(employee));
	}

	public VComDepartmentSection getSelectedDepartmentSection() {
		return selectedDepartmentSection;
	}

	public void setSelectedDepartmentSection(
			VComDepartmentSection selectedDepartmentSection) {
		this.selectedDepartmentSection = selectedDepartmentSection;
	}

	public LazyDataModel<VComDepartmentSection> getDepartmentSections() {
		return departmentSections;
	}

	public void setDepartmentSections(
			LazyDataModel<VComDepartmentSection> departmentSections) {
		this.departmentSections = departmentSections;
	}

	public LazyDataModel<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(LazyDataModel<Employee> employees) {
		this.employees = employees;
	}

	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}

	public void setSelectedEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}

	public List<JobTitleType> getJobTitleTypes() {
		return jobTitleTypes;
	}

	public void setJobTitleTypes(List<JobTitleType> jobTitleTypes) {
		this.jobTitleTypes = jobTitleTypes;
	}

	public List<Establishment> getEstablishments() {
		return establishments;
	}

	public void setEstablishments(List<Establishment> establishments) {
		this.establishments = establishments;
	}

	public void saveEmployee() {

		boolean isAlreadyExisitEntity = Utils.hasID(selectedEmployee);
		
		selectedEmployee.setDepartmentSection(new DepartmentSection(selectedDepartmentSection.getDepartmentSectionNumber()));
		selectedEmployee.setLastModificationDate(new Date());
		selectedEmployee
				.setModificationMakerName(WebUtils.getCurrentUserCode());
		selectedEmployee = almabaniFacade.saveOrUpdate(selectedEmployee);

		WebUtils.fireInfoMessage(
				(isAlreadyExisitEntity) ? MessagesKeyStore.ALMABANI_GENERAL_UPDATED_SUCCESSFULLY
						: MessagesKeyStore.ALMABANI_GENERAL_ADDED_SUCCESSFULLY,
				WebUtils.prepareParamSet(MessagesKeyStore.ALMABANI_GENERAL_ITEM));
	}

	public ProjectEmployee getProjectEmployee() {
		return projectEmployee;
	}

	public void setProjectEmployee(ProjectEmployee projectEmployee) {
		this.projectEmployee = projectEmployee;
	}

	public Set<ProjectEmployee> getEmployeeProjects() {
		return employeeProjects;
	}

	public void setEmployeeProjects(Set<ProjectEmployee> employeeProjects) {
		this.employeeProjects = employeeProjects;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public void saveProjectEmployee() throws AlmabaniException {

		boolean isAlreadyExisitEntity = Utils.hasID(projectEmployee);
		projectEmployee.setEmployee(selectedEmployee);
		projectEmployee.setLastModificationDate(new Date());
		projectEmployee.setModificationMakerName(WebUtils.getCurrentUserCode());
		projectEmployee = almabaniFacade.saveOrUpdate(projectEmployee);

		employeeProjects.add(projectEmployee);
		WebUtils.fireInfoMessage(
				(isAlreadyExisitEntity) ? MessagesKeyStore.ALMABANI_GENERAL_UPDATED_SUCCESSFULLY
						: MessagesKeyStore.ALMABANI_GENERAL_ADDED_SUCCESSFULLY,
				WebUtils.prepareParamSet(MessagesKeyStore.ALMABANI_GENERAL_ITEM));
	}

	public List<AllocationType> getAllocationTypes() {
		return allocationTypes;
	}

	public void setAllocationTypes(List<AllocationType> allocationTypes) {
		this.allocationTypes = allocationTypes;
	}

	public List<ProjectJobTitle> getProjectJobTitles() {
		return projectJobTitles;
	}

	public void setProjectJobTitles(List<ProjectJobTitle> projectJobTitles) {
		this.projectJobTitles = projectJobTitles;
	}

	public Project getSelectedProject() {
		return selectedProject;
	}

	public void setSelectedProject(Project selectedProject) {
		this.selectedProject = selectedProject;
	}

	public void selectNullProjectEmployee() {

		projectEmployee = null;
	}
}
