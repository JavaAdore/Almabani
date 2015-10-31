package com.almabani.common.entity.schema.adminoam.view;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Subselect;

@Entity
@Subselect("select * from adminoam.V_OAM_STOCK_ITEMS")
public class OamStockItemView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@EmbeddedId
	private OamStockItemViewId oamStockItemViewId;
	
	@Column(name = "QUANTITY_AVAILABLE")
	private Long availableQuantity;



	public Long getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Long availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public void deductAmount(Integer entryValue) {
		if (availableQuantity != null) {
			availableQuantity -= entryValue;
		}
	}

	public OamStockItemViewId getOamStockItemViewId() {
		return oamStockItemViewId;
	}

	public void setOamStockItemViewId(OamStockItemViewId oamStockItemViewId) {
		this.oamStockItemViewId = oamStockItemViewId;
	}

}
