package com.almabani.dataaccess.dao.admincor;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.almabani.common.dto.menu.Module;

@Repository
public interface MenuDAO {

	
	public List<Module> getUserModules(String userLoginCode);
}
 