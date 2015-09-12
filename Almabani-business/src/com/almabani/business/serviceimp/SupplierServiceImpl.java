package com.almabani.business.serviceimp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.SupplierService;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.OamProjectItem;
import com.almabani.common.entity.schema.adminoam.OamSupplier;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.common.util.Utils;
import com.almabani.dataaccess.dao.admincor.SupplierDAO;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierDAO supplierDAO;

	@Override
	public List<OamSupplier> loadSuppliers(Integer first, Integer pageSize,
			String sortField, boolean assending, Map<String, Object> filters) {
		return supplierDAO.loadSuppliers(first, pageSize, sortField, assending,
				filters);
	}

	@Override
	public Integer getCountOfSupplier(Map<String, Object> filters) {
		return supplierDAO.getCountOfSupplier(filters);
	}

	@Override
	public List<OamSupplier> getAllSuppliers() {
		return supplierDAO.getAllSuppliers();
	}

	@Override
	public OamSupplier addSupplier(OamSupplier supplier,
			CommonDriverMap commonDriverMap) throws AlmabaniException {
		Date date = new Date();
		supplier.setLastModificationDate(date);
		supplier.setModificationMakerName(commonDriverMap.getCurrentUserCode());
		return supplierDAO.addOrUpdateSupplier(supplier);
	}

	@Override
	public OamSupplier updateSupplier(OamSupplier supplier,
			CommonDriverMap commonDriverMap) throws AlmabaniException {
		Date date = new Date();
		supplier.setLastModificationDate(date);
		supplier.setModificationMakerName(commonDriverMap.getCurrentUserCode());
		return supplierDAO.addOrUpdateSupplier(supplier);
	}

	@Override
	public OamSupplier getSupplier(Long id) {
		return supplierDAO.getSupplier(id);
	}

	@Override
	public List<OamSupplier> getAllSuppliers(Company company) {
		return supplierDAO.getAllSuppliers(company);
	}

	@Override
	public List<OamProjectItem> getAllProjectItems(
			String projectItemNameOrDescription, Company company) {
		if (Utils.isNull(company)) {
			return supplierDAO.getAllProjectItems(projectItemNameOrDescription);
		} else {
			return supplierDAO.getAllProjectItems(projectItemNameOrDescription,company);


		}
	}

}
