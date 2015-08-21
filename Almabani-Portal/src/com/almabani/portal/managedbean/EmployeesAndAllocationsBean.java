package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.common.entity.schema.admincor.DepartmentSection;
import com.almabani.common.entity.schema.admincor.Employee;
import com.almabani.common.entity.schema.adminoam.ProjectEmployee;
import com.almabani.common.enums.EmployeeContractType;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class EmployeesAndAllocationsBean extends AbstractBeanHelper implements
		Serializable {

	private static final long serialVersionUID = 1L;

	// private List<Company> companiesList;

	private List<Company> companiesList;

	private Company selectedCompany;

	private List<Department> departmentList;

	private Department selectedDepartment;

	private Department department4Details;

	private List<DepartmentSection> departmentSections;

	private DepartmentSection selectedDepartmentSection;

	private DepartmentSection departmentSection4Details;

	private List<Employee> employeesList;

	private Employee selectedEmployee;

	private Employee employee4Details;
	

	@PostConstruct
	public void init() {
		companiesList = almabaniFacade.getAllCompanies();

	}

	public void onCompanySelect() {
		departmentList = almabaniFacade.getDepartments(selectedCompany);
		selectedDepartment = null;
		departmentSections = null;
		selectedDepartmentSection = null;
		employeesList = null;
	}

	public void onDepartmentSelect() {
		departmentSections = almabaniFacade
				.getDepartmentSections(selectedDepartment);
		selectedDepartmentSection = null;
		employeesList = null;

	}

	public void departmentDetails(Department department4Details) {
		this.department4Details = department4Details;
	}

	public void departmentSectionDetails(
			DepartmentSection departmentSection4Details) {
		this.departmentSection4Details = departmentSection4Details;
	}

	public void employeeDetails(Employee employee4Details) {
		this.employee4Details = employee4Details;
	}

	public int totalEmployees(DepartmentSection departmentSection) {
		return almabaniFacade.getProjectEmployee(
				almabaniFacade.getEmployees(departmentSection)).size();
	}

	public int numberOfContractEmployees(DepartmentSection departmentSection) {
		int contractEmployeesNo = 0;
		for (ProjectEmployee projectEmployee : almabaniFacade
				.getProjectEmployee(almabaniFacade
						.getEmployees(departmentSection))) {
			if (projectEmployee.getEmployeeContractType().equals(
					EmployeeContractType.C))
				contractEmployeesNo += 1;
		}
		return contractEmployeesNo;
	}

	public int numberOfSupportEmployees(DepartmentSection departmentSection) {
		int supportEmployeesNo = 0;
		for (ProjectEmployee projectEmployee : almabaniFacade
				.getProjectEmployee(almabaniFacade
						.getEmployees(departmentSection))) {
			if (projectEmployee.getEmployeeContractType().equals(
					EmployeeContractType.S))
				supportEmployeesNo += 1;
		}
		return supportEmployeesNo;
	}

	public void onDepartmentSectionSelect() {
		employeesList = almabaniFacade.getEmployees(selectedDepartmentSection);
	}

	public String extractFromBundle(String key) {
		return WebUtils.extractFromBundle(key);
	}

	/**
	 * @return the companiesList
	 */
	public List<Company> getCompaniesList() {
		return companiesList;
	}

	/**
	 * @param companiesList
	 *            the companiesList to set
	 */
	public void setCompaniesList(List<Company> companiesList) {
		this.companiesList = companiesList;
	}

	/**
	 * @return the selectedCompany
	 */
	public Company getSelectedCompany() {
		return selectedCompany;
	}

	/**
	 * @param selectedCompany
	 *            the selectedCompany to set
	 */
	public void setSelectedCompany(Company selectedCompany) {
		this.selectedCompany = selectedCompany;
	}

	/**
	 * @return the departmentList
	 */
	public List<Department> getDepartmentList() {
		return departmentList;
	}

	/**
	 * @param departmentList
	 *            the departmentList to set
	 */
	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	/**
	 * @return the selectedDepartment
	 */
	public Department getSelectedDepartment() {
		return selectedDepartment;
	}

	/**
	 * @param selectedDepartment
	 *            the selectedDepartment to set
	 */
	public void setSelectedDepartment(Department selectedDepartment) {
		this.selectedDepartment = selectedDepartment;
	}

	/**
	 * @return the department4Details
	 */
	public Department getDepartment4Details() {
		return department4Details;
	}

	/**
	 * @param department4Details
	 *            the department4Details to set
	 */
	public void setDepartment4Details(Department department4Details) {
		this.department4Details = department4Details;
	}

	/**
	 * @return the departmentSections
	 */
	public List<DepartmentSection> getDepartmentSections() {
		return departmentSections;
	}

	/**
	 * @param departmentSections
	 *            the departmentSections to set
	 */
	public void setDepartmentSections(List<DepartmentSection> departmentSections) {
		this.departmentSections = departmentSections;
	}

	/**
	 * @return the selectedDepartmentSection
	 */
	public DepartmentSection getSelectedDepartmentSection() {
		return selectedDepartmentSection;
	}

	/**
	 * @param selectedDepartmentSection
	 *            the selectedDepartmentSection to set
	 */
	public void setSelectedDepartmentSection(
			DepartmentSection selectedDepartmentSection) {
		this.selectedDepartmentSection = selectedDepartmentSection;
	}

	/**
	 * @return the departmentSection4Details
	 */
	public DepartmentSection getDepartmentSection4Details() {
		return departmentSection4Details;
	}

	/**
	 * @param departmentSection4Details
	 *            the departmentSection4Details to set
	 */
	public void setDepartmentSection4Details(
			DepartmentSection departmentSection4Details) {
		this.departmentSection4Details = departmentSection4Details;
	}

	/**
	 * @return the employeesList
	 */
	public List<Employee> getEmployeesList() {
		return employeesList;
	}

	/**
	 * @param employeesList
	 *            the employeesList to set
	 */
	public void setEmployeesList(List<Employee> employeesList) {
		this.employeesList = employeesList;
	}

	/**
	 * @return the selectedEmployee
	 */
	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}

	/**
	 * @param selectedEmployee
	 *            the selectedEmployee to set
	 */
	public void setSelectedEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
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

	 public void onRowSelect(SelectEvent event) {
		 selectedEmployee =  (Employee) event.getObject();
	 }   
	 
	 private class EmployeeLazyModel extends
		LazyDataModel<Employee> implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer rowCount;

	List<Employee> result;

	@Override
	public List<Employee> load(int first, int pageSize,
			String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		
		rowCount = almabaniFacade.getNumberOfEmployees(filters);

		result = (List<Employee>) almabaniFacade
				.loadEmployees(first, pageSize, sortField,
						sortOrder == SortOrder.ASCENDING, filters);

		setRowCount(this.rowCount);

		return result;
	}


	@Override
	public Employee getRowData(String rowKey) {

		for (Employee employee : result) {
			if (employee.getId().toString().equals(rowKey)) {
				selectedEmployee = employee;
				return employee;
			}
		}

		return null;
	}

}
	
}
