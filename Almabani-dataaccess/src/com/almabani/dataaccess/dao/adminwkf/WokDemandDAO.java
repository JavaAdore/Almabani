package com.almabani.dataaccess.dao.adminwkf;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminwkf.WokDemand;
import com.almabani.dataaccess.dao.AbstractDAOInt;

@Repository
public interface WokDemandDAO  extends AbstractDAOInt{

	WokDemand getWokDemand(Long id);

	List<WokDemand> getWokDemands();

	List<WokDemand> getWokDemands(Company company);

}
