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
//@Table(name = "V_COM_COMPANIES", catalog = "", schema = "ADMINCOR")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "VComCompanies.findAll", query = "SELECT v FROM VComCompanies v")})
//public class VComCompanies implements Serializable {
//    private static final long serialVersionUID = 1L;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "NUM_COMPANY")
//    private short numCompany;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 80)
//    @Column(name = "NAM_COMPANY")
//    private String namCompany;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "NUM_COUNTRY")
//    private int numCountry;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 100)
//    @Column(name = "NAM_COUNTRY")
//    private String namCountry;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 2)
//    @Column(name = "COD_STATE")
//    private String codState;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 80)
//    @Column(name = "NAM_STATE")
//    private String namState;
//    @Size(max = 100)
//    @Column(name = "NAM_COMPANY_ALTERNATIVE")
//    private String namCompanyAlternative;
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
//    @Size(min = 1, max = 30)
//    @Column(name = "COD_IDENTITY_FEDERAL")
//    private String codIdentityFederal;
//    @Size(max = 10)
//    @Column(name = "DES_LANGUAGE")
//    private String desLanguage;
//
//    public VComCompanies() {
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
//    public int getNumCountry() {
//        return numCountry;
//    }
//
//    public void setNumCountry(int numCountry) {
//        this.numCountry = numCountry;
//    }
//
//    public String getNamCountry() {
//        return namCountry;
//    }
//
//    public void setNamCountry(String namCountry) {
//        this.namCountry = namCountry;
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
//    public String getNamState() {
//        return namState;
//    }
//
//    public void setNamState(String namState) {
//        this.namState = namState;
//    }
//
//    public String getNamCompanyAlternative() {
//        return namCompanyAlternative;
//    }
//
//    public void setNamCompanyAlternative(String namCompanyAlternative) {
//        this.namCompanyAlternative = namCompanyAlternative;
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
//    public String getCodIdentityFederal() {
//        return codIdentityFederal;
//    }
//
//    public void setCodIdentityFederal(String codIdentityFederal) {
//        this.codIdentityFederal = codIdentityFederal;
//    }
//
//    public String getDesLanguage() {
//        return desLanguage;
//    }
//
//    public void setDesLanguage(String desLanguage) {
//        this.desLanguage = desLanguage;
//    }
//    
//}
