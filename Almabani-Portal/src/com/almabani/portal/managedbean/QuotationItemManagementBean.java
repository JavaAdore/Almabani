package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.adminoam.OamItemQuotation;
import com.almabani.common.entity.schema.adminoam.OamProjectItem;
import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
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
	
	@ManagedProperty(value = "#{quotationQuotationItemManagementBean}")
	QuotationQuotationItemManagementBean quotationQuotationItemManagementBean;
	

	@PostConstruct
	public void init() {
		initializeCompaniesLazyList();
		loadInitialLists();
		prepareStatesList();
		quotationQuotationItemManagementBean.setQuotationItemManagementBean(this);
	}

	public	 void prepareCreate() {

		selected = new OamItemQuotation();  
	}

	private void loadInitialLists() {
		items = new QuotationItemLazyModel();
		oamQuotataions = almabaniFacade.getAllQuotations();
		projectItems = almabaniFacade.getAllProjectItems();
	}

	private void initializeCompaniesLazyList() {

	}

	private void prepareStatesList() {

	}

	public void saveNew() throws AlmabaniException {

		 operationFaild();
		 boolean isAlreadyExisitEntity = Utils.hasID(selected);

		 selected = almabaniFacade.addOrUpdateQuotationItem(selected,
		 CommonDriverMap.appendCurrentUserCode(null,
		 WebUtils.getCurrentUserCode()));
		 WebUtils.fireInfoMessage(
		 (isAlreadyExisitEntity) ?
		 MessagesKeyStore.ALMABANI_GENERAL_UPDATED_SUCCESSFULLY
		 : MessagesKeyStore.ALMABANI_GENERAL_ADDED_SUCCESSFULLY,
		 WebUtils.prepareParamSet(MessagesKeyStore.ALMABANI_GENERAL_QUOTATION));
		
		 operationSuccess();

	}

	private void operationSuccess() {
		operationSuccess = true;		
	}

	private void operationFaild() {
		operationSuccess=false;
	}

	public OamQuotation getParentQuotation() {
		return parentQuotation;
	}

	public void setParentQuotation(OamQuotation parentQuotation) {
		this.parentQuotation = parentQuotation;
		selected.setQuotation(parentQuotation); 
		
	}

	private class QuotationItemLazyModel extends LazyDataModel<OamItemQuotation>
			implements Serializable {
		/**
 * 
 */
		private static final long serialVersionUID = 1L;
		private Integer rowCount;

		List<OamItemQuotation> result;

		@Override
		public List<OamItemQuotation> load(int first, int pageSize,
				String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {
			
			injcetParentQuotationIfExisit(filters);
			rowCount = almabaniFacade.getNumberOfOamItemQuotations(filters);
			result = (List<OamItemQuotation>) almabaniFacade.loadItemQuotataions(first,
					pageSize, sortField, sortOrder == SortOrder.ASCENDING,
					filters);

			setRowCount(this.rowCount);

			return result;
		}

		private void injcetParentQuotationIfExisit(Map<String, Object> filters) {


			if(Utils.isNotNull(parentQuotation))
			{
				filters.put("quotation", parentQuotation);
			}
		}

		@Override
		public OamItemQuotation getRowData(String rowKey) {

			for (OamItemQuotation  qoutation : result) {
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

	public QuotationQuotationItemManagementBean getQuotationQuotationItemManagementBean() {
		return quotationQuotationItemManagementBean;
	}

	public void setQuotationQuotationItemManagementBean(
			QuotationQuotationItemManagementBean quotationQuotationItemManagementBean) {
		this.quotationQuotationItemManagementBean = quotationQuotationItemManagementBean;
	}

}
