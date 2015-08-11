package com.almabani.common.entity.schema.admincor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINCOR" ,name = "COM_CALENDAR")
public class Calendar implements Serializable {

	private static final long serialVersionUID = -495300974659881872L;
	
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "datCalendar", column = @Column(name = "DAT_CALENDAR", nullable = false, length = 7)),
			@AttributeOverride(name = "numSeqCalendar", column = @Column(name = "NUM_SEQ_CALENDAR", nullable = false, precision = 4, scale = 0)) })
	private CalendarId calendarId;
	
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "NUM_MUNICIPALITY", referencedColumnName = "NUM_MUNICIPALITY"),
			@JoinColumn(name = "NUM_COUNTRY", referencedColumnName = "NUM_COUNTRY"),
			@JoinColumn(name = "COD_STATE", referencedColumnName = "COD_STATE") })
	private Municipalities municipalities;
	
	@ManyToOne
	@JoinColumn(name = "COD_TYPE_EVENT", referencedColumnName="COD_TYPE_EVENT", nullable = false)
	private HolidayType holidayType;
	
	@ManyToOne
	@JoinColumn(name = "NUM_ESTABLISHMENT", referencedColumnName="NUM_ESTABLISHMENT", nullable = false)
	private Establishment establishment;
	
	@Column(name = "DES_EVENT", nullable = false, length = 40)
	private String eventDescription;
	
	@Column(name = "IND_TYPE_CALENDAR", nullable = false, length = 1)
	private String indTypeCalendar;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	
	public Calendar() {
	}

	/**
	 * @return the calendarId
	 */
	public CalendarId getCalendarId() {
		return calendarId;
	}


	/**
	 * @param calendarId the calendarId to set
	 */
	public void setCalendarId(CalendarId calendarId) {
		this.calendarId = calendarId;
	}


	/**
	 * @return the municipalities
	 */
	public Municipalities getMunicipalities() {
		return municipalities;
	}

	/**
	 * @param municipalities the municipalities to set
	 */
	public void setMunicipalities(Municipalities municipalities) {
		this.municipalities = municipalities;
	}

	/**
	 * @return the holidayType
	 */
	public HolidayType getHolidayType() {
		return holidayType;
	}

	/**
	 * @param holidayType the holidayType to set
	 */
	public void setHolidayType(HolidayType holidayType) {
		this.holidayType = holidayType;
	}

	/**
	 * @return the establishment
	 */
	public Establishment getEstablishment() {
		return establishment;
	}

	/**
	 * @param establishment the establishment to set
	 */
	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}

	/**
	 * @return the eventDescription
	 */
	public String getEventDescription() {
		return eventDescription;
	}

	/**
	 * @param eventDescription the eventDescription to set
	 */
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	/**
	 * @return the indTypeCalendar
	 */
	public String getIndTypeCalendar() {
		return indTypeCalendar;
	}

	/**
	 * @param indTypeCalendar the indTypeCalendar to set
	 */
	public void setIndTypeCalendar(String indTypeCalendar) {
		this.indTypeCalendar = indTypeCalendar;
	}

	/**
	 * @return the lastModificationDate
	 */
	public Date getLastModificationDate() {
		return lastModificationDate;
	}

	/**
	 * @param lastModificationDate the lastModificationDate to set
	 */
	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	/**
	 * @return the modificationMakerName
	 */
	public String getModificationMakerName() {
		return modificationMakerName;
	}

	/**
	 * @param modificationMakerName the modificationMakerName to set
	 */
	public void setModificationMakerName(String modificationMakerName) {
		this.modificationMakerName = modificationMakerName;
	}
}
