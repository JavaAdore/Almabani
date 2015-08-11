package com.almabani.common.entity.schema.admincor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINCOR", name = "COM_STATES")

public class State  implements Serializable {
       
	private static final long serialVersionUID = -1658552753618443682L;

	@EmbeddedId    
	private StateId stateId;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DAT_LAST_MODIFY", nullable = false)
    private Date lastModificationDate;
    
    @Column(name = "NAM_STATE", nullable = false, length = 80)
    private String stateName;
    
    /**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
    
    @Column(name = "NUM_CONTROL_DOCUMENT")
    private Long controlDocument;   

    public State() {
    }
    
	/**
	 * @return the stateId
	 */
	public StateId getStateId() {
		return stateId;
	}

	/**
	 * @param stateId the stateId to set
	 */
	public void setStateId(StateId stateId) {
		this.stateId = stateId;
	}

	public Date getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	public String getModificationMakerName() {
		return modificationMakerName;
	}

	public void setModificationMakerName(String modificationMakerName) {
		this.modificationMakerName = modificationMakerName;
	}

	public Long getControlDocument() {
		return controlDocument;
	}

	public void setControlDocument(Long controlDocument) {
		this.controlDocument = controlDocument;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stateId == null) ? 0 : stateId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if (stateId == null) {
			if (other.stateId != null)
				return false;
		} else if (!stateId.equals(other.stateId))
			return false;
		return true;
	}
  
	   
}
