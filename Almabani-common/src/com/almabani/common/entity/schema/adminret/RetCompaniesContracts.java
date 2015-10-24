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
@Table(schema="adminret" ,name = "RET_COMPANIES_CONTRACTS")
public class RetCompaniesContracts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    
    @Column(name = "NUM_COMPANY_CONTRACT", nullable = false)
    private Long numCompanyContract;
    
    @Column(name = "DAT_CONTRACT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datContract;
    
    @Column(name = "DAT_BEGIN_VALIDITY", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datBeginValidity;
    @Column(name = "DAT_END_VALIDITY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datEndValidity;
    
    @Column(name = "IND_MONDAY_OFFER", nullable = false, length = 1)
    private String indMondayOffer;
    
    @Column(name = "IND_TUESDAY_OFFER", nullable = false, length = 1)
    private String indTuesdayOffer;
    
    @Column(name = "IND_WEDNESDAY_OFFER", nullable = false, length = 1)
    private String indWednesdayOffer;
    
    @Column(name = "IND_THURSDAY_OFFER", nullable = false, length = 1)
    private String indThursdayOffer;
    
    @Column(name = "IND_FRIDAY_OFFER", nullable = false, length = 1)
    private String indFridayOffer;
    
    @Column(name = "IND_SATURDAY_OFFER", nullable = false, length = 1)
    private String indSaturdayOffer;
    
    @Column(name = "IND_SUNDAY_OFFER", nullable = false, length = 1)
    private String indSundayOffer;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Column(name = "VAL_LIMIT_OFFER", nullable = false, precision = 15, scale = 2)
    private Integer valLimitOffer;
    
    @Column(name = "VAL_FROM_OFFER", nullable = false, precision = 15, scale = 2)
    private Integer valFromOffer;
    
    @Column(name = "VAL_TO_OFFER", nullable = false, precision = 15, scale = 2)
    private Integer valToOffer;
    
    @Column(name = "QUT_LIMIT_USERS", nullable = false)
    private int qutLimitUsers;
    @Column(name = "DES_EMAIL_BILLING", length = 40)
    private String desEmailBilling;
    @Column(name = "NUM_PREVIOUS_CONTRACT")
    private Integer numPreviousContract;
    @Column(name = "DAT_CANCELLATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datCancellation;
    @Column(name = "NAM_USER_CANCELLATION", length = 10)
    private String namUserCancellation;
    @Column(name = "DES_JUSTIFICATION_CANCELLATION", length = 100)
    private String desJustificationCancellation;
    @Column(name = "DAT_NEXT_BILLING")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datNextBilling;
    @Column(name = "DAT_PROCESS_NEXT_BILLING")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datProcessNextBilling;
    
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numCompanyContract", fetch = FetchType.LAZY)
    private List<RetSituationsContract> retSituationsContractList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "retCompaniesContracts", fetch = FetchType.LAZY)
    private List<RetInstallmentsContract> retInstallmentsContractList;
    @JoinColumn(name = "NUM_CLIENT_COMPANY", referencedColumnName = "NUM_CLIENT_COMPANY", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RetClientsCompanies numClientCompany;
    @JoinColumn(name = "NUM_PAYMENT_PLAN", referencedColumnName = "NUM_PAYMENT_PLAN", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RetPaymentsPlans numPaymentPlan;
    @JoinColumn(name = "NUM_TYPE_DISCOUNT", referencedColumnName = "NUM_TYPE_DISCOUNT", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RetTypesDiscount numTypeDiscount;

    public RetCompaniesContracts() {
    }

    public RetCompaniesContracts(Long numCompanyContract) {
        this.numCompanyContract = numCompanyContract;
    }

    public RetCompaniesContracts(Long numCompanyContract, Date datContract, Date datBeginValidity, String indMondayOffer, String indTuesdayOffer, String indWednesdayOffer, String indThursdayOffer, String indFridayOffer, String indSaturdayOffer, String indSundayOffer, Integer valLimitOffer, Integer valFromOffer, Integer valToOffer, int qutLimitUsers, String codLoginInsert, Date datRecordInsert, String codLoginModify, Date datLastModify) {
        this.numCompanyContract = numCompanyContract;
        this.datContract = datContract;
        this.datBeginValidity = datBeginValidity;
        this.indMondayOffer = indMondayOffer;
        this.indTuesdayOffer = indTuesdayOffer;
        this.indWednesdayOffer = indWednesdayOffer;
        this.indThursdayOffer = indThursdayOffer;
        this.indFridayOffer = indFridayOffer;
        this.indSaturdayOffer = indSaturdayOffer;
        this.indSundayOffer = indSundayOffer;
        this.valLimitOffer = valLimitOffer;
        this.valFromOffer = valFromOffer;
        this.valToOffer = valToOffer;
        this.qutLimitUsers = qutLimitUsers;
        this.codLoginInsert = codLoginInsert;
        this.datRecordInsert = datRecordInsert;
        this.codLoginModify = codLoginModify;
        this.datLastModify = datLastModify;
    }

    public Long getNumCompanyContract() {
        return numCompanyContract;
    }

    public void setNumCompanyContract(Long numCompanyContract) {
        this.numCompanyContract = numCompanyContract;
    }

    public Date getDatContract() {
        return datContract;
    }

    public void setDatContract(Date datContract) {
        this.datContract = datContract;
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

    public String getIndMondayOffer() {
        return indMondayOffer;
    }

    public void setIndMondayOffer(String indMondayOffer) {
        this.indMondayOffer = indMondayOffer;
    }

    public String getIndTuesdayOffer() {
        return indTuesdayOffer;
    }

    public void setIndTuesdayOffer(String indTuesdayOffer) {
        this.indTuesdayOffer = indTuesdayOffer;
    }

    public String getIndWednesdayOffer() {
        return indWednesdayOffer;
    }

    public void setIndWednesdayOffer(String indWednesdayOffer) {
        this.indWednesdayOffer = indWednesdayOffer;
    }

    public String getIndThursdayOffer() {
        return indThursdayOffer;
    }

    public void setIndThursdayOffer(String indThursdayOffer) {
        this.indThursdayOffer = indThursdayOffer;
    }

    public String getIndFridayOffer() {
        return indFridayOffer;
    }

    public void setIndFridayOffer(String indFridayOffer) {
        this.indFridayOffer = indFridayOffer;
    }

    public String getIndSaturdayOffer() {
        return indSaturdayOffer;
    }

    public void setIndSaturdayOffer(String indSaturdayOffer) {
        this.indSaturdayOffer = indSaturdayOffer;
    }

    public String getIndSundayOffer() {
        return indSundayOffer;
    }

    public void setIndSundayOffer(String indSundayOffer) {
        this.indSundayOffer = indSundayOffer;
    }

    public Integer getValLimitOffer() {
        return valLimitOffer;
    }

    public void setValLimitOffer(Integer valLimitOffer) {
        this.valLimitOffer = valLimitOffer;
    }

    public Integer getValFromOffer() {
        return valFromOffer;
    }

    public void setValFromOffer(Integer valFromOffer) {
        this.valFromOffer = valFromOffer;
    }

    public Integer getValToOffer() {
        return valToOffer;
    }

    public void setValToOffer(Integer valToOffer) {
        this.valToOffer = valToOffer;
    }

    public int getQutLimitUsers() {
        return qutLimitUsers;
    }

    public void setQutLimitUsers(int qutLimitUsers) {
        this.qutLimitUsers = qutLimitUsers;
    }

    public String getDesEmailBilling() {
        return desEmailBilling;
    }

    public void setDesEmailBilling(String desEmailBilling) {
        this.desEmailBilling = desEmailBilling;
    }

    public Integer getNumPreviousContract() {
        return numPreviousContract;
    }

    public void setNumPreviousContract(Integer numPreviousContract) {
        this.numPreviousContract = numPreviousContract;
    }

    public Date getDatCancellation() {
        return datCancellation;
    }

    public void setDatCancellation(Date datCancellation) {
        this.datCancellation = datCancellation;
    }

    public String getNamUserCancellation() {
        return namUserCancellation;
    }

    public void setNamUserCancellation(String namUserCancellation) {
        this.namUserCancellation = namUserCancellation;
    }

    public String getDesJustificationCancellation() {
        return desJustificationCancellation;
    }

    public void setDesJustificationCancellation(String desJustificationCancellation) {
        this.desJustificationCancellation = desJustificationCancellation;
    }

    public Date getDatNextBilling() {
        return datNextBilling;
    }

    public void setDatNextBilling(Date datNextBilling) {
        this.datNextBilling = datNextBilling;
    }

    public Date getDatProcessNextBilling() {
        return datProcessNextBilling;
    }

    public void setDatProcessNextBilling(Date datProcessNextBilling) {
        this.datProcessNextBilling = datProcessNextBilling;
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
    public List<RetSituationsContract> getRetSituationsContractList() {
        return retSituationsContractList;
    }

    public void setRetSituationsContractList(List<RetSituationsContract> retSituationsContractList) {
        this.retSituationsContractList = retSituationsContractList;
    }

    @XmlTransient
    public List<RetInstallmentsContract> getRetInstallmentsContractList() {
        return retInstallmentsContractList;
    }

    public void setRetInstallmentsContractList(List<RetInstallmentsContract> retInstallmentsContractList) {
        this.retInstallmentsContractList = retInstallmentsContractList;
    }

    public RetClientsCompanies getNumClientCompany() {
        return numClientCompany;
    }

    public void setNumClientCompany(RetClientsCompanies numClientCompany) {
        this.numClientCompany = numClientCompany;
    }

    public RetPaymentsPlans getNumPaymentPlan() {
        return numPaymentPlan;
    }

    public void setNumPaymentPlan(RetPaymentsPlans numPaymentPlan) {
        this.numPaymentPlan = numPaymentPlan;
    }

    public RetTypesDiscount getNumTypeDiscount() {
        return numTypeDiscount;
    }

    public void setNumTypeDiscount(RetTypesDiscount numTypeDiscount) {
        this.numTypeDiscount = numTypeDiscount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numCompanyContract != null ? numCompanyContract.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RetCompaniesContracts)) {
            return false;
        }
        RetCompaniesContracts other = (RetCompaniesContracts) object;
        if ((this.numCompanyContract == null && other.numCompanyContract != null) || (this.numCompanyContract != null && !this.numCompanyContract.equals(other.numCompanyContract))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.almabani.common.entity.schema.adminret.RetCompaniesContracts[ numCompanyContract=" + numCompanyContract + " ]";
    }
    
}
