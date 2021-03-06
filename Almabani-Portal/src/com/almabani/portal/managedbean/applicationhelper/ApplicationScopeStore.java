package com.almabani.portal.managedbean.applicationhelper;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.almabani.business.facade.AlmabaniFacade;
import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.dto.FileHolder;
import com.almabani.common.dto.menu.Access;
import com.almabani.common.dto.menu.KeyValueHolder;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Country;
import com.almabani.common.entity.schema.admincor.State;
import com.almabani.common.entity.schema.adminsec.SecUser;
import com.almabani.common.enums.DocumentType;
import com.almabani.common.util.Utils;
import com.almabani.portal.constant.PortalConstants;
import com.almabani.portal.webutils.WebUtils;

@ManagedBean(eager = true)
@ApplicationScoped
public class ApplicationScopeStore implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{almabaniFacadeImp}")
	protected AlmabaniFacade almabaniFacade;

	private Map<String, String> oamQoutationSituationMap = new TreeMap<String, String>();

	private Map<String, String> oamQoutationTypeMap = new TreeMap<String, String>();

	private Map<String, String> documentTypeKeysAndValues;

	private Map<String, String> inOutMap = new TreeMap<String, String>();

	private List<Country> countries;

	private Map<Country, List<State>> countriesStatesMap = new HashMap<Country, List<State>>();

	private Map<String, String> unitTypesMap = new TreeMap<String, String>();

	private Map<String, String> yesNoMap = new LinkedHashMap<String, String>();

	private Map<String, String> languagesMap = new LinkedHashMap<String, String>();

	private Map<String, String> employeeTypeMap = new LinkedHashMap<String, String>();

	private Map<String, String> genderMap = new LinkedHashMap<String, String>();

	private Map<String, String> documentTypeMap = new LinkedHashMap<String, String>();

	private Map<String, String> maritalStatusMap = new LinkedHashMap<String, String>();

	private Map<String, String> contractTypeMap = new LinkedHashMap<String, String>();

	@PostConstruct
	public void init() {
		loadCountries();
		constructCountriesStatesMap();
		constructOamQoutationSituationMap();
		constructQoutationTypeMap();
		constructUnitTypesMap();
		constructYesNoMap();
		constructLangaugesMap();
		constructInOutMap();
		constructEmployeeTypeMap();
		contructGenderMap();
		constructDocumentTypeKeysAndValues();
		constructMaritalStatusMap();
		constructContractTypeMap();

	}

	private void constructContractTypeMap() {

		contractTypeMap.put("C", "EmployeeContractType_Contract");
		contractTypeMap.put("S", "EmployeeContractType_Support");

	}

	private void constructMaritalStatusMap() {

		maritalStatusMap.put("I", "MaritalStatus_SINGLE");
		maritalStatusMap.put("E", "MaritalStatus_ENGAGED");
		maritalStatusMap.put("M", "MaritalStatus_MARRIED");
		maritalStatusMap.put("S", "MaritalStatus_SEPARATED");
		maritalStatusMap.put("D", "MaritalStatus_DIVORCED");
		maritalStatusMap.put("W", "MaritalStatus_WIDOWED");
		maritalStatusMap.put("O", "MaritalStatus_OTHERS");

	}

	private void contructGenderMap() {
		genderMap.put("M", "Gender_MALE");
		genderMap.put("F", "Gender_FEMALE");
	}

	private void constructEmployeeTypeMap() {

		employeeTypeMap.put("E", "EmployeeType_EMPLOYEE");
		employeeTypeMap.put("T", "EmployeeType_TRAINEE");
		employeeTypeMap.put("C", "EmployeeType_COMMISSION");
		employeeTypeMap.put("P", "EmployeeType_PART_TIME");

	}

	private void constructLangaugesMap() {

		languagesMap.put("E", "LANGUAGE_ENGLISH");
		languagesMap.put("P", "LANGUAGE_PORTUGUESE");
		languagesMap.put("S", "LANGUAGE_SPANSIH");

	}

	private void constructInOutMap() {

		inOutMap.put("I", MessagesKeyStore.ALMABANI_STOCK_ITEM_INCOME);
		inOutMap.put("O", MessagesKeyStore.ALMABANI_STOCK_ITEM_OUTCOME);

	}

	private void constructYesNoMap() {

		yesNoMap.put("Y", MessagesKeyStore.ALMABANI_GENERAL_YES);
		yesNoMap.put("N", MessagesKeyStore.ALMABANI_GENERAL_NO);

	}

	private void constructUnitTypesMap() {

		unitTypesMap.put("RO", MessagesKeyStore.ALMABANI_UNIT_TYPE_ROLL);
		unitTypesMap.put("PC", MessagesKeyStore.ALMABANI_UNIT_TYPE_PEICE);
		unitTypesMap.put("BO", MessagesKeyStore.ALMABANI_UNIT_TYPE_BOX);
		unitTypesMap.put("GA", MessagesKeyStore.ALMABANI_UNIT_TYPE_GALON);
		unitTypesMap.put("BT", MessagesKeyStore.ALMABANI_UNIT_TYPE_BOTTLE);

	}

	private void constructQoutationTypeMap() {
		oamQoutationTypeMap.put("S",
				MessagesKeyStore.ALMABANI_QUOTATION_SPARE_PART);
		oamQoutationTypeMap.put("O",
				MessagesKeyStore.ALMABANI_QOUTATION_OFFICE_SUPPLY);
		oamQoutationTypeMap.put("K",
				MessagesKeyStore.ALMABANI_QUOTATAION_KITCHEN_SUPPLY);
		oamQoutationTypeMap
				.put("T", MessagesKeyStore.ALMABANI_QUOTATAION_TOOLS);
		oamQoutationTypeMap.put("C",
				MessagesKeyStore.ALMABANI_QUOTATAION_CONSUMABLES);
		oamQoutationTypeMap.put("U",
				MessagesKeyStore.ALMABANI_QUOTATAION_UNIFORMS);
		oamQoutationTypeMap.put("X",
				MessagesKeyStore.ALMABANI_QUOTATAION_OTHERS);

	}

	private void constructDocumentTypeKeysAndValues() {

		documentTypeMap = new TreeMap();

		for (DocumentType documentType : DocumentType.values()) {
			documentTypeMap.put(documentType.getKey(),
					WebUtils.extractFromBundle(documentType.getValue()));
		}
	}

	private void constructOamQoutationSituationMap() {

		oamQoutationSituationMap.put("N",
				MessagesKeyStore.ALMABANI_QOUTATION_TYPE_IN_QUOTATION);
		oamQoutationSituationMap.put("P",
				MessagesKeyStore.ALMABANI_QOUTATION_TYPE_IN_APPROVAL);
		oamQoutationSituationMap.put("A",
				MessagesKeyStore.ALMABANI_QOUTATION_TYPE_APPROVED);
		oamQoutationSituationMap.put("C",
				MessagesKeyStore.ALMABANI_QOUTATION_TYPE_CANCELED);

	}

	public void constructCountriesStatesMap() {
		countriesStatesMap.clear();

		for (Country country : countries) {
			List<State> states = almabaniFacade.getStates(country);
			if (Utils.isNotEmptyList(states)) {
				countriesStatesMap.put(country, states);
			}

		}
	}

	public void loadCountries() {
		countries = almabaniFacade.getAllCountries();
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public List<State> getStatesListByCountry(Country country) {

		return countriesStatesMap.get(country);
	}

	public AlmabaniFacade getAlmabaniFacade() {
		return almabaniFacade;
	}

	public void setAlmabaniFacade(AlmabaniFacade almabaniFacade) {
		this.almabaniFacade = almabaniFacade;
	}

	protected String getStringKey(java.lang.Long value) {
		StringBuffer sb = new StringBuffer();
		sb.append(value);
		return sb.toString();
	}

	public String getOamQoutationSituationValue(String situateionKey) {
		if (Utils.isNotEmptyString(situateionKey)) {
			String oamQoutationSituationMassage = oamQoutationSituationMap
					.get(situateionKey);
			if (Utils.isNotEmptyString(oamQoutationSituationMassage)) {
				String oamQoutationSitutationLocalizedMessage = WebUtils
						.extractFromBundle(oamQoutationSituationMassage);
				if (Utils
						.isNotEmptyString(oamQoutationSitutationLocalizedMessage)) {
					return oamQoutationSitutationLocalizedMessage;
				} else {
					return WebUtils
							.extractFromBundle(MessagesKeyStore.ALMABANI_GENERAL_NOT_DEFINED_VALUE);

				}
			} else {
				return WebUtils
						.extractFromBundle(MessagesKeyStore.ALMABANI_GENERAL_NOT_DEFINED_VALUE);
			}
		}
		return "";
	}

	public String getLanguage(String languageCode) {
		if (Utils.isNotEmptyString(languageCode)) {
			String langaugeKey = languagesMap.get(languageCode);
			if (Utils.isNotEmptyString(langaugeKey)) {
				String languageValue = WebUtils.extractFromBundle(langaugeKey);
				if (Utils.isNotEmptyString(languageValue)) {
					return languageValue;
				} else {
					return WebUtils
							.extractFromBundle(MessagesKeyStore.ALMABANI_GENERAL_NOT_DEFINED_VALUE);

				}
			} else {
				return WebUtils
						.extractFromBundle(MessagesKeyStore.ALMABANI_GENERAL_NOT_DEFINED_VALUE);
			}
		}
		return "";
	}

	public String getQuotationType(String quotationType) {

		if (Utils.isNotEmptyString(quotationType)) {
			String oamQoutationSituationMassage = oamQoutationTypeMap
					.get(quotationType);
			if (Utils.isNotEmptyString(oamQoutationSituationMassage)) {
				String oamQoutationSitutationLocalizedMessage = WebUtils
						.extractFromBundle(oamQoutationSituationMassage);
				if (Utils
						.isNotEmptyString(oamQoutationSitutationLocalizedMessage)) {
					return oamQoutationSitutationLocalizedMessage;
				} else {
					return WebUtils
							.extractFromBundle(MessagesKeyStore.ALMABANI_GENERAL_NOT_DEFINED_VALUE);

				}
			} else {
				return WebUtils
						.extractFromBundle(MessagesKeyStore.ALMABANI_GENERAL_NOT_DEFINED_VALUE);
			}
		}
		return "";
	}

	public String getUnitType(String unitType) {

		if (Utils.isNotEmptyString(unitType)) {
			String oamQoutationSituationMassage = unitTypesMap.get(unitType);
			if (Utils.isNotEmptyString(oamQoutationSituationMassage)) {
				String oamQoutationSitutationLocalizedMessage = WebUtils
						.extractFromBundle(oamQoutationSituationMassage);
				if (Utils
						.isNotEmptyString(oamQoutationSitutationLocalizedMessage)) {
					return oamQoutationSitutationLocalizedMessage;
				} else {
					return WebUtils
							.extractFromBundle(MessagesKeyStore.ALMABANI_GENERAL_NOT_DEFINED_VALUE);

				}
			} else {
				return WebUtils
						.extractFromBundle(MessagesKeyStore.ALMABANI_GENERAL_NOT_DEFINED_VALUE);
			}
		}
		return "";
	}

	public String getYesNoValue(String yesNoVal) {

		if (Utils.isNotEmptyString(yesNoVal)) {
			String yesNoMassage = yesNoMap.get(yesNoVal);
			if (Utils.isNotEmptyString(yesNoMassage)) {
				String yesNoMassageLocalizedMessage = WebUtils
						.extractFromBundle(yesNoMassage);
				if (Utils.isNotEmptyString(yesNoMassageLocalizedMessage)) {
					return yesNoMassageLocalizedMessage;
				} else {
					return WebUtils
							.extractFromBundle(MessagesKeyStore.ALMABANI_GENERAL_NOT_DEFINED_VALUE);

				}
			} else {
				return WebUtils
						.extractFromBundle(MessagesKeyStore.ALMABANI_GENERAL_NOT_DEFINED_VALUE);
			}
		}
		return "";
	}

	public List<com.almabani.common.dto.menu.KeyValueHolder<String, String>> getQuotationSituationList() {
		List<com.almabani.common.dto.menu.KeyValueHolder<String, String>> situationList = new ArrayList<KeyValueHolder<String, String>>();
		for (String key : oamQoutationSituationMap.keySet()) {
			situationList.add(new KeyValueHolder<String, String>(key,
					getOamQoutationSituationValue(key)));
		}

		return situationList;
	}

	public List<KeyValueHolder<String, String>> getQuotationTypeList() {
		List<KeyValueHolder<String, String>> quotationType = new ArrayList<KeyValueHolder<String, String>>();
		for (String key : oamQoutationTypeMap.keySet()) {
			quotationType.add(new KeyValueHolder<String, String>(key,
					getQuotationType(key)));
		}

		return quotationType;
	}

	public List<KeyValueHolder<String, String>> getContractTypesList() {
		List<KeyValueHolder<String, String>> contractType = new ArrayList<KeyValueHolder<String, String>>();
		for (String key : contractTypeMap.keySet()) {
			contractType.add(new KeyValueHolder<String, String>(key,
					getContractType(key)));
		}

		return contractType;
	}

	public List<KeyValueHolder<String, String>> getMaritalStatusList() {
		List<KeyValueHolder<String, String>> unitTypes = new ArrayList<KeyValueHolder<String, String>>();
		for (String key : maritalStatusMap.keySet()) {
			unitTypes.add(new KeyValueHolder<String, String>(key,
					getMaritalStatus(key)));
		}

		return unitTypes;
	}

	public List<KeyValueHolder<String, String>> getUnitTypesList() {
		List<KeyValueHolder<String, String>> unitTypes = new ArrayList<KeyValueHolder<String, String>>();
		for (String key : unitTypesMap.keySet()) {
			unitTypes.add(new KeyValueHolder<String, String>(key,
					getUnitType(key)));
		}

		return unitTypes;
	}

	public List<KeyValueHolder<String, String>> getEmployeeTypeList() {
		List<KeyValueHolder<String, String>> unitTypes = new ArrayList<KeyValueHolder<String, String>>();
		for (String key : employeeTypeMap.keySet()) {
			unitTypes.add(new KeyValueHolder<String, String>(key,
					getEmployeeTypeValue(key)));
		}

		return unitTypes;
	}

	public List<KeyValueHolder<String, String>> getInOutList() {
		List<KeyValueHolder<String, String>> quotationType = new ArrayList<KeyValueHolder<String, String>>();
		for (String key : inOutMap.keySet()) {
			quotationType.add(new KeyValueHolder<String, String>(key,
					getInOutValue(key)));
		}

		return quotationType;
	}

	public List<KeyValueHolder<String, String>> getYesNoList() {
		List<KeyValueHolder<String, String>> yesNoList = new ArrayList<KeyValueHolder<String, String>>();
		for (String key : yesNoMap.keySet()) {
			yesNoList.add(new KeyValueHolder<String, String>(key,
					getYesNoValue((key))));
		}

		return yesNoList;
	}

	public List<KeyValueHolder<String, String>> getReversedYesNoList() {
		List<KeyValueHolder<String, String>> yesNoList = new ArrayList<KeyValueHolder<String, String>>();
		Set<String> set = new HashSet<String>(yesNoMap.keySet());
		List<String> list = new ArrayList<String>(set);
  		for (String key : list) {
			yesNoList.add(new KeyValueHolder<String, String>(key,
					getYesNoValue((key))));
		}

		return yesNoList;
	}

	public List<KeyValueHolder<String, String>> getLangaugesList() {
		List<KeyValueHolder<String, String>> langaugesList = new ArrayList<KeyValueHolder<String, String>>();
		for (String key : languagesMap.keySet()) {
			langaugesList.add(new KeyValueHolder<String, String>(key,
					getLanguage(key)));
		}
		return langaugesList;
	}

	public boolean isAdminUser() {
		return WebUtils.isAdminUser();
	}

	public String getCurrentPageURL() {
		return WebUtils.getCurrentPageURL();
	}

	public boolean hasFullAccess() {
		return WebUtils.isAllowedURL(WebUtils.trimSlashs(getCurrentPageURL()))
				.getAccess().equals(Access.FULL);
	}

	public SecUser getCurrentlyLoggedUser() {
		return WebUtils.getCurrentLoggedUser();
	}

	public String getUserSessionId() {
		if (Utils.isNotNull(WebUtils.getCurrentSession())) {
			return WebUtils.getCurrentSession().getId();
		}
		return "";
	}

	public String extractFromBundle(String key) {
		return extractFromBundle(key);
	}

	public void invalidateCurrentSession() {
		WebUtils.getCurrentSession().invalidate();
	}

	public String getLoginDurationSince(Date date) {
		StringBuilder stringBuilder = new StringBuilder();

		if (Utils.isNotNull(date)) {
			Map<TimeUnit, Long> result = Utils.computeDiff(date, new Date());

			stringBuilder
					.append(String.format(
							"%s %s ",
							result.get(TimeUnit.HOURS),
							WebUtils.extractFromBundle(MessagesKeyStore.ALMABANI_GENERAL_DATES_HOUR)));
			stringBuilder
					.append(String.format(
							"%s %s ",
							result.get(TimeUnit.MINUTES),
							WebUtils.extractFromBundle(MessagesKeyStore.ALMABANI_GENERAL_DATES_MINUTE)));
			stringBuilder
					.append(String.format(
							"%s %s ",
							result.get(TimeUnit.SECONDS),
							WebUtils.extractFromBundle(MessagesKeyStore.ALMABANI_GENERAL_DATES_SECOND)));
		}
		return stringBuilder.toString();
	}

	public String getApplicationDescription() {
		String val = (String) WebUtils.extractFromRequest("applicationCode");
		if (Utils.isNotEmptyString(val)) {
			val = almabaniFacade.getApplicationDescription(val);
		}
		return Utils.getAbsoluteStringValue(val);
	}

	public void logout() {
		WebUtils.redirectTo("/Almabani-Portal/logout.xhtml");
	}

	public String getInOutValue(String inOutKey) {
		if (Utils.isNotEmptyString(inOutKey)) {
			String inOutSituationMassage = inOutMap.get(inOutKey);
			if (Utils.isNotEmptyString(inOutSituationMassage)) {
				String inOutLocalizedMessage = WebUtils
						.extractFromBundle(inOutSituationMassage);
				if (Utils.isNotEmptyString(inOutLocalizedMessage)) {
					return inOutLocalizedMessage;
				} else {
					return WebUtils
							.extractFromBundle(MessagesKeyStore.ALMABANI_GENERAL_NOT_DEFINED_VALUE);

				}
			} else {
				return WebUtils
						.extractFromBundle(MessagesKeyStore.ALMABANI_GENERAL_NOT_DEFINED_VALUE);
			}
		}
		return "";
	}

	public String getMaritalStatus(String inOutKey) {
		if (Utils.isNotEmptyString(inOutKey)) {
			String inOutSituationMassage = maritalStatusMap.get(inOutKey);
			if (Utils.isNotEmptyString(inOutSituationMassage)) {
				String inOutLocalizedMessage = WebUtils
						.extractFromBundle(inOutSituationMassage);
				if (Utils.isNotEmptyString(inOutLocalizedMessage)) {
					return inOutLocalizedMessage;
				} else {
					return WebUtils
							.extractFromBundle(MessagesKeyStore.ALMABANI_GENERAL_NOT_DEFINED_VALUE);

				}
			} else {
				return WebUtils
						.extractFromBundle(MessagesKeyStore.ALMABANI_GENERAL_NOT_DEFINED_VALUE);
			}
		}
		return "";
	}

	public String getCurrentCompanyTimeZone() {
		Company company = WebUtils.getCurrentLoggedUserCompany();
		if (Utils.isNotNull(company)) {
			com.almabani.common.entity.schema.admincor.State state = company
					.getState();
			if (Utils.isNotNull(state) && Utils.isNotNull(state.getStateId())
					&& Utils.isNotNull(state.getStateId().getCountry())) {
				Country country = state.getStateId().getCountry();
				if (country != null && country.getGmtHoursDefferent() != null) {
					return country.getGmtHoursDefferent() > 0 ? "+"
							+ country.getGmtHoursDefferent() : "-"
							+ country.getGmtHoursDefferent();
				}
			}
		}
		return "+0";
	}

	public String extractNoneStyleText(String str) {

		return Utils.extractNoneStyleText(str);
	}

	public String getEmployeeTypeValue(String employeeTypeKey) {
		if (Utils.isNotEmptyString(employeeTypeKey)) {
			String employeeTypeSituationMassage = employeeTypeMap
					.get(employeeTypeKey);
			if (Utils.isNotEmptyString(employeeTypeSituationMassage)) {
				String employeeTypeLocalizedMessage = WebUtils
						.extractFromBundle(employeeTypeSituationMassage);
				if (Utils.isNotEmptyString(employeeTypeLocalizedMessage)) {
					return employeeTypeLocalizedMessage;
				} else {
					return WebUtils
							.extractFromBundle(MessagesKeyStore.ALMABANI_GENERAL_NOT_DEFINED_VALUE);

				}
			} else {
				return WebUtils
						.extractFromBundle(MessagesKeyStore.ALMABANI_GENERAL_NOT_DEFINED_VALUE);
			}
		}
		return "";
	}

	public List<KeyValueHolder<String, String>> getGenderList() {
		List<KeyValueHolder<String, String>> genderList = new ArrayList<KeyValueHolder<String, String>>();
		for (String key : genderMap.keySet()) {
			genderList.add(new KeyValueHolder<String, String>(key,
					getGenderValue((key))));
		}

		return genderList;
	}

	public List<KeyValueHolder<String, String>> getDocumentTypeList() {
		List<KeyValueHolder<String, String>> documentTypeList = new ArrayList<KeyValueHolder<String, String>>();
		for (String key : documentTypeMap.keySet()) {
			documentTypeList.add(new KeyValueHolder<String, String>(key,
					getDocumentTypeValue((key))));
		}

		return documentTypeList;
	}

	public String getDocumentTypeValue(String documentTypeKey) {
		if (Utils.isNotEmptyString(documentTypeKey)) {
			String documentTypeSituationMassage = documentTypeMap
					.get(documentTypeKey);
			if (Utils.isNotEmptyString(documentTypeSituationMassage)) {
				String documentTypeLocalizedMessage = WebUtils
						.extractFromBundle(documentTypeSituationMassage);
				if (Utils.isNotEmptyString(documentTypeLocalizedMessage)) {
					return documentTypeLocalizedMessage;
				} else {
					return WebUtils
							.extractFromBundle(MessagesKeyStore.ALMABANI_GENERAL_NOT_DEFINED_VALUE);

				}
			} else {
				return WebUtils
						.extractFromBundle(MessagesKeyStore.ALMABANI_GENERAL_NOT_DEFINED_VALUE);
			}
		}
		return "";
	}

	public String getGenderValue(String genderKey) {
		if (Utils.isNotEmptyString(genderKey)) {
			String genderSituationMassage = genderMap.get(genderKey);
			if (Utils.isNotEmptyString(genderSituationMassage)) {
				String genderLocalizedMessage = WebUtils
						.extractFromBundle(genderSituationMassage);
				if (Utils.isNotEmptyString(genderLocalizedMessage)) {
					return genderLocalizedMessage;
				} else {
					return WebUtils
							.extractFromBundle(MessagesKeyStore.ALMABANI_GENERAL_NOT_DEFINED_VALUE);

				}
			} else {
				return WebUtils
						.extractFromBundle(MessagesKeyStore.ALMABANI_GENERAL_NOT_DEFINED_VALUE);
			}
		}
		return "";
	}

	public Date getMinAllowedEmployeeDate() {

		return almabaniFacade.getMinAllowedEmployeeDate();
	}

	public String getContractType(String contractTypeKey) {
		if (Utils.isNotEmptyString(contractTypeKey)) {
			String contractTypeSituationMassage = contractTypeMap
					.get(contractTypeKey);
			if (Utils.isNotEmptyString(contractTypeSituationMassage)) {
				String contractTypeLocalizedMessage = WebUtils
						.extractFromBundle(contractTypeSituationMassage);
				if (Utils.isNotEmptyString(contractTypeLocalizedMessage)) {
					return contractTypeLocalizedMessage;
				} else {
					return WebUtils
							.extractFromBundle(MessagesKeyStore.ALMABANI_GENERAL_NOT_DEFINED_VALUE);

				}
			} else {
				return WebUtils
						.extractFromBundle(MessagesKeyStore.ALMABANI_GENERAL_NOT_DEFINED_VALUE);
			}
		}
		return "";
	} 

	public StreamedContent prepareStreamContent( InputStream is ,String fileName) {
		
		return new DefaultStreamedContent(is, "pdf",fileName); 

	}

	public StreamedContent prepareStreamContent(FileHolder fileHodler) {
		return new DefaultStreamedContent(fileHodler.getInputStream(), "pdf",
				fileHodler.getFileName());

	}
	
	
	public Company getCurrentLoggedUserCompany()
	{
		return WebUtils.getCurrentLoggedUserCompany();
	}
	
	
	public Date getAnalogousUsersCountryDate(Date date)
	{
		if(Utils.isNull(date)) return null;
		Integer deff = (Integer) WebUtils.extractFromSession(PortalConstants.DEFFERENT_HOURS_BETWEEN_USER_TIME_AND_GERENWICH_TIME);
		deff= (deff !=null)?deff:0;
		return Utils.addHours(date , deff);
		
		
		
	}
}
