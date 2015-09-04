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
@Table(schema="ADMINOAM", name = "OAM_SITE_LOCATIONS")
@SequenceGenerator(name = "OamSiteLocations_Id_Seq_Gen", sequenceName = "ADMINOAM.OAM_SEQ_NUM_SITE_LOCATION", allocationSize = 1, initialValue = 1)
public class OamSiteLocation extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = -8055275475003894076L;
	
	@Id
	@Column(name = "NUM_SITE_LOCATION", unique = true, nullable = false, precision = 6, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OamSiteLocations_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "NUM_SITE_DIRECTION", referencedColumnName="NUM_SITE_DIRECTION", nullable = false)
	private OamSiteDirection siteDirection;
	
	@Column(name = "COD_SITE_LOCATION", nullable = false, length = 10)
	private String siteLocationCode;
	
	@Column(name = "DES_SITE_LOCATION", nullable = false, length = 80)
	private String siteLocationDescription;
	
	@Column(name = "IND_TYPE_LOCATION", nullable = false, length = 1)
	private String indTypeLocation;
	
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

	public OamSiteLocation() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the siteDirection
	 */
	public OamSiteDirection getSiteDirection() {
		return siteDirection;
	}

	/**
	 * @param siteDirection the siteDirection to set
	 */
	public void setSiteDirection(OamSiteDirection siteDirection) {
		this.siteDirection = siteDirection;
	}

	/**
	 * @return the siteLocationCode
	 */
	public String getSiteLocationCode() {
		return siteLocationCode;
	}

	/**
	 * @param siteLocationCode the siteLocationCode to set
	 */
	public void setSiteLocationCode(String siteLocationCode) {
		this.siteLocationCode = siteLocationCode;
	}

	/**
	 * @return the siteLocationDescription
	 */
	public String getSiteLocationDescription() {
		return siteLocationDescription;
	}

	/**
	 * @param siteLocationDescription the siteLocationDescription to set
	 */
	public void setSiteLocationDescription(String siteLocationDescription) {
		this.siteLocationDescription = siteLocationDescription;
	}

	/**
	 * @return the indTypeLocation
	 */
	public String getIndTypeLocation() {
		return indTypeLocation;
	}

	/**
	 * @param indTypeLocation the indTypeLocation to set
	 */
	public void setIndTypeLocation(String indTypeLocation) {
		this.indTypeLocation = indTypeLocation;
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
