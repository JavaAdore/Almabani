package com.almabani.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.adminsec.SecUser;
import com.almabani.common.entity.schema.adminwkf.WokUserGroup;
import com.almabani.common.entity.schema.adminwkf.WokWorkingGroup;

@Service
public interface WokUserGroupService {

	
	List<WokUserGroup> getCommuincators(Object communicatorsParamValue,WokWorkingGroup wokWorkingGroup , SecUser secUser);
			
	List<WokUserGroup> getSafetyAgents(Object safetyAgentsParamValue,WokWorkingGroup wokWorkingGroup , SecUser secUser);

	List<WokUserGroup> getTechnicians(Object techincianParamValue, WokWorkingGroup wokWorkingGroup , SecUser secUser);

	List<WokUserGroup> getOperators(Object operatorsParamValue, WokWorkingGroup wokWorkingGroup , SecUser secUser);

	WokUserGroup getWokUserGroup(Long id);


	
}
