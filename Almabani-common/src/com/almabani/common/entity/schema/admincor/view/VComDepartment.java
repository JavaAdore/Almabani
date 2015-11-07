package com.almabani.common.entity.schema.admincor.view;
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package com.almabani.common.entity.schema.admincor.view;
//
//import java.io.Serializable;
//import java.math.BigInteger;
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
//@Table(name = "V_COM_DEPARTMENTS", catalog = "", schema = "ADMINCOR")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "VComDepartments.findAll", query = "SELECT v FROM VComDepartments v")})
//public class VComDepartments implements Serializable {
//    private static final long serialVersionUID = 1L;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "NUM_DEPARTMENT")
//    private short numDepartment;
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
//    @Size(min = 1, max = 15)
//    @Column(name = "COD_DEPARTMENT")
//    private String codDepartment;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 40)
//    @Column(name = "NAM_DEPARTMENT")
//    private String namDepartment;
//    @Size(max = 4)
//    @Column(name = "IND_ACTIVE")
//    private String indActive;
//    @Column(name = "COD_USER_RESPONSIBLE")
//    private BigInteger codUserResponsible;
//    @Size(max = 100)
//    @Column(name = "NAM_EMPLOYEE")
//    private String namEmployee;
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
//    public VComDepartments() {
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
//    public String getCodDepartment() {
//        return codDepartment;
//    }
//
//    public void setCodDepartment(String codDepartment) {
//        this.codDepartment = codDepartment;
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
//    public String getIndActive() {
//        return indActive;
//    }
//
//    public void setIndActive(String indActive) {
//        this.indActive = indActive;
//    }
//
//    public BigInteger getCodUserResponsible() {
//        return codUserResponsible;
//    }
//
//    public void setCodUserResponsible(BigInteger codUserResponsible) {
//        this.codUserResponsible = codUserResponsible;
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
