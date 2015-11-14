package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.common.entity.schema.admincor.Establishment;
import com.almabani.common.entity.schema.adminoam.OamItemQuotation;
import com.almabani.common.entity.schema.adminoam.OamProjectItem;
import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean(eager = true)
@ViewScoped
public class QuotationItemManagementBean extends AbstractBeanHelper implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LazyDataModel<OamItemQuotation> items;

	private OamQuotation parentQuotation;

	private boolean operationSuccess = false;

	private OamItemQuotation selected;
	private List<OamQuotation> oamQuotataions;
	private List<OamProjectItem> projectItems;

	QuotationApplicationController quotationApplicationController;

	private List<Establishment> establishments;

	@PostConstruct
	public void init() {
		loadQuotationItemLazyList();
		loadInitialLists();
	}

	public void prepareCreate() {

		selected = new OamItemQuotation();
		selected.setQuotation(parentQuotation);
	}

	private void loadInitialLists() {
		loadQuotationList();
		loadEstablishmentsList();
	}

	private void loadEstablishmentsList() {
		if (WebUtils.isAdminUser()) {
			establishments = almabaniFacade.getAllEstablishments();
		} else {
			establishments = almabaniFacade.getAllEstablishments(WebUtils
					.getCurrentLoggedUserCompany());

		}
	}

	private void loadQuotationList() {
		if (WebUtils.isAdminUser()) {
			oamQuotataions = almabaniFacade.getAllQuotations();
		} else {
			Company company = WebUtils.getCurrentLoggedUser().getEmployee()
					.getEstablishment().getCompany();
			oamQuotataions = almabaniFacade.getAllQuotations(company);
		}

	}

	private void loadQuotationItemLazyList() {
		items = new QuotationItemLazyModel();

	}

	public List<OamProjectItem> autoCompleteProjectItemList(
			String projectItemNameOrDescription) {

		projectItemNameOrDescription = Utils
				.isNotEmptyString(projectItemNameOrDescription) ? projectItemNameOrDescription
				: "";
		projectItems = almabaniFacade.getAllProjectItems(
				projectItemNameOrDescription, selected.getQuotation()
						.getDepartment());
		return projectItems;

	}

	public void saveNew() throws AlmabaniException {

		operationFaild();
		boolean isAlreadyExisitEntity = Utils.hasID(selected);

		selected = almabaniFacade.addOrUpdateQuotationItem(
				selected,
				CommonDriverMap.appendCurrentUserCode(null,
						WebUtils.getCurrentUserCode()));
		WebUtils.fireInfoMessage(
				(isAlreadyExisitEntity) ? MessagesKeyStore.ALMABANI_GENERAL_UPDATED_SUCCESSFULLY
						: MessagesKeyStore.ALMABANI_GENERAL_ADDED_SUCCESSFULLY,
				WebUtils.prepareParamSet(MessagesKeyStore.ALMABANI_GENERAL_QUOTATION));
		quotationApplicationController.setOamItemQuotation(selected);
		quotationApplicationController.refreshQuotationItemList();
		operationSuccess();

	}

	private void operationSuccess() {
		operationSuccess = true;
	}

	private void operationFaild() {
		operationSuccess = false;
	}

	public OamQuotation getParentQuotation() {
		return parentQuotation;
	}

	public void setParentQuotation(OamQuotation parentQuotation) {
		this.parentQuotation = parentQuotation;
		if (Utils.isNull(selected)) {
			selected = new OamItemQuotation();
		}
		selected.setQuotation(parentQuotation);

	}

	private class QuotationItemLazyModel extends
			LazyDataModel<OamItemQuotation> implements Serializable {

		private static final long serialVersionUID = 1L;
		private Integer rowCount;

		List<OamItemQuotation> result;

		@Override
		public List<OamItemQuotation> load(int first, int pageSize,
				String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {

			if (Utils.isNotNull(parentQuotation)) {
				filters.put("quotation", parentQuotation);
				rowCount = almabaniFacade.getNumberOfOamItemQuotations(filters);
				setRowCount(this.rowCount);

				return result = (List<OamItemQuotation>) almabaniFacade
						.loadItemQuotataions(first, pageSize, sortField,
								sortOrder == SortOrder.ASCENDING, filters);

			} else {
				return new ArrayList();
			}
		}

		private void injectCompanyInCaseOfNoneAdminUser(
				Map<String, Object> filters) {
			if (WebUtils.isAdminUser() == false) {
				filters.put("quotation.department.company", WebUtils
						.getCurrentLoggedUser().getEmployee()
						.getEstablishment().getCompany());
			}

		}

		private void injcetParentQuotationIfExisit(Map<String, Object> filters) {

		}

		@Override
		public OamItemQuotation getRowData(String rowKey) {

			for (OamItemQuotation qoutation : result) {
				if (qoutation.getId().toString().equals(rowKey)) {
					selected = qoutation;

					return qoutation;
				}
			}

			return null;
		}

	}

	public LazyDataModel<OamItemQuotation> getItems() {
		return items;
	}

	public void setItems(LazyDataModel<OamItemQuotation> items) {
		this.items = items;
	}

	public OamItemQuotation getSelected() {
		return selected;
	}

	public void setSelected(OamItemQuotation selected) {
		this.selected = selected;
		quotationApplicationController.setOamItemQuotation(selected);

	}

	public List<OamQuotation> getOamQuotataions() {
		return oamQuotataions;
	}

	public void setOamQuotataions(List<OamQuotation> oamQuotataions) {
		this.oamQuotataions = oamQuotataions;
	}

	public List<OamProjectItem> getProjectItems() {
		return projectItems;
	}

	public void setProjectItems(List<OamProjectItem> projectItems) {
		this.projectItems = projectItems;
	}

	public QuotationApplicationController getQuotationApplicationController() {
		return quotationApplicationController;
	}

	public void setQuotationApplicationController(
			QuotationApplicationController quotationApplicationController) {
		this.quotationApplicationController = quotationApplicationController;
	}

	public void selectedQuotationChanged(AjaxBehaviorEvent event) {
		parentQuotation = (OamQuotation) ((SelectOneMenu) event.getSource())
				.getValue();
		if (Utils.isNotNull(parentQuotation)
				&& Utils.isNotNull(selected.getQuotation())
				&& Utils.isNotNull(selected.getProjectItem())) {
			Department selectedProjectItemDepartment = selected
					.getProjectItem().getItem().getItemCategory()
					.getComDepartmentSection().getDepartment();
			if (selectedProjectItemDepartment.equals(parentQuotation
					.getDepartment()) == false) {
				selected.setProjectItem(null);
			}
		}
	}

	public void selectedQuotationItemChagned(SelectEvent event) {
		OamItemQuotation oamItemQuotation = (OamItemQuotation) event.getObject(); 
		quotationApplicationController.getOamItemsQuotSupplierManagementBean().setParentQuotationItem(oamItemQuotation);
		quotationApplicationController.getOamItemsQuotSupplierManagementBean().loadOamItemSupplierLazyModel();
		WebUtils.invokeJavaScriptFunction("updateListForm()");
	}

	public void refreshQuotationList() {
		loadQuotationList();

	}

	public List<Establishment> getEstablishments() {
		return establishments;
	}

	public void setEstablishments(List<Establishment> establishments) {
		this.establishments = establishments;
	}
}
