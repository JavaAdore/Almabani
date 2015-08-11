 package com.almabani.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.adminsec.SecTypesPerfil;

@Service
public interface PrefilTypeService {

	

	SecTypesPerfil getTypePrefil(String profileCode );

	List<SecTypesPerfil> getAllPrefilTypes();

	
}
