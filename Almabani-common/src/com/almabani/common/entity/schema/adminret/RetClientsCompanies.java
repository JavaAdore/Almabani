/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.almabani.common.entity.schema.adminret;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author orcl
 */
@Entity
@Table(schema="adminret" ,name = "RET_CLIENTS_COMPANIES")
public class RetClientsCompanies implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    
    @Column(name = "NUM_CLIENT_COMPANY", nullable = false)
    private Long numClientCompany;
    
    @Column(name = "NUM_COMPANY", nullable = false)
    private Integer numCompany;
    
    @Column(name = "IND_TYPE_CADASTRAL", nullable = false, length = 1)
    private String indTypeCadastral;
    
    @Column(name = "IND_TYPE_INTEREST", nullable = false, length = 1)
    private String indTypeInterest;
    
    @Column(name = "DAT_REGISTRATION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datRegistration;
    
    @Column(name = "NAM_CLIENT_COMPANY", nullable = false, length = 100)
    private String namClientCompany;
    
    @Column(name = "NUM_EMPLOYEE_RESP_CLI", nullable = false)
    private long numEmployeeRespCli;
    
    @Column(name = "IND_ACTIVE", nullable = false, length = 1)
    private String indActive;
    @Column(name = "COD_IDENTITY_FEDERAL", length = 30)
    private String codIdentityFederal;
    @Column(name = "NAM_CLIENT_RESP", length = 80)
    private String namClientResp;
    @Column(name = "NUM_TYPE_JOB_RESP")
    private Integer numTypeJobResp;
    @Column(name = "DAT_BIRTH_RESP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datBirthResp;
    @Column(name = "DES_EMAIL_RESP", length = 80)
    private String desEmailResp;
    @Column(name = "DES_SITE_CLIENT", length = 100)
    private String desSiteClient;
    @Column(name = "NUM_DDI_LANDLINE")
    private Integer numDdiLandline;
    @Column(name = "NUM_DDD_LANDLINE")
    private Integer numDddLandline;
    @Column(name = "NUM_TELEFONE_LANDLINE")
    private Long numTelefoneLandline;
    @Column(name = "NUM_DDI_MOBILE")
    private Integer numDdiMobile;
    @Column(name = "NUM_DDD_MOBILE")
    private Integer numDddMobile;
    @Column(name = "NUM_TELEFONE_MOBILE")
    private Long numTelefoneMobile;
    @Column(name = "NUM_ZIP_CODE")
    private Integer numZipCode;
    @Column(name = "NUM_SEQ_ZIP_CODE")
    private Integer numSeqZipCode;
    @Column(name = "NAM_ADDRESS", length = 80)
    private String namAddress;
    @Column(name = "NUM_ADDRESS")
    private Integer numAddress;
    @Column(name = "DES_COMPLEMENT_ADDRESS", length = 30)
    private String desComplementAddress;
    @Column(name = "DES_OBSERVATION", length = 300)
    private String desObservation;
    
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
    @JoinColumn(name = "NUM_TYPE_COMP_ACTIVITY", referencedColumnName = "NUM_TYPE_COMP_ACTIVITY", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RetTypesCompaniesActivity numTypeCompActivity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numClientCompany", fetch = FetchType.LAZY)
    private List<RetClientsCompTracking> retClientsCompTrackingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numClientCompany", fetch = FetchType.LAZY)
    private List<RetCompaniesContracts> retCompaniesContractsList;

    public RetClientsCompanies() {
    }

    public RetClientsCompanies(Long numClientCompany) {
        this.numClientCompany = numClientCompany;
    }

    public RetClientsCompanies(Long numClientCompany, Integer numCompany, String indTypeCadastral, String indTypeInterest, Date datRegistration, String namClientCompany, long numEmployeeRespCli, String indActive, String codLoginInsert, Date datRecordInsert, String codLoginModify, Date datLastModify) {
        this.numClientCompany = numClientCompany;
        this.numCompany = numCompany;
        this.indTypeCadastral = indTypeCadastral;
        this.indTypeInterest = indTypeInterest;
        this.datRegistration = datRegistration;
        this.namClientCompany = namClientCompany;
        this.numEmployeeRespCli = numEmployeeRespCli;
        this.indActive = indActive;
        this.codLoginInsert = codLoginInsert;
        this.datRecordInsert = datRecordInsert;
        this.codLoginModify = codLoginModify;
        this.datLastModify = datLastModify;
    }

    public Long getNumClientCompany() {
        return numClientCompany;
    }

    public void setNumClientCompany(Long numClientCompany) {
        this.numClientCompany = numClientCompany;
    }

    public Integer getNumCompany() {
        return numCompany;
    }

    public void setNumCompany(Integer numCompany) {
        this.numCompany = numCompany;
    }

    public String getIndTypeCadastral() {
        return indTypeCadastral;
    }

    public void setIndTypeCadastral(String indTypeCadastral) {
        this.indTypeCadastral = indTypeCadastral;
    }

    public String getIndTypeInterest() {
        return indTypeInterest;
    }

    public void setIndTypeInterest(String indTypeInterest) {
        this.indTypeInterest = indTypeInterest;
    }

    public Date getDatRegistration() {
        return datRegistration;
    }

    public void setDatRegistration(Date datRegistration) {
        this.datRegistration = datRegistration;
    }

    public String getNamClientCompany() {
        return namClientCompany;
    }

    public void setNamClientCompany(String namClientCompany) {
        this.namClientCompany = namClientCompany;
    }

    public long getNumEmployeeRespCli() {
        return numEmployeeRespCli;
    }

    public void setNumEmployeeRespCli(long numEmployeeRespCli) {
        this.numEmployeeRespCli = numEmployeeRespCli;
    }

    public String getIndActive() {
        return indActive;
    }

    public void setIndActive(String indActive) {
        this.indActive = indActive;
    }

    public String getCodIdentityFederal() {
        return codIdentityFederal;
    }

    public void setCodIdentityFederal(String codIdentityFederal) {
        this.codIdentityFederal = codIdentityFederal;
    }

    public String getNamClientResp() {
        return namClientResp;
    }

    public void setNamClientResp(String namClientResp) {
        this.namClientResp = namClientResp;
    }

    public Integer getNumTypeJobResp() {
        return numTypeJobResp;
    }

    public void setNumTypeJobResp(Integer numTypeJobResp) {
        this.numTypeJobResp = numTypeJobResp;
    }

    public Date getDatBirthResp() {
        return datBirthResp;
    }

    public void setDatBirthResp(Date datBirthResp) {
        this.datBirthResp = datBirthResp;
    }

    public String getDesEmailResp() {
        return desEmailResp;
    }

    public void setDesEmailResp(String desEmailResp) {
        this.desEmailResp = desEmailResp;
    }

    public String getDesSiteClient() {
        return desSiteClient;
    }

    public void setDesSiteClient(String desSiteClient) {
        this.desSiteClient = desSiteClient;
    }

    public Integer getNumDdiLandline() {
        return numDdiLandline;
    }

    public void setNumDdiLandline(Integer numDdiLandline) {
        this.numDdiLandline = numDdiLandline;
    }

    public Integer getNumDddLandline() {
        return numDddLandline;
    }

    public void setNumDddLandline(Integer numDddLandline) {
        this.numDddLandline = numDddLandline;
    }

    public Long getNumTelefoneLandline() {
        return numTelefoneLandline;
    }

    public void setNumTelefoneLandline(Long numTelefoneLandline) {
        this.numTelefoneLandline = numTelefoneLandline;
    }

    public Integer getNumDdiMobile() {
        return numDdiMobile;
    }

    public void setNumDdiMobile(Integer numDdiMobile) {
        this.numDdiMobile = numDdiMobile;
    }

    public Integer getNumDddMobile() {
        return numDddMobile;
    }

    public void setNumDddMobile(Integer numDddMobile) {
        this.numDddMobile = numDddMobile;
    }

    public Long getNumTelefoneMobile() {
        return numTelefoneMobile;
    }

    public void setNumTelefoneMobile(Long numTelefoneMobile) {
        this.numTelefoneMobile = numTelefoneMobile;
    }

    public Integer getNumZipCode() {
        return numZipCode;
    }

    public void setNumZipCode(Integer numZipCode) {
        this.numZipCode = numZipCode;
    }

    public Integer getNumSeqZipCode() {
        return numSeqZipCode;
    }

    public void setNumSeqZipCode(Integer numSeqZipCode) {
        this.numSeqZipCode = numSeqZipCode;
    }

    public String getNamAddress() {
        return namAddress;
    }

    public void setNamAddress(String namAddress) {
        this.namAddress = namAddress;
    }

    public Integer getNumAddress() {
        return numAddress;
    }

    public void setNumAddress(Integer numAddress) {
        this.numAddress = numAddress;
    }

    public String getDesComplementAddress() {
        return desComplementAddress;
    }

    public void setDesComplementAddress(String desComplementAddress) {
        this.desComplementAddress = desComplementAddress;
    }

    public String getDesObservation() {
        return desObservation;
    }

    public void setDesObservation(String desObservation) {
        this.desObservation = desObservation;
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

    public RetTypesCompaniesActivity getNumTypeCompActivity() {
        return numTypeCompActivity;
    }

    public void setNumTypeCompActivity(RetTypesCompaniesActivity numTypeCompActivity) {
        this.numTypeCompActivity = numTypeCompActivity;
    }

    @XmlTransient
    public List<RetClientsCompTracking> getRetClientsCompTrackingList() {
        return retClientsCompTrackingList;
    }

    public void setRetClientsCompTrackingList(List<RetClientsCompTracking> retClientsCompTrackingList) {
        this.retClientsCompTrackingList = retClientsCompTrackingList;
    }

    @XmlTransient
    public List<RetCompaniesContracts> getRetCompaniesContractsList() {
        return retCompaniesContractsList;
    }

    public void setRetCompaniesContractsList(List<RetCompaniesContracts> retCompaniesContractsList) {
        this.retCompaniesContractsList = retCompaniesContractsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numClientCompany != null ? numClientCompany.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RetClientsCompanies)) {
            return false;
        }
        RetClientsCompanies other = (RetClientsCompanies) object;
        if ((this.numClientCompany == null && other.numClientCompany != null) || (this.numClientCompany != null && !this.numClientCompany.equals(other.numClientCompany))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.almabani.common.entity.schema.adminret.RetClientsCompanies[ numClientCompany=" + numClientCompany + " ]";
    }
    
}
