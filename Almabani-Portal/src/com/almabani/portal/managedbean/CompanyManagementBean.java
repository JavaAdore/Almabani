package com.almabani.portal.managedbean;

import java.io.Serializable;
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

import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Country;
import com.almabani.common.entity.schema.admincor.State;
import com.almabani.common.entity.schema.admincor.StateId;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class CompanyManagementBean extends AbstractBeanHelper implements
		Serializable {
	private static final long serialVersionUID = 1L;

	private LazyDataModel<Company> items;

	private List<Company> myItemms;

	private boolean operationSuccess = false;

	public List<Company> getMyItemms() {
		return myItemms;
	}

	public void setMyItemms(List<Company> myItemms) {
		this.myItemms = myItemms;
	}

	private Company selected;

	private List<State> states;

	@PostConstruct
	public void init() {
		initializeCompaniesLazyList();
		prepareCreate();
		prepareStatesList();
	}

	private void initializeCompaniesLazyList() {
		items = new ComanyLazyDataModel();
	}

	private void prepareStatesList() {
		List<Country> countries = getApplicationScopeStore().getCountries();
		if (Utils.isNotEmptyList(countries)) {
			setCurrentStateList(countries.get(0));
		}

	}

	public void countryChanged(AjaxBehaviorEvent event) {
			Country country = (Country) ((SelectOneMenu) event.getSource())
				.getValue();

		setCurrentStateList(country);
	}

	private void setCurrentStateList(Country country) {

		states = getApplicationScopeStore().getStatesListByCountry(country);
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public void prepareCreate() {
		selected = new Company();
		State state = new State();
		state.setStateId(new StateId());
		selected.setState(state);   
	}

	public void saveNew() throws AlmabaniException {

		operationFaild(); 
		boolean isAlreadyExisitEntity = Utils.hasID(selected);
		CommonDriverMap commonDriverMap = new CommonDriverMap();
		commonDriverMap.appendTargetUser(commonDriverMap, WebUtils.getCurrentLoggedUser());
		selected = almabaniFacade.addCompany(selected,commonDriverMap);
		WebUtils.fireInfoMessage(
				(isAlreadyExisitEntity) ? MessagesKeyStore.ALMABANI_GENERAL_UPDATED_SUCCESSFULLY
						: MessagesKeyStore.ALMABANI_GENERAL_ADDED_SUCCESSFULLY,
				WebUtils.prepareParamSet(MessagesKeyStore.ALMABANI_GENERAL_COMPANY));
		operationSucceded();

	}

	private class ComanyLazyDataModel extends LazyDataModel<Company> implements
			Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Integer rowCount;

		List<Company> result;

		@Override
		public List<Company> load(int first, int pageSize, String sortField,
				SortOrder sortOrder, Map<String, Object> filters) {
			rowCount = almabaniFacade.getCountOfCompany(filters);

			result = (List<Company>) almabaniFacade.loadCompanies(first,
					pageSize, sortField, sortOrder == SortOrder.ASCENDING,
					filters);

			setRowCount(this.rowCount);

			return result;
		}

		@Override
		public Company getRowData(String rowKey) {

			for (Company company : result) {
				if (company.getId().toString().equals(rowKey)) {
					selected = company;
					return company;
				}
			}

			return null;
		}

	}
	
	
	public void edit() throws AlmabaniException
	{
		if(selected==null || selected.getId()==null ||selected.getId().intValue()==0)
		{
			throw new AlmabaniException("ALMABANI_VIEW_SELECT_COMPANY_FIRST");
		}
		WebUtils.invokeJavaScriptFunction("PF('editDialog').show()");
	}
	
	public void view() throws AlmabaniException
	{
		if(selected==null || selected.getId()==null ||selected.getId().intValue()==0)
		{
			throw new AlmabaniException("ALMABANI_VIEW_SELECT_COMPANY_FIRST");
		}
		WebUtils.invokeJavaScriptFunction("PF('viewDialog').show()");
	}
	
	

	public LazyDataModel<Company> getItems() {
		return items;
	}

	public void setItems(LazyDataModel<Company> items) {
		this.items = items;
	}

	public Company getSelected() {
		return selected;
	}

	public void setSelected(Company selected) {
		this.selected = selected;
	}

	public void onRowSelect(SelectEvent event) {
		selected = (Company) event.getObject();
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

}
