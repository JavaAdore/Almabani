package com.almabani.common.entity.schema.adminsec;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Mohamed_Ibrahim
 */

@Embeddable
public class SecProcessingApplicationsId implements java.io.Serializable {
	
	private static final long serialVersionUID = 869083444010963765L;
	
	@Column(name = "DAT_PROCESSING", nullable = false, length = 7)
	private Date processingDate;
	
	@ManyToOne
	@JoinColumn(name = "COD_APPLICATION", referencedColumnName="COD_APPLICATION", nullable = false)
	private SecApplication application;

	public SecProcessingApplicationsId() {
	}

	public Date getProcessingDate() {
		return processingDate;
	}

	public void setProcessingDate(Date processingDate) {
		this.processingDate = processingDate;
	}

	public SecApplication getApplication() {
		return application;
	}

	public void setApplication(SecApplication application) {
		this.application = application;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SecProcessingApplicationsId))
			return false;
		SecProcessingApplicationsId castOther = (SecProcessingApplicationsId) other;

		return ((this.getProcessingDate() == castOther.getProcessingDate()) || (this
				.getProcessingDate() != null
				&& castOther.getProcessingDate() != null && this
				.getProcessingDate().equals(castOther.getProcessingDate())))
				&& ((this.getApplication().getCodApplication() == castOther.getApplication().getCodApplication()) || (this
						.getApplication().getCodApplication() != null
						&& castOther.getApplication().getCodApplication() != null && this
						.getApplication().getCodApplication().equals(
								castOther.getApplication().getCodApplication())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getProcessingDate() == null ? 0 : this.getProcessingDate()
						.hashCode());
		result = 37
				* result
				+ (getApplication().getCodApplication() == null ? 0 : this.getApplication().getCodApplication()
						.hashCode());
		return result;
	}

}
