package com.almabani.common.entity.schema.admincor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

/**
 * @author Mohamed_Ibrahim
 */

@Embeddable
public class MunicipalitiesId implements java.io.Serializable {

	private static final long serialVersionUID = -1153393776303404943L;

	@Column(name = "NUM_MUNICIPALITY", nullable = false, precision = 7, scale = 0)
	private Long municipalityNumber;

//	@ManyToOne
//	@JoinColumn(name = "NUM_COUNTRY", referencedColumnName = "NUM_COUNTRY", nullable = false)
//	private ComCountry country;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "NUM_COUNTRY", referencedColumnName = "NUM_COUNTRY", nullable = false),
			@JoinColumn(name = "COD_STATE", referencedColumnName = "COD_STATE", nullable = false) })
	private State state;

	public MunicipalitiesId() {
	}

	// public ComMunicipalitiesId(int numMunicipality, int numCountry,
	// String codState) {
	// this.numMunicipality = numMunicipality;
	// this.numCountry = numCountry;
	// this.codState = codState;
	// }

	public Long getMunicipalityNumber() {
		return municipalityNumber;
	}

	public void setMunicipalityNumber(Long municipalityNumber) {
		this.municipalityNumber = municipalityNumber;
	}

//	public ComCountry getCountry() {
//		return country;
//	}
//
//	public void setCountry(ComCountry country) {
//		this.country = country;
//	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getMunicipalityNumber().intValue();
		result = 37 * result + this.getState().getStateId().getCountry().getId().intValue();
		result = 37
				* result
				+ (getState().getStateId().getStateCode() == null ? 0 : this
						.getState().getStateId().getStateCode().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MunicipalitiesId))
			return false;
		MunicipalitiesId castOther = (MunicipalitiesId) other;

		return (this.getMunicipalityNumber() == castOther.getMunicipalityNumber())
				&& (this.getState().getStateId() == castOther.getState().getStateId())
				&& ((this.getState().getStateId().getStateCode() == castOther
						.getState().getStateId().getStateCode()) || (this
						.getState().getStateId().getStateCode() != null
						&& castOther.getState().getStateId().getStateCode() != null && this
						.getState().getStateId().getStateCode()
						.equals(castOther.getState().getStateId().getStateCode())));
	}
}
