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
@Table(schema="ADMINOAM", name = "OAM_EQUIPMENTS")
@SequenceGenerator(name = "OamEquipments_Id_Seq_Gen", sequenceName = "OAM_EQUIPMENTS_ALLOCATIONS_ID_SEQ_GEN", allocationSize = 1, initialValue = 1)
public class OamEquipment extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = -188744923493250560L;

	@Id
	@Column(name = "NUM_EQUIPMENT", unique = true, nullable = false, precision = 3, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OamEquipments_Id_Seq_Gen")
	private Long id;
	
	@Column(name = "DES_EQUIPMENT", nullable = false, length = 600)
	private String equipmentDescription;
	
	@Column(name = "QUT_REFERENCE", nullable = false, precision = 2, scale = 0)
	private byte qutReference;
	
	@Column(name = "VAL_EQUIPMENT", nullable = false, precision = 15)
	private Integer equipmentValue;
	
	@ManyToOne
	@JoinColumn(name = "NUM_PROJECT", referencedColumnName="NUM_PROJECT", nullable = false)
	private Project project;
	
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

	public OamEquipment() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEquipmentDescription() {
		return equipmentDescription;
	}

	public void setEquipmentDescription(String equipmentDescription) {
		this.equipmentDescription = equipmentDescription;
	}

	public byte getQutReference() {
		return qutReference;
	}

	public void setQutReference(byte qutReference) {
		this.qutReference = qutReference;
	}

	public Integer getEquipmentValue() {
		return equipmentValue;
	}

	public void setEquipmentValue(Integer equipmentValue) {
		this.equipmentValue = equipmentValue;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getIndActive() {
		return indActive;
	}

	public void setIndActive(String indActive) {
		this.indActive = indActive;
	}

	public String getModificationMakerName() {
		return modificationMakerName;
	}

	public void setModificationMakerName(String modificationMakerName) {
		this.modificationMakerName = modificationMakerName;
	}

	public Date getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}
	
}
