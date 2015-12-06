/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.almabani.common.entity.schema.adminoam;

import java.io.Serializable;
import java.sql.Blob;
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
 *
 * @author orcl
 */
@Entity
@Table(name = "OAM_QUOTATIONS_DOCUMENTS", catalog = "", schema = "ADMINOAM")
@SequenceGenerator(name="Oam_quotation_document_seq" , sequenceName="adminoam.oam_seq_NUM_QUOT_DOCUMENT")
public class OamQuotationDocument extends AbstractEntity implements Serializable {
   
	private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "NUM_IQUOTATION_DOCUMENT")
    @GeneratedValue(strategy=GenerationType.SEQUENCE , generator="Oam_quotation_document_seq")
    private Long id;
    
	@Column(name = "COD_LOGIN_INSERT")
    private String codLoginInsert;
    
	@Column(name = "DES_DOCUMENT")
    private String documentName;
	
    @Column(name = "DAT_ROW_INSERT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertionDate;
   
    @Column(name = "IMG_QUOTATION")
    private Blob imgQuotation;
    
    @JoinColumn(name = "NUM_TYPE_DOCUMENT", referencedColumnName = "NUM_TYPE_DOCUMENT")
    @ManyToOne(optional = false)
    private OamDocumentType documentType;
    
    @JoinColumn(name = "NUM_QUOTATION", referencedColumnName = "NUM_QUOTATION")
    @ManyToOne(optional = false)
    private OamQuotation quotation;
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodLoginInsert() {
		return codLoginInsert;
	}
	public void setCodLoginInsert(String codLoginInsert) {
		this.codLoginInsert = codLoginInsert;
	}
	public Date getInsertionDate() {
		return insertionDate;
	}
	public void setInsertionDate(Date insertionDate) {
		this.insertionDate = insertionDate;
	}
	public Blob getImgQuotation() {
		return imgQuotation;
	}
	public void setImgQuotation(Blob imgQuotation) {
		this.imgQuotation = imgQuotation;
	}
	public OamDocumentType getDocumentType() {
		return documentType;
	}
	public void setDocumentType(OamDocumentType documentType) {
		this.documentType = documentType;
	}
	public OamQuotation getQuotation() {
		return quotation;
	}
	public void setQuotation(OamQuotation quotation) {
		this.quotation = quotation;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
    
    
    

    

  
}
