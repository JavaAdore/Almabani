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
@Table(schema="adminret" ,name = "RET_TYPES_PAYMENT")
public class RetTypesPayment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    
    @Column(name = "NUM_TYPE_PAYMENT", nullable = false)
    private Integer numTypePayment;
    
    @Column(name = "DES_TYPE_PAYMENT", nullable = false, length = 80)
    private String desTypePayment;
    
    @Column(name = "IND_TYPE_PAYMENT", nullable = false, length = 2)
    private String indTypePayment;
    
    @Column(name = "NUM_COMPANY", nullable = false)
    private Integer numCompany;
    
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numTypePayment", fetch = FetchType.LAZY)
    private List<RetPaymentsPlans> retPaymentsPlansList;

    public RetTypesPayment() {
    }

    public RetTypesPayment(Integer numTypePayment) {
        this.numTypePayment = numTypePayment;
    }

    public RetTypesPayment(Integer numTypePayment, String desTypePayment, String indTypePayment, Integer numCompany, String indActive, String codLoginInsert, Date datRecordInsert, String codLoginModify, Date datLastModify) {
        this.numTypePayment = numTypePayment;
        this.desTypePayment = desTypePayment;
        this.indTypePayment = indTypePayment;
        this.numCompany = numCompany;
        this.indActive = indActive;
        this.codLoginInsert = codLoginInsert;
        this.datRecordInsert = datRecordInsert;
        this.codLoginModify = codLoginModify;
        this.datLastModify = datLastModify;
    }

    public Integer getNumTypePayment() {
        return numTypePayment;
    }

    public void setNumTypePayment(Integer numTypePayment) {
        this.numTypePayment = numTypePayment;
    }

    public String getDesTypePayment() {
        return desTypePayment;
    }

    public void setDesTypePayment(String desTypePayment) {
        this.desTypePayment = desTypePayment;
    }

    public String getIndTypePayment() {
        return indTypePayment;
    }

    public void setIndTypePayment(String indTypePayment) {
        this.indTypePayment = indTypePayment;
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
    public List<RetPaymentsPlans> getRetPaymentsPlansList() {
        return retPaymentsPlansList;
    }

    public void setRetPaymentsPlansList(List<RetPaymentsPlans> retPaymentsPlansList) {
        this.retPaymentsPlansList = retPaymentsPlansList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numTypePayment != null ? numTypePayment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RetTypesPayment)) {
            return false;
        }
        RetTypesPayment other = (RetTypesPayment) object;
        if ((this.numTypePayment == null && other.numTypePayment != null) || (this.numTypePayment != null && !this.numTypePayment.equals(other.numTypePayment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.almabani.common.entity.schema.adminret.RetTypesPayment[ numTypePayment=" + numTypePayment + " ]";
    }
    
}
