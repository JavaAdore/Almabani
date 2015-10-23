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
@Table(schema="ADMINOAM", name = "OAM_PROJ_SPARE_PARTS_INVOICES")
@SequenceGenerator(name = "OamProjSparePartsInvoices_Id_Seq_Gen", sequenceName = "ADMINOAM.OAM_SEQ_NUM_PROJ_SPA_PAR_INV", allocationSize = 1, initialValue = 1)
public class OamProjSparePartsInvoice extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 873887582073813005L;

	@Id
	@Column(name = "NUM_PROJ_SPARE_PARTS_INVOICE", unique = true, nullable = false, precision = 9, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OamProjSparePartsInvoices_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "NUM_PROJECT_INVOICE", referencedColumnName="NUM_PROJECT_INVOICE", nullable = false)
	private OamProjectInvoice projectInvoice;
	
	@Column(name = "COD_REQUESITION", nullable = false, length = 15)
	private String requesitionCode;
	
	@Column(name = "DES_SUPPLIER", nullable = false, length = 100)
	private String supplierDescription;
	
	@Column(name = "COD_BILL", nullable = false, length = 15)
	private String billCode;
	
	@Column(name = "VAL_BILL", nullable = false, precision = 15)
	private Integer billValue;
	
	@Column(name = "DES_OBSERVATION", length = 100)
	private String observationDescription;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;

	public OamProjSparePartsInvoice() {
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
	 * @return the requesitionCode
	 */
	public String getRequesitionCode() {
		return requesitionCode;
	}

	/**
	 * @param requesitionCode the requesitionCode to set
	 */
	public void setRequesitionCode(String requesitionCode) {
		this.requesitionCode = requesitionCode;
	}

	/**
	 * @return the supplierDescription
	 */
	public String getSupplierDescription() {
		return supplierDescription;
	}

	/**
	 * @param supplierDescription the supplierDescription to set
	 */
	public void setSupplierDescription(String supplierDescription) {
		this.supplierDescription = supplierDescription;
	}

	/**
	 * @return the billCode
	 */
	public String getBillCode() {
		return billCode;
	}

	/**
	 * @param billCode the billCode to set
	 */
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}

	/**
	 * @return the billValue
	 */
	public Integer getBillValue() {
		return billValue;
	}

	/**
	 * @param billValue the billValue to set
	 */
	public void setBillValue(Integer billValue) {
		this.billValue = billValue;
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
