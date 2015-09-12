package com.almabani.dataaccess.dao.adminoamImpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.almabani.common.constant.DataAccessConfig;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.OamProjectItem;
import com.almabani.common.entity.schema.adminoam.OamStockItem;
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


}
