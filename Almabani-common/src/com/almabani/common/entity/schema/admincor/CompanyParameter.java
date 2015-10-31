/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.almabani.common.entity.schema.admincor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.almabani.common.entity.AbstractEntity;

/**
 * 
 * @author orcl
 */
@Entity
@Table(name = "COM_COMPANIES_PARAMETERS", catalog = "", schema = "ADMINCOR")
public class CompanyParameter extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "NUM_COMPANY_PARAMETER")
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "COD_GENERAL_PARAMETER", referencedColumnName = "COD_GENERAL_PARAMETER")
	private GenericParameter parameter;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation

	@JoinColumn(name = "NUM_COMPANY", referencedColumnName = "NUM_COMPANY")
	@ManyToOne(optional = false)
	private Company company;

	@Column(name = "COD_ATTRIBUTION_PARAMETER")
	private String codeAttributeParameter;

	@Column(name = "NAM_USER_MODIFY")
	private String namUserModify;

	@Column(name = "DAT_LAST_MODIFY")
	@Temporal(TemporalType.TIMESTAMP)
	private Date datLastModify;

	public CompanyParameter() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GenericParameter getParameter() {
		return parameter;
	}

	public void setParameter(GenericParameter parameter) {
		this.parameter = parameter;
	}

	public String getCodeAttributeParameter() {
		return codeAttributeParameter;
	}

	public void setCodeAttributeParameter(String codeAttributeParameter) {
		this.codeAttributeParameter = codeAttributeParameter;
	}

	public String getNamUserModify() {
		return namUserModify;
	}

	public void setNamUserModify(String namUserModify) {
		this.namUserModify = namUserModify;
	}

	public Date getDatLastModify() {
		return datLastModify;
	}

	public void setDatLastModify(Date datLastModify) {
		this.datLastModify = datLastModify;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Object getValuedParam() {
		return codeAttributeParameter;
	}

}
