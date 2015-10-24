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
@Table(schema="adminret" ,name = "RET_ACCOUNTS_ENTRIES"  ) 
public class RetAccountsEntries implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "NUM_ACCOUNT_ENTRY", nullable = false)
    private Integer numAccountEntry;
    
    @Column(name = "NUM_COMPANY", nullable = false)
    private Integer numCompany;
    
    @Column(name = "DES_ACCOUNT_ENTRY", nullable = false, length = 80)
    private String desAccountEntry;
    
    @Column(name = "NUM_BANK", nullable = false)
    private Integer numBank;
    
    @Column(name = "NUM_AGENCY", nullable = false)
    private int numAgency;
    
    @Column(name = "NUM_ACCOUNT", nullable = false)
    private long numAccount;
    
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numAccountEntry", fetch = FetchType.LAZY)
    private List<RetEntriesExpenses> retEntriesExpensesList;

    public RetAccountsEntries() {
    }

    public RetAccountsEntries(Integer numAccountEntry) {
        this.numAccountEntry = numAccountEntry;
    }

    public RetAccountsEntries(Integer numAccountEntry, Integer numCompany, String desAccountEntry, Integer numBank, int numAgency, long numAccount, Date datBeginValidity, String codLoginInsert, Date datRecordInsert, String codLoginModify, Date datLastModify) {
        this.numAccountEntry = numAccountEntry;
        this.numCompany = numCompany;
        this.desAccountEntry = desAccountEntry;
        this.numBank = numBank;
        this.numAgency = numAgency;
        this.numAccount = numAccount;
        this.datBeginValidity = datBeginValidity;
        this.codLoginInsert = codLoginInsert;
        this.datRecordInsert = datRecordInsert;
        this.codLoginModify = codLoginModify;
        this.datLastModify = datLastModify;
    }

    public Integer getNumAccountEntry() {
        return numAccountEntry;
    }

    public void setNumAccountEntry(Integer numAccountEntry) {
        this.numAccountEntry = numAccountEntry;
    }

    public Integer getNumCompany() {
        return numCompany;
    }

    public void setNumCompany(Integer numCompany) {
        this.numCompany = numCompany;
    }

    public String getDesAccountEntry() {
        return desAccountEntry;
    }

    public void setDesAccountEntry(String desAccountEntry) {
        this.desAccountEntry = desAccountEntry;
    }

    public Integer getNumBank() {
        return numBank;
    }

    public void setNumBank(Integer numBank) {
        this.numBank = numBank;
    }

    public int getNumAgency() {
        return numAgency;
    }

    public void setNumAgency(int numAgency) {
        this.numAgency = numAgency;
    }

    public long getNumAccount() {
        return numAccount;
    }

    public void setNumAccount(long numAccount) {
        this.numAccount = numAccount;
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
    public List<RetEntriesExpenses> getRetEntriesExpensesList() {
        return retEntriesExpensesList;
    }

    public void setRetEntriesExpensesList(List<RetEntriesExpenses> retEntriesExpensesList) {
        this.retEntriesExpensesList = retEntriesExpensesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numAccountEntry != null ? numAccountEntry.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RetAccountsEntries)) {
            return false;
        }
        RetAccountsEntries other = (RetAccountsEntries) object;
        if ((this.numAccountEntry == null && other.numAccountEntry != null) || (this.numAccountEntry != null && !this.numAccountEntry.equals(other.numAccountEntry))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.almabani.common.entity.schema.adminret.RetAccountsEntries[ numAccountEntry=" + numAccountEntry + " ]";
    }
    
}
