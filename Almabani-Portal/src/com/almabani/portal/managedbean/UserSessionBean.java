package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.MenuModel;

import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.spring.CustomUserDetails;

@ManagedBean(eager=false) 
@SessionScoped
public class UserSessionBean extends AbstractBeanHelper implements Serializable {

	@PostConstruct
	public void init()
	{
		
		Locale browserLocale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
	}
	
	
	public MenuModel getMenuModel() {
		return menuModel;
	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MenuModel menuModel;

	public void constructUserMenu(CustomUserDetails customUserDetails) {
              
		menuModel = customUserDetails.getMenuModel();
		menuModel.addElement(new DefaultMenuItem("Help")); 
	}

}
