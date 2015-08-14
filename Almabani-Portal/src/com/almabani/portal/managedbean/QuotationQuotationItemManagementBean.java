package com.almabani.portal.managedbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.common.util.Utils;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class QuotationQuotationItemManagementBean extends AbstractBeanHelper implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private OamQuotation quotation;

	
	private QuotationItemManagementBean quotationItemManagementBean;

	public OamQuotation getQuotation() {
		return quotation;
	}


	public void setQuotation(OamQuotation quotation) {
		this.quotation = quotation;
		if(Utils.isNotNull(quotation) && Utils.isNotNull(quotationItemManagementBean)){   
		quotationItemManagementBean.setParentQuotation(quotation);
		WebUtils.invokeJavaScriptFunction("updateListForm()"); 
		}
	}


	public QuotationItemManagementBean getQuotationItemManagementBean() {
		return quotationItemManagementBean;
	}


	public void setQuotationItemManagementBean(
			QuotationItemManagementBean quotationItemManagementBean) {
		this.quotationItemManagementBean = quotationItemManagementBean;
	}
	
	
	    

	
	
	
	

	
	
}
