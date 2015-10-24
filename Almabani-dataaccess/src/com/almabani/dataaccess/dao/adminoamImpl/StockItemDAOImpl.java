package com.almabani.dataaccess.dao.adminoamImpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Establishment;
import com.almabani.common.entity.schema.adminoam.OamItemQuotation;
import com.almabani.common.entity.schema.adminoam.OamProjectItem;
import com.almabani.common.entity.schema.adminoam.OamStockItem;
import com.almabani.common.entity.schema.adminoam.view.OamStockItemDetailsView;
import com.almabani.common.entity.schema.adminoam.view.OamStockItemView;
import com.almabani.common.util.Utils;
import com.almabani.dataaccess.dao.adminoam.StockItemDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class StockItemDAOImpl extends AbstractDAO implements StockItemDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<OamStockItem> loadStockItems(Integer first, Integer pageSize,
			String sortField, boolean assending, Map<String, Object> filters) {

		return super.lazyLoadEntities(OamStockItem.class, first, pageSize,
				sortField, assending, filters);
	} 

	@Override
	@Transactional
	public OamStockItem addOrUpdateStockItem(OamStockItem StockItem) {
		return (OamStockItem) super.persist(StockItem);
	}

	@Override
	public OamStockItem getStockItem(Long id) {
		return (OamStockItem) super.getEntity(OamStockItem.class, id);
	}


	@Override
	public Integer getCountOfStockItem(Map<String, Object> filters) {

		return super.getCountOfResults(OamStockItem.class, filters);
	}

	@Override
	public List<OamStockItem> getAllStockItems() {
		return super.getAllEntities(OamStockItem.class);
	}

	@Override
	public List<OamStockItem> getAllStockItems(Company company) {
		Query query = super.getCurrentSession().createQuery("select x from OamStockItem x where x.itemQuotation.quotation.department.company =:company");
		query.setParameter("company", company);
		return query.list(); 
	}

	@Override
	public List<OamStockItemView> loadOamStockItemsView(int first, int pageSize,
			String sortField, boolean assending, Map<String, Object> filters) {
		return super.lazyLoadEntities(OamStockItemView.class, first, pageSize, sortField, assending, filters);
	}

	@Override
	public Integer getNumberOfOamStockItemsView(Map<String, Object> filters) {
		return super.getCountOfResults(OamStockItemView.class, filters); 
	}

	@Override
	public List<OamStockItemDetailsView> loadOamStockItemsDetailsView(
			int first, int pageSize, String sortField, boolean assending,
			Map<String, Object> filters) {
		return super.lazyLoadEntities(OamStockItemDetailsView.class, first, pageSize, sortField, assending, filters);
	}

	@Override
	public Integer getNumberOfOamStockItemsDetailsView(
			Map<String, Object> filters) {
		return super.getCountOfResults(OamStockItemDetailsView.class, filters);
	}

	@Override
	public Long getNumberOfRemainingItems(OamProjectItem projectItem,
			OamItemQuotation itemQuotation, Establishment establishment) {
		Query query = super
				.getCurrentSession() 
				.createQuery(
						"select x.availableQuantity from  OamStockItemView x , OamStockItem xx where x.oamStockItemViewId.projectItemId  = xx.projectItem.id and x.oamStockItemViewId.projectItemId=:projectItem and x.oamStockItemViewId.establishmentNumber=:establishmentNumber and  xx.itemQuotation =:itemQuotation");
		query.setParameter("projectItem", projectItem.getId()); 
		query.setParameter("itemQuotation", itemQuotation);
		query.setParameter("establishmentNumber", establishment.getId());
		Object numberOfRemainingItems = Utils.getFirstResult(query.list());

		return numberOfRemainingItems != null ? (Long) numberOfRemainingItems
				: 0L;
	}

	

}
