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
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

import com.almabani.common.entity.AbstractEntity;
import com.almabani.common.entity.schema.admincor.Establishment;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINOAM", name = "OAM_STOCK_ITEMS")
@SequenceGenerator(name = "OamStockItems_Id_Seq_Gen", sequenceName = "ADMINOAM.OAM_SEQ_NUM_STOCK_ITEM", allocationSize = 1, initialValue = 1)
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
	
	
	@Transient
	private Long maxAmountToWithdraw;
	
	
	public Long getMaxAmountToWithdraw() {
		return maxAmountToWithdraw;
	}

	public void setMaxAmountToWithdraw(Long maxAmountToWithdraw) {
		this.maxAmountToWithdraw = maxAmountToWithdraw;
	}

	public OamItemQuotation getItemQuotation() {
		return itemQuotation;
	}

	public void setItemQuotation(OamItemQuotation itemQuotation) {
		this.itemQuotation = itemQuotation;
	}

	public Establishment getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}

	@Column(name = "IND_IN_OUT", nullable = false, length = 1)
	private String indInOut;
	
	
	@Column(name = "VAL_ENTRY", precision = 15)
	private Integer entryValue;
	
	
	@ManyToOne
	@JoinColumn(name = "NUM_ITEM_QUOTATION", referencedColumnName="NUM_ITEM_QUOTATION", nullable = false)
	private OamItemQuotation itemQuotation;

	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	 
	@Temporal(TemporalType.TIMESTAMP)
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

	public String getIndInOut() {
		return indInOut;
	}

	public void setIndInOut(String indInOut) {
		this.indInOut = indInOut;
	}

	public Integer getEntryValue() {
		return entryValue;
	}

	public void setEntryValue(Integer entryValue) {
		this.entryValue = entryValue;
	}

	public Date getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}
	
	public OamProjectItem getProjectItem() {
		return projectItem;
	}

	public void setProjectItem(OamProjectItem projectItem) {
		this.projectItem = projectItem;
	}

	

	public String getModificationMakerName() {
		return modificationMakerName;
	}

	public void setModificationMakerName(String modificationMakerName) {
		this.modificationMakerName = modificationMakerName;
	}


	  
}
