package com.almabani.portal.spring;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.primefaces.model.menu.Submenu;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.almabani.common.dto.menu.Access;
import com.almabani.common.dto.menu.Application;
import com.almabani.common.dto.menu.ApplicationAccess;
import com.almabani.common.dto.menu.Module;
import com.almabani.common.dto.menu.SubModule;
//import com.almabani.common.entity.schema.adminsec.SecUser;
import com.almabani.common.entity.schema.adminsec.SecUser;
import com.almabani.common.util.Utils;
import com.almabani.portal.webutils.WebUtils;

public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Map<String, ApplicationAccess> allowedURLs = new HashMap<String, ApplicationAccess>();
	MenuModel menuModel = new DefaultMenuModel();
 
	private SecUser user; 

	public CustomUserDetails(SecUser user) {
		super();
		this.user = user;
	}

	@Override
	public boolean isEnabled() {
		if(Utils.isNotNull(user))
		{
			return user.isActive();
		}
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public String getUsername() {
		return user.getUserLoginCode();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();

	@Override
	public Collection<GrantedAuthority> getAuthorities() {

		return auths;
	}

	public void assignAllowedUrls(List<Module> modules) {

		if (Utils.isNotEmptyList(modules)) {
			for (Module module : modules) {
				Submenu submenu = new DefaultSubMenu(module.getModuleName());

				for (SubModule subModule : module.getSubModules()) {

					Submenu innerSubMenu = new DefaultSubMenu(
							subModule.getSubModuleName());

					for (Application application : subModule.getApplications()) {

						DefaultMenuItem menuItem = new DefaultMenuItem(
								application.getApplicationName());
						menuItem.setUrl("/" + application.getUrl());
						String abstractAppURL = WebUtils.trimSlashs(application.getUrl());; 
						allowedURLs
								.put(abstractAppURL,
										new ApplicationAccess(
												abstractAppURL,
												application.getPerfilCode()
														.equals(Access.FULL
																.toString()) ? Access.FULL
														: Access.READ));

						innerSubMenu.getElements().add(menuItem);
					}

					submenu.getElements().add(innerSubMenu);
				}
				menuModel.getElements().add(submenu);

			}
		}

	}

	public MenuModel getMenuModel() {
		return menuModel;
	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}

	public SecUser getUser() {
		return user;
	}

	public void setUser(SecUser user) {
		this.user = user;
	}

	public Map<String, ApplicationAccess> getAllowedURLs() {
		return allowedURLs;
	}

	public void setAllowedURLs(Map<String, ApplicationAccess> allowedURLs) {
		this.allowedURLs = allowedURLs;
	}

}
