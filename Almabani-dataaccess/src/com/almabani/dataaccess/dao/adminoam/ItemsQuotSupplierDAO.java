package com.almabani.dataaccess.dao.adminoam;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.adminoam.OamItemQuotation;
import com.almabani.common.entity.schema.adminoam.OamItemsQuotSupplier;
import com.almabani.dataaccess.dao.AbstractDAOInt;
@Repository
public interface ItemsQuotSupplierDAO extends AbstractDAOInt{

	List<OamItemsQuotSupplier> loadOamItemsQuotSuppliers(int first,
			int pageSize, String sortField, boolean ascending,
			Map<String, Object> filters);

	Integer getCountOfOamItemsQuotSupplier(Map<String, Object> filters);

	OamItemsQuotSupplier addOrUpdate(OamItemsQuotSupplier oamItemsQuotSupplier);

	OamItemsQuotSupplier getSelectedSupplier(OamItemQuotation oamItemQuotation);

	void unselectOldSupplierOfQuotationItem(OamItemQuotation itemQuotation);


	
	
}
