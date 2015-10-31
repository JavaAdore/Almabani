package com.almabani.common.entity.schema.adminoam;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.almabani.common.entity.AbstractEntity;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINOAM", name = "OAM_TYPES_DEVICE")
@SequenceGenerator(name = "OamTypesDevice_Id_Seq_Gen", sequenceName = "ADMINOAM.OAM_SEQ_NUM_TYPE_DEVICE", allocationSize = 1, initialValue = 1)
public class OamTypeDevice extends AbstractEntity implements Serializable{

	public OamTypeDevice(Long id) {
		super();
		this.id = id;
	}

	public final static OamTypeDevice FIXED_CAMERAS = new OamTypeDevice(2L);
	public final static OamTypeDevice CCTV_CABINETS = new OamTypeDevice(4L);

	
	private static final long serialVersionUID = 1186413455161829342L;

	@Id
	@Column(name = "NUM_TYPE_DEVICE", unique = true, nullable = false, precision = 3, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OamTypesDevice_Id_Seq_Gen")
	private Long id;

	@Column(name = "DES_TYPE_DEVICE", nullable = false, length = 80)
	private String deviceTypedescription;

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

	public OamTypeDevice() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the deviceTypedescription
	 */
	public String getDeviceTypedescription() {
		return deviceTypedescription;
	}

	/**
	 * @param deviceTypedescription the deviceTypedescription to set
	 */
	public void setDeviceTypedescription(String deviceTypedescription) {
		this.deviceTypedescription = deviceTypedescription;
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
