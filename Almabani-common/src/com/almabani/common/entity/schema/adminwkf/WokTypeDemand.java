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
import javax.persistence.UniqueConstraint;

import com.almabani.common.entity.AbstractEntity;
import com.almabani.common.entity.schema.admincor.Company;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINWKF", name = "WOK_TYPES_DEMAND", uniqueConstraints = @UniqueConstraint(columnNames = {
		"NUM_COMPANY", "IND_CATEGORY" }))
@SequenceGenerator(name = "WokTypesDemand_Id_Seq_Gen", sequenceName = "WOK_TYPES_DEMAND_ID_SEQ_GEN", allocationSize = 1, initialValue = 1)
public class WokTypeDemand extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = -8176905469413603637L;

	@Id
	@Column(name = "NUM_TYPE_DEMAND", unique = true, nullable = false, precision = 3, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WokTypesDemand_Id_Seq_Gen")
	private Long id;
	
	@Column(name = "DES_TYPE_DEMAND", nullable = false, length = 80)
	private String typeDemandDescription;
	
	@ManyToOne
	@JoinColumn(name = "NUM_COMPANY", referencedColumnName="NUM_COMPANY", nullable = false)
	private Company company;
	
	@Column(name = "IND_CATEGORY", nullable = false, length = 1)
	private String indCategory;
	
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

	public WokTypeDemand() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the typeDemandDescription
	 */
	public String getTypeDemandDescription() {
		return typeDemandDescription;
	}

	/**
	 * @param typeDemandDescription the typeDemandDescription to set
	 */
	public void setTypeDemandDescription(String typeDemandDescription) {
		this.typeDemandDescription = typeDemandDescription;
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
	 * @return the indCategory
	 */
	public String getIndCategory() {
		return indCategory;
	}

	/**
	 * @param indCategory the indCategory to set
	 */
	public void setIndCategory(String indCategory) {
		this.indCategory = indCategory;
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
