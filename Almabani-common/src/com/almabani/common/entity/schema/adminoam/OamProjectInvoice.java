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
@Table(schema="ADMINOAM", name = "OAM_PROJECT_INVOICES")
@SequenceGenerator(name = "OamProjectInvoices_Id_Seq_Gen", sequenceName = "OAM_PROJECT_INVOICES_ID_SEQ_GEN", allocationSize = 1, initialValue = 1)
public class OamProjectInvoice extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = -1507770244616179715L;
	
	@Id
	@Column(name = "NUM_PROJECT_INVOICE", unique = true, nullable = false, precision = 6, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OamProjectInvoices_Id_Seq_Gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "NUM_PROJECT", referencedColumnName="NUM_PROJECT", nullable = false)
	private Project project;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_MONTH_INVOICE", nullable = false, length = 7)
	private Date invoiceMonthdate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_BEGIN_ACRUAL", nullable = false, length = 7)
	private Date acrualBeginDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_END_ACRUAL", nullable = false, length = 7)
	private Date acrualEndDate;
	
	@Column(name = "QUT_WORKING_DAYS", nullable = false, precision = 2, scale = 0)
	private byte workingDaysQuotation;
	
	/**
	 * modificationMakerName represent the user name who make the last modification
	 */
	@Column(name = "NAM_USER_MODIFY", nullable = false, length = 10)
	private String modificationMakerName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DAT_LAST_MODIFY", nullable = false, length = 7)
	private Date lastModificationDate;
	
	@Column(name = "IND_STATUS_INVOICE", nullable = false, length = 1)
	private String indStatusInvoice;

	public OamProjectInvoice() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	 * @return the invoiceMonthdate
	 */
	public Date getInvoiceMonthdate() {
		return invoiceMonthdate;
	}

	/**
	 * @param invoiceMonthdate the invoiceMonthdate to set
	 */
	public void setInvoiceMonthdate(Date invoiceMonthdate) {
		this.invoiceMonthdate = invoiceMonthdate;
	}

	/**
	 * @return the acrualBeginDate
	 */
	public Date getAcrualBeginDate() {
		return acrualBeginDate;
	}

	/**
	 * @param acrualBeginDate the acrualBeginDate to set
	 */
	public void setAcrualBeginDate(Date acrualBeginDate) {
		this.acrualBeginDate = acrualBeginDate;
	}

	/**
	 * @return the acrualEndDate
	 */
	public Date getAcrualEndDate() {
		return acrualEndDate;
	}

	/**
	 * @param acrualEndDate the acrualEndDate to set
	 */
	public void setAcrualEndDate(Date acrualEndDate) {
		this.acrualEndDate = acrualEndDate;
	}

	/**
	 * @return the workingDaysQuotation
	 */
	public byte getWorkingDaysQuotation() {
		return workingDaysQuotation;
	}

	/**
	 * @param workingDaysQuotation the workingDaysQuotation to set
	 */
	public void setWorkingDaysQuotation(byte workingDaysQuotation) {
		this.workingDaysQuotation = workingDaysQuotation;
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
	 * @return the indStatusInvoice
	 */
	public String getIndStatusInvoice() {
		return indStatusInvoice;
	}

	/**
	 * @param indStatusInvoice the indStatusInvoice to set
	 */
	public void setIndStatusInvoice(String indStatusInvoice) {
		this.indStatusInvoice = indStatusInvoice;
	}
	
}
