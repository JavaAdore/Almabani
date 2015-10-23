package com.almabani.common.entity.schema.adminwkf;

import java.io.Serializable;
import java.sql.Blob;
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
@Table(schema="ADMINWKF", name = "WOK_DOCUMENTS_DEMAND")
//@SequenceGenerator(name = "WokDocumentsDemand_Id_Seq_Gen", sequenceName = "ADMINWKF.WOK_DOCUMENTS_DEMAND_ID_SEQ_GEN", allocationSize = 1, initialValue = 1)
public class WokDocumentDemand extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = -1153200783761958440L;

	@Id
	@Column(name = "NUM_DOC_DEMAN", unique = true, nullable = false, precision = 9, scale = 0)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WokDocumentsDemand_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "NUM_DEMAND", referencedColumnName="NUM_DEMAND", nullable = false)
	private WokDemand demand;
	
	@Column(name = "IMA_DOC_DEMAND", nullable = false)
	private Blob imaDocDemand;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;

	public WokDocumentDemand() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the demand
	 */
	public WokDemand getDemand() {
		return demand;
	}

	/**
	 * @param demand the demand to set
	 */
	public void setDemand(WokDemand demand) {
		this.demand = demand;
	}

	/**
	 * @return the imaDocDemand
	 */
	public Blob getImaDocDemand() {
		return imaDocDemand;
	}

	/**
	 * @param imaDocDemand the imaDocDemand to set
	 */
	public void setImaDocDemand(Blob imaDocDemand) {
		this.imaDocDemand = imaDocDemand;
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
