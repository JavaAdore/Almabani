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
@Table(schema="adminret" ,name = "RET_SUB_TYPES_EXPENSES")
public class RetSubTypesExpenses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    
    @Column(name = "NUM_SUB_TYPE_EXPENSE", nullable = false)
    private Integer numSubTypeExpense;
    
    @Column(name = "DES_SUB_TYPE_EXPENSE", nullable = false, length = 80)
    private String desSubTypeExpense;
    
    @Column(name = "IND_CRED_DEB", nullable = false, length = 1)
    private String indCredDeb;
    
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
    @JoinColumn(name = "NUM_TYPE_EXPENSE", referencedColumnName = "NUM_TYPE_EXPENSE", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RetTypesExpenses numTypeExpense;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numSubTypeExpense", fetch = FetchType.LAZY)
    private List<RetEntriesExpenses> retEntriesExpensesList;

    public RetSubTypesExpenses() {
    }

    public RetSubTypesExpenses(Integer numSubTypeExpense) {
        this.numSubTypeExpense = numSubTypeExpense;
    }

    public RetSubTypesExpenses(Integer numSubTypeExpense, String desSubTypeExpense, String indCredDeb, Date datBeginValidity, String codLoginInsert, Date datRecordInsert, String codLoginModify, Date datLastModify) {
        this.numSubTypeExpense = numSubTypeExpense;
        this.desSubTypeExpense = desSubTypeExpense;
        this.indCredDeb = indCredDeb;
        this.datBeginValidity = datBeginValidity;
        this.codLoginInsert = codLoginInsert;
        this.datRecordInsert = datRecordInsert;
        this.codLoginModify = codLoginModify;
        this.datLastModify = datLastModify;
    }

    public Integer getNumSubTypeExpense() {
        return numSubTypeExpense;
    }

    public void setNumSubTypeExpense(Integer numSubTypeExpense) {
        this.numSubTypeExpense = numSubTypeExpense;
    }

    public String getDesSubTypeExpense() {
        return desSubTypeExpense;
    }

    public void setDesSubTypeExpense(String desSubTypeExpense) {
        this.desSubTypeExpense = desSubTypeExpense;
    }

    public String getIndCredDeb() {
        return indCredDeb;
    }

    public void setIndCredDeb(String indCredDeb) {
        this.indCredDeb = indCredDeb;
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

    public RetTypesExpenses getNumTypeExpense() {
        return numTypeExpense;
    }

    public void setNumTypeExpense(RetTypesExpenses numTypeExpense) {
        this.numTypeExpense = numTypeExpense;
    }

    @XmlTransient
    public List<RetEntriesExpenses> getRetEntriesExpensesList() {
        return retEntriesExpensesList;
    }

    public void setRetEntriesExpensesList(List<RetEntriesExpenses> retEntriesExpensesList) {
        this.retEntriesExpensesList = retEntriesExpensesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numSubTypeExpense != null ? numSubTypeExpense.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RetSubTypesExpenses)) {
            return false;
        }
        RetSubTypesExpenses other = (RetSubTypesExpenses) object;
        if ((this.numSubTypeExpense == null && other.numSubTypeExpense != null) || (this.numSubTypeExpense != null && !this.numSubTypeExpense.equals(other.numSubTypeExpense))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.almabani.common.entity.schema.adminret.RetSubTypesExpenses[ numSubTypeExpense=" + numSubTypeExpense + " ]";
    }
    
}
