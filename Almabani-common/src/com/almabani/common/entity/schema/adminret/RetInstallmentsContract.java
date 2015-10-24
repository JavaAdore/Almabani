/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.almabani.common.entity.schema.adminret;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(schema="adminret" ,name = "RET_INSTALLMENTS_CONTRACT")
public class RetInstallmentsContract implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RetInstallmentsContractPK retInstallmentsContractPK;
    
    @Column(name = "NUM_GROUP_ACCOUNTING", nullable = false)
    private int numGroupAccounting;
    
    @Column(name = "DAT_DUE_PAYMENT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datDuePayment;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Column(name = "VAL_INSTALLMENT", nullable = false, precision = 14, scale = 6)
    private Integer valInstallment;
    @Column(name = "DAT_PAYMENT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datPayment;
    @Column(name = "VAL_INSTALLMENT_PAYED", precision = 15, scale = 2)
    private Integer valInstallmentPayed;
    @Column(name = "VAL_INCREMENT_PROCESSED", precision = 15, scale = 2)
    private Integer valIncrementProcessed;
    @Column(name = "VAL_INCREMENT_RECEIVED", precision = 15, scale = 2)
    private Integer valIncrementReceived;
    @Column(name = "VAL_FINE_PROCESSED", precision = 15, scale = 2)
    private Integer valFineProcessed;
    @Column(name = "VAL_FINE_RECEIVED", precision = 15, scale = 2)
    private Integer valFineReceived;
    @Column(name = "VAL_DISCOUNT_GRANTED", precision = 15, scale = 2)
    private Integer valDiscountGranted;
    @Column(name = "IND_UNCOLLECTIBLE", length = 1)
    private String indUncollectible;
    @Column(name = "NUM_ITEM_LOT_PAYMENT")
    private Long numItemLotPayment;
    @Column(name = "NUM_ITEM_LOT_SALE")
    private Long numItemLotSale;
    
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
    @JoinColumn(name = "NUM_COMPANY_CONTRACT", referencedColumnName = "NUM_COMPANY_CONTRACT", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RetCompaniesContracts retCompaniesContracts;

    public RetInstallmentsContract() {
    }

    public RetInstallmentsContract(RetInstallmentsContractPK retInstallmentsContractPK) {
        this.retInstallmentsContractPK = retInstallmentsContractPK;
    }

    public RetInstallmentsContract(RetInstallmentsContractPK retInstallmentsContractPK, int numGroupAccounting, Date datDuePayment, Integer valInstallment, String codLoginInsert, Date datRecordInsert, String codLoginModify, Date datLastModify) {
        this.retInstallmentsContractPK = retInstallmentsContractPK;
        this.numGroupAccounting = numGroupAccounting;
        this.datDuePayment = datDuePayment;
        this.valInstallment = valInstallment;
        this.codLoginInsert = codLoginInsert;
        this.datRecordInsert = datRecordInsert;
        this.codLoginModify = codLoginModify;
        this.datLastModify = datLastModify;
    }

    public RetInstallmentsContract(long numCompanyContract, Integer numInstallment) {
        this.retInstallmentsContractPK = new RetInstallmentsContractPK(numCompanyContract, numInstallment);
    }

    public RetInstallmentsContractPK getRetInstallmentsContractPK() {
        return retInstallmentsContractPK;
    }

    public void setRetInstallmentsContractPK(RetInstallmentsContractPK retInstallmentsContractPK) {
        this.retInstallmentsContractPK = retInstallmentsContractPK;
    }

    public int getNumGroupAccounting() {
        return numGroupAccounting;
    }

    public void setNumGroupAccounting(int numGroupAccounting) {
        this.numGroupAccounting = numGroupAccounting;
    }

    public Date getDatDuePayment() {
        return datDuePayment;
    }

    public void setDatDuePayment(Date datDuePayment) {
        this.datDuePayment = datDuePayment;
    }

    public Integer getValInstallment() {
        return valInstallment;
    }

    public void setValInstallment(Integer valInstallment) {
        this.valInstallment = valInstallment;
    }

    public Date getDatPayment() {
        return datPayment;
    }

    public void setDatPayment(Date datPayment) {
        this.datPayment = datPayment;
    }

    public Integer getValInstallmentPayed() {
        return valInstallmentPayed;
    }

    public void setValInstallmentPayed(Integer valInstallmentPayed) {
        this.valInstallmentPayed = valInstallmentPayed;
    }

    public Integer getValIncrementProcessed() {
        return valIncrementProcessed;
    }

    public void setValIncrementProcessed(Integer valIncrementProcessed) {
        this.valIncrementProcessed = valIncrementProcessed;
    }

    public Integer getValIncrementReceived() {
        return valIncrementReceived;
    }

    public void setValIncrementReceived(Integer valIncrementReceived) {
        this.valIncrementReceived = valIncrementReceived;
    }

    public Integer getValFineProcessed() {
        return valFineProcessed;
    }

    public void setValFineProcessed(Integer valFineProcessed) {
        this.valFineProcessed = valFineProcessed;
    }

    public Integer getValFineReceived() {
        return valFineReceived;
    }

    public void setValFineReceived(Integer valFineReceived) {
        this.valFineReceived = valFineReceived;
    }

    public Integer getValDiscountGranted() {
        return valDiscountGranted;
    }

    public void setValDiscountGranted(Integer valDiscountGranted) {
        this.valDiscountGranted = valDiscountGranted;
    }

    public String getIndUncollectible() {
        return indUncollectible;
    }

    public void setIndUncollectible(String indUncollectible) {
        this.indUncollectible = indUncollectible;
    }

    public Long getNumItemLotPayment() {
        return numItemLotPayment;
    }

    public void setNumItemLotPayment(Long numItemLotPayment) {
        this.numItemLotPayment = numItemLotPayment;
    }

    public Long getNumItemLotSale() {
        return numItemLotSale;
    }

    public void setNumItemLotSale(Long numItemLotSale) {
        this.numItemLotSale = numItemLotSale;
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

    public RetCompaniesContracts getRetCompaniesContracts() {
        return retCompaniesContracts;
    }

    public void setRetCompaniesContracts(RetCompaniesContracts retCompaniesContracts) {
        this.retCompaniesContracts = retCompaniesContracts;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (retInstallmentsContractPK != null ? retInstallmentsContractPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RetInstallmentsContract)) {
            return false;
        }
        RetInstallmentsContract other = (RetInstallmentsContract) object;
        if ((this.retInstallmentsContractPK == null && other.retInstallmentsContractPK != null) || (this.retInstallmentsContractPK != null && !this.retInstallmentsContractPK.equals(other.retInstallmentsContractPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.almabani.common.entity.schema.adminret.RetInstallmentsContract[ retInstallmentsContractPK=" + retInstallmentsContractPK + " ]";
    }
    
}
