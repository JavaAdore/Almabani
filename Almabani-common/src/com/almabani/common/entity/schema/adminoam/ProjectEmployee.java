package com.almabani.common.entity.schema.adminoam;

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
import com.almabani.common.entity.schema.admincor.Employee;
import com.almabani.common.entity.schema.admincor.Project;
import com.almabani.common.enums.EmployeeContractType;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINOAM", name = "OAM_PROJECT_EMPLOYEES")
@SequenceGenerator(name = "OamProjectEmp_Id_Seq_Gen", sequenceName = "ADMINOAM.OAM_SEQ_NUM_PROJECT_EMPLOYEE", allocationSize = 1, initialValue = 1)
public class ProjectEmployee extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 8919380638917643613L;

	@Id
	@Column(name = "NUM_PROJECT_EMPLOYEE", unique = true, nullable = false, precision = 6, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OamProjectEmp_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "NUM_TYPE_ALLOCATION", referencedColumnName="NUM_TYPE_ALLOCATION", nullable = false)
	private AllocationType allocationType;
	
	@ManyToOne
	@JoinColumn(name = "NUM_PROJECT_JOB_TITLE", referencedColumnName="NUM_PROJECT_JOB_TITLE", nullable = false)
	private ProjectJobTitle projectJobTitle;
	
	@ManyToOne
	@JoinColumn(name = "NUM_PROJECT", referencedColumnName="NUM_PROJECT", nullable = false)
	private Project project;
	
	@ManyToOne
	@JoinColumn(name = "COD_EMPLOYEE", referencedColumnName="COD_EMPLOYEE", nullable = false)
	private Employee employee;
	
//	@Convert(converter = EmployeeContractTypeConverter.class)
	@Enumerated(EnumType.STRING)
	@Column(name = "IND_TYPE_EMP_CONTR", nullable = false, length = 1)
	private EmployeeContractType employeeContractType;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_BEGIN_VALIDITY", nullable = false, length = 7)
	private Date validityBeginDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_END_VALIDITY", length = 7)
	private Date validityEndDate;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;

	public ProjectEmployee() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the allocationType
	 */
	public AllocationType getAllocationType() {
		return allocationType;
	}

	/**
	 * @param allocationType the allocationType to set
	 */
	public void setAllocationType(AllocationType allocationType) {
		this.allocationType = allocationType;
	}

	/**
	 * @return the projectJobTitle
	 */
	public ProjectJobTitle getProjectJobTitle() {
		return projectJobTitle;
	}

	/**
	 * @param projectJobTitle the projectJobTitle to set
	 */
	public void setProjectJobTitle(ProjectJobTitle projectJobTitle) {
		this.projectJobTitle = projectJobTitle;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
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
	 * @return the employeeContractType
	 */
	public EmployeeContractType getEmployeeContractType() {
		return employeeContractType;
	}

	/**
	 * @param employeeContractType the employeeContractType to set
	 */
	public void setEmployeeContractType(EmployeeContractType employeeContractType) {
		this.employeeContractType = employeeContractType;
	}

	/**
	 * @return the validityBeginDate
	 */
	public Date getValidityBeginDate() {
		return validityBeginDate;
	}

	/**
	 * @param validityBeginDate the validityBeginDate to set
	 */
	public void setValidityBeginDate(Date validityBeginDate) {
		this.validityBeginDate = validityBeginDate;
	}

	/**
	 * @return the validityEndDate
	 */
	public Date getValidityEndDate() {
		return validityEndDate;
	}

	/**
	 * @param validityEndDate the validityEndDate to set
	 */
	public void setValidityEndDate(Date validityEndDate) {
		this.validityEndDate = validityEndDate;
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
	
}
