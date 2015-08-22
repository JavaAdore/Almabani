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
@Table(schema="ADMINOAM", name = "OAM_ITEM_QUOTATIONS")
@SequenceGenerator(name = "OamItemQuotations_Id_Seq_Gen", sequenceName = "ADMINOAM.OAM_SEQ_NUM_ITEM_QUOTATION", allocationSize = 1, initialValue = 1)
public class OamItemQuotation extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 4712509499440223342L;

	@Id
	@Column(name = "NUM_ITEM_QUOTATION", unique = true, nullable = false, precision = 12, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OamItemQuotations_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "NUM_QUOTATION", referencedColumnName="NUM_QUOTATION", nullable = false)
	private OamQuotation quotation;
	
	@ManyToOne
	@JoinColumn(name = "NUM_PROJECT_ITEM", referencedColumnName="NUM_PROJECT_ITEM")
	private OamProjectItem projectItem;
	
	@Column(name = "QUT_ITEM", nullable = false, precision = 3, scale = 0)
	private Integer qutItem;
	
	@Column(name = "DES_OBSERVATION", length = 80)
	private String observationDescription;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;

	public OamItemQuotation() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OamQuotation getQuotation() {
		return quotation;
	}

	public void setQuotation(OamQuotation quotation) {
		this.quotation = quotation;
	}

	public OamProjectItem getProjectItem() {
		return projectItem;
	}

	public void setProjectItem(OamProjectItem projectItem) {
		this.projectItem = projectItem;
	}

	public Integer getQutItem() {
		return qutItem;
	}

	public void setQutItem(Integer qutItem) {
		this.qutItem = qutItem;
	}

	public String getObservationDescription() {
		return observationDescription;
	}

	public void setObservationDescription(String observationDescription) {
		this.observationDescription = observationDescription;
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
