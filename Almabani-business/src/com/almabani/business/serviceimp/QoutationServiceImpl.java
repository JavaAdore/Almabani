package com.almabani.business.serviceimp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.QoutationService;
import com.almabani.common.constant.DataAccessConstants;
import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.OamItemQuotation;
import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.common.entity.schema.adminoam.OamQuotationAction;
import com.almabani.common.entity.schema.adminoam.OamQuotationActionType;
import com.almabani.common.entity.schema.adminoam.OamStockItem;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.common.util.Utils;
import com.almabani.dataaccess.dao.adminoam.OamQuotationActionDAO;
import com.almabani.dataaccess.dao.adminoam.OamQuotationActionTypeDAO;
import com.almabani.dataaccess.dao.adminoam.QoutationDAO;
import com.almabani.dataaccess.dao.adminoam.QuotationItemDAO;
import com.almabani.dataaccess.dao.adminoam.StockItemDAO;

@Service
public class QoutationServiceImpl implements QoutationService {

	@Autowired
	QoutationDAO qoutationDAO;

	@Autowired
	OamQuotationActionTypeDAO oamQuotationActionType;

	@Autowired
	OamQuotationActionDAO oamQuotationActionDAO;

	@Autowired
	QuotationItemDAO qoutationItemDAO;

	@Autowired
	StockItemDAO stockItemDAO;

	@Override
	public Integer getCountOfQoutations(Map<String, Object> filters) {
		return qoutationDAO.getCountOfQoutations(filters);

	}

	@Override
	public List<OamQuotation> loadQoutations(int first, int pageSize,
			String sortField, boolean assending, Map<String, Object> filters) {
		return qoutationDAO.loadQoutations(first, pageSize, sortField,
				assending, filters);
	}

	@Override
	public OamQuotation updateQuotation(OamQuotation oamQuotation,
			CommonDriverMap commonDriverMap) throws AlmabaniException {
		Date date = new Date();
		oamQuotation.setLastModificationDate(date);
		oamQuotation.setModificationLoginCode(commonDriverMap
				.getCurrentUserCode());
	
		
		if (Utils.isNull(oamQuotation)
				&& Utils.isNotEmptyList(oamQuotation.getQuotataionActions())) {
			oamQuotation.setSelectedActionType(oamQuotation
					.getQuotataionActions()
					.get(oamQuotation.getQuotataionActions().size() - 1)
					.getOamTypesQuotActions());
		}

		handleStockItems(oamQuotation, commonDriverMap);

		if (Utils.isNotNull(oamQuotation.getSelectedActionType())
				&& Utils.isNotEmptyList(oamQuotation.getQuotataionActions())) {
			addNewActionType(oamQuotation, commonDriverMap);
		}

		return qoutationDAO.addOrUpdateQuotation(oamQuotation);

	}

	private void validateQuotationItems(OamQuotation oamQuotation) throws AlmabaniException{
	Integer numberOfItemQuotaiton=  qoutationItemDAO.getNumberOfItemQuotation(oamQuotation);
		if(numberOfItemQuotaiton == null || numberOfItemQuotaiton ==0)
		{
			throw new AlmabaniException(MessagesKeyStore.ALMABANI_QUOTATION_HAS_NO_ITEMS_TO_CHANGE_ITS_STATUS);
		}
	}

	private void handleStockItems(OamQuotation oamQuotation,
			CommonDriverMap commonDriverMap) throws AlmabaniException {

		OamQuotationActionType currentlySelectedActionType = oamQuotation
				.getSelectedActionType();

		OamQuotationActionType lastSelectedOamActionTypeInDB = getLastActinoType(oamQuotation);

		if (lastSelectedOamActionTypeInDB.equals(currentlySelectedActionType) == false) {

			validateQuotationItems(oamQuotation);
			
			OamQuotationActionType approveQuotationActionType = oamQuotationActionType
					.getApproveActionType(commonDriverMap.getAttachedCompany());

			if (Utils.isNotNull(approveQuotationActionType)) {
				if (approveQuotationActionType
						.equals(currentlySelectedActionType)) {
					persistNewStockItems(oamQuotation, commonDriverMap);

				}

			}

		}

	}

