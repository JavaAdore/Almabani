package com.almabani.business.serviceimp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.ItemsQuotSupplierService;
import com.almabani.common.constant.DataAccessConstants;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.adminoam.OamItemsQuotSupplier;
import com.almabani.common.util.Utils;
import com.almabani.dataaccess.dao.adminoam.ItemsQuotSupplierDAO;

@Service
public class ItemsQuotSupplierServiceImpl implements ItemsQuotSupplierService {

	@Autowired
	ItemsQuotSupplierDAO itemsQuotSupplierDAO;

	@Override
	public List<OamItemsQuotSupplier> loadOamItemsQuotSuppliers(int first,
			int pageSize, String sortField, boolean ascending,
			Map<String, Object> filters) {
		return itemsQuotSupplierDAO.loadOamItemsQuotSuppliers(first, pageSize,
				sortField, ascending, filters);
	}

	@Override
	public Integer getCountOfOamItemsQuotSupplier(Map<String, Object> filters) {
		return itemsQuotSupplierDAO.getCountOfOamItemsQuotSupplier(filters);
	}

	@Override
	public OamItemsQuotSupplier updateOamItemsQuotSupplier(
			OamItemsQuotSupplier oamItemsQuotSupplier,
			CommonDriverMap commonDriverMap) {
		Date date = new Date();
		oamItemsQuotSupplier.setLastModificationDate(date);
		oamItemsQuotSupplier.setModificationMakerName(commonDriverMap
				.getCurrentUserCode());
		if (Utils.isNotNull(oamItemsQuotSupplier.getSelectionDate())) {
			oamItemsQuotSupplier.setSelectionUserName(commonDriverMap
					.getCurrentUserCode());
			oamItemsQuotSupplier.setIndSelected(DataAccessConstants.YES);
		} else {
			oamItemsQuotSupplier.setIndSelected(null);

		}
		return itemsQuotSupplierDAO.addOrUpdate(oamItemsQuotSupplier);
	}

	@Override
	public OamItemsQuotSupplier addOamItemsQuotSupplier(
			OamItemsQuotSupplier oamItemsQuotSupplier,
			CommonDriverMap commonDriverMap) {
		Date date = new Date();
		oamItemsQuotSupplier.setLastModificationDate(date);
		oamItemsQuotSupplier.setModificationMakerName(commonDriverMap
				.getCurrentUserCode());
		if (Utils.isNotNull(oamItemsQuotSupplier.getSelectionDate())) {
			oamItemsQuotSupplier.setSelectionUserName(commonDriverMap
					.getCurrentUserCode());
			oamItemsQuotSupplier.setIndSelected(DataAccessConstants.YES);
		} else {
			oamItemsQuotSupplier.setIndSelected(null);

		}
		return itemsQuotSupplierDAO.addOrUpdate(oamItemsQuotSupplier);
	}

}
