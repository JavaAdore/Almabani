package com.almabani.common.entity.schema.adminwkf;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.almabani.common.entity.AbstractEntity;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINWKF", name = "WOK_DEMANDS")
@SequenceGenerator(name = "WokDemands_Id_Seq_Gen", sequenceName = "WOK_DEMANDS_ID_SEQ_GEN", allocationSize = 50, initialValue = 50)
public class WokDemand extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = -8668330372929475449L;
  
	@Id
	@Column(name = "NUM_DEMAND", unique = true, nullable = false, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WokDemands_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "NUM_TYPE_DEMAND", referencedColumnName="NUM_TYPE_DEMAND", nullable = false)
	private WokTypeDemand typeDemand;
//	
//	@ManyToOne
//	@JoinColumn(name = "NUM_PRIORITY", referencedColumnName="NUM_PRIORITY", nullable = false)
//	private WokDemandPriority demandPriority;
//	
//	@ManyToOne
//	@JoinColumn(name = "NUM_USER_GROUP", referencedColumnName="NUM_USER_GROUP", nullable = false)
//	private WokUserGroup userGroup;
//	
//	@ManyToOne
//	@JoinColumn(name = "NUM_TYPE_SYMPTOM", referencedColumnName="NUM_TYPE_SYMPTOM", nullable = false)
//	private WokTypeSymptoms typeSymptoms;
//	
//	@ManyToOne
//	@JoinColumn(name = "NUM_TYPE_IMPACT", referencedColumnName="NUM_TYPE_IMPACT", nullable = false)
//	private WokTypesImpact typesImpact;
//	
//	@Temporal(TemporalType.DATE)
//	@Column(name = "DAT_DEMAND", nullable = false, length = 7)
//	private Date demandDate;
//	
//	@ManyToOne
//	@JoinColumn(name = "NUM_ZONE_DEVICE", referencedColumnName="NUM_ZONE_DEVICE", nullable = false)
//	private OamZoneDevice zoneDevice;
//	
//	/**
//	 * modificationMakerName represent the user name who make the last modification
//	 */
//	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
//	private String modificationMakerName;
//	
//	@Temporal(TemporalType.DATE)
//	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
//	private Date lastModificationDate;
//	
//	@Column(name = "NUM_CONFIGURATION_ITEM", nullable = false, precision = 5, scale = 0)
//	private int configurationItemNumber;
//	
	@Column(name = "DES_SUMMARY_DEMAND", nullable = false, length = 60)
	private String demandSummaryDescription;
	
	@Column(name = "DES_DETAIL_DEMAND", nullable = false, length = 400)
	private String demandDetailDescription;
//	
//	@ManyToOne
//	@JoinColumn(name = "NUM_SITE_LOCATION", referencedColumnName="NUM_SITE_LOCATION", nullable = false)
//	private OamSiteLocation siteLocation;
//	
//	@Temporal(TemporalType.DATE)
//	@Column(name = "DAT_ESTIMATED_CONCLUSION", length = 7)
//	private Date conclusionEstimatedDate;
//	
//	@Temporal(TemporalType.DATE)
//	@Column(name = "DAT_REAL_CONCLUSION", length = 7)
//	private Date conclusionRealDate;
//	
//	@Temporal(TemporalType.DATE)
//	@Column(name = "DAT_VIOLATION_SLA", nullable = false, length = 7)
//	private Date violationSlaDate;
//	
	@Column(name = "NUM_MAXIMO", precision = 10, scale = 0)
	private Long maximoNumber;

	public WokDemand() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the typeDemand
	 */
	public WokTypeDemand getTypeDemand() {
		return typeDemand;
	}

	/**
	 * @param typeDemand the typeDemand to set
	 */
	public void setTypeDemand(WokTypeDemand typeDemand) {
		this.typeDemand = typeDemand;
	}
