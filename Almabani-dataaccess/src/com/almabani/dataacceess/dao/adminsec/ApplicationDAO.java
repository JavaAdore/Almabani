package com.almabani.dataacceess.dao.adminsec;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.dto.UserApplicationGrant;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminsec.ApplicationType;
import com.almabani.common.entity.schema.adminsec.SecApplication;
import com.almabani.common.entity.schema.adminsec.SecApplicationGrants;
import com.almabani.common.entity.schema.adminsec.SecApplicationsCompany;
import com.almabani.common.entity.schema.adminsec.SecUser;
import com.almabani.dataaccess.dao.AbstractDAOInt;


  
@Repository
public interface ApplicationDAO extends AbstractDAOInt{

	Integer getCountOfApplications(Map<String, Object> filters);

	List<SecApplication> loadApplications(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters);

	SecApplication addOrUpdateApplication(SecApplication application);

	SecApplication getApplication(Long applicationId);

	List<SecApplication> getAllApplications();

	ApplicationType getApplicationType(Long id);

	List<ApplicationType> getAllApplicationTypes();

	List<UserApplicationGrant> getAllUserApplications();

	List<UserApplicationGrant>  getGrantedApplication(Company company);

	Map<SecApplication, SecApplicationGrants> getGrantedApplication(SecUser secUser, Company company);

	void revokeOldAccess(SecUser secUser , Company company);

	SecApplicationGrants addApplicationGrant(SecApplicationGrants secApplicationGrants);

	SecApplicationsCompany addCompanyApplicationGrant(SecApplicationsCompany secApplicationCompany);

	void revokeOldAccess(Company company);

	List<SecApplicationsCompany> getSecApplicationsCompany(Company company);

	void deleteUserGrants(List<SecApplicationsCompany> revokeGrantList);

	void deleteGrants(List<SecApplicationsCompany> revokeGrantList);
	SecApplication getApplication(String codApplication);

	Map<SecApplication, SecApplicationGrants> getGrantedApplication(
			CommonDriverMap commonDriverMap);

	List<UserApplicationGrant> getCompanyGrante(CommonDriverMap commonDriverMap);

	
}
