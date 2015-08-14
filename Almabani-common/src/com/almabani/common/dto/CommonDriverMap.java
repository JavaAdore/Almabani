package com.almabani.common.dto;

import java.util.LinkedHashMap;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminsec.SecUser;

public class CommonDriverMap extends LinkedHashMap<String, Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public final static String CURRENT_USER_CODE = "CURRENT_USER_CODE";

	public final static String CURRENT_COMPANY = "CURRENT_COMPANY";

	private static final String TARGET_USER = "TARGET_USER";

	
	public CommonDriverMap setCurrentUserCode(String currentUserCode) {
		put(CURRENT_USER_CODE, currentUserCode);
		return this;
	}

	public String getCurrentUserCode() {
		return (String) get(CURRENT_USER_CODE);
	}

	public static CommonDriverMap appendCurrentUserCode(
			CommonDriverMap commonDriverMap, String currentUserCode) {

		if (commonDriverMap == null) {

			commonDriverMap = new CommonDriverMap();
		}
		return commonDriverMap.setCurrentUserCode(currentUserCode);

	}

	public CommonDriverMap appendCompany(CommonDriverMap commonDriverMap , Company activeCompany) {
		if (commonDriverMap == null) {

			commonDriverMap = new CommonDriverMap();
		}
		return commonDriverMap.setCurrentCompany(activeCompany);
	}

	private CommonDriverMap setCurrentCompany(Company activeCompany) {
		put(CURRENT_COMPANY, activeCompany);
		return this;
	}
	
	public Company getAttachedCompany()
	{
		return (Company) get(CURRENT_COMPANY);
	}

	public CommonDriverMap appendTargetUser(CommonDriverMap commonDriverMap,
			SecUser activeUser) {
		if (commonDriverMap == null) {

			commonDriverMap = new CommonDriverMap();
		}
		return commonDriverMap.setTargetUser(activeUser);
	}

	private CommonDriverMap setTargetUser(SecUser user) {
		put(TARGET_USER, user);
		return this;
	}
	
	public SecUser getTargetUser()
	{
		return (SecUser) get(TARGET_USER);
	}

}
