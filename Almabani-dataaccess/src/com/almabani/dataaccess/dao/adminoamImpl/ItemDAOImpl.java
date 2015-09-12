package com.almabani.dataaccess.dao.adminoamImpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.almabani.common.constant.DataAccessConfig;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.OamItem;
import com.almabani.dataaccess.dao.adminoam.ItemDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class ItemDAOImpl extends AbstractDAO implements ItemDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<OamItem> loadItems(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters) {
		return super.lazyLoadEntities(OamItem.class, first, pageSize,
				sortField, ascending, filters);
	}

	@Override
	public Integer getCountOfItems(Map<String, Object> filters) {
		return super.getCountOfResults(OamItem.class, filters);
	}

	@Override
	public OamItem addOrUpdate(OamItem item) {
		return (OamItem) super.persist(item);
	}

	@Override
	public List<OamItem> getAllItems() {

		return super.getAllEntities(OamItem.class);
	}

	@Override
	public OamItem getItem(Long itemID) {

		return (OamItem) super.getEntity(OamItem.class, itemID);
	}

	@Override
	public List<OamItem> getAllItems(Company company) {
		Query query = super
				.getCurrentSession()
				.createQuery(
						"select x from OamItem x where x.itemCategory.comDepartmentSection.department.company =:company ");
		query.setParameter("company", company);
		return query.list();

	}

	@Override
	public List<OamItem> getAllItems(String itemNameOrDescription) {
		Query query = super
				.getCurrentSession()
				.createQuery(
						"select x from OamItem x where  upper(x.itemDescription) like upper(:itemCodeOrDescription) or upper(x.itemCode) like upper(:itemCodeOrDescription) ");
		query.setParameter("itemCodeOrDescription", itemNameOrDescription + "%");

		query.setMaxResults(DataAccessConfig.MAX_ALLOWED_NUMBER_OF_ELEMENTS_IN_AUTO_COMPLETE);
		return query.list();
	}

	@Override
	public List<OamItem> getAllItems(String itemNameOrDescription,
			Company company) {
		Query query = super
				.getCurrentSession()
				.createQuery(
						"select x from OamItem x where  x.itemCategory.comDepartmentSection.department.company=:company and  upper(x.itemDescription) like upper(:itemCodeOrDescription) or upper(x.itemCode) like upper(:itemCodeOrDescription) ");
		query.setParameter("itemCodeOrDescription", itemNameOrDescription + "%");
		query.setParameter("company", company);
		query.setMaxResults(DataAccessConfig.MAX_ALLOWED_NUMBER_OF_ELEMENTS_IN_AUTO_COMPLETE); 

		return query.list();
	}

}
