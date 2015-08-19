package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.component.selectbooleancheckbox.SelectBooleanCheckbox;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.almabani.common.exception.AlmabaniException;
import com.almabani.portal.constant.PortalConstants;
import com.almabani.portal.listener.SessionCapturerListener;
import com.almabani.portal.spring.CustomUserDetails;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ViewScoped
public class LoginHandlerBean implements Serializable {


	@ManagedProperty(value = "#{authenticationManager}")
	private AuthenticationManager authenticationManager;

	private Map<String,String> datasources = new LinkedHashMap();
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	
	public static boolean awsDataBase ;
	  
	
	public boolean awsdb;
	
	@PostConstruct
	public void init()
	{
		datasources.put("Developement", "Development");
		datasources.put("Homologation", "Homologation");
		datasources.put("Production", "Production");
		datasources.put("aws", "aws");

		
	}

	public boolean isAwsdb() {
		return awsDataBase;
	}


	public void setAwsdb(boolean awsdb) {
		this.awsdb = awsdb;
		awsDataBase = awsdb; 
	}


	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}


	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	



	public UserSessionBean getUserSessionBean() {
		return userSessionBean;
	}


	public void setUserSessionBean(UserSessionBean userSessionBean) {
		this.userSessionBean = userSessionBean;
	}


	@ManagedProperty(value = "#{userSessionBean}")
	UserSessionBean userSessionBean;

	public void login() throws Exception {

		try {
			Authentication request = new UsernamePasswordAuthenticationToken(
					this.getUserName(), this.getPassword());
			Authentication result = authenticationManager.authenticate(request);
			SecurityContextHolder.getContext().setAuthentication(result);
			WebUtils.injectIntoSession("SPRING_SECURITY_CONTEXT",
					SecurityContextHolder.getContext());

			WebUtils.setCurrentlyLoggenUser(((CustomUserDetails) result
					.getPrincipal()).getUser());
			userSessionBean.constructUserMenu((CustomUserDetails) result
					.getPrincipal());
			WebUtils.setCookie("log", "log", 1000000000);
			SessionCapturerListener.getSessionmap().put(
					((CustomUserDetails) result.getPrincipal()).getUser(),
					WebUtils.prepareCurrentSessionDetailsHolder());

			WebUtils.redirectTo(PortalConstants.HOME_PAGE);

		} catch (Exception ex) {
			WebUtils.displayAlmabanyExceptionErrorMessage(new AlmabaniException(
					ex.getMessage()));
		}

	}


	public void checkChanged(AjaxBehaviorEvent e) {
		boolean result = (Boolean) ((SelectBooleanCheckbox) e.getSource())
				.getValue();
		
		awsDataBase = result;
		awsdb = result;  
	}
	
	



}
