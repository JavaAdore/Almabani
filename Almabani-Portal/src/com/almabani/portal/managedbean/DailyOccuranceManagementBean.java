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

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.OamZoneDevice;
import com.almabani.common.entity.schema.adminsec.SecUser;
import com.almabani.common.entity.schema.adminwkf.WokDailyOcurrence;
import com.almabani.common.entity.schema.adminwkf.WokOccurrenceType;
import com.almabani.common.entity.schema.adminwkf.WokUserGroup;
import com.almabani.common.entity.schema.adminwkf.WokWorkingGroup;
import com.almabani.common.entity.schema.adminwkf.view.WokDailyOcurrencesView;
import com.almabani.common.entity.schema.adminwkf.view.WokWorkingGroupsListView;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class DailyOccuranceManagementBean extends AbstractBeanHelper implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WokWorkingGroupsListView selectedWokGroup;
	private List<WokWorkingGroupsListView> wokDailyIccurrencesViewRecords;
	private LazyDataModel<WokDailyOcurrencesView> wokDailyOccurencyLazyModel;
	private WokDailyOcurrencesView selectedWokDailyOcurrencesView;
	private WokDailyOcurrence selectedWokDailyOcurrence;
	
	
	
	private List<WokOccurrenceType> occurencyTypeList;
	private List<WokUserGroup> operatorsList;
	private List<WokUserGroup> commuincatorsList;
	private List<WokUserGroup> safetyAgentsList;
	private List<WokUserGroup> techniciansList;
	
	private List<OamZoneDevice> cameras;

	
	
	
	@PostConstruct 
	public void init() {

		wokDailyIccurrencesViewRecords = almabaniFacade
				.getWokDailyIccurrencesViewRecords(WebUtils
						.getCurrentUserCode());

		if (Utils.isNotEmptyList(wokDailyIccurrencesViewRecords)
				&& wokDailyIccurrencesViewRecords.size() == 1) {
			selectedWokGroup = wokDailyIccurrencesViewRecords.get(0);
			workGroupRowSelected(selectedWokGroup);
		}
		 
		loadInitialLists();
		initializeWokDailyOccurencyLazyModel();

	}

	private void loadInitialLists() {

		loadOccurencyTypeList();
		
		
	}
	
	
	public void workGroupRowSelected(WokWorkingGroupsListView selectedWokGroup)
	{
		Company company = WebUtils.getCurrentLoggedUserCompany();
		SecUser secUser = WebUtils.getCurrentLoggedUser();
		operatorsList = almabaniFacade.getOperators(company, new WokWorkingGroup(selectedWokGroup.getNumWorkingGroup()) ,secUser);
		commuincatorsList = almabaniFacade.getCommuincators(company,new WokWorkingGroup(selectedWokGroup.getNumWorkingGroup()),secUser);
		safetyAgentsList = almabaniFacade.getSafetyAgents(company,new WokWorkingGroup(selectedWokGroup.getNumWorkingGroup()),secUser);
		techniciansList = almabaniFacade.getTechnicians(company,new WokWorkingGroup(selectedWokGroup.getNumWorkingGroup()),secUser);
		cameras =  almabaniFacade.getCamDevicesWithAssociatedLocations();
		System.out.println();
	}

	private void loadOccurencyTypeList() {
		occurencyTypeList = almabaniFacade.getWokOccurrenceTypeList(WebUtils.getCurrentLoggedUserCompany());
	}

	public void initializeWokDailyOccurencyLazyModel() {
		wokDailyOccurencyLazyModel = new WokDailyoccurenceLazyModel();
	}

	public List<WokWorkingGroupsListView> getWokDailyIccurrencesViewRecords() {
		return wokDailyIccurrencesViewRecords;
	}

	public void setWokDailyIccurrencesViewRecords(
			List<WokWorkingGroupsListView> wokDailyIccurrencesViewRecords) {
		this.wokDailyIccurrencesViewRecords = wokDailyIccurrencesViewRecords;
	}

	private class WokDailyoccurenceLazyModel extends
			LazyDataModel<WokDailyOcurrencesView> implements Serializable {

		private static final long serialVersionUID = -8581403240573581907L;

		private Integer rowCount;

		List<WokDailyOcurrencesView> result;

		@Override
		public List<WokDailyOcurrencesView> load(int first, int pageSize,
				String sortField, SortOrder sortOrder,
				Map<String, Object> filters) {
			rowCount = almabaniFacade.getCountOfWokDailyOcurrencesView(filters);

			if (Utils.isNotNull(selectedWokGroup)) {

				attachSelectedWokGroupFiltration(filters);
				result = (List<WokDailyOcurrencesView>) almabaniFacade
						.loadWokDailyOcurrencesView(first, pageSize, sortField,
								sortOrder == SortOrder.ASCENDING, filters);
 
				setRowCount(this.rowCount);
			} else {
				result = new ArrayList();
			}

			return result;
		}

		private void attachSelectedWokGroupFiltration(
				Map<String, Object> filters) {
			filters.put("workingGroupNumber", selectedWokGroup.getNumWorkingGroup());
			
		}

		@Override
		public WokDailyOcurrencesView getRowData(String rowKey) {

			for (WokDailyOcurrencesView wokDailyOcurrencesView : result) {
				if (wokDailyOcurrencesView.getId().toString().equals(rowKey)) {
					selectedWokDailyOcurrencesView = wokDailyOcurrencesView;
					return wokDailyOcurrencesView;
				}
			}

			return null;
		}

	}
	
	
	public void saveWokDailyOccurence()
	{
		System.out.println();
	}
	
	public void prepareCreateDailyOccurence()
	{
		selectedWokDailyOcurrence = new WokDailyOcurrence();
	}

	public LazyDataModel<WokDailyOcurrencesView> getWokDailyOccurencyLazyModel() {
		return wokDailyOccurencyLazyModel;
	}

	public void setWokDailyOccurencyLazyModel(
			LazyDataModel<WokDailyOcurrencesView> wokDailyOccurencyLazyModel) {
		this.wokDailyOccurencyLazyModel = wokDailyOccurencyLazyModel;
	}

	public WokDailyOcurrencesView getSelectedWokDailyOcurrencesView() {
		return selectedWokDailyOcurrencesView;
	}

	public void setSelectedWokDailyOcurrencesView(
			WokDailyOcurrencesView selectedWokDailyOcurrencesView) {
		this.selectedWokDailyOcurrencesView = selectedWokDailyOcurrencesView;
	}

	public WokWorkingGroupsListView getSelectedWokGroup() {
		return selectedWokGroup;
	}

	public void setSelectedWokGroup(WokWorkingGroupsListView selectedWokGroup) {
		this.selectedWokGroup = selectedWokGroup;
	}


	public WokDailyOcurrence getSelectedWokDailyOcurrence() {
		return selectedWokDailyOcurrence;
	}

	public void setSelectedWokDailyOcurrence(
			WokDailyOcurrence selectedWokDailyOcurrence) {
		this.selectedWokDailyOcurrence = selectedWokDailyOcurrence;
	}

	public List<WokOccurrenceType> getOccurencyTypeList() {
		return occurencyTypeList;
	}

	public void setOccurencyTypeList(List<WokOccurrenceType> occurencyTypeList) {
		this.occurencyTypeList = occurencyTypeList;
	}

	public List<WokUserGroup> getOperatorsList() {
		return operatorsList;
	}

	public void setOperatorsList(List<WokUserGroup> operatorsList) {
		this.operatorsList = operatorsList;
	}

	public List<WokUserGroup> getCommuincatorsList() {
		return commuincatorsList;
	}

	public void setCommuincatorsList(List<WokUserGroup> commuincatorsList) {
		this.commuincatorsList = commuincatorsList;
	}

	public List<WokUserGroup> getSafetyAgentsList() {
		return safetyAgentsList;
	}

	public void setSafetyAgentsList(List<WokUserGroup> safetyAgentsList) {
		this.safetyAgentsList = safetyAgentsList;
	}

	public List<WokUserGroup> getTechniciansList() {
		return techniciansList;
	}

	public void setTechniciansList(List<WokUserGroup> techniciansList) {
		this.techniciansList = techniciansList;
	}

	public List<OamZoneDevice> getCameras() {
		return cameras;
	}

	public void setCameras(List<OamZoneDevice> cameras) {
		this.cameras = cameras;
	}

}
