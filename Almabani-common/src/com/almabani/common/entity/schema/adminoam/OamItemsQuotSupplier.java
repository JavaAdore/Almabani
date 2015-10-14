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

import com.almabani.common.entity.AbstractEntity;
import com.almabani.common.interfaces.ByteArrayHolder;

/**
 * @author Mohamed_Ibrahim
 */

@Entity 
@Table(schema="ADMINOAM", name = "OAM_ITEMS_QUOT_SUPPLIERS")   
@SequenceGenerator(name = "OamItemsQuotSuppliers_Id_Seq_Gen", sequenceName = "ADMINOAM.OAM_SEQ_NUM_ITEM_QUOT_SUPPLIER", allocationSize = 1, initialValue = 1)
public class OamItemsQuotSupplier extends AbstractEntity implements ByteArrayHolder, Serializable {
	
	private static final long serialVersionUID = 3294985301470505243L;
 
	@Id
	@Column(name = "NUM_ITEM_QUOT_SUPPLIER", unique = true, nullable = false, precision = 12, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OamItemsQuotSuppliers_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "NUM_ITEM_QUOTATION", referencedColumnName="NUM_ITEM_QUOTATION", nullable = false)
	private OamItemQuotation itemQuotation;
	
	@ManyToOne
	@JoinColumn(name = "NUM_SUPPLIER", referencedColumnName="NUM_SUPPLIER", nullable = false)
	private OamSupplier supplier;
	
	@Column(name = "QUT_ITEM", nullable = false, precision = 3, scale = 0)
	private Integer qutItem =1;
	
	@Column(name = "VAL_ITEM", nullable = false, precision = 15)
	private Integer itemValue=1;
	
	@Column(name = "QUT_MONTHS_WARRANTY", precision = 3, scale = 0)
	private Integer warrantyMonthsQutation=1;
	
	@Column(name = "QUT_DAYS_DELIVERY", precision = 4, scale = 0)
	private Integer deliveryDaysQuotation=1;
	
	@Column(name = "PER_PAYMENT_PO", precision = 6)
	private Integer perPaymentPo=1;
	
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
	
	@Column(name = "IND_SELECTED")
	private String indSelected; 
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_SELECTION", length = 7)
	private Date selectionDate;
	
	@Column(name = "NAM_USER_SELECTION", length = 10)
	private String selectionUserName;
	
	//@Column(name = "IMG_QUOTATION")
	@Transient  
	private byte[] imgQuotation;
	
	public OamItemsQuotSupplier() {
	}

	public Long getId() {
		return id; 
	}

	public void setId(Long id) {
		this.id = id;
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
	 * @return the supplier
	 */
	public OamSupplier getSupplier() {
		return supplier;
	}

	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(OamSupplier supplier) {
		this.supplier = supplier;
	}

	/**
	 * @return the qutItem
	 */
	public Integer getQutItem() {
		return qutItem;
	}

	/**
	 * @param qutItem the qutItem to set
	 */
	public void setQutItem(Integer qutItem) {
		this.qutItem = qutItem;
	}

	/**
	 * @return the itemValue
	 */
	public Integer getItemValue() {
		return itemValue;
	}

	/**
	 * @param itemValue the itemValue to set
	 */
	public void setItemValue(Integer itemValue) {
		this.itemValue = itemValue;
	}

	/**
	 * @return the warrantyMonthsQutation
	 */
	public Integer getWarrantyMonthsQutation() {
		return warrantyMonthsQutation;
	}

	/**
	 * @param warrantyMonthsQutation the warrantyMonthsQutation to set
	 */
	public void setWarrantyMonthsQutation(Integer warrantyMonthsQutation) {
		this.warrantyMonthsQutation = warrantyMonthsQutation;
	}

	/**
	 * @return the deliveryDaysQuotation
	 */
	public Integer getDeliveryDaysQuotation() {
		return deliveryDaysQuotation;
	}

	/**
	 * @param deliveryDaysQuotation the deliveryDaysQuotation to set
	 */
	public void setDeliveryDaysQuotation(Integer deliveryDaysQuotation) {
		this.deliveryDaysQuotation = deliveryDaysQuotation;
	}

	/**
	 * @return the perPaymentPo
	 */
	public Integer getPerPaymentPo() {
		return perPaymentPo;
	}

	/**
	 * @param perPaymentPo the perPaymentPo to set
	 */
	public void setPerPaymentPo(Integer perPaymentPo) {
		this.perPaymentPo = perPaymentPo;
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

	/**
	 * @return the indSelected
	 */
	public String getIndSelected() {
		return indSelected;
	}

	/**
	 * @param indSelected the indSelected to set
	 */
	public void setIndSelected(String indSelected) {
		this.indSelected = indSelected;
	}

	/**
	 * @return the selectionDate
	 */
	public Date getSelectionDate() {
		return selectionDate;
	}

	/**
	 * @param selectionDate the selectionDate to set
	 */
	public void setSelectionDate(Date selectionDate) {
		this.selectionDate = selectionDate;
	}

	/**
	 * @return the selectionUserName
	 */
	public String getSelectionUserName() {
		return selectionUserName;
	}

	/**
	 * @param selectionUserName the selectionUserName to set
	 */
	public void setSelectionUserName(String selectionUserName) {
		this.selectionUserName = selectionUserName;
	}

	/**
	 * @return the imgQuotation
	 */
	public byte[] getImgQuotation() {
		return imgQuotation;
	}

	/**
	 * @param imgQuotation the imgQuotation to set
	 */
	public void setImgQuotation(byte[] imgQuotation) {
		this.imgQuotation = imgQuotation;
	}

	@Override
	public void setHoldedImage(byte[] blob) {
		setImgQuotation(blob);
		
	}

	@Override
	public byte[] getHoldedImage() {
		return getImgQuotation();
	}
	
}
