package com.almabani.common.entity.schema.adminsec;

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
import javax.persistence.UniqueConstraint;

import com.almabani.common.entity.AbstractEntity;
import com.almabani.common.entity.schema.admincor.Company;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINSEC", name = "SEC_APPLICATIONS_COMPANIES", uniqueConstraints = @UniqueConstraint(columnNames = {
		"COD_APPLICATION", "NUM_COMPANY" }))
@SequenceGenerator(name = "SecApplicationsCompanies_Id_Seq_Gen", sequenceName = "ADMINSEC.SEC_SEQ_NUM_APP_COMPANY", allocationSize = 1, initialValue = 1)
public class SecApplicationsCompany extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 6771033847934228252L;

	@Id
	@Column(name = "NUM_APPLICATION_COMPANY", unique = true, nullable = false, precision = 9, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SecApplicationsCompanies_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "COD_APPLICATION", referencedColumnName="COD_APPLICATION", nullable = false)
	private SecApplication application;
	
	@ManyToOne
	@JoinColumn(name = "NUM_COMPANY", referencedColumnName="NUM_COMPANY", nullable = false)
	private Company company;
	
	@Column(name = "IND_ACTIVE", nullable = false, length = 1)
	private String indActive;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;
	
	@Transient
	private boolean granted;

	public SecApplicationsCompany() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the application
	 */
	public SecApplication getApplication() {
		return application;
	}

	/**
	 * @param application the application to set
	 */
	public void setApplication(SecApplication application) {
		this.application = application;
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

	public boolean isGranted() {
		return granted;
	}

	public void setGranted(boolean granted) {
		this.granted = granted;
	}
	
}
