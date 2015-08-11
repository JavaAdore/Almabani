package com.almabani.dataaccess.daoimpl.adminsec;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.almabani.common.entity.schema.adminsec.SecSystem;
import com.almabani.dataacceess.dao.adminsec.SystemDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class SystemDAOImpl extends AbstractDAO implements SystemDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<SecSystem> loadSystems(Integer first, Integer pageSize,
			String sortField, boolean assending, Map<String, Object> filters) {

		return super.lazyLoadEntities(SecSystem.class, first, pageSize,
				sortField, assending, filters);
	}

	@Override
	@Transactional
	public SecSystem addOrUpdateSystem(SecSystem module) {
		return (SecSystem) super.persist(module);
	}

	@Override
	public SecSystem getSystem(Long id) {
		return (SecSystem) super.getEntity(SecSystem.class, id);
	}

	

	@Override
	public Integer getCountOfSystem(Map<String, Object> filters) {

		return super.getCountOfResults(SecSystem.class, filters);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SecSystem> getAllSystems() {
		return super.getAllEntities(SecSystem.class);
	}

}
