package com.almabani.dataaccess.daoimpl.adminsec;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.almabani.common.entity.schema.adminsec.SecModule;
import com.almabani.common.entity.schema.adminsec.SecSubModule;
import com.almabani.dataacceess.dao.adminsec.SubModuleDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class SubModuleDAOImpl extends AbstractDAO implements SubModuleDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<SecSubModule> loadSubModules(Integer first, Integer pageSize,
			String sortField, boolean assending, Map<String, Object> filters) {

		return super.lazyLoadEntities(SecSubModule.class, first, pageSize,
				sortField, assending, filters);
	}

	@Override
	@Transactional
	public SecSubModule addOrUpdateSubModule(SecSubModule module) {
		return (SecSubModule) super.persist(module);
	}

	@Override
	public SecSubModule getSubModule(Long id) {
		return (SecSubModule) super.getEntity(SecSubModule.class, id);
	}

	

	@Override
	public Integer getCountOfSubModules(Map<String, Object> filters) {

		return super.getCountOfResults(SecSubModule.class, filters);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SecSubModule> getAllSubModules() {
		return super.getAllEntities(SecSubModule.class);
	}

	@Override
	public List<SecSubModule> getSubModules(SecModule module) {
		Query query = super.getCurrentSession().createQuery("select x from SecSubModule x where x.module =:module  ");
		query.setParameter("module", module);
		return query.list();   
		
	}

}
