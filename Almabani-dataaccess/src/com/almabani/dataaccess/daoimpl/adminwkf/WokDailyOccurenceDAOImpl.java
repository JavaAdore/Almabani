package com.almabani.dataaccess.daoimpl.adminwkf;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.adminwkf.view.WokDailyOcurrencesView;
import com.almabani.common.entity.schema.adminwkf.view.WokWorkingGroupsListView;
import com.almabani.dataaccess.dao.adminwkf.WokDailyOccurenceDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class WokDailyOccurenceDAOImpl extends AbstractDAO implements WokDailyOccurenceDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<WokWorkingGroupsListView> getWokDailyIccurrencesViewRecords(
			String userLoginCode) {
		//and wug.user.userLoginCode =:userLoginCode
		Query query = super.getCurrentSession().createQuery("select x from WokWorkingGroupsListView x  , WokWorkingGroup wg , WokUserGroup wug  where x.numWorkingGroup = wg.id and wug.workingGroup = wg     ");
		//query.setParameter("userLoginCode", userLoginCode);
		return query.list(); 
	}

	@Override
	public List<WokDailyOcurrencesView> loadWokDailyOcurrencesView(int first,
			int pageSize, String sortField, boolean assending,
			Map<String, Object> filters) {
		return super.lazyLoadEntities(WokDailyOcurrencesView.class, first, pageSize, sortField, assending, filters);
	}

	@Override
	public Integer getCountOfWokDailyOcurrencesView(Map<String, Object> filters) {
		return super.getCountOfResults(WokDailyOcurrencesView.class, filters);
	}

	
}
