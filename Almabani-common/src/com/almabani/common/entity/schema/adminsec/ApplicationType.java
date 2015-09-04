	package com.almabani.common.entity.schema.adminsec;

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
@Table(schema="ADMINSEC", name = "SEC_TYPES_APPLICATION")
@SequenceGenerator(name = "SecTypesApplication_Id_Seq_Gen", sequenceName = "ADMINSEC.SEC_SEQ_NUM_TYPE_APPLICATION", allocationSize = 1, initialValue = 1)
public class ApplicationType extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = -6912851314863919976L;

	@Id
	@Column(name = "NUM_TYPE_APPLICATION", unique = true, nullable = false, precision = 2, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SecTypesApplication_Id_Seq_Gen")
	private Long id;
	
	@Column(name = "DES_TYPE_APPLICATION", nullable = false, length = 50)
	private String applicationTypedescription;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;

	public ApplicationType() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the applicationTypedescription
	 */
	public String getApplicationTypedescription() {
		return applicationTypedescription;
	}

	/**
	 * @param applicationTypedescription the applicationTypedescription to set
	 */
	public void setApplicationTypedescription(String applicationTypedescription) {
		this.applicationTypedescription = applicationTypedescription;
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
