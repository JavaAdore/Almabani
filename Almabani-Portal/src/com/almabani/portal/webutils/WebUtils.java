package com.almabani.portal.webutils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeMap;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;

import com.almabani.common.annotataion.Bundle;
import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.dto.menu.ApplicationAccess;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Country;
import com.almabani.common.entity.schema.adminsec.SecUser;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.common.util.Utils;
import com.almabani.portal.common.SessionDetailsHolder;
import com.almabani.portal.constant.PortalConstants;
import com.almabani.portal.spring.CustomUserDetails;

public class WebUtils {
	public static final String WELCOME = "Welcome";

	public static Map<String, String> objectToMap(Object object) {
		Map<String, String> map = new TreeMap<String, String>();
		if (object != null) {
			for (Field field : object.getClass().getDeclaredFields()) {
				field.setAccessible(true);
				try {
					Object obj = field.get(object);
					if (obj != null) {
						map.put(camelCasingStylingToNormal(field.getName()),
								String.valueOf(obj));
					}
				} catch (IllegalArgumentException e) {

					e.printStackTrace();
				} catch (IllegalAccessException e) {

					e.printStackTrace();
				}

			}
		}
		return map;
	}

	public static String camelCasingStylingToNormal(String camelStyledString) {
		StringBuilder stringBuilder = new StringBuilder();
		if (camelStyledString != null) {
			char[] chars = camelStyledString.toCharArray();
			for (int i = 0; i < camelStyledString.toCharArray().length; i++) {
				char currentChar = chars[i];
				if (i == 0) {
					stringBuilder.append(String.valueOf(currentChar)
							.toUpperCase());
					continue;
				}
				if (((int) currentChar) >= 65 && ((int) currentChar) <= 90) {
					stringBuilder.append(" ");
					stringBuilder.append(String.valueOf(currentChar)
							.toUpperCase());

				} else {
					stringBuilder.append(String.valueOf(currentChar)
							.toLowerCase());

				}
			}
		}
		return stringBuilder.toString();
	}

	public static void fireErrorMessage(String key) {
		String messageToDisplay = extractFromBundle(key);
		fireMessage(FacesMessage.SEVERITY_ERROR, messageToDisplay);
	}

	public static void fireInfoMessage(String key) {
		String messageToDisplay = extractFromBundle(key);
		fireMessage(FacesMessage.SEVERITY_INFO, messageToDisplay);

	}

	public static void fireInfoMessage(String key, Set<String> params) {
		String messageToDisplay = extractFromBundle(key);
		if (Utils.isNotEmptySet(params)) {
			List<String> localizedParams = new ArrayList<String>();
			for (String param : params) {
				localizedParams.add(extractFromBundle(param));

			}
			MessageFormat messageFormat = new MessageFormat(messageToDisplay);
			messageToDisplay = messageFormat.format(localizedParams.toArray());
			fireMessage(FacesMessage.SEVERITY_INFO, messageToDisplay);

		} else {
			fireMessage(FacesMessage.SEVERITY_INFO, messageToDisplay);

		}

	}

	public static void fireErrorMessage(String key, Set<String> params) {
		String messageToDisplay = extractFromBundle(key);
		if (Utils.isNotEmptySet(params)) {
			List<String> localizedParams = new ArrayList<String>();
			for (String param : params) {
				localizedParams.add(extractFromBundle(param));

			}
			MessageFormat messageFormat = new MessageFormat(messageToDisplay);
			messageToDisplay = messageFormat.format(localizedParams.toArray());
			fireMessage(FacesMessage.SEVERITY_ERROR, messageToDisplay);

		} else {
			fireMessage(FacesMessage.SEVERITY_ERROR, messageToDisplay);

		}

	}

