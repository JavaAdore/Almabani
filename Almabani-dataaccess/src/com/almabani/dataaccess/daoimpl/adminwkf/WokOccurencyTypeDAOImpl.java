package com.almabani.dataaccess.daoimpl.adminwkf;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminwkf.WokOccurrenceType;
import com.almabani.dataaccess.dao.adminwkf.WokOccurencyTypeDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class WokOccurencyTypeDAOImpl extends AbstractDAO implements
		WokOccurencyTypeDAO {

	private static final long serialVersionUID = 1L;

	@Override
	public List<WokOccurrenceType> getWokOccurrenceTypeList(Company company) {
		Query query = super.getCurrentSession().createQuery(
				"select x from WokOccurrenceType x where x.company =:company");
		query.setParameter("company", company);
		return query.list();
	}

	@Override
	public WokOccurrenceType getOccurenceType(Long id) {
		return (WokOccurrenceType) super.getEntity(WokOccurrenceType.class, id);
	}

}
