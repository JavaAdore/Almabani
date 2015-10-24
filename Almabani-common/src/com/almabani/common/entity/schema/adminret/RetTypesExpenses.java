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
@Table(schema="adminret" ,name = "RET_TYPES_EXPENSES")
public class RetTypesExpenses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id 
    @Column(name = "NUM_TYPE_EXPENSE", nullable = false)
    private Integer numTypeExpense;
    
    @Column(name = "NUM_COMPANY", nullable = false)
    private Integer numCompany;
    
    @Column(name = "DES_TYPE_EXPENSE", nullable = false, length = 80)
    private String desTypeExpense;
    
    @Column(name = "DAT_BEGIN_VALIDITY", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datBeginValidity;
    @Column(name = "DAT_END_VALIDITY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datEndValidity;
    
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numTypeExpense", fetch = FetchType.LAZY)
    private List<RetSubTypesExpenses> retSubTypesExpensesList;

    public RetTypesExpenses() {
    }

    public RetTypesExpenses(Integer numTypeExpense) {
        this.numTypeExpense = numTypeExpense;
    }

    public RetTypesExpenses(Integer numTypeExpense, Integer numCompany, String desTypeExpense, Date datBeginValidity, String codLoginInsert, Date datRecordInsert, String codLoginModify, Date datLastModify) {
        this.numTypeExpense = numTypeExpense;
        this.numCompany = numCompany;
        this.desTypeExpense = desTypeExpense;
        this.datBeginValidity = datBeginValidity;
        this.codLoginInsert = codLoginInsert;
        this.datRecordInsert = datRecordInsert;
        this.codLoginModify = codLoginModify;
        this.datLastModify = datLastModify;
    }

    public Integer getNumTypeExpense() {
        return numTypeExpense;
    }

    public void setNumTypeExpense(Integer numTypeExpense) {
        this.numTypeExpense = numTypeExpense;
    }

    public Integer getNumCompany() {
        return numCompany;
    }

    public void setNumCompany(Integer numCompany) {
        this.numCompany = numCompany;
    }

    public String getDesTypeExpense() {
        return desTypeExpense;
    }

    public void setDesTypeExpense(String desTypeExpense) {
        this.desTypeExpense = desTypeExpense;
    }

    public Date getDatBeginValidity() {
        return datBeginValidity;
    }

    public void setDatBeginValidity(Date datBeginValidity) {
        this.datBeginValidity = datBeginValidity;
    }

    public Date getDatEndValidity() {
        return datEndValidity;
    }

    public void setDatEndValidity(Date datEndValidity) {
        this.datEndValidity = datEndValidity;
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
    public List<RetSubTypesExpenses> getRetSubTypesExpensesList() {
        return retSubTypesExpensesList;
    }

    public void setRetSubTypesExpensesList(List<RetSubTypesExpenses> retSubTypesExpensesList) {
        this.retSubTypesExpensesList = retSubTypesExpensesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numTypeExpense != null ? numTypeExpense.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RetTypesExpenses)) {
            return false;
        }
        RetTypesExpenses other = (RetTypesExpenses) object;
        if ((this.numTypeExpense == null && other.numTypeExpense != null) || (this.numTypeExpense != null && !this.numTypeExpense.equals(other.numTypeExpense))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.almabani.common.entity.schema.adminret.RetTypesExpenses[ numTypeExpense=" + numTypeExpense + " ]";
    }
    
}
