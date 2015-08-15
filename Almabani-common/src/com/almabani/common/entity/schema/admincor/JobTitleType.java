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
 * To create ID generator sequence "COM_TYPES_JOB_TITLE_ID_SEQ_GEN":
 * CREATE SEQUENCE "COM_TYPES_JOB_TITLE_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@Table( schema="ADMINCOR",name = "COM_TYPES_JOB_TITLE")
@SequenceGenerator(name = "ComTypesJobTitle_Id_Seq_Gen", sequenceName = "ADMINCOR.COM_SEQ_NUM_TYPE_JOB_TITLE",
                   allocationSize = 50, initialValue = 50)
public class JobTitleType extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "NUM_TYPE_JOB_TITLE", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ComTypesJobTitle_Id_Seq_Gen")
    private Long id;
	
	@Temporal(TemporalType.DATE)
    @Column(name = "DAT_LAST_MODIFY", nullable = false)
    private Date lastModificationDate;
    
	@Column(name = "DES_TYPE_JOB_TITLE", nullable = false, length = 80)
    private String jobTitle;
	
    @Column(name = "IND_ACTIVE", nullable = false, length = 1)
    private String indActive;
    
    /**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
    
    @ManyToOne
    @JoinColumn(name = "NUM_COMPANY",referencedColumnName="NUM_COMPANY")
    private Company company;

    public JobTitleType() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getIndActive() {
		return indActive;
	}

	public void setIndActive(String indActive) {
		this.indActive = indActive;
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
   
}
