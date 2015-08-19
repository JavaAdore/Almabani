package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.common.entity.schema.admincor.DepartmentSection;
import com.almabani.common.entity.schema.admincor.Employee;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;

@ManagedBean
@ViewScoped
public class CompanyBean extends AbstractBeanHelper implements
		Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private List<Company> companiesList;
	
	private Company selectedCompany;
	
	private List<Department> departmentList;
	
	private Department selectedDepartment; 
	
	private List<DepartmentSection> departmentSections;
	
	private DepartmentSection selectedDepartmentSection;
	
	private List<Employee> employeesList;
	
	@PostConstruct
	public void init() {
		companiesList = almabaniFacade.getAllCompanies();
	}
	
	public void onCompanySelect(){
		departmentList = almabaniFacade.getDepartments(selectedCompany);
		selectedDepartment = null;
		departmentSections = null;
		selectedDepartmentSection = null;
		employeesList = null;
	}
	
	public void onDepartmentSelect(){
		departmentSections = almabaniFacade.getDepartmentSections(selectedDepartment);
		selectedDepartmentSection = null;
		employeesList = null;
		
	}
	
	public void onDepartmentSectionSelect(){
		employeesList = almabaniFacade.getEmployees(selectedDepartmentSection);
	}
	
	/**
	 * @return the companiesList
	 */
	public List<Company> getCompaniesList() {
		return companiesList;
	}

	/**
	 * @param companiesList the companiesList to set
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
	 * @param selectedCompany the selectedCompany to set
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
	 * @param departmentList the departmentList to set
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
	 * @param selectedDepartment the selectedDepartment to set
	 */
	public void setSelectedDepartment(Department selectedDepartment) {
		this.selectedDepartment = selectedDepartment;
	}

	/**
	 * @return the departmentSections
	 */
	public List<DepartmentSection> getDepartmentSections() {
		return departmentSections;
	}

	/**
	 * @param departmentSections the departmentSections to set
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
	 * @param selectedDepartmentSection the selectedDepartmentSection to set
	 */
	public void setSelectedDepartmentSection(
			DepartmentSection selectedDepartmentSection) {
		this.selectedDepartmentSection = selectedDepartmentSection;
	}

	/**
	 * @return the employeesList
	 */
	public List<Employee> getEmployeesList() {
		return employeesList;
	}

	/**
	 * @param employeesList the employeesList to set
	 */
	public void setEmployeesList(List<Employee> employeesList) {
		this.employeesList = employeesList;
	}
	
	
}
