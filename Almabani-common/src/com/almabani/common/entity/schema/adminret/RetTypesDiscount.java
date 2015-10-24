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
@Table(schema="adminret" ,name = "RET_TYPES_DISCOUNT")
public class RetTypesDiscount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "NUM_TYPE_DISCOUNT", nullable = false)
    private Integer numTypeDiscount;
    
    @Column(name = "DES_TYPE_DISCOUNT", nullable = false, length = 80)
    private String desTypeDiscount;
    
    @Column(name = "NUM_COMPANY", nullable = false)
    private Integer numCompany;
    
    @Column(name = "IND_ACTIVE", nullable = false, length = 1)
    private String indActive;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PER_MAX_DISCOUNT", precision = 5, scale = 2)
    private Integer perMaxDiscount;
    @Column(name = "VAL_MAX_DISCOUNT", precision = 15, scale = 2)
    private Integer valMaxDiscount;
    
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numTypeDiscount", fetch = FetchType.LAZY)
    private List<RetCompaniesContracts> retCompaniesContractsList;

    public RetTypesDiscount() {
    }

    public RetTypesDiscount(Integer numTypeDiscount) {
        this.numTypeDiscount = numTypeDiscount;
    }

    public RetTypesDiscount(Integer numTypeDiscount, String desTypeDiscount, Integer numCompany, String indActive, String codLoginInsert, Date datRecordInsert, String codLoginModify, Date datLastModify) {
        this.numTypeDiscount = numTypeDiscount;
        this.desTypeDiscount = desTypeDiscount;
        this.numCompany = numCompany;
        this.indActive = indActive;
        this.codLoginInsert = codLoginInsert;
        this.datRecordInsert = datRecordInsert;
        this.codLoginModify = codLoginModify;
        this.datLastModify = datLastModify;
    }

    public Integer getNumTypeDiscount() {
        return numTypeDiscount;
    }

    public void setNumTypeDiscount(Integer numTypeDiscount) {
        this.numTypeDiscount = numTypeDiscount;
    }

    public String getDesTypeDiscount() {
        return desTypeDiscount;
    }

    public void setDesTypeDiscount(String desTypeDiscount) {
        this.desTypeDiscount = desTypeDiscount;
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

    public Integer getPerMaxDiscount() {
        return perMaxDiscount;
    }

    public void setPerMaxDiscount(Integer perMaxDiscount) {
        this.perMaxDiscount = perMaxDiscount;
    }

    public Integer getValMaxDiscount() {
        return valMaxDiscount;
    }

    public void setValMaxDiscount(Integer valMaxDiscount) {
        this.valMaxDiscount = valMaxDiscount;
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
    public List<RetCompaniesContracts> getRetCompaniesContractsList() {
        return retCompaniesContractsList;
    }

    public void setRetCompaniesContractsList(List<RetCompaniesContracts> retCompaniesContractsList) {
        this.retCompaniesContractsList = retCompaniesContractsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numTypeDiscount != null ? numTypeDiscount.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RetTypesDiscount)) {
            return false;
        }
        RetTypesDiscount other = (RetTypesDiscount) object;
        if ((this.numTypeDiscount == null && other.numTypeDiscount != null) || (this.numTypeDiscount != null && !this.numTypeDiscount.equals(other.numTypeDiscount))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.almabani.common.entity.schema.adminret.RetTypesDiscount[ numTypeDiscount=" + numTypeDiscount + " ]";
    }
    
}
