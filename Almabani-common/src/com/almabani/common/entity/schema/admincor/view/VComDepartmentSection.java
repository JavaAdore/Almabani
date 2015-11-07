/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.almabani.common.entity.schema.admincor.view;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Subselect;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Employee;

/**
 * 
 * @author orcl
 */
@Entity
@Subselect("select * from admincor.V_COM_DEP_SECTIONS")
public class VComDepartmentSection implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "NUM_DEP_SECTION")
	private Long departmentSectionNumber;
	@Basic(optional = false)
	@NotNull
	@Column(name = "NUM_DEPARTMENT")
	private Long departmentNumber;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 15)
	@Column(name = "COD_DEPARTMENT")
	private String deaprtmentCode;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 40)
	@Column(name = "NAM_DEPARTMENT")
	private String departmentName;

	@ManyToOne
	@JoinColumn(name = "NUM_COMPANY", referencedColumnName = "NUM_COMPANY")
	private Company company;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 15)
	@Column(name = "COD_SECTION")
	private String sectionCode;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 40)
	@Column(name = "NAM_SECTION")
	private String sectionNumber;
	@Size(max = 4)
	@Column(name = "IND_ACTIVE")
	private String indActive;

	@ManyToOne
	@JoinColumn(name = "COD_USER_RESPONSIBLE", referencedColumnName = "COD_EMPLOYEE")
	private Employee responsibleEmployee;

	@Basic(optional = false)
	@NotNull
	@Column(name = "DAT_LAST_MODIFY")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModificationDate;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 10)
	@Column(name = "NAM_USER_MODIFY")
	private String modifiedByUserName;

	@Formula(" (select COUNT(adminoam.OAM_PROJECT_EMPLOYEES.NUM_PROJECT_EMPLOYEE  ) FROM adminoam.OAM_PROJECT_EMPLOYEES  ,admincor.COM_EMPLOYEES  ,   ADMINCOR.COM_DEP_SECTIONS  WHERE  adminoam.OAM_PROJECT_EMPLOYEES.COD_EMPLOYEE = admincor.COM_EMPLOYEES.COD_EMPLOYEE and admincor.COM_EMPLOYEES.NUM_DEP_SECTION = ADMINCOR.COM_DEP_SECTIONS.NUM_DEP_SECTION and  adminoam.OAM_PROJECT_EMPLOYEES.IND_TYPE_EMP_CONTR = 'S' and admincor.COM_EMPLOYEES.NUM_DEP_SECTION = NUM_DEP_SECTION )")
	public Long numberOfSupportEmployees;

	@Formula(value = "(select COUNT(adminoam.OAM_PROJECT_EMPLOYEES.NUM_PROJECT_EMPLOYEE  ) FROM adminoam.OAM_PROJECT_EMPLOYEES  ,admincor.COM_EMPLOYEES  ,   ADMINCOR.COM_DEP_SECTIONS  WHERE  adminoam.OAM_PROJECT_EMPLOYEES.COD_EMPLOYEE = admincor.COM_EMPLOYEES.COD_EMPLOYEE and admincor.COM_EMPLOYEES.NUM_DEP_SECTION = ADMINCOR.COM_DEP_SECTIONS.NUM_DEP_SECTION and  adminoam.OAM_PROJECT_EMPLOYEES.IND_TYPE_EMP_CONTR = 'C' and admincor.COM_EMPLOYEES.NUM_DEP_SECTION = NUM_DEP_SECTION )")
	public Long numberOfContractEmployees;
    
	@Formula(value = "(select COUNT(adminoam.OAM_PROJECT_EMPLOYEES.NUM_PROJECT_EMPLOYEE  ) FROM adminoam.OAM_PROJECT_EMPLOYEES  ,admincor.COM_EMPLOYEES  ,   ADMINCOR.COM_DEP_SECTIONS  WHERE  adminoam.OAM_PROJECT_EMPLOYEES.COD_EMPLOYEE = admincor.COM_EMPLOYEES.COD_EMPLOYEE and admincor.COM_EMPLOYEES.NUM_DEP_SECTION = ADMINCOR.COM_DEP_SECTIONS.NUM_DEP_SECTION  and admincor.COM_EMPLOYEES.NUM_DEP_SECTION = NUM_DEP_SECTION )")
	public Long numberOfAllEmployees;

	public Long getDepartmentSectionNumber() {
		return departmentSectionNumber;
	}

	public void setDepartmentSectionNumber(Long departmentSectionNumber) {
		this.departmentSectionNumber = departmentSectionNumber;
	}

	public Long getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(Long departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	public String getDeaprtmentCode() {
		return deaprtmentCode;
	}

	public void setDeaprtmentCode(String deaprtmentCode) {
		this.deaprtmentCode = deaprtmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getSectionCode() {
		return sectionCode;
	}

	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	public String getSectionNumber() {
		return sectionNumber;
	}

	public void setSectionNumber(String sectionNumber) {
		this.sectionNumber = sectionNumber;
	}

	public String getIndActive() {
		return indActive;
	}

	public void setIndActive(String indActive) {
		this.indActive = indActive;
	}

	public Employee getResponsibleEmployee() {
		return responsibleEmployee;
	}

	public void setResponsibleEmployee(Employee responsibleEmployee) {
		this.responsibleEmployee = responsibleEmployee;
	}

	public Date getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	public String getModifiedByUserName() {
		return modifiedByUserName;
	}

	public void setModifiedByUserName(String modifiedByUserName) {
		this.modifiedByUserName = modifiedByUserName;
	}

	public Long getNumberOfSupportEmployees() {
		return numberOfSupportEmployees;
	}

	public void setNumberOfSupportEmployees(Long numberOfSupportEmployees) {
		this.numberOfSupportEmployees = numberOfSupportEmployees;
	}

	public Long getNumberOfAllEmployees() {
		return numberOfAllEmployees;
	}

	public void setNumberOfAllEmployees(Long numberOfAllEmployees) {
		this.numberOfAllEmployees = numberOfAllEmployees;
	}

	public Long getNumberOfContractEmployees() {
		return numberOfContractEmployees;
	}

	public void setNumberOfContractEmployees(Long numberOfContractEmployees) {
		this.numberOfContractEmployees = numberOfContractEmployees;
	}

	// public Long getNumberOfContractEmployees() {
	// return numberOfContractEmployees;
	// }
	//
	// public void setNumberOfContractEmployees(Long numberOfContractEmployees)
	// {
	// this.numberOfContractEmployees = numberOfContractEmployees;
	// }

}
