 package com.almabani.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.dto.UserApplicationGrant;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminsec.ApplicationType;
import com.almabani.common.entity.schema.adminsec.SecApplication;
import com.almabani.common.entity.schema.adminsec.SecApplicationGrants;
import com.almabani.common.entity.schema.adminsec.SecApplicationsCompany;
import com.almabani.common.entity.schema.adminsec.SecUser;
import com.almabani.common.exception.AlmabaniException;

@Service
public interface ApplicationService {

	Integer getCountOfApplications(Map<String, Object> filters);

	List<SecApplication> loadApplications(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters);

	SecApplication addApplication(SecApplication SecApplication, CommonDriverMap appendCurrentUserCode) throws AlmabaniException;

	SecApplication getApplication(Long id);

	SecApplication updateApplication(SecApplication SecApplication, CommonDriverMap appendCurrentUserCode) throws AlmabaniException;
	
	List<SecApplication> getAllApplications();

	ApplicationType getApplicationType(Long id);
	
	List<ApplicationType> getAllApplicationTypes();

	List<UserApplicationGrant> getAllUserApplications();

	Map<SecApplication, UserApplicationGrant> getGrantedApplication(Company company);

	Map<SecApplication, SecApplicationGrants> getGrantedApplication(SecUser secUser, Company company);

	void grantAccess(List<UserApplicationGrant> allApplications,
			CommonDriverMap commonDriverMap);

	void grantCompanyAccess(
			List<SecApplicationsCompany> grantableApplications,
			CommonDriverMap commonDriverMap);
}
