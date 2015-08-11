package com.almabani.common.entity.schema.adminsec;

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
@Table(schema="ADMINSEC", name = "SEC_MODULES", uniqueConstraints = @UniqueConstraint(columnNames = {
		"COD_MODULE", "NUM_SYSTEM" }))
@SequenceGenerator(name = "SecModules_Id_Seq_Gen", sequenceName = "SEC_MODULES_ID_SEQ_GEN", allocationSize = 50, initialValue = 50)
public class SecModule extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 3631959832092882735L;

	@Id
	@Column(name = "NUM_MODULE", unique = true, nullable = false, precision = 5, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SecModules_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "NUM_SYSTEM", referencedColumnName="NUM_SYSTEM", nullable = false)
	private SecSystem system;
	
	@Column(name = "COD_MODULE", nullable = false, length = 3)
	private String moduleCode;
	
	@Column(name = "DES_MODULE", nullable = false, length = 50)
	private String moduleDescription;
	
	@Column(name = "NUM_ORDER_MENU", nullable = false, precision = 2, scale = 0)
	private Integer orderMenuNumber = 1;
	
	@Column(name = "DES_LABEL_PORTUGUESE", length = 25)
	private String portugueseLabelDescription;
	
	@Column(name = "DES_LABEL_ENGLISH", length = 25)
	private String englishLabelDescription;
	
	@Column(name = "DES_LABEL_SPANISH", length = 25)
	private String spanishLabelDescription;
	
	@Column(name = "IND_ACTIVE", length = 1)
	private String indActive;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;

	public SecModule() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the system
	 */
	public SecSystem getSystem() {
		return system;
	}

	/**
	 * @param system the system to set
	 */
	public void setSystem(SecSystem system) {
		this.system = system;
	}

	/**
	 * @return the moduleCode
	 */
	public String getModuleCode() {
		return moduleCode;
	}

	/**
	 * @param moduleCode the moduleCode to set
	 */
	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	/**
	 * @return the moduleDescription
	 */
	public String getModuleDescription() {
		return moduleDescription;
	}

	/**
	 * @param moduleDescription the moduleDescription to set
	 */
	public void setModuleDescription(String moduleDescription) {
		this.moduleDescription = moduleDescription;
	}

	/**
	 * @return the orderMenuNumber
	 */
	public Integer getOrderMenuNumber() {
		return orderMenuNumber;
	}

	/**
	 * @param orderMenuNumber the orderMenuNumber to set
	 */
	public void setOrderMenuNumber(Integer orderMenuNumber) {
		this.orderMenuNumber = orderMenuNumber;
	}

	/**
	 * @return the portugueseLabelDescription
	 */
	public String getPortugueseLabelDescription() {
		return portugueseLabelDescription;
	}

	/**
	 * @param portugueseLabelDescription the portugueseLabelDescription to set
	 */
	public void setPortugueseLabelDescription(String portugueseLabelDescription) {
		this.portugueseLabelDescription = portugueseLabelDescription;
	}

	/**
	 * @return the englishLabelDescription
	 */
	public String getEnglishLabelDescription() {
		return englishLabelDescription;
	}

	/**
	 * @param englishLabelDescription the englishLabelDescription to set
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
	 * @param spanishLabelDescription the spanishLabelDescription to set
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
	
}
