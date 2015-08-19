package com.almabani.dataaccess.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.almabani.common.util.Utils;

@Repository
@Transactional (propagation=Propagation.REQUIRED)
public class AbstractDAO implements Serializable {

	private static final long serialVersionUID = -8668330372929475449L;
	public static final String ALIAS = "x";
	@Autowired
	protected SessionFactory sessionFactory;

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected Object persist(Object obj) {

		return getCurrentSession().merge(obj);

	}

	@SuppressWarnings("rawtypes")
	protected Object getEntity(Class clz, Long id) {
		return getCurrentSession().get(clz, id);
	}

	@SuppressWarnings("rawtypes")
	protected List getAllEntities(Class clz) {
		return getCurrentSession()
				.createQuery("from " + clz.getCanonicalName()).list();
	}

	@SuppressWarnings("rawtypes")
	public Criteria createCriteria(Class clz) {
		return getCurrentSession().createCriteria(clz);
	}

	// @SuppressWarnings("rawtypes")
	// public Criteria preparelazyFetchingCriteria(Class clz, Integer first,
	// Integer pageSize, String sortField, boolean assending,
	// Map<String, Object> filters) {
	//
	// Map<String, String> aliases = new HashMap<String, String>();
	//
	// Criteria cr = getCurrentSession().createCriteria(clz);
	//
	// attachFilters(clz, cr, aliases, filters);
	//
	// attachSort(cr, aliases, sortField, assending);
	//
	// addAliases(cr, aliases);
	//
	// return cr;
	//
	// }

	@SuppressWarnings("unused")
	private void addAliases(Criteria cr, Map<String, String> aliases) {
		for (String alia : aliases.keySet()) {
			cr = cr.createAlias(alia, aliases.get(alia));

		}
	}

	@SuppressWarnings("unused")
	private void attachSort(Criteria cr, Map<String, String> aliases,
			String sortField, boolean assending) {
		if (Utils.isNotNull(sortField)) {
			String[] fields = sortField.split("\\.");

			if (Utils.isNotNull(sortField)) {
				if (assending) {

					cr.addOrder(Order.asc(Utils.dublicate(ALIAS,
							fields.length - 1)
							+ "."
							+ fields[fields.length - 1]));
				} else {
					cr.addOrder(Order.desc(Utils.dublicate(ALIAS,
							fields.length - 1)
							+ "."
							+ fields[fields.length - 1]));

				}
				if (Utils.isDirectValue(sortField) == false) {

					attachFieldAliases(aliases, sortField);
				}
			}
		}
	}

	@SuppressWarnings("unused")
	private void attachFieldAliases(Map<String, String> aliases,
			String sortField) {
		int counter = 1;
		String[] fields = sortField.split("\\.");
		String targetField = fields[fields.length - 1];
		for (String ali : fields) {

			List<String> values = new ArrayList<String>(aliases.values());

			if (ali.equalsIgnoreCase(targetField) == false) {

				if (counter == 1) {
					aliases.put(ali, ALIAS);
				} else {
					aliases.put(
							Utils.dublicate(ALIAS, counter - 1) + "." + ali,
							Utils.dublicate(ALIAS, counter));

				}

			}
			counter++;
		}
	}

	// @SuppressWarnings({ "rawtypes" })
	// private void attachFilters(Class clz, Criteria cr,
	// Map<String, String> aliases, Map<String, Object> filters) {
	// for (String currentFilter : filters.keySet()) {
	// Object filterValue = filters.get(currentFilter);
	// Class targetedClass = Utils.getFilterClass(currentFilter, clz);
	// if (Utils.isAString(filterValue)) {
	// if (targetedClass == String.class) {
	// if (Utils.isDirectValue((String) currentFilter)) {
	// cr.add(Restrictions.like(currentFilter,
	// (String) filterValue, MatchMode.START));
	// } else {
	//
	// attachFieldAliases(aliases, currentFilter);
	//
	// cr.add(Restrictions.like(currentFilter,
	// (String) filterValue, MatchMode.START)
	// .ignoreCase());
	// }
	// } else if (Utils.isPrimitiveDataType(targetedClass)) {
	// if (Utils.isAString(filterValue)) {
	// Object object = Utils.initiatePrimitiveObject(
	// targetedClass, (String) filterValue);
	//
	// cr.add(Restrictions.eq(currentFilter, object));
	// }
	// }
	// } else {
	// if (targetedClass == Date.class) {
	// cr.add(Restrictions.between(currentFilter,
	// Utils.getStartOfDay((Date) filterValue),
	// Utils.getEndOfDay((Date) filterValue)));
	// } else {
	// cr.add(Restrictions.eq(currentFilter, filterValue));
	// }
	// }
	// }
	//
	// }

