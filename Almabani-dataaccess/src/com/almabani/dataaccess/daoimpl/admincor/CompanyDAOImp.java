package com.almabani.dataaccess.daoimpl.admincor;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.view.CompanyView;
import com.almabani.common.util.Utils;
import com.almabani.dataaccess.dao.admincor.CompanyDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class CompanyDAOImp extends AbstractDAO implements CompanyDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> loadMCompanies(Integer first, Integer pageSize,
			String sortField, boolean assending, Map<String, Object> filters) {

		return super.lazyLoadEntities(Company.class, first, pageSize,
				sortField, assending, filters);
	}

	@Override
	@Transactional
	public Company addCompany(Company company) {
		return (Company) super.persist(company);
	}

	@Override
	public Company getCompany(Long id) {
		return (Company) super.getEntity(Company.class, id);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Company getCompany(String fedralIdentityCode) {

		Query query = getCurrentSession()
				.createQuery(
						"select x from Company x where x.federalIdentityCode =:fedralCode");
		query.setParameter("fedralCode", fedralIdentityCode);
		List result = query.list();
		if (Utils.isNotEmptyList(result)) {
			return (Company) result.get(0);
		}
		return null;
	}

	@Override
	public Integer getCountOfCompany(Map<String, Object> filters) {

		return super.getCountOfResults(Company.class, filters);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> getAllCompanies() {
		return super.getAllEntities(Company.class);
	}

	@Override
	public List<CompanyView> getAllCompanyViews() {
		return super.getAllEntities(CompanyView.class);
	}

}
