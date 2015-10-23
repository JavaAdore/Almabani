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
@Table(schema="ADMINOAM", name = "OAM_EMP_DAILY_ALLOCATION")
@SequenceGenerator(name = "OamEmpDailyAllocation_Id_Seq_Gen", sequenceName = "ADMINOAM.OAM_SEQ_NUM_EMP_DAY_ALLOCATION", allocationSize = 1, initialValue = 1)
public class OamEmpDailyAllocation extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = -8394638178844770538L;

	@Id
	@Column(name = "NUM_EMP_DAY_ALLOCATION", unique = true, nullable = false, precision = 9, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OamEmpDailyAllocation_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "NUM_EMP_MON_ALLOCATION", referencedColumnName="NUM_EMP_MON_ALLOCATION", nullable = false)
	private OamEmpMonthlyAllocation empMonthlyAllocation;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_DAY_ALLOCATION", nullable = false, length = 7)
	private Date allocationDayDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_HOUR_BEGIN_ALLOCATION", length = 7)
	private Date allocationBeginHourDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_HOUR_END_ALLOCATION", length = 7)
	private Date allocationEndHourDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_HOUR_BEGIN_ALLOCATION_REAL", length = 7)
	private Date realAllocationBeginHourDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_HOUR_END_ALLOCATION_REAL", length = 7)
	private Date realAllocationEndHourDate;
	
	@Column(name = "IND_REST_DAY", nullable = false, length = 1)
	private String indRestDay;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;

	public OamEmpDailyAllocation() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OamEmpMonthlyAllocation getEmpMonthlyAllocation() {
		return empMonthlyAllocation;
	}

	public void setEmpMonthlyAllocation(OamEmpMonthlyAllocation empMonthlyAllocation) {
		this.empMonthlyAllocation = empMonthlyAllocation;
	}

	public Date getAllocationDayDate() {
		return allocationDayDate;
	}

	public void setAllocationDayDate(Date allocationDayDate) {
		this.allocationDayDate = allocationDayDate;
	}

	public Date getAllocationBeginHourDate() {
		return allocationBeginHourDate;
	}

	public void setAllocationBeginHourDate(Date allocationBeginHourDate) {
		this.allocationBeginHourDate = allocationBeginHourDate;
	}

	public Date getAllocationEndHourDate() {
		return allocationEndHourDate;
	}

	public void setAllocationEndHourDate(Date allocationEndHourDate) {
		this.allocationEndHourDate = allocationEndHourDate;
	}

	public Date getRealAllocationBeginHourDate() {
		return realAllocationBeginHourDate;
	}

	public void setRealAllocationBeginHourDate(Date realAllocationBeginHourDate) {
		this.realAllocationBeginHourDate = realAllocationBeginHourDate;
	}

	public Date getRealAllocationEndHourDate() {
		return realAllocationEndHourDate;
	}

	public void setRealAllocationEndHourDate(Date realAllocationEndHourDate) {
		this.realAllocationEndHourDate = realAllocationEndHourDate;
	}

	public String getIndRestDay() {
		return indRestDay;
	}

	public void setIndRestDay(String indRestDay) {
		this.indRestDay = indRestDay;
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
