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
import com.almabani.common.exception.AlmabaniException;
import com.almabani.common.util.Utils;
import com.almabani.common.virtual.entity.StockItemView;
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

	private LazyDataModel<StockItemView> items;
	
	private List<Project> projects;

	private boolean operationSuccess = false;

	private StockItemView selected;

	@PostConstruct
	public void init() {
		
		initializeStockItemLazyList();
		
		loadInitialLists();

		prepareStatesList();
	}

	public void prepareCreate() {

		selected = new StockItemView();
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

	private class StockItemsLazyModel extends LazyDataModel<StockItemView>
			implements Serializable {
		/**
 * 
 */
		private static final long serialVersionUID = 1L;
		private Integer rowCount;

		List<StockItemView> result;

		@Override
		public List<StockItemView> load(int first, int pageSize,
				String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {

			injectCompanyInCaseOfNormalUser(filters);

			rowCount = almabaniFacade.getNumberOfOamStockItemsView(filters);

			result = (List<StockItemView>) almabaniFacade.loadOamStockItemsView(
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
		public StockItemView getRowData(String rowKey) {

			for (StockItemView stockItemView : result) {
				if (stockItemView.getProjectItem().getId().equals(rowKey)) {
					selected = stockItemView;
					return stockItemView;
				}
			}

			return null;
		}

	}

	public LazyDataModel<StockItemView> getItems() {
		return items;
	}

	public void setItems(LazyDataModel<StockItemView> items) {
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

	public StockItemView getSelected() {
		return selected;
	}

	public void setSelected(StockItemView selected) {
		this.selected = selected;
	}


	

}
