package com.almabani.common.entity.schema.adminoam;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Mohamed_Ibrahim
 */

@Embeddable
public class OamNextQuotActionId implements java.io.Serializable {
	
	private static final long serialVersionUID = -154420592604500799L;

	@ManyToOne
	@JoinColumn(name = "NUM_TYPE_QUOT_ACTION", referencedColumnName="NUM_TYPE_QUOT_ACTION", nullable = false)
	private OamQuotationActionType oamTypeQuotAction;
	
	@ManyToOne
	@JoinColumn(name = "NUM_TYPE_ACTION_NEXT_FIRST", referencedColumnName="NUM_TYPE_QUOT_ACTION", nullable = false)
	private OamQuotationActionType oamTypeQuotActionNextFirst;

	public OamNextQuotActionId() {
	}

	/**
	 * @return the oamTypeQuotAction
	 */
	public OamQuotationActionType getOamTypeQuotAction() {
		return oamTypeQuotAction;
	}

	/**
	 * @param oamTypeQuotAction the oamTypeQuotAction to set
	 */
	public void setOamTypeQuotAction(OamQuotationActionType oamTypeQuotAction) {
		this.oamTypeQuotAction = oamTypeQuotAction;
	}

	/**
	 * @return the oamTypeQuotActionNextFirst
	 */
	public OamQuotationActionType getOamTypeQuotActionNextFirst() {
		return oamTypeQuotActionNextFirst;
	}

	/**
	 * @param oamTypeQuotActionNextFirst the oamTypeQuotActionNextFirst to set
	 */
	public void setOamTypeQuotActionNextFirst(
			OamQuotationActionType oamTypeQuotActionNextFirst) {
		this.oamTypeQuotActionNextFirst = oamTypeQuotActionNextFirst;
	}


	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OamNextQuotActionId))
			return false;
		OamNextQuotActionId castOther = (OamNextQuotActionId) other;

		return (this.getOamTypeQuotAction().getId() == castOther.getOamTypeQuotAction().getId())
				&& (this.getOamTypeQuotActionNextFirst().getId() == castOther
						.getOamTypeQuotActionNextFirst().getId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getOamTypeQuotAction().getId().intValue();
		result = 37 * result + this.getOamTypeQuotActionNextFirst().getId().intValue();
		return result;
	}

}
