package com.almabani.common.entity.schema.adminoam;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.almabani.common.entity.schema.admincor.Project;
import com.almabani.common.entity.schema.adminwkf.WokConfigurationItem;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINOAM", name = "OAM_PROJECT_DEVICES")
@SequenceGenerator(name = "OamProjectDevices_Id_Seq_Gen", sequenceName = "OAM_PROJECT_DEVICES_SEQ_GEN", allocationSize = 1, initialValue = 1)
public class OamProjectDevice implements Serializable {
	
	private static final long serialVersionUID = -2834931858810448899L;
	
	@Id
	@Column(name = "COD_DEVICE", unique = true, nullable = false, length = 30)
	private String deviceCode;
	
	@ManyToOne
	@JoinColumn(name = "NUM_TYPE_DEVICE", referencedColumnName="NUM_TYPE_DEVICE", nullable = false)
	private OamTypeDevice deviceType;
	
	@ManyToOne
	@JoinColumn(name = "NUM_PROJECT", referencedColumnName="NUM_PROJECT", nullable = false)
	private Project project;
	
	@Column(name = "DES_DEVICE", length = 80)
	private String deviceDescription;
	
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
	
	@ManyToOne
	@JoinColumn(name = "NUM_CONFIGURATION_ITEM", referencedColumnName="NUM_CONFIGURATION_ITEM", nullable = false)
	private WokConfigurationItem configurationItem;
	
	@Column(name = "COD_IP_DEVICE", length = 30)
	private String deviceIpCode;

	public OamProjectDevice() {
	}

	/**
	 * @return the deviceCode
	 */
	public String getDeviceCode() {
		return deviceCode;
	}

	/**
	 * @param deviceCode the deviceCode to set
	 */
	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	/**
	 * @return the deviceType
	 */
	public OamTypeDevice getDeviceType() {
		return deviceType;
	}

	/**
	 * @param deviceType the deviceType to set
	 */
	public void setDeviceType(OamTypeDevice deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * @return the deviceDescription
	 */
	public String getDeviceDescription() {
		return deviceDescription;
	}

	/**
	 * @param deviceDescription the deviceDescription to set
	 */
	public void setDeviceDescription(String deviceDescription) {
		this.deviceDescription = deviceDescription;
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
	 * @return the configurationItem
	 */
	public WokConfigurationItem getConfigurationItem() {
		return configurationItem;
	}

	/**
	 * @param configurationItem the configurationItem to set
	 */
	public void setConfigurationItem(WokConfigurationItem configurationItem) {
		this.configurationItem = configurationItem;
	}

	/**
	 * @return the deviceIpCode
	 */
	public String getDeviceIpCode() {
		return deviceIpCode;
	}

	/**
	 * @param deviceIpCode the deviceIpCode to set
	 */
	public void setDeviceIpCode(String deviceIpCode) {
		this.deviceIpCode = deviceIpCode;
	}	
}
