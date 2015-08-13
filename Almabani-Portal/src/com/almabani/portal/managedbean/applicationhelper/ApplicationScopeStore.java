package com.almabani.portal.managedbean.applicationhelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.almabani.business.facade.AlmabaniFacade;
import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.dto.menu.Access;
import com.almabani.common.dto.menu.KeyValueHolder;
import com.almabani.common.entity.schema.admincor.Country;
import com.almabani.common.entity.schema.admincor.State;
import com.almabani.common.entity.schema.adminsec.SecUser;
import com.almabani.common.enums.DocumentType;
import com.almabani.common.util.Utils;
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

	private Map<String, String> oamQoutationSituationMap = new TreeMap();

	private Map<String, String> oamQoutationTypeMap = new TreeMap();

	private Map<String, String> documentTypeKeysAndValues;

	private List<Country> countries;

	private Map<Country, List<State>> countriesStatesMap = new HashMap();

	private Map<String, String> unitTypesMap = new TreeMap();

	private Map<String, String> yesNoMap = new LinkedHashMap();

	@PostConstruct  
	public void init() {  
		loadCountries();
		constructCountriesStatesMap();
		constructOamQoutationSituationMap();
		constructQoutationTypeMap();
		constructUnitTypesMap();
		constructYesNoMap();
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

	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	private void constructDocumentTypeKeysAndValues() {

		documentTypeKeysAndValues = new TreeMap();

		for (DocumentType documentType : DocumentType.values()) {
			documentTypeKeysAndValues.put(documentType.getKey(),
					WebUtils.extractFromBundle(documentType.getKey()));
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

	public List<KeyValueHolder<String, String>> getUnitTypesList() {
		List<KeyValueHolder<String, String>> unitTypes = new ArrayList<KeyValueHolder<String, String>>();
		for (String key : unitTypesMap.keySet()) {
			unitTypes.add(new KeyValueHolder<String, String>(key,
					getUnitType(key)));
		}

		return unitTypes;
	}

	public List<KeyValueHolder<String, String>> getYesNoList() {
		List<KeyValueHolder<String, String>> yesNoList = new ArrayList<KeyValueHolder<String, String>>();
		for (String key : yesNoMap.keySet()) {
			yesNoList.add(new KeyValueHolder<String, String>(key,
					getYesNoValue((key))));
		}

		return yesNoList;
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
			Map<TimeUnit, Long> result = Utils.computeDiff( date , new Date());
 
			 
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

}
