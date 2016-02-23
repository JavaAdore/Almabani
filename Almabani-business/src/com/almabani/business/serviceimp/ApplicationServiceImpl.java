package com.almabani.business.serviceimp;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.ApplicationService;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.dto.UserApplicationGrant;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminsec.ApplicationType;
import com.almabani.common.entity.schema.adminsec.SecApplication;
import com.almabani.common.entity.schema.adminsec.SecApplicationGrants;
import com.almabani.common.entity.schema.adminsec.SecApplicationsCompany;
import com.almabani.common.entity.schema.adminsec.SecUser;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.common.util.Utils;
import com.almabani.dataacceess.dao.adminsec.ApplicationDAO;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private ApplicationDAO applicationDAO;

	@Override
	public List<SecApplication> loadApplications(Integer first,
			Integer pageSize, String sortField, boolean assending,
			Map<String, Object> filters) {
		return applicationDAO.loadApplications(first, pageSize, sortField,
				assending, filters);
	}

	@Override
	public SecApplication getApplication(Long id) {
		return applicationDAO.getApplication(id);
	}

	@Override
	public Integer getCountOfApplications(Map<String, Object> filters) {
		return applicationDAO.getCountOfApplications(filters);
	}

	@Override
	public List<SecApplication> getAllApplications() {
		return applicationDAO.getAllApplications();
	}

	@Override
	public SecApplication addApplication(SecApplication secApplication,
			CommonDriverMap commonDriverMap) throws AlmabaniException {
		Date date =  Utils.getGrenetchTime();
		secApplication.setLastModificationDate(date);
		secApplication.setModificationMakerName(commonDriverMap
				.getCurrentUserCode());

		return applicationDAO.addOrUpdateApplication(secApplication);
	}

	@Override
	public SecApplication updateApplication(SecApplication secApplication,
			CommonDriverMap commonDriverMap) throws AlmabaniException {
		Date date =  Utils.getGrenetchTime();
		secApplication.setLastModificationDate(date);
		secApplication.setModificationMakerName(commonDriverMap
				.getCurrentUserCode());

		return applicationDAO.addOrUpdateApplication(secApplication);
	}

	@Override
	public ApplicationType getApplicationType(Long id) {

		return applicationDAO.getApplicationType(id);
	}

	@Override
	public List<ApplicationType> getAllApplicationTypes() {

		return applicationDAO.getAllApplicationTypes();
	}

	@Override
	public List<UserApplicationGrant> getAllUserApplications() {
		return applicationDAO.getAllUserApplications();
	}

	@Override
	public Map<SecApplication, UserApplicationGrant> getCompanyGrantedApps(
			CommonDriverMap commonDriverMap ) {
		List<UserApplicationGrant> result = applicationDAO.getCompanyGrante(commonDriverMap);
				
		Map<SecApplication, UserApplicationGrant> mapToReturn = new LinkedHashMap<SecApplication, UserApplicationGrant>();
		for (UserApplicationGrant userApplicationGrant : result) {
			mapToReturn.put(userApplicationGrant.getApplication(),
					userApplicationGrant);
		}
		return mapToReturn;
	}

	@Override
	public Map<SecApplication, SecApplicationGrants> getGrantedApplication(
			SecUser secUser, Company company) {
		return applicationDAO.getGrantedApplication(secUser, company);

	}

	@Override
	public void grantAccess(List<UserApplicationGrant> allApplications,
			CommonDriverMap commonDriverMap) {

		applicationDAO.revokeOldAccess(commonDriverMap.getTargetUser(),
				commonDriverMap.getAttachedCompany() , commonDriverMap.getTargetModule());
  
		List<SecApplicationGrants> grants = new ArrayList<SecApplicationGrants>();
		Date date =  Utils.getGrenetchTime();
		String modifiedByUserName = commonDriverMap.getCurrentUserCode();

		for (UserApplicationGrant userApplicationGrant : allApplications) {
			if (userApplicationGrant.isGranted()) {
				SecApplicationGrants secApplicationGrants = new SecApplicationGrants();
				secApplicationGrants
						.setApplicationsCompany(userApplicationGrant
								.getSecApplicationCompany());
				secApplicationGrants.setLastModificationDate(date);
				secApplicationGrants.setTypesPerfil(userApplicationGrant
						.getPrefilType());
				secApplicationGrants.setValidityBeginDate(date);
				secApplicationGrants
						.setModificationMakerName(modifiedByUserName);
				secApplicationGrants
						.setObservationDescription(modifiedByUserName);

				secApplicationGrants.setUserLoginCode(commonDriverMap
						.getTargetUser().getUserLoginCode());

				grants.add(secApplicationGrants);
				applicationDAO.addApplicationGrant(secApplicationGrants);
			}
		}

	}

	@Override
	public void grantCompanyAccess(
			List<SecApplicationsCompany> grantableApplications,
			CommonDriverMap commonDriverMap) {
		Company company = commonDriverMap.getAttachedCompany();
		List<SecApplicationsCompany> revokeGrantList = new ArrayList<SecApplicationsCompany>();
		Date date =  Utils.getGrenetchTime();
		String modifiedByUserName = commonDriverMap.getCurrentUserCode();
		for (SecApplicationsCompany secApplicationCompany : grantableApplications) {
			if (Utils.hasID(secApplicationCompany)
					&& secApplicationCompany.isGranted() == false) {
				secApplicationCompany.setLastModificationDate(date);
				secApplicationCompany
						.setModificationMakerName(modifiedByUserName);
				revokeGrantList.add(secApplicationCompany);
			} else if (secApplicationCompany.isGranted()) {
				secApplicationCompany.setCompany(company);
				secApplicationCompany.setLastModificationDate(date);
				secApplicationCompany
						.setModificationMakerName(modifiedByUserName);
				applicationDAO
						.addCompanyApplicationGrant(secApplicationCompany);
			}

		}

		if (Utils.isNotEmptyList(revokeGrantList)) {
			applicationDAO.deleteGrants(revokeGrantList);
		}

	}

	@Override
	public SecApplication getApplication(String codApplication) {
		return applicationDAO.getApplication(codApplication);
	}

	@Override
	public Map<SecApplication, SecApplicationGrants> getGrantedApplication(
			CommonDriverMap commonDriverMap) {
		return  applicationDAO.getGrantedApplication(commonDriverMap);
	}

	@Override
	public Map<String, String> getApplicationDescriptionMap() {
		return applicationDAO.getApplicationDescriptionMap();
	}
 
} 
