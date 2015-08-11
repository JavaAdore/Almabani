package com.almabani.portal.spring;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.almabani.business.facade.AlmabaniFacade;
import com.almabani.common.entity.schema.adminsec.SecUser;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private AlmabaniFacade almabanyFacade;

	@PostConstruct
	public void init() {

	}

	@SuppressWarnings("unused")
	@Override
	public UserDetails loadUserByUsername(String userLoginCode)
			throws UsernameNotFoundException {
		System.out.println("Trying to fetch user with login: " + userLoginCode);
		final SecUser user = almabanyFacade.getUser(userLoginCode);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		CustomUserDetails details = new CustomUserDetails(user);

		return details;
	}

}
