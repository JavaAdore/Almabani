package com.almabani.portal.managedbean;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.UploadedFile;

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
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class EmployeeWizardBean extends AbstractBeanHelper implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Employee employee;
	
	private List<Country> countries;
	
	private List<Department> departmentList;
	
	private Long selectedDepartmentID; 
	
	private List<DepartmentSection> departmentSections;
	
	private DepartmentSection selectedDepartmentSection;
	
	private List<Establishment> establishments;
	
	private List<JobTitleType> jobTitleTypes;
	
	private Gender[] genders;
	
	private MaritalStatus[] maritalStatus;
	
	private Active[] active;
	
	private EmployeeType[] employeeTypes;
	
	private DocumentType[] documentTypes;
	
	private UploadedFile image;
	
	private boolean skip;
	
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
	
	public void onDepartmentSelect(){
		if(selectedDepartmentID != null && selectedDepartmentID!=0)
			departmentSections = almabaniFacade.getDepartmentSections(almabaniFacade.getDepartment(selectedDepartmentID));
		else
			departmentSections = null;
	}
	
	public String extractFromBundle(String key){
		return WebUtils.extractFromBundle(key);
	}
	byte[] imageBytes= null;
	public void handleFileUpload(FileUploadEvent event) {
        image = event.getFile();
        
    	InputStream imageSource;
		try {
			imageSource = image.getInputstream();
			imageBytes = IOUtils.toByteArray(imageSource);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	public void save(){
		
        try {
        	employee.setRegistrationDate(new Date());
        	employee.setLastModificationDate(new Date());
        	employee.setModificationMakerName("Register");
            almabaniFacade.saveOrUpdate(employee);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
    
	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
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
	 * @return the selectedDepartmentID
	 */
	public Long getSelectedDepartmentID() {
		return selectedDepartmentID;
	}

	/**
	 * @param selectedDepartmentID the selectedDepartmentID to set
	 */
	public void setSelectedDepartmentID(Long selectedDepartmentID) {
		this.selectedDepartmentID = selectedDepartmentID;
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
	 * @return the image
	 */
	public UploadedFile getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(UploadedFile image) {
		this.image = image;
	}
	
	/**
	 * @return the skip
	 */
	public boolean isSkip() {
		return skip;
	}

	/**
	 * @param skip the skip to set
	 */
	public void setSkip(boolean skip) {
		this.skip = skip;
	}
}
