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
import com.almabani.common.entity.schema.admincor.DepartmentSection;

/**
 * @author Mohamed_Ibrahim
 */

@Entity
@Table(schema="ADMINOAM", name = "OAM_ITEMS_CATEGORY")
@SequenceGenerator(name = "OamItemsCategory_Id_Seq_Gen", sequenceName = "OAM_ITEMS_CATEGORY_ID_SEQ_GEN", allocationSize = 50, initialValue = 50)
public class OamItemCategory extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 7915713742837390252L;
	
	@Id
	@Column(name = "NUM_ITEM_CATEGORY", unique = true, nullable = false, precision = 5, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OamItemsCategory_Id_Seq_Gen")
	private Long id;
	
	@Column(name = "NAM_ITEM_CATEGORY", nullable = false, length = 40)
	private String categoryItemName;
	
	@ManyToOne
	@JoinColumn(name = "NUM_DEP_SECTION", referencedColumnName="NUM_DEP_SECTION", nullable = false)
	private DepartmentSection comDepartmentSection;
	
	@Column(name = "IND_ACTIVE", length = 1)
	private String indActive;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;

	public OamItemCategory() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryItemName() {
		return categoryItemName;
	}

	public void setCategoryItemName(String categoryItemName) {
		this.categoryItemName = categoryItemName;
	}

	public DepartmentSection getComDepartmentSection() {
		return comDepartmentSection;
	}

	public void setComDepartmentSection(DepartmentSection comDepartmentSection) {
		this.comDepartmentSection = comDepartmentSection;
	}

	public String getIndActive() {
		return indActive;
	}

	public void setIndActive(String indActive) {
		this.indActive = indActive;
	}

	public Date getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	public String getModificationMakerName() {
		return modificationMakerName;
	}

	public void setModificationMakerName(String modificationMakerName) {
		this.modificationMakerName = modificationMakerName;
	}
	
}
