package com.almabani.common.entity.schema.admincor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.almabani.common.entity.AbstractEntity;
import com.almabani.common.enums.Active;
import com.almabani.common.enums.DocumentType;
import com.almabani.common.enums.EmployeeType;
import com.almabani.common.enums.Gender;
import com.almabani.common.enums.MaritalStatus;
import com.almabani.common.interfaces.ByteArrayHolder;

@Entity
@Table( schema="ADMINCOR",name = "COM_EMPLOYEES")
@SequenceGenerator(name = "ComEmployees_Id_Seq_Gen", sequenceName = "ADMINCOR.COM_EMPLOYEES_ID_SEQ_GEN")
public class Employee extends AbstractEntity implements ByteArrayHolder, Serializable {
	
	private static final long serialVersionUID = -9109549932466687734L;

	@Id
	@Column(name = "COD_EMPLOYEE", unique = true, nullable = false, precision = 15, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ComEmployees_Id_Seq_Gen")
    private Long id;
	
	@ManyToOne
    @JoinColumn(name = "NUM_DEP_SECTION" , referencedColumnName ="NUM_DEP_SECTION")
    private DepartmentSection departmentSection;
	
	@ManyToOne
    @JoinColumn(name = "NUM_ESTABLISHMENT" , referencedColumnName="NUM_ESTABLISHMENT")
	private Establishment establishment;
	
	@ManyToOne
    @JoinColumn(name = "NUM_TYPE_JOB_TITLE" , referencedColumnName="NUM_TYPE_JOB_TITLE")
	private JobTitleType jobTitleType;   
	
	@ManyToOne
    @JoinColumn(name = "NUM_COUNTRY_NATIONALITY",referencedColumnName="NUM_COUNTRY")
	private Country country;
	
	@Column(name = "COD_IDENTITY_FEDERAL", nullable = false, length = 30)
	private String federalIdentityCode;
	
	@Column(name = "NAM_EMPLOYEE", nullable = false, length = 100)
	private String employeeName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_REGISTRATION", nullable = false, length = 7)
	private Date registrationDate;
	
	@Column(name = "COD_IDENTITY_STATE", length = 30)
	private String stateIdentityCode;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_BIRTH", length = 7)
	private Date birthDate;
	
//	@Convert(converter = GenderConverter.class)
	@Enumerated(EnumType.STRING)
	@Column(name = "IND_GENDER", length = 1)
	private Gender gender;
	
//	@Convert(converter = MaritalStatusConverter.class)
	@Enumerated(EnumType.STRING)
	@Column(name = "IND_MARITAL_STATUS", length = 1)
	private MaritalStatus maritalStatus;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_ADMISSION", length = 7)
	private Date admissionDate;
	
	@Column(name = "DES_OBSERVATION", length = 300)
	private String observationDescription;
	
//	@Convert(converter = ActiveConverter.class)
	@Enumerated(EnumType.STRING)
	@Column(name = "IND_ACTIVE", nullable = false, length = 1)
	private Active active;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_BEGIN_INACTIVITY", length = 7)
	private Date inactivityBeginDate;
	
//	@Convert(converter = EmployeeTypeConverter.class)
	@Enumerated(EnumType.STRING)
	@Column(name = "IND_TYPE_EMPLOYEE", length = 1)
	private EmployeeType employeeType;
	
	@Column(name = "DES_EMAIL_1", length = 80)
	private String email1Description;
	
	@Column(name = "DES_EMAIL_2", length = 80)
	private String email2Description;
	
	@Column(name = "NUM_DDI_TELEFONE", precision = 3, scale = 0)
	private Integer ddiTelephoneNumber;
	
	@Column(name = "NUM_DDD_TELEFONE", precision = 3, scale = 0)
	private Integer dddTelephoneNumber;
	
	@Column(name = "NUM_TELEFONE", precision = 10, scale = 0)
	private Long telephoneNumber;
	
	@Column(name = "NUM_DDI_MOBILE", precision = 3, scale = 0)
	private Integer ddiMobileNumber;
	
	@Column(name = "NUM_DDD_MOBILE", precision = 3, scale = 0)
	private Integer dddMobileNumber;
	
	@Column(name = "NUM_MOBILE", precision = 10, scale = 0)
	private Long mobileNumber;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;
	
//	@Convert(converter = DocumentTypeConverter.class)
	@Enumerated(EnumType.STRING)
	@Column(name = "IND_TYPE_DOCUMENT", length = 1)
	private DocumentType indTypeDocument;
	
	@Column(name = "IMG_EMPLOYEE")
	private byte[] employeeImage;

	public Employee() {
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the departmentSection
	 */
	public DepartmentSection getDepartmentSection() {
		return departmentSection;
	}

	/**
	 * @param departmentSection the departmentSection to set
	 */
	public void setDepartmentSection(DepartmentSection departmentSection) {
		this.departmentSection = departmentSection;
	}

	/**
	 * @return the establishment
	 */
	public Establishment getEstablishment() {
		return establishment;
	}

	/**
	 * @param establishment the establishment to set
	 */
	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}

	/**
	 * @return the jobTitleType
	 */
	public JobTitleType getJobTitleType() {
		return jobTitleType;
	}

	/**
	 * @param jobTitleType the jobTitleType to set
	 */
	public void setJobTitleType(JobTitleType jobTitleType) {
		this.jobTitleType = jobTitleType;
	}

	/**
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	/**
	 * @return the federalIdentityCode
	 */
	public String getFederalIdentityCode() {
		return federalIdentityCode;
	}

	/**
	 * @param federalIdentityCode the federalIdentityCode to set
	 */
	public void setFederalIdentityCode(String federalIdentityCode) {
		this.federalIdentityCode = federalIdentityCode;
	}

	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the registrationDate
	 */
	public Date getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * @param registrationDate the registrationDate to set
	 */
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * @return the stateIdentityCode
	 */
	public String getStateIdentityCode() {
		return stateIdentityCode;
	}

	/**
	 * @param stateIdentityCode the stateIdentityCode to set
	 */
	public void setStateIdentityCode(String stateIdentityCode) {
		this.stateIdentityCode = stateIdentityCode;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return the maritalStatus
	 */
	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	/**
	 * @param maritalStatus the maritalStatus to set
	 */
	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	/**
	 * @return the admissionDate
	 */
	public Date getAdmissionDate() {
		return admissionDate;
	}

	/**
	 * @param admissionDate the admissionDate to set
	 */
	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	/**
	 * @return the observationDescription
	 */
	public String getObservationDescription() {
		return observationDescription;
	}

	/**
	 * @param observationDescription the observationDescription to set
	 */
	public void setObservationDescription(String observationDescription) {
		this.observationDescription = observationDescription;
	}
	
	/**
	 * @return the active
	 */
	public Active getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(Active active) {
		this.active = active;
	}

	/**
	 * @return the inactivityBeginDate
	 */
	public Date getInactivityBeginDate() {
		return inactivityBeginDate;
	}

	/**
	 * @param inactivityBeginDate the inactivityBeginDate to set
	 */
	public void setInactivityBeginDate(Date inactivityBeginDate) {
		this.inactivityBeginDate = inactivityBeginDate;
	}
	
	/**
	 * @return the employeeType
	 */
	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	/**
	 * @param employeeType the employeeType to set
	 */
	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	/**
	 * @return the email1Description
	 */
	public String getEmail1Description() {
		return email1Description;
	}

	/**
	 * @param email1Description the email1Description to set
	 */
	public void setEmail1Description(String email1Description) {
		this.email1Description = email1Description;
	}

	/**
	 * @return the email2Description
	 */
	public String getEmail2Description() {
		return email2Description;
	}

	/**
	 * @param email2Description the email2Description to set
	 */
	public void setEmail2Description(String email2Description) {
		this.email2Description = email2Description;
	}

	/**
	 * @return the ddiTelephoneNumber
	 */
	public Integer getDdiTelephoneNumber() {
		return ddiTelephoneNumber;
	}

	/**
	 * @param ddiTelephoneNumber the ddiTelephoneNumber to set
	 */
	public void setDdiTelephoneNumber(Integer ddiTelephoneNumber) {
		this.ddiTelephoneNumber = ddiTelephoneNumber;
	}

	/**
	 * @return the dddTelephoneNumber
	 */
	public Integer getDddTelephoneNumber() {
		return dddTelephoneNumber;
	}

	/**
	 * @param dddTelephoneNumber the dddTelephoneNumber to set
	 */
	public void setDddTelephoneNumber(Integer dddTelephoneNumber) {
		this.dddTelephoneNumber = dddTelephoneNumber;
	}

	/**
	 * @return the telephoneNumber
	 */
	public Long getTelephoneNumber() {
		return telephoneNumber;
	}

	/**
	 * @param telephoneNumber the telephoneNumber to set
	 */
	public void setTelephoneNumber(Long telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	/**
	 * @return the ddiMobileNumber
	 */
	public Integer getDdiMobileNumber() {
		return ddiMobileNumber;
	}

	/**
	 * @param ddiMobileNumber the ddiMobileNumber to set
	 */
	public void setDdiMobileNumber(Integer ddiMobileNumber) {
		this.ddiMobileNumber = ddiMobileNumber;
	}

	/**
	 * @return the dddMobileNumber
	 */
	public Integer getDddMobileNumber() {
		return dddMobileNumber;
	}

	/**
	 * @param dddMobileNumber the dddMobileNumber to set
	 */
	public void setDddMobileNumber(Integer dddMobileNumber) {
		this.dddMobileNumber = dddMobileNumber;
	}

	/**
	 * @return the mobileNumber
	 */
	public Long getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the modificationMakerName
	 */
	public String getModificationMakerName() {
		return modificationMakerName;
	}

	/**
	 * @param modificationMakerName the modificationMakerName to set
	 */
	public void setModificationMakerName(String modificationMakerName) {
		this.modificationMakerName = modificationMakerName;
	}

	/**
	 * @return the lastModificationDate
	 */
	public Date getLastModificationDate() {
		return lastModificationDate;
	}

	/**
	 * @param lastModificationDate the lastModificationDate to set
	 */
	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}
	
	/**
	 * @return the indTypeDocument
	 */
	public DocumentType getIndTypeDocument() {
		return indTypeDocument;
	}

	/**
	 * @param indTypeDocument the indTypeDocument to set
	 */
	public void setIndTypeDocument(DocumentType indTypeDocument) {
		this.indTypeDocument = indTypeDocument;
	}
	
	/**
	 * @return the employeeImage
	 */
	public byte[] getEmployeeImage() {
		return employeeImage;
	}

	/**
	 * @param employeeImage the employeeImage to set
	 */
	public void setEmployeeImage(byte[] employeeImage) {
		this.employeeImage = employeeImage;
	}

	@Override
	public String toString() {
		return "ComEmployee [id=" + id + ", employeeName=" + employeeName + "]";
	}

	@Override
	public void setHoldedImage(byte[] blob) {
		setEmployeeImage(blob);
		
	}

	@Override
	public byte[] getHoldedImage() {
		return getEmployeeImage();
	}
}
