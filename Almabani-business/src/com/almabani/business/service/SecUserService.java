package com.almabani.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.adminsec.SecUser;

@Service
public interface SecUserService {
	
	
	SecUser getUser(String userLoginCode);

	List<SecUser> getAllUsers();

	List<SecUser> loadUsers(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters);

	SecUser updateUser(SecUser user, CommonDriverMap commonDriverMap);

	SecUser addUser(SecUser user, CommonDriverMap commonDriverMap);

	Integer getNumberOfUser(Map<String, Object> filters);
}
