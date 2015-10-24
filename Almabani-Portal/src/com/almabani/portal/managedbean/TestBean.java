package com.almabani.portal.managedbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.almabani.dataaccess.dao.admincor.CompanyDAO;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;

@ManagedBean
@ViewScoped
public class TestBean extends AbstractBeanHelper implements Serializable {

	/**
	 * 
	 */
	
	@ManagedProperty(value = "#{companyDAOImp}")
	protected CompanyDAO companyDAO;
	
	private static final long serialVersionUID = 1L;

	public void test() {

		Object x = companyDAO.getAllCompanyViews();
		System.out.println(x);
	} 

	public CompanyDAO getCompanyDAO() {
		return companyDAO;
	}

	public void setCompanyDAO(CompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
	}

}
