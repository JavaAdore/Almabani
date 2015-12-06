/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import com.almabani.common.entity.schema.admincor.Company;

/**
 *
 * @author orcl
 */
@Entity
@Table(name = "OAM_TYPES_DOCUMENTS", schema = "ADMINOAM")
@SequenceGenerator(sequenceName="adminoam.oam_seq_NUM_TYPE_DOCUMENT" , name = "Oam_DocumentType_Id_Seq_Gen")
public class OamDocumentType extends AbstractEntity implements Serializable {


	private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "NUM_TYPE_DOCUMENT", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Oam_DocumentType_Id_Seq_Gen")
    private Long id;
    
    @Column(name = "DES_TYPE_DOCUMENT", nullable = false, length = 80)
    private String documentTypeDescription;
    
    @ManyToOne
    @JoinColumn(name = "NUM_COMPANY", referencedColumnName = "NUM_COMPANY")
    private Company company;
    
    @Column(name = "IND_ACTIVE", nullable = false, length = 1)
    private String indActive;
    
    @Column(name = "COD_LOGIN_MODIFY", nullable = false, length = 10)
    private String modifiedByUserCode;
    
    @Column(name = "DAT_LAST_MODIFY", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModificatinoDate;
    
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


    

	public String getDocumentTypeDescription() {
		return documentTypeDescription;
	}

	public void setDocumentTypeDescription(String documentTypeDescription) {
		this.documentTypeDescription = documentTypeDescription;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getIndActive() {
		return indActive;
	}

	public void setIndActive(String indActive) {
		this.indActive = indActive;
	}

	public String getModifiedByUserCode() {
		return modifiedByUserCode;
	}

	public void setModifiedByUserCode(String modifiedByUserCode) {
		this.modifiedByUserCode = modifiedByUserCode;
	}

	public Date getLastModificatinoDate() {
		return lastModificatinoDate;
	}

	public void setLastModificatinoDate(Date lastModificatinoDate) {
		this.lastModificatinoDate = lastModificatinoDate;
	}

	

    public OamDocumentType() {
    }

}