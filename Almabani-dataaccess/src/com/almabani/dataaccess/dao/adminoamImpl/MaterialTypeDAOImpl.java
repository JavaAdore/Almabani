package com.almabani.dataaccess.dao.adminoamImpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.OamTypeMaterial;
import com.almabani.dataaccess.dao.adminoam.MaterialTypeDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class MaterialTypeDAOImpl extends AbstractDAO implements MaterialTypeDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<OamTypeMaterial> loadMaterialTypes(Integer first,
			Integer pageSize, String sortField, boolean assending,
			Map<String, Object> filters) {

		return super.lazyLoadEntities(OamTypeMaterial.class, first, pageSize,
				sortField, assending, filters);
	}

	@Override
	@Transactional
	public OamTypeMaterial addMaterialType(OamTypeMaterial company) {
		return (OamTypeMaterial) super.persist(company);
	}

	@Override
	public OamTypeMaterial getMaterialType(Long id) {
		return (OamTypeMaterial) super.getEntity(OamTypeMaterial.class, id);
	}

	@Override
	public Integer getCountOfMaterialTypes(Map<String, Object> filters) {

		return super.getCountOfResults(OamTypeMaterial.class, filters);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OamTypeMaterial> getAllMaterialTypes() {
		return super.getAllEntities(OamTypeMaterial.class);
	}

	@Override
	public List<OamTypeMaterial> getAllMaterialTypes(Company company) {
		Query query = getCurrentSession().createQuery(
				"select x  from OamTypeMaterial x where x.company =:company  ");
		query.setParameter("company", company);
		return query.list(); 
	}

}
