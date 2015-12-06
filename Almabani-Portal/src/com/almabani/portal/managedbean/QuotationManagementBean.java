package com.almabani.portal.managedbean;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.dto.FileHolder;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Country;
import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.common.entity.schema.admincor.Project;
import com.almabani.common.entity.schema.admincor.State;
import com.almabani.common.entity.schema.adminoam.OamDocumentType;
import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.common.entity.schema.adminoam.OamQuotationActionType;
import com.almabani.common.entity.schema.adminoam.OamQuotationDocument;
import com.almabani.common.entity.schema.adminoam.OamSupplier;
import com.almabani.common.entity.schema.adminsec.SecSystem;
import com.almabani.common.entity.schema.adminwkf.WokDemand;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.common.interfaces.QuotataionHolder;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class QuotationManagementBean extends AbstractBeanHelper implements
		QuotataionHolder, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LazyDataModel<OamQuotation> items;

	private boolean operationSuccess = false;

	private List<Department> departments;

	private List<Project> projects;

	private OamQuotation selected;

	private List<State> states;

	private List<WokDemand> wokDemands;

	private QuotationApplicationController quotationApplicationController;

	private List<OamDocumentType> documentTypeList;

	private OamQuotationDocument selectedQuotationDocument;

	private List<Company> companies;
	private List<OamSupplier> suppliers;

	@PostConstruct
	public void init() {
		initializeCompaniesLazyList();
		loadInitialLists();
		prepareStatesList();
	}

	private void loadInitialLists() {

		if (WebUtils.isAdminUser()) {
			companies = almabaniFacade.getAllCompanies();

		} else {
			Company company = WebUtils.getCurrentLoggedUser().getEmployee()
					.getEstablishment().getCompany();
			loadIntialList(company);
		}

	}

	private void initializeCompaniesLazyList() {
		items = new QuotationLazyModel();
	}

	private void prepareStatesList() {
		List<Country> countries = getApplicationScopeStore().getCountries();
		if (Utils.isNotEmptyList(countries)) {
			setCurrentStateList(countries.get(0));
		}

	}

	public void countryChanged(AjaxBehaviorEvent event) {
		Country country = (Country) ((SelectOneMenu) event.getSource())
				.getValue();

		setCurrentStateList(country);
	}

	private void setCurrentStateList(Country country) {

		states = getApplicationScopeStore().getStatesListByCountry(country);
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public void prepareCreate() {
		selected = new OamQuotation();
		loadDocumentTypesList();
	}

	private void loadDocumentTypesList() {

		if (Utils.isNull(documentTypeList)) {
			documentTypeList = almabaniFacade.getDocuemtTypeList(WebUtils
					.getCurrentLoggedUserCompany());

		}
	}

	public void saveNew() throws AlmabaniException {

		try {
			operationFaild();
			boolean isAlreadyExisitEntity = Utils.hasID(selected);
			CommonDriverMap commonDriverMap = CommonDriverMap
					.appendCurrentUserCode(null, WebUtils.getCurrentUserCode());

			commonDriverMap.appendCompany(commonDriverMap,
					WebUtils.getCurrentLoggedUserCompany());

			selected = almabaniFacade.addOrUpdateQuotation(selected,
					commonDriverMap);
			WebUtils.fireInfoMessage(
					(isAlreadyExisitEntity) ? MessagesKeyStore.ALMABANI_GENERAL_UPDATED_SUCCESSFULLY
							: MessagesKeyStore.ALMABANI_GENERAL_ADDED_SUCCESSFULLY,
					WebUtils.prepareParamSet(MessagesKeyStore.ALMABANI_GENERAL_QUOTATION));
			quotationApplicationController.setQuotation(selected);
			quotationApplicationController.refreshQuotaionList();
			attachAvailableActionTypes();
			selected.getQuotationFilesHolderList().clear();
			operationSucceded();

		} catch (AlmabaniException e) {
			selected.getQuotationFilesHolderList().clear();
			throw e;
		}

	}

	public void uploadQuotationDocument(FileUploadEvent event) {

		try {
			FileHolder fileHolder = FileHolder.prepareFileHolder(event
					.getFile().getFileName(), event.getFile().getInputstream());
			selected.getQuotationFilesHolderList().add(fileHolder);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteUploadedFile(FileHolder fileHolder) {
		selected.getQuotationFilesHolderList().remove(fileHolder);

	}

	private void emptyInputStreamList() {
		selected.getQuotationFilesHolderList().clear();
	}

	private class QuotationLazyModel extends LazyDataModel<OamQuotation>
			implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Integer rowCount;

		List<OamQuotation> result;

		@Override
		public List<OamQuotation> load(int first, int pageSize,
				String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {
			rowCount = almabaniFacade.getNumberOfQoutations(filters);

			injectCompanyIncaseOfNoneAdminUser(filters);
			result = (List<OamQuotation>) almabaniFacade.loadQoutations(first,
					pageSize, sortField, sortOrder == SortOrder.ASCENDING,
					filters);

			setRowCount(this.rowCount);

			return result;
		}

		@Override
		public OamQuotation getRowData(String rowKey) {

			for (OamQuotation qoutation : result) {
				if (qoutation.getId().toString().equals(rowKey)) {
					selected = qoutation;
					return qoutation;
				}
			}

			return null;
		}

	}

	public void edit() throws AlmabaniException {
		if (selected == null || selected.getId() == null
				|| selected.getId().intValue() == 0) {
			throw new AlmabaniException("ALMABANI_VIEW_SELECT_COMPANY_FIRST");
		}
		WebUtils.invokeJavaScriptFunction("PF('editDialog').show()");
	}

	public void injectCompanyIncaseOfNoneAdminUser(Map<String, Object> filters) {
		if (WebUtils.isAdminUser() == false) {
			filters.put("department.company", WebUtils.getCurrentLoggedUser()
					.getEmployee().getEstablishment().getCompany());
		}

	}

	public void view() throws AlmabaniException {
		if (selected == null || selected.getId() == null
				|| selected.getId().intValue() == 0) {
			throw new AlmabaniException("ALMABANI_VIEW_SELECT_COMPANY_FIRST");
		}
		WebUtils.invokeJavaScriptFunction("PF('viewDialog').show()");
	}

	public LazyDataModel<OamQuotation> getItems() {
		return items;
	}

	public void setItems(LazyDataModel<OamQuotation> items) {
		this.items = items;
	}

	public OamQuotation getSelected() {
		return selected;
	}

	public void setSelected(OamQuotation selected) {
		this.selected = selected;
		quotationApplicationController.setQuotation(selected);
		attachAvailableActionTypes();
		attachUploadedDocuments();
		loadDocumentTypesList();

	}

	private void attachUploadedDocuments() {
		if (Utils.isNotNull(selected)) {
			List<OamQuotationDocument> quotationDocuments = almabaniFacade
					.getQuotationDocuments(selected);
			selected.setQuotationDocuments(quotationDocuments);
			int counter = 1;
			selected.getQuotationFilesHolderList().clear();
			for (OamQuotationDocument oamQuotationDocument : quotationDocuments) {
				try {
					FileHolder fileHolder = FileHolder.prepareFileHolder(
							oamQuotationDocument.getId(), oamQuotationDocument.getDocumentName(), oamQuotationDocument
									.getImgQuotation().getBinaryStream());
					fileHolder.setDocumentType(oamQuotationDocument
							.getDocumentType());
					selected.getQuotationFilesHolderList().add(fileHolder);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	public void onRowSelect(SelectEvent event) {
		selected = (OamQuotation) event.getObject();
	}

	public void attachAvailableActionTypes() {

		List<OamQuotationActionType> availableActionTypes = almabaniFacade
				.getAvailableQuotationActionTypes(selected);
		selected.setAvailableActionTypes(availableActionTypes);
		if (Utils.isNotNull(selected.getQuotataionActions())) {
			selected.setSelectedActionType(selected.getQuotataionActions()
					.get(selected.getQuotataionActions().size() - 1)
					.getOamTypesQuotActions());
		}
	}

	public void operationFaild() {
		operationSuccess = false;
	}

	public void operationSucceded() {
		operationSuccess = true;

	}

	public boolean isOperationSuccess() {
		return operationSuccess;
	}

	public void setOperationSuccess(boolean operationSuccess) {
		this.operationSuccess = operationSuccess;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public List<WokDemand> getWokDemands() {
		return wokDemands;
	}

	public void setWokDemands(List<WokDemand> wokDemands) {
		this.wokDemands = wokDemands;
	}

	@Override
	public OamQuotation getCurrentQuotation() {
		return selected;
	}

	public void onRowEdit(RowEditEvent event) {

		selected = (OamQuotation) event.getObject();

	}

	public QuotationApplicationController getQuotationApplicationController() {
		return quotationApplicationController;
	}

	public void setQuotationApplicationController(
			QuotationApplicationController quotationApplicationController) {
		this.quotationApplicationController = quotationApplicationController;
	}

	public List<OamDocumentType> getDocumentTypeList() {
		return documentTypeList;
	}

	public void setDocumentTypeList(List<OamDocumentType> documentTypeList) {
		this.documentTypeList = documentTypeList;
	}

	public OamQuotationDocument getSelectedQuotationDocument() {
		return selectedQuotationDocument;
	}

	public void setSelectedQuotationDocument(
			OamQuotationDocument selectedQuotationDocument) {
		this.selectedQuotationDocument = selectedQuotationDocument;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public void initializeWokDemands(Company company) {
		if (Utils.isNotNull(company)) {
			wokDemands = almabaniFacade.getWokDemands(company);
		} else {
			wokDemands = new ArrayList();
		}

	}

	public void loadIntialList(Company company) {

		if (Utils.isNotNull(company)) {
			intializeDepertmentsList(company);
			initializeWokDemands(company);
			initializeProjectlist(company);
			initialieSuppliersList(company);
		} else {
			initializeWokDemands(null);
			initializeProjectlist(null);
			initialieSuppliersList(null);

		}

	}

	private void intializeDepertmentsList(Company company) {
		if (Utils.isNotNull(company)) {
			departments = almabaniFacade.getDepartments(company);
		} else {
			departments = new ArrayList();
		}
	}

	private void initialieSuppliersList(Company company) {
		if (Utils.isNotNull(company)) {
			suppliers = almabaniFacade.getAllSuppliers(company);
		} else {
			suppliers = new ArrayList();
		}

	}


	private void initializeProjectlist(Company company) {
		if (Utils.isNotNull(company)) {
			projects = almabaniFacade.getProjects(company);
		} else {
			projects = new ArrayList();
		}
	}

	
	public void loadInitialListsOfSelectedQuotation()
	{
		
		loadIntialList(selected.getDepartment().getCompany());
	}


	public List<OamSupplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<OamSupplier> suppliers) {
		this.suppliers = suppliers;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

}
