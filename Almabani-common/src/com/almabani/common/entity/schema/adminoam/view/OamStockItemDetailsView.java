package com.almabani.common.entity.schema.adminoam.view;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Subselect;

import com.almabani.common.entity.schema.admincor.Establishment;

@Entity
@Subselect("select * from adminoam.V_OAM_STOCK_ITEMS_DETAILS")
public class OamStockItemDetailsView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="NUM_STOCK_ITEM")
	private Long stockItemNumber;
	
	@Column(name="NUM_PROJECT_ITEM")
	private Integer projectItemId;
	
	@ManyToOne
	@JoinColumn(name="NUM_ESTABLISHMENT" , referencedColumnName="NUM_ESTABLISHMENT")
	private Establishment establishment;
	
	@Column(name="IND_IN_OUT")
	private String inOrOut;
	
	
	@Column(name="VAL_ENTRY")
	private Integer amount;
	

	@Column(name="DES_QUOTATION")
	private String quotationDescription;


	public Integer getProjectItemId() {
		return projectItemId;
	}


	public void setProjectItemId(Integer projectItemId) {
		this.projectItemId = projectItemId;
	}


	public Establishment getEstablishment() {
		return establishment;
	}


	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}


	public String getInOrOut() {
		return inOrOut;
	}


	public void setInOrOut(String inOrOut) {
		this.inOrOut = inOrOut;
	}


	public Integer getAmount() {
		return amount;
	}


	public void setAmount(Integer amount) {
		this.amount = amount;
	}


	public String getQuotationDescription() {
		return quotationDescription;
	}


	public void setQuotationDescription(String quotationDescription) {
		this.quotationDescription = quotationDescription;
	}


	public Long getStockItemNumber() {
		return stockItemNumber;
	}


	public void setStockItemNumber(Long stockItemNumber) {
		this.stockItemNumber = stockItemNumber;
	}
	
	
	

}
