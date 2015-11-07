package com.almabani.dataaccess.dao.adminwkf;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.adminwkf.WokDailyOcurrence;
import com.almabani.common.entity.schema.adminwkf.view.WokDailyOcurrencesView;
import com.almabani.common.entity.schema.adminwkf.view.WokWorkingGroupsListView;

@Repository
public interface WokDailyOccurenceDAO {

	List<WokWorkingGroupsListView> getWokDailyIccurrencesViewRecords(
			String currentUserCode);

	List<WokDailyOcurrencesView> loadWokDailyOcurrencesView(int first,
			int pageSize, String sortField, boolean assending,
			Map<String, Object> filters);

	Integer getCountOfWokDailyOcurrencesView(Map<String, Object> filters);

	WokDailyOcurrence WokDailyOccurency(WokDailyOcurrence wokDailyOcurrence);

	WokDailyOcurrence getWokDailyOccurence(Long id);

}
