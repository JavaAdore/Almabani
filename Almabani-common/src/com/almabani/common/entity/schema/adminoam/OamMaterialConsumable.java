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
import com.almabani.common.entity.schema.admincor.Project;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINOAM", name = "OAM_MATERIALS_CONSUMABLES")
@SequenceGenerator(name = "OamMaterialsConsumables_Id_Seq_Gen", sequenceName = "ADMINOAM.OAM_SEQ_NUM_MAT_CONSUMABLE", allocationSize = 1, initialValue = 1)
public class OamMaterialConsumable extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = -2810586222684693304L;

	@Id
	@Column(name = "NUM_MATERIAL_CONSUMABLE", unique = true, nullable = false, precision = 3, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OamMaterialsConsumables_Id_Seq_Gen")
	private Long id;
	
	@Column(name = "DES_MATERIAL_CONSUMABLE", nullable = false, length = 100)
	private String consumableMaterialDescription;
	
	@ManyToOne
	@JoinColumn(name = "NUM_PROJECT", referencedColumnName="NUM_PROJECT", nullable = false)
	private Project project;
	
	@Column(name = "IND_ACTIVE", nullable = false, length = 1)
	private String indActive;
	
	@Column(name = "VAL_MATERIAL_CONSUMABLE", nullable = false, precision = 15)
	private Integer consumableMaterialValue;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;

	public OamMaterialConsumable() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the consumableMaterialDescription
	 */
	public String getConsumableMaterialDescription() {
		return consumableMaterialDescription;
	}

	/**
	 * @param consumableMaterialDescription the consumableMaterialDescription to set
	 */
	public void setConsumableMaterialDescription(
			String consumableMaterialDescription) {
		this.consumableMaterialDescription = consumableMaterialDescription;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
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
	 * @return the consumableMaterialValue
	 */
	public Integer getConsumableMaterialValue() {
		return consumableMaterialValue;
	}

	/**
	 * @param consumableMaterialValue the consumableMaterialValue to set
	 */
	public void setConsumableMaterialValue(Integer consumableMaterialValue) {
		this.consumableMaterialValue = consumableMaterialValue;
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
