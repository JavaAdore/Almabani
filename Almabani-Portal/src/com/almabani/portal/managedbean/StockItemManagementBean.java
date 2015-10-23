package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Project;
import com.almabani.common.entity.schema.adminoam.OamProjectItem;
import com.almabani.common.entity.schema.adminoam.OamStockItem;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class StockItemManagementBean extends AbstractBeanHelper implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LazyDataModel<OamStockItem> items;
	
	private List<Project> projects;

	private boolean operationSuccess = false;

	private OamStockItem selected;

	@PostConstruct
	public void init() {
		
		initializeStockItemLazyList();
		
		loadInitialLists();

		prepareStatesList();
	}

	public void prepareCreate() {

		selected = new OamStockItem();
	}

	private void loadInitialLists() {

	}

	public List<OamProjectItem> autoCompleteProjectItemList(
			String projectItemNameOrDescription) {

		projectItemNameOrDescription = Utils
				.isNotEmptyString(projectItemNameOrDescription) ? projectItemNameOrDescription
				: "";
		if (WebUtils.isAdminUser()) {
			return almabaniFacade.getAllCompanyProjectItems(
					projectItemNameOrDescription, null);
		} else {
			return almabaniFacade.getAllCompanyProjectItems(
					projectItemNameOrDescription, WebUtils
							.getCurrentLoggedUser().getEmployee()
							.getEstablishment().getCompany());

		}

	}

	private void initializeStockItemLazyList() {
		items = new StockItemsLazyModel();

	}

	private void prepareStatesList() {

	}

	public void saveNew() throws AlmabaniException {

		operationFaild();
	//	boolean isAlreadyExisitEntity = Utils.hasID(selected);
//
//		selected = almabaniFacade.addorUpdateOamStockItem(
//				selected,
//				CommonDriverMap.appendCurrentUserCode(null,
//						WebUtils.getCurrentUserCode()));
//		WebUtils.fireInfoMessage(
//				(isAlreadyExisitEntity) ? MessagesKeyStore.ALMABANI_GENERAL_UPDATED_SUCCESSFULLY
//						: MessagesKeyStore.ALMABANI_GENERAL_ADDED_SUCCESSFULLY,
//				WebUtils.prepareParamSet(MessagesKeyStore.ALMABANI_GENERAL_OAM_STOCK_ITEM));

		operationSuccess();

	}

	private void operationSuccess() {
		operationSuccess = true;
	}

	private void operationFaild() {
		operationSuccess = false;
	}

	private class StockItemsLazyModel extends LazyDataModel<OamStockItem>
			implements Serializable {
		/**
 * 
 */
		private static final long serialVersionUID = 1L;
		private Integer rowCount;

		List<OamStockItem> result;

		@Override
		public List<OamStockItem> load(int first, int pageSize,
				String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {

			injectCompanyInCaseOfNormalUser(filters);

			rowCount = almabaniFacade.getNumberOfOamStockItemsView(filters);

			result = (List<OamStockItem>) almabaniFacade.loadOamStockItemsView(
					first, pageSize, sortField,
					sortOrder == SortOrder.ASCENDING, filters);

			setRowCount(this.rowCount);

			return result;
		}

		private void injectCompanyInCaseOfNormalUser(Map<String, Object> filters) {

			if (WebUtils.getCurrentLoggedUser().isAdminUser() == false) {
				Company company = WebUtils.getCurrentLoggedUser().getEmployee()
						.getEstablishment().getCompany();
				if (Utils.isNotNull(company))
					filters.put("company", company);
			}

		}

		@Override
		public OamStockItem getRowData(String rowKey) {

			for (OamStockItem stockItemView : result) {
				if (stockItemView.getProjectItem().getId().equals(rowKey)) {
					selected = stockItemView;
					return stockItemView;
				}
			}

			return null;
		}

	}

	public LazyDataModel<OamStockItem> getItems() {
		return items;
	}

	public void setItems(LazyDataModel<OamStockItem> items) {
		this.items = items;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public boolean isOperationSuccess() {
		return operationSuccess;
	}

	public void setOperationSuccess(boolean operationSuccess) {
		this.operationSuccess = operationSuccess;
	}

	public OamStockItem getSelected() {
		return selected;
	}

	public void setSelected(OamStockItem selected) {
		this.selected = selected;
	}


	

}
