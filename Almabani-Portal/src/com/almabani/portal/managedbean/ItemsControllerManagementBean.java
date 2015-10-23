package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.tabview.TabView;
import org.primefaces.event.TabChangeEvent;

import com.almabani.common.entity.schema.adminoam.OamItem;
import com.almabani.common.entity.schema.adminoam.OamItemQuotation;
import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class ItemsControllerManagementBean extends AbstractBeanHelper
		implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{itemManagementBean}")
	private ItemManagementBean itemManagementBean;
	
	@ManagedProperty("#{projectItemManagementBean}")
	private ProjectItemManagementBean projectItemManagementBean;

	@PostConstruct
	public void init() {
		
		itemManagementBean.setItemsControllerManagementBean(this);
		projectItemManagementBean.setItemsControllerManagementBean(this);
	}

	
	
	
	public ItemManagementBean getItemManagementBean() {
		return itemManagementBean;
	}

	public void setItemManagementBean(ItemManagementBean itemManagementBean) {
		this.itemManagementBean = itemManagementBean;
	}

	public ProjectItemManagementBean getProjectItemManagementBean() {
		return projectItemManagementBean;
	}

	public void setProjectItemManagementBean(
			ProjectItemManagementBean projectItemManagementBean) {
		this.projectItemManagementBean = projectItemManagementBean;
	}




	public void setSelectedItem(OamItem selected) {
		projectItemManagementBean.setSelectedItem(selected);
		
	}

	
}
