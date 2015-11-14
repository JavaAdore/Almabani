package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.almabani.common.constant.DataAccessConstants;
import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.State;
import com.almabani.common.entity.schema.adminoam.OamItemQuotation;
import com.almabani.common.entity.schema.adminoam.OamItemsQuotSupplier;
import com.almabani.common.entity.schema.adminoam.OamSupplier;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class OamItemsQuotSupplierManagementBean extends AbstractBeanHelper
		implements Serializable {
	private static final long serialVersionUID = 1L;

	private LazyDataModel<OamItemsQuotSupplier> items;

	private List<OamSupplier> suppliers;

	private List<OamItemQuotation> quotataionItems;

	private boolean operationSuccess = false;

	private OamItemsQuotSupplier selected;

	private List<State> states;

	private QuotationApplicationController quotationApplicationController;

	private OamItemQuotation parentQuotationItem;

	private OamSupplier supplier;

	private OamItemsQuotSupplier alreadySelectedQuotaionItem;

	public OamItemsQuotSupplier getAlreadySelectedQuotaionItem() {
		return alreadySelectedQuotaionItem;
	}

	public void setAlreadySelectedQuotaionItem(
			OamItemsQuotSupplier alreadySelectedQuotaionItem) {
		this.alreadySelectedQuotaionItem = alreadySelectedQuotaionItem;
	}

	public OamSupplier getSupplier() {
		return supplier;
	}

	public void setSupplier(OamSupplier supplier) {
		this.supplier = supplier;
	}

	public OamItemQuotation getParentQuotationItem() {
		return parentQuotationItem;
	}

	public void setParentQuotationItem(OamItemQuotation parentQuotationItem) {

		this.parentQuotationItem = parentQuotationItem;
	}

	public QuotationApplicationController getQuotationApplicationController() {
		return quotationApplicationController;
	}

	public void setQuotationApplicationController(
			QuotationApplicationController quotationApplicationController) {
		this.quotationApplicationController = quotationApplicationController;
	}

	@PostConstruct
	public void init() {
		initializeOamItemSupplierLazyList();
		prepareInitialLists();
	}

	private void initializeOamItemSupplierLazyList() {
		items = new OamItemsQuotSupplierLazyModel();
	}

	private void prepareInitialLists() {

		initializeQuotaitonItemList();
		initializeSupplierList();
	}

	private void initializeQuotaitonItemList() {
		if (WebUtils.isAdminUser()) {
			quotataionItems = almabaniFacade.getAllQuotationItems();
		} else {
			Company company = WebUtils.getCurrentLoggedUser().getEmployee()
					.getEstablishment().getCompany();
			quotataionItems = almabaniFacade.getAllQuotationItems(company);
		}

	}

	private void initializeSupplierList() {
		// TODO Auto-generated method stub
		if (WebUtils.isAdminUser()) {
			quotataionItems = almabaniFacade.getAllQuotationItems();
			suppliers = almabaniFacade.getAllSuppliers();
		} else {
			Company company = WebUtils.getCurrentLoggedUser().getEmployee()
					.getEstablishment().getCompany();
			quotataionItems = almabaniFacade.getAllQuotationItems(company);
			suppliers = almabaniFacade.getAllSuppliers(company);
		}
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public void prepareCreate() {
		selected = new OamItemsQuotSupplier();
		selected.setIndSelected(DataAccessConstants.NO);
		selected.setItemQuotation(parentQuotationItem);
	}

	public void saveNew() throws AlmabaniException {

		operationFaild();
		boolean isAlreadyExisitEntity = Utils.hasID(selected);

		selected = almabaniFacade.addOrUpdateOamItemsQuotSupplier(
				selected,
				CommonDriverMap.appendCurrentUserCode(null,
						WebUtils.getCurrentUserCode()));
		WebUtils.fireInfoMessage(
				(isAlreadyExisitEntity) ? MessagesKeyStore.ALMABANI_GENERAL_UPDATED_SUCCESSFULLY
						: MessagesKeyStore.ALMABANI_GENERAL_ADDED_SUCCESSFULLY,
				WebUtils.prepareParamSet(MessagesKeyStore.ALMABANI_GENERAL_ITEM_QUOTATION_SUPPLIER));

		operationSucceded();

	}

	private class OamItemsQuotSupplierLazyModel extends
			LazyDataModel<OamItemsQuotSupplier> implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Integer rowCount;

		List<OamItemsQuotSupplier> result;

		@Override
		public List<OamItemsQuotSupplier> load(int first, int pageSize,
				String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {

			if (Utils.isNotNull(parentQuotationItem)) {
				
				filters.put("itemQuotation", parentQuotationItem);

				rowCount = almabaniFacade
						.getCountOfOamItemsQuotSupplier(filters);

				result = (List<OamItemsQuotSupplier>) almabaniFacade
						.loadOamItemsQuotSuppliers(first, pageSize, sortField,
								sortOrder == SortOrder.ASCENDING, filters);

				setRowCount(this.rowCount);

				return result;
			}
			return new ArrayList();
		}

		private void injectCompanyIncaseOfNoneAdminUser(
				Map<String, Object> filters) {
			if (WebUtils.isAdminUser() == false) {
				filters.put("supplier.company", WebUtils.getCurrentLoggedUser()
						.getEmployee().getEstablishment().getCompany());
			}

		}

		@Override
		public OamItemsQuotSupplier getRowData(String rowKey) {

			for (OamItemsQuotSupplier qamItemsQuotSupplier : result) {
				if (qamItemsQuotSupplier.getId().toString().equals(rowKey)) {
					selected = qamItemsQuotSupplier;
					return qamItemsQuotSupplier;
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

	public void view() throws AlmabaniException {
		if (selected == null || selected.getId() == null
				|| selected.getId().intValue() == 0) {
			throw new AlmabaniException("ALMABANI_VIEW_SELECT_COMPANY_FIRST");
		}
		WebUtils.invokeJavaScriptFunction("PF('viewDialog').show()");
	}

	public LazyDataModel<OamItemsQuotSupplier> getItems() {
		return items;
	}

	public void setItems(LazyDataModel<OamItemsQuotSupplier> items) {
		this.items = items;
	}

	public OamItemsQuotSupplier getSelected() {
		return selected;
	}

	public void setSelected(OamItemsQuotSupplier selected) {
		this.selected = selected;
	}

	public void onRowSelect(SelectEvent event) {
		selected = (OamItemsQuotSupplier) event.getObject();
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

	public List<OamItemQuotation> getQuotataionItems() {
		return quotataionItems;
	}

	public void setQuotataionItems(List<OamItemQuotation> quotataionItems) {
		this.quotataionItems = quotataionItems;
	}

	public List<OamSupplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<OamSupplier> suppliers) {
		this.suppliers = suppliers;
	}

	public void refreshQuotationItemList() {
		initializeQuotaitonItemList();

	}

	public void initializeNewSupplier() {

		supplier = new OamSupplier();
		supplier.setCompany(WebUtils.getCurrentLoggedUserCompany());
		supplier.setIndActive(DataAccessConstants.IND_ACTIVE);
		supplier.setIndProspect(DataAccessConstants.IND_ACTIVE);

	}

	public void addSupplier() throws AlmabaniException {

		supplier = almabaniFacade.addorUpdateSupplier(
				supplier,
				CommonDriverMap.appendCurrentUserCode(null,
						WebUtils.getCurrentUserCode()));
		suppliers.add(supplier);
		selected.setSupplier(supplier);
		WebUtils.fireInfoMessage(

		MessagesKeyStore.ALMABANI_GENERAL_ADDED_SUCCESSFULLY, WebUtils
				.prepareParamSet(MessagesKeyStore.ALMABANI_GENERAL_SUPPLIER));
	}

	public void statusChanged(AjaxBehaviorEvent event) {

		String status = (String) ((SelectOneMenu) event.getSource()).getValue();
		if (Utils.isNotEmptyString(status)
				&& status.equalsIgnoreCase(DataAccessConstants.YES)) {
			try {
				almabaniFacade
						.checkQuotationItemSupplierSelectionAvailability(selected
								.getItemQuotation());
			} catch (AlmabaniException e) {
				alreadySelectedQuotaionItem = (OamItemsQuotSupplier) e
						.getWrappedObject();
				displayQuotionMessage();
			}

		}

	}

	private void displayQuotionMessage() {

		WebUtils.invokeJavaScriptFunction("displayDublicationForm()");
	}

	public void unselectOldSupplierOfQuotationItem() {
		almabaniFacade
				.unselectOldSupplierOfQuotationItem(alreadySelectedQuotaionItem
						.getItemQuotation());

	}

	public void cancelSelectingCurrentSupplier() {
		selected.setIndSelected(DataAccessConstants.NO);
	}

	public void loadOamItemSupplierLazyModel() {

		initializeOamItemSupplierLazyList();
	}
}
