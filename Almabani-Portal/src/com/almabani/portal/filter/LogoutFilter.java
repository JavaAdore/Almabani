package com.almabani.portal.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContext;

import com.almabani.common.entity.schema.adminsec.SecUser;
import com.almabani.common.util.Utils;
import com.almabani.portal.listener.SessionCapturerListener;
import com.almabani.portal.spring.CustomUserDetails;

public class LogoutFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse respon,
			FilterChain chain) throws IOException, ServletException {

		
		SecurityContext securityContext = (SecurityContext) 	((HttpSession)((HttpServletRequest)request).getSession()).getAttribute("SPRING_SECURITY_CONTEXT");

		if(Utils.isNotNull(securityContext) && Utils.isNotNull( securityContext.getAuthentication())  && Utils.isNotNull(securityContext.getAuthentication().getPrincipal()))
		{
			if(Utils.isObjectInstanceOf(securityContext.getAuthentication().getPrincipal(), CustomUserDetails.class))
			{
				SecUser currentSecUser = ((CustomUserDetails)	securityContext.getAuthentication().getPrincipal()).getUser();
				SessionCapturerListener.getSessionmap().remove(currentSecUser);
			}
		}
		chain.doFilter(request, respon); 
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
