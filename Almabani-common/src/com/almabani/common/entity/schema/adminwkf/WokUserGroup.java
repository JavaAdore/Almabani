package com.almabani.common.entity.schema.adminwkf;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.almabani.common.entity.AbstractEntity;
import com.almabani.common.entity.schema.adminsec.SecUser;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINWKF", name = "WOK_USERS_GROUP", uniqueConstraints = @UniqueConstraint(columnNames = {
		"COD_USER_LOGIN", "NUM_WORKING_GROUP" }))
//@SequenceGenerator(name = "WokUsersGroup_Id_Seq_Gen", sequenceName = "ADMINWKF.WOK_USERS_GROUP_ID_SEQ_GEN", allocationSize = 1, initialValue = 1)
public class WokUserGroup extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = -7465052548278372040L;

	@Id
	@Column(name = "NUM_USER_GROUP", unique = true, nullable = false, precision = 5, scale = 0)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WokUsersGroup_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "NUM_WORKING_GROUP", referencedColumnName="NUM_WORKING_GROUP", nullable = false)
	private WokWorkingGroup workingGroup;
	
	@ManyToOne
	@JoinColumn(name = "NUM_TYPE_PROFILE", referencedColumnName="NUM_TYPE_PROFILE", nullable = false)
	private WokTypeProfile typeProfiles;
	
	@ManyToOne
	@JoinColumn(name = "COD_USER_LOGIN", referencedColumnName="COD_USER_LOGIN", nullable = false)
	private SecUser user;
	
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
	
	@Column(name = "IND_RESPONSIBLE_GROUP", nullable = false, length = 1)
	private String indResponsibleGroup;
	
	@Column(name = "IND_RECEIVE_NOTIFICATION", nullable = false, length = 1)
	private String indReceiveNotification;
	
	@Column(name = "IND_INTERACTION_DEMANDS", nullable = false, length = 1)
	private String indInteractionDemands;
	
	@Column(name = "IND_RECEIVE_EMAIL_OCCURRENCE", nullable = false, length = 1)
	private String indReceiveEmailOccurrence;
	
	@Column(name = "IND_INTERACTION_OCCURRENCES", nullable = false, length = 1)
	private String indInteractionOccurrences;

	public WokUserGroup() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the workingGroup
	 */
	public WokWorkingGroup getWorkingGroup() {
		return workingGroup;
	}

	/**
	 * @param workingGroup the workingGroup to set
	 */
	public void setWorkingGroup(WokWorkingGroup workingGroup) {
		this.workingGroup = workingGroup;
	}

	/**
	 * @return the typeProfiles
	 */
	public WokTypeProfile getTypeProfiles() {
		return typeProfiles;
	}

	/**
	 * @param typeProfiles the typeProfiles to set
	 */
	public void setTypeProfiles(WokTypeProfile typeProfiles) {
		this.typeProfiles = typeProfiles;
	}

	/**
	 * @return the user
	 */
	public SecUser getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(SecUser user) {
		this.user = user;
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

	/**
	 * @return the indResponsibleGroup
	 */
	public String getIndResponsibleGroup() {
		return indResponsibleGroup;
	}

	/**
	 * @param indResponsibleGroup the indResponsibleGroup to set
	 */
	public void setIndResponsibleGroup(String indResponsibleGroup) {
		this.indResponsibleGroup = indResponsibleGroup;
	}

	/**
	 * @return the indReceiveNotification
	 */
	public String getIndReceiveNotification() {
		return indReceiveNotification;
	}

	/**
	 * @param indReceiveNotification the indReceiveNotification to set
	 */
	public void setIndReceiveNotification(String indReceiveNotification) {
		this.indReceiveNotification = indReceiveNotification;
	}

	/**
	 * @return the indInteractionDemands
	 */
	public String getIndInteractionDemands() {
		return indInteractionDemands;
	}

	/**
	 * @param indInteractionDemands the indInteractionDemands to set
	 */
	public void setIndInteractionDemands(String indInteractionDemands) {
		this.indInteractionDemands = indInteractionDemands;
	}

	/**
	 * @return the indReceiveEmailOccurrence
	 */
	public String getIndReceiveEmailOccurrence() {
		return indReceiveEmailOccurrence;
	}

	/**
	 * @param indReceiveEmailOccurrence the indReceiveEmailOccurrence to set
	 */
	public void setIndReceiveEmailOccurrence(String indReceiveEmailOccurrence) {
		this.indReceiveEmailOccurrence = indReceiveEmailOccurrence;
	}

	/**
	 * @return the indInteractionOccurrences
	 */
	public String getIndInteractionOccurrences() {
		return indInteractionOccurrences;
	}

	/**
	 * @param indInteractionOccurrences the indInteractionOccurrences to set
	 */
	public void setIndInteractionOccurrences(String indInteractionOccurrences) {
		this.indInteractionOccurrences = indInteractionOccurrences;
	}
	
}