	@SuppressWarnings("rawtypes")
	public List lazyLoadEntities(Class clz, Integer first, Integer pageSize,
			String sortField, boolean assending, Map<String, Object> filters) {
		Query query = prepareLazyLoadingQuery(clz, first, pageSize, sortField,
				assending, filters, false);
		query.setFetchSize(pageSize);
		query.setFirstResult(first);
		List result = query.list();  
		return result;
	}

	@SuppressWarnings("rawtypes")
	public Integer getCountOfResults(Class clz, Map<String, Object> filters) {
		Query query = prepareLazyLoadingQuery(clz, null, null, null, false,
				filters, true);
		return ((Long) Utils.getFirstResult(query.list())).intValue();
	}  

	@SuppressWarnings("rawtypes")
	private Query prepareLazyLoadingQuery(Class clz, Integer first,
			Integer pageSize, String sortField, boolean assending,
			Map<String, Object> filters, boolean count) {
		StringBuilder stringBuilder = new StringBuilder();
		if (count) {
			stringBuilder.append(String.format(
					"select count( o ) from %s o where 1=1 ",
					clz.getCanonicalName()));
		} else {
			stringBuilder.append(String.format("select o from %s o where 1=1 ",
					clz.getCanonicalName()));
		}
		int counter = 1;
		Map<String, Object> queryParams = new LinkedHashMap<String, Object>();

		for (String field : filters.keySet()) {
			Object filterValue = filters.get(field);
			Class fieldClass = Utils.getFilterClass(field, clz);
			String alias = null;
			alias = Utils.dublicate(ALIAS, counter++);

			
				if (fieldClass == String.class) {
					stringBuilder.append(String.format("and lower( o.%s ) like lower( CONCAT(  :%s ,'%s')   ) ",
							field, alias,"%"));
  
					queryParams.put(alias, ((String) filterValue ).trim() );

				} else if (Utils.isPrimitiveDataType(fieldClass)) {
					if (Utils.isAString(filterValue)) {
						Object object = Utils.initiatePrimitiveObject(
								fieldClass, (String) filterValue);
						stringBuilder.append(String.format(" and o.%s =:%s ",
								field, alias));
						queryParams.put(alias, object);
					}
				} else if (fieldClass == Date.class) {
					String secondAlias = Utils.dublicate(alias, ++counter);
					stringBuilder.append(String.format(
							" and o.%s >= :%s and o.%s <= :%s ", field, alias,field,  
							secondAlias));
					Date startDate = Utils.getStartOfDay((Date) filterValue);
					Date endDate = Utils.getEndOfDay((Date) filterValue);
					queryParams.put(alias, startDate);
					queryParams.put(secondAlias, endDate);
				} else {
					stringBuilder.append(String.format(" and  o.%s =:%s ",
							field, alias));
					queryParams.put(alias, filters.get(field));
				}

			
		}

		if (Utils.isNotEmptyString(sortField)) {
			stringBuilder.append(String.format(" order by %s %s", sortField,
					assending == false ? "desc " : ""));
		}
		Query query = getCurrentSession().createQuery(stringBuilder.toString());

		for (String alia : queryParams.keySet()) {
			
			query.setParameter(alia, queryParams.get(alia));
			
		}
		return query;

	}

	
}
