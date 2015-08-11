package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.admincor.Project;
import com.almabani.common.entity.schema.adminoam.OamItem;
import com.almabani.common.entity.schema.adminoam.OamProjectItem;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class ProjectItemManagementBean extends AbstractBeanHelper implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LazyDataModel<OamProjectItem> items;


	private boolean operationSuccess = false;
	private List<Project> projects;
	private List<OamItem> oamItems;

	private OamProjectItem selected;

	@PostConstruct
	public void init() {
		initializeCompaniesLazyList();
		loadInitialLists();
		
		prepareStatesList();
	}

	public void prepareCreate() {

		selected = new OamProjectItem();
	}

	private void loadInitialLists() {
		projects = almabaniFacade.getAllProjects();
		oamItems = almabaniFacade.getAllItems();
	}

	private void initializeCompaniesLazyList() {
		items = new QuotationItemLazyModel();

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

	private void operationSuccess() {
		operationSuccess = true;
	}

	private void operationFaild() {
		operationSuccess = false;
	}


	private class QuotationItemLazyModel extends LazyDataModel<OamProjectItem>
			implements Serializable {
		/**
 * 
 */
		private static final long serialVersionUID = 1L;
		private Integer rowCount;

		List<OamProjectItem> result;

		@Override
		public List<OamProjectItem> load(int first, int pageSize,
				String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {
			rowCount = almabaniFacade.getNumberOfProjectItems(filters);
			result = (List<OamProjectItem>) almabaniFacade.loadProjectItems(
					first, pageSize, sortField,
					sortOrder == SortOrder.ASCENDING, filters);

			setRowCount(this.rowCount);

			return result;
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

	}

	public LazyDataModel<OamProjectItem> getItems() {
		return items;
	}

	public void setItems(LazyDataModel<OamProjectItem> items) {
		this.items = items;
	}

	public OamProjectItem getSelected() {
		return selected;
	}

	public void setSelected(OamProjectItem selected) {
		this.selected = selected;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<OamItem> getOamItems() {
		return oamItems;
	}

	public void setOamItems(List<OamItem> oamItems) {
		this.oamItems = oamItems;
	}

	

}
