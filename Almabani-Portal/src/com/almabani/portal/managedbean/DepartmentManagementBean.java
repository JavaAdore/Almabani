package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class DepartmentManagementBean extends AbstractBeanHelper implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LazyDataModel<Department> items;

	private List<Company> companies;

	private OamQuotation parentQuotation;

	private boolean operationSuccess = false;

	private Department selected;

	@PostConstruct
	public void init() {
		initializeSupplierssLazyList();
		loadInitialLists();

		prepareStatesList();
	}

	public void prepareCreate() {

		selected = new Department();
	}

	private void loadInitialLists() {
		if (WebUtils.getCurrentLoggedUser().isAdminUser()) {
			companies = almabaniFacade.getAllCompanies();
		} else {
			companies = new ArrayList();
			companies.add(WebUtils.getCurrentLoggedUser().getEmployee()
					.getEstablishment().getCompany());
		}

	}

	private void initializeSupplierssLazyList() {
		items = new QuotationItemLazyModel();

	}

	private void prepareStatesList() {

	}

	public void saveNew() throws AlmabaniException {

		operationFaild();
		boolean isAlreadyExisitEntity = Utils.hasID(selected);

		selected = almabaniFacade.addOrUpdate(
				selected,
				CommonDriverMap.appendCurrentUserCode(null,
						WebUtils.getCurrentUserCode()));
		WebUtils.fireInfoMessage(
				(isAlreadyExisitEntity) ? MessagesKeyStore.ALMABANI_GENERAL_UPDATED_SUCCESSFULLY
						: MessagesKeyStore.ALMABANI_GENERAL_ADDED_SUCCESSFULLY,
				WebUtils.prepareParamSet(MessagesKeyStore.ALMABANI_GENERAL_DEPARTMENT));

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
	}

	private class QuotationItemLazyModel extends LazyDataModel<Department>
			implements Serializable {
		/**
 * 
 */
		private static final long serialVersionUID = 1L;
		private Integer rowCount;

		List<Department> result;

		@Override
		public List<Department> load(int first, int pageSize, String sortField,
				SortOrder sortOrder, Map<String, Object> filters) {

			injectCompanyInCaseOfNormalUser(filters);

			rowCount = almabaniFacade.getNumberOfDepartments(filters);

			result = (List<Department>) almabaniFacade.loadDepartments(first,
					pageSize, sortField, sortOrder == SortOrder.ASCENDING,
					filters);

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

		private void injcetParentQuotationIfExisit(Map<String, Object> filters) {

			if (Utils.isNotNull(parentQuotation)) {
				filters.put("quotation", parentQuotation);
			}
		}

		@Override
		public Department getRowData(String rowKey) {

			for (Department qoutation : result) {
				if (qoutation.getId().toString().equals(rowKey)) {
					selected = qoutation;
					return qoutation;
				}
			}

			return null;
		}

	}

	public LazyDataModel<Department> getItems() {
		return items;
	}

	public void setItems(LazyDataModel<Department> items) {
		this.items = items;
	}

	public Department getSelected() {
		return selected;
	}

	public void setSelected(Department selected) {
		this.selected = selected;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

}
