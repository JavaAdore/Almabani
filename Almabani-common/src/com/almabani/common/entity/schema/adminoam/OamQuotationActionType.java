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
@Table(schema="ADMINOAM", name = "OAM_TYPES_QUOT_ACTIONS")
@SequenceGenerator(name = "OamTypesQuotActions_Id_Seq_Gen", sequenceName = "ADMINOAM.OAM_SEQ_NUM_TYPE_QUOT_ACTION", allocationSize = 1, initialValue = 1)
public class OamQuotationActionType extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 7544673398792503287L;
	
	 
	
	
	@Id
	@Column(name = "NUM_TYPE_QUOT_ACTION", unique = true, nullable = false, precision = 3, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OamTypesQuotActions_Id_Seq_Gen")
	private Long id;
	
	@Column(name = "DES_TYPE_QUOT_ACTION", nullable = false, length = 80)
	private String typeQuotActionDescription;
	
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
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;
	
	@Column(name = "IND_PENDING", nullable = false, length = 1)
	private String indPending;

	public OamQuotationActionType() {
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
	 * @return the typeQuotActionDescription
	 */
	public String getTypeQuotActionDescription() {
		return typeQuotActionDescription;
	}

	/**
	 * @param typeQuotActionDescription the typeQuotActionDescription to set
	 */
	public void setTypeQuotActionDescription(String typeQuotActionDescription) {
		this.typeQuotActionDescription = typeQuotActionDescription;
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
