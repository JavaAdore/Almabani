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
@Table(schema="adminret" ,name = "RET_PAYMENTS_PLANS")
public class RetPaymentsPlans implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    
    @Column(name = "NUM_PAYMENT_PLAN", nullable = false)
    private Integer numPaymentPlan;
    
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Column(name = "PER_DISCOUNT_PAY_PLAN", nullable = false, precision = 5, scale = 2)
    private Integer perDiscountPayPlan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numPaymentPlan", fetch = FetchType.LAZY)
    private List<RetCompaniesContracts> retCompaniesContractsList;
    @JoinColumn(name = "NUM_TYPE_PAYMENT", referencedColumnName = "NUM_TYPE_PAYMENT", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RetTypesPayment numTypePayment;
    @JoinColumn(name = "NUM_TYPE_PLAN", referencedColumnName = "NUM_TYPE_PLAN", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RetTypesPlans numTypePlan;

    public RetPaymentsPlans() {
    }

    public RetPaymentsPlans(Integer numPaymentPlan) {
        this.numPaymentPlan = numPaymentPlan;
    }

    public RetPaymentsPlans(Integer numPaymentPlan, Date datBeginValidity, String codLoginInsert, Date datRecordInsert, String codLoginModify, Date datLastModify, Integer perDiscountPayPlan) {
        this.numPaymentPlan = numPaymentPlan;
        this.datBeginValidity = datBeginValidity;
        this.codLoginInsert = codLoginInsert;
        this.datRecordInsert = datRecordInsert;
        this.codLoginModify = codLoginModify;
        this.datLastModify = datLastModify;
        this.perDiscountPayPlan = perDiscountPayPlan;
    }

    public Integer getNumPaymentPlan() {
        return numPaymentPlan;
    }

    public void setNumPaymentPlan(Integer numPaymentPlan) {
        this.numPaymentPlan = numPaymentPlan;
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

    public Integer getPerDiscountPayPlan() {
        return perDiscountPayPlan;
    }

    public void setPerDiscountPayPlan(Integer perDiscountPayPlan) {
        this.perDiscountPayPlan = perDiscountPayPlan;
    }

    @XmlTransient
    public List<RetCompaniesContracts> getRetCompaniesContractsList() {
        return retCompaniesContractsList;
    }

    public void setRetCompaniesContractsList(List<RetCompaniesContracts> retCompaniesContractsList) {
        this.retCompaniesContractsList = retCompaniesContractsList;
    }

    public RetTypesPayment getNumTypePayment() {
        return numTypePayment;
    }

    public void setNumTypePayment(RetTypesPayment numTypePayment) {
        this.numTypePayment = numTypePayment;
    }

    public RetTypesPlans getNumTypePlan() {
        return numTypePlan;
    }

    public void setNumTypePlan(RetTypesPlans numTypePlan) {
        this.numTypePlan = numTypePlan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numPaymentPlan != null ? numPaymentPlan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RetPaymentsPlans)) {
            return false;
        }
        RetPaymentsPlans other = (RetPaymentsPlans) object;
        if ((this.numPaymentPlan == null && other.numPaymentPlan != null) || (this.numPaymentPlan != null && !this.numPaymentPlan.equals(other.numPaymentPlan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.almabani.common.entity.schema.adminret.RetPaymentsPlans[ numPaymentPlan=" + numPaymentPlan + " ]";
    }
    
}
