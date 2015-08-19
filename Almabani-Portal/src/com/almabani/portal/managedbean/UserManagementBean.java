package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Employee;
import com.almabani.common.entity.schema.adminsec.SecUser;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class UserManagementBean extends AbstractBeanHelper implements
		Serializable {
	private static final long serialVersionUID = 1L;

	private LazyDataModel<SecUser> items;

	private List<Employee> employees;

	private List<Company> companies;
	
	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	private boolean operationSuccess = false;

	private SecUser selected;

	@PostConstruct
	public void init() {
		initializeUsersLazyList();
		initializeEmployeesList();
		initializeCompaniesList();

	}

	private void initializeCompaniesList() {
		companies = almabaniFacade.getAllCompanies();		
	}

	private void initializeEmployeesList() {
		employees = almabaniFacade.getAllEmployees();
	}

	private void initializeUsersLazyList() {
		items = new UserLazyDataModel();
	}

	public void prepareCreate() {
		selected = new SecUser();

	}

	public void saveNew() throws AlmabaniException {

		operationFaild();
		boolean isAlreadyExisitEntity = Utils.isNotEmptyString(selected
				.getUserLoginCode());

		selected = almabaniFacade.addorUpdateUser(
				selected,
				CommonDriverMap.appendCurrentUserCode(null,
						WebUtils.getCurrentUserCode()));
		WebUtils.fireInfoMessage(
				(isAlreadyExisitEntity) ? MessagesKeyStore.ALMABANI_GENERAL_UPDATED_SUCCESSFULLY
						: MessagesKeyStore.ALMABANI_GENERAL_ADDED_SUCCESSFULLY,
				WebUtils.prepareParamSet(MessagesKeyStore.ALMABANI_GENERAL_USER));
		operationSucceded();

	}

	private class UserLazyDataModel extends LazyDataModel<SecUser> implements
			Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Integer rowCount;

		List<SecUser> result;

		@Override
		public List<SecUser> load(int first, int pageSize, String sortField,
				SortOrder sortOrder, Map<String, Object> filters) {
			rowCount = almabaniFacade.getCountOfUsers(filters);

			result = (List<SecUser>) almabaniFacade.loadUsers(first, pageSize,
					sortField, sortOrder == SortOrder.ASCENDING, filters);

			setRowCount(this.rowCount);

			return result;
		}

		@Override
		public SecUser getRowData(String rowKey) {

			for (SecUser SecUser : result) {
				if (SecUser.getUserLoginCode().equals(rowKey)) {
					selected = SecUser;
					return SecUser;
				}
			}

			return null;
		}

	}

	public LazyDataModel<SecUser> getItems() {
		return items;
	}

	public void setItems(LazyDataModel<SecUser> items) {
		this.items = items;
	}

	public SecUser getSelected() {
		return selected;
	}

	public void setSelected(SecUser selected) {
		this.selected = selected;
	}

	public void onRowSelect(SelectEvent event) {
		selected = (SecUser) event.getObject();
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
 
	public void onRowEdit(RowEditEvent event) throws AlmabaniException {
		try {
			saveNew(); 
		} catch (AlmabaniException ex) {
			initializeEmployeesList();
			 
			throw ex;   
		} 
	}

	public void onRowCancel(RowEditEvent event) {

		System.out.println();

	}

	public void onCellEdit(CellEditEvent event) {
		System.out.println();

	} 

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
