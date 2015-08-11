package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.adminoam.OamItemQuotation;
import com.almabani.common.entity.schema.adminoam.OamProjectItem;
import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.common.exception.AlmabaniException;
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
