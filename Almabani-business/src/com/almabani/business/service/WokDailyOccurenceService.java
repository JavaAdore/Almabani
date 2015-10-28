package com.almabani.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.admincor.Country;
import com.almabani.common.entity.schema.adminwkf.view.WokDailyOcurrencesView;
import com.almabani.common.entity.schema.adminwkf.view.WokWorkingGroupsListView;

@Service
public interface WokDailyOccurenceService {

	List<WokWorkingGroupsListView> getWokDailyIccurrencesViewRecords(
			String currentUserCode);

	List<WokDailyOcurrencesView> loadWokDailyOcurrencesView(int first,
			int pageSize, String sortField, boolean assending,
			Map<String, Object> filters);

	Integer getCountOfWokDailyOcurrencesView(Map<String, Object> filters);

}
