package com.almabani.business.serviceimp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.almabani.business.service.ItemCategoryService;
import com.almabani.common.dto.CommonDriverMap;
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

	@Override
	public OamItemCategory addItemCategory(OamItemCategory itemCategory,
			CommonDriverMap commonDriverMap) throws AlmabaniException {
		Date date = new Date();
		itemCategory.setLastModificationDate(date);
		itemCategory.setModificationMakerName(commonDriverMap
				.getCurrentUserCode());
		return itemCategoryDAO.addItemCategory(itemCategory);
	}

	@Override
	public OamItemCategory getItemCategory(Long id) {
		return itemCategoryDAO.getItemCategory(id);
	}

	@Override
	public OamItemCategory updateItemCategory(OamItemCategory itemCategory,
			CommonDriverMap commonDriverMap) throws AlmabaniException {

		Date date = new Date();
		itemCategory.setLastModificationDate(date);
		itemCategory.setModificationMakerName(commonDriverMap
				.getCurrentUserCode());
		return itemCategoryDAO.addItemCategory(itemCategory);

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
		return itemCategoryDAO.getAllItemCategories(department);
	}

}
