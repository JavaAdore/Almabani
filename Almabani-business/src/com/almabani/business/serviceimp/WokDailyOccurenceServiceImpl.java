package com.almabani.business.serviceimp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.WokDailyOccurenceService;
import com.almabani.common.entity.schema.adminwkf.view.WokDailyOcurrencesView;
import com.almabani.common.entity.schema.adminwkf.view.WokWorkingGroupsListView;
import com.almabani.dataaccess.dao.adminwkf.WokDailyOccurenceDAO;

@Service
public class WokDailyOccurenceServiceImpl implements WokDailyOccurenceService {

	@Autowired
	private WokDailyOccurenceDAO wokDailyOccurenceDAO;

	@Override
	public List<WokWorkingGroupsListView> getWokDailyIccurrencesViewRecords(
			String currentUserCode) {
		return wokDailyOccurenceDAO
				.getWokDailyIccurrencesViewRecords(currentUserCode);
	}

	@Override
	public List<WokDailyOcurrencesView> loadWokDailyOcurrencesView(int first,
			int pageSize, String sortField, boolean assending,
			Map<String, Object> filters) {
		return wokDailyOccurenceDAO.loadWokDailyOcurrencesView(first, pageSize,
				sortField, assending, filters);
	}

	@Override
	public Integer getCountOfWokDailyOcurrencesView(Map<String, Object> filters) {
		return wokDailyOccurenceDAO.getCountOfWokDailyOcurrencesView(filters) ;
	}

}
