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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author orcl
 */
@Entity
@Table(schema="adminret" ,name = "RET_SITUATIONS_CONTRACT")
public class RetSituationsContract implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    
    @Column(name = "NUM_SITUATION_CONTRACT", nullable = false, precision = 19, scale = 0)
    private Integer numSituationContract;
    
    @Column(name = "DAT_SITUATION_CONTRACT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datSituationContract;
    @Column(name = "DES_OBSERVATION", length = 150)
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
    @JoinColumn(name = "NUM_COMPANY_CONTRACT", referencedColumnName = "NUM_COMPANY_CONTRACT", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RetCompaniesContracts numCompanyContract;
    @JoinColumn(name = "NUM_TYPE_CONTR_SITUATION", referencedColumnName = "NUM_TYPE_CONTR_SITUATION", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RetTypesContractsSituation numTypeContrSituation;

    public RetSituationsContract() {
    }

    public RetSituationsContract(Integer numSituationContract) {
        this.numSituationContract = numSituationContract;
    }

    public RetSituationsContract(Integer numSituationContract, Date datSituationContract, String codLoginInsert, Date datRecordInsert, String codLoginModify, Date datLastModify) {
        this.numSituationContract = numSituationContract;
        this.datSituationContract = datSituationContract;
        this.codLoginInsert = codLoginInsert;
        this.datRecordInsert = datRecordInsert;
        this.codLoginModify = codLoginModify;
        this.datLastModify = datLastModify;
    }

    public Integer getNumSituationContract() {
        return numSituationContract;
    }

    public void setNumSituationContract(Integer numSituationContract) {
        this.numSituationContract = numSituationContract;
    }

    public Date getDatSituationContract() {
        return datSituationContract;
    }

    public void setDatSituationContract(Date datSituationContract) {
        this.datSituationContract = datSituationContract;
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

    public RetCompaniesContracts getNumCompanyContract() {
        return numCompanyContract;
    }

    public void setNumCompanyContract(RetCompaniesContracts numCompanyContract) {
        this.numCompanyContract = numCompanyContract;
    }

    public RetTypesContractsSituation getNumTypeContrSituation() {
        return numTypeContrSituation;
    }

    public void setNumTypeContrSituation(RetTypesContractsSituation numTypeContrSituation) {
        this.numTypeContrSituation = numTypeContrSituation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numSituationContract != null ? numSituationContract.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RetSituationsContract)) {
            return false;
        }
        RetSituationsContract other = (RetSituationsContract) object;
        if ((this.numSituationContract == null && other.numSituationContract != null) || (this.numSituationContract != null && !this.numSituationContract.equals(other.numSituationContract))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.almabani.common.entity.schema.adminret.RetSituationsContract[ numSituationContract=" + numSituationContract + " ]";
    }
    
}
