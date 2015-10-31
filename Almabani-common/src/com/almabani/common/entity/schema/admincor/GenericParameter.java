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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author orcl
 */
@Entity
@Table(name = "COM_TYPES_GEN_PARAMETERS", catalog = "", schema = "ADMINCOR")
public class GenericParameter implements Serializable {
	private final static long serialVersionUID = 1L;
	
	private final static String COMMUNICATOR_PARAM_CODE = "communicat";
	
	private final static String SAFETY_PARAM_CODE = "safety";
	
	private final static String TECHNICIAN_PARAM_CODE = "technician";
	
	private final static String OPERATOR_PARAM_CODE = "operator";


	public final static GenericParameter COMMUNICATOR = new GenericParameter(
			COMMUNICATOR_PARAM_CODE);
	
	public final static GenericParameter SAFETY = new GenericParameter(
			SAFETY_PARAM_CODE);
	
	public final static GenericParameter TECHNICIAN = new GenericParameter(
			TECHNICIAN_PARAM_CODE);
	
	public final static GenericParameter OPERATOR = new GenericParameter(
			OPERATOR_PARAM_CODE);


	@Id
	@Column(name = "COD_GENERAL_PARAMETER")
	private String generalParameterCode;

	@Column(name = "DES_GENERAL_PARAMETER")
	private String generalParameterDescription;

	@Column(name = "NAM_USER_MODIFY")
	private String userModifiedName;


	@Column(name = "IND_TYPE_PARAMETER")
	private String parameterType;
	
	@Column(name = "DAT_LAST_MODIFY")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModificationDate;

	public GenericParameter() {
	}

	public GenericParameter(String generalParameterCode) {
		super();
		this.generalParameterCode = generalParameterCode;
	}

	
	public String getGeneralParameterCode() {
		return generalParameterCode;
	}

	public void setGeneralParameterCode(String generalParameterCode) {
		this.generalParameterCode = generalParameterCode;
	}

	public String getGeneralParameterDescription() {
		return generalParameterDescription;
	}

	public void setGeneralParameterDescription(
			String generalParameterDescription) {
		this.generalParameterDescription = generalParameterDescription;
	}

	public String getUserModifiedName() {
		return userModifiedName;
	}

	public void setUserModifiedName(String userModifiedName) {
		this.userModifiedName = userModifiedName;
	}

	public Date getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	public String getParameterType() {
		return parameterType;
	}

	public void setParameterType(String parameterType) {
		this.parameterType = parameterType;
	}

}
