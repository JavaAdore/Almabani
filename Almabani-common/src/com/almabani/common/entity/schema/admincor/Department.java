package com.almabani.common.entity.schema.admincor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
import javax.persistence.Transient;

import com.almabani.common.entity.AbstractEntity;
import com.almabani.common.enums.Active;

/**
 * To create ID generator sequence "COM_DEPARTMENTS_ID_SEQ_GEN": CREATE SEQUENCE
 * "COM_DEPARTMENTS_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@Table(schema="ADMINCOR",name = "COM_DEPARTMENTS")
@SequenceGenerator(name = "ComDepartments_Id_Seq_Gen", sequenceName = "ADMINCOR.COM_SEQ_NUM_DEPARTMENT", allocationSize = 1, initialValue = 1)
public class Department extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NUM_DEPARTMENT", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ComDepartments_Id_Seq_Gen")
	private Long id;

	@Column(name = "COD_DEPARTMENT", nullable = false, length = 15)
	private String departmentCode;

	@Column(name = "COD_USER_RESPONSIBLE", length = 15)
	private String responsibleUserCode;

	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_LAST_MODIFY", nullable = false)
	private Date lastModificationDate;

//	@Convert(converter = ActiveConverter.class)
	@Enumerated(EnumType.STRING)
	@Column(name = "IND_ACTIVE", nullable = false, length = 1)
	private Active active;

	@Column(name = "NAM_DEPARTMENT", nullable = false, length = 40)
	private String departmentName;

	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;

	@ManyToOne
	@JoinColumn(name = "NUM_COMPANY", referencedColumnName = "NUM_COMPANY")
	private Company company;
	
	@Transient
	private List<DepartmentSection> departmentSections;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
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

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public String getModificationMakerName() {
		return modificationMakerName;
	}

	public void setModificationMakerName(String modificationMakerName) {
		this.modificationMakerName = modificationMakerName;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	public List<DepartmentSection> getDepartmentSections() {
		return departmentSections;
	}

	public void setDepartmentSections(List<DepartmentSection> departmentSections) {
		this.departmentSections = departmentSections;
	}


	@Override
	public String toString() { 
		return  String.format("( %s ) %s", departmentCode , departmentName);
	}
	
	

}