	private void persistNewStockItems(OamQuotation oamQuotation,
			CommonDriverMap commonDriverMap) {
		List<OamItemQuotation> itemQuotations = qoutationItemDAO
				.getQuotationItem(oamQuotation);
		if (Utils.isNotEmptyList(itemQuotations)) {
			Date date = new Date();
			String loginUserCode = commonDriverMap.getCurrentUserCode();

			for (OamItemQuotation itemQuotation : itemQuotations) {
				OamStockItem oamStockItem = new OamStockItem();
				oamStockItem.setEstablishment(itemQuotation.getEstablishment());
				oamStockItem.setEntryValue(itemQuotation.getQutItem());
				oamStockItem.setIndInOut(DataAccessConstants.STOCK_ITEM_IN);
				oamStockItem.setItemQuotation(itemQuotation);
				oamStockItem.setProjectItem(itemQuotation.getProjectItem());
				oamStockItem.setModificationMakerName(loginUserCode);
				oamStockItem.setLastModificationDate(date);

				stockItemDAO.addOrUpdateStockItem(oamStockItem);

			}
		}

	}

	private OamQuotationActionType getLastActinoType(OamQuotation oamQuotation) {
		OamQuotation freshQuotation = qoutationDAO.getQuotataion(oamQuotation
				.getId());

		OamQuotationAction quotationAction = freshQuotation
				.getQuotataionActions().get(
						freshQuotation.getQuotataionActions().size() - 1);

		OamQuotationActionType quotationActionType = quotationAction
				.getOamTypesQuotActions();

		return quotationActionType;

	}

	private void addNewActionType(OamQuotation oamQuotation,
			CommonDriverMap commonDriverMap) {
		Date date = new Date();
		if (oamQuotation.getSelectedActionType().equals(
				oamQuotation.getQuotataionActions().get(
						oamQuotation.getQuotataionActions().size() - 1)) == false) {
			if (Utils.isNotEmptyList(oamQuotation.getQuotataionActions())) {
				OamQuotationAction oamQuotationAction = new OamQuotationAction();
				oamQuotationAction.setInsertActionDate(date);
				oamQuotationAction.setLastModificationDate(date);
				oamQuotationAction.setLoginActionCode(commonDriverMap
						.getCurrentUserCode());
				oamQuotationAction.setModificationLoginCode(commonDriverMap
						.getCurrentUserCode());
				oamQuotationAction.setOamQuotation(oamQuotation);
				oamQuotationAction.setOamTypesQuotActions(oamQuotation
						.getSelectedActionType());

				oamQuotation.getQuotataionActions().add(oamQuotationAction);
				oamQuotationAction = oamQuotationActionDAO
						.addOrUpdateQuotationAction(oamQuotationAction);
			}
		}
	}

	@Override
	public OamQuotation addQuotation(OamQuotation oamQuotation,
			CommonDriverMap commonDriverMap) {
		Date date = new Date();
		oamQuotation.setCreationDate(date);
		oamQuotation.setInsertRowDate(date);
		oamQuotation.setLastModificationDate(date);
		oamQuotation.setInsertLoginCode(commonDriverMap.getCurrentUserCode());
		oamQuotation.setModificationLoginCode(commonDriverMap
				.getCurrentUserCode());

		oamQuotation = qoutationDAO.addOrUpdateQuotation(oamQuotation);
		OamQuotationAction oamQuotationAction = new OamQuotationAction();
		oamQuotationAction.setInsertActionDate(date);
		oamQuotationAction.setLastModificationDate(date);
		oamQuotationAction.setLoginActionCode(commonDriverMap
				.getCurrentUserCode());
		oamQuotationAction.setModificationLoginCode(commonDriverMap
				.getCurrentUserCode());
		oamQuotationAction.setOamQuotation(oamQuotation);
		List<OamQuotationActionType> oamQuotationActionTypes = oamQuotationActionType
				.getAllQuotationActionType(commonDriverMap.getAttachedCompany());

		if (Utils.isNotEmptyList(oamQuotationActionTypes)) {
			oamQuotationAction.setOamTypesQuotActions(oamQuotationActionTypes
					.get(0));
		}

		oamQuotationAction = oamQuotationActionDAO
				.addOrUpdateQuotationAction(oamQuotationAction);
		oamQuotation.getQuotataionActions().add(oamQuotationAction);

		return oamQuotation;
	}

	@Override
	public List<OamQuotation> getAllQuotations() {
		return qoutationDAO.getAllQuotations();
	}

	@Override
	public OamQuotation getQuotataion(Long quotationID) {
		return qoutationDAO.getQuotataion(quotationID);
	}

	@Override
	public List<OamQuotation> getAllQuotations(Company company) {
		return qoutationDAO.getAllQuotations(company);
	}

}
