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
	public WokDailyOcurrencesView selectedWokDailyOcurrencesView;

	@PostConstruct
	public void init() {

		wokDailyIccurrencesViewRecords = almabaniFacade
				.getWokDailyIccurrencesViewRecords(WebUtils
						.getCurrentUserCode());

		if (Utils.isNotEmptyList(wokDailyIccurrencesViewRecords)
				&& wokDailyIccurrencesViewRecords.size() == 1) {
			selectedWokGroup = wokDailyIccurrencesViewRecords.get(0);
		}

		initializeWokDailyOccurencyLazyModel();

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

				//attachSelectedWokGroupFiltration(filters);
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

}
