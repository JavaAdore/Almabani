package com.almabani.common.entity.schema.admincor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Mohamed_Ibrahim
 */

@Embeddable
public class StateId implements java.io.Serializable {

	private static final long serialVersionUID = -2785763335755744781L;

	@ManyToOne
	@JoinColumn(name = "NUM_COUNTRY", referencedColumnName = "NUM_COUNTRY", nullable = false)
	private Country country;

	@Column(name = "COD_STATE", nullable = false, length = 2)
	private String stateCode;

	public StateId() {
	}

	// public ComStatesId(int numCountry, String codState) {
	// this.numCountry = numCountry;
	// this.codState = codState;
	// }

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StateId))
			return false;
		StateId castOther = (StateId) other;
		if (this.getStateCode() == null || castOther.getStateCode() == null
				|| this.getCountry() == null || castOther.getCountry() == null) {
			return false;    

		}
		
		return (this.getCountry().getId() == castOther.getCountry().getId())
				&& ((this.getStateCode() == castOther.getStateCode()) || (this
						.getStateCode() != null
						&& castOther.getStateCode() != null && this
						.getStateCode().equals(castOther.getStateCode())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCountry().getId().intValue();
		result = 37 * result
				+ (getStateCode() == null ? 0 : this.getStateCode().hashCode());
		return result;
	}

}
