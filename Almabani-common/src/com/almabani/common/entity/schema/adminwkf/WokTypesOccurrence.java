package com.almabani.common.entity.schema.adminwkf;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.almabani.common.entity.AbstractEntity;
import com.almabani.common.entity.schema.admincor.Company;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINWKF", name = "WOK_TYPES_OCCURRENCE")
//@SequenceGenerator(name = "WokTypesOccurrence_Id_Seq_Gen", sequenceName = "ADMINWKF.WOK_TYPES_OCCURRENCE_ID_SEQ_GEN", allocationSize = 1, initialValue = 1)
public class WokTypesOccurrence extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = -4410319788627362105L;

	@Id
	@Column(name = "NUM_TYPE_OCCURRENCE", unique = true, nullable = false, precision = 3, scale = 0)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WokTypesOccurrence_Id_Seq_Gen")
	private Long id;
	
	@Column(name = "DES_TYPE_OCCURRENCE", nullable = false, length = 80)
	private String typeOccurrenceDescription;
	
	@Column(name = "IND_NEED_DETAILS", nullable = false, length = 1)
	private String indNeedDetails;
	
	@Column(name = "IND_SEND_EMAIL", nullable = false, length = 1)
	private String indSendEmail;
	
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

	public WokTypesOccurrence() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the typeOccurrenceDescription
	 */
	public String getTypeOccurrenceDescription() {
		return typeOccurrenceDescription;
	}

	/**
	 * @param typeOccurrenceDescription the typeOccurrenceDescription to set
	 */
	public void setTypeOccurrenceDescription(String typeOccurrenceDescription) {
		this.typeOccurrenceDescription = typeOccurrenceDescription;
	}

	/**
	 * @return the indNeedDetails
	 */
	public String getIndNeedDetails() {
		return indNeedDetails;
	}

	/**
	 * @param indNeedDetails the indNeedDetails to set
	 */
	public void setIndNeedDetails(String indNeedDetails) {
		this.indNeedDetails = indNeedDetails;
	}

	/**
	 * @return the indSendEmail
	 */
	public String getIndSendEmail() {
		return indSendEmail;
	}

	/**
	 * @param indSendEmail the indSendEmail to set
	 */
	public void setIndSendEmail(String indSendEmail) {
		this.indSendEmail = indSendEmail;
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
	
}
