package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;

@ManagedBean
@ViewScoped
public class TestBean extends AbstractBeanHelper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void test() {
		List object = almabaniFacade.getAllStockItems();

		System.out.println();
	}

}
