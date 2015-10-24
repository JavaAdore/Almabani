package com.almabani.common.entity.schema.adminoam.view;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.almabani.common.entity.schema.admincor.Company;

@Embeddable
public class OamStockItemViewId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="NUM_COMPANY" , referencedColumnName = "NUM_COMPANY")
	private Company company;
	
	@Column(name ="COD_PROJECT")
	private String projectCode;

	@Column(name = "NAM_ESTABLISHMENT")
	private String establishmentName;
	
	@Column(name = "NUM_ESTABLISHMENT")
	private Long establishmentNumber;
	
	@Column(name="NUM_DEPARTMENT")
	private String departmentName;
	
	
	@Column(name="NAM_SECTION")
	private String departmentSection;
	
	@Column(name="NAM_ITEM_CATEGORY")
	private String itemCategory;
	
	@Column(name="DES_TYPE_MATERIAL")
	private String materialType;
	
	@Column(name="NUM_PROJECT_ITEM")
	private Long projectItemId;

	@Column(name="DES_ITEM")
	private String itemDescription;
	
	
	
	

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getEstablishmentName() {
		return establishmentName;
	}

	public void setEstablishmentName(String establishmentName) {
		this.establishmentName = establishmentName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentSection() {
		return departmentSection;
	}

	public void setDepartmentSection(String departmentSection) {
		this.departmentSection = departmentSection;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public Long getProjectItemId() {
		return projectItemId;
	}

	public void setProjectItemId(Long projectItemId) {
		this.projectItemId = projectItemId;
	}

	public Long getEstablishmentNumber() {
		return establishmentNumber;
	}

	public void setEstablishmentNumber(Long establishmentNumber) {
		this.establishmentNumber = establishmentNumber;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	
	
}
