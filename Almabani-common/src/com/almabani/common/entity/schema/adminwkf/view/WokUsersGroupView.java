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
@Subselect("SELECT * FROM ADMINWKF.V_WOK_USERS_GROUP ")
public class WokUsersGroupView extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NUM_USER_GROUP")
	private Long userGroupNumber;

	@Column(name = "NUM_COMPANY")
	private Long companyNumber;

	@Column(name = "NAM_COMPANY")
	private String companyName;

	@Column(name = "NAM_DEPARTMENT")
	private String departmentName;

	@Column(name = "NAM_SECTION")
	private String sectionName;

	@Column(name = "COD_USER_LOGIN")
	private String loginUserCode;

	@Column(name = "COD_EMPLOYEE")
	private Long employeeCode;

	@Column(name = "NAM_EMPLOYEE")
	private String employeeName;

	@Column(name = "NUM_WORKING_GROUP")
	private Long workingGroupNumber;

	@Column(name = "DES_WORKING_GROUP")
	private String workingGroupDescription;

	@Column(name = "NUM_TYPE_PROFILE")
	private Long profileTypeNumber;

	@Column(name = "DES_TYPE_PROFILE")
	private String profileTypeDescription;

	@Column(name = "DAT_BEGIN_VALIDITY")
	@Temporal(TemporalType.TIMESTAMP)
	private Date beginDateValidity;
	
	@Column(name = "DAT_END_VALIDITY")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDateValidity;

	@Column(name = "NAM_USER_MODIFY")
	private String userModifiedName;

	@Column(name = "DAT_LAST_MODIFY")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModificationDate;

	@Column(name = "IND_RESPONSIBLE_GROUP")
	private String esponsibleGroupInd;

	@Column(name = "IND_RECEIVE_NOTIFICATION")
	private String receiveNotificationInd;

	@Column(name = "IND_INTERACTION_DEMANDS")
	private String interactionDemandsInd;

	public Long getUserGroupNumber() {
		return userGroupNumber;
	}

	public void setUserGroupNumber(Long userGroupNumber) {
		this.userGroupNumber = userGroupNumber;
	}

	public Long getCompanyNumber() {
		return companyNumber;
	}

	public void setCompanyNumber(Long companyNumber) {
		this.companyNumber = companyNumber;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public String getLoginUserCode() {
		return loginUserCode;
	}

	public void setLoginUserCode(String loginUserCode) {
		this.loginUserCode = loginUserCode;
	}

	public Long getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(Long employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Long getWorkingGroupNumber() {
		return workingGroupNumber;
	}

	public void setWorkingGroupNumber(Long workingGroupNumber) {
		this.workingGroupNumber = workingGroupNumber;
	}

	public String getWorkingGroupDescription() {
		return workingGroupDescription;
	}

	public void setWorkingGroupDescription(String workingGroupDescription) {
		this.workingGroupDescription = workingGroupDescription;
	}

	public Long getProfileTypeNumber() {
		return profileTypeNumber;
	}

	public void setProfileTypeNumber(Long profileTypeNumber) {
		this.profileTypeNumber = profileTypeNumber;
	}

	public String getProfileTypeDescription() {
		return profileTypeDescription;
	}

	public void setProfileTypeDescription(String profileTypeDescription) {
		this.profileTypeDescription = profileTypeDescription;
	}

	public Date getBeginDateValidity() {
		return beginDateValidity;
	}

	public void setBeginDateValidity(Date beginDateValidity) {
		this.beginDateValidity = beginDateValidity;
	}

	public Date getEndDateValidity() {
		return endDateValidity;
	}

	public void setEndDateValidity(Date endDateValidity) {
		this.endDateValidity = endDateValidity;
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

	public String getEsponsibleGroupInd() {
		return esponsibleGroupInd;
	}

	public void setEsponsibleGroupInd(String esponsibleGroupInd) {
		this.esponsibleGroupInd = esponsibleGroupInd;
	}

	public String getReceiveNotificationInd() {
		return receiveNotificationInd;
	}

	public void setReceiveNotificationInd(String receiveNotificationInd) {
		this.receiveNotificationInd = receiveNotificationInd;
	}

	public String getInteractionDemandsInd() {
		return interactionDemandsInd;
	}

	public void setInteractionDemandsInd(String interactionDemandsInd) {
		this.interactionDemandsInd = interactionDemandsInd;
	}

	@Override
	public Long getId() {
		return userGroupNumber;
	}

	@Override
	public void setId(Long i) {
		userGroupNumber = i;
	}

}
