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
import org.hibernate.annotations.Type;

import com.almabani.common.entity.AbstractEntity;

/**
 * 
 * @author orcl
 */
@Entity
@Subselect("select * from adminwkf.V_WOK_DAILY_OCURRENCES")
public class WokDailyOcurrencesView extends AbstractEntity implements Serializable {

	@Id
	@Column(name = "NUM_DAILY_OCCURRENCE")
	private Long dailyOccurrenceNumber;

	@Column(name = "DAT_TIME_OCCURRENCE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date occurrenceDate;

	@Column(name = "NUM_WORKING_GROUP")
	private Long workingGroupNumber;

	@Column(name = "DES_WORKING_GROUP")
	private String workingGroupDescription;

	@Column(name = "NUM_USER_GROUP")
	private Long userGroupNumber;

	@Column(name = "COD_USER_LOGIN")
	private String loginUserCode;

	@Column(name = "NAM_EMPLOYEE")
	private String employeeName;

	@Column(name = "NUM_ZONE_DEVICE")
	private Long zoneDeviceNumber;

	@Column(name = "COD_DEVICE")
	private String deviceCode;

	@Column(name = "DES_ZONE")
	private String zoneDescription;

	@Column(name = "DES_SITE_LOCATION")
	private String siteLocationDescription;

	@Column(name = "DES_SITE_DIRECTION")
	private String siteDirectionDescription;
	
	@Column(name = "COD_GPS_LOCATION")
	private String codGpsLocation;

	@Column(name = "DES_SITE")
	private String siteDescription;

	@Column(name = "COD_PROJECT")
	private String projectCode;

	@Column(name = "NUM_COMPANY")
	private Long companyNumber;

	@Column(name = "DES_OCCURRENCE")
	private String occurrenceDescription;

	@Column(name = "NAM_USER_MODIFY")
	private String userModifiedName;

	@Column(name = "DAT_LAST_MODIFY")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModificationName;
	
	@Column(name = "NUM_USER_GROUP_CALL")
	private Long userGroupCallNumber;
	
	@Column(name = "NAM_EMPLOYEE_CALL")
	private String employeeCallName;

	@Column(name = "NUM_USER_GROUP_SAFETY")
	private Long numUserGroupSafety;

	@Column(name = "NAM_EMPLOYEE_SAFETY")
	private String employeeSaftyName;

	@Column(name = "NUM_USER_GROUP_TECHNICIAN")
	private Long userGroupTechnicanNumber;

	@Column(name = "NAM_EMPLOYEE_TECHNICIAN")
	private String employeeTechnicianName;

	@Column(name = "NUM_TYPE_OCCURRENCE")
	private Long occurrenceTypeNumber;

	@Column(name = "DES_TYPE_OCCURRENCE")
	private String occurrenceTypeDescription;

	@Column(name = "DAT_TIME_RESPONSE")
	@Type(type="timestamp") 
	private Date responseTime;       

	@Column(name = "DAT_TIME_CLOSING")
	@Temporal(TemporalType.TIMESTAMP)
	private Date closingTime;

	@Column(name = "DES_ACTION_TAKEN")
	private String actionTakedDescription;

	@Column(name = "DES_IND_CONTACT_POLICE")
	private String contactPoliceDescriptionInd;

	@Column(name = "DES_IND_CONTACT_AMBULANCE")
	private String contactAmbulanceDescriptionInd;

	@Column(name = "DES_IND_CONTACT_INSURANCE")
	private String CxntactInsuranceDescriptoinInd;

	@Column(name = "DES_IND_CONTACT_TRANSIT")
	private String contactTransitDescriptionInd;

	
	private static final long serialVersionUID = 1L;

	public Long getDailyOccurrenceNumber() {
		return dailyOccurrenceNumber;
	}

	public void setDailyOccurrenceNumber(Long dailyOccurrenceNumber) {
		this.dailyOccurrenceNumber = dailyOccurrenceNumber;
	}

	public Date getOccurrenceDate() {
		return occurrenceDate;
	}

	public void setOccurrenceDate(Date occurrenceDate) {
		this.occurrenceDate = occurrenceDate;
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

	public Long getUserGroupNumber() {
		return userGroupNumber;
	}

	public void setUserGroupNumber(Long userGroupNumber) {
		this.userGroupNumber = userGroupNumber;
	}

	public String getLoginUserCode() {
		return loginUserCode;
	}

	public void setLoginUserCode(String loginUserCode) {
		this.loginUserCode = loginUserCode;
	}


	public Long getZoneDeviceNumber() {
		return zoneDeviceNumber;
	}

	public void setZoneDeviceNumber(Long zoneDeviceNumber) {
		this.zoneDeviceNumber = zoneDeviceNumber;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public String getZoneDescription() {
		return zoneDescription;
	}

	public void setZoneDescription(String zoneDescription) {
		this.zoneDescription = zoneDescription;
	}

	public String getSiteLocationDescription() {
		return siteLocationDescription;
	}

	public void setSiteLocationDescription(String siteLocationDescription) {
		this.siteLocationDescription = siteLocationDescription;
	}

	public String getSiteDirectionDescription() {
		return siteDirectionDescription;
	}

	public void setSiteDirectionDescription(String siteDirectionDescription) {
		this.siteDirectionDescription = siteDirectionDescription;
	}

	public String getCodGpsLocation() {
		return codGpsLocation;
	}

	public void setCodGpsLocation(String codGpsLocation) {
		this.codGpsLocation = codGpsLocation;
	}

	public String getSiteDescription() {
		return siteDescription;
	}

	public void setSiteDescription(String siteDescription) {
		this.siteDescription = siteDescription;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public Long getCompanyNumber() {
		return companyNumber;
	}

	public void setCompanyNumber(Long companyNumber) {
		this.companyNumber = companyNumber;
	}

	public String getOccurrenceDescription() {
		return occurrenceDescription;
	}

	public void setOccurrenceDescription(String occurrenceDescription) {
		this.occurrenceDescription = occurrenceDescription;
	}

	public String getUserModifiedName() {
		return userModifiedName;
	}

	public void setUserModifiedName(String userModifiedName) {
		this.userModifiedName = userModifiedName;
	}

	public Date getLastModificationName() {
		return lastModificationName;
	}

	public void setLastModificationName(Date lastModificationName) {
		this.lastModificationName = lastModificationName;
	}

	public Long getUserGroupCallNumber() {
		return userGroupCallNumber;
	}

	public void setUserGroupCallNumber(Long userGroupCallNumber) {
		this.userGroupCallNumber = userGroupCallNumber;
	}

	

	public Long getNumUserGroupSafety() {
		return numUserGroupSafety;
	}

	public void setNumUserGroupSafety(Long numUserGroupSafety) {
		this.numUserGroupSafety = numUserGroupSafety;
	}

	

	public Long getUserGroupTechnicanNumber() {
		return userGroupTechnicanNumber;
	}

	public void setUserGroupTechnicanNumber(Long userGroupTechnicanNumber) {
		this.userGroupTechnicanNumber = userGroupTechnicanNumber;
	}

	
	public Long getOccurrenceTypeNumber() {
		return occurrenceTypeNumber;
	}

	public void setOccurrenceTypeNumber(Long occurrenceTypeNumber) {
		this.occurrenceTypeNumber = occurrenceTypeNumber;
	}

	public String getOccurrenceTypeDescription() {
		return occurrenceTypeDescription;
	}

	public void setOccurrenceTypeDescription(String occurrenceTypeDescription) {
		this.occurrenceTypeDescription = occurrenceTypeDescription;
	}

	public Date getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Date responseTime) {
		this.responseTime = responseTime;
	}

	public Date getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(Date closingTime) {
		this.closingTime = closingTime;
	}

	public String getActionTakedDescription() {
		return actionTakedDescription;
	}

	public void setActionTakedDescription(String actionTakedDescription) {
		this.actionTakedDescription = actionTakedDescription;
	}

	public String getContactPoliceDescriptionInd() {
		return contactPoliceDescriptionInd;
	}

	public void setContactPoliceDescriptionInd(String contactPoliceDescriptionInd) {
		this.contactPoliceDescriptionInd = contactPoliceDescriptionInd;
	}

	public String getContactAmbulanceDescriptionInd() {
		return contactAmbulanceDescriptionInd;
	}

	public void setContactAmbulanceDescriptionInd(
			String contactAmbulanceDescriptionInd) {
		this.contactAmbulanceDescriptionInd = contactAmbulanceDescriptionInd;
	}

	public String getCxntactInsuranceDescriptoinInd() {
		return CxntactInsuranceDescriptoinInd;
	}

	public void setCxntactInsuranceDescriptoinInd(
			String cxntactInsuranceDescriptoinInd) {
		CxntactInsuranceDescriptoinInd = cxntactInsuranceDescriptoinInd;
	}

	public String getContactTransitDescriptionInd() {
		return contactTransitDescriptionInd;
	}

	public void setContactTransitDescriptionInd(String contactTransitDescriptionInd) {
		this.contactTransitDescriptionInd = contactTransitDescriptionInd;
	}

	@Override
	public Long getId() {
		return dailyOccurrenceNumber;
	}

	@Override
	public void setId(Long i) {
		dailyOccurrenceNumber = i;		
	}

	public String getEmployeeCallName() {
		return employeeCallName;
	}

	public void setEmployeeCallName(String employeeCallName) {
		this.employeeCallName = employeeCallName;
	}

	public String getEmployeeSaftyName() {
		return employeeSaftyName;
	}

	public void setEmployeeSaftyName(String employeeSaftyName) {
		this.employeeSaftyName = employeeSaftyName;
	}

	public String getEmployeeTechnicianName() {
		return employeeTechnicianName;
	}

	public void setEmployeeTechnicianName(String employeeTechnicianName) {
		this.employeeTechnicianName = employeeTechnicianName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	
}
