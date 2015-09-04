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

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINOAM", name = "OAM_PROJ_EQUIPMENTS_INVOICES")
@SequenceGenerator(name = "OamProjEquipmentsInvoices_Id_Seq_Gen", sequenceName = "ADMINOAM.OAM_SEQ_NUM_PROJ_EQUIP_INVOICE", allocationSize = 1, initialValue = 1)
public class OamProjEquipmentInvoices extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 3826099015579584535L;

	@Id
	@Column(name = "NUM_PROJ_EQUIPMENT_INVOICE", unique = true, nullable = false, precision = 9, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OamProjEquipmentsInvoices_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "NUM_PROJECT_INVOICE", referencedColumnName="NUM_PROJECT_INVOICE", nullable = false)
	private OamProjectInvoice projectInvoice;
	
	@ManyToOne
	@JoinColumn(name = "NUM_EQUIPMENT", referencedColumnName="NUM_EQUIPMENT", nullable = false)
	private OamEquipment equipment;
	
	@Column(name = "QUT_EQUIPMENT", nullable = false, precision = 2, scale = 0)
	private byte qutEquipment;
	
	@Column(name = "VAL_UNIT_EQUIPMENT", nullable = false, precision = 15)
	private Integer equipmentUnitValue;
	
	@Column(name = "VAL_TOT_EQUIPMENT", nullable = false, precision = 15)
	private Integer equipmentTotalValue;
	
	@Column(name = "DES_OBSERVATION", length = 100)
	private String observationDescription;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;

	public OamProjEquipmentInvoices() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the projectInvoice
	 */
	public OamProjectInvoice getProjectInvoice() {
		return projectInvoice;
	}

	/**
	 * @param projectInvoice the projectInvoice to set
	 */
	public void setProjectInvoice(OamProjectInvoice projectInvoice) {
		this.projectInvoice = projectInvoice;
	}

	/**
	 * @return the equipment
	 */
	public OamEquipment getEquipment() {
		return equipment;
	}

	/**
	 * @param equipment the equipment to set
	 */
	public void setEquipment(OamEquipment equipment) {
		this.equipment = equipment;
	}

	/**
	 * @return the qutEquipment
	 */
	public byte getQutEquipment() {
		return qutEquipment;
	}

	/**
	 * @param qutEquipment the qutEquipment to set
	 */
	public void setQutEquipment(byte qutEquipment) {
		this.qutEquipment = qutEquipment;
	}

	/**
	 * @return the equipmentUnitValue
	 */
	public Integer getEquipmentUnitValue() {
		return equipmentUnitValue;
	}

	/**
	 * @param equipmentUnitValue the equipmentUnitValue to set
	 */
	public void setEquipmentUnitValue(Integer equipmentUnitValue) {
		this.equipmentUnitValue = equipmentUnitValue;
	}

	/**
	 * @return the equipmentTotalValue
	 */
	public Integer getEquipmentTotalValue() {
		return equipmentTotalValue;
	}

	/**
	 * @param equipmentTotalValue the equipmentTotalValue to set
	 */
	public void setEquipmentTotalValue(Integer equipmentTotalValue) {
		this.equipmentTotalValue = equipmentTotalValue;
	}

	/**
	 * @return the observationDescription
	 */
	public String getObservationDescription() {
		return observationDescription;
	}

	/**
	 * @param observationDescription the observationDescription to set
	 */
	public void setObservationDescription(String observationDescription) {
		this.observationDescription = observationDescription;
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
	
}
