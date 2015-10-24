/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.almabani.common.entity.schema.adminret;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author orcl
 */
@Embeddable
public class RetInstallmentsContractPK implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "NUM_COMPANY_CONTRACT", nullable = false)
    private long numCompanyContract;
    
    @Column(name = "NUM_INSTALLMENT", nullable = false)
    private Integer numInstallment;

    public RetInstallmentsContractPK() {
    }

    public RetInstallmentsContractPK(long numCompanyContract, Integer numInstallment) {
        this.numCompanyContract = numCompanyContract;
        this.numInstallment = numInstallment;
    }

    public long getNumCompanyContract() {
        return numCompanyContract;
    }

    public void setNumCompanyContract(long numCompanyContract) {
        this.numCompanyContract = numCompanyContract;
    }

    public Integer getNumInstallment() {
        return numInstallment;
    }

    public void setNumInstallment(Integer numInstallment) {
        this.numInstallment = numInstallment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numCompanyContract;
        hash += (int) numInstallment;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RetInstallmentsContractPK)) {
            return false;
        }
        RetInstallmentsContractPK other = (RetInstallmentsContractPK) object;
        if (this.numCompanyContract != other.numCompanyContract) {
            return false;
        }
        if (this.numInstallment != other.numInstallment) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.almabani.common.entity.schema.adminret.RetInstallmentsContractPK[ numCompanyContract=" + numCompanyContract + ", numInstallment=" + numInstallment + " ]";
    }
    
}
