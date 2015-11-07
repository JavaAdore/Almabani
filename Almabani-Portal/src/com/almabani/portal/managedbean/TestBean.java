package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.HashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.SortOrder;

import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;

@ManagedBean
@ViewScoped
public class TestBean extends AbstractBeanHelper implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	public void test() {

		Object o = almabaniFacade.loadDepartmentSectionsView(1, 10, null,
				false, new HashMap());
		System.out.println(o); 
	}
}
