package com.almabani.common.entity.schema.admincor;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * @author Mohamed_Ibrahim
 */

@Embeddable
public class CalendarId implements java.io.Serializable {

	private static final long serialVersionUID = -6562115790593004104L;

	@Column(name = "DAT_CALENDAR", nullable = false, length = 7)
	private Date calendardate;

	@Column(name = "NUM_SEQ_CALENDAR", nullable = false, precision = 4, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ComCalendar_Id_Seq_Gen")
	private Integer calendarSequence;

	public CalendarId() {
	}

	public CalendarId(Date calendardate, Integer calendarSequence) {
		this.calendardate = calendardate;
		this.calendarSequence = calendarSequence;
	}

	public Date getCalendardate() {
		return calendardate;
	}

	public void setCalendardate(Date calendardate) {
		this.calendardate = calendardate;
	}

	public Integer getCalendarSequence() {
		return calendarSequence;
	}

	public void setCalendarSequence(Integer calendarSequence) {
		this.calendarSequence = calendarSequence;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CalendarId))
			return false;
		CalendarId castOther = (CalendarId) other;

		return ((this.getCalendardate() == castOther.getCalendardate()) || (this
				.getCalendardate() != null && castOther.getCalendardate() != null && this
				.getCalendardate().equals(castOther.getCalendardate())))
				&& (this.getCalendarSequence() == castOther.getCalendarSequence());
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCalendardate() == null ? 0 : this.getCalendardate()
						.hashCode());
		result = 37 * result + this.getCalendarSequence();
		return result;
	}

}
