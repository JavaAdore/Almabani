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

/**
 * @author Mohamed_Ibrahim
 */ 

@Entity
@Table(schema="ADMINWKF", name = "WOK_CONFIGURATIONS_ITEM")
//@SequenceGenerator(name = "WokConfigurationsItem_Id_Seq_Gen", sequenceName = "ADMINWKF.WOK_CONFIGURATIONS_ITEM_ID_SEQ_GEN", allocationSize = 1, initialValue = 1)
public class WokConfigurationItem extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = -3396753552647742778L;

	@Id
	@Column(name = "NUM_CONFIGURATION_ITEM", unique = true, nullable = false, precision = 5, scale = 0)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WokConfigurationsItem_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "NUM_CONFIGURATION_TYPE", referencedColumnName="NUM_CONFIGURATION_TYPE", nullable = false)
	private WokConfigurationType configurationType;
	
	@Column(name = "DES_CONFIGURATION_ITEM", nullable = false, length = 80)
	private String configurationItemDescription;
	
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
	
	@Column(name = "COD_CONFIGURATION_ITEM", nullable = false, length = 10)
	private String configurationItemCode;

	public WokConfigurationItem() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the configurationType
	 */
	public WokConfigurationType getConfigurationType() {
		return configurationType;
	}

	/**
	 * @param configurationType the configurationType to set
	 */
	public void setConfigurationType(WokConfigurationType configurationType) {
		this.configurationType = configurationType;
	}

	/**
	 * @return the configurationItemDescription
	 */
	public String getConfigurationItemDescription() {
		return configurationItemDescription;
	}

	/**
	 * @param configurationItemDescription the configurationItemDescription to set
	 */
	public void setConfigurationItemDescription(String configurationItemDescription) {
		this.configurationItemDescription = configurationItemDescription;
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
	 * @return the configurationItemCode
	 */
	public String getConfigurationItemCode() {
		return configurationItemCode;
	}

	/**
	 * @param configurationItemCode the configurationItemCode to set
	 */
	public void setConfigurationItemCode(String configurationItemCode) {
		this.configurationItemCode = configurationItemCode;
	}
	
}
