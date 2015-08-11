package com.almabani.business.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.MenuService;
import com.almabani.common.dto.menu.Module;
import com.almabani.dataaccess.dao.admincor.MenuDAO;

@Service
public class MenuServiceImpl implements MenuService {
	
	
	@Autowired
	private MenuDAO menuDAO;

	@Override
	public List<Module> loadUserModules(String userName) {
		return menuDAO.getUserModules(userName);
	}


	
	
	

}
