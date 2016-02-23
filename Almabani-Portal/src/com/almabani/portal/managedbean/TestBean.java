package com.almabani.portal.managedbean;
import java.io.Serializable;
import java.util.HashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.SortOrder;

import com.almabani.common.util.Configuration;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;

public class TestBean extends AbstractBeanHelper implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	public void test() {


		System.out.println("xx"); 
		
		myString();
	}
	
	
	public String myString()
	{
		return "welcome";
	}
}
