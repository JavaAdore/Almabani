package com.almabani.dataaccess.daoimpl.admincor;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.CompanyParameter;
import com.almabani.common.entity.schema.admincor.GenericParameter;
import com.almabani.common.util.Utils;
import com.almabani.dataaccess.dao.admincor.ParameterDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class ParameterDAOImpl extends AbstractDAO implements ParameterDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public CompanyParameter getCompanyParameter(GenericParameter parameter,
			Company company) {
		Query query = super
				.getCurrentSession()
				.createQuery(
						"select x from CompanyParameter x where x.parameter =:parameter and x.company =:company");
		query.setParameter("parameter", parameter);
		query.setParameter("company", company);
		return (CompanyParameter) Utils.getFirstResult(query.list());
	}

}
