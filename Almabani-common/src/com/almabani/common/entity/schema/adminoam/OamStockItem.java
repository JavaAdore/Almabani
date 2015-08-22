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
import com.almabani.common.entity.schema.admincor.Establishment;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINOAM", name = "OAM_STOCK_ITEMS")
@SequenceGenerator(name = "OamStockItems_Id_Seq_Gen", sequenceName = "OAM_STOCK_ITEMS_ID_SEQ_GEN", allocationSize = 1, initialValue = 1)
public class OamStockItem extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 6832336132373271576L;

	@Id
	@Column(name = "NUM_STOCK_ITEM", unique = true, nullable = false, precision = 15, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OamStockItems_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "NUM_PROJECT_ITEM", referencedColumnName="NUM_PROJECT_ITEM", nullable = false)
	private OamProjectItem projectItem;
	
	@ManyToOne
	@JoinColumn(name = "NUM_ESTABLISHMENT", referencedColumnName="NUM_ESTABLISHMENT", nullable = false)
	private Establishment establishment;
	
	@Column(name = "IND_IN_OUT", nullable = false, length = 1)
	private String indInOut;
	
	@Column(name = "VAL_ENTRY", precision = 15)
	private Integer entryValue;
	
//	@Column(name = "NUM_ITEM_QUOTATION", precision = 4, scale = 0)
//	private Integer numItemQuotation;
	
	@ManyToOne
	@JoinColumn(name = "NUM_ITEM_QUOTATION", referencedColumnName="NUM_ITEM_QUOTATION", nullable = false)
	private OamItemQuotation itemQuotation;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;

	public OamStockItem() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the projectItem
	 */
	public OamProjectItem getProjectItem() {
		return projectItem;
	}

	/**
	 * @param projectItem the projectItem to set
	 */
	public void setProjectItem(OamProjectItem projectItem) {
		this.projectItem = projectItem;
	}

	/**
	 * @return the establishment
	 */
	public Establishment getEstablishment() {
		return establishment;
	}

	/**
	 * @param establishment the establishment to set
	 */
	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}

	/**
	 * @return the indInOut
	 */
	public String getIndInOut() {
		return indInOut;
	}

	/**
	 * @param indInOut the indInOut to set
	 */
	public void setIndInOut(String indInOut) {
		this.indInOut = indInOut;
	}

	/**
	 * @return the entryValue
	 */
	public Integer getEntryValue() {
		return entryValue;
	}

	/**
	 * @param entryValue the entryValue to set
	 */
	public void setEntryValue(Integer entryValue) {
		this.entryValue = entryValue;
	}

	/**
	 * @return the itemQuotation
	 */
	public OamItemQuotation getItemQuotation() {
		return itemQuotation;
	}

	/**
	 * @param itemQuotation the itemQuotation to set
	 */
	public void setItemQuotation(OamItemQuotation itemQuotation) {
		this.itemQuotation = itemQuotation;
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
