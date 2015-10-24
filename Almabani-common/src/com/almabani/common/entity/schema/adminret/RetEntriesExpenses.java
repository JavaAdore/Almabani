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
@Table(schema="adminret" ,name = "RET_ENTRIES_EXPENSES")
public class RetEntriesExpenses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    
    @Column(name = "NUM_ENTRY_EXPENSE", nullable = false)
    private Integer numEntryExpense;
    
    @Column(name = "DAT_ENTRY", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datEntry;
    
    @Column(name = "DAT_REGISTRATION_ENTRY", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datRegistrationEntry;
    
    @Column(name = "IND_ADJUSTMENT", nullable = false, length = 1)
    private String indAdjustment;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Column(name = "VAL_ENTRY", nullable = false, precision = 15, scale = 2)
    private Integer valEntry;
    @Column(name = "DES_OBSERVATION", length = 80)
    private String desObservation;
    @Column(name = "DES_MOTIVE_ADJUSTMENT", length = 80)
    private String desMotiveAdjustment;
    
    @Column(name = "COD_LOGIN_INSERT", nullable = false, length = 10)
    private String codLoginInsert;
    
    @Column(name = "DAT_RECORD_INSERT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datRecordInsert;
    @JoinColumn(name = "NUM_ACCOUNT_ENTRY", referencedColumnName = "NUM_ACCOUNT_ENTRY", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RetAccountsEntries numAccountEntry;
    @JoinColumn(name = "NUM_SUB_TYPE_EXPENSE", referencedColumnName = "NUM_SUB_TYPE_EXPENSE", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RetSubTypesExpenses numSubTypeExpense;

    public RetEntriesExpenses() {
    }

    public RetEntriesExpenses(Integer numEntryExpense) {
        this.numEntryExpense = numEntryExpense;
    }

    public RetEntriesExpenses(Integer numEntryExpense, Date datEntry, Date datRegistrationEntry, String indAdjustment, Integer valEntry, String codLoginInsert, Date datRecordInsert) {
        this.numEntryExpense = numEntryExpense;
        this.datEntry = datEntry;
        this.datRegistrationEntry = datRegistrationEntry;
        this.indAdjustment = indAdjustment;
        this.valEntry = valEntry;
        this.codLoginInsert = codLoginInsert;
        this.datRecordInsert = datRecordInsert;
    }

    public Integer getNumEntryExpense() {
        return numEntryExpense;
    }

    public void setNumEntryExpense(Integer numEntryExpense) {
        this.numEntryExpense = numEntryExpense;
    }

    public Date getDatEntry() {
        return datEntry;
    }

    public void setDatEntry(Date datEntry) {
        this.datEntry = datEntry;
    }

    public Date getDatRegistrationEntry() {
        return datRegistrationEntry;
    }

    public void setDatRegistrationEntry(Date datRegistrationEntry) {
        this.datRegistrationEntry = datRegistrationEntry;
    }

    public String getIndAdjustment() {
        return indAdjustment;
    }

    public void setIndAdjustment(String indAdjustment) {
        this.indAdjustment = indAdjustment;
    }

    public Integer getValEntry() {
        return valEntry;
    }

    public void setValEntry(Integer valEntry) {
        this.valEntry = valEntry;
    }

    public String getDesObservation() {
        return desObservation;
    }

    public void setDesObservation(String desObservation) {
        this.desObservation = desObservation;
    }

    public String getDesMotiveAdjustment() {
        return desMotiveAdjustment;
    }

    public void setDesMotiveAdjustment(String desMotiveAdjustment) {
        this.desMotiveAdjustment = desMotiveAdjustment;
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

    public RetAccountsEntries getNumAccountEntry() {
        return numAccountEntry;
    }

    public void setNumAccountEntry(RetAccountsEntries numAccountEntry) {
        this.numAccountEntry = numAccountEntry;
    }

    public RetSubTypesExpenses getNumSubTypeExpense() {
        return numSubTypeExpense;
    }

    public void setNumSubTypeExpense(RetSubTypesExpenses numSubTypeExpense) {
        this.numSubTypeExpense = numSubTypeExpense;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numEntryExpense != null ? numEntryExpense.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RetEntriesExpenses)) {
            return false;
        }
        RetEntriesExpenses other = (RetEntriesExpenses) object;
        if ((this.numEntryExpense == null && other.numEntryExpense != null) || (this.numEntryExpense != null && !this.numEntryExpense.equals(other.numEntryExpense))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.almabani.common.entity.schema.adminret.RetEntriesExpenses[ numEntryExpense=" + numEntryExpense + " ]";
    }
    
}
