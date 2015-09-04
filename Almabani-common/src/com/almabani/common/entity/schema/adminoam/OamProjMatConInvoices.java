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
@Table(schema="ADMINOAM", name = "OAM_PROJ_MAT_CONS_INVOICES")
@SequenceGenerator(name = "OamProjMatConsInvoices_Id_Seq_Gen", sequenceName = "ADMINOAM.OAM_SEQ_NUM_PROJ_MAT_CONS_INV", allocationSize = 1, initialValue = 1)
public class OamProjMatConInvoices extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 8875809616138293752L;

	@Id
	@Column(name = "NUM_PROJ_MAT_CONS_INVOICE", unique = true, nullable = false, precision = 9, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OamProjMatConsInvoices_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "NUM_PROJECT_INVOICE", referencedColumnName="NUM_PROJECT_INVOICE", nullable = false)
	private OamProjectInvoice projectInvoice;
	
	@ManyToOne
	@JoinColumn(name = "NUM_MATERIAL_CONSUMABLE", referencedColumnName="NUM_MATERIAL_CONSUMABLE", nullable = false)
	private OamMaterialConsumable materialConsumable;
	
	@Column(name = "QUT_MATERIAL_CONSUMABLE", nullable = false, precision = 2, scale = 0)
	private byte consumableMaterialQuotation;
	
	@Column(name = "VAL_UNIT_MATERIAL_CONSUMABLE", nullable = false, precision = 15)
	private Integer consumableMaterialUnitValue;
	
	@Column(name = "VAL_TOT_MATERIAL_CONSUMABLE", nullable = false, precision = 15)
	private Integer consumableMaterialTotalValue;
	
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

	public OamProjMatConInvoices() {
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
	 * @return the materialConsumable
	 */
	public OamMaterialConsumable getMaterialConsumable() {
		return materialConsumable;
	}

	/**
	 * @param materialConsumable the materialConsumable to set
	 */
	public void setMaterialConsumable(OamMaterialConsumable materialConsumable) {
		this.materialConsumable = materialConsumable;
	}

	/**
	 * @return the consumableMaterialQuotation
	 */
	public byte getConsumableMaterialQuotation() {
		return consumableMaterialQuotation;
	}

	/**
	 * @param consumableMaterialQuotation the consumableMaterialQuotation to set
	 */
	public void setConsumableMaterialQuotation(byte consumableMaterialQuotation) {
		this.consumableMaterialQuotation = consumableMaterialQuotation;
	}

	/**
	 * @return the consumableMaterialUnitValue
	 */
	public Integer getConsumableMaterialUnitValue() {
		return consumableMaterialUnitValue;
	}

	/**
	 * @param consumableMaterialUnitValue the consumableMaterialUnitValue to set
	 */
	public void setConsumableMaterialUnitValue(
			Integer consumableMaterialUnitValue) {
		this.consumableMaterialUnitValue = consumableMaterialUnitValue;
	}

	/**
	 * @return the consumableMaterialTotalValue
	 */
	public Integer getConsumableMaterialTotalValue() {
		return consumableMaterialTotalValue;
	}

	/**
	 * @param consumableMaterialTotalValue the consumableMaterialTotalValue to set
	 */
	public void setConsumableMaterialTotalValue(
			Integer consumableMaterialTotalValue) {
		this.consumableMaterialTotalValue = consumableMaterialTotalValue;
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
