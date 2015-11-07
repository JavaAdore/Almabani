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
//@Table(name = "V_COM_EMPLOYEES", catalog = "", schema = "ADMINCOR")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "VComEmployees.findAll", query = "SELECT v FROM VComEmployees v")})
//public class VComEmployees implements Serializable {
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
//    @Column(name = "NUM_DEPARTMENT")
//    private short numDepartment;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 40)
//    @Column(name = "NAM_DEPARTMENT")
//    private String namDepartment;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "NUM_DEP_SECTION")
//    private short numDepSection;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 40)
//    @Column(name = "NAM_SECTION")
//    private String namSection;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "NUM_ESTABLISHMENT")
//    private short numEstablishment;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 40)
//    @Column(name = "NAM_ESTABLISHMENT")
//    private String namEstablishment;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "COD_EMPLOYEE")
//    private long codEmployee;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 30)
//    @Column(name = "COD_IDENTITY_FEDERAL")
//    private String codIdentityFederal;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 100)
//    @Column(name = "NAM_EMPLOYEE")
//    private String namEmployee;
//    @Size(max = 4)
//    @Column(name = "DES_IND_ACTIVE")
//    private String desIndActive;
//    @Column(name = "NUM_TYPE_JOB_TITLE")
//    private Short numTypeJobTitle;
//    @Size(max = 80)
//    @Column(name = "DES_TYPE_JOB_TITLE")
//    private String desTypeJobTitle;
//    @Size(max = 300)
//    @Column(name = "DES_OBSERVATION")
//    private String desObservation;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "DAT_REGISTRATION")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date datRegistration;
//    @Size(max = 30)
//    @Column(name = "COD_IDENTITY_STATE")
//    private String codIdentityState;
//    @Column(name = "DAT_BIRTH")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date datBirth;
//    @Size(max = 9)
//    @Column(name = "DES_GENDER")
//    private String desGender;
//    @Size(max = 10)
//    @Column(name = "DES_MARITAL_STATUS")
//    private String desMaritalStatus;
//    @Column(name = "DAT_ADMISSION")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date datAdmission;
//    @Column(name = "DAT_BEGIN_INACTIVITY")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date datBeginInactivity;
//    @Size(max = 11)
//    @Column(name = "DES_IND_TYPE_EMPLOYEE")
//    private String desIndTypeEmployee;
//    @Size(max = 80)
//    @Column(name = "DES_EMAIL_1")
//    private String desEmail1;
//    @Size(max = 80)
//    @Column(name = "DES_EMAIL_2")
//    private String desEmail2;
//    @Column(name = "NUM_DDI_TELEFONE")
//    private Short numDdiTelefone;
//    @Column(name = "NUM_DDD_TELEFONE")
//    private Short numDddTelefone;
//    @Column(name = "NUM_TELEFONE")
//    private Long numTelefone;
//    @Column(name = "NUM_DDI_MOBILE")
//    private Short numDdiMobile;
//    @Column(name = "NUM_DDD_MOBILE")
//    private Short numDddMobile;
//    @Column(name = "NUM_MOBILE")
//    private Long numMobile;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 10)
//    @Column(name = "NAM_USER_MODIFY")
//    private String namUserModify;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "DAT_LAST_MODIFY")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date datLastModify;
//
//    public VComEmployees() {
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
//    public short getNumDepartment() {
//        return numDepartment;
//    }
//
//    public void setNumDepartment(short numDepartment) {
//        this.numDepartment = numDepartment;
//    }
//
//    public String getNamDepartment() {
//        return namDepartment;
//    }
//
//    public void setNamDepartment(String namDepartment) {
//        this.namDepartment = namDepartment;
//    }
//
//    public short getNumDepSection() {
//        return numDepSection;
//    }
//
//    public void setNumDepSection(short numDepSection) {
//        this.numDepSection = numDepSection;
//    }
//
//    public String getNamSection() {
//        return namSection;
//    }
//
//    public void setNamSection(String namSection) {
//        this.namSection = namSection;
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
//    public String getNamEstablishment() {
//        return namEstablishment;
//    }
//
//    public void setNamEstablishment(String namEstablishment) {
//        this.namEstablishment = namEstablishment;
//    }
//
//    public long getCodEmployee() {
//        return codEmployee;
//    }
//
//    public void setCodEmployee(long codEmployee) {
//        this.codEmployee = codEmployee;
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
//    public String getNamEmployee() {
//        return namEmployee;
//    }
//
//    public void setNamEmployee(String namEmployee) {
//        this.namEmployee = namEmployee;
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
//    public Short getNumTypeJobTitle() {
//        return numTypeJobTitle;
//    }
//
//    public void setNumTypeJobTitle(Short numTypeJobTitle) {
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
//    public String getDesObservation() {
//        return desObservation;
//    }
//
//    public void setDesObservation(String desObservation) {
//        this.desObservation = desObservation;
//    }
//
//    public Date getDatRegistration() {
//        return datRegistration;
//    }
//
//    public void setDatRegistration(Date datRegistration) {
//        this.datRegistration = datRegistration;
//    }
//
//    public String getCodIdentityState() {
//        return codIdentityState;
//    }
//
//    public void setCodIdentityState(String codIdentityState) {
//        this.codIdentityState = codIdentityState;
//    }
//
//    public Date getDatBirth() {
//        return datBirth;
//    }
//
//    public void setDatBirth(Date datBirth) {
//        this.datBirth = datBirth;
//    }
//
//    public String getDesGender() {
//        return desGender;
//    }
//
//    public void setDesGender(String desGender) {
//        this.desGender = desGender;
//    }
//
//    public String getDesMaritalStatus() {
//        return desMaritalStatus;
//    }
//
//    public void setDesMaritalStatus(String desMaritalStatus) {
//        this.desMaritalStatus = desMaritalStatus;
//    }
//
//    public Date getDatAdmission() {
//        return datAdmission;
//    }
//
//    public void setDatAdmission(Date datAdmission) {
//        this.datAdmission = datAdmission;
//    }
//
//    public Date getDatBeginInactivity() {
//        return datBeginInactivity;
//    }
//
//    public void setDatBeginInactivity(Date datBeginInactivity) {
//        this.datBeginInactivity = datBeginInactivity;
//    }
//
//    public String getDesIndTypeEmployee() {
//        return desIndTypeEmployee;
//    }
//
//    public void setDesIndTypeEmployee(String desIndTypeEmployee) {
//        this.desIndTypeEmployee = desIndTypeEmployee;
//    }
//
//    public String getDesEmail1() {
//        return desEmail1;
//    }
//
//    public void setDesEmail1(String desEmail1) {
//        this.desEmail1 = desEmail1;
//    }
//
//    public String getDesEmail2() {
//        return desEmail2;
//    }
//
//    public void setDesEmail2(String desEmail2) {
//        this.desEmail2 = desEmail2;
//    }
//
//    public Short getNumDdiTelefone() {
//        return numDdiTelefone;
//    }
//
//    public void setNumDdiTelefone(Short numDdiTelefone) {
//        this.numDdiTelefone = numDdiTelefone;
//    }
//
//    public Short getNumDddTelefone() {
//        return numDddTelefone;
//    }
//
//    public void setNumDddTelefone(Short numDddTelefone) {
//        this.numDddTelefone = numDddTelefone;
//    }
//
//    public Long getNumTelefone() {
//        return numTelefone;
//    }
//
//    public void setNumTelefone(Long numTelefone) {
//        this.numTelefone = numTelefone;
//    }
//
//    public Short getNumDdiMobile() {
//        return numDdiMobile;
//    }
//
//    public void setNumDdiMobile(Short numDdiMobile) {
//        this.numDdiMobile = numDdiMobile;
//    }
//
//    public Short getNumDddMobile() {
//        return numDddMobile;
//    }
//
//    public void setNumDddMobile(Short numDddMobile) {
//        this.numDddMobile = numDddMobile;
//    }
//
//    public Long getNumMobile() {
//        return numMobile;
//    }
//
//    public void setNumMobile(Long numMobile) {
//        this.numMobile = numMobile;
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
//    public Date getDatLastModify() {
//        return datLastModify;
//    }
//
//    public void setDatLastModify(Date datLastModify) {
//        this.datLastModify = datLastModify;
//    }
//    
//}
