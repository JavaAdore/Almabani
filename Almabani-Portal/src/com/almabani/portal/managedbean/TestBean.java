package com.almabani.portal.managedbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.almabani.dataaccess.dao.admincor.StateDAO;

@ManagedBean
@ViewScoped
public class TestBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value ="#{statesDAOImp}")
	private StateDAO stateDAO;
	
	public void test()
	{
		
		stateDAO.test();  
		
	}

	public StateDAO getStateDAO() {
		return stateDAO;
	}

	public void setStateDAO(StateDAO stateDAO) {
		this.stateDAO = stateDAO;
	}
}
