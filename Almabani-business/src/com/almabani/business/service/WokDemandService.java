package com.almabani.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminwkf.WokDemand;

@Service
public interface WokDemandService {

	WokDemand getWokDemand(Long id);

	List<WokDemand> getWokDemands();

	List<WokDemand> getWokDemands(Company company);

	
}
