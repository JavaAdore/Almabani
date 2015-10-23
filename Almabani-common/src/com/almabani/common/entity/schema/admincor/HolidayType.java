package com.almabani.common.entity.schema.admincor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINCOR" ,name = "COM_TYPES_HOLIDAYS")
public class HolidayType implements Serializable {

	private static final long serialVersionUID = 8368249216389004695L;
	
	@Id
	@Column(name = "COD_TYPE_EVENT", unique = true, nullable = false, length = 1)
	private String eventTypeCode;
	
	@Column(name = "DES_TYPE_EVENT", nullable = false, length = 80)
	private String eventTypeDescription;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Column(name = "IND_OPENING_ESTABLISHMENT", nullable = false, length = 1)
	private String indOpeningEstablishment;
	

	public HolidayType() {
	}

	public String getEventTypeCode() {
		return eventTypeCode;
	}

	public void setEventTypeCode(String eventTypeCode) {
		this.eventTypeCode = eventTypeCode;
	}

	public String getEventTypeDescription() {
		return eventTypeDescription;
	}

	public void setEventTypeDescription(String eventTypeDescription) {
		this.eventTypeDescription = eventTypeDescription;
	}

	public Date getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	public String getModificationMakerName() {
		return modificationMakerName;
	}

	public void setModificationMakerName(String modificationMakerName) {
		this.modificationMakerName = modificationMakerName;
	}

	public String getIndOpeningEstablishment() {
		return indOpeningEstablishment;
	}

	public void setIndOpeningEstablishment(String indOpeningEstablishment) {
		this.indOpeningEstablishment = indOpeningEstablishment;
	}
	
}
