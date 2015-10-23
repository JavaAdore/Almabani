package com.almabani.common.entity.schema.admincor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINCOR" ,name = "COM_ZIP_CODE")
public class ZipCode implements Serializable {

	private static final long serialVersionUID = 4878509595686706949L;
	
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "numZipCode", column = @Column(name = "NUM_ZIP_CODE", nullable = false, precision = 8, scale = 0)),
			@AttributeOverride(name = "numSeqZipCode", column = @Column(name = "NUM_SEQ_ZIP_CODE", nullable = false, precision = 6, scale = 0)) })
	private ZipCodeId zipCodeId;
	
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "NUM_MUNICIPALITY", referencedColumnName = "NUM_MUNICIPALITY"),
			@JoinColumn(name = "NUM_COUNTRY", referencedColumnName = "NUM_COUNTRY"),
			@JoinColumn(name = "COD_STATE", referencedColumnName = "COD_STATE") })
	private Municipalities municipalities;
	
	@Column(name = "DES_ZIP_CODE", length = 60)
	private String zipCodeDescription;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_LAST_MODIFY", length = 7)
	private Date lastModificationDate;
	
	@Column(name = "NUM_TYPE_ZIP_CODE", precision = 1, scale = 0)
	private Boolean numTypeZipCode;
	
	@Column(name = "NUM_REC_LABEL", precision = 8, scale = 0)
	private Integer recLabelNumber;
	
	@Column(name = "NUM_ZIP_CODE5", precision = 5, scale = 0)
	private Integer zipCode5Number;
	
	@Column(name = "NAM_BEGIN_NEIGHBORHOOD", length = 30)
	private String beginNeighborhoodName;
	
	@Column(name = "NAM_COD_SPECIAL", length = 70)
	private String codSpecialName;
	
	@Column(name = "NAM_END_NEIGHBORHOOD", length = 30)
	private String endNeighborhoodName;
	
	@Column(name = "COD_TYPE_LOCALIDADE", length = 1)
	private String localidadeTypeCode;
	
	@Column(name = "COD_TYPE_STREET", length = 10)
	private String streetTypeCode;
	
	@Column(name = "NAM_ABBREVIATED_STREET", length = 29)
	private String abbreviatedStreetName;
	
	@Column(name = "COD_CLUE_ZIP_CODE", length = 6)
	private String zipCodeClueCode;
	
	@Column(name = "COD_CLUE_DNE", length = 8)
	private String dneClueCode;
	
	@Column(name = "IND_PAR_IMPAR", length = 1)
	private String indParImpar;
	
	@Column(name = "IND_BIG_USSER", length = 1)
	private String indBigUsser;
	
	@Column(name = "NUM_STREET", precision = 6, scale = 0)
	private Integer streetNumber;
	
	@Column(name = "NUM_BEGIN_SECTION", precision = 6, scale = 0)
	private Integer beginSectionNumber;
	
	@Column(name = "NUM_END_SECTION", precision = 6, scale = 0)
	private Integer endSectionNumber;
	
	@Column(name = "NUM_BEGIN_NEIGHBOURHOOD", precision = 9, scale = 0)
	private Integer beginNeighbourhoodNumber;
	
	@Column(name = "NUM_END_NEIGHBOURHOOD", precision = 9, scale = 0)
	private Integer endNeighbourhoodNumber;
	
	@Column(name = "IND_VALID", length = 1)
	private String indValid;

	public ZipCode() {
	}

	/**
	 * @return the zipCodeId
	 */
	public ZipCodeId getZipCodeId() {
		return zipCodeId;
	}


	/**
	 * @param zipCodeId the zipCodeId to set
	 */
	public void setZipCodeId(ZipCodeId zipCodeId) {
		this.zipCodeId = zipCodeId;
	}


	public Municipalities getMunicipalities() {
		return municipalities;
	}

	public void setMunicipalities(Municipalities municipalities) {
		this.municipalities = municipalities;
	}

	public String getZipCodeDescription() {
		return zipCodeDescription;
	}

	public void setZipCodeDescription(String zipCodeDescription) {
		this.zipCodeDescription = zipCodeDescription;
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

	public Boolean getNumTypeZipCode() {
		return numTypeZipCode;
	}

	public void setNumTypeZipCode(Boolean numTypeZipCode) {
		this.numTypeZipCode = numTypeZipCode;
	}

	public Integer getRecLabelNumber() {
		return recLabelNumber;
	}

	public void setRecLabelNumber(Integer recLabelNumber) {
		this.recLabelNumber = recLabelNumber;
	}

	public Integer getZipCode5Number() {
		return zipCode5Number;
	}

	public void setZipCode5Number(Integer zipCode5Number) {
		this.zipCode5Number = zipCode5Number;
	}

	public String getBeginNeighborhoodName() {
		return beginNeighborhoodName;
	}

	public void setBeginNeighborhoodName(String beginNeighborhoodName) {
		this.beginNeighborhoodName = beginNeighborhoodName;
	}

	public String getCodSpecialName() {
		return codSpecialName;
	}

	public void setCodSpecialName(String codSpecialName) {
		this.codSpecialName = codSpecialName;
	}

	public String getEndNeighborhoodName() {
		return endNeighborhoodName;
	}

	public void setEndNeighborhoodName(String endNeighborhoodName) {
		this.endNeighborhoodName = endNeighborhoodName;
	}

	public String getLocalidadeTypeCode() {
		return localidadeTypeCode;
	}

	public void setLocalidadeTypeCode(String localidadeTypeCode) {
		this.localidadeTypeCode = localidadeTypeCode;
	}

	public String getStreetTypeCode() {
		return streetTypeCode;
	}

	public void setStreetTypeCode(String streetTypeCode) {
		this.streetTypeCode = streetTypeCode;
	}

	public String getAbbreviatedStreetName() {
		return abbreviatedStreetName;
	}

	public void setAbbreviatedStreetName(String abbreviatedStreetName) {
		this.abbreviatedStreetName = abbreviatedStreetName;
	}

	public String getZipCodeClueCode() {
		return zipCodeClueCode;
	}

	public void setZipCodeClueCode(String zipCodeClueCode) {
		this.zipCodeClueCode = zipCodeClueCode;
	}

	public String getDneClueCode() {
		return dneClueCode;
	}

	public void setDneClueCode(String dneClueCode) {
		this.dneClueCode = dneClueCode;
	}

	public String getIndParImpar() {
		return indParImpar;
	}

	public void setIndParImpar(String indParImpar) {
		this.indParImpar = indParImpar;
	}

	public String getIndBigUsser() {
		return indBigUsser;
	}

	public void setIndBigUsser(String indBigUsser) {
		this.indBigUsser = indBigUsser;
	}

	public Integer getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(Integer streetNumber) {
		this.streetNumber = streetNumber;
	}

	public Integer getBeginSectionNumber() {
		return beginSectionNumber;
	}

	public void setBeginSectionNumber(Integer beginSectionNumber) {
		this.beginSectionNumber = beginSectionNumber;
	}

	public Integer getEndSectionNumber() {
		return endSectionNumber;
	}

	public void setEndSectionNumber(Integer endSectionNumber) {
		this.endSectionNumber = endSectionNumber;
	}

	public Integer getBeginNeighbourhoodNumber() {
		return beginNeighbourhoodNumber;
	}

	public void setBeginNeighbourhoodNumber(Integer beginNeighbourhoodNumber) {
		this.beginNeighbourhoodNumber = beginNeighbourhoodNumber;
	}

	public Integer getEndNeighbourhoodNumber() {
		return endNeighbourhoodNumber;
	}

	public void setEndNeighbourhoodNumber(Integer endNeighbourhoodNumber) {
		this.endNeighbourhoodNumber = endNeighbourhoodNumber;
	}

	public String getIndValid() {
		return indValid;
	}

	public void setIndValid(String indValid) {
		this.indValid = indValid;
	}
	
}
