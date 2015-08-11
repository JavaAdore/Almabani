package com.almabani.common.entity.schema.adminwkf;

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
import javax.persistence.UniqueConstraint;

import com.almabani.common.entity.AbstractEntity;
import com.almabani.common.entity.schema.admincor.Project;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINWKF", name = "WOK_WORKING_GROUPS", uniqueConstraints = @UniqueConstraint(columnNames = "COD_WORKING_GROUP"))
@SequenceGenerator(name = "WokWorkingGroups_Id_Seq_Gen", sequenceName = "WOK_WORKING_GROUPS_ID_SEQ_GEN", allocationSize = 50, initialValue = 50)
public class WokWorkingGroup extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = -5964225776479051957L;

	@Id
	@Column(name = "NUM_WORKING_GROUP", unique = true, nullable = false, precision = 5, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WokWorkingGroups_Id_Seq_Gen")
	private Long id;
	
	@Column(name = "COD_WORKING_GROUP", unique = true, nullable = false, length = 15)
	private String workingGroupCode;
	
	@Column(name = "DES_WORKING_GROUP", nullable = false, length = 80)
	private String workingGroupDescription;
	
	@ManyToOne
	@JoinColumn(name = "NUM_PROJECT", referencedColumnName="NUM_PROJECT", nullable = false)
	private Project project;
	
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
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_HOUR_START_OPERATION", length = 7)
	private Date startOperationHourDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_HOUR_END_OPERATION", length = 7)
	private Date endOperationHourDate;
	
	@Column(name = "IND_TYPE_WORKING_DAYS", length = 1)
	private String indTypeWorkingDays;

	public WokWorkingGroup() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the workingGroupCode
	 */
	public String getWorkingGroupCode() {
		return workingGroupCode;
	}

	/**
	 * @param workingGroupCode the workingGroupCode to set
	 */
	public void setWorkingGroupCode(String workingGroupCode) {
		this.workingGroupCode = workingGroupCode;
	}

	/**
	 * @return the workingGroupDescription
	 */
	public String getWorkingGroupDescription() {
		return workingGroupDescription;
	}

	/**
	 * @param workingGroupDescription the workingGroupDescription to set
	 */
	public void setWorkingGroupDescription(String workingGroupDescription) {
		this.workingGroupDescription = workingGroupDescription;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * @return the validityBeginDate
	 */
	public Date getValidityBeginDate() {
		return validityBeginDate;
	}

	/**
	 * @param validityBeginDate the validityBeginDate to set
	 */
	public void setValidityBeginDate(Date validityBeginDate) {
		this.validityBeginDate = validityBeginDate;
	}

	/**
	 * @return the validityEndDate
	 */
	public Date getValidityEndDate() {
		return validityEndDate;
	}

	/**
	 * @param validityEndDate the validityEndDate to set
	 */
	public void setValidityEndDate(Date validityEndDate) {
		this.validityEndDate = validityEndDate;
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

	/**
	 * @return the startOperationHourDate
	 */
	public Date getStartOperationHourDate() {
		return startOperationHourDate;
	}

	/**
	 * @param startOperationHourDate the startOperationHourDate to set
	 */
	public void setStartOperationHourDate(Date startOperationHourDate) {
		this.startOperationHourDate = startOperationHourDate;
	}

	/**
	 * @return the endOperationHourDate
	 */
	public Date getEndOperationHourDate() {
		return endOperationHourDate;
	}

	/**
	 * @param endOperationHourDate the endOperationHourDate to set
	 */
	public void setEndOperationHourDate(Date endOperationHourDate) {
		this.endOperationHourDate = endOperationHourDate;
	}

	/**
	 * @return the indTypeWorkingDays
	 */
	public String getIndTypeWorkingDays() {
		return indTypeWorkingDays;
	}

	/**
	 * @param indTypeWorkingDays the indTypeWorkingDays to set
	 */
	public void setIndTypeWorkingDays(String indTypeWorkingDays) {
		this.indTypeWorkingDays = indTypeWorkingDays;
	}
	
}
