package com.almabani.dataacceess.dao.adminsec;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.adminsec.SecUser;
import com.almabani.dataaccess.dao.AbstractDAOInt;
@Repository
public interface SecUserDAO extends AbstractDAOInt{

	SecUser getUser(String userLoginCode);

	List<SecUser> getAllUsers();

	List<SecUser> loadUsers(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters);

	SecUser saveOrUpdate(SecUser user);

	Integer getNumberOfUser(Map<String, Object> filters);

	
}
