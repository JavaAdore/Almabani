package com.almabani.business.serviceimp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.almabani.business.service.ItemCategoryService;
import com.almabani.common.entity.schema.admincor.Department;
import com.almabani.common.entity.schema.adminoam.OamItemCategory;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.dataaccess.dao.adminoam.ItemCategoryDAO;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {

	@Autowired
	private ItemCategoryDAO itemCategoryDAO;

	@Override
	public List<OamItemCategory> loadItemCategories(Integer first,
			Integer pageSize, String sortField, boolean assending,
			Map<String, Object> filters) {
		return itemCategoryDAO.loadItemCategories(first, pageSize, sortField,
				assending, filters);
	}

	@Transactional
	@Override
	public OamItemCategory addItemCategory(OamItemCategory company)
			throws AlmabaniException {

		return null;
	}

	@Override
	public OamItemCategory getItemCategory(Long id) {
		return itemCategoryDAO.getItemCategory(id);
	}

	@Transactional
	@Override
	public OamItemCategory updateItemCategory(OamItemCategory company)
			throws AlmabaniException {

		// String fedralIdentifierCode =company.getFederalIdentityCode();
		// if(Utils.isNull(result) ||company.getId() == result.getId())
		// {
		// try
		// {
		// return itemCategoryDAO.addOamItemCategory(company);
		// }catch(Exception ex)
		// {
		// AlmabaniException almabaniException = new
		// AlmabaniException(MessagesKeyStore.ALMABANI_GENERAL_NOT_ABLE_TO_UPDATE);
		// almabaniException.attachParameter(MessagesKeyStore.ALMABANI_GENERAL_COMPANY);
		// throw almabaniException;
		// }
		// }else
		// {
		// company.setFederalIdentityCode(fedralIdentifierCode);
		// throw new
		// AlmabaniException(MessagesKeyStore.ALMABANI_ADD_COMPANY_DUPLICATED_FEDRAIL_IDENTIFIER);
		// }

		return null;

	}

	@Override
	public Integer getCountOfItemCategory(Map<String, Object> filters) {
		return itemCategoryDAO.getCountOfItemCategories(filters);
	}

	@Override
	public List<OamItemCategory> getAllItemCategories() {
		return itemCategoryDAO.getAllItemCategories();
	}

	@Override
	public List<OamItemCategory> getAllItemCategories(Department department) {
		return itemCategoryDAO.getAllItemCategories( department);
	}

}
