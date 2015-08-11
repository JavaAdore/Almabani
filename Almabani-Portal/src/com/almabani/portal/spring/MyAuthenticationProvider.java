package com.almabani.portal.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.almabani.business.facade.AlmabaniFacade;
import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.dto.menu.Module;
import com.almabani.common.entity.schema.adminsec.SecUser;
import com.almabani.common.util.Utils;

@Service
public class MyAuthenticationProvider extends
		AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private CustomUserDetailsService userDetailsService;
	@Autowired
	private AlmabaniFacade almabaniFacade;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		return super.authenticate(authentication);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {

		checkUserActivity(((CustomUserDetails) userDetails).getUser());
		if (Utils.isNotNull(userDetails.getPassword())
				&& Utils.isNotNull(authentication.getCredentials())
				&& Utils.isNotNull(authentication.getCredentials().toString())) {
			if (Utils.isNotNull(userDetails.getPassword())) {
				if (userDetails.getPassword().equals(
						authentication.getCredentials().toString()) == false) {
					throw new BadCredentialsException(
							MessagesKeyStore.ALMABANI_BAD_CREDENTIALS);
				}
			}
		}

		if (userDetails instanceof CustomUserDetails) {
			List<Module> modules = almabaniFacade.loadUserModule(userDetails
					.getUsername());
			if (Utils.isNotEmptyList(modules)) {
				((CustomUserDetails) (userDetails)).assignAllowedUrls(modules);
			}
		}

	}  

	private void checkUserActivity(SecUser user) {
		if (user.isActive() == false) {
			throw new BadCredentialsException(
					MessagesKeyStore.ALMABANI_IN_ACTIVE_USER);
		}
	}

	@Override
	protected UserDetails retrieveUser(String username,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		UserDetails userDetails = userDetailsService
				.loadUserByUsername(username);
		return userDetails;

	}

}
