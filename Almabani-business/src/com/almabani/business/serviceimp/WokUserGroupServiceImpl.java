package com.almabani.business.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.WokUserGroupService;
import com.almabani.common.entity.schema.adminsec.SecUser;
import com.almabani.common.entity.schema.adminwkf.WokTypeProfile;
import com.almabani.common.entity.schema.adminwkf.WokUserGroup;
import com.almabani.common.entity.schema.adminwkf.WokWorkingGroup;
import com.almabani.dataaccess.dao.adminwkf.WokUserGroupDAO;

@Service
public class WokUserGroupServiceImpl implements WokUserGroupService {

	@Autowired
	WokUserGroupDAO wokUserGroupDAO;

	@Override
	public List<WokUserGroup> getCommuincators(Object communicatorsParamValue,
			WokWorkingGroup wokWorkingGroup, SecUser secUser) {

		return wokUserGroupDAO.getUserGroups(
				new WokTypeProfile(new Long(String
						.valueOf(communicatorsParamValue))), wokWorkingGroup,
				secUser);
	}

	@Override
	public List<WokUserGroup> getSafetyAgents(Object safetyAgentsParamValue,
			WokWorkingGroup wokWorkingGroup, SecUser secUser) {

		return wokUserGroupDAO.getUserGroups(
				new WokTypeProfile(new Long(String
						.valueOf(safetyAgentsParamValue))), wokWorkingGroup,
				secUser);
	}

	@Override
	public List<WokUserGroup> getTechnicians(Object techincianParamValue,
			WokWorkingGroup wokWorkingGroup, SecUser secUser) {
		return wokUserGroupDAO.getUserGroups(
				new WokTypeProfile(new Long(String
						.valueOf(techincianParamValue))), wokWorkingGroup,
				secUser);
	}

	@Override
	public List<WokUserGroup> getOperators(Object operatorsParamValue,
			WokWorkingGroup wokWorkingGroup, SecUser secUser) {

		return wokUserGroupDAO.getUserGroups(
				new WokTypeProfile(new Long(String
						.valueOf(operatorsParamValue))), wokWorkingGroup,
				secUser);
	}

	@Override
	public WokUserGroup getWokUserGroup(Long id) {
		return wokUserGroupDAO.getWokUserGroup( id);
	}

}
