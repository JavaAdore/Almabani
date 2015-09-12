package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.dto.UserApplicationGrant;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminsec.SecModule;
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
	private List<SecModule> modules;

	private SecModule activeModule;

	@PostConstruct
	public void init() {
		initializeInitialLists();
	}

	private void initializeInitialLists() {

		initializeUsersList();
		initializeCompanyList();
		initializePrefilTypeList();
		initializeModulesList();

	}

	private void initializeModulesList() {
		modules = almabaniFacade.getAllModules();
	}

	public void grantAccess() throws AlmabaniException {

		if (Utils.isNotEmptyList(allApplications)) {

			CommonDriverMap commonDriverMap = CommonDriverMap
					.appendCurrentUserCode(null, WebUtils.getCurrentUserCode());
			commonDriverMap = commonDriverMap.appendTargetUser(commonDriverMap,
					activeUser);
			commonDriverMap = commonDriverMap.appendCompany(commonDriverMap,
					activeCompany);
			commonDriverMap = commonDriverMap.appendCurrentModule(
					commonDriverMap, activeModule);

			almabaniFacade.grantAccess(allApplications, commonDriverMap);

			WebUtils.fireInfoMessage(MessagesKeyStore.ALMABANI_GRANT_ACCESS_GRANTED_SUCCESSFULLY);
		}
	}

	private void initializePrefilTypeList() {
		prefelTypes = almabaniFacade.getAllPrefilTypes();

	}

	public void displayGrants() {
		if (Utils.isNotNull(activeCompany) && Utils.isNotNull(activeUser)) {
			CommonDriverMap commonDriverMap = new CommonDriverMap();
			commonDriverMap.appendTargetUser(commonDriverMap, activeUser);
			commonDriverMap = commonDriverMap.appendCompany(commonDriverMap,
					activeCompany);
			commonDriverMap = commonDriverMap.appendCurrentModule(
					commonDriverMap, activeModule);
			initializeAllApplicationsList(commonDriverMap);
		} else {
			allApplications = new ArrayList();

		}
	}

	private void initializeAllApplicationsList(CommonDriverMap commonDriverMap) {
		allApplications = almabaniFacade.getGrantedApplication(commonDriverMap);
		if (Utils.isEmptyList(allApplications)) {
			WebUtils.fireInfoMessage(MessagesKeyStore.ALMABANI_GRANTS_NO_RESULT_FOUND);
		}
	}

	private void initializeCompanyList() {
		if (WebUtils.getCurrentLoggedUser().isAdminUser()) {
			companies = almabaniFacade.getAllCompanies();
		} else {
			companies = new ArrayList();
			companies.add(WebUtils.getCurrentLoggedUser().getEmployee()
					.getEstablishment().getCompany());
		}
	}

	private void initializeUsersList() {
		if (WebUtils.getCurrentLoggedUser().isAdminUser()) {
			users = almabaniFacade.getAllUsers();
		} else {

			users = almabaniFacade.getCompanyUsers(WebUtils
					.getCurrentLoggedUser().getEmployee().getEstablishment()
					.getCompany());
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

	public List<SecModule> getModules() {
		return modules;
	}

	public void setModules(List<SecModule> modules) {
		this.modules = modules;
	}

	public SecModule getActiveModule() {
		return activeModule;
	}

	public void setActiveModule(SecModule activeModule) {
		this.activeModule = activeModule;
	}
}
