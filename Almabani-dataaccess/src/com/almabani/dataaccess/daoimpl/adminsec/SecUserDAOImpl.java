package com.almabani.dataaccess.daoimpl.adminsec;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminsec.SecUser;
import com.almabani.common.util.Utils;
import com.almabani.dataacceess.dao.adminsec.SecUserDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;
@Repository
public class SecUserDAOImpl extends AbstractDAO implements SecUserDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public SecUser getUser(String userLoginCode) {
		Query query = getCurrentSession().createQuery("select x from SecUser x where lower(x.userLoginCode) = lower(:userLoginCode)  ");
		query.setParameter("userLoginCode"	, userLoginCode);
		return (SecUser) Utils.getFirstResult(query.list());
	}

	@Override
	public List<SecUser> getAllUsers() {
		return super.getAllEntities(SecUser.class);
	}

	@Override
	public List<SecUser> loadUsers(int first, int pageSize, String sortField,
			boolean assending, Map<String, Object> filters) {
		return super.lazyLoadEntities(SecUser.class, first, pageSize, sortField, assending, filters);
	}

	@Override
	public SecUser saveOrUpdate(SecUser user) {
		return (SecUser) super.persist(user);
	}

	@Override
	public Integer getNumberOfUser(Map<String, Object> filters) {
		return super.getCountOfResults(SecUser.class, filters);
	}

	@Override
	public List<SecUser> getUsers(Company company) {
		Query query = getCurrentSession().createQuery("select x from SecUser x where x.employee.establishment.company =:company");
		query.setParameter("company", company);
		return query.list();
	}
   
}
