package com.almabani.business.serviceimp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.ModuleService;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.adminsec.SecModule;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.dataacceess.dao.adminsec.ModuleDAO;

@Service
public class ModuleServiceImpl implements ModuleService {
	
	
	@Autowired
	private ModuleDAO moduleDAO;


	@Override
	public List<SecModule> loadModules(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters){
		return moduleDAO.loadModules(first,pageSize,sortField,assending,filters);
	}

	

	@Override
	public Integer getCountOfSecModule(Map<String, Object> filters) {
		return moduleDAO.getCountOfModule( filters);
	}

	@Override
	public List<SecModule> getAllModules() {
		return moduleDAO.getAllModules();
	}



	@Override
	public SecModule addModule(SecModule secModule,
			CommonDriverMap commonDriverMap) throws AlmabaniException {
		Date date = new Date();
		secModule.setLastModificationDate(date);
		secModule.setModificationMakerName(commonDriverMap.getCurrentUserCode());
		
		return moduleDAO.addOrUpdateModule(secModule);
	}



	@Override
	public SecModule getModule(Long id) {
		
		return moduleDAO.getModule(id);
	}



	@Override
	public SecModule updateModule(SecModule secModule,
			CommonDriverMap commonDriverMap) throws AlmabaniException {
		Date date = new Date();
		secModule.setLastModificationDate(date); 
		secModule.setModificationMakerName(commonDriverMap.getCurrentUserCode());
		
		return moduleDAO.addOrUpdateModule(secModule);
	}

	
	

}
