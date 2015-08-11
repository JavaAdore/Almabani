package com.almabani.common.entity.schema.adminoam;

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

import com.almabani.common.entity.AbstractEntity;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINOAM", name = "OAM_QUOTATION_ACTIONS")
@SequenceGenerator(name = "OamQuotationActions_Id_Seq_Gen", sequenceName = "OAM_QUOTATION_ACTIONS_ID_SEQ_GEN", allocationSize = 50, initialValue = 50)
public class OamQuotationAction extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = -6649839838260967977L;
	
	@Id
	@Column(name = "NUM_QUOTATION_ACTION", unique = true, nullable = false, precision = 9, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OamQuotationActions_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "NUM_QUOTATION", referencedColumnName="NUM_QUOTATION", nullable = false)
	private OamQuotation oamQuotation;
	
	@ManyToOne
	@JoinColumn(name = "NUM_TYPE_QUOT_ACTION", referencedColumnName="NUM_TYPE_QUOT_ACTION", nullable = false)
	private OamTypeQuotAction oamTypesQuotActions;
	
	@Column(name = "COD_LOGIN_ACTION", nullable = false, length = 10)
	private String loginActionCode;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_INSERT_ACTION", nullable = false, length = 7)
	private Date insertActionDate;
	
	@Column(name = "COD_LOGIN_MODIFY", nullable = false, length = 10)
	private String modificationLoginCode;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;
	
	@Column(name = "DES_USER_OBSERVATION", length = 300)
	private String userObservationDescription;

	public OamQuotationAction() {
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the oamQuotation
	 */
	public OamQuotation getOamQuotation() {
		return oamQuotation;
	}

	/**
	 * @param oamQuotation the oamQuotation to set
	 */
	public void setOamQuotation(OamQuotation oamQuotation) {
		this.oamQuotation = oamQuotation;
	}

	/**
	 * @return the oamTypesQuotActions
	 */
	public OamTypeQuotAction getOamTypesQuotActions() {
		return oamTypesQuotActions;
	}

	/**
	 * @param oamTypesQuotActions the oamTypesQuotActions to set
	 */
	public void setOamTypesQuotActions(OamTypeQuotAction oamTypesQuotActions) {
		this.oamTypesQuotActions = oamTypesQuotActions;
	}

	/**
	 * @return the loginActionCode
	 */
	public String getLoginActionCode() {
		return loginActionCode;
	}

	/**
	 * @param loginActionCode the loginActionCode to set
	 */
	public void setLoginActionCode(String loginActionCode) {
		this.loginActionCode = loginActionCode;
	}

	/**
	 * @return the insertActionDate
	 */
	public Date getInsertActionDate() {
		return insertActionDate;
	}

	/**
	 * @param insertActionDate the insertActionDate to set
	 */
	public void setInsertActionDate(Date insertActionDate) {
		this.insertActionDate = insertActionDate;
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
	 * @return the userObservationDescription
	 */
	public String getUserObservationDescription() {
		return userObservationDescription;
	}

	/**
	 * @param userObservationDescription the userObservationDescription to set
	 */
	public void setUserObservationDescription(String userObservationDescription) {
		this.userObservationDescription = userObservationDescription;
	}
}
