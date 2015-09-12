package com.almabani.dataaccess.daoimpl.admincor;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.almabani.common.constant.DataAccessConfig;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.OamProjectItem;
import com.almabani.common.entity.schema.adminoam.OamSupplier;
import com.almabani.dataaccess.dao.admincor.SupplierDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class SupplierDAOImp extends AbstractDAO implements SupplierDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<OamSupplier> loadSuppliers(Integer first, Integer pageSize,
			String sortField, boolean assending, Map<String, Object> filters) {

		return super.lazyLoadEntities(OamSupplier.class, first, pageSize,
				sortField, assending, filters);
	}

	@Override
	@Transactional
	public OamSupplier addOrUpdateSupplier(OamSupplier supplier) {
		return (OamSupplier) super.persist(supplier);
	}

	@Override
	public OamSupplier getSupplier(Long id) {
		return (OamSupplier) super.getEntity(OamSupplier.class, id);
	}


	@Override
	public Integer getCountOfSupplier(Map<String, Object> filters) {

		return super.getCountOfResults(OamSupplier.class, filters);
	}

	@Override
	public List<OamSupplier> getAllSuppliers() {
		return super.getAllEntities(OamSupplier.class);
	}

	@Override
	public List<OamSupplier> getAllSuppliers(Company company) {
		Query query = super.getCurrentSession().createQuery("select x from OamSupplier x where x.company =:company");
		query.setParameter("company", company);
		return query.list(); 
	}

	@Override
	public List<OamProjectItem> getAllProjectItems(
			String projectItemNameOrDescription) {
		Query query = super.getCurrentSession().createQuery("select x from  OamProjectItem x where upper(x.item.itemDescription) like upper(:itemNameOrDescription) or upper(x.item.itemCode) like upper(:itemNameOrDescription)   ");
		query.setParameter("itemNameOrDescription", projectItemNameOrDescription+"%");
		query.setMaxResults(DataAccessConfig.MAX_ALLOWED_NUMBER_OF_ELEMENTS_IN_AUTO_COMPLETE);
		return query.list(); 
	}
 
	@Override
	public List<OamProjectItem> getAllProjectItems(
			String projectItemNameOrDescription, Company company) {
		Query query = super.getCurrentSession().createQuery("select x from  OamProjectItem x where x.project.company =:company and upper(x.item.itemDescription) like upper(:itemNameOrDescription) or upper(x.item.itemCode) like upper(:itemNameOrDescription)   ");
		query.setParameter("itemNameOrDescription", projectItemNameOrDescription+"%"); 
		query.setParameter("company", company); 
		query.setMaxResults(DataAccessConfig.MAX_ALLOWED_NUMBER_OF_ELEMENTS_IN_AUTO_COMPLETE);
 
		return query.list();
	}

}
