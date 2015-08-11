package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FlowEvent;

import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.entity.schema.admincor.Country;
import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.common.entity.schema.admincor.DepartmentSection;
import com.almabani.common.entity.schema.admincor.Employee;
import com.almabani.common.entity.schema.admincor.Establishment;
import com.almabani.common.entity.schema.admincor.JobTitleType;
import com.almabani.common.enums.Active;
import com.almabani.common.enums.DocumentType;
import com.almabani.common.enums.EmployeeType;
import com.almabani.common.enums.Gender;
import com.almabani.common.enums.MaritalStatus;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class EmployeeBean extends AbstractBeanHelper implements
		Serializable {
	
private static final long serialVersionUID = 1L;
	
	private Employee employee;
	
	private Employee selectedEmployee;
	
	private List<Employee> emplyeesList;
	
	private List<Country> countries;
	
	private List<Department> departmentList;
		
	private Department selectedDepartment;
	
	private List<DepartmentSection> departmentSections;
	
	private DepartmentSection selectedDepartmentSection;
	
	private List<Establishment> establishments;
	
	private List<JobTitleType> jobTitleTypes;
	
	private Gender[] genders;
	
	private MaritalStatus[] maritalStatus;
	
	private Active[] active;
	
	private EmployeeType[] employeeTypes;
	
	private DocumentType[] documentTypes;
		
	private String step = "first";

	@PostConstruct
	public void init() {
		employee = new Employee();
		employee.setActive(Active.Y);
		departmentList = almabaniFacade.getDepartments();
		countries = almabaniFacade.getAllCountries();
		establishments = almabaniFacade.getEstablishments();
		jobTitleTypes = almabaniFacade.getJobTitleTypes();
		genders = Gender.values();
		maritalStatus = MaritalStatus.values();
		active = Active.values();
		employeeTypes = EmployeeType.values();
		documentTypes = DocumentType.values();
	}
	
	public void prepareCreateEmployee(){
		employee = new Employee();
		step = "first";
	}
	
	public void prepareEditEmployee(Employee emp){
		selectedEmployee = emp;
		departmentSections = almabaniFacade.getDepartmentSections(emp.getDepartmentSection().getDepartment());
		selectedDepartment = emp.getDepartmentSection().getDepartment();
		step = "first";
	}
	
	public void onDepartmentSelect(){
		if(selectedDepartment != null)
			departmentSections = almabaniFacade.getDepartmentSections(selectedDepartment);
		else if(selectedEmployee != null){
			departmentSections = almabaniFacade.getDepartmentSections(selectedDepartment);
		} else
			departmentSections = null;
	}
	
	public String extractFromBundle(String key){
		return WebUtils.extractFromBundle(key);
	}
	
	public void saveOrUpdate(Employee emp){
		
        try {
        	boolean isAlreadyExisitEntity = Utils.hasID(emp);
        	
        	emp.setRegistrationDate(new Date());
        	emp.setLastModificationDate(new Date());
        	emp.setModificationMakerName("Register");
            almabaniFacade.saveOrUpdate(emp);
            if(isAlreadyExisitEntity)
            	WebUtils.invokeJavaScriptFunction("PF('editEmployeeDialog').hide()");
            else
            	WebUtils.invokeJavaScriptFunction("PF('createEmployeeDialog').hide()");
                        
            WebUtils.fireInfoMessage(
					(isAlreadyExisitEntity) ? MessagesKeyStore.ALMABANI_GENERAL_UPDATED_SUCCESSFULLY
							: MessagesKeyStore.ALMABANI_GENERAL_ADDED_SUCCESSFULLY, 
					WebUtils.prepareParamSet(MessagesKeyStore.ALMABANI_EMPLOYEE));
            
            prepareCreateEmployee();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}

	public String onFlowProcess(FlowEvent event) {

		return event.getNewStep();
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}
	
	/**
	 * @return the selectedEmployee
	 */
	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}

	/**
	 * @param selectedEmployee the selectedEmployee to set
	 */
	public void setSelectedEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}

	/**
	 * @return the emplyeesList
	 */
	public List<Employee> getEmplyeesList() {
		return emplyeesList;
	}

	/**
	 * @param emplyeesList the emplyeesList to set
	 */
	public void setEmplyeesList(List<Employee> emplyeesList) {
		this.emplyeesList = emplyeesList;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	/**
	 * @return the countries
	 */
	public List<Country> getCountries() {
		return countries;
	}

	/**
	 * @param countries the countries to set
	 */
	public void setCountries(List<Country> countries) {
		this.countries = countries;
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
	 * @return the establishments
	 */
	public List<Establishment> getEstablishments() {
		return establishments;
	}

	/**
	 * @param establishments the establishments to set
	 */
	public void setEstablishments(List<Establishment> establishments) {
		this.establishments = establishments;
	}

	/**
	 * @return the jobTitleTypes
	 */
	public List<JobTitleType> getJobTitleTypes() {
		return jobTitleTypes;
	}

	/**
	 * @param jobTitleTypes the jobTitleTypes to set
	 */
	public void setJobTitleTypes(List<JobTitleType> jobTitleTypes) {
		this.jobTitleTypes = jobTitleTypes;
	}

	/**
	 * @return the genders
	 */
	public Gender[] getGenders() {
		return genders;
	}

	/**
	 * @param genders the genders to set
	 */
	public void setGenders(Gender[] genders) {
		this.genders = genders;
	}

	/**
	 * @return the maritalStatus
	 */
	public MaritalStatus[] getMaritalStatus() {
		return maritalStatus;
	}

	/**
	 * @param maritalStatus the maritalStatus to set
	 */
	public void setMaritalStatus(MaritalStatus[] maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	/**
	 * @return the active
	 */
	public Active[] getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(Active[] active) {
		this.active = active;
	}

	/**
	 * @return the employeeTypes
	 */
	public EmployeeType[] getEmployeeTypes() {
		return employeeTypes;
	}

	/**
	 * @param employeeTypes the employeeTypes to set
	 */
	public void setEmployeeTypes(EmployeeType[] employeeTypes) {
		this.employeeTypes = employeeTypes;
	}

	/**
	 * @return the documentTypes
	 */
	public DocumentType[] getDocumentTypes() {
		return documentTypes;
	}

	/**
	 * @param documentTypes the documentTypes to set
	 */
	public void setDocumentTypes(DocumentType[] documentTypes) {
		this.documentTypes = documentTypes;
	}

	/**
	 * @return the step
	 */
	public String getStep() {
		return step;
	}

	/**
	 * @param step the step to set
	 */
	public void setStep(String step) {
		this.step = step;
	}
	
}
