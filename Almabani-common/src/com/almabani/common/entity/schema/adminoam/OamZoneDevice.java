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

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINOAM", name = "OAM_ZONE_DEVICES")
@SequenceGenerator(name = "OamZoneDevices_Id_Seq_Gen", sequenceName = "ADMINOAM.OAM_SEQ_NUM_ZONE_DEVICE", allocationSize = 1, initialValue = 1)
public class OamZoneDevice extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 5580091354043445039L;
	
	@Id
	@Column(name = "NUM_ZONE_DEVICE", unique = true, precision = 8, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OamZoneDevices_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "COD_DEVICE", referencedColumnName="COD_DEVICE")
	private OamProjectDevice projectDevice;
	
	@ManyToOne
	@JoinColumn(name = "NUM_REPORT_ZONE", referencedColumnName="NUM_REPORT_ZONE")
	private OamReportingZone reportingZone;
	
	@ManyToOne
	@JoinColumn(name = "NUM_ZONE", referencedColumnName="NUM_ZONE")
	private OamZone zone;
	
	@Column(name = "DES_DEVICE", length = 80)
	private String deviceDescription;
	
	@Column(name = "IND_ACTIVE", length = 1)
	private String indActive;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", length = 10)
	private String modificationMakerName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_LAST_MODIFY", length = 7)
	private Date lastModificationDate;

	public OamZoneDevice() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the projectDevice
	 */
	public OamProjectDevice getProjectDevice() {
		return projectDevice;
	}

	/**
	 * @param projectDevice the projectDevice to set
	 */
	public void setProjectDevice(OamProjectDevice projectDevice) {
		this.projectDevice = projectDevice;
	}

	/**
	 * @return the reportingZone
	 */
	public OamReportingZone getReportingZone() {
		return reportingZone;
	}

	/**
	 * @param reportingZone the reportingZone to set
	 */
	public void setReportingZone(OamReportingZone reportingZone) {
		this.reportingZone = reportingZone;
	}

	/**
	 * @return the zone
	 */
	public OamZone getZone() {
		return zone;
	}

	/**
	 * @param zone the zone to set
	 */
	public void setZone(OamZone zone) {
		this.zone = zone;
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
	
}
