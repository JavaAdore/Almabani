package com.almabani.business.serviceimp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.SecUserService;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.adminsec.SecUser;
import com.almabani.dataacceess.dao.adminsec.SecUserDAO;

@Service
public class SecUserServiceImp implements SecUserService {

	@Autowired
	private SecUserDAO secUserDAO;

	@Override
	public SecUser getUser(String userLoginCode) {
		return secUserDAO.getUser(userLoginCode);
	}

	@Override
	public List<SecUser> getAllUsers() {
		return secUserDAO.getAllUsers();
	}

	@Override
	public List<SecUser> loadUsers(int first, int pageSize, String sortField,
			boolean ascending, Map<String, Object> filters) {
		return secUserDAO.loadUsers(first, pageSize, sortField, ascending,
				filters);
	}

	@Override
	public SecUser updateUser(SecUser user, CommonDriverMap commonDriverMap) {
		Date date = new Date();
		user.setLastModificationDate(date);
		user.setModificationMakerName(commonDriverMap.getCurrentUserCode());
		return secUserDAO.saveOrUpdate(user);
	}

	@Override
	public SecUser addUser(SecUser user, CommonDriverMap commonDriverMap) {
		Date date = new Date();
		user.setLastModificationDate(date);
		user.setModificationMakerName(commonDriverMap.getCurrentUserCode());
		user.setRegistrationDate(date); 
		return secUserDAO.saveOrUpdate(user);
	}

	@Override
	public Integer getNumberOfUser(Map<String, Object> filters) {
		return secUserDAO.getNumberOfUser(filters);
	}

}
