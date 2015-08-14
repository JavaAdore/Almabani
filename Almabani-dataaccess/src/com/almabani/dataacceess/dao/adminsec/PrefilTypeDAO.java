package com.almabani.dataacceess.dao.adminsec;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.adminsec.SecTypesPerfil;
import com.almabani.dataaccess.dao.AbstractDAOInt;


  
@Repository
public interface PrefilTypeDAO extends AbstractDAOInt{

	SecTypesPerfil getTypePrefil(String profileCode);

	List<SecTypesPerfil> getAllPrefilTypes();

	
	
}
