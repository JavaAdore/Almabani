package com.almabani.dataaccess.daoimpl.adminsec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.dto.UserApplicationGrant;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminsec.ApplicationType;
import com.almabani.common.entity.schema.adminsec.SecApplication;
import com.almabani.common.entity.schema.adminsec.SecApplicationGrants;
import com.almabani.common.entity.schema.adminsec.SecApplicationsCompany;
import com.almabani.common.entity.schema.adminsec.SecModule;
import com.almabani.common.entity.schema.adminsec.SecUser;
import com.almabani.common.util.Utils;
import com.almabani.dataacceess.dao.adminsec.ApplicationDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class ApplicationDAOImpl extends AbstractDAO implements ApplicationDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<SecApplication> loadApplications(Integer first,
			Integer pageSize, String sortField, boolean assending,
			Map<String, Object> filters) {

		return super.lazyLoadEntities(SecApplication.class, first, pageSize,
				sortField, assending, filters);
	}

	@Override
	@Transactional
	public SecApplication addOrUpdateApplication(SecApplication application) {
		return (SecApplication) super.persist(application);
	}

	@Override
	public SecApplication getApplication(Long id) {
		return (SecApplication) super.getEntity(SecApplication.class, id);
	}

	@Override
	public Integer getCountOfApplications(Map<String, Object> filters) {

		return super.getCountOfResults(SecApplication.class, filters);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SecApplication> getAllApplications() {
		Query query = getCurrentSession()
				.createQuery(
						" select  x from SecApplication x order by x.secSubModule desc");
		List result = query.list();
		return result;
	}

	@Override
	public ApplicationType getApplicationType(Long id) {
		return (ApplicationType) super.getEntity(ApplicationType.class, id);
	}

	@Override
	public List<ApplicationType> getAllApplicationTypes() {
		return super.getAllEntities(ApplicationType.class);
	}

	@Override
	public List<UserApplicationGrant> getAllUserApplications() {
		Query query = getCurrentSession()
				.createQuery(
						" select new UserApplicationGrant(false , a) from SecApplication a");
		List result = query.list();
		return result;
	}

	@Override
	public List<UserApplicationGrant> getGrantedApplication(Company company) {
		Query query = getCurrentSession()
				.createQuery(
						" select new com.almabani.common.dto.UserApplicationGrant( ac.application , ac) from SecApplicationsCompany ac where ac.company =:company ");
		query.setParameter("company", company);
		List result = query.list();
		return result;
	}

	@Override
	public List<SecApplicationsCompany> getSecApplicationsCompany(
			Company company) {
		Query query = getCurrentSession()
				.createQuery(
						" select ac from SecApplicationsCompany ac where ac.company =:company ");
		query.setParameter("company", company);
		List result = query.list();
		return result;
	}

	@Override
	public Map<SecApplication, SecApplicationGrants> getGrantedApplication(
			SecUser secUser, Company company) {
		Query query = super
				.getCurrentSession()
				.createQuery(
						"select x    from SecApplicationGrants x where x.applicationsCompany.company =:company and x.userLoginCode =:userLoginCode");
		query.setParameter("company", company);
		query.setParameter("userLoginCode", secUser.getUserLoginCode());
		Map<SecApplication, SecApplicationGrants> mapToReturn = new HashMap();
		for (SecApplicationGrants secApplicationGrants : (List<SecApplicationGrants>) query
				.list()) {
			mapToReturn.put(secApplicationGrants.getApplicationsCompany()
					.getApplication(), secApplicationGrants);
		}
		return mapToReturn;
	}

	@Override
	public void revokeOldAccess(SecUser secUser, Company company,SecModule module) {
		if(Utils.isNull(module)){
		Query query = super
				.getCurrentSession()
				.createQuery(
						"delete  from SecApplicationGrants  where applicationsCompany in (select x from SecApplicationsCompany x where x.company =:company )  and userLoginCode =:userLoginCode");
		query.setParameter("company", company);
		query.setParameter("userLoginCode", secUser.getUserLoginCode());
		query.executeUpdate();
		}else
		{
			
			Query query = super
					.getCurrentSession()
					.createQuery(
							"delete  from SecApplicationGrants  where applicationsCompany in (select x from SecApplicationsCompany x where x.company =:company and x.application.secSubModule.module=:module )  and userLoginCode =:userLoginCode");
			query.setParameter("company", company);
			query.setParameter("userLoginCode", secUser.getUserLoginCode());
			query.setParameter("module", module);
			query.executeUpdate(); 
		}
	}

	@Override
	public SecApplicationGrants addApplicationGrant(
			SecApplicationGrants secApplicationGrants) {

		return (SecApplicationGrants) super.persist(secApplicationGrants);
	}

	@Override
	public SecApplicationsCompany addCompanyApplicationGrant(
			SecApplicationsCompany secApplicationCompany) {
		return (SecApplicationsCompany) super.persist(secApplicationCompany);

	}

	@Override
	public void revokeOldAccess(Company company) {

		Query query = super.getCurrentSession().createQuery(
				"delete  from SecApplicationsCompany  where company =:company");
		query.setParameter("company", company);
		query.executeUpdate();
	}

	@Override
	public void deleteUserGrants(List<SecApplicationsCompany> companyApps) {

		Query query = super
				.getCurrentSession()
				.createQuery(
						"delete   from SecApplicationGrants  where  applicationsCompany in (:companyApps) ");
		query.setParameterList("companyApps", companyApps);
		query.executeUpdate();
	}

	@Override
	public void deleteGrants(List<SecApplicationsCompany> revokeGrantList) {
		Iterator<SecApplicationsCompany> secAppCompanyIterator = revokeGrantList
				.iterator();
		while (secAppCompanyIterator.hasNext()) {

			super.getCurrentSession().delete(secAppCompanyIterator.next());
		}

	}

	@Override
	public SecApplication getApplication(String codApplication) {
		Query query = super
				.getCurrentSession()
				.createQuery(
						"from SecApplication app where app.codApplication =:codApplication ");
		query.setParameter("codApplication", codApplication);
		return (SecApplication) Utils.getFirstResult(query.list());

	}

	@Override
	public Map<SecApplication, SecApplicationGrants> getGrantedApplication(
			CommonDriverMap commonDriverMap) {
		Map<SecApplication, SecApplicationGrants> mapToReturn = new HashMap();
		List<SecApplicationGrants> result = new ArrayList();
		if (Utils.isNotNull(commonDriverMap.getAttachedCompany())
				&& Utils.isNotNull(commonDriverMap.getTargetUser())
				&& Utils.isNotNull(commonDriverMap.getTargetModule())) {
			Query query = super
					.getCurrentSession()
					.createQuery(
							"select x    from SecApplicationGrants x where x.applicationsCompany.company =:company and x.userLoginCode =:userLoginCode and x.applicationsCompany.application.secSubModule.module =:module ");
			query.setParameter("company", commonDriverMap.getAttachedCompany());
			query.setParameter("userLoginCode", commonDriverMap.getTargetUser()
					.getUserLoginCode());
			query.setParameter("module", commonDriverMap.getTargetModule());
			result = query.list();
			for (SecApplicationGrants secApplicationGrants : result) {
				mapToReturn.put(secApplicationGrants.getApplicationsCompany()
						.getApplication(), secApplicationGrants);
			}
		} else if (Utils.isNotNull(commonDriverMap.getAttachedCompany())
				&& Utils.isNotNull(commonDriverMap.getTargetUser())) {
			Query query = super
					.getCurrentSession()
					.createQuery(  
							"select x    from SecApplicationGrants x where x.applicationsCompany.company =:company and x.userLoginCode =:userLoginCode ");
			query.setParameter("company", commonDriverMap.getAttachedCompany());
			query.setParameter("userLoginCode", commonDriverMap.getTargetUser()
					.getUserLoginCode());
			result = query.list();
			for (SecApplicationGrants secApplicationGrants : result) {
				mapToReturn.put(secApplicationGrants.getApplicationsCompany()
						.getApplication(), secApplicationGrants);
			}

		}
		return mapToReturn;
	}

	@Override
	public List<UserApplicationGrant> getCompanyGrante(
			CommonDriverMap commonDriverMap) {
		List result = new ArrayList();
		if (Utils.isNotNull(commonDriverMap.getAttachedCompany()) && Utils.isNotNull(commonDriverMap.getTargetModule()) ) {
			Query query = getCurrentSession()
					.createQuery(
							" select new com.almabani.common.dto.UserApplicationGrant( ac.application , ac) from SecApplicationsCompany ac where ac.company =:company and ac.application.secSubModule.module =:module ");
			query.setParameter("company", commonDriverMap.getAttachedCompany());
	  		query.setParameter("module", commonDriverMap.getTargetModule());
			result = query.list();
		} else if (Utils.isNotNull(commonDriverMap.getAttachedCompany())
				) { 
			Query query = getCurrentSession()
					.createQuery(
							" select new com.almabani.common.dto.UserApplicationGrant( ac.application , ac) from SecApplicationsCompany ac where ac.company =:company ");
			query.setParameter("company", commonDriverMap.getAttachedCompany());
			result = query.list();
		}
		return result;
	}

	@Override
	public Map<String, String> getApplicationDescriptionMap() {
		String HQL_QUERY = "select codApplication ,applicationDescription  from SecApplication ";        
		Query query = getCurrentSession().createQuery(HQL_QUERY);
		List<Object[] >result = (List<Object[] >)query.list();
		Map<String,String > mapToReturn = new TreeMap();
		for(Object[] currentRow : result)  
		{ 
			mapToReturn.put((String)currentRow[0], (String)currentRow[1]); 
		}
		return mapToReturn; 
	}

	

}
