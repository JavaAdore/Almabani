package com.almabani.portal.spring;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.adminsec.SecUser;
import com.almabani.common.util.Utils;
import com.almabani.portal.listener.SessionCapturerListener;

@Service 
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,
			Authentication authentication) throws IOException, ServletException {

		if (authentication != null && authentication.getDetails() != null) {
			try {

				SecurityContext securityContext = (SecurityContext) httpServletRequest
						.getSession().getAttribute("SPRING_SECURITY_CONTEXT");

				if (Utils.isNotNull(securityContext)
						&& Utils.isNotNull(securityContext.getAuthentication())
						&& Utils.isNotNull(securityContext.getAuthentication()
								.getPrincipal())) {
					if (Utils.isObjectInstanceOf(securityContext
							.getAuthentication().getPrincipal(),
							CustomUserDetails.class)) {
						SecUser currentSecUser = ((CustomUserDetails) securityContext
								.getAuthentication().getPrincipal()).getUser();
						SessionCapturerListener.getSessionmap().remove(
								currentSecUser);
					}
				}

				httpServletRequest.getSession().invalidate();
			} catch (Exception e) {
				e.printStackTrace();
				e = null;
			}
		}

		httpServletResponse.setStatus(HttpServletResponse.SC_OK);
		// redirect to login
		httpServletResponse.sendRedirect("/Login.xhtml");

	}

}
