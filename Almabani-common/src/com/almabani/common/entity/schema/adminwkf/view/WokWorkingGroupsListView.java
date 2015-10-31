/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.almabani.common.entity.schema.adminwkf.view;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Subselect;

/**
 * 
 * @author orcl
 */
@Entity
@Subselect("SELECT * FROM ADMINWKF.V_WOK_WORKING_GROUPS_LIST")
public class WokWorkingGroupsListView implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "NUM_WORKING_GROUP")
	private Long numWorkingGroup;

	@Column(name = "NUM_COMPANY")
	private Long numCompany;

	@Column(name = "NAM_COMPANY")
	private String namCompany;

	@Column(name = "NUM_PROJECT")
	private Long numProject;

	@Column(name = "COD_PROJECT")
	private String codProject;

	@Column(name = "COD_WORKING_GROUP")
	private String codWorkingGroup;

	@Column(name = "DES_WORKING_GROUP")
	private String desWorkingGroup;
	@Column(name = "QUT_ROWS")
	private Long qutRows;

	public WokWorkingGroupsListView() {
	}

	public Long getNumCompany() {
		return numCompany;
	}

	public void setNumCompany(Long numCompany) {
		this.numCompany = numCompany;
	}

	public String getNamCompany() {
		return namCompany;
	}

	public void setNamCompany(String namCompany) {
		this.namCompany = namCompany;
	}

	public Long getNumProject() {
		return numProject;
	}

	public void setNumProject(Long numProject) {
		this.numProject = numProject;
	}

	public String getCodProject() {
		return codProject;
	}

	public void setCodProject(String codProject) {
		this.codProject = codProject;
	}

	public Long getNumWorkingGroup() {
		return numWorkingGroup;
	}

	public void setNumWorkingGroup(Long numWorkingGroup) {
		this.numWorkingGroup = numWorkingGroup;
	}

	public String getCodWorkingGroup() {
		return codWorkingGroup;
	}

	public void setCodWorkingGroup(String codWorkingGroup) {
		this.codWorkingGroup = codWorkingGroup;
	}

	public String getDesWorkingGroup() {
		return desWorkingGroup;
	}

	public void setDesWorkingGroup(String desWorkingGroup) {
		this.desWorkingGroup = desWorkingGroup;
	}

	public Long getQutRows() {
		return qutRows;
	}

	public void setQutRows(Long qutRows) {
		this.qutRows = qutRows;
	}

}
