package com.almabani.common.entity.schema.adminoam;

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
import com.almabani.common.entity.schema.admincor.Project;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINOAM", name = "OAM_TYPES_ALLOCATIONS")
@SequenceGenerator(name = "OamTypesAllocations_Id_Seq_Gen", sequenceName = "OAM_TYPES_ALLOCATIONS_ID_SEQ_GEN", allocationSize = 50, initialValue = 50)
public class AllocationType extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = -715235308395274041L;
	
	@Id
	@Column(name = "NUM_TYPE_ALLOCATION", unique = true, nullable = false, precision = 3, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OamTypesAllocations_Id_Seq_Gen")
	private Long id;
	
	@Column(name = "DES_TYPE_ALLOCATION", nullable = false, length = 80)
	private String allocationTypeDescription;
	
	@ManyToOne
	@JoinColumn(name = "NUM_PROJECT", referencedColumnName="NUM_PROJECT", nullable = false)
	private Project project;
	
	@Column(name = "NUM_HOUR_SUN_BEGIN", precision = 2, scale = 0)
	private Byte sunBeginHourNumber;
	
	@Column(name = "NUM_HOUR_SUN_END", precision = 2, scale = 0)
	private Byte sunEndHourNumber;
	
	@Column(name = "NUM_HOUR_MON_BEGIN", precision = 2, scale = 0)
	private Byte monBeginHourNumber;
	
	@Column(name = "NUM_HOUR_MON_END", precision = 2, scale = 0)
	private Byte monEndHourNumber;
	
	@Column(name = "NUM_HOUR_TUE_BEGIN", precision = 2, scale = 0)
	private Byte tueBeginHourNumber;
	
	@Column(name = "NUM_HOUR_TUE_END", precision = 2, scale = 0)
	private Byte tueEndHourNumber;
	
	@Column(name = "NUM_HOUR_WEN_BEGIN", precision = 2, scale = 0)
	private Byte wenBeginHourNumber;
	
	@Column(name = "NUM_HOUR_WEN_END", precision = 2, scale = 0)
	private Byte wenEndHourNumber;
	
	@Column(name = "NUM_HOUR_THU_BEGIN", precision = 2, scale = 0)
	private Byte thuBeginHourNumber;
	
	@Column(name = "NUM_HOUR_THU_END", precision = 2, scale = 0)
	private Byte thuEndHourNumber;
	
	@Column(name = "NUM_HOUR_FRI_BEGIN", precision = 2, scale = 0)
	private Byte friBeginHourNumber;
	
	@Column(name = "NUM_HOUR_FRI_END", precision = 2, scale = 0)
	private Byte friEndHourNumber;
	
	@Column(name = "NUM_HOUR_SAT_BEGIN", precision = 2, scale = 0)
	private Byte satBeginHourNumber;
	
	@Column(name = "NUM_HOUR_SAT_END", precision = 2, scale = 0)
	private Byte satEndHourNumber;
	
	@Column(name = "IND_ACTIVE", nullable = false, length = 1)
	private String indActive;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;

	public AllocationType() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the allocationTypeDescription
	 */
	public String getAllocationTypeDescription() {
		return allocationTypeDescription;
	}

	/**
	 * @param allocationTypeDescription the allocationTypeDescription to set
	 */
	public void setAllocationTypeDescription(String allocationTypeDescription) {
		this.allocationTypeDescription = allocationTypeDescription;
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
	 * @return the sunBeginHourNumber
	 */
	public Byte getSunBeginHourNumber() {
		return sunBeginHourNumber;
	}

	/**
	 * @param sunBeginHourNumber the sunBeginHourNumber to set
	 */
	public void setSunBeginHourNumber(Byte sunBeginHourNumber) {
		this.sunBeginHourNumber = sunBeginHourNumber;
	}

	/**
	 * @return the sunEndHourNumber
	 */
	public Byte getSunEndHourNumber() {
		return sunEndHourNumber;
	}

	/**
	 * @param sunEndHourNumber the sunEndHourNumber to set
	 */
	public void setSunEndHourNumber(Byte sunEndHourNumber) {
		this.sunEndHourNumber = sunEndHourNumber;
	}

	/**
	 * @return the monBeginHourNumber
	 */
	public Byte getMonBeginHourNumber() {
		return monBeginHourNumber;
	}

	/**
	 * @param monBeginHourNumber the monBeginHourNumber to set
	 */
	public void setMonBeginHourNumber(Byte monBeginHourNumber) {
		this.monBeginHourNumber = monBeginHourNumber;
	}

	/**
	 * @return the monEndHourNumber
	 */
	public Byte getMonEndHourNumber() {
		return monEndHourNumber;
	}

	/**
	 * @param monEndHourNumber the monEndHourNumber to set
	 */
	public void setMonEndHourNumber(Byte monEndHourNumber) {
		this.monEndHourNumber = monEndHourNumber;
	}

	/**
	 * @return the tueBeginHourNumber
	 */
	public Byte getTueBeginHourNumber() {
		return tueBeginHourNumber;
	}

	/**
	 * @param tueBeginHourNumber the tueBeginHourNumber to set
	 */
	public void setTueBeginHourNumber(Byte tueBeginHourNumber) {
		this.tueBeginHourNumber = tueBeginHourNumber;
	}

	/**
	 * @return the tueEndHourNumber
	 */
	public Byte getTueEndHourNumber() {
		return tueEndHourNumber;
	}

	/**
	 * @param tueEndHourNumber the tueEndHourNumber to set
	 */
	public void setTueEndHourNumber(Byte tueEndHourNumber) {
		this.tueEndHourNumber = tueEndHourNumber;
	}

	/**
	 * @return the wenBeginHourNumber
	 */
	public Byte getWenBeginHourNumber() {
		return wenBeginHourNumber;
	}

	/**
	 * @param wenBeginHourNumber the wenBeginHourNumber to set
	 */
	public void setWenBeginHourNumber(Byte wenBeginHourNumber) {
		this.wenBeginHourNumber = wenBeginHourNumber;
	}

	/**
	 * @return the wenEndHourNumber
	 */
	public Byte getWenEndHourNumber() {
		return wenEndHourNumber;
	}

	/**
	 * @param wenEndHourNumber the wenEndHourNumber to set
	 */
	public void setWenEndHourNumber(Byte wenEndHourNumber) {
		this.wenEndHourNumber = wenEndHourNumber;
	}

	/**
	 * @return the thuBeginHourNumber
	 */
	public Byte getThuBeginHourNumber() {
		return thuBeginHourNumber;
	}

	/**
	 * @param thuBeginHourNumber the thuBeginHourNumber to set
	 */
	public void setThuBeginHourNumber(Byte thuBeginHourNumber) {
		this.thuBeginHourNumber = thuBeginHourNumber;
	}

	/**
	 * @return the thuEndHourNumber
	 */
	public Byte getThuEndHourNumber() {
		return thuEndHourNumber;
	}

	/**
	 * @param thuEndHourNumber the thuEndHourNumber to set
	 */
	public void setThuEndHourNumber(Byte thuEndHourNumber) {
		this.thuEndHourNumber = thuEndHourNumber;
	}

	/**
	 * @return the friBeginHourNumber
	 */
	public Byte getFriBeginHourNumber() {
		return friBeginHourNumber;
	}

	/**
	 * @param friBeginHourNumber the friBeginHourNumber to set
	 */
	public void setFriBeginHourNumber(Byte friBeginHourNumber) {
		this.friBeginHourNumber = friBeginHourNumber;
	}

	/**
	 * @return the friEndHourNumber
	 */
	public Byte getFriEndHourNumber() {
		return friEndHourNumber;
	}

	/**
	 * @param friEndHourNumber the friEndHourNumber to set
	 */
	public void setFriEndHourNumber(Byte friEndHourNumber) {
		this.friEndHourNumber = friEndHourNumber;
	}

	/**
	 * @return the satBeginHourNumber
	 */
	public Byte getSatBeginHourNumber() {
		return satBeginHourNumber;
	}

	/**
	 * @param satBeginHourNumber the satBeginHourNumber to set
	 */
	public void setSatBeginHourNumber(Byte satBeginHourNumber) {
		this.satBeginHourNumber = satBeginHourNumber;
	}

	/**
	 * @return the satEndHourNumber
	 */
	public Byte getSatEndHourNumber() {
		return satEndHourNumber;
	}

	/**
	 * @param satEndHourNumber the satEndHourNumber to set
	 */
	public void setSatEndHourNumber(Byte satEndHourNumber) {
		this.satEndHourNumber = satEndHourNumber;
	}

	/**
	 * @return the indActive
	 */
	public String getIndActive() {
		return indActive;
	}

	/**
	 * @param indActive the indActive to set
	 */
	public void setIndActive(String indActive) {
		this.indActive = indActive;
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

	@Override
	public boolean equals(Object other) {
		return (other instanceof AllocationType) && (id != null) ? id
				.equals(((AllocationType) other).id) : (other == this);
	}

	@Override
	public int hashCode() {
		return (id != null) ? (this.getClass().hashCode() + id.hashCode())
				: super.hashCode();
	}
}
