package com.almabani.common.entity.schema.admincor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Mohamed_Ibrahim
 */

@Embeddable
public class ZipCodeId implements java.io.Serializable {
	
	private static final long serialVersionUID = 3011831602445869130L;
	
	@Column(name = "NUM_ZIP_CODE", nullable = false, precision = 8, scale = 0)
	private Integer zipCodeNumber;
	
	@Column(name = "NUM_SEQ_ZIP_CODE", nullable = false, precision = 6, scale = 0)
	private Integer ZipCodeSeqNumber;

	public ZipCodeId() {
	}

	public ZipCodeId(Integer zipCodeNumber, Integer ZipCodeSeqNumber) {
		this.zipCodeNumber = zipCodeNumber;
		this.ZipCodeSeqNumber = ZipCodeSeqNumber;
	}

	public Integer getZipCodeNumber() {
		return zipCodeNumber;
	}

	public void setZipCodeNumber(Integer zipCodeNumber) {
		this.zipCodeNumber = zipCodeNumber;
	}

	public Integer getZipCodeSeqNumber() {
		return ZipCodeSeqNumber;
	}

	public void setZipCodeSeqNumber(Integer zipCodeSeqNumber) {
		ZipCodeSeqNumber = zipCodeSeqNumber;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ZipCodeId))
			return false;
		ZipCodeId castOther = (ZipCodeId) other;

		return (this.getZipCodeNumber() == castOther.getZipCodeNumber())
				&& (this.getZipCodeSeqNumber() == castOther.getZipCodeSeqNumber());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getZipCodeNumber();
		result = 37 * result + this.getZipCodeSeqNumber();
		return result;
	}

}
