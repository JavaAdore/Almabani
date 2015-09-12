package com.almabani.portal.spring;

import java.io.Serializable;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.almabani.portal.managedbean.LoginHandlerBean;
  
public class CustomDataSourceRouter extends AbstractRoutingDataSource implements  Serializable {

	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected Object determineCurrentLookupKey() {
		return LoginHandlerBean.awsDataBase ?"aws":"local";
		
	}

	
	
 	
}

