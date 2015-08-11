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
import com.almabani.common.entity.schema.admincor.Company;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINOAM", name = "OAM_SUPPLIERS")
@SequenceGenerator(name = "OamSuppliers_Id_Seq_Gen", sequenceName = "adminoam.NUM_ITEM_QUOT_SUPPLIER", allocationSize = 50, initialValue = 50)
public class OamSupplier extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 4936711375291276209L;
	
	@Id   
	@Column(name = "NUM_SUPPLIER", unique = true, nullable = false,precision=0,scale=6)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OamSuppliers_Id_Seq_Gen" )
	private Long id;
	
	@Column(name = "NAM_SUPPLIER", nullable = false, length = 50)
	private String supplierName;
	
	@ManyToOne
	@JoinColumn(name = "NUM_COMPANY", referencedColumnName="NUM_COMPANY", nullable = false)
	private Company company;
	
	@Column(name = "NAM_ADDRESS", nullable = false, length = 50)
	private String address;
	
	@Column(name = "NAM_ADD_COMPLEMENT", length = 50)
	private String addComplementName;
	
	@Column(name = "NAM_RESPONSIBLE", length = 50)
	private String responsibleNumber;
	
	@Column(name = "NUM_TELEFONE")
	private Long telephoneNumber;
	
	@Column(name = "NUM_MOBILE")
	private Long mobileNumber;
	
	@Column(name = "NUM_FAX")
	private Long faxNumber;
	
	@Column(name = "DES_OBSERVATION", length = 300)
	private String observationDescription;
	
	@Column(name = "IND_ACTIVE", nullable = false, length = 1)
	private String indActive;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false)
	private String modificationMakerName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_LAST_MODIFY", nullable = false)
	private Date lastModificationDate;

	public OamSupplier() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the supplierName
	 */
	public String getSupplierName() {
		return supplierName;
	}

	/**
	 * @param supplierName the supplierName to set
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the addComplementName
	 */
	public String getAddComplementName() {
		return addComplementName;
	}

	/**
	 * @param addComplementName the addComplementName to set
	 */
	public void setAddComplementName(String addComplementName) {
		this.addComplementName = addComplementName;
	}

	/**
	 * @return the responsibleNumber
	 */
	public String getResponsibleNumber() {
		return responsibleNumber;
	}

	/**
	 * @param responsibleNumber the responsibleNumber to set
	 */
	public void setResponsibleNumber(String responsibleNumber) {
		this.responsibleNumber = responsibleNumber;
	}

	/**
	 * @return the telephoneNumber
	 */
	public Long getTelephoneNumber() {
		return telephoneNumber;
	}

	/**
	 * @param telephoneNumber the telephoneNumber to set
	 */
	public void setTelephoneNumber(Long telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	/**
	 * @return the mobileNumber
	 */
	public Long getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the faxNumber
	 */
	public Long getFaxNumber() {
		return faxNumber;
	}

	/**
	 * @param faxNumber the faxNumber to set
	 */
	public void setFaxNumber(Long faxNumber) {
		this.faxNumber = faxNumber;
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
	
}
