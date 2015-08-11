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

import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.adminsec.ApplicationType;
import com.almabani.common.entity.schema.adminsec.SecApplication;
import com.almabani.common.entity.schema.adminsec.SecModule;
import com.almabani.common.entity.schema.adminsec.SecSubModule;
import com.almabani.common.entity.schema.adminsec.SecSystem;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class ApplicationManagementBean  extends AbstractBeanHelper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LazyDataModel<SecApplication> items;
	
	private List<SecSystem> sytems;
	
	private boolean operationSuccess = false;

		
	private List<SecModule> modules;
	private List<SecSubModule> subModules;
	private List<ApplicationType> applicationTypes; 
	private SecApplication selected;

	private SecModule tempModule;

	@PostConstruct
	public void init() {
		initializeItemsLazyList();
		loadInitialLists();
	}

	private void loadInitialLists() {
		modules = almabaniFacade.getAllModules();
		if(Utils.isNotEmptyList(modules))
		{
			tempModule = modules.get(0);
		}
		applicationTypes = almabaniFacade.getAllApplicationTypes();
	}

	private void initializeItemsLazyList() {
		items = new ItemsLazyList();
	}

	
	public void prepareCreate() {
		   selected = new SecApplication();
	}

	public void saveNew() throws AlmabaniException {

		operationFaild();
		boolean isAlreadyExisitEntity = Utils.isNotEmptyString(selected.getCodApplication());
		
		selected = almabaniFacade.addOrUpdateApplication(selected, CommonDriverMap.appendCurrentUserCode(null, WebUtils.getCurrentUserCode()));
		WebUtils.fireInfoMessage(
				(isAlreadyExisitEntity) ? MessagesKeyStore.ALMABANI_GENERAL_UPDATED_SUCCESSFULLY
						: MessagesKeyStore.ALMABANI_GENERAL_ADDED_SUCCESSFULLY,
				WebUtils.prepareParamSet(MessagesKeyStore.ALMABANI_GENERAL_MODULE));
		
		operationSucceded();

	}
	
	
	public void moduleChanged(AjaxBehaviorEvent event)
	{
		tempModule = (SecModule) ((SelectOneMenu)event.getSource()).getValue();
		
		loadSubModules();
	}

	private void loadSubModules() {
		if(Utils.isNotNull(tempModule))
	 	{ 
			subModules = almabaniFacade.getSubModules(tempModule);
		}else
		{
			subModules = new ArrayList(); 
		}		
	}

	private class ItemsLazyList extends LazyDataModel<SecApplication> implements
			Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Integer rowCount;

		List<SecApplication> result;

		@Override
		public List<SecApplication> load(int first, int pageSize, String sortField,
				SortOrder sortOrder, Map<String, Object> filters) {
			rowCount = almabaniFacade.getNumberOfApplications(filters);

			result = (List<SecApplication>) almabaniFacade.loadApplications(first,
					pageSize, sortField, sortOrder == SortOrder.ASCENDING,
					filters);

			setRowCount(this.rowCount);

			return result;
		}

		@Override
		public SecApplication getRowData(String rowKey) {

			for (SecApplication module : result) {
				if (module.getCodApplication().toString().equals(rowKey)) {
					selected = module;
					return module;
				}
			}

			return null; 
		}

	}
	
	public void loadApproperateModule()
	{
		if(Utils.isNotNull(selected.getSecSubModule()))
		{
			tempModule = selected.getSecSubModule().getModule(); 
			loadSubModules(); 
		}
	}
	
	

	public LazyDataModel<SecApplication> getItems() {
		return items;
	}

	public void setItems(LazyDataModel<SecApplication> items) {
		this.items = items;
	}

	public SecApplication getSelected() {
		return selected;
	}

	public void setSelected(SecApplication selected) {
		this.selected = selected;
	}

	public void onRowSelect(SelectEvent event) {
		selected = (SecApplication) event.getObject();
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

	public List<SecSubModule> getSubModules() {
		return subModules;
	}

	public void setSubModules(List<SecSubModule> subModules) {
		this.subModules = subModules;
	}

	public List<ApplicationType> getApplicationTypes() {
		return applicationTypes;
	}

	public void setApplicationTypes(List<ApplicationType> applicationTypes) {
		this.applicationTypes = applicationTypes;
	}

	public SecModule getTempModule() {
		return tempModule;
	}

	public void setTempModule(SecModule tempModule) {
		this.tempModule = tempModule;
	}


}
