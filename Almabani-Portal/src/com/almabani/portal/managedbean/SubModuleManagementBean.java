package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminsec.SecModule;
import com.almabani.common.entity.schema.adminsec.SecSubModule;
import com.almabani.common.entity.schema.adminsec.SecSystem;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class SubModuleManagementBean extends AbstractBeanHelper implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LazyDataModel<SecSubModule> items;

	private List<SecSystem> sytems;

	private boolean operationSuccess = false;

	private List<SecModule> modules;

	private SecSubModule selected;

	@PostConstruct
	public void init() {
		initializeItemsLazyList();
		loadInitialLists();
	}

	private void loadInitialLists() {
		if(WebUtils.isAdminUser()){
			sytems = almabaniFacade.getAllSystems();
			modules = almabaniFacade.getAllModules();
		}else
		{
			Company company = WebUtils.getCurrentLoggedUser().getEmployee().getEstablishment().getCompany();
			sytems = almabaniFacade.getAllSystems(company);
			modules = almabaniFacade.getAllModules(company) ; 
		}
	}

	private void initializeItemsLazyList() {
		items = new ItemsLazyList();
	}

	public void prepareCreate() {
		selected = new SecSubModule();
	}

	public void saveNew() throws AlmabaniException {

		operationFaild();
		boolean isAlreadyExisitEntity = Utils.hasID(selected);

		selected = almabaniFacade.addOrUpdateSubModule(
				selected,
				CommonDriverMap.appendCurrentUserCode(null,
						WebUtils.getCurrentUserCode()));
		WebUtils.fireInfoMessage(
				(isAlreadyExisitEntity) ? MessagesKeyStore.ALMABANI_GENERAL_UPDATED_SUCCESSFULLY
						: MessagesKeyStore.ALMABANI_GENERAL_ADDED_SUCCESSFULLY,
				WebUtils.prepareParamSet(MessagesKeyStore.ALMABANI_GENERAL_SUB_MODULE));

		operationSucceded();

	}

	private class ItemsLazyList extends LazyDataModel<SecSubModule> implements
			Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Integer rowCount;

		List<SecSubModule> result;

		@Override
		public List<SecSubModule> load(int first, int pageSize,
				String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {

			attachCompanyFiltrationInCaseOfNoneAdmin(filters);

			rowCount = almabaniFacade.getNumberOfSubModules(filters);

			result = (List<SecSubModule>) almabaniFacade.loadSubModules(first,
					pageSize, sortField, sortOrder == SortOrder.ASCENDING,
					filters);

			setRowCount(this.rowCount);

			return result;
		}

		private void attachCompanyFiltrationInCaseOfNoneAdmin(
				Map<String, Object> filters) {
			if (WebUtils.isAdminUser() == false) {
				filters.put("module.system.company", WebUtils
						.getCurrentLoggedUser().getEmployee()
						.getEstablishment().getCompany());
			}

		}

		@Override
		public SecSubModule getRowData(String rowKey) {

			for (SecSubModule module : result) {
				if (module.getId().toString().equals(rowKey)) {
					selected = module;
					return module;
				}
			}

			return null;
		}

	}

	public LazyDataModel<SecSubModule> getItems() {
		return items;
	}

	public void setItems(LazyDataModel<SecSubModule> items) {
		this.items = items;
	}

	public SecSubModule getSelected() {
		return selected;
	}

	public void setSelected(SecSubModule selected) {
		this.selected = selected;
	}

	public void onRowSelect(SelectEvent event) {
		selected = (SecSubModule) event.getObject();
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

	public List<SecSystem> getSytems() {
		return sytems;
	}

	public void setSytems(List<SecSystem> sytems) {
		this.sytems = sytems;
	}

	public List<SecModule> getModules() {
		return modules;
	}

	public void setModules(List<SecModule> modules) {
		this.modules = modules;
	}

}
