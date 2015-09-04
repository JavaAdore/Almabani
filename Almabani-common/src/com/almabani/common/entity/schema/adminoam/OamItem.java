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
@Table(schema="ADMINOAM", name = "OAM_ITEMS")
@SequenceGenerator(name = "OamItems_Id_Seq_Gen", sequenceName = "ADMINOAM.OAM_SEQ_NUM_ITEM", allocationSize = 1, initialValue = 1)
public class OamItem extends AbstractEntity implements Serializable {  
	
	private static final long serialVersionUID = 1611168614758417632L;

	@Id
	@Column(name = "NUM_ITEM", unique = true, nullable = false, precision = 9, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OamItems_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "NUM_MANUFACTURER", referencedColumnName="NUM_MANUFACTURER")
	private OamManufacturer manufacturer;
	
	@ManyToOne
	@JoinColumn(name = "NUM_TYPE_MATERIAL", referencedColumnName="NUM_TYPE_MATERIAL", nullable = false)
	private OamTypeMaterial materialType;
	
	@ManyToOne
	@JoinColumn(name = "NUM_ITEM_CATEGORY", referencedColumnName="NUM_ITEM_CATEGORY", nullable = false)
	private OamItemCategory itemCategory;
	
	@Column(name = "DES_ITEM", nullable = false, length = 150)
	private String itemDescription;
	
	@Column(name = "COD_ITEM", nullable = false, length = 20)
	private String itemCode;
	
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
	
	@Column(name = "IND_TYPE_UNIT", length = 2)
	private String indUnitType;

	public OamItem() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OamManufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(OamManufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public OamTypeMaterial getMaterialType() {
		return materialType;
	}

	public void setMaterialType(OamTypeMaterial materialType) {
		this.materialType = materialType;
	}

	public OamItemCategory getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(OamItemCategory itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
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

	public String getIndUnitType() {
		return indUnitType;
	}

	public void setIndUnitType(String indUnitType) {
		this.indUnitType = indUnitType;
	}
	
}
