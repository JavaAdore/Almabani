package com.almabani.common.entity.schema.adminsec;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINSEC", name = "SEC_PROCESSING_APPLICATIONS")
public class SecProcessingApplication implements java.io.Serializable {
	
	private static final long serialVersionUID = 1631764973340621905L;

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "datProcessing", column = @Column(name = "DAT_PROCESSING", nullable = false, length = 7)),
			@AttributeOverride(name = "codApplication", column = @Column(name = "COD_APPLICATION", nullable = false, length = 8)) })
	private SecProcessingApplicationsId id;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;

	public SecProcessingApplication() {
	}

	/**
	 * @return the id
	 */
	public SecProcessingApplicationsId getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(SecProcessingApplicationsId id) {
		this.id = id;
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