//
//	/**
//	 * @return the demandPriority
//	 */
//	public WokDemandPriority getDemandPriority() {
//		return demandPriority;
//	}
//
//	/**
//	 * @param demandPriority the demandPriority to set
//	 */
//	public void setDemandPriority(WokDemandPriority demandPriority) {
//		this.demandPriority = demandPriority;
//	}
//
//	/**
//	 * @return the userGroup
//	 */
//	public WokUserGroup getUserGroup() {
//		return userGroup;
//	}
//
//	/**
//	 * @param userGroup the userGroup to set
//	 */
//	public void setUserGroup(WokUserGroup userGroup) {
//		this.userGroup = userGroup;
//	}
//
//	/**
//	 * @return the typeSymptoms
//	 */
//	public WokTypeSymptoms getTypeSymptoms() {
//		return typeSymptoms;
//	}
//
//	/**
//	 * @param typeSymptoms the typeSymptoms to set
//	 */
//	public void setTypeSymptoms(WokTypeSymptoms typeSymptoms) {
//		this.typeSymptoms = typeSymptoms;
//	}
//
//	/**
//	 * @return the typesImpact
//	 */
//	public WokTypesImpact getTypesImpact() {
//		return typesImpact;
//	}
//
//	/**
//	 * @param typesImpact the typesImpact to set
//	 */
//	public void setTypesImpact(WokTypesImpact typesImpact) {
//		this.typesImpact = typesImpact;
//	}
//
//	/**
//	 * @return the demandDate
//	 */
//	public Date getDemandDate() {
//		return demandDate;
//	}
//
//	/**
//	 * @param demandDate the demandDate to set
//	 */
//	public void setDemandDate(Date demandDate) {
//		this.demandDate = demandDate;
//	}
//
//	/**
//	 * @return the zoneDevice
//	 */
//	public OamZoneDevice getZoneDevice() {
//		return zoneDevice;
//	}
//
//	/**
//	 * @param zoneDevice the zoneDevice to set
//	 */
//	public void setZoneDevice(OamZoneDevice zoneDevice) {
//		this.zoneDevice = zoneDevice;
//	}
//
//	/**
//	 * @return the modificationMakerName
//	 */
//	public String getModificationMakerName() {
//		return modificationMakerName;
//	}
//
//	/**
//	 * @param modificationMakerName the modificationMakerName to set
//	 */
//	public void setModificationMakerName(String modificationMakerName) {
//		this.modificationMakerName = modificationMakerName;
//	}
//
//	/**
//	 * @return the lastModificationDate
//	 */
//	public Date getLastModificationDate() {
//		return lastModificationDate;
//	}
//
//	/**
//	 * @param lastModificationDate the lastModificationDate to set
//	 */
//	public void setLastModificationDate(Date lastModificationDate) {
//		this.lastModificationDate = lastModificationDate;
//	}
//
//	/**
//	 * @return the configurationItemNumber
//	 */
//	public int getConfigurationItemNumber() {
//		return configurationItemNumber;
//	}
//
//	/**
//	 * @param configurationItemNumber the configurationItemNumber to set
//	 */
//	public void setConfigurationItemNumber(int configurationItemNumber) {
//		this.configurationItemNumber = configurationItemNumber;
//	}
//
	/**
	 * @return the demandSummaryDescription
	 */
	public String getDemandSummaryDescription() {
		return demandSummaryDescription;
	}

	/**
	 * @param demandSummaryDescription the demandSummaryDescription to set
	 */
	public void setDemandSummaryDescription(String demandSummaryDescription) {
		this.demandSummaryDescription = demandSummaryDescription;
	}

	/**
	 * @return the demandDetailDescription
	 */
	public String getDemandDetailDescription() {
		return demandDetailDescription;
	}

	/**
	 * @param demandDetailDescription the demandDetailDescription to set
	 */
	public void setDemandDetailDescription(String demandDetailDescription) {
		this.demandDetailDescription = demandDetailDescription;
	}
//
//	/**
//	 * @return the siteLocation
//	 */
//	public OamSiteLocation getSiteLocation() {
//		return siteLocation;
//	}
//
//	/**
//	 * @param siteLocation the siteLocation to set
//	 */
//	public void setSiteLocation(OamSiteLocation siteLocation) {
//		this.siteLocation = siteLocation;
//	}
//
//	/**
//	 * @return the conclusionEstimatedDate
//	 */
//	public Date getConclusionEstimatedDate() {
//		return conclusionEstimatedDate;
//	}
//
//	/**
//	 * @param conclusionEstimatedDate the conclusionEstimatedDate to set
//	 */
//	public void setConclusionEstimatedDate(Date conclusionEstimatedDate) {
//		this.conclusionEstimatedDate = conclusionEstimatedDate;
//	}
//
//	/**
//	 * @return the conclusionRealDate
//	 */
//	public Date getConclusionRealDate() {
//		return conclusionRealDate;
//	}
//
//	/**
//	 * @param conclusionRealDate the conclusionRealDate to set
//	 */
//	public void setConclusionRealDate(Date conclusionRealDate) {
//		this.conclusionRealDate = conclusionRealDate;
//	}
//
//	/**
//	 * @return the violationSlaDate
//	 */
//	public Date getViolationSlaDate() {
//		return violationSlaDate;
//	}
//
//	/**
//	 * @param violationSlaDate the violationSlaDate to set
//	 */
//	public void setViolationSlaDate(Date violationSlaDate) {
//		this.violationSlaDate = violationSlaDate;
//	}
//
	/**
	 * @return the maximoNumber
	 */
	public Long getMaximoNumber() {
		return maximoNumber;
	}

	/**
	 * @param maximoNumber the maximoNumber to set
	 */
	public void setMaximoNumber(Long maximoNumber) {
		this.maximoNumber = maximoNumber;
	}

	@Override
	public String toString() {
		return String.format(" (%s) %s ", id,demandDetailDescription);
	}
	
	
	
	
}
