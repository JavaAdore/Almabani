package com.almabani.common.entity.schema.adminsec;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.almabani.common.constant.DataAccessConstant;
import com.almabani.common.util.Utils;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema = "ADMINSEC", name = "SEC_APPLICATIONS")
public class SecApplication implements java.io.Serializable {

	private static final long serialVersionUID = -1606184417699823437L;

	@Id
	@Column(name = "COD_APPLICATION", unique = true, nullable = false, length = 8)
	private String codApplication;

	@ManyToOne
	@JoinColumn(name = "NUM_SUB_MODULE", referencedColumnName = "NUM_SUB_MODULE", nullable = false)
	private SecSubModule secSubModule;

	@ManyToOne
	@JoinColumn(name = "NUM_TYPE_APPLICATION", referencedColumnName = "NUM_TYPE_APPLICATION", nullable = false)
	private ApplicationType typesApplication;

	@Column(name = "DES_APPLICATION", nullable = false, length = 50)
	private String applicationDescription;

	@Column(name = "NUM_ORDER_MENU", nullable = false, precision = 2, scale = 0)
	private Integer orderMenuNumber = 1;

	@Column(name = "DES_LABEL_PORTUGUESE", length = 25)
	private String portugueseLabel;

	@Column(name = "DES_LABEL_ENGLISH", length = 25)
	private String englishLabelDescription;

	@Column(name = "DES_LABEL_SPANISH", length = 25)
	private String spanishLabelDescription;

	@Column(name = "IND_ACTIVE", length = 1)
	private String indActive;

	/**
	 * modificationMakerName represent the user name who make the last
	 * modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;

	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;

	@Column(name = "DES_LINK_CODE", length = 100)
	private String linkCodeDescription;

	@Column(name = "ind_display_menu", length = 1)
	private String displayInMenu;

	public SecApplication() {
	}

	public String getCodApplication() {
		return codApplication;
	}

	public void setCodApplication(String codApplication) {
		this.codApplication = codApplication;
	}

	/**
	 * @return the secSubModule
	 */
	public SecSubModule getSecSubModule() {
		return secSubModule;
	}

	/**
	 * @param secSubModule
	 *            the secSubModule to set
	 */
	public void setSecSubModule(SecSubModule secSubModule) {
		this.secSubModule = secSubModule;
	}

	/**
	 * @return the typesApplication
	 */
	public ApplicationType getTypesApplication() {
		return typesApplication;
	}

	/**
	 * @param typesApplication
	 *            the typesApplication to set
	 */
	public void setTypesApplication(ApplicationType typesApplication) {
		this.typesApplication = typesApplication;
	}

	/**
	 * @return the applicationDescription
	 */
	public String getApplicationDescription() {
		return applicationDescription;
	}

	/**
	 * @param applicationDescription
	 *            the applicationDescription to set
	 */
	public void setApplicationDescription(String applicationDescription) {
		this.applicationDescription = applicationDescription;
	}

	/**
	 * @return the orderMenuNumber
	 */
	public Integer getOrderMenuNumber() {
		return orderMenuNumber;
	}

	/**
	 * @param orderMenuNumber
	 *            the orderMenuNumber to set
	 */
	public void setOrderMenuNumber(Integer orderMenuNumber) {
		this.orderMenuNumber = orderMenuNumber;
	}

	/**
	 * @return the portugueseLabel
	 */
	public String getPortugueseLabel() {
		return portugueseLabel;
	}

	/**
	 * @param portugueseLabel
	 *            the portugueseLabel to set
	 */
	public void setPortugueseLabel(String portugueseLabel) {
		this.portugueseLabel = portugueseLabel;
	}

	/**
	 * @return the englishLabelDescription
	 */
	public String getEnglishLabelDescription() {
		return englishLabelDescription;
	}

	/**
	 * @param englishLabelDescription
	 *            the englishLabelDescription to set
	 */
	public void setEnglishLabelDescription(String englishLabelDescription) {
		this.englishLabelDescription = englishLabelDescription;
	}

	/**
	 * @return the spanishLabelDescription
	 */
	public String getSpanishLabelDescription() {
		return spanishLabelDescription;
	}

	/**
	 * @param spanishLabelDescription
	 *            the spanishLabelDescription to set
	 */
	public void setSpanishLabelDescription(String spanishLabelDescription) {
		this.spanishLabelDescription = spanishLabelDescription;
	}

	/**
	 * @return the indActive
	 */
	public String getIndActive() {
		return indActive;
	}

	/**
	 * @param indActive
	 *            the indActive to set
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
	 * @param modificationMakerName
	 *            the modificationMakerName to set
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
	 * @param lastModificationDate
	 *            the lastModificationDate to set
	 */
	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	/**
	 * @return the linkCodeDescription
	 */
	public String getLinkCodeDescription() {
		return linkCodeDescription;
	}

	/**
	 * @param linkCodeDescription
	 *            the linkCodeDescription to set
	 */
	public void setLinkCodeDescription(String linkCodeDescription) {
		this.linkCodeDescription = linkCodeDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codApplication == null) ? 0 : codApplication.hashCode());
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
		SecApplication other = (SecApplication) obj;
		if (codApplication == null) {
			if (other.codApplication != null)
				return false;
		} else if (!codApplication.equals(other.codApplication))
			return false;
		return true;
	}

	public String getDisplayInMenu() {
		return displayInMenu;
	}

	public void setDisplayInMenu(String displayInMenu) {
		this.displayInMenu = displayInMenu;
	}

}
