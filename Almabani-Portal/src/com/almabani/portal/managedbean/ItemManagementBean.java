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
import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.common.entity.schema.admincor.DepartmentSection;
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
public class ItemManagementBean extends AbstractBeanHelper implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LazyDataModel<OamItem> items;

	private List<OamManufacturer> manufacturers;

	private List<OamItemCategory> itemCategories;

	private List<OamTypeMaterial> materialTypes;

	private boolean operationSuccess = false;

	OamManufacturer manufacturer;

	Department department;

	private List<Company> companies;

	private List<Department> departments;

	private OamItemCategory oamItemCategory;

	private OamItem selected;

	private List<DepartmentSection> departmentSections;

	private ItemsControllerManagementBean itemsControllerManagementBean;

	@PostConstruct
	public void init() {
		initializeItemsLazyList();

	}

	public void addNewManufacturer() throws AlmabaniException {
		CommonDriverMap commonDriverMap = new CommonDriverMap();
		commonDriverMap = commonDriverMap.appendCurrentUserCode(
				commonDriverMap, WebUtils.getCurrentUserCode());
		manufacturer = almabaniFacade.addOrUpdateManufacturer(manufacturer,
				commonDriverMap);
		manufacturers.add(manufacturer);
		selected.setManufacturer(manufacturer);
		WebUtils.fireInfoMessage(
				MessagesKeyStore.ALMABANI_GENERAL_ADDED_SUCCESSFULLY,
				WebUtils.prepareParamSet(MessagesKeyStore.ALMABANI_GENERAL_MANUFACTURER));
	}

	public void addNewItemCategory() throws AlmabaniException {
		CommonDriverMap commonDriverMap = new CommonDriverMap();
		commonDriverMap = commonDriverMap.appendCurrentUserCode(
				commonDriverMap, WebUtils.getCurrentUserCode());
		oamItemCategory = almabaniFacade.addOrUpdateItemCategory(
				oamItemCategory, commonDriverMap);
		itemCategories.add(oamItemCategory);
		selected.setItemCategory(oamItemCategory);
		WebUtils.fireInfoMessage(
				MessagesKeyStore.ALMABANI_GENERAL_ADDED_SUCCESSFULLY,
				WebUtils.prepareParamSet(MessagesKeyStore.ALMABANI_GENERAL_ITEM_CATEGORY));
	}

	private void loadInitialLists() {

		if (WebUtils.isAdminUser()) {
			manufacturers = almabaniFacade.getAllManufacturers();
			materialTypes = almabaniFacade.getAllMaterialTypes();
			companies = almabaniFacade.getAllCompanies();
		} else {
			Company company = WebUtils.getCurrentLoggedUser().getEmployee()
					.getEstablishment().getCompany();
			manufacturers = almabaniFacade.getAllManufacturers(company);
			materialTypes = almabaniFacade.getAllMaterialTypes(company);
			companies = new ArrayList<Company>();
			companies.add(WebUtils.getCurrentLoggedUser().getEmployee()
					.getEstablishment().getCompany());
		}

	}

	public void loadItemCategoriesOfDepartment(Department department) {
		if (Utils.isNull(department)) {
			itemCategories = almabaniFacade.getAllItemCategories();
		} else {
			itemCategories = almabaniFacade.getAllItemCategories(department);

		}
	}

	public void departmentChanged(AjaxBehaviorEvent event) {
		department = (Department) ((SelectOneMenu) event.getSource())
				.getValue();
		if (Utils.isNotNull(department)) {
			loadItemCategoriesOfDepartment(department);
		} else {
			initializeNewitemCategoriesList();
		}
	}

	public void initializeDepartmentAndDepartmentsList() {
		loadInitialLists();
		department = selected.getItemCategory().getComDepartmentSection()
				.getDepartment();
		initializeDepartmentsList();

		loadItemCategoriesOfDepartment(department);
	}

	private void initializeNewitemCategoriesList() {
		itemCategories = new ArrayList();
	}

	private void initializeItemsLazyList() {
		items = new ItemsLazyList();
	}

	public void prepareCreate() {
		selected = new OamItem();
		initializeDepartmentsList();
		loadInitialLists();
	}

	private void initializeDepartmentsList() {
		if (Utils.isNull(departments)) {
			if (WebUtils.isAdminUser()) {
				departments = almabaniFacade.getDepartments();
			} else {
				departments = almabaniFacade.getDepartments(WebUtils
						.getCurrentLoggedUser().getEmployee()
						.getEstablishment().getCompany());
			}
		}

	}

	public void saveNew() throws AlmabaniException {

		operationFaild();
		boolean isAlreadyExisitEntity = Utils.hasID(selected);

		selected = almabaniFacade.addOrUpdateItem(
				selected,
				CommonDriverMap.appendCurrentUserCode(null,
						WebUtils.getCurrentUserCode()));
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

			filterByCompanyInCaseOnNoneAdminUser(filters);

			rowCount = almabaniFacade.getnumberOfItems(filters);

			result = (List<OamItem>) almabaniFacade.loadItems(first, pageSize,
					sortField, sortOrder == SortOrder.ASCENDING, filters);

			setRowCount(this.rowCount);

			return result;
		}

		private void filterByCompanyInCaseOnNoneAdminUser(
				Map<String, Object> filters) {
			if (WebUtils.isAdminUser() == false) {
				filters.put(
						"itemCategory.comDepartmentSection.department.company",
						WebUtils.getCurrentLoggedUser().getEmployee()
								.getEstablishment().getCompany());
			}

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
		passSelectedItemIntoProjectItemManagementBean(selected);
	}
	
	public void onRowUnselect(SelectEvent event) {  
		passSelectedItemIntoProjectItemManagementBean(null);

	}

	private void passSelectedItemIntoProjectItemManagementBean(OamItem selected2) {
		if (Utils.isNotNull(itemsControllerManagementBean)) {
			itemsControllerManagementBean.setSelectedItem(selected);
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

	public void initializeNewManufacturer() {
		manufacturer = new OamManufacturer();
		manufacturer
				.setIndActive(com.almabani.common.constant.DataAccessConstants.IND_ACTIVE);
		manufacturer.setCompany(WebUtils.getCurrentLoggedUser().getEmployee()
				.getEstablishment().getCompany());
	}

	public void initializeNewCategory() {
		oamItemCategory = new OamItemCategory();
		oamItemCategory.setIndActive(DataAccessConstants.IND_ACTIVE);
		departmentSections = almabaniFacade.getDepartmentSections(department);

	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public OamManufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(OamManufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public OamItemCategory getOamItemCategory() {
		return oamItemCategory;
	}

	public void setOamItemCategory(OamItemCategory oamItemCategory) {
		this.oamItemCategory = oamItemCategory;
	}

	public List<DepartmentSection> getDepartmentSections() {
		return departmentSections;
	}

	public void setDepartmentSections(List<DepartmentSection> departmentSections) {
		this.departmentSections = departmentSections;
	}

	public ItemsControllerManagementBean getItemsControllerManagementBean() {
		return itemsControllerManagementBean;
	}

	public void setItemsControllerManagementBean(
			ItemsControllerManagementBean itemsControllerManagementBean) {
		this.itemsControllerManagementBean = itemsControllerManagementBean;
	}

}
