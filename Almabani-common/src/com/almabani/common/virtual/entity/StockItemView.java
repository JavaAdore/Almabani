package com.almabani.common.virtual.entity;

import java.io.Serializable;

import com.almabani.common.entity.schema.adminoam.OamProjectItem;

public class StockItemView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private OamProjectItem projectItem; 
	
	private Long quantityAvaiable;

	
	
	public StockItemView() {
		super();
	}
	
	

	public StockItemView(OamProjectItem projectItem, Long quantityAvaiable) {
		super();
		this.projectItem = projectItem;
		this.quantityAvaiable = quantityAvaiable;
	}



	public OamProjectItem getProjectItem() {
		return projectItem;
	}

	public void setProjectItem(OamProjectItem projectItem) {
		this.projectItem = projectItem;
	}

	public Long getQuantityAvaiable() {
		return quantityAvaiable;
	}

	public void setQuantityAvaiable(Long quantityAvaiable) {
		this.quantityAvaiable = quantityAvaiable;
	}
	
	
	

	
	
	
	
	

	
	
	

}
