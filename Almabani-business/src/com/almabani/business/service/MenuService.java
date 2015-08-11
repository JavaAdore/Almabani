package com.almabani.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.almabani.common.dto.menu.Module;

@Service
public interface MenuService {

	List<Module> loadUserModules(String userName);


}
