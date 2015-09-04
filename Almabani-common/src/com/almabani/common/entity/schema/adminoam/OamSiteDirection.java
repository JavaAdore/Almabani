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
@Table(schema="ADMINOAM", name = "OAM_SITE_DIRECTIONS")
@SequenceGenerator(name = "OamSiteDirections_Id_Seq_Gen", sequenceName = "ADMINOAM.OAM_SEQ_NUM_SITE_DIRECTION", allocationSize = 1, initialValue = 1)
public class OamSiteDirection extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = -1051664207537477899L;
	
	@Id
	@Column(name = "NUM_SITE_DIRECTION", unique = true, nullable = false, precision = 5, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OamSiteDirections_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "NUM_SITE", referencedColumnName="NUM_SITE", nullable = false)
	private OamSite site;
	
	@Column(name = "DES_SITE_DIRECTION", nullable = false, length = 80)
	private String siteDirectionDescription;
	
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

	public OamSiteDirection() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the site
	 */
	public OamSite getSite() {
		return site;
	}

	/**
	 * @param site the site to set
	 */
	public void setSite(OamSite site) {
		this.site = site;
	}

	/**
	 * @return the siteDirectionDescription
	 */
	public String getSiteDirectionDescription() {
		return siteDirectionDescription;
	}

	/**
	 * @param siteDirectionDescription the siteDirectionDescription to set
	 */
	public void setSiteDirectionDescription(String siteDirectionDescription) {
		this.siteDirectionDescription = siteDirectionDescription;
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
