package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.dto.CommonDriverMap;
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
public class OamItemsQuotSupplierManagementBean extends AbstractBeanHelper implements
		Serializable {
	private static final long serialVersionUID = 1L;

	private LazyDataModel<OamItemsQuotSupplier> items;

	private List<OamSupplier> suppliers;
	
	private List<OamItemQuotation> quotataionItems;

	private boolean operationSuccess = false;


	private OamItemsQuotSupplier selected;

	private List<State> states;

	@PostConstruct
	public void init() {
		initializeCompaniesLazyList();
		prepareInitialLists();
	}

	private void initializeCompaniesLazyList() {
		items = new OamItemsQuotSupplierLazyModel();
	}

	private void prepareInitialLists() {
		
		quotataionItems = almabaniFacade.getAllQuotationItems();
		suppliers = almabaniFacade.getAllSuppliers();

	}

	

	
	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public void prepareCreate() {
		selected = new OamItemsQuotSupplier();
		
	}

	public void saveNew() throws AlmabaniException {

		operationFaild();
		boolean isAlreadyExisitEntity = Utils.hasID(selected);

		selected = almabaniFacade.addOrUpdateOamItemsQuotSupplier(selected, CommonDriverMap.appendCurrentUserCode(null, WebUtils.getCurrentUserCode()));
		WebUtils.fireInfoMessage(
				(isAlreadyExisitEntity) ? MessagesKeyStore.ALMABANI_GENERAL_UPDATED_SUCCESSFULLY
						: MessagesKeyStore.ALMABANI_GENERAL_ADDED_SUCCESSFULLY,
				WebUtils.prepareParamSet(MessagesKeyStore.ALMABANI_GENERAL_ITEM_QUOTATION_SUPPLIER));
		
		operationSucceded();

	}

	private class OamItemsQuotSupplierLazyModel extends LazyDataModel<OamItemsQuotSupplier> implements
			Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Integer rowCount;

		List<OamItemsQuotSupplier> result;

		@Override
		public List<OamItemsQuotSupplier> load(int first, int pageSize, String sortField,
				SortOrder sortOrder, Map<String, Object> filters) {
			rowCount = almabaniFacade.getCountOfOamItemsQuotSupplier(filters);

			result = (List<OamItemsQuotSupplier>) almabaniFacade.loadOamItemsQuotSuppliers(first,
					pageSize, sortField, sortOrder == SortOrder.ASCENDING,
					filters);

			setRowCount(this.rowCount);

			return result;
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
	
	
	public void edit() throws AlmabaniException
	{
		if(selected==null || selected.getId()==null ||selected.getId().intValue()==0)
		{
			throw new AlmabaniException("ALMABANI_VIEW_SELECT_COMPANY_FIRST");
		}
		WebUtils.invokeJavaScriptFunction("PF('editDialog').show()");
	}
	
	public void view() throws AlmabaniException
	{
		if(selected==null || selected.getId()==null ||selected.getId().intValue()==0)
		{
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

	

}
