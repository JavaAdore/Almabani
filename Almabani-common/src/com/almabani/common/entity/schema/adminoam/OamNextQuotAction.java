package com.almabani.common.entity.schema.adminoam;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(name = "OAM_NEXT_QUOT_ACTIONS")
public class OamNextQuotAction implements java.io.Serializable {
	
	private static final long serialVersionUID = -7618315952561803907L;
	
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "numTypeQuotAction", column = @Column(name = "NUM_TYPE_QUOT_ACTION", nullable = false, precision = 3, scale = 0)),
			@AttributeOverride(name = "numTypeActionNextFirst", column = @Column(name = "NUM_TYPE_ACTION_NEXT_FIRST", nullable = false, precision = 3, scale = 0)) })
	private OamNextQuotActionId oamNextQuotActionId;
	
	@ManyToOne
	@JoinColumn(name = "NUM_TYPE_ACTION_NEXT_SECOND", referencedColumnName="NUM_TYPE_QUOT_ACTION", nullable = false)
	private OamQuotationActionType oamTypeQuotActionNextSecond;
	
	@Column(name = "DES_NEXT_QUOT_ACTION", nullable = false, length = 20)
	private String nextQuotActionDescription;
	
	@Column(name = "IND_REQUEST_USER", nullable = false, length = 1)
	private String indRequestUser;
	
	@Column(name = "IND_ACTIVE", nullable = false, length = 1)
	private String indActive;
	
	@Column(name = "COD_LOGIN_MODIFY", nullable = false, length = 10)
	private String modificationLoginCode;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;
	
	@Column(name = "IND_CONCLUDE", nullable = false, length = 1)
	private String indConclude;

	public OamNextQuotAction() {
	}

	/**
	 * @return the oamNextQuotActionId
	 */
	public OamNextQuotActionId getOamNextQuotActionId() {
		return oamNextQuotActionId;
	}

	/**
	 * @param oamNextQuotActionId the oamNextQuotActionId to set
	 */
	public void setOamNextQuotActionId(OamNextQuotActionId oamNextQuotActionId) {
		this.oamNextQuotActionId = oamNextQuotActionId;
	}

	/**
	 * @return the oamTypeQuotActionNextSecond
	 */
	public OamQuotationActionType getOamTypeQuotActionNextSecond() {
		return oamTypeQuotActionNextSecond;
	}

	/**
	 * @param oamTypeQuotActionNextSecond the oamTypeQuotActionNextSecond to set
	 */
	public void setOamTypeQuotActionNextSecond(
			OamQuotationActionType oamTypeQuotActionNextSecond) {
		this.oamTypeQuotActionNextSecond = oamTypeQuotActionNextSecond;
	}

	/**
	 * @return the nextQuotActionDescription
	 */
	public String getNextQuotActionDescription() {
		return nextQuotActionDescription;
	}

	/**
	 * @param nextQuotActionDescription the nextQuotActionDescription to set
	 */
	public void setNextQuotActionDescription(String nextQuotActionDescription) {
		this.nextQuotActionDescription = nextQuotActionDescription;
	}

	/**
	 * @return the indRequestUser
	 */
	public String getIndRequestUser() {
		return indRequestUser;
	}

	/**
	 * @param indRequestUser the indRequestUser to set
	 */
	public void setIndRequestUser(String indRequestUser) {
		this.indRequestUser = indRequestUser;
	}

	/**
	 * @return the indActive
	 */
	public String getIndActive() {
		return indActive;
	}

	/**
	 * @param indActive the indActive to set
	 */
	public void setIndActive(String indActive) {
		this.indActive = indActive;
	}

	/**
	 * @return the modificationLoginCode
	 */
	public String getModificationLoginCode() {
		return modificationLoginCode;
	}

	/**
	 * @param modificationLoginCode the modificationLoginCode to set
	 */
	public void setModificationLoginCode(String modificationLoginCode) {
		this.modificationLoginCode = modificationLoginCode;
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
	 * @return the indConclude
	 */
	public String getIndConclude() {
		return indConclude;
	}

	/**
	 * @param indConclude the indConclude to set
	 */
	public void setIndConclude(String indConclude) {
		this.indConclude = indConclude;
	}
	
}
