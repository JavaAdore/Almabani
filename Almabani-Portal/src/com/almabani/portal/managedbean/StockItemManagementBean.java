package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.almabani.common.constant.DataAccessConstants;
import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Establishment;
import com.almabani.common.entity.schema.adminoam.OamItemQuotation;
import com.almabani.common.entity.schema.adminoam.OamProjectItem;
import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.common.entity.schema.adminoam.OamStockItem;
import com.almabani.common.entity.schema.adminoam.view.OamStockItemDetailsView;
import com.almabani.common.entity.schema.adminoam.view.OamStockItemView;
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

	private LazyDataModel<OamStockItemView> stockItemView;

	private LazyDataModel<OamStockItemDetailsView> stockItemDetailedView;

	private boolean operationSuccess = false;

	private OamStockItemView selected = null;

	private OamStockItem selectedStockItem;

	private List<OamItemQuotation> quotataionItems;

	private List<Establishment> establishments;

	@PostConstruct
	public void init() {

		initializeStockItemLazyList();
		initializeStockItemDetailsLazyList();
		loadEstablishmentsList();
	}

	public void prepareCreateStockItem() {
		selectedStockItem = new OamStockItem();
		selectedStockItem.setIndInOut(DataAccessConstants.STOCK_ITEM_OUT);
		quotataionItems = almabaniFacade.getItemQuotataion(new OamProjectItem(
				selected.getOamStockItemViewId().getProjectItemId()));
	}

	private void initializeStockItemDetailsLazyList() {
		stockItemDetailedView = new StockItemsDetailsLazyModel();
	}

	private void initializeStockItemLazyList() {
		stockItemView = new StockItemsLazyModel();

	}

	private void prepareStatesList() {

	}

	private class StockItemsLazyModel extends LazyDataModel<OamStockItemView>
			implements Serializable {
		private static final long serialVersionUID = 1L;
		private Integer rowCount;

		List<OamStockItemView> result;

		@Override
		public List<OamStockItemView> load(int first, int pageSize,
				String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {

			injectCompanyInCaseOfNormalUser(filters);

			rowCount = almabaniFacade.getNumberOfOamStockItemsView(filters);

			result = (List<OamStockItemView>) almabaniFacade
					.loadOamStockItemsView(first, pageSize, sortField,
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
		public OamStockItemView getRowData(String rowKey) {

			for (OamStockItemView stockItemView : result) {
				String rowCompositIdentifier = stockItemView
						.getOamStockItemViewId().getProjectItemId()
						+ "-"
						+ stockItemView.getOamStockItemViewId()
								.getEstablishmentNumber();
				if (rowCompositIdentifier.toString().equals(rowKey)) {
					selected = stockItemView;
					return stockItemView;
				}
			}

			return null;
		}

	}

	private class StockItemsDetailsLazyModel extends
			LazyDataModel<OamStockItemDetailsView> implements Serializable {
		private static final long serialVersionUID = 1L;
		private Integer rowCount;

		List<OamStockItemDetailsView> result;

		@Override
		public List<OamStockItemDetailsView> load(int first, int pageSize,
				String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {

			if (Utils.isNotNull(selected)) {

				attachSelectedProjectItem(filters);
				attachSelectedEstablishment(filters);
				rowCount = almabaniFacade
						.getNumberOfOamStockItemsDetailsView(filters);

				result = (List<OamStockItemDetailsView>) almabaniFacade
						.loadOamStockItemsDetailsView(first, pageSize,
								sortField, sortOrder == SortOrder.ASCENDING,
								filters);

				setRowCount(this.rowCount);
			} else {
				result = new ArrayList();

			}

			return result;
		}

		private void attachSelectedEstablishment(Map<String, Object> filters) {

			filters.put("establishment.id", selected.getOamStockItemViewId()
					.getEstablishmentNumber());
		}

		private void attachSelectedProjectItem(Map<String, Object> filters) {

			filters.put("projectItemId", selected.getOamStockItemViewId()
					.getProjectItemId());
		}

	}

	public boolean isOperationSuccess() {
		return operationSuccess;
	}

	public void setOperationSuccess(boolean operationSuccess) {
		this.operationSuccess = operationSuccess;
	}

	public OamStockItemView getSelected() {
		return selected;
	}

	public void setSelected(OamStockItemView selected) {
		this.selected = selected;
	}

	public LazyDataModel<OamStockItemView> getStockItemView() {
		return stockItemView;
	}

	public void setStockItemView(LazyDataModel<OamStockItemView> stockItemView) {
		this.stockItemView = stockItemView;
	}

	public LazyDataModel<OamStockItemDetailsView> getStockItemDetailedView() {
		return stockItemDetailedView;
	}

	public void setStockItemDetailedView(
			LazyDataModel<OamStockItemDetailsView> stockItemDetailedView) {
		this.stockItemDetailedView = stockItemDetailedView;
	}

	public OamStockItem getSelectedStockItem() {
		return selectedStockItem;
	}

	public void setSelectedStockItem(OamStockItem selectedStockItem) {
		this.selectedStockItem = selectedStockItem;
	}

	public List<OamItemQuotation> getQuotataionItems() {
		return quotataionItems;
	}

	public void setQuotataionItems(List<OamItemQuotation> quotataionItems) {
		this.quotataionItems = quotataionItems;
	}

	public void withdrawal() throws AlmabaniException {

		boolean isAlreadyExisitEntity = Utils.hasID(selectedStockItem);
		
		selectedStockItem.setProjectItem(new OamProjectItem(selected
				.getOamStockItemViewId().getProjectItemId()));
		
		selectedStockItem.setEstablishment(new Establishment(selected.getOamStockItemViewId().getEstablishmentNumber()));
		
	
		
		selectedStockItem = almabaniFacade.addorUpdateOamStockItem(
				selectedStockItem,
				CommonDriverMap.appendCurrentUserCode(null,
						WebUtils.getCurrentUserCode()));
		selected.deductAmount(selectedStockItem.getEntryValue());
		WebUtils.fireInfoMessage(
				(isAlreadyExisitEntity) ? MessagesKeyStore.ALMABANI_GENERAL_UPDATED_SUCCESSFULLY
						: MessagesKeyStore.ALMABANI_GENERAL_ADDED_SUCCESSFULLY,
				WebUtils.prepareParamSet(MessagesKeyStore.ALMABANI_GENERAL_STOCK_ITEM));
	}

	public List<Establishment> getEstablishments() {
		return establishments;
	}

	public void setEstablishments(List<Establishment> establishments) {
		this.establishments = establishments;
	}

	private void loadEstablishmentsList() {
		if (WebUtils.isAdminUser()) {
			establishments = almabaniFacade.getAllEstablishments();
		} else {
			establishments = almabaniFacade.getAllEstablishments(WebUtils
					.getCurrentLoggedUserCompany());

		}
	}


}
