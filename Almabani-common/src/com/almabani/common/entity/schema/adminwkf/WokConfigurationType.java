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
@Table(schema="ADMINWKF", name = "WOK_CONFIGURATIONS_TYPES")
//@SequenceGenerator(name = "WokConfigurationsTypes_Id_Seq_Gen", sequenceName = "ADMINWKF.WOK_CONFIGURATIONS_TYPES_ID_SEQ_GEN", allocationSize = 1, initialValue = 1)
public class WokConfigurationType extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 3303596609993145985L;

	@Id
	@Column(name = "NUM_CONFIGURATION_TYPE", unique = true, nullable = false, precision = 4, scale = 0)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WokConfigurationsTypes_Id_Seq_Gen")
	private Long id;
	
	@Column(name = "DES_CONFIGURATION_TYPE", nullable = false, length = 80)
	private String configurationTypeDescription;
	
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
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;

	public WokConfigurationType() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the configurationTypeDescription
	 */
	public String getConfigurationTypeDescription() {
		return configurationTypeDescription;
	}

	/**
	 * @param configurationTypeDescription the configurationTypeDescription to set
	 */
	public void setConfigurationTypeDescription(String configurationTypeDescription) {
		this.configurationTypeDescription = configurationTypeDescription;
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
