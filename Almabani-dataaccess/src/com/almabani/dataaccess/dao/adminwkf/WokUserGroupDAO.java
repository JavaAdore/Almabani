package com.almabani.dataaccess.dao.adminwkf;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.adminsec.SecUser;
import com.almabani.common.entity.schema.adminwkf.WokTypeProfile;
import com.almabani.common.entity.schema.adminwkf.WokUserGroup;
import com.almabani.common.entity.schema.adminwkf.WokWorkingGroup;

@Repository
public interface WokUserGroupDAO {

	List<WokUserGroup> getUserGroups(WokTypeProfile profile,
			WokWorkingGroup wokWorkingGroup, SecUser memberOfWorkGroup);

	WokUserGroup getWokUserGroup(Long id);

	List<WokUserGroup> getInteractionOccurenceUserGroups(
			WokTypeProfile wokTypeProfile, WokWorkingGroup wokWorkingGroup,
			SecUser secUser);

	

}
