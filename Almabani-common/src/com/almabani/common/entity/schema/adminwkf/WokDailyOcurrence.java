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
import com.almabani.common.entity.schema.adminoam.OamZoneDevice;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINWKF", name = "WOK_DAILY_OCURRENCES")
@SequenceGenerator(name = "WokDailyOcurrences_Id_Seq_Gen", sequenceName = "ADMINWKF.WOK_SEQ_NUM_DAILY_OCCURRENCE", allocationSize = 1, initialValue = 1)
public class WokDailyOcurrence extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = -7318188634734742852L;

	@Id
	@Column(name = "NUM_DAILY_OCCURRENCE", unique = true, nullable = false, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WokDailyOcurrences_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "NUM_TYPE_OCCURRENCE", referencedColumnName="NUM_TYPE_OCCURRENCE", nullable = false)
	private WokTypesOccurrence typesOccurrence;
	
	@ManyToOne
	@JoinColumn(name = "NUM_USER_GROUP_TECHNICIAN", referencedColumnName="NUM_USER_GROUP", nullable = false)
	private WokUserGroup userGroupTechnician;
	
	@ManyToOne
	@JoinColumn(name = "NUM_USER_GROUP_SAFETY", referencedColumnName="NUM_USER_GROUP", nullable = false)
	private WokUserGroup userGroupSafety;
	
	@ManyToOne
	@JoinColumn(name = "NUM_USER_GROUP_CALL", referencedColumnName="NUM_USER_GROUP", nullable = false)
	private WokUserGroup userGroupCall;
	
	@ManyToOne
	@JoinColumn(name = "NUM_USER_GROUP", referencedColumnName="NUM_USER_GROUP", nullable = false)
	private WokUserGroup userGroup;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_TIME_OCCURRENCE", nullable = false, length = 7)
	private Date occurrenceDateTime;
	
	@ManyToOne
	@JoinColumn(name = "NUM_ZONE_DEVICE", referencedColumnName="NUM_ZONE_DEVICE", nullable = false)
	private OamZoneDevice zoneDevice;
	
	@Column(name = "DES_OCCURRENCE", nullable = false, length = 300)
	private String occurrenceDescription;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_TIME_RESPONSE", length = 7)
	private Date responseDateTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_TIME_CLOSING", length = 7)
	private Date closingDateTime;
	
	@Column(name = "DES_ACTION_TAKEN", length = 100)
	private String actionTakenDescription;
	
	@Column(name = "IND_CONTACT_POLICE", length = 1)
	private String indContactPolice;
	
	@Column(name = "IND_CONTACT_AMBULANCE", length = 1)
	private String indContactAmbulance;
	
	@Column(name = "IND_CONTACT_INSURANCE", length = 1)
	private String indContactInsurance;
	
	@Column(name = "IND_CONTACT_TRANSIT", length = 1)
	private String indContactTransit;

	public WokDailyOcurrence() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the typesOccurrence
	 */
	public WokTypesOccurrence getTypesOccurrence() {
		return typesOccurrence;
	}

	/**
	 * @param typesOccurrence the typesOccurrence to set
	 */
	public void setTypesOccurrence(WokTypesOccurrence typesOccurrence) {
		this.typesOccurrence = typesOccurrence;
	}

	/**
	 * @return the userGroupTechnician
	 */
	public WokUserGroup getUserGroupTechnician() {
		return userGroupTechnician;
	}

	/**
	 * @param userGroupTechnician the userGroupTechnician to set
	 */
	public void setUserGroupTechnician(WokUserGroup userGroupTechnician) {
		this.userGroupTechnician = userGroupTechnician;
	}

	/**
	 * @return the userGroupSafety
	 */
	public WokUserGroup getUserGroupSafety() {
		return userGroupSafety;
	}

	/**
	 * @param userGroupSafety the userGroupSafety to set
	 */
	public void setUserGroupSafety(WokUserGroup userGroupSafety) {
		this.userGroupSafety = userGroupSafety;
	}

	/**
	 * @return the userGroupCall
	 */
	public WokUserGroup getUserGroupCall() {
		return userGroupCall;
	}

	/**
	 * @param userGroupCall the userGroupCall to set
	 */
	public void setUserGroupCall(WokUserGroup userGroupCall) {
		this.userGroupCall = userGroupCall;
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
	 * @return the occurrenceDateTime
	 */
	public Date getOccurrenceDateTime() {
		return occurrenceDateTime;
	}

	/**
	 * @param occurrenceDateTime the occurrenceDateTime to set
	 */
	public void setOccurrenceDateTime(Date occurrenceDateTime) {
		this.occurrenceDateTime = occurrenceDateTime;
	}

	/**
	 * @return the zoneDevice
	 */
	public OamZoneDevice getZoneDevice() {
		return zoneDevice;
	}

	/**
	 * @param zoneDevice the zoneDevice to set
	 */
	public void setZoneDevice(OamZoneDevice zoneDevice) {
		this.zoneDevice = zoneDevice;
	}

	/**
	 * @return the occurrenceDescription
	 */
	public String getOccurrenceDescription() {
		return occurrenceDescription;
	}

	/**
	 * @param occurrenceDescription the occurrenceDescription to set
	 */
	public void setOccurrenceDescription(String occurrenceDescription) {
		this.occurrenceDescription = occurrenceDescription;
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
	 * @return the responseDateTime
	 */
	public Date getResponseDateTime() {
		return responseDateTime;
	}

	/**
	 * @param responseDateTime the responseDateTime to set
	 */
	public void setResponseDateTime(Date responseDateTime) {
		this.responseDateTime = responseDateTime;
	}

	/**
	 * @return the closingDateTime
	 */
	public Date getClosingDateTime() {
		return closingDateTime;
	}

	/**
	 * @param closingDateTime the closingDateTime to set
	 */
	public void setClosingDateTime(Date closingDateTime) {
		this.closingDateTime = closingDateTime;
	}

	/**
	 * @return the actionTakenDescription
	 */
	public String getActionTakenDescription() {
		return actionTakenDescription;
	}

	/**
	 * @param actionTakenDescription the actionTakenDescription to set
	 */
	public void setActionTakenDescription(String actionTakenDescription) {
		this.actionTakenDescription = actionTakenDescription;
	}

	/**
	 * @return the indContactPolice
	 */
	public String getIndContactPolice() {
		return indContactPolice;
	}

	/**
	 * @param indContactPolice the indContactPolice to set
	 */
	public void setIndContactPolice(String indContactPolice) {
		this.indContactPolice = indContactPolice;
	}

	/**
	 * @return the indContactAmbulance
	 */
	public String getIndContactAmbulance() {
		return indContactAmbulance;
	}

	/**
	 * @param indContactAmbulance the indContactAmbulance to set
	 */
	public void setIndContactAmbulance(String indContactAmbulance) {
		this.indContactAmbulance = indContactAmbulance;
	}

	/**
	 * @return the indContactInsurance
	 */
	public String getIndContactInsurance() {
		return indContactInsurance;
	}

	/**
	 * @param indContactInsurance the indContactInsurance to set
	 */
	public void setIndContactInsurance(String indContactInsurance) {
		this.indContactInsurance = indContactInsurance;
	}

	/**
	 * @return the indContactTransit
	 */
	public String getIndContactTransit() {
		return indContactTransit;
	}

	/**
	 * @param indContactTransit the indContactTransit to set
	 */
	public void setIndContactTransit(String indContactTransit) {
		this.indContactTransit = indContactTransit;
	}
	
}
