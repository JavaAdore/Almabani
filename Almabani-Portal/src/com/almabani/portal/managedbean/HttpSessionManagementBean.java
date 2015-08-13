package com.almabani.portal.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.primefaces.component.selectbooleancheckbox.SelectBooleanCheckbox;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import com.almabani.common.entity.schema.adminsec.SecUser;
import com.almabani.portal.common.SessionDetailsHolder;
import com.almabani.portal.listener.SessionCapturerListener;
import com.almabani.portal.managedbean.applicationhelper.AbstractBeanHelper;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean
@ApplicationScoped
public class HttpSessionManagementBean extends AbstractBeanHelper implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Map<SecUser, SessionDetailsHolder> sessionMap;

	public Set<SecUser> usersToCick;

	@PostConstruct
	public void init() {

		sessionMap = SessionCapturerListener.getSessionmap();
		usersToCick = new HashSet();
	}

	public void checkChanged(AjaxBehaviorEvent e) {
		boolean add = (Boolean) ((SelectBooleanCheckbox) e.getSource())
				.getValue();
		SecUser user = (SecUser) ((SelectBooleanCheckbox) e.getSource())
				.getAttributes().get("user");
		
		if (add) {
			SecUser secUser = WebUtils.getCurrentLoggedUser();
			if (secUser.equals(user) == false) {
				usersToCick.add(user);
			}
		} else {
			usersToCick.remove(user);

		}
	}

	public void selectDeSelectAll(AjaxBehaviorEvent e) {
		boolean all = (Boolean) ((SelectBooleanCheckbox) e.getSource())
				.getValue();

		if (all) {
			SecUser currentUser = WebUtils.getCurrentLoggedUser();

			for (SecUser secUser : sessionMap.keySet()) {
				if (secUser.equals(currentUser) == false) {
				
					usersToCick.add(secUser);
				}
			}
		} else {
			usersToCick.clear();
		}

	}

	public void kickSelected() {
		for (final SecUser secUser : usersToCick) {
			new Thread() {
				public void run() {
					try {
						SessionDetailsHolder sessionDetailsHolder = sessionMap
								.get(secUser);

						sessionMap.remove(secUser);
						sessionDetailsHolder.getSession().invalidate();

			 		} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

			}.start();
		}
		usersToCick.clear();
	}

	public Map<SecUser, SessionDetailsHolder> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<SecUser, SessionDetailsHolder> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public Set<SecUser> getUsersToCick() {
		return usersToCick;
	}

	public void setUsersToCick(Set<SecUser> usersToCick) {
		this.usersToCick = usersToCick;
	}

}
