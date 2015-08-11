package com.almabani.common.entity.schema.adminwkf;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Mohamed_Ibrahim
 */

@Embeddable
public class WokNextActionsId implements java.io.Serializable {
	
	private static final long serialVersionUID = 6446201960528457873L;
	
	@ManyToOne
	@JoinColumn(name = "NUM_TYPE_ACTION", referencedColumnName="NUM_TYPE_ACTION", nullable = false)
	private WokTypeActions typeAction;
	
	@ManyToOne
	@JoinColumn(name = "NUM_TYPE_ACTION_NEXT_FIRST", referencedColumnName="NUM_TYPE_ACTION", nullable = false)
	private WokTypeActions typeActionNextFirst;

	public WokNextActionsId() {
	}

//	public WokNextActionsId(Integer numTypeAction, Integer numTypeActionNextFirst) {
//		this.numTypeAction = numTypeAction;
//		this.numTypeActionNextFirst = numTypeActionNextFirst;
//	}

	public WokTypeActions getTypeAction() {
		return typeAction;
	}

	public void setTypeAction(WokTypeActions typeAction) {
		this.typeAction = typeAction;
	}

	public WokTypeActions getTypeActionNextFirst() {
		return typeActionNextFirst;
	}

	public void setTypeActionNextFirst(WokTypeActions typeActionNextFirst) {
		this.typeActionNextFirst = typeActionNextFirst;
	}
	
	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof WokNextActionsId))
			return false;
		WokNextActionsId castOther = (WokNextActionsId) other;

		return (this.getTypeAction() == castOther.getTypeAction())
				&& (this.getTypeActionNextFirst().getId() == castOther
						.getTypeActionNextFirst().getId());
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getTypeAction().getId().intValue();
		result = 37 * result + this.getTypeActionNextFirst().getId().intValue();
		return result;
	}

}
