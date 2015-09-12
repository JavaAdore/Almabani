package com.almabani.dataaccess.daoimpl.adminsec;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminsec.SecModule;
import com.almabani.dataacceess.dao.adminsec.ModuleDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class ModuleDAOImpl extends AbstractDAO implements ModuleDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<SecModule> loadModules(Integer first, Integer pageSize,
			String sortField, boolean assending, Map<String, Object> filters) {

		return super.lazyLoadEntities(SecModule.class, first, pageSize,
				sortField, assending, filters);
	}

	@Override
	@Transactional
	public SecModule addOrUpdateModule(SecModule module) {
		return (SecModule) super.persist(module);
	}

	@Override
	public SecModule getModule(Long id) {
		return (SecModule) super.getEntity(SecModule.class, id);
	}

	

	@Override
	public Integer getCountOfModule(Map<String, Object> filters) {

		return super.getCountOfResults(SecModule.class, filters);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SecModule> getAllModules() {
		return super.getAllEntities(SecModule.class);
	}

	@Override
	public List<SecModule> getAllModules(Company company) {
		Query query = super.getCurrentSession().createQuery("select x from SecModule x where x.system.company =:company ");
		query.setParameter("company", company);
		return query.list(); 
	}

}
