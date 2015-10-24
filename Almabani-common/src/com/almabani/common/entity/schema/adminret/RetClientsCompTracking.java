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
@Table(schema="adminret" ,name = "RET_CLIENTS_COMP_TRACKING")
public class RetClientsCompTracking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    
    @Column(name = "NUM_CLIENT_COMP_TRACKING", nullable = false)
    private Long numClientCompTracking;
    
    @Column(name = "DES_TRACKING", nullable = false, length = 300)
    private String desTracking;
    @Column(name = "DAT_NEXT_REMINDER")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datNextReminder;
    @Column(name = "DAT_PROCESS_REMINDER")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datProcessReminder;
    
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
    @JoinColumn(name = "NUM_CLIENT_COMPANY", referencedColumnName = "NUM_CLIENT_COMPANY", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RetClientsCompanies numClientCompany;

    public RetClientsCompTracking() {
    }

    public RetClientsCompTracking(Long numClientCompTracking) {
        this.numClientCompTracking = numClientCompTracking;
    }

    public RetClientsCompTracking(Long numClientCompTracking, String desTracking, String codLoginInsert, Date datRecordInsert, String codLoginModify, Date datLastModify) {
        this.numClientCompTracking = numClientCompTracking;
        this.desTracking = desTracking;
        this.codLoginInsert = codLoginInsert;
        this.datRecordInsert = datRecordInsert;
        this.codLoginModify = codLoginModify;
        this.datLastModify = datLastModify;
    }

    public Long getNumClientCompTracking() {
        return numClientCompTracking;
    }

    public void setNumClientCompTracking(Long numClientCompTracking) {
        this.numClientCompTracking = numClientCompTracking;
    }

    public String getDesTracking() {
        return desTracking;
    }

    public void setDesTracking(String desTracking) {
        this.desTracking = desTracking;
    }

    public Date getDatNextReminder() {
        return datNextReminder;
    }

    public void setDatNextReminder(Date datNextReminder) {
        this.datNextReminder = datNextReminder;
    }

    public Date getDatProcessReminder() {
        return datProcessReminder;
    }

    public void setDatProcessReminder(Date datProcessReminder) {
        this.datProcessReminder = datProcessReminder;
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

    public RetClientsCompanies getNumClientCompany() {
        return numClientCompany;
    }

    public void setNumClientCompany(RetClientsCompanies numClientCompany) {
        this.numClientCompany = numClientCompany;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numClientCompTracking != null ? numClientCompTracking.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RetClientsCompTracking)) {
            return false;
        }
        RetClientsCompTracking other = (RetClientsCompTracking) object;
        if ((this.numClientCompTracking == null && other.numClientCompTracking != null) || (this.numClientCompTracking != null && !this.numClientCompTracking.equals(other.numClientCompTracking))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.almabani.common.entity.schema.adminret.RetClientsCompTracking[ numClientCompTracking=" + numClientCompTracking + " ]";
    }
    
}
