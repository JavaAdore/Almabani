package com.almabani.dataaccess.daoimpl.admincor;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Country;
import com.almabani.common.entity.schema.admincor.State;
import com.almabani.common.util.Utils;
import com.almabani.dataaccess.dao.admincor.StateDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class StatesDAOImp extends AbstractDAO implements StateDAO {
	
	private static final long serialVersionUID = 9028293043560640796L;

	@SuppressWarnings("unchecked")
	@Override
	public List<State> getAllStates() {
		return super.getAllEntities(State.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<State> getStates(Country country) {
		Query query = getCurrentSession().createQuery("select x from State x where x.id.country =:country");
		query.setParameter("country", country);
		return query.list();
	}

	@Override
	public State getState(Long countryId, String stateCode) {
		Query query = getCurrentSession().createQuery("select x from State x where x.id.country.id =:country and x.id.stateCode=:stateCode ");
		query.setParameter("country", countryId);
		query.setParameter("stateCode", stateCode);
		return (State) Utils.getFirstResult(query.list());
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	@Override
	public void test() { 
		Query query = getCurrentSession().createQuery("select x from Company x where x.state.stateId.country.countryName =:countryName ");
		query.setParameter("countryName", "BRASIL");
		List result = query.list();
		System.out.println();
	}

}
