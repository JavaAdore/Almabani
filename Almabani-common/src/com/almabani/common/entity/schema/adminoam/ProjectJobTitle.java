package com.almabani.common.entity.schema.adminoam;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import com.almabani.common.entity.schema.admincor.Project;
import com.almabani.common.enums.Active;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINOAM", name = "OAM_PROJECT_JOB_TITLES")
@SequenceGenerator(name = "OamProjectJobTitles_Id_Seq_Gen", sequenceName = "ADMINOAM.OAM_SEQ_NUM_PROJECT_JOB_TITLE", allocationSize = 50, initialValue = 50)
public class ProjectJobTitle extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = -1684308762515128512L;
	
	@Id
	@Column(name = "NUM_PROJECT_JOB_TITLE", unique = true, nullable = false, precision = 3, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OamProjectJobTitles_Id_Seq_Gen")
	private Long id;
	
	@Column(name = "DES_PROJECT_JOB_TITLE", nullable = false, length = 80)
	private String projectJobTitleDescription;
	
	@ManyToOne
	@JoinColumn(name = "NUM_PROJECT", referencedColumnName="NUM_PROJECT", nullable = false)
	private Project project;
	
	@Column(name = "VAL_CONTRACTOR", precision = 15)
	private Integer contractorValue;
	
//	@Convert(converter = ActiveConverter.class)
	@Enumerated(EnumType.STRING)
	@Column(name = "IND_ACTIVE", nullable = false, length = 1)
	private Active active;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;
	
	@Column(name = "VAL_CONTRACTOR_AGREEMENT", precision = 15)
	private Integer contractorAgreementValue;
	
	public ProjectJobTitle() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the projectJobTitleDescription
	 */
	public String getProjectJobTitleDescription() {
		return projectJobTitleDescription;
	}

	/**
	 * @param projectJobTitleDescription the projectJobTitleDescription to set
	 */
	public void setProjectJobTitleDescription(String projectJobTitleDescription) {
		this.projectJobTitleDescription = projectJobTitleDescription;
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
	 * @return the contractorValue
	 */
	public Integer getContractorValue() {
		return contractorValue;
	}

	/**
	 * @param contractorValue the contractorValue to set
	 */
	public void setContractorValue(Integer contractorValue) {
		this.contractorValue = contractorValue;
	}
	
	/**
	 * @return the active
	 */
	public Active getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(Active active) {
		this.active = active;
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
	
	public Integer getContractorAgreementValue() {
		return contractorAgreementValue;
	}

	public void setContractorAgreementValue(Integer contractorAgreementValue) {
		this.contractorAgreementValue = contractorAgreementValue;
	}
	
}
