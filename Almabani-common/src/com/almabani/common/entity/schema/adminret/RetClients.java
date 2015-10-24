/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.almabani.common.entity.schema.adminret;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author orcl
 */
@Entity
@Table(name = "RET_CLIENTS", schema="ADMINRET")
public class RetClients implements Serializable {
    
	private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "NUM_CLIENT", nullable = false)
    private Long numClient;
    
    @Column(name = "NAM_CLIENT", nullable = false, length = 70)
    private String namClient;
    @Column(name = "COD_IDENTITY_FEDERAL", length = 30)
    private String codIdentityFederal;
    @Column(name = "COD_IDENTITY_STATE", length = 30)
    private String codIdentityState;
    
    @Column(name = "IND_GENDER", nullable = false, length = 1)
    private String indGender;
    
    @Column(name = "DAT_BIRTH", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datBirth;
    @Column(name = "IND_MARITAL_STATUS", length = 1)
    private String indMaritalStatus;
    
    @Column(name = "DAT_REGISTRATION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datRegistration;
    @Column(name = "NAM_FATHER_CUSTOMER", length = 25)
    private String namFatherCustomer;
    @Column(name = "NAM_MOTHER_CUSTOMER", length = 50)
    private String namMotherCustomer;
    
    @Column(name = "NUM_ESTABLISHMENT", nullable = false)
    private Integer numEstablishment;
    @Column(name = "COD_EMPLOYEE_COMPANY")
    private Long codEmployeeCompany;
    @Column(name = "NUM_MOB_CLIENT")
    private Long numMobClient;
    @Column(name = "DES_EMAIL_CLIENT", length = 50)
    private String desEmailClient;
    @Column(name = "IND_RENT_RESIDENCE", length = 1)
    private String indRentResidence;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VAL_RENT", precision = 15, scale = 2)
    private Integer valRent;
    @Column(name = "DAT_BEGIN_RESIDENCE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datBeginResidence;
    @Column(name = "NUM_ZIP_CODE_RES")
    private Integer numZipCodeRes;
    @Column(name = "NUM_SEQ_ZIP_CODE_RES")
    private Integer numSeqZipCodeRes;
    @Column(name = "NAM_ADDRESS_RES", length = 80)
    private String namAddressRes;
    @Column(name = "NUM_ADDRESS_RES")
    private Integer numAddressRes;
    @Column(name = "DES_COMPLEMENT_ADDRESS_RES", length = 30)
    private String desComplementAddressRes;
    @Column(name = "NUM_TEL_RESIDENCE")
    private Long numTelResidence;
    @Column(name = "NUM_DEPENDENTS")
    private Integer numDependents;
    @Column(name = "NUM_TYPE_JOB")
    private Integer numTypeJob;
    @Column(name = "NAM_COMPANY_WORK", length = 60)
    private String namCompanyWork;
    @Column(name = "DAT_ADMISSION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datAdmission;
    @Column(name = "IND_TYPE_HIRING", length = 1)
    private String indTypeHiring;
    @Column(name = "NUM_TEL_WORK")
    private Long numTelWork;
    @Column(name = "NUM_ZIP_CODE_WORK")
    private Integer numZipCodeWork;
    @Column(name = "NUM_SEQ_ZIP_CODE_WORK")
    private Integer numSeqZipCodeWork;
    @Column(name = "NAM_ADDRESS_WORK", length = 80)
    private String namAddressWork;
    @Column(name = "NUM_ADDRESS_WORK")
    private Integer numAddressWork;
    @Column(name = "DES_COMPLEMENT_ADDRESS_WORK", length = 30)
    private String desComplementAddressWork;
    @Column(name = "VAL_INCOME", precision = 15, scale = 2)
    private Integer valIncome;
    @Column(name = "VAL_OTHER_INCOME", precision = 15, scale = 2)
    private Integer valOtherIncome;
    @Column(name = "DES_ORIGIN_OTHER_INCOME", length = 80)
    private String desOriginOtherIncome;
    
    @Column(name = "IND_ACTIVE", nullable = false, length = 1)
    private String indActive;
    
    @Column(name = "COD_LOGIN_INSERT", nullable = false, length = 10)
    private String codLoginInsert;
    
    @Column(name = "DAT_RECORD_INSERT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datRecordInsert;
    
    @Column(name = "COD_LOGIN_MODIFY", nullable = false, length = 10)
    private String codLoginModify;
    
    @Column(name = "DAT_LAST_MODIFY", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datLastModify;

    public RetClients() {
    }

    public RetClients(Long numClient) {
        this.numClient = numClient;
    }

    public RetClients(Long numClient, String namClient, String indGender, Date datBirth, Date datRegistration, Integer numEstablishment, String indActive, String codLoginInsert, Date datRecordInsert, String codLoginModify, Date datLastModify) {
        this.numClient = numClient;
        this.namClient = namClient;
        this.indGender = indGender;
        this.datBirth = datBirth;
        this.datRegistration = datRegistration;
        this.numEstablishment = numEstablishment;
        this.indActive = indActive;
        this.codLoginInsert = codLoginInsert;
        this.datRecordInsert = datRecordInsert;
        this.codLoginModify = codLoginModify;
        this.datLastModify = datLastModify;
    }

    public Long getNumClient() {
        return numClient;
    }

    public void setNumClient(Long numClient) {
        this.numClient = numClient;
    }

    public String getNamClient() {
        return namClient;
    }

    public void setNamClient(String namClient) {
        this.namClient = namClient;
    }

    public String getCodIdentityFederal() {
        return codIdentityFederal;
    }

    public void setCodIdentityFederal(String codIdentityFederal) {
        this.codIdentityFederal = codIdentityFederal;
    }

    public String getCodIdentityState() {
        return codIdentityState;
    }

    public void setCodIdentityState(String codIdentityState) {
        this.codIdentityState = codIdentityState;
    }

    public String getIndGender() {
        return indGender;
    }

    public void setIndGender(String indGender) {
        this.indGender = indGender;
    }

    public Date getDatBirth() {
        return datBirth;
    }

    public void setDatBirth(Date datBirth) {
        this.datBirth = datBirth;
    }

    public String getIndMaritalStatus() {
        return indMaritalStatus;
    }

    public void setIndMaritalStatus(String indMaritalStatus) {
        this.indMaritalStatus = indMaritalStatus;
    }

    public Date getDatRegistration() {
        return datRegistration;
    }

    public void setDatRegistration(Date datRegistration) {
        this.datRegistration = datRegistration;
    }

    public String getNamFatherCustomer() {
        return namFatherCustomer;
    }

    public void setNamFatherCustomer(String namFatherCustomer) {
        this.namFatherCustomer = namFatherCustomer;
    }

    public String getNamMotherCustomer() {
        return namMotherCustomer;
    }

    public void setNamMotherCustomer(String namMotherCustomer) {
        this.namMotherCustomer = namMotherCustomer;
    }

    public Integer getNumEstablishment() {
        return numEstablishment;
    }

    public void setNumEstablishment(Integer numEstablishment) {
        this.numEstablishment = numEstablishment;
    }

    public Long getCodEmployeeCompany() {
        return codEmployeeCompany;
    }

    public void setCodEmployeeCompany(Long codEmployeeCompany) {
        this.codEmployeeCompany = codEmployeeCompany;
    }

    public Long getNumMobClient() {
        return numMobClient;
    }

    public void setNumMobClient(Long numMobClient) {
        this.numMobClient = numMobClient;
    }

    public String getDesEmailClient() {
        return desEmailClient;
    }

    public void setDesEmailClient(String desEmailClient) {
        this.desEmailClient = desEmailClient;
    }

    public String getIndRentResidence() {
        return indRentResidence;
    }

    public void setIndRentResidence(String indRentResidence) {
        this.indRentResidence = indRentResidence;
    }

    public Integer getValRent() {
        return valRent;
    }

    public void setValRent(Integer valRent) {
        this.valRent = valRent;
    }

    public Date getDatBeginResidence() {
        return datBeginResidence;
    }

    public void setDatBeginResidence(Date datBeginResidence) {
        this.datBeginResidence = datBeginResidence;
    }

    public Integer getNumZipCodeRes() {
        return numZipCodeRes;
    }

    public void setNumZipCodeRes(Integer numZipCodeRes) {
        this.numZipCodeRes = numZipCodeRes;
    }

    public Integer getNumSeqZipCodeRes() {
        return numSeqZipCodeRes;
    }

    public void setNumSeqZipCodeRes(Integer numSeqZipCodeRes) {
        this.numSeqZipCodeRes = numSeqZipCodeRes;
    }

    public String getNamAddressRes() {
        return namAddressRes;
    }

    public void setNamAddressRes(String namAddressRes) {
        this.namAddressRes = namAddressRes;
    }

    public Integer getNumAddressRes() {
        return numAddressRes;
    }

    public void setNumAddressRes(Integer numAddressRes) {
        this.numAddressRes = numAddressRes;
    }

    public String getDesComplementAddressRes() {
        return desComplementAddressRes;
    }

    public void setDesComplementAddressRes(String desComplementAddressRes) {
        this.desComplementAddressRes = desComplementAddressRes;
    }

    public Long getNumTelResidence() {
        return numTelResidence;
    }

    public void setNumTelResidence(Long numTelResidence) {
        this.numTelResidence = numTelResidence;
    }

    public Integer getNumDependents() {
        return numDependents;
    }

    public void setNumDependents(Integer numDependents) {
        this.numDependents = numDependents;
    }

    public Integer getNumTypeJob() {
        return numTypeJob;
    }

    public void setNumTypeJob(Integer numTypeJob) {
        this.numTypeJob = numTypeJob;
    }

    public String getNamCompanyWork() {
        return namCompanyWork;
    }

    public void setNamCompanyWork(String namCompanyWork) {
        this.namCompanyWork = namCompanyWork;
    }

    public Date getDatAdmission() {
        return datAdmission;
    }

    public void setDatAdmission(Date datAdmission) {
        this.datAdmission = datAdmission;
    }

    public String getIndTypeHiring() {
        return indTypeHiring;
    }

    public void setIndTypeHiring(String indTypeHiring) {
        this.indTypeHiring = indTypeHiring;
    }

    public Long getNumTelWork() {
        return numTelWork;
    }

    public void setNumTelWork(Long numTelWork) {
        this.numTelWork = numTelWork;
    }

    public Integer getNumZipCodeWork() {
        return numZipCodeWork;
    }

    public void setNumZipCodeWork(Integer numZipCodeWork) {
        this.numZipCodeWork = numZipCodeWork;
    }

    public Integer getNumSeqZipCodeWork() {
        return numSeqZipCodeWork;
    }

    public void setNumSeqZipCodeWork(Integer numSeqZipCodeWork) {
        this.numSeqZipCodeWork = numSeqZipCodeWork;
    }

    public String getNamAddressWork() {
        return namAddressWork;
    }

    public void setNamAddressWork(String namAddressWork) {
        this.namAddressWork = namAddressWork;
    }

    public Integer getNumAddressWork() {
        return numAddressWork;
    }

    public void setNumAddressWork(Integer numAddressWork) {
        this.numAddressWork = numAddressWork;
    }

    public String getDesComplementAddressWork() {
        return desComplementAddressWork;
    }

    public void setDesComplementAddressWork(String desComplementAddressWork) {
        this.desComplementAddressWork = desComplementAddressWork;
    }

    public Integer getValIncome() {
        return valIncome;
    }

    public void setValIncome(Integer valIncome) {
        this.valIncome = valIncome;
    }

    public Integer getValOtherIncome() {
        return valOtherIncome;
    }

    public void setValOtherIncome(Integer valOtherIncome) {
        this.valOtherIncome = valOtherIncome;
    }

    public String getDesOriginOtherIncome() {
        return desOriginOtherIncome;
    }

    public void setDesOriginOtherIncome(String desOriginOtherIncome) {
        this.desOriginOtherIncome = desOriginOtherIncome;
    }

    public String getIndActive() {
        return indActive;
    }

    public void setIndActive(String indActive) {
        this.indActive = indActive;
    }

    public String getCodLoginInsert() {
        return codLoginInsert;
    }

    public void setCodLoginInsert(String codLoginInsert) {
        this.codLoginInsert = codLoginInsert;
    }

    public Date getDatRecordInsert() {
        return datRecordInsert;
    }

    public void setDatRecordInsert(Date datRecordInsert) {
        this.datRecordInsert = datRecordInsert;
    }

    public String getCodLoginModify() {
        return codLoginModify;
    }

    public void setCodLoginModify(String codLoginModify) {
        this.codLoginModify = codLoginModify;
    }

    public Date getDatLastModify() {
        return datLastModify;
    }

    public void setDatLastModify(Date datLastModify) {
        this.datLastModify = datLastModify;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numClient != null ? numClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RetClients)) {
            return false;
        }
        RetClients other = (RetClients) object;
        if ((this.numClient == null && other.numClient != null) || (this.numClient != null && !this.numClient.equals(other.numClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.almabani.common.entity.schema.adminret.RetClients[ numClient=" + numClient + " ]";
    }
    
}
