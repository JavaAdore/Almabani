package com.almabani.business.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.WokDemandService;
import com.almabani.common.entity.schema.adminwkf.WokDemand;
import com.almabani.dataaccess.dao.adminwkf.WokDemandDAO;

@Service
public class WokDemandServiceImp implements WokDemandService {
	
	
	@Autowired
	private WokDemandDAO wokDemandDAO;

	@Override
	public WokDemand getWokDemand(Long id) {
		return wokDemandDAO.getWokDemand( id);
	}

	@Override
	public List<WokDemand> getWokDemands() {
		return wokDemandDAO.getWokDemands();
	}


	
	

	
	

}
