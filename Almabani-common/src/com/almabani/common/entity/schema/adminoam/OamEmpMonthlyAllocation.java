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
@Table(schema="ADMINOAM", name = "OAM_EMP_MONTHLY_ALLOCATION")
@SequenceGenerator(name = "OamEmpMonthlyAllocation_Id_Seq_Gen", sequenceName = "adminoam.OAM_SEQ_NUM_EMP_MON_ALLOCATION", allocationSize = 1, initialValue = 1)
public class OamEmpMonthlyAllocation extends AbstractEntity implements Serializable {
	    
	private static final long serialVersionUID = -7850203435939341007L;

	@Id
	@Column(name = "NUM_EMP_MON_ALLOCATION", unique = true, nullable = false, precision = 9, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OamEmpMonthlyAllocation_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "NUM_PROJECT_EMPLOYEE", referencedColumnName="NUM_PROJECT_EMPLOYEE", nullable = false)
	private ProjectEmployee projectEmployee;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_MONTH_ALLOCATION", nullable = false, length = 7)
	private Date allocationMonthDate;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_BEGIN_ALLOCATION", nullable = false, length = 7)
	private Date allocationBeginDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_END_ALLOCATION", nullable = false, length = 7)
	private Date allocationEndDate;

	public OamEmpMonthlyAllocation() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProjectEmployee getProjectEmployee() {
		return projectEmployee;
	}

	public void setProjectEmployee(ProjectEmployee projectEmployee) {
		this.projectEmployee = projectEmployee;
	}

	public Date getAllocationMonthDate() {
		return allocationMonthDate;
	}

	public void setAllocationMonthDate(Date allocationMonthDate) {
		this.allocationMonthDate = allocationMonthDate;
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

	public Date getAllocationBeginDate() {
		return allocationBeginDate;
	}

	public void setAllocationBeginDate(Date allocationBeginDate) {
		this.allocationBeginDate = allocationBeginDate;
	}

	public Date getAllocationEndDate() {
		return allocationEndDate;
	}

	public void setAllocationEndDate(Date allocationEndDate) {
		this.allocationEndDate = allocationEndDate;
	}
	
}
