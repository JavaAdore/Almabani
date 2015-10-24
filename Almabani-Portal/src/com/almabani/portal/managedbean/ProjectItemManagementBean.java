package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.common.entity.schema.admincor.DepartmentSection;
import com.almabani.common.entity.schema.admincor.Project;
import com.almabani.common.entity.schema.adminoam.OamItem;
import com.almabani.common.entity.schema.adminoam.OamProjectItem;
import com.almabani.common.entity.schema.adminoam.OamStockItem;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.common.util.Utils;
import com.almabani.dataaccess.daoimpl.CustomCriteria;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class ProjectItemManagementBean extends AbstractBeanHelper implements
		Serializable {

	private static final long serialVersionUID = 1L;

	private LazyDataModel<OamProjectItem> items;

	private List<OamItem> oamItems;

	private boolean operationSuccess = false;

	private List<Project> projects;

	private OamProjectItem selected;

	public OamStockItem selectedStockItem;

	private OamItem selectedItem;

	private LazyDataModel<OamStockItem> stockItems;

	private List<SelectItem> lightDepartments;

	private ItemsControllerManagementBean itemsControllerManagementBean;

	private boolean filterByApprovedQuotationsOnly;


	public List<OamItem> autoCompleteItemList(String itemNameOrDescription) {

		itemNameOrDescription = Utils.isNotEmptyString(itemNameOrDescription) ? itemNameOrDescription
				: "";
		if (WebUtils.isAdminUser()) {
			oamItems = almabaniFacade.getAllItems(itemNameOrDescription, null);
		} else {
			oamItems = almabaniFacade.getAllItems(itemNameOrDescription,
					WebUtils.getCurrentLoggedUser().getEmployee()
							.getEstablishment().getCompany());

		}
		return oamItems;

	}

	public LazyDataModel<OamProjectItem> getItems() {
		return items;
	}

	public List<OamItem> getOamItems() {
		return oamItems;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public OamProjectItem getSelected() {
		return selected;
	}

	public OamStockItem getSelectedStockItem() {
		return selectedStockItem;
	}

	public LazyDataModel<OamStockItem> getStockItems() {
		return stockItems;
	}

	@PostConstruct
	public void init() {
		initializeLazyModels();

		loadInitialLists();

		prepareStatesList();
	}

	private void initializeLazyModels() {
		items = new ProjecttemLazyModel();
		stockItems = new OamStockItemLazyModel();

	}

	private void loadInitialLists() {

		loadProjectsList();

		loadLightDepartmentsList();

	}

	private void loadLightDepartmentsList() {

		List<Department> departments = new ArrayList();
		if (WebUtils.isAdminUser()) {

			departments = almabaniFacade.getLightDepartments();

		} else {

			departments = almabaniFacade.getLightDepartments(WebUtils
					.getCurrentLoggedUserCompany());
		}
		lightDepartments = new ArrayList<>();

		for (Department lightDepartment : departments) {

			String companyName = WebUtils.isAdminUser() ? lightDepartment
					.getCompany().getCompanyName() + " - " : "";

			SelectItemGroup selectItemGroup = new SelectItemGroup(companyName
					+ lightDepartment.getDepartmentName());

			selectItemGroup.setSelectItems(new SelectItem[lightDepartment
					.getDepartmentSections().size()]);

			for (int i = 0; i < lightDepartment.getDepartmentSections().size(); i++) {
				DepartmentSection lightDepartmentSection = lightDepartment
						.getDepartmentSections().get(i);
				selectItemGroup.getSelectItems()[i] = new SelectItem(
						lightDepartmentSection.getSectionCode(),
						lightDepartmentSection.getSectionCode());
			}

			lightDepartments.add(selectItemGroup);

		}

	}

	private void loadProjectsList() {
		if (WebUtils.isAdminUser()) {
			projects = almabaniFacade.getAllProjects();
		} else {
			projects = almabaniFacade.getAllProjects(WebUtils
					.getCurrentLoggedUserCompany());

		}
	}

	private void operationFaild() {
		operationSuccess = false;
	}

	private void operationSuccess() {
		operationSuccess = true;
	}

	public void prepareCreate() {

		selected = new OamProjectItem();
		if (Utils.isNotNull(selectedItem)) {
			selected.setItem(selectedItem);

		}
	}

	private void prepareStatesList() {

	}

	public void saveNew() throws AlmabaniException {

		operationFaild();
		boolean isAlreadyExisitEntity = Utils.hasID(selected);

		selected = almabaniFacade.addOrUpdateProjectItem(
				selected,
				CommonDriverMap.appendCurrentUserCode(null,
						WebUtils.getCurrentUserCode()));
		WebUtils.fireInfoMessage(
				(isAlreadyExisitEntity) ? MessagesKeyStore.ALMABANI_GENERAL_UPDATED_SUCCESSFULLY
						: MessagesKeyStore.ALMABANI_GENERAL_ADDED_SUCCESSFULLY,
				WebUtils.prepareParamSet(MessagesKeyStore.ALMABANI_GENERAL_PROJECT_ITEM));

		operationSuccess();

	}

	public void setItems(LazyDataModel<OamProjectItem> items) {
		this.items = items;
	}

	public void setOamItems(List<OamItem> oamItems) {
		this.oamItems = oamItems;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public void setSelected(OamProjectItem selected) {
		this.selected = selected;
	}

	public void setSelectedStockItem(OamStockItem selectedStockItem) {
		this.selectedStockItem = selectedStockItem;
	}

	public void setStockItems(LazyDataModel<OamStockItem> stockItems) {
		this.stockItems = stockItems;
	}

	private class OamStockItemLazyModel extends LazyDataModel<OamStockItem>
			implements Serializable {
		/**
* 
*/
		private static final long serialVersionUID = 1L;
		List<OamStockItem> result;

		private Integer rowCount;

		private void attachSelectedProjectItem(Map<String, Object> filters) {
			filters.put("projectItem", selected);

		}

		@Override
		public OamStockItem getRowData(String rowKey) {

			for (OamStockItem stockItem : result) {
				if (stockItem.getId().toString().equals(rowKey)) {
					selectedStockItem = stockItem;
					return stockItem;
				}
			}

			return null;
		}

		@Override
		public List<OamStockItem> load(int first, int pageSize,
				String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {

			if (selected != null && Utils.hasID(selected)) {

				attachSelectedProjectItem(filters);

				rowCount = almabaniFacade.getNumberOfStockItems(filters);
				result = (List<OamStockItem>) almabaniFacade.loadOamStockItems(
						first, pageSize, sortField,
						sortOrder == SortOrder.ASCENDING, filters);
				setRowCount(this.rowCount);

				return result;
			} else {
				return new ArrayList();
			}

		}

	}

	private class ProjecttemLazyModel extends LazyDataModel<OamProjectItem>
			implements Serializable {
		/**
* 
*/
		private static final long serialVersionUID = 1L;
		List<OamProjectItem> result;

		private Integer rowCount;

		private void attachCompanyFiltrataionInCaseOnNoneAdmin(
				Map<String, Object> filters) {
			if (WebUtils.isAdminUser() == false) {
				filters.put("project.company",
						WebUtils.getCurrentLoggedUserCompany());
			}

		}

		@Override
		public OamProjectItem getRowData(String rowKey) {

			for (OamProjectItem qoutation : result) {
				if (qoutation.getId().toString().equals(rowKey)) {
					selected = qoutation;
					return qoutation;
				}
			}

			return null;
		}

		@Override
		public List<OamProjectItem> load(int first, int pageSize,
				String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {

			attachCompanyFiltrataionInCaseOnNoneAdmin(filters);

			attachSelectedItemInCaseOfSelected(filters);

			attachFilterByArrovedQuotationsOnly(filters);

			rowCount = almabaniFacade.getNumberOfProjectItems(filters);

			result = (List<OamProjectItem>) almabaniFacade.loadProjectItems(
					first, pageSize, sortField,
					sortOrder == SortOrder.ASCENDING, filters);

			setRowCount(this.rowCount);

			return result;
		}

		private void attachFilterByArrovedQuotationsOnly(
				Map<String, Object> filters) {
			if (filterByApprovedQuotationsOnly) {
				if (filters.containsKey("remainingAmount") == false) {
					filters.put("remainingAmount", new CustomCriteria(
							" is not null"));

				}

			}

		}

		private void attachSelectedItemInCaseOfSelected(
				Map<String, Object> filters) {

			if (Utils.isNotNull(selectedItem)) {

				filters.put("item", selectedItem);
			}

		}

	}

	public void onRowSelect(SelectEvent event) {

	}

	public List<SelectItem> getLightDepartments() {
		return lightDepartments;
	}

	public void setLightDepartments(List<SelectItem> lightDepartments) {
		this.lightDepartments = lightDepartments;
	}

	public ItemsControllerManagementBean getItemsControllerManagementBean() {
		return itemsControllerManagementBean;
	}

	public void setItemsControllerManagementBean(
			ItemsControllerManagementBean itemsControllerManagementBean) {
		this.itemsControllerManagementBean = itemsControllerManagementBean;
	}

	public OamItem getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(OamItem selectedItem) {
		this.selectedItem = selectedItem;
	}

	public boolean isFilterByApprovedQuotationsOnly() {
		return filterByApprovedQuotationsOnly;
	}

	public void setFilterByApprovedQuotationsOnly(
			boolean filterByApprovedQuotationsOnly) {
		this.filterByApprovedQuotationsOnly = filterByApprovedQuotationsOnly;
	}


}
