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

import com.almabani.common.entity.schema.adminoam.OamItemQuotation;
import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class QuotationApplicationController extends AbstractBeanHelper
		implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private OamItemQuotation oamItemQuotation;

	@ManagedProperty("#{oamItemsQuotSupplierManagementBean}")
	private OamItemsQuotSupplierManagementBean oamItemsQuotSupplierManagementBean;

	private OamQuotation quotation;

	@ManagedProperty("#{quotationItemManagementBean}")
	private QuotationItemManagementBean quotationItemManagementBean;

	@ManagedProperty("#{quotationManagementBean}")
	private QuotationManagementBean quotationManagementBean;

	private int activeTabIndex = 0;

	@PostConstruct
	public void init() {
		quotationItemManagementBean.setQuotationApplicationController(this);
		quotationManagementBean.setQuotationApplicationController(this);
		oamItemsQuotSupplierManagementBean
				.setQuotationApplicationController(this);
	}

	public void setOamItemQuotation(OamItemQuotation oamItemQuotation) {
		this.oamItemQuotation = oamItemQuotation;
		oamItemsQuotSupplierManagementBean
				.setParentQuotationItem(oamItemQuotation);
	}

	public void setOamItemsQuotSupplierManagementBean(
			OamItemsQuotSupplierManagementBean oamItemsQuotSupplierManagementBean) {
		this.oamItemsQuotSupplierManagementBean = oamItemsQuotSupplierManagementBean;
	}

	public void setQuotation(OamQuotation quotation) {
		this.quotation = quotation;
		if (Utils.isNotNull(quotation)
				&& Utils.isNotNull(quotationItemManagementBean)) {
			quotationItemManagementBean.setParentQuotation(quotation);
			WebUtils.invokeJavaScriptFunction("updateListForm()");
		}
	}

	public void setQuotationItemManagementBean(
			QuotationItemManagementBean quotationItemManagementBean) {
		this.quotationItemManagementBean = quotationItemManagementBean;
	}

	public void setQuotationManagementBean(
			QuotationManagementBean quotationManagementBean) {
		this.quotationManagementBean = quotationManagementBean;
	}

	public final void onTabChange(final TabChangeEvent event) {
		//This code was taken directly from TabViewRenderer.
		  FacesContext context = FacesContext.getCurrentInstance();
		  Map<String, String> params = context.getExternalContext().getRequestParameterMap();
		  TabView tabView = (TabView) event.getComponent();
		  String activeIndexValue = params.get(tabView.getClientId(context) + "_tabindex");
  
		  //this.activeTab = Integer.parseInt(activeIndexValue);
		  this.activeTabIndex = Integer.parseInt(activeIndexValue); 
	}
	
	public OamItemQuotation getOamItemQuotation() {
		return oamItemQuotation;
	}
	
	public OamItemsQuotSupplierManagementBean getOamItemsQuotSupplierManagementBean() {
		return oamItemsQuotSupplierManagementBean;
	}

	public OamQuotation getQuotation() {
		return quotation;
	}

	public QuotationItemManagementBean getQuotationItemManagementBean() {
		return quotationItemManagementBean;
	}

	public QuotationManagementBean getQuotationManagementBean() {
		return quotationManagementBean;
	}

	public int getActiveTabIndex() {
		return activeTabIndex;
	}

	public void setActiveTabIndex(int activeTabIndex) {
		this.activeTabIndex = activeTabIndex;
	}

	public void refreshQuotaionList() {
		quotationItemManagementBean.refreshQuotationList();
		
	}

	public void refreshQuotationItemList() {
		
		oamItemsQuotSupplierManagementBean.refreshQuotationItemList();
	}

}
