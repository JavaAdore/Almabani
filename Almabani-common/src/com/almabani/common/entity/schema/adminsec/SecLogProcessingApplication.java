package com.almabani.common.entity.schema.adminsec;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(schema="ADMINSEC", name = "SEC_LOG_PROCESSING_APPLICATION")
@SequenceGenerator(name = "SecLogProcessingApplication_Id_Seq_Gen", sequenceName = "ADMINSEC.SEC_SEQ_NUM_LOG_PROCESSING", allocationSize = 1, initialValue = 1)
public class SecLogProcessingApplication extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = -199347732510063801L;

	@Id
	@Column(name = "NUM_LOG_PROCESSING", unique = true, nullable = false, precision = 12, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SecLogProcessingApplication_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "DAT_PROCESSING", referencedColumnName = "DAT_PROCESSING", nullable = false),
			@JoinColumn(name = "COD_APPLICATION", referencedColumnName = "COD_APPLICATION", nullable = false) })
	private SecProcessingApplication processingApplication;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_LOG_PROCESSING", nullable = false, length = 7)
	private Date logProcessingDate;
	
	@Column(name = "DES_LOG_PROCESSING", nullable = false, length = 240)
	private String logProcessingDescription;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;

	public SecLogProcessingApplication() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the processingApplication
	 */
	public SecProcessingApplication getProcessingApplication() {
		return processingApplication;
	}

	/**
	 * @param processingApplication the processingApplication to set
	 */
	public void setProcessingApplication(
			SecProcessingApplication processingApplication) {
		this.processingApplication = processingApplication;
	}

	/**
	 * @return the logProcessingDate
	 */
	public Date getLogProcessingDate() {
		return logProcessingDate;
	}

	/**
	 * @param logProcessingDate the logProcessingDate to set
	 */
	public void setLogProcessingDate(Date logProcessingDate) {
		this.logProcessingDate = logProcessingDate;
	}

	/**
	 * @return the logProcessingDescription
	 */
	public String getLogProcessingDescription() {
		return logProcessingDescription;
	}

	/**
	 * @param logProcessingDescription the logProcessingDescription to set
	 */
	public void setLogProcessingDescription(String logProcessingDescription) {
		this.logProcessingDescription = logProcessingDescription;
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
	
}
