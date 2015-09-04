package com.almabani.common.entity.schema.admincor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(schema="ADMINCOR",name = "COM_ESTABLISHMENTS")
@SequenceGenerator(name = "ComEstablishments_Id_Seq_Gen", sequenceName = "ADMINCOR.COM_SEQ_NUM_ESTABLISHMENT", allocationSize = 1, initialValue = 1)
public class Establishment extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1288021767291635086L;
	
	@Id
	@Column(name = "NUM_ESTABLISHMENT", unique = true, nullable = false, precision = 4, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ComEstablishments_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "NUM_COMPANY", referencedColumnName="NUM_COMPANY", nullable = false)
	private Company company;
	
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "NUM_ZIP_CODE", referencedColumnName = "NUM_ZIP_CODE", nullable = false),
			@JoinColumn(name = "NUM_SEQ_ZIP_CODE", referencedColumnName = "NUM_SEQ_ZIP_CODE", nullable = false) })
	private ZipCode zipCode;
	
	@Column(name = "NUM_DOCUMENT", nullable = false, precision = 14, scale = 0)
	private long documentNumber;
	
	@Column(name = "NUM_DIGIT_ESTABLISHMENT", precision = 1, scale = 0)
	private Boolean digitEstablishmentNumber;
	
	@Column(name = "IND_TYPE_ESTABLISHMENT", length = 1)
	private String indTypeEstablishment;
	
	@Column(name = "NAM_ESTABLISHMENT", nullable = false, length = 40)
	private String establishmentName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Column(name = "IND_ACTIVE", nullable = false, length = 1)
	private String indActive;
	
	@Column(name = "NAM_ADDRESS", length = 80)
	private String addressName;
	
	@Column(name = "NUM_ADDRESS", precision = 4, scale = 0)
	private Integer addressNumber;
	
	@Column(name = "DES_COMPLEMENT_ADDRESS_1", length = 50)
	private String desComplementAddress1;
	
	@Column(name = "DES_COMPLEMENT_ADDRESS_2", length = 50)
	private String desComplementAddress2;

	public Establishment() {
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the zipCode
	 */
	public ZipCode getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(ZipCode zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the documentNumber
	 */
	public long getDocumentNumber() {
		return documentNumber;
	}

	/**
	 * @param documentNumber the documentNumber to set
	 */
	public void setDocumentNumber(long documentNumber) {
		this.documentNumber = documentNumber;
	}

	/**
	 * @return the digitEstablishmentNumber
	 */
	public Boolean getDigitEstablishmentNumber() {
		return digitEstablishmentNumber;
	}

	/**
	 * @param digitEstablishmentNumber the digitEstablishmentNumber to set
	 */
	public void setDigitEstablishmentNumber(Boolean digitEstablishmentNumber) {
		this.digitEstablishmentNumber = digitEstablishmentNumber;
	}

	/**
	 * @return the indTypeEstablishment
	 */
	public String getIndTypeEstablishment() {
		return indTypeEstablishment;
	}

	/**
	 * @param indTypeEstablishment the indTypeEstablishment to set
	 */
	public void setIndTypeEstablishment(String indTypeEstablishment) {
		this.indTypeEstablishment = indTypeEstablishment;
	}

	/**
	 * @return the establishmentName
	 */
	public String getEstablishmentName() {
		return establishmentName;
	}

	/**
	 * @param establishmentName the establishmentName to set
	 */
	public void setEstablishmentName(String establishmentName) {
		this.establishmentName = establishmentName;
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
	 * @return the addressName
	 */
	public String getAddressName() {
		return addressName;
	}

	/**
	 * @param addressName the addressName to set
	 */
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	/**
	 * @return the addressNumber
	 */
	public Integer getAddressNumber() {
		return addressNumber;
	}

	/**
	 * @param addressNumber the addressNumber to set
	 */
	public void setAddressNumber(Integer addressNumber) {
		this.addressNumber = addressNumber;
	}

	/**
	 * @return the desComplementAddress1
	 */
	public String getDesComplementAddress1() {
		return desComplementAddress1;
	}

	/**
	 * @param desComplementAddress1 the desComplementAddress1 to set
	 */
	public void setDesComplementAddress1(String desComplementAddress1) {
		this.desComplementAddress1 = desComplementAddress1;
	}

	/**
	 * @return the desComplementAddress2
	 */
	public String getDesComplementAddress2() {
		return desComplementAddress2;
	}

	/**
	 * @param desComplementAddress2 the desComplementAddress2 to set
	 */
	public void setDesComplementAddress2(String desComplementAddress2) {
		this.desComplementAddress2 = desComplementAddress2;
	}
}
