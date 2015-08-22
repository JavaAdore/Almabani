package com.almabani.common.entity.schema.adminwkf;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINWKF", name = "WOK_DEMANDS_ACTIVITIES")
@SequenceGenerator(name = "WokDemandsActivities_Id_Seq_Gen", sequenceName = "WOK_DEMANDS_ACTIVITIES_ID_SEQ_GEN", allocationSize = 1, initialValue = 1)
public class WokDemandActivities extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 5809514804715304008L;

	@Id
	@Column(name = "NUM_ACTIVITY", unique = true, nullable = false, precision = 9, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WokDemandsActivities_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "NUM_DEMAND", referencedColumnName="NUM_DEMAND", nullable = false)
	private WokDemand demand;
	
	@ManyToOne
	@JoinColumn(name = "NUM_USER_GROUP_ACTIVITY", referencedColumnName="NUM_USER_GROUP", nullable = false)
	private WokUserGroup userGroup;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_INSERT_ACTIVITY", nullable = false, length = 7)
	private Date activityInsertDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_UPDATE_ACTIVITY", length = 7)
	private Date activityUpdateDate;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;
	
	@Column(name = "DES_ACTIVITY", nullable = false, length = 300)
	private String activityDescription;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_ESTIMATED_BEGIN", length = 7)
	private Date estimatedBeginDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_ESTIMATED_END", length = 7)
	private Date estimatedEndDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_REAL_BEGIN", length = 7)
	private Date realBeginDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_REAL_END", length = 7)
	private Date realEndDate;
	
	@Column(name = "PER_REALIZED", precision = 5)
	private Integer perRealized;
	
	@Column(name = "DES_ATT_POINTS", length = 300)
	private String attPointsDescription;

	public WokDemandActivities() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the demand
	 */
	public WokDemand getDemand() {
		return demand;
	}

	/**
	 * @param demand the demand to set
	 */
	public void setDemand(WokDemand demand) {
		this.demand = demand;
	}

	/**
	 * @return the userGroup
	 */
	public WokUserGroup getUserGroup() {
		return userGroup;
	}

	/**
	 * @param userGroup the userGroup to set
	 */
	public void setUserGroup(WokUserGroup userGroup) {
		this.userGroup = userGroup;
	}

	/**
	 * @return the activityInsertDate
	 */
	public Date getActivityInsertDate() {
		return activityInsertDate;
	}

	/**
	 * @param activityInsertDate the activityInsertDate to set
	 */
	public void setActivityInsertDate(Date activityInsertDate) {
		this.activityInsertDate = activityInsertDate;
	}

	/**
	 * @return the activityUpdateDate
	 */
	public Date getActivityUpdateDate() {
		return activityUpdateDate;
	}

	/**
	 * @param activityUpdateDate the activityUpdateDate to set
	 */
	public void setActivityUpdateDate(Date activityUpdateDate) {
		this.activityUpdateDate = activityUpdateDate;
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
	 * @return the activityDescription
	 */
	public String getActivityDescription() {
		return activityDescription;
	}

	/**
	 * @param activityDescription the activityDescription to set
	 */
	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}

	/**
	 * @return the estimatedBeginDate
	 */
	public Date getEstimatedBeginDate() {
		return estimatedBeginDate;
	}

	/**
	 * @param estimatedBeginDate the estimatedBeginDate to set
	 */
	public void setEstimatedBeginDate(Date estimatedBeginDate) {
		this.estimatedBeginDate = estimatedBeginDate;
	}

	/**
	 * @return the estimatedEndDate
	 */
	public Date getEstimatedEndDate() {
		return estimatedEndDate;
	}

	/**
	 * @param estimatedEndDate the estimatedEndDate to set
	 */
	public void setEstimatedEndDate(Date estimatedEndDate) {
		this.estimatedEndDate = estimatedEndDate;
	}

	/**
	 * @return the realBeginDate
	 */
	public Date getRealBeginDate() {
		return realBeginDate;
	}

	/**
	 * @param realBeginDate the realBeginDate to set
	 */
	public void setRealBeginDate(Date realBeginDate) {
		this.realBeginDate = realBeginDate;
	}

	/**
	 * @return the realEndDate
	 */
	public Date getRealEndDate() {
		return realEndDate;
	}

	/**
	 * @param realEndDate the realEndDate to set
	 */
	public void setRealEndDate(Date realEndDate) {
		this.realEndDate = realEndDate;
	}

	/**
	 * @return the perRealized
	 */
	public Integer getPerRealized() {
		return perRealized;
	}

	/**
	 * @param perRealized the perRealized to set
	 */
	public void setPerRealized(Integer perRealized) {
		this.perRealized = perRealized;
	}

	/**
	 * @return the attPointsDescription
	 */
	public String getAttPointsDescription() {
		return attPointsDescription;
	}

	/**
	 * @param attPointsDescription the attPointsDescription to set
	 */
	public void setAttPointsDescription(String attPointsDescription) {
		this.attPointsDescription = attPointsDescription;
	}
	
}
