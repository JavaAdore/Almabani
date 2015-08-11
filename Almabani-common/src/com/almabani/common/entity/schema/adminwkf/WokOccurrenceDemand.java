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
@Table(schema="ADMINWKF", name = "WOK_OCCURRENCES_DEMAND")
@SequenceGenerator(name = "WokOccurrencesDemand_Id_Seq_Gen", sequenceName = "WOK_OCCURRENCES_DEMAND_ID_SEQ_GEN", allocationSize = 50, initialValue = 50)
public class WokOccurrenceDemand extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 5855385957354729309L;

	@Id
	@Column(name = "NUM_OCCURRENCE", unique = true, nullable = false, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WokOccurrencesDemand_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "NUM_DEMAND", referencedColumnName="NUM_DEMAND", nullable = false)
	private WokDemand demand;
	
	@ManyToOne
	@JoinColumn(name = "NUM_TYPE_ACTION", referencedColumnName="NUM_TYPE_ACTION", nullable = false)
	private WokTypeActions typeActions;
	
	@ManyToOne
	@JoinColumn(name = "NUM_USER_GROUP", referencedColumnName="NUM_USER_GROUP", nullable = false)
	private WokUserGroup userGroup;
	
	@Column(name = "NUM_USER_GROUP_PREVIOUS", precision = 5, scale = 0)
	private Integer userGroupPrevious;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_OCCURRENCE", nullable = false, length = 7)
	private Date occurrencedate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_NEXT_ACTION", length = 7)
	private Date nextActionDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_UPDATE_ACTION", length = 7)
	private Date updateActionDate;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;
	
	@Column(name = "DES_USER_OBSERVATION", length = 300)
	private String userObservationdescription;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_ESTIMATED_BEGIN", length = 7)
	private Date estimatedBeginDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_ESTIMATED_END", length = 7)
	private Date estimatedEndDate;

	public WokOccurrenceDemand() {
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
	 * @return the typeActions
	 */
	public WokTypeActions getTypeActions() {
		return typeActions;
	}

	/**
	 * @param typeActions the typeActions to set
	 */
	public void setTypeActions(WokTypeActions typeActions) {
		this.typeActions = typeActions;
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
	 * @return the userGroupPrevious
	 */
	public Integer getUserGroupPrevious() {
		return userGroupPrevious;
	}

	/**
	 * @param userGroupPrevious the userGroupPrevious to set
	 */
	public void setUserGroupPrevious(Integer userGroupPrevious) {
		this.userGroupPrevious = userGroupPrevious;
	}

	/**
	 * @return the occurrencedate
	 */
	public Date getOccurrencedate() {
		return occurrencedate;
	}

	/**
	 * @param occurrencedate the occurrencedate to set
	 */
	public void setOccurrencedate(Date occurrencedate) {
		this.occurrencedate = occurrencedate;
	}

	/**
	 * @return the nextActionDate
	 */
	public Date getNextActionDate() {
		return nextActionDate;
	}

	/**
	 * @param nextActionDate the nextActionDate to set
	 */
	public void setNextActionDate(Date nextActionDate) {
		this.nextActionDate = nextActionDate;
	}

	/**
	 * @return the updateActionDate
	 */
	public Date getUpdateActionDate() {
		return updateActionDate;
	}

	/**
	 * @param updateActionDate the updateActionDate to set
	 */
	public void setUpdateActionDate(Date updateActionDate) {
		this.updateActionDate = updateActionDate;
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
	 * @return the userObservationdescription
	 */
	public String getUserObservationdescription() {
		return userObservationdescription;
	}

	/**
	 * @param userObservationdescription the userObservationdescription to set
	 */
	public void setUserObservationdescription(String userObservationdescription) {
		this.userObservationdescription = userObservationdescription;
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
	
}
