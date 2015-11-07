///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package com.almabani.common.entity.schema.admincor.view;
//
//import java.io.Serializable;
//import java.util.Date;
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import javax.xml.bind.annotation.XmlRootElement;
//
///**
// *
// * @author orcl
// */
//@Entity
//@Table(name = "V_COM_ESTABLISHMENTS", catalog = "", schema = "ADMINCOR")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "VComEstablishments.findAll", query = "SELECT v FROM VComEstablishments v")})
//public class VComEstablishments implements Serializable {
//    private static final long serialVersionUID = 1L;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "NUM_ESTABLISHMENT")
//    private short numEstablishment;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "NUM_DOCUMENT")
//    private long numDocument;
//    @Column(name = "NUM_DIGIT_ESTABLISHMENT")
//    private Short numDigitEstablishment;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "NUM_COMPANY")
//    private short numCompany;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 80)
//    @Column(name = "NAM_COMPANY")
//    private String namCompany;
//    @Size(max = 9)
//    @Column(name = "DES_TYPE_ESTABLISHMENT")
//    private String desTypeEstablishment;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 40)
//    @Column(name = "NAM_ESTABLISHMENT")
//    private String namEstablishment;
//    @Size(max = 4)
//    @Column(name = "DES_IND_ACTIVE")
//    private String desIndActive;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "DAT_LAST_MODIFY")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date datLastModify;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 10)
//    @Column(name = "NAM_USER_MODIFY")
//    private String namUserModify;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "NUM_ZIP_CODE")
//    private int numZipCode;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "NUM_SEQ_ZIP_CODE")
//    private int numSeqZipCode;
//    @Size(max = 60)
//    @Column(name = "DES_ZIP_CODE")
//    private String desZipCode;
//    @Size(max = 2)
//    @Column(name = "COD_STATE")
//    private String codState;
//
//    public VComEstablishments() {
//    }
//
//    public short getNumEstablishment() {
//        return numEstablishment;
//    }
//
//    public void setNumEstablishment(short numEstablishment) {
//        this.numEstablishment = numEstablishment;
//    }
//
//    public long getNumDocument() {
//        return numDocument;
//    }
//
//    public void setNumDocument(long numDocument) {
//        this.numDocument = numDocument;
//    }
//
//    public Short getNumDigitEstablishment() {
//        return numDigitEstablishment;
//    }
//
//    public void setNumDigitEstablishment(Short numDigitEstablishment) {
//        this.numDigitEstablishment = numDigitEstablishment;
//    }
//
//    public short getNumCompany() {
//        return numCompany;
//    }
//
//    public void setNumCompany(short numCompany) {
//        this.numCompany = numCompany;
//    }
//
//    public String getNamCompany() {
//        return namCompany;
//    }
//
//    public void setNamCompany(String namCompany) {
//        this.namCompany = namCompany;
//    }
//
//    public String getDesTypeEstablishment() {
//        return desTypeEstablishment;
//    }
//
//    public void setDesTypeEstablishment(String desTypeEstablishment) {
//        this.desTypeEstablishment = desTypeEstablishment;
//    }
//
//    public String getNamEstablishment() {
//        return namEstablishment;
//    }
//
//    public void setNamEstablishment(String namEstablishment) {
//        this.namEstablishment = namEstablishment;
//    }
//
//    public String getDesIndActive() {
//        return desIndActive;
//    }
//
//    public void setDesIndActive(String desIndActive) {
//        this.desIndActive = desIndActive;
//    }
//
//    public Date getDatLastModify() {
//        return datLastModify;
//    }
//
//    public void setDatLastModify(Date datLastModify) {
//        this.datLastModify = datLastModify;
//    }
//
//    public String getNamUserModify() {
//        return namUserModify;
//    }
//
//    public void setNamUserModify(String namUserModify) {
//        this.namUserModify = namUserModify;
//    }
//
//    public int getNumZipCode() {
//        return numZipCode;
//    }
//
//    public void setNumZipCode(int numZipCode) {
//        this.numZipCode = numZipCode;
//    }
//
//    public int getNumSeqZipCode() {
//        return numSeqZipCode;
//    }
//
//    public void setNumSeqZipCode(int numSeqZipCode) {
//        this.numSeqZipCode = numSeqZipCode;
//    }
//
//    public String getDesZipCode() {
//        return desZipCode;
//    }
//
//    public void setDesZipCode(String desZipCode) {
//        this.desZipCode = desZipCode;
//    }
//
//    public String getCodState() {
//        return codState;
//    }
//
//    public void setCodState(String codState) {
//        this.codState = codState;
//    }
//    
//}
