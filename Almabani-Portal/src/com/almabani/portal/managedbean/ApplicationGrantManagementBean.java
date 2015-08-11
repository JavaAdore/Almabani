package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.dto.UserApplicationGrant;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminsec.SecTypesPerfil;
import com.almabani.common.entity.schema.adminsec.SecUser;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class ApplicationGrantManagementBean extends AbstractBeanHelper
		implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<UserApplicationGrant> allApplications;

	private List<SecUser> users;

	private List<Company> companies;

	private Company activeCompany;

	private SecUser activeUser;

	private List<SecTypesPerfil> prefelTypes;

	@PostConstruct
	public void init() {
		initializeInitialLists();
	}

	private void initializeInitialLists() {

		initializeUsersList();
		initializeCompanyList();
		initializePrefilTypeList();

	}

	public void grantAccess() throws AlmabaniException {

		if (Utils.isNotEmptyList(allApplications)) {

			CommonDriverMap commonDriverMap = CommonDriverMap
					.appendCurrentUserCode(null, WebUtils.getCurrentUserCode());
			commonDriverMap = commonDriverMap.appendTargetUser(commonDriverMap,
					activeUser);
			commonDriverMap = commonDriverMap.appendCompany(commonDriverMap,
					activeCompany);
			almabaniFacade.grantAccess(allApplications, commonDriverMap);

			WebUtils.fireInfoMessage(MessagesKeyStore.ALMABANI_GRANT_ACCESS_GRANTED_SUCCESSFULLY);
		}
	}

	private void initializePrefilTypeList() {
		prefelTypes = almabaniFacade.getAllPrefilTypes();

	}

	public void displayGrants() {
		if (Utils.isNotNull(activeCompany) && Utils.isNotNull(activeUser)) {
			initializeAllApplicationsList(activeCompany, activeUser);
		} else {
			allApplications = new ArrayList();

		}
	}

	private void initializeCompanyList() {

		companies = almabaniFacade.getAllCompanies();
	}

	private void initializeUsersList() {
		users = almabaniFacade.getAllUsers();
	}

	private void initializeAllApplicationsList(Company company, SecUser secUser) {
		allApplications = almabaniFacade
				.getGrantedApplication(secUser, company);
		if (Utils.isEmptyList(allApplications)) {
			WebUtils.fireInfoMessage(MessagesKeyStore.ALMABANI_GRANTS_COMPANY_HAS_NO_GRANTS_TO_ANY_APPLICATION);
		}
	}

	public List<UserApplicationGrant> getAllApplications() {
		return allApplications;
	}

	public void setAllApplications(List<UserApplicationGrant> allApplications) {
		this.allApplications = allApplications;
	}

	public List<SecUser> getUsers() {
		return users;
	}

	public void setUsers(List<SecUser> users) {
		this.users = users;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Company getActiveCompany() {
		return activeCompany;
	}

	public void setActiveCompany(Company activeCompany) {
		this.activeCompany = activeCompany;
	}

	public SecUser getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(SecUser activeUser) {
		this.activeUser = activeUser;
	}

	public List<SecTypesPerfil> getPrefelTypes() {
		return prefelTypes;
	}

	public void setPrefelTypes(List<SecTypesPerfil> prefelTypes) {
		this.prefelTypes = prefelTypes;
	}
}
