package com.almabani.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.adminwkf.WokDailyOcurrence;
import com.almabani.common.entity.schema.adminwkf.view.WokDailyOcurrencesView;
import com.almabani.common.entity.schema.adminwkf.view.WokWorkingGroupsListView;
import com.almabani.common.exception.AlmabaniException;

@Service
public interface WokDailyOccurenceService {

	List<WokWorkingGroupsListView> getWokDailyIccurrencesViewRecords(
			String currentUserCode);

	List<WokDailyOcurrencesView> loadWokDailyOcurrencesView(int first,
			int pageSize, String sortField, boolean assending,
			Map<String, Object> filters);

	Integer getCountOfWokDailyOcurrencesView(Map<String, Object> filters);

	WokDailyOcurrence updateWokDailyOccurency(WokDailyOcurrence selectedWokDailyOcurrence,
			CommonDriverMap commonDriverMap) throws AlmabaniException;

	WokDailyOcurrence addWokDailyOccurency(WokDailyOcurrence selectedWokDailyOcurrence,
			CommonDriverMap commonDriverMap) throws AlmabaniException;

	WokDailyOcurrence getWokDailyOccurence(Long id);

}
