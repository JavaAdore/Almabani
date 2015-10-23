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
 * To create ID generator sequence "COM_DEP_SECTIONS_ID_SEQ_GEN": CREATE
 * SEQUENCE "COM_DEP_SECTIONS_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@Table( schema="ADMINCOR",name = "COM_DEP_SECTIONS")
@SequenceGenerator(name = "ComDepSections_Id_Seq_Gen", sequenceName = "ADMINCOR.COM_SEQ_NUM_DEP_SECTION", allocationSize = 1, initialValue = 1)
public class DepartmentSection extends AbstractEntity implements
		Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NUM_DEP_SECTION", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ComDepSections_Id_Seq_Gen")
	private Long id;

	@Column(name = "COD_SECTION", nullable = false, length = 15)
	private String sectionCode;

	@Column(name = "COD_USER_RESPONSIBLE", length = 15)
	private String responsibleUserCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_LAST_MODIFY", nullable = false)
	private Date lastModificationDate;

	@Column(name = "IND_ACTIVE", length = 1)
	private String indActive;

	@Column(name = "NAM_SECTION", nullable = false, length = 40)
	private String sectionName;

	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@ManyToOne
	@JoinColumn(name = "NUM_DEPARTMENT" , referencedColumnName="NUM_DEPARTMENT")
	private Department department;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSectionCode() {
		return sectionCode;
	}

	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	public String getResponsibleUserCode() {
		return responsibleUserCode;
	}

	public void setResponsibleUserCode(String responsibleUserCode) {
		this.responsibleUserCode = responsibleUserCode;
	}

	public Date getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	public String getIndActive() {
		return indActive;
	}

	public void setIndActive(String indActive) {
		this.indActive = indActive;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getModificationMakerName() {
		return modificationMakerName;
	}

	public void setModificationMakerName(String modificationMakerName) {
		this.modificationMakerName = modificationMakerName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "DepartmentSection [id=" + id + ", sectionCode=" + sectionCode
				+ ", sectionName=" + sectionName + "]";
	}
}
