package com.almabani.common.entity.schema.adminwkf;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.almabani.common.entity.AbstractEntity;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINWKF", name = "WOK_PROFILES_ACTIONS", uniqueConstraints = @UniqueConstraint(columnNames = {
		"NUM_TYPE_ACTION", "NUM_TYPE_PROFILE", "DAT_BEGIN_VALIDITY" }))
@SequenceGenerator(name = "WokProfilesActions_Id_Seq_Gen", sequenceName = "ADMINWKF.WOK_SEQ_NUM_PROFILE_ACTION", allocationSize = 1, initialValue = 1)
public class WokProfileActions extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = -4276068268456651666L;

	@Id
	@Column(name = "NUM_PROFILE_ACTION", unique = true, nullable = false, precision = 5, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WokProfilesActions_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "NUM_PROFILE_ACTION_ANTECESSOR", referencedColumnName="NUM_PROFILE_ACTION", nullable = false)
	private WokProfileActions profileActions;
	
	@ManyToOne
	@JoinColumn(name = "NUM_TYPE_PROFILE", referencedColumnName="NUM_TYPE_PROFILE", nullable = false)
	private WokTypeProfiles typeProfiles;
	
	@ManyToOne
	@JoinColumn(name = "NUM_TYPE_ACTION", referencedColumnName="NUM_TYPE_ACTION", nullable = false)
	private WokTypeActions typeActions;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_BEGIN_VALIDITY", nullable = false, length = 7)
	private Date validityBeginDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_END_VALIDITY", length = 7)
	private Date validityEndDate;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;
	
	@Column(name = "IND_REQUIRE_JUSTIFY", nullable = false, length = 1)
	private String indRequireJustify;

	public WokProfileActions() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the profileActions
	 */
	public WokProfileActions getProfileActions() {
		return profileActions;
	}

	/**
	 * @param profileActions the profileActions to set
	 */
	public void setProfileActions(WokProfileActions profileActions) {
		this.profileActions = profileActions;
	}

	/**
	 * @return the typeProfiles
	 */
	public WokTypeProfiles getTypeProfiles() {
		return typeProfiles;
	}

	/**
	 * @param typeProfiles the typeProfiles to set
	 */
	public void setTypeProfiles(WokTypeProfiles typeProfiles) {
		this.typeProfiles = typeProfiles;
	}

	/**
	 * @return the typeActions
	 */
	public WokTypeActions getTypeActions() {
		return typeActions;
	}

	/**
	 * @param typeActions the typeActions to set
	 */
	public void setTypeActions(WokTypeActions typeActions) {
		this.typeActions = typeActions;
	}

	/**
	 * @return the validityBeginDate
	 */
	public Date getValidityBeginDate() {
		return validityBeginDate;
	}

	/**
	 * @param validityBeginDate the validityBeginDate to set
	 */
	public void setValidityBeginDate(Date validityBeginDate) {
		this.validityBeginDate = validityBeginDate;
	}

	/**
	 * @return the validityEndDate
	 */
	public Date getValidityEndDate() {
		return validityEndDate;
	}

	/**
	 * @param validityEndDate the validityEndDate to set
	 */
	public void setValidityEndDate(Date validityEndDate) {
		this.validityEndDate = validityEndDate;
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
	 * @return the indRequireJustify
	 */
	public String getIndRequireJustify() {
		return indRequireJustify;
	}

	/**
	 * @param indRequireJustify the indRequireJustify to set
	 */
	public void setIndRequireJustify(String indRequireJustify) {
		this.indRequireJustify = indRequireJustify;
	}
	
}
