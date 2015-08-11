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
import com.almabani.common.entity.schema.adminsec.SecModule;
import com.almabani.common.entity.schema.adminsec.SecSystem;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class ModuleManagementBean  extends AbstractBeanHelper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LazyDataModel<SecModule> items;
	
	private List<SecSystem> sytems;
	
	private boolean operationSuccess = false;


	private SecModule selected;

	

	@PostConstruct
	public void init() {
		initializeItemsLazyList();
		loadInitialLists();
	}

	private void loadInitialLists() {
		
		sytems = almabaniFacade.getAllSystems();
	}

	private void initializeItemsLazyList() {
		items = new ItemsLazyList();
	}

	
	public void prepareCreate() {
		   selected = new SecModule();
	}

	public void saveNew() throws AlmabaniException {

		operationFaild();
		boolean isAlreadyExisitEntity = Utils.hasID(selected);
		
		selected = almabaniFacade.addOrUpdateModule(selected, CommonDriverMap.appendCurrentUserCode(null, WebUtils.getCurrentUserCode()));
		WebUtils.fireInfoMessage(
				(isAlreadyExisitEntity) ? MessagesKeyStore.ALMABANI_GENERAL_UPDATED_SUCCESSFULLY
						: MessagesKeyStore.ALMABANI_GENERAL_ADDED_SUCCESSFULLY,
				WebUtils.prepareParamSet(MessagesKeyStore.ALMABANI_GENERAL_MODULE));
		
		operationSucceded();

	}

	private class ItemsLazyList extends LazyDataModel<SecModule> implements
			Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Integer rowCount;

		List<SecModule> result;

		@Override
		public List<SecModule> load(int first, int pageSize, String sortField,
				SortOrder sortOrder, Map<String, Object> filters) {
			rowCount = almabaniFacade.getNumberOfModules(filters);

			result = (List<SecModule>) almabaniFacade.loadModules(first,
					pageSize, sortField, sortOrder == SortOrder.ASCENDING,
					filters);

			setRowCount(this.rowCount);

			return result;
		}

		@Override
		public SecModule getRowData(String rowKey) {

			for (SecModule module : result) {
				if (module.getId().toString().equals(rowKey)) {
					selected = module;
					return module;
				}
			}

			return null;
		}

	}
	
	

	public LazyDataModel<SecModule> getItems() {
		return items;
	}

	public void setItems(LazyDataModel<SecModule> items) {
		this.items = items;
	}

	public SecModule getSelected() {
		return selected;
	}

	public void setSelected(SecModule selected) {
		this.selected = selected;
	}

	public void onRowSelect(SelectEvent event) {
		selected = (SecModule) event.getObject();
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

	public List<SecSystem> getSytems() {
		return sytems;
	}

	public void setSytems(List<SecSystem> sytems) {
		this.sytems = sytems;
	}


}
