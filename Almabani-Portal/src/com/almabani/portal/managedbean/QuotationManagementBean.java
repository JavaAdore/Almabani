package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.admincor.Country;
import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.common.entity.schema.admincor.State;
import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.common.entity.schema.adminoam.OamQuotationAction;
import com.almabani.common.entity.schema.adminoam.OamQuotationActionType;
import com.almabani.common.entity.schema.adminwkf.WokDemand;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.common.interfaces.QuotataionHolder;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class QuotationManagementBean  extends AbstractBeanHelper implements QuotataionHolder , Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LazyDataModel<OamQuotation> items;


	private boolean operationSuccess = false;

private List<Department> departments;

	private OamQuotation selected;

	private List<State> states;
	
	private List<WokDemand> wokDemands;
	
	
	@ManagedProperty(value = "#{quotationQuotationItemManagementBean}")
	QuotationQuotationItemManagementBean quotationQuotationItemManagementBean;

	@PostConstruct
	public void init() {
		initializeCompaniesLazyList();
		loadInitialLists();
		prepareStatesList();
	}

	private void loadInitialLists() {
		departments = almabaniFacade.getDepartments();
		wokDemands = almabaniFacade.getWokDemands();
		
	}

	private void initializeCompaniesLazyList() {
		items = new QuotationLazyModel();
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
		   selected = new OamQuotation();
	}

	public void saveNew() throws AlmabaniException {

		operationFaild();
		boolean isAlreadyExisitEntity = Utils.hasID(selected);
		
		selected = almabaniFacade.addOrUpdateQuotation(selected, CommonDriverMap.appendCurrentUserCode(null, WebUtils.getCurrentUserCode()));
		WebUtils.fireInfoMessage(
				(isAlreadyExisitEntity) ? MessagesKeyStore.ALMABANI_GENERAL_UPDATED_SUCCESSFULLY
						: MessagesKeyStore.ALMABANI_GENERAL_ADDED_SUCCESSFULLY,
				WebUtils.prepareParamSet(MessagesKeyStore.ALMABANI_GENERAL_QUOTATION));
		quotationQuotationItemManagementBean.setQuotation(selected);
		attachAvailableActionTypes();    
		operationSucceded();

	}

	private class QuotationLazyModel extends LazyDataModel<OamQuotation> implements
			Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Integer rowCount;

		List<OamQuotation> result;

		@Override
		public List<OamQuotation> load(int first, int pageSize, String sortField,
				SortOrder sortOrder, Map<String, Object> filters) {
			rowCount = almabaniFacade.getNumberOfQoutations(filters);

			result = (List<OamQuotation>) almabaniFacade.loadQoutations(first,
					pageSize, sortField, sortOrder == SortOrder.ASCENDING,
					filters);

			setRowCount(this.rowCount);

			return result;
		}

		@Override
		public OamQuotation getRowData(String rowKey) {

			for (OamQuotation qoutation : result) {
				if (qoutation.getId().toString().equals(rowKey)) {
					selected = qoutation;
					return qoutation;
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
	
	

	public LazyDataModel<OamQuotation> getItems() {
		return items;
	}

	public void setItems(LazyDataModel<OamQuotation> items) {
		this.items = items;
	}

	public OamQuotation getSelected() {
		return selected;
	}

	public void setSelected(OamQuotation selected) {
		this.selected = selected;
		quotationQuotationItemManagementBean.setQuotation(selected);
		attachAvailableActionTypes();  
	}

	public void onRowSelect(SelectEvent event) {  
		selected = (OamQuotation) event.getObject();
	}
	
	public void attachAvailableActionTypes()
	{
		
		 List<OamQuotationActionType> availableActionTypes = almabaniFacade.getAvailableQuotationActionTypes(selected);
		 selected.setAvailableActionTypes(availableActionTypes);   
		 if(Utils.isNotNull(selected.getQuotataionActions())){
		 selected.setSelectedActionType(selected.getQuotataionActions().get(selected.getQuotataionActions().size()-1).getOamTypesQuotActions());
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

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public List<WokDemand> getWokDemands() {
		return wokDemands;
	}

	public void setWokDemands(List<WokDemand> wokDemands) {
		this.wokDemands = wokDemands;
	}

	@Override
	public OamQuotation getCurrentQuotation() {
		return selected;
	}

	public QuotationQuotationItemManagementBean getQuotationQuotationItemManagementBean() {
		return quotationQuotationItemManagementBean;
	}

	public void setQuotationQuotationItemManagementBean(
			QuotationQuotationItemManagementBean quotationQuotationItemManagementBean) {
		this.quotationQuotationItemManagementBean = quotationQuotationItemManagementBean;
	}

	
	 public void onRowEdit(RowEditEvent event) {
	       
		 selected = (OamQuotation) event.getObject();
		
		 
	    }
	
	    
}
