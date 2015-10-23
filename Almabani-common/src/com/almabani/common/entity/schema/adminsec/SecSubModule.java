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

import com.almabani.common.entity.AbstractEntity;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINSEC", name = "SEC_SUB_MODULES")
@SequenceGenerator(name = "SecSubModules_Id_Seq_Gen", sequenceName = "ADMINSEC.SEC_SEQ_NUM_SUB_MODULE", allocationSize = 1, initialValue = 1)
public class SecSubModule extends AbstractEntity implements Serializable{
	
	private static final long serialVersionUID = -519805299603681093L;

	@Id
	@Column(name = "NUM_SUB_MODULE", unique = true, nullable = false, precision = 5, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SecSubModules_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "NUM_MODULE", referencedColumnName="NUM_MODULE", nullable = false)
	private SecModule module;
	
	@Column(name = "DES_SUB_MODULE", nullable = false, length = 50)
	private String subModuleDescription;
	
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
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;

	public SecSubModule() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the module
	 */
	public SecModule getModule() {
		return module;
	}

	/**
	 * @param module the module to set
	 */
	public void setModule(SecModule module) {
		this.module = module;
	}

	/**
	 * @return the subModuleDescription
	 */
	public String getSubModuleDescription() {
		return subModuleDescription;
	}

	/**
	 * @param subModuleDescription the subModuleDescription to set
	 */
	public void setSubModuleDescription(String subModuleDescription) {
		this.subModuleDescription = subModuleDescription;
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
