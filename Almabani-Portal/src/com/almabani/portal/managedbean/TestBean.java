package com.almabani.portal.managedbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.almabani.dataaccess.dao.admincor.CompanyDAO;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class TestBean extends AbstractBeanHelper implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	public void test() { 

		Object o = almabaniFacade.getWokDailyIccurrencesViewRecords("ALZAHER");
		System.out.println(o);
	}

}
