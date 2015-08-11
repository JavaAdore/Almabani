package com.almabani.common.entity.schema.adminwkf;

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
@Table(schema="ADMINWKF", name = "WOK_NEXT_ACTIONS")
public class WokNextActions implements java.io.Serializable {
	
	private static final long serialVersionUID = 4748394335812017765L;

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "numTypeAction", column = @Column(name = "NUM_TYPE_ACTION", nullable = false, precision = 3, scale = 0)),
			@AttributeOverride(name = "numTypeActionNextFirst", column = @Column(name = "NUM_TYPE_ACTION_NEXT_FIRST", nullable = false, precision = 3, scale = 0)) })
	private WokNextActionsId id;
	
	@ManyToOne
	@JoinColumn(name = "NUM_TYPE_ACTION_NEXT_SECOND", referencedColumnName="NUM_TYPE_ACTION", nullable = false)
	private WokTypeActions typeActionNextSecond;
	
	@Column(name = "DES_NEXT_ACTION", nullable = false, length = 20)
	private String nextActionDescription;
	
	@Column(name = "IND_REQUEST_USER", nullable = false, length = 1)
	private String indRequestUser;
	
	@Column(name = "IND_ACTIVE", nullable = false, length = 1)
	private String indActive;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;
	
	@Column(name = "IND_CONCLUDE", nullable = false, length = 1)
	private String indConclude;

	public WokNextActions() {
	}

	/**
	 * @return the id
	 */
	public WokNextActionsId getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(WokNextActionsId id) {
		this.id = id;
	}

	/**
	 * @return the typeActionNextSecond
	 */
	public WokTypeActions getTypeActionNextSecond() {
		return typeActionNextSecond;
	}

	/**
	 * @param typeActionNextSecond the typeActionNextSecond to set
	 */
	public void setTypeActionNextSecond(WokTypeActions typeActionNextSecond) {
		this.typeActionNextSecond = typeActionNextSecond;
	}

	/**
	 * @return the nextActionDescription
	 */
	public String getNextActionDescription() {
		return nextActionDescription;
	}

	/**
	 * @param nextActionDescription the nextActionDescription to set
	 */
	public void setNextActionDescription(String nextActionDescription) {
		this.nextActionDescription = nextActionDescription;
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
