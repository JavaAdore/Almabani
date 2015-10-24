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
@Table(schema="adminret" ,name = "RET_TYPES_COMPANIES_ACTIVITY")
public class RetTypesCompaniesActivity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    
    @Column(name = "NUM_TYPE_COMP_ACTIVITY", nullable = false)
    private Integer numTypeCompActivity;
    
    @Column(name = "DES_TYPE_COMP_ACTIVITY", nullable = false, length = 80)
    private String desTypeCompActivity;
    
    @Column(name = "IND_ACTIVE", nullable = false, length = 1)
    private String indActive;
    
    @Column(name = "NUM_COMPANY", nullable = false)
    private Integer numCompany;
    
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numTypeCompActivity", fetch = FetchType.LAZY)
    private List<RetClientsCompanies> retClientsCompaniesList;

    public RetTypesCompaniesActivity() {
    }

    public RetTypesCompaniesActivity(Integer numTypeCompActivity) {
        this.numTypeCompActivity = numTypeCompActivity;
    }

    public RetTypesCompaniesActivity(Integer numTypeCompActivity, String desTypeCompActivity, String indActive, Integer numCompany, String codLoginInsert, Date datRecordInsert, String codLoginModify, Date datLastModify) {
        this.numTypeCompActivity = numTypeCompActivity;
        this.desTypeCompActivity = desTypeCompActivity;
        this.indActive = indActive;
        this.numCompany = numCompany;
        this.codLoginInsert = codLoginInsert;
        this.datRecordInsert = datRecordInsert;
        this.codLoginModify = codLoginModify;
        this.datLastModify = datLastModify;
    }

    public Integer getNumTypeCompActivity() {
        return numTypeCompActivity;
    }

    public void setNumTypeCompActivity(Integer numTypeCompActivity) {
        this.numTypeCompActivity = numTypeCompActivity;
    }

    public String getDesTypeCompActivity() {
        return desTypeCompActivity;
    }

    public void setDesTypeCompActivity(String desTypeCompActivity) {
        this.desTypeCompActivity = desTypeCompActivity;
    }

    public String getIndActive() {
        return indActive;
    }

    public void setIndActive(String indActive) {
        this.indActive = indActive;
    }

    public Integer getNumCompany() {
        return numCompany;
    }

    public void setNumCompany(Integer numCompany) {
        this.numCompany = numCompany;
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
    public List<RetClientsCompanies> getRetClientsCompaniesList() {
        return retClientsCompaniesList;
    }

    public void setRetClientsCompaniesList(List<RetClientsCompanies> retClientsCompaniesList) {
        this.retClientsCompaniesList = retClientsCompaniesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numTypeCompActivity != null ? numTypeCompActivity.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RetTypesCompaniesActivity)) {
            return false;
        }
        RetTypesCompaniesActivity other = (RetTypesCompaniesActivity) object;
        if ((this.numTypeCompActivity == null && other.numTypeCompActivity != null) || (this.numTypeCompActivity != null && !this.numTypeCompActivity.equals(other.numTypeCompActivity))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.almabani.common.entity.schema.adminret.RetTypesCompaniesActivity[ numTypeCompActivity=" + numTypeCompActivity + " ]";
    }
    
}
