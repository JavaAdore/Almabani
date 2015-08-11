package com.almabani.portal.listener;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.security.core.context.SecurityContext;

import com.almabani.common.entity.schema.adminsec.SecUser;
import com.almabani.common.util.Utils;
import com.almabani.portal.common.SessionDetailsHolder;
import com.almabani.portal.spring.CustomUserDetails;

public class SessionCapturerListener implements HttpSessionListener{

	public static final Map<SecUser ,SessionDetailsHolder > sessionMap = new LinkedHashMap();
	
	@Override
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {

		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		SecurityContext securityContext = (SecurityContext) 	httpSessionEvent.getSession().getAttribute("SPRING_SECURITY_CONTEXT");

		if(Utils.isNotNull(securityContext) && Utils.isNotNull( securityContext.getAuthentication())  && Utils.isNotNull(securityContext.getAuthentication().getPrincipal()))
		{
			if(Utils.isObjectInstanceOf(securityContext.getAuthentication().getPrincipal(), CustomUserDetails.class))
			{
				SecUser currentSecUser = ((CustomUserDetails)	securityContext.getAuthentication().getPrincipal()).getUser();
				sessionMap.remove(currentSecUser);
			}
		}
		
	}

	  
}
