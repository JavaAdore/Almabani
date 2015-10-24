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
@Table(schema="adminret" ,name = "RET_TYPES_PLANS")
public class RetTypesPlans implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    
    @Column(name = "NUM_TYPE_PLAN", nullable = false)
    private Integer numTypePlan;
    
    @Column(name = "NUM_COMPANY", nullable = false)
    private Integer numCompany;
    
    @Column(name = "DES_SERVICE_PLAN", nullable = false, length = 80)
    private String desServicePlan;
    
    @Column(name = "DAT_BEGIN_VALIDITY", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datBeginValidity;
    @Column(name = "DAT_END_VALIDITY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datEndValidity;
    @Column(name = "NUM_DAY_PAYMENT_DELAY")
    private Integer numDayPaymentDelay;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Column(name = "VAL_SERVICE_PLAN", nullable = false, precision = 15, scale = 2)
    private Integer valServicePlan;
    
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numTypePlan", fetch = FetchType.LAZY)
    private List<RetPaymentsPlans> retPaymentsPlansList;

    public RetTypesPlans() {
    }

    public RetTypesPlans(Integer numTypePlan) {
        this.numTypePlan = numTypePlan;
    }

    public RetTypesPlans(Integer numTypePlan, Integer numCompany, String desServicePlan, Date datBeginValidity, Integer valServicePlan, String codLoginInsert, Date datRecordInsert, String codLoginModify, Date datLastModify) {
        this.numTypePlan = numTypePlan;
        this.numCompany = numCompany;
        this.desServicePlan = desServicePlan;
        this.datBeginValidity = datBeginValidity;
        this.valServicePlan = valServicePlan;
        this.codLoginInsert = codLoginInsert;
        this.datRecordInsert = datRecordInsert;
        this.codLoginModify = codLoginModify;
        this.datLastModify = datLastModify;
    }

    public Integer getNumTypePlan() {
        return numTypePlan;
    }

    public void setNumTypePlan(Integer numTypePlan) {
        this.numTypePlan = numTypePlan;
    }

    public Integer getNumCompany() {
        return numCompany;
    }

    public void setNumCompany(Integer numCompany) {
        this.numCompany = numCompany;
    }

    public String getDesServicePlan() {
        return desServicePlan;
    }

    public void setDesServicePlan(String desServicePlan) {
        this.desServicePlan = desServicePlan;
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

    public Integer getNumDayPaymentDelay() {
        return numDayPaymentDelay;
    }

    public void setNumDayPaymentDelay(Integer numDayPaymentDelay) {
        this.numDayPaymentDelay = numDayPaymentDelay;
    }

    public Integer getValServicePlan() {
        return valServicePlan;
    }

    public void setValServicePlan(Integer valServicePlan) {
        this.valServicePlan = valServicePlan;
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
        hash += (numTypePlan != null ? numTypePlan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RetTypesPlans)) {
            return false;
        }
        RetTypesPlans other = (RetTypesPlans) object;
        if ((this.numTypePlan == null && other.numTypePlan != null) || (this.numTypePlan != null && !this.numTypePlan.equals(other.numTypePlan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.almabani.common.entity.schema.adminret.RetTypesPlans[ numTypePlan=" + numTypePlan + " ]";
    }
    
}
