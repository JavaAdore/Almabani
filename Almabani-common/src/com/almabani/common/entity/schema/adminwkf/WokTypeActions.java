package com.almabani.common.entity.schema.adminwkf;

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
@Table(schema="ADMINWKF", name = "WOK_TYPES_ACTIONS")
@SequenceGenerator(name = "WokTypesActions_Id_Seq_Gen", sequenceName = "WOK_TYPES_ACTIONS_ID_SEQ_GEN", allocationSize = 50, initialValue = 50)
public class WokTypeActions extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = -1643100131820683157L;

	@Id
	@Column(name = "NUM_TYPE_ACTION", unique = true, nullable = false, precision = 3, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WokTypesActions_Id_Seq_Gen")
	private Long id;
	
	@Column(name = "DES_TYPE_ACTION", nullable = false, length = 80)
	private String typeActiondescription;
	
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
	
	@Column(name = "IND_PENDING", nullable = false, length = 1)
	private String indPending;

	public WokTypeActions() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the typeActiondescription
	 */
	public String getTypeActiondescription() {
		return typeActiondescription;
	}

	/**
	 * @param typeActiondescription the typeActiondescription to set
	 */
	public void setTypeActiondescription(String typeActiondescription) {
		this.typeActiondescription = typeActiondescription;
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

	/**
	 * @return the indPending
	 */
	public String getIndPending() {
		return indPending;
	}

	/**
	 * @param indPending the indPending to set
	 */
	public void setIndPending(String indPending) {
		this.indPending = indPending;
	}
	
}
