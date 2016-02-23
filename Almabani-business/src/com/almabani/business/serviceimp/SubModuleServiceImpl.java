package com.almabani.business.serviceimp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.SubModuleService;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.adminsec.SecModule;
import com.almabani.common.entity.schema.adminsec.SecSubModule;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.common.util.Utils;
import com.almabani.dataacceess.dao.adminsec.SubModuleDAO;

@Service
public class SubModuleServiceImpl implements SubModuleService {
	
	
	@Autowired
	private SubModuleDAO subModuleDAO;


	@Override
	public List<SecSubModule> loadSubModules(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters){
		return subModuleDAO.loadSubModules(first,pageSize,sortField,assending,filters);
	}

	

	@Override
	public Integer getCountOfSubModules(Map<String, Object> filters) {
		return subModuleDAO.getCountOfSubModules( filters);
	}

	@Override
	public List<SecSubModule> getAllSubModules() {
		return subModuleDAO.getAllSubModules();
	}



	@Override
	public SecSubModule addSubModule(SecSubModule secSubModule,
			CommonDriverMap commonDriverMap) throws AlmabaniException {
		Date date =  Utils.getGrenetchTime();
		secSubModule.setLastModificationDate(date);
		secSubModule.setModificationMakerName(commonDriverMap.getCurrentUserCode());
		return subModuleDAO.addOrUpdateSubModule(secSubModule);
	}



	@Override
	public SecSubModule getSubModule(Long id) {
		return subModuleDAO.getSubModule(id);
	}



	@Override
	public SecSubModule updateSubModule(SecSubModule secSubModule,
			CommonDriverMap commonDriverMap) throws AlmabaniException {
		Date date =  Utils.getGrenetchTime();
		secSubModule.setLastModificationDate(date);
		secSubModule.setModificationMakerName(commonDriverMap.getCurrentUserCode());
		return subModuleDAO.addOrUpdateSubModule(secSubModule);
	}



	@Override
	public List<SecSubModule> getSubModules(SecModule module) {
		
		return subModuleDAO.getSubModules( module);
	}

	
	

}