	public static void fireMessage(FacesMessage.Severity severity,
			String messageToDisplay) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage("", new FacesMessage(severity,
				messageToDisplay, ""));

	}

	public static String extractFromBundle(String key) {
		ResourceBundle bundle = FacesContext.getCurrentInstance()
				.getApplication()
				.getResourceBundle(FacesContext.getCurrentInstance(), "loc");
		try {
			return bundle.getString(key);
		} catch (Exception ex) {
			return key;
		}
	}

	public static void redirectTo(String homePage) {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect(homePage);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static String perpareWelcomeMessage(String firstName) {

		String welcome = extractFromBundle(WELCOME);
		return String.format("%s ,", welcome);
	}

	public static String getWarPath() {
		String targetedLocation = FacesContext.getCurrentInstance()
				.getExternalContext().getRealPath("/");

		return targetedLocation;

	}

	public static void invokeJavaScriptFunction(String functionWithParameter) {

		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.execute(functionWithParameter);
	}

	public static void fireDetailsIntoMessage(String key, String details) {
		String messageToDisplay = extractFromBundle(key);
		fireDetailedMessage(FacesMessage.SEVERITY_INFO, messageToDisplay,
				details);

	}

	private static void fireDetailedMessage(Severity severity, String title,
			String details) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage("", new FacesMessage(severity, title, details));

	}

	public static void invalidateSession() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		session.invalidate();

	}

	public static String getRealPath(String str) {
		String url = null;
		try {
			ExternalContext ext = FacesContext.getCurrentInstance()
					.getExternalContext();
			String path = ext.getRequestContextPath();
			path += path.endsWith("/") ? str : "/" + str;
			url = ext.encodeResourceURL(path);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return url;
	}

	// public static boolean isFileExistInWar(String filePath) {
	// String realFilePath = getRealPath(filePath);
	// InputStream stream = FacesContext.getCurrentInstance()
	// .getExternalContext().getResourceAsStream("/" + filePath);
	//
	// return stream != null;
	// }

	public static void injectIntoSession(String key, Object objectToInject) {
		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put(key, objectToInject);
	}

	public static Object extractFromSession(String key) {
		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		Object objectToReturn = sessionMap.get(key);
		return objectToReturn;

	}

	public static void fireExactInfoMessage(String message) {

		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage(FacesMessage.SEVERITY_INFO, "", message));

	}

	public static void fireExactInfoMessage(String name, String details) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage("", new FacesMessage(
				FacesMessage.SEVERITY_INFO, name, details));

	}

	public static Object extractFromRequest(String key) {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get(key);
	}

	public static void injectIntoRequest(String key, Object value) {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		request.setAttribute(key, value);

	}

	public static void fireInfoMessageAndKeep(String key, boolean keep) {

		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(keep);
		context.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO,
				extractFromBundle(key), ""));
	}

	public static void setKeepMessage(boolean keep) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(keep);

	}

	public static void hideFacesMessage(final int sleep) {
		new Thread() {
			public void run() {
				try {
					sleep(sleep);

					setKeepMessage(false);
				} catch (Exception ex) {
					// do Absolutely Nothing
				}
			}
		}.start();

	}

	public static void invokeJavaScriptFunctionLater(final String key,
			final int sleep) {
		new Thread() {
			public void run() {
				try {
					sleep(sleep);

					fireErrorMessage(key);

					setKeepMessage(false);
				} catch (Exception ex) {
					// do Absolutely Nothing
				}
			}
		}.start();

	}

	public static Set<String> prepareParamSet(String initialMessageToAdd) {
		Set<String> params = new LinkedHashSet<String>();
		if (Utils.isNotEmptyString(initialMessageToAdd)) {
			params.add(initialMessageToAdd);
		}
		return params;
	}

	public static void displayAlmabanyExceptionErrorMessage(AlmabaniException t) {
		fireErrorMessage(t.getKey(), t.getParameters());
	}

	public static SecUser getCurrentLoggedUser() {
		return (SecUser) extractFromSession(PortalConstants.CURRENTLY_LOGGIN_USER);

	}

	public static Company getCurrentLoggedUserCompany() {
		SecUser secUser = getCurrentLoggedUser();
		if (Utils.isNotNull(secUser)) {
			return secUser.getEmployee().getEstablishment().getCompany();

		}

		return null;

	}

	public static void setCurrentlyLoggenUser(SecUser user) {
		injectIntoSession(PortalConstants.CURRENTLY_LOGGIN_USER, user);
	}

	// public static Map<String, String> getDocumentTypeKeysAndValuesMap() {
	// Map<String, String> situationList = new HashMap<String, String>();
	//
	// for (DocumentType documentType : DocumentType.values()) {
	// situationList.put(documentType.getKey(),
	// getDocumentTypeValue(documentType.getKey()));
	// }
	// return situationList;
	// }
	//
	// private static String getDocumentTypeValue(String documentTypeKey) {
	//
	// if (Utils.isNotEmptyString(documentTypeKey)) {
	//
	// String documentTypeSitutationLocalizedMessage =
	// extractFromBundle(documentTypeKey);
	//
	// if (Utils.isNotEmptyString(documentTypeSitutationLocalizedMessage)) {
	//
	// return documentTypeSitutationLocalizedMessage;
	//
	// } else {
	//
	// return
	// WebUtils.extractFromBundle(MessagesKeyStore.ALMABANI_GENERAL_NOT_DEFINED_VALUE);
	// }
	// } else {
	// return WebUtils
	// .extractFromBundle(MessagesKeyStore.ALMABANI_GENERAL_EMPTY_STRING);
	// }
	// }
	public static String getCurrentUserCode() {
		SecUser seUser = getCurrentLoggedUser();
		if (Utils.isNotNull(seUser)) {
			return seUser.getUserLoginCode();
		}
		return "ALIBRAHIM";
	}

	public static Map<String, String> bundledObjectToMap(Object obj) {
		Map<String, String> map = new LinkedHashMap<String, String>();

		for (Field field : obj.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(Bundle.class)) {
				try {
					Bundle bundle = field.getAnnotation(Bundle.class);

					String key = bundle.key();
					String fieldName = field.getName().substring(0, 1)
							.toUpperCase();
					if (field.getName().length() > 1) {
						fieldName += field.getName().substring(1,
								field.getName().length());
					}

					Method method = obj.getClass().getDeclaredMethod(
							"get" + fieldName, null);
					Object val = method.invoke(obj, null);
					if (val != null) {
						if (val instanceof Date) {
							map.put(extractFromBundle(key),
									Utils.getFullDate((Date) val));
						} else {
							map.put(extractFromBundle(key), val.toString());

						}
					}
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return map;

	}

	public static boolean isAdminUser() {
		SecUser currentUser = getCurrentLoggedUser();
		if (Utils.isNotNull(currentUser)) {
			return currentUser.isAdminUser();
		}

		return false;
	}

	public static String trimSlashs(String url) {
		return url.replace("/", "").replace("\\", "");
	}

	public static Map<String, ApplicationAccess> getUserAllowedApps(
			Authentication authentication) {
		;
		if (Utils.isNotNull(authentication)

		&& Utils.isNotNull(authentication.getPrincipal())) {
			Object principal = authentication.getPrincipal();
			if (Utils.isObjectInstanceOf(principal, CustomUserDetails.class)) {
				Map<String, ApplicationAccess> mapToReturn = ((CustomUserDetails) principal)
						.getAllowedURLs();
				if (Utils.isNotNull(mapToReturn)) {

					return mapToReturn;
				}
			}
		}

		return new HashMap();
	}

	public static ApplicationAccess isAllowedURL(Authentication authentication,
			String abstractURL) throws AccessDeniedException {

		ApplicationAccess applicationAccess = getUserAllowedApps(authentication)
				.get(abstractURL);
		if (Utils.isNotNull(applicationAccess)) {
			return applicationAccess;
		}
		throw new AccessDeniedException(
				MessagesKeyStore.ALMABANI_GENERAL_ACCESS_DENIED_MESSAGE);
	}

	public static ApplicationAccess isAllowedURL(String abstractURL) {
		SecurityContext securityContext = (SecurityContext) extractFromSession("SPRING_SECURITY_CONTEXT");
		return isAllowedURL(securityContext.getAuthentication(), abstractURL);
	}

	public static String getCurrentPageURL() {
		return FacesContext.getCurrentInstance().getViewRoot().getViewId();
	}

	public static HttpSession getCurrentSession() {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
	}

	public static void setCookie(String name, String value, int expiry) {

		FacesContext facesContext = FacesContext.getCurrentInstance();

		HttpServletRequest request = (HttpServletRequest) facesContext
				.getExternalContext().getRequest();
		Cookie cookie = null;

		Cookie[] userCookies = request.getCookies();
		if (userCookies != null && userCookies.length > 0) {
			for (int i = 0; i < userCookies.length; i++) {
				if (userCookies[i].getName().equals(name)) {
					cookie = userCookies[i];
					break;
				}
			}
		}

		if (cookie != null) {
			cookie.setValue(value);
		} else {
			cookie = new Cookie(name, value);
			cookie.setPath(request.getContextPath());
		}

		HttpServletResponse response = (HttpServletResponse) facesContext
				.getExternalContext().getResponse();
		response.addCookie(cookie);
	}

	public static Cookie getCookie(String name) {

		FacesContext facesContext = FacesContext.getCurrentInstance();

		HttpServletRequest request = (HttpServletRequest) facesContext
				.getExternalContext().getRequest();
		Cookie cookie = null;

		Cookie[] userCookies = request.getCookies();
		if (userCookies != null && userCookies.length > 0) {
			for (int i = 0; i < userCookies.length; i++) {
				if (userCookies[i].getName().equals(name)) {
					cookie = userCookies[i];
					return cookie;
				}
			}
		}
		return null;
	}

	public static String getCurrentIpAddress() {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			ipAddress = request.getRemoteAddr();
		}
		return ipAddress;
	}

	public static String getCurrentDeviceTypeAddress() {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		if (request.getHeader("User-Agent").indexOf("Mobile") != -1) {
			return "Mobile Device";
		} else {
			return "Desktop Device";
		}
	}

	public static SessionDetailsHolder prepareCurrentSessionDetailsHolder() {
		SessionDetailsHolder sessionDetailsHolder = new SessionDetailsHolder();
		sessionDetailsHolder.setIpAddress(getCurrentIpAddress());
		sessionDetailsHolder.setLoginDate(new Date());
		sessionDetailsHolder.setDeviceType(getCurrentDeviceTypeAddress());
		sessionDetailsHolder.setSession(getCurrentSession());
		return sessionDetailsHolder;
	}

	public static void updatePrimeFacesComponent(String componentId) {
		RequestContext.getCurrentInstance().update(componentId);

	}
	
	
	public Date toGrenetchTime(Date date)
	{
		
		return new Date();    
	}	
	

}
