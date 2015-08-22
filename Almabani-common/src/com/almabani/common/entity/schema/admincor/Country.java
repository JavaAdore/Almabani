package com.almabani.common.entity.schema.admincor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.almabani.common.entity.AbstractEntity;

/**
 * To create ID generator sequence "COM_COUNTRIES_ID_SEQ_GEN": CREATE SEQUENCE
 * "COM_COUNTRIES_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@Table(schema = "ADMINCOR", name = "COM_COUNTRIES")
@SequenceGenerator(name = "ComCountries_Id_Seq_Gen", sequenceName = "COM_COUNTRIES_ID_SEQ_GEN", allocationSize = 1, initialValue = 1)
public class Country extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NUM_COUNTRY", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ComCountries_Id_Seq_Gen")
	private Long id;
	
	@Column(name = "NAM_COUNTRY", nullable = false, length = 100)
	private String countryName;

	@Column(name = "COD_ACRONYM_COUNTRY", length = 3)
	private String countryAbbreviationCode;

	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_LAST_MODIFY", nullable = false)
	private Date lastModificationDate;

	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryAbbreviationCode() {
		return countryAbbreviationCode;
	}

	public void setCountryAbbreviationCode(String countryAbbreviationCode) {
		this.countryAbbreviationCode = countryAbbreviationCode;
	}

	public Date getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getModificationMakerName() {
		return modificationMakerName;
	}

	public void setModificationMakerName(String modificationMakerName) {
		this.modificationMakerName = modificationMakerName;
	}
	
}
