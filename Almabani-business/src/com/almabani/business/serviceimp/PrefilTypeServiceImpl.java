package com.almabani.business.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.PrefilTypeService;
import com.almabani.common.entity.schema.adminsec.SecTypesPerfil;
import com.almabani.dataacceess.dao.adminsec.PrefilTypeDAO;

@Service
public class PrefilTypeServiceImpl implements PrefilTypeService {
	
	
	@Autowired
	private PrefilTypeDAO prefilTypeDAO;

	@Override
	public SecTypesPerfil getTypePrefil(String profileCode) {
		return prefilTypeDAO.getTypePrefil( profileCode);
	}

	@Override
	public List<SecTypesPerfil> getAllPrefilTypes() {
		return prefilTypeDAO.getAllPrefilTypes();
	}


	
	

}
