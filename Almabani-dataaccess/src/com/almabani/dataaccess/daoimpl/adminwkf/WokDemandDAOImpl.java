package com.almabani.dataaccess.daoimpl.adminwkf;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminwkf.WokDemand;
import com.almabani.dataaccess.dao.adminwkf.WokDemandDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class WokDemandDAOImpl extends AbstractDAO implements WokDemandDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8668330372929475449L;
  
	@Override
	public WokDemand getWokDemand(Long id) {
		return (WokDemand) super.getEntity(WokDemand.class, id);
	}

	@Override
	public List<WokDemand> getWokDemands() {
		return super.getAllEntities(WokDemand.class);
	}

	@Override
	public List<WokDemand> getWokDemands(Company company) {
		Query query = super.getCurrentSession().createQuery("select x from WokDemand x where x.typeDemand.company =:company");
		query.setParameter("company", company); 
		return query.list();  
	}

}
