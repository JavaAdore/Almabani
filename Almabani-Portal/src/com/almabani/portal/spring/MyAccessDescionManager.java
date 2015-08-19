package com.almabani.portal.spring;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Service;

import com.almabani.portal.webutils.WebUtils;

@Service
public class MyAccessDescionManager implements AccessDecisionManager {

	@Override
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		
		FilterInvocation filterInvocation = (FilterInvocation) object;

		 
		String path = WebUtils.trimSlashs(filterInvocation.getRequestUrl());
	   	WebUtils.isAllowedURL(authentication , path); 
	}  

	@Override
	public boolean supports(ConfigAttribute attribute) {
		// TODO Auto-generated method stub
		System.out.println();

		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		System.out.println();

		return true;
	}

}
