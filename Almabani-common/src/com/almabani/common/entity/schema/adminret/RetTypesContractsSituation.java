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
@Table(schema="adminret" ,name = "RET_TYPES_CONTRACTS_SITUATION")
public class RetTypesContractsSituation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    
    @Column(name = "NUM_TYPE_CONTR_SITUATION", nullable = false)
    private Integer numTypeContrSituation;
    
    @Column(name = "DES_TYPE_CONTR_SITUATION", nullable = false, length = 80)
    private String desTypeContrSituation;
    
    @Column(name = "NUM_COMPANY", nullable = false)
    private Integer numCompany;
    
    @Column(name = "IND_ACTIVE", nullable = false, length = 1)
    private String indActive;
    
    @Column(name = "IND_USER_INTERACTION", nullable = false, length = 1)
    private String indUserInteraction;
    
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numTypeContrSituation", fetch = FetchType.LAZY)
    private List<RetSituationsContract> retSituationsContractList;

    public RetTypesContractsSituation() {
    }

    public RetTypesContractsSituation(Integer numTypeContrSituation) {
        this.numTypeContrSituation = numTypeContrSituation;
    }

    public RetTypesContractsSituation(Integer numTypeContrSituation, String desTypeContrSituation, Integer numCompany, String indActive, String indUserInteraction, String codLoginInsert, Date datRecordInsert, String codLoginModify, Date datLastModify) {
        this.numTypeContrSituation = numTypeContrSituation;
        this.desTypeContrSituation = desTypeContrSituation;
        this.numCompany = numCompany;
        this.indActive = indActive;
        this.indUserInteraction = indUserInteraction;
        this.codLoginInsert = codLoginInsert;
        this.datRecordInsert = datRecordInsert;
        this.codLoginModify = codLoginModify;
        this.datLastModify = datLastModify;
    }

    public Integer getNumTypeContrSituation() {
        return numTypeContrSituation;
    }

    public void setNumTypeContrSituation(Integer numTypeContrSituation) {
        this.numTypeContrSituation = numTypeContrSituation;
    }

    public String getDesTypeContrSituation() {
        return desTypeContrSituation;
    }

    public void setDesTypeContrSituation(String desTypeContrSituation) {
        this.desTypeContrSituation = desTypeContrSituation;
    }

    public Integer getNumCompany() {
        return numCompany;
    }

    public void setNumCompany(Integer numCompany) {
        this.numCompany = numCompany;
    }

    public String getIndActive() {
        return indActive;
    }

    public void setIndActive(String indActive) {
        this.indActive = indActive;
    }

    public String getIndUserInteraction() {
        return indUserInteraction;
    }

    public void setIndUserInteraction(String indUserInteraction) {
        this.indUserInteraction = indUserInteraction;
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

    @XmlTransient
    public List<RetSituationsContract> getRetSituationsContractList() {
        return retSituationsContractList;
    }

    public void setRetSituationsContractList(List<RetSituationsContract> retSituationsContractList) {
        this.retSituationsContractList = retSituationsContractList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numTypeContrSituation != null ? numTypeContrSituation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RetTypesContractsSituation)) {
            return false;
        }
        RetTypesContractsSituation other = (RetTypesContractsSituation) object;
        if ((this.numTypeContrSituation == null && other.numTypeContrSituation != null) || (this.numTypeContrSituation != null && !this.numTypeContrSituation.equals(other.numTypeContrSituation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.almabani.common.entity.schema.adminret.RetTypesContractsSituation[ numTypeContrSituation=" + numTypeContrSituation + " ]";
    }
    
}
