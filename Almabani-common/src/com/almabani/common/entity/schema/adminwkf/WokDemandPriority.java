package com.almabani.common.entity.schema.adminwkf;

import java.io.Serializable;
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
@Table(schema="ADMINWKF", name = "WOK_DEMANDS_PRIORITY")
//@SequenceGenerator(name = "WokDemandsPriority_Id_Seq_Gen", sequenceName = "ADMINWKF.WOK_DEMANDS_PRIORITY_ID_SEQ_GEN", allocationSize = 1, initialValue = 1)
public class WokDemandPriority extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = -5381874645673313869L;

	@Id
	@Column(name = "NUM_PRIORITY", unique = true, nullable = false, precision = 3, scale = 0)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WokDemandsPriority_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "NUM_TYPE_DEMAND", referencedColumnName="NUM_TYPE_DEMAND", nullable = false)
	private WokTypeDemand typeDemand;
	
	@Column(name = "DES_PRIORITY", nullable = false, length = 80)
	private String priorityDescription;
	
	@Column(name = "QUT_HOURS_VIOLATION_SLA_INC", nullable = false, precision = 5, scale = 0)
	private int qutHoursViolationSla;
	
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

	public WokDemandPriority() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the typeDemand
	 */
	public WokTypeDemand getTypeDemand() {
		return typeDemand;
	}

	/**
	 * @param typeDemand the typeDemand to set
	 */
	public void setTypeDemand(WokTypeDemand typeDemand) {
		this.typeDemand = typeDemand;
	}

	/**
	 * @return the priorityDescription
	 */
	public String getPriorityDescription() {
		return priorityDescription;
	}

	/**
	 * @param priorityDescription the priorityDescription to set
	 */
	public void setPriorityDescription(String priorityDescription) {
		this.priorityDescription = priorityDescription;
	}

	/**
	 * @return the qutHoursViolationSla
	 */
	public int getQutHoursViolationSla() {
		return qutHoursViolationSla;
	}

	/**
	 * @param qutHoursViolationSla the qutHoursViolationSla to set
	 */
	public void setQutHoursViolationSla(int qutHoursViolationSla) {
		this.qutHoursViolationSla = qutHoursViolationSla;
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
