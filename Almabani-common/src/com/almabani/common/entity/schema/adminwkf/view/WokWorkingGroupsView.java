/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.almabani.common.entity.schema.adminwkf.view;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Subselect;

import com.almabani.common.entity.AbstractEntity;

/**
 * 
 * @author orcl
 */
@Entity
@Subselect("SELECT * FROM ADMINWKF.V_WOK_WORKING_GROUPS")
public class WokWorkingGroupsView extends AbstractEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NUM_WORKING_GROUP")
	private Long numWorkingGroup;

	@Column(name = "NUM_COMPANY")
	private Long companyNumber;

	@Column(name = "NAM_COMPANY")
	private String companyBame;

	@Column(name = "NUM_PROJECT")
	private Long projectNumber;

	@Column(name = "COD_PROJECT")
	private String projectCode;

	@Column(name = "NAM_DEPARTMENT")
	private String departmentName;

	@Column(name = "NAM_SECTION")
	private String sectionName;

	@Column(name = "NUM_TYPE_GROUP")
	private String groupTypeNumber;

	@Column(name = "DES_TYPE_GROUP")
	private String groupTypeDescription;

	@Column(name = "COD_WORKING_GROUP")
	private String workingGroupCode;

	@Column(name = "DES_WORKING_GROUP")
	private String desWorkingGroup;

	@Column(name = "DAT_BEGIN_VALIDITY")
	@Temporal(TemporalType.TIMESTAMP)
	private Date validityBeginDate;

	@Column(name = "DAT_END_VALIDITY")
	@Temporal(TemporalType.TIMESTAMP)
	private Date validityEndDate;

	@Column(name = "NAM_USER_MODIFY")
	private String userModifiedName;

	@Column(name = "DAT_LAST_MODIFY")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModificationDate;

	@Column(name = "DAT_HOUR_START_OPERATION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startOperateionHour;

	@Column(name = "DAT_HOUR_END_OPERATION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endOperationHour;

	@Column(name = "IND_TYPE_WORKING_DAYS")
	private String workingDaysTypeInd;

	public Long getCompanyNumber() {
		return companyNumber;
	}

	public void setCompanyNumber(Long companyNumber) {
		this.companyNumber = companyNumber;
	}

	public String getCompanyBame() {
		return companyBame;
	}

	public void setCompanyBame(String companyBame) {
		this.companyBame = companyBame;
	}

	public Long getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(Long projectNumber) {
		this.projectNumber = projectNumber;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getGroupTypeNumber() {
		return groupTypeNumber;
	}

	public void setGroupTypeNumber(String groupTypeNumber) {
		this.groupTypeNumber = groupTypeNumber;
	}

	public String getGroupTypeDescription() {
		return groupTypeDescription;
	}

	public void setGroupTypeDescription(String groupTypeDescription) {
		this.groupTypeDescription = groupTypeDescription;
	}

	public Long getNumWorkingGroup() {
		return numWorkingGroup;
	}

	public void setNumWorkingGroup(Long numWorkingGroup) {
		this.numWorkingGroup = numWorkingGroup;
	}

	public String getWorkingGroupCode() {
		return workingGroupCode;
	}

	public void setWorkingGroupCode(String workingGroupCode) {
		this.workingGroupCode = workingGroupCode;
	}

	public String getDesWorkingGroup() {
		return desWorkingGroup;
	}

	public void setDesWorkingGroup(String desWorkingGroup) {
		this.desWorkingGroup = desWorkingGroup;
	}

	public Date getValidityBeginDate() {
		return validityBeginDate;
	}

	public void setValidityBeginDate(Date validityBeginDate) {
		this.validityBeginDate = validityBeginDate;
	}

	public Date getValidityEndDate() {
		return validityEndDate;
	}

	public void setValidityEndDate(Date validityEndDate) {
		this.validityEndDate = validityEndDate;
	}

	public String getUserModifiedName() {
		return userModifiedName;
	}

	public void setUserModifiedName(String userModifiedName) {
		this.userModifiedName = userModifiedName;
	}

	public Date getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	public Date getStartOperateionHour() {
		return startOperateionHour;
	}

	public void setStartOperateionHour(Date startOperateionHour) {
		this.startOperateionHour = startOperateionHour;
	}

	public Date getEndOperationHour() {
		return endOperationHour;
	}

	public void setEndOperationHour(Date endOperationHour) {
		this.endOperationHour = endOperationHour;
	}

	public String getWorkingDaysTypeInd() {
		return workingDaysTypeInd;
	}

	public void setWorkingDaysTypeInd(String workingDaysTypeInd) {
		this.workingDaysTypeInd = workingDaysTypeInd;
	}

	public static Long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public Long getId() {
		return numWorkingGroup;
	}

	@Override
	public void setId(Long i) {
		numWorkingGroup = i;
	}

}
