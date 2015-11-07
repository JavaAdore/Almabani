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
//@Table(name = "V_COM_TYPES_JOB_TITLE", catalog = "", schema = "ADMINCOR")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "VComTypesJobTitle.findAll", query = "SELECT v FROM VComTypesJobTitle v")})
//public class VComTypesJobTitle implements Serializable {
//    private static final long serialVersionUID = 1L;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "NUM_TYPE_JOB_TITLE")
//    private short numTypeJobTitle;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 80)
//    @Column(name = "DES_TYPE_JOB_TITLE")
//    private String desTypeJobTitle;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "NUM_COMPANY")
//    private short numCompany;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 80)
//    @Column(name = "NAM_COMPANY")
//    private String namCompany;
//    @Size(max = 4)
//    @Column(name = "IND_ACTIVE")
//    private String indActive;
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
//
//    public VComTypesJobTitle() {
//    }
//
//    public short getNumTypeJobTitle() {
//        return numTypeJobTitle;
//    }
//
//    public void setNumTypeJobTitle(short numTypeJobTitle) {
//        this.numTypeJobTitle = numTypeJobTitle;
//    }
//
//    public String getDesTypeJobTitle() {
//        return desTypeJobTitle;
//    }
//
//    public void setDesTypeJobTitle(String desTypeJobTitle) {
//        this.desTypeJobTitle = desTypeJobTitle;
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
//    public String getIndActive() {
//        return indActive;
//    }
//
//    public void setIndActive(String indActive) {
//        this.indActive = indActive;
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
//}
