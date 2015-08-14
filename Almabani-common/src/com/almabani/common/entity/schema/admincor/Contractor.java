package com.almabani.common.entity.schema.admincor;

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
@Table(schema="ADMINCOR" ,name = "COM_CONTRACTORS")
@SequenceGenerator(name = "ComContractors_Id_Seq_Gen", sequenceName = "COM_CONTRACTORS_ID_SEQ_GEN", allocationSize = 50, initialValue = 50)
public class Contractor extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = -2851871687239799754L;
	
	@Id
	@Column(name = "NUM_CONTRACTOR", unique = true, nullable = false, precision = 3, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ComContractors_Id_Seq_Gen")
	private Long id;
	
	
	
	@Column(name = "DES_CONTRACTOR", nullable = false, length = 60)
	private String contractorDescription;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_BEGIN_VALIDITY", nullable = false, length = 7)
	private Date validityBeginDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_END_VALIDITY", length = 7)
	private Date validityEndDate;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;

	public Contractor() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getContractorDescription() {
		return contractorDescription;
	}

	public void setContractorDescription(String contractorDescription) {
		this.contractorDescription = contractorDescription;
	}

	public Date getValidityBeginDate() {
		return validityBeginDate;
	}

	public void setValidityBeginDate(Date validityBeginDate) {
		this.validityBeginDate = validityBeginDate;
	}

	public Date getValidityEndDate() {
		return validityEndDate;
	}

	public void setValidityEndDate(Date validityEndDate) {
		this.validityEndDate = validityEndDate;
	}

	public String getModificationMakerName() {
		return modificationMakerName;
	}

	public void setModificationMakerName(String modificationMakerName) {
		this.modificationMakerName = modificationMakerName;
	}

	public Date getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}
	
}
