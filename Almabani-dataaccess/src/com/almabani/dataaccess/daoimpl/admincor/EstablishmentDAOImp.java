package com.almabani.dataaccess.daoimpl.admincor;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Establishment;
import com.almabani.dataaccess.dao.admincor.EstablishmentDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class EstablishmentDAOImp extends AbstractDAO implements EstablishmentDAO {
	
	private static final long serialVersionUID = 2483362673095573457L;

	@Override
	public Establishment getEstablishment(Long key) {
		return (Establishment) getCurrentSession().get(Establishment.class, key);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Establishment> getEstablishments(Company company) {
		
		Query query = getCurrentSession().createQuery("select e from Establishment e where e.company =:company");
		query.setParameter("company", company);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Establishment> getEstablishments() {
		return super.getAllEntities(Establishment.class);
	}	
}
