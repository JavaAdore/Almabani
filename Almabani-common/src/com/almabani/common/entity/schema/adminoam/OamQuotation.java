package com.almabani.common.entity.schema.adminoam;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.almabani.common.annotataion.Bundle;
import com.almabani.common.dto.FileHolder;
import com.almabani.common.entity.AbstractEntity;
import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.common.entity.schema.admincor.Project;
import com.almabani.common.entity.schema.adminsec.SecSystem;
import com.almabani.common.entity.schema.adminwkf.WokDemand;

@Entity
@Table(schema="ADMINOAM", name = "OAM_QUOTATIONS")
@SequenceGenerator(name = "OamQuotations_Id_Seq_Gen", sequenceName = "ADMINOAM.OAM_SEQ_NUM_QUOTATION", allocationSize = 1, initialValue = 1)
public class OamQuotation extends AbstractEntity implements 
		Serializable {
	  
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NUM_QUOTATION", unique = true, nullable = false, precision = 6, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OamQuotations_Id_Seq_Gen")
	@Bundle(key="ALMABANI_GENERAL_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "NUM_DEPARTMENT", referencedColumnName="NUM_DEPARTMENT", nullable = false)
	@Bundle(key="ALMABANI_GENERAL_DEPARTMENT")
	private Department department;
	
	@Column(name = "IND_TYPE_QUOTATION", nullable = false, length = 1)
	@Bundle(key="ALMABANI_GENERAL_STATUS")
	private String indTypeQuotation;
	
	
	@Column(name = "DES_QUOTATION", nullable = false, length = 80)
	@Bundle(key="ALMABANI_GENERAL_DESCRIPTION")
	private String quotationDescription;
	
	@ManyToOne
	@JoinColumn(name = "NUM_DEMAND", referencedColumnName="NUM_DEMAND")
	@Bundle(key="ALMABANI_GENERAL_DEMAND")
	private WokDemand demand;
	
	@Column(name = "COD_LOGIN_INSERT", nullable = false, length = 10)
	private String insertLoginCode;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_ROW_INSERT", nullable = false, length = 7)
	private Date insertRowDate;
	
	@Column(name = "COD_LOGIN_MODIFY", length = 10)
	private String modificationLoginCode;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_LAST_MODIFY", length = 7)
	private Date lastModificationDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DAT_CREATION", length = 7)
	private Date creationDate;
	
	@Column(name = "IND_MOTIVE_QUOTATION", length = 1)
	private String indMotiveQuotation;
	
	@Column(name = "COD_INVOICE", length = 20)
	private String invoiceCode;
	
	@Column(name = "NUM_REFERENCE_MAXIMO", precision = 10, scale = 0)
	private Long maximoReferenceNumber;

	@OneToMany(mappedBy ="oamQuotation",fetch=FetchType.EAGER) // Fetch Type EAGER because they are highly coupled and always have been used together
	@OrderBy("NUM_TYPE_QUOT_ACTION")
	private List<OamQuotationAction> quotataionActions = new ArrayList<OamQuotationAction>();   
	
	
	@OneToMany(mappedBy ="quotation",fetch=FetchType.LAZY)
	@OrderBy("NUM_IQUOTATION_DOCUMENT")
	private List<OamQuotationDocument> quotationDocuments = new ArrayList();
	
	
	@Column(name="NUM_REFERENCE_SYSTEM")
    private Long system;
   
	
	 @Column(name = "QUT_MONTHS_WARRANTY")
    private Integer monthWorrenty;
   
	 @Column(name = "QUT_DAYS_DELIVERY")
    private Integer deliveryDays;
   
	@Column(name = "DAT_REAL_DELIVERY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date realDeliveryDate;
   
	// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VAL_FREIGHT")
    private Integer valFreight;
    
    @Column(name = "PER_PAYMENT_APPROVAL"  )
    private Integer paymentApprovalPersentage;
    
    @ManyToOne
    @JoinColumn(name="NUM_PROJECT" , referencedColumnName="NUM_PROJECT")
    private Project project;
   
    @JoinColumn(name = "NUM_SUPPLIER", referencedColumnName = "NUM_SUPPLIER")
    @ManyToOne
    private OamSupplier supplier;
	    
	    
	
	
	@Transient
	private List<OamQuotationActionType> availableActionTypes;
	
	@Transient
	private OamQuotationActionType selectedActionType;
	
	@Transient
	private List<FileHolder> quotationFilesHolderList = new ArrayList();
	
	
	public OamQuotation() {
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}
	/**
	 * @return the indTypeQuotation
	 */
	public String getIndTypeQuotation() {
		return indTypeQuotation;
	}
	/**
	 * @param indTypeQuotation the indTypeQuotation to set
	 */
	public void setIndTypeQuotation(String indTypeQuotation) {
		this.indTypeQuotation = indTypeQuotation;
	}
	/**
	 * @return the quotationDescription
	 */
	public String getQuotationDescription() {
		return quotationDescription;
	}
	/**
	 * @param quotationDescription the quotationDescription to set
	 */
	public void setQuotationDescription(String quotationDescription) {
		this.quotationDescription = quotationDescription;
	}
	/**
	 * @return the demand
	 */
	public WokDemand getDemand() {
		return demand;
	}
	/**
	 * @param demand the demand to set
	 */
	public void setDemand(WokDemand demand) {
		this.demand = demand;
	}
	/**
	 * @return the insertLoginCode
	 */
	public String getInsertLoginCode() {
		return insertLoginCode;
	}
	/**
	 * @param insertLoginCode the insertLoginCode to set
	 */
	public void setInsertLoginCode(String insertLoginCode) {
		this.insertLoginCode = insertLoginCode;
	}
	/**
	 * @return the insertRowDate
	 */
	public Date getInsertRowDate() {
		return insertRowDate;
	}
	/**
	 * @param insertRowDate the insertRowDate to set
	 */
	public void setInsertRowDate(Date insertRowDate) {
		this.insertRowDate = insertRowDate;
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
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the indMotiveQuotation
	 */
	public String getIndMotiveQuotation() {
		return indMotiveQuotation;
	}
	/**
	 * @param indMotiveQuotation the indMotiveQuotation to set
	 */
	public void setIndMotiveQuotation(String indMotiveQuotation) {
		this.indMotiveQuotation = indMotiveQuotation;
	}
	/**
	 * @return the invoiceCode
	 */
	public String getInvoiceCode() {
		return invoiceCode;
	}
	/**
	 * @param invoiceCode the invoiceCode to set
	 */
	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}
	/**
	 * @return the maximoReferenceNumber
	 */
	public Long getMaximoReferenceNumber() {
		return maximoReferenceNumber;
	}
	/**
	 * @param maximoReferenceNumber the maximoReferenceNumber to set
	 */
	public void setMaximoReferenceNumber(Long maximoReferenceNumber) {
		this.maximoReferenceNumber = maximoReferenceNumber;
	}
	public List<OamQuotationAction> getQuotataionActions() {
		return quotataionActions;
	}
	public void setQuotataionActions(List<OamQuotationAction> quotataionActions) {
		this.quotataionActions = quotataionActions;
	}
	public List<OamQuotationActionType> getAvailableActionTypes() {
		return availableActionTypes;
	}
	public void setAvailableActionTypes(
			List<OamQuotationActionType> availableActionTypes) {
		this.availableActionTypes = availableActionTypes;
	}
	public OamQuotationActionType getSelectedActionType() {
		return selectedActionType;
	}
	public void setSelectedActionType(OamQuotationActionType selectedActionType) {
		this.selectedActionType = selectedActionType;
	}
	public List<FileHolder> getQuotationFilesHolderList() {
		return quotationFilesHolderList;
	}
	public void setQuotationFilesHolderList(
			List<FileHolder> quotationFilesHolderList) {
		this.quotationFilesHolderList = quotationFilesHolderList;
	}
	public List<OamQuotationDocument> getQuotationDocuments() {
		return quotationDocuments;
	}
	public void setQuotationDocuments(List<OamQuotationDocument> quotationDocuments) {
		this.quotationDocuments = quotationDocuments;
	}
	public Long getSystem() {
		return system;
	}
	public void setSystem(Long system) {
		this.system = system;
	}
	public Integer getMonthWorrenty() {
		return monthWorrenty;
	}
	public void setMonthWorrenty(Integer monthWorrenty) {
		this.monthWorrenty = monthWorrenty;
	}
	public Integer getDeliveryDays() {
		return deliveryDays;
	}
	public void setDeliveryDays(Integer deliveryDays) {
		this.deliveryDays = deliveryDays;
	}
	public Date getRealDeliveryDate() {
		return realDeliveryDate;
	}
	public void setRealDeliveryDate(Date realDeliveryDate) {
		this.realDeliveryDate = realDeliveryDate;
	}
	public Integer getValFreight() {
		return valFreight;
	}
	public void setValFreight(Integer valFreight) {
		this.valFreight = valFreight;
	}
	public Integer getPaymentApprovalPersentage() {
		return paymentApprovalPersentage;
	}
	public void setPaymentApprovalPersentage(Integer paymentApprovalPersentage) {
		this.paymentApprovalPersentage = paymentApprovalPersentage;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public OamSupplier getSupplier() {
		return supplier;
	}
	public void setSupplier(OamSupplier supplier) {
		this.supplier = supplier;
	}
	
}
