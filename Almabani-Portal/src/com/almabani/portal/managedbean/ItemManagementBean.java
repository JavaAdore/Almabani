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
import com.almabani.common.entity.schema.adminoam.OamItem;
import com.almabani.common.entity.schema.adminoam.OamItemCategory;
import com.almabani.common.entity.schema.adminoam.OamManufacturer;
import com.almabani.common.entity.schema.adminoam.OamTypeMaterial;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class ItemManagementBean  extends AbstractBeanHelper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LazyDataModel<OamItem> items;
	
	private List<OamManufacturer>manufacturers;
	
	private List<OamItemCategory>itemCategories;

	private List<OamTypeMaterial>materialTypes;
	
	private boolean operationSuccess = false;


	private OamItem selected;

	

	@PostConstruct
	public void init() {
		initializeItemsLazyList();
		loadInitialLists();
	}

	private void loadInitialLists() {
		manufacturers = almabaniFacade.getAllManufacturers();
		itemCategories = almabaniFacade.getAllItemCategories();
		materialTypes = almabaniFacade.getAllMaterialTypes();
		
	}

	private void initializeItemsLazyList() {
		items = new ItemsLazyList();
	}

	
	public void prepareCreate() {
		   selected = new OamItem();
	}

	public void saveNew() throws AlmabaniException {

		operationFaild();
		boolean isAlreadyExisitEntity = Utils.hasID(selected);
		
		selected = almabaniFacade.addOrUpdateItem(selected, CommonDriverMap.appendCurrentUserCode(null, WebUtils.getCurrentUserCode()));
		WebUtils.fireInfoMessage(
				(isAlreadyExisitEntity) ? MessagesKeyStore.ALMABANI_GENERAL_UPDATED_SUCCESSFULLY
						: MessagesKeyStore.ALMABANI_GENERAL_ADDED_SUCCESSFULLY,
				WebUtils.prepareParamSet(MessagesKeyStore.ALMABANI_GENERAL_ITEM));
	
		operationSucceded();

	}

	private class ItemsLazyList extends LazyDataModel<OamItem> implements
			Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Integer rowCount;

		List<OamItem> result;

		@Override
		public List<OamItem> load(int first, int pageSize, String sortField,
				SortOrder sortOrder, Map<String, Object> filters) {
			rowCount = almabaniFacade.getnumberOfItems(filters);

			result = (List<OamItem>) almabaniFacade.loadItems(first,
					pageSize, sortField, sortOrder == SortOrder.ASCENDING,
					filters);

			setRowCount(this.rowCount);

			return result;
		}

		@Override
		public OamItem getRowData(String rowKey) {

			for (OamItem qoutation : result) {
				if (qoutation.getId().toString().equals(rowKey)) {
					selected = qoutation;
					return qoutation;
				}
			}

			return null;
		}

	}
	
	

	public LazyDataModel<OamItem> getItems() {
		return items;
	}

	public void setItems(LazyDataModel<OamItem> items) {
		this.items = items;
	}

	public OamItem getSelected() {
		return selected;
	}

	public void setSelected(OamItem selected) {
		this.selected = selected;
	}

	public void onRowSelect(SelectEvent event) {
		selected = (OamItem) event.getObject();
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

	public List<OamManufacturer> getManufacturers() {
		return manufacturers;
	}

	public void setManufacturers(List<OamManufacturer> manufacturers) {
		this.manufacturers = manufacturers;
	}

	public List<OamItemCategory> getItemCategories() {
		return itemCategories;
	}

	public void setItemCategories(List<OamItemCategory> itemCategories) {
		this.itemCategories = itemCategories;
	}

	public List<OamTypeMaterial> getMaterialTypes() {
		return materialTypes;
	}

	public void setMaterialTypes(List<OamTypeMaterial> materialTypes) {
		this.materialTypes = materialTypes;
	}

	
	

}
