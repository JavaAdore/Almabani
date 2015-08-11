package com.almabani.common.entity.schema.admincor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINCOR" ,name = "COM_MUNICIPALITIES")
public class Municipalities implements Serializable {

	private static final long serialVersionUID = 2165450185282231157L;
	
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "numMunicipality", column = @Column(name = "NUM_MUNICIPALITY", nullable = false, precision = 7, scale = 0)),
			@AttributeOverride(name = "numCountry", column = @Column(name = "NUM_COUNTRY", nullable = false, precision = 5, scale = 0)),
			@AttributeOverride(name = "codState", column = @Column(name = "COD_STATE", nullable = false, length = 2)) })
	private MunicipalitiesId id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Column(name = "NAM_MUNICIPALITY", nullable = false, length = 40)
	private String municipalityName;
	
	@Column(name = "NUM_INHABITANTS", precision = 8, scale = 0)
	private Integer inhabitantsNumber;
	
	@Column(name = "NUM_IBGE", precision = 6, scale = 0)
	private Integer ibgeNumber;
	
	@Column(name = "VAL_PER_CAPITA_INCOME", precision = 15)
	private Integer valPerCapitaIncome;
	
	@Column(name = "NUM_DDD", length = 4)
	private String dddNumber;
	
	@Column(name = "COD_KEY_CEP", length = 6)
	private String cepKeyCode;
	
	@Column(name = "COD_KEY_SUB_CEP", length = 6)
	private String subCepKeyCode;
	
	@Column(name = "COD_KEY_DNE", length = 8)
	private String dneKeyCode;
	
	@Column(name = "COD_KEY_SUB_DNE", length = 8)
	private String subDneKeyCode;
	
	@Column(name = "NUM_CEP_MUNICIPALITY", precision = 8, scale = 0)
	private Integer cepMunicipalityNumber;
	
	@Column(name = "IND_TYPE_MUNICIPALITY", length = 1)
	private String indTypeMunicipality;

	public Municipalities() {
	}

	public MunicipalitiesId getId() {
		return id;
	}

	public void setId(MunicipalitiesId id) {
		this.id = id;
	}

	public Date getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	public String getModificationMakerName() {
		return modificationMakerName;
	}

	public void setModificationMakerName(String modificationMakerName) {
		this.modificationMakerName = modificationMakerName;
	}

	public String getMunicipalityName() {
		return municipalityName;
	}

	public void setMunicipalityName(String municipalityName) {
		this.municipalityName = municipalityName;
	}

	public Integer getInhabitantsNumber() {
		return inhabitantsNumber;
	}

	public void setInhabitantsNumber(Integer inhabitantsNumber) {
		this.inhabitantsNumber = inhabitantsNumber;
	}

	public Integer getIbgeNumber() {
		return ibgeNumber;
	}

	public void setIbgeNumber(Integer ibgeNumber) {
		this.ibgeNumber = ibgeNumber;
	}

	public Integer getValPerCapitaIncome() {
		return valPerCapitaIncome;
	}

	public void setValPerCapitaIncome(Integer valPerCapitaIncome) {
		this.valPerCapitaIncome = valPerCapitaIncome;
	}

	public String getDddNumber() {
		return dddNumber;
	}

	public void setDddNumber(String dddNumber) {
		this.dddNumber = dddNumber;
	}

	public String getCepKeyCode() {
		return cepKeyCode;
	}

	public void setCepKeyCode(String cepKeyCode) {
		this.cepKeyCode = cepKeyCode;
	}

	public String getSubCepKeyCode() {
		return subCepKeyCode;
	}

	public void setSubCepKeyCode(String subCepKeyCode) {
		this.subCepKeyCode = subCepKeyCode;
	}

	public String getDneKeyCode() {
		return dneKeyCode;
	}

	public void setDneKeyCode(String dneKeyCode) {
		this.dneKeyCode = dneKeyCode;
	}

	public String getSubDneKeyCode() {
		return subDneKeyCode;
	}

	public void setSubDneKeyCode(String subDneKeyCode) {
		this.subDneKeyCode = subDneKeyCode;
	}

	public Integer getCepMunicipalityNumber() {
		return cepMunicipalityNumber;
	}

	public void setCepMunicipalityNumber(Integer cepMunicipalityNumber) {
		this.cepMunicipalityNumber = cepMunicipalityNumber;
	}

	public String getIndTypeMunicipality() {
		return indTypeMunicipality;
	}

	public void setIndTypeMunicipality(String indTypeMunicipality) {
		this.indTypeMunicipality = indTypeMunicipality;
	}
	
}
