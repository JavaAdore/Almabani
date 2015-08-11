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
 * To create ID generator sequence "COM_COMPANIES_ID_SEQ_GEN": CREATE SEQUENCE
 * "COM_COMPANIES_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */

@Entity
@Table(schema="ADMINCOR" ,name = "COM_COMPANIES")
@SequenceGenerator(name = "ComCompanies_Id_Seq_Gen", sequenceName = "COM_COMPANIES_ID_SEQ_GEN", allocationSize = 50, initialValue = 50)
public class Company extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = -2498719625804108167L;

	@Id
	@Column(name = "NUM_COMPANY", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ComCompanies_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "NUM_COUNTRY", referencedColumnName = "NUM_COUNTRY", nullable = false),
			@JoinColumn(name = "COD_STATE", referencedColumnName = "COD_STATE", nullable = false) })
	private State state;
	
	@Column(name = "NAM_COMPANY", nullable = false, length = 80)
	private String companyName;
	
	@Column(name = "NAM_COMPANY_ALTERNATIVE", length = 100)
	private String alternativeCompanyName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Column(name = "COD_IDENTITY_FEDERAL", nullable = false, length = 30)
	private String federalIdentityCode;
	
	@Column(name = "IND_SYSTEM_LANGUAGE", nullable = false, length = 1)
	private String indSystemLanguage;

	public Company() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFederalIdentityCode() {
		return federalIdentityCode;
	}

	public void setFederalIdentityCode(String federalIdentityCode) {
		this.federalIdentityCode = federalIdentityCode;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAlternativeCompanyName() {
		return alternativeCompanyName;
	}

	public void setAlternativeCompanyName(String alternativeCompanyName) {
		this.alternativeCompanyName = alternativeCompanyName;
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

	public String getIndSystemLanguage() {
		return indSystemLanguage;
	}

	public void setIndSystemLanguage(String indSystemLanguage) {
		this.indSystemLanguage = indSystemLanguage;
	}

	public void assignLastModificationDate() {
		lastModificationDate = new Date();		
	}
	
}
