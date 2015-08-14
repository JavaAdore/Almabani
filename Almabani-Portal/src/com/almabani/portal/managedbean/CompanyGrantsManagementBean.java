package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminsec.SecApplicationsCompany;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class CompanyGrantsManagementBean extends AbstractBeanHelper implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<SecApplicationsCompany> grantableApplications;

	private List<Company> companies;

	private Company company;

	@PostConstruct
	public void init() {
		initializeInitialLists();
	}

	private void initializeInitialLists() {

		initializeCompanyList();

	}

	public void loadGrantableApplications() {
		if (Utils.isNotNull(company)) {
			grantableApplications = almabaniFacade
					.getGrantableApplications(company);

			if (Utils.isEmptyList(grantableApplications)) {
				WebUtils.fireErrorMessage(MessagesKeyStore.ALMABANI_GRANTS_NO_APPLICATION_EXSIST);
			}
		}
  	}

	
	
	public void updateAccess()
	{
		CommonDriverMap commonDriverMap = 	 CommonDriverMap.appendCurrentUserCode(null, WebUtils.getCurrentUserCode());
		commonDriverMap = commonDriverMap.appendCompany(commonDriverMap, company);
		
		almabaniFacade.grantCompanyAccess(grantableApplications ,commonDriverMap  );
		WebUtils.fireInfoMessage(MessagesKeyStore.ALMABANI_GRANT_ACCESS_GRANTED_SUCCESSFULLY);
    
	}
	
	private void initializeCompanyList() {

		companies = almabaniFacade.getAllCompanies();
	}

	

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<SecApplicationsCompany> getGrantableApplications() {
		return grantableApplications;
	}

	public void setGrantableApplications(
			List<SecApplicationsCompany> grantableApplications) {
		this.grantableApplications = grantableApplications;
	}

}
