package com.almabani.dataaccess.dao.adminoamImpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.OamManufacturer;
import com.almabani.dataaccess.dao.adminoam.ManufacturerDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class ManufacturerDAOImpl extends AbstractDAO implements ManufacturerDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<OamManufacturer> loadManufacturers(Integer first, Integer pageSize,
			String sortField, boolean assending, Map<String, Object> filters) {

		return super.lazyLoadEntities(OamManufacturer.class, first, pageSize,
				sortField, assending, filters);
	}

	@Override
	@Transactional
	public OamManufacturer addOamManufacturer(OamManufacturer OamManufacturer) {
		return (OamManufacturer) super.persist(OamManufacturer);
	}

	@Override
	public OamManufacturer getManufacturer(Long id) {
		return (OamManufacturer) super.getEntity(OamManufacturer.class, id);
	}

	

	@Override
	public Integer getCountOfOamManufacturer(Map<String, Object> filters) {

		return super.getCountOfResults(OamManufacturer.class, filters);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OamManufacturer> getAllManufacturers() {
		return super.getAllEntities(OamManufacturer.class);
	}

	@Override
	public List<OamManufacturer> getAllManufacturers(Company company) {
		Query query = getCurrentSession().createQuery("select x from OamManufacturer x where x.company =:company ");
		query.setParameter("company", company);
		return query.list();  
	}

}
