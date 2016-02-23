package com.almabani.business.serviceimp;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.OamDocumentTypeService;
import com.almabani.business.service.QoutationService;
import com.almabani.common.constant.DataAccessConstants;
import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.dto.CommonDriverMap;
import com.almabani.common.dto.FileHolder;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.OamItemQuotation;
import com.almabani.common.entity.schema.adminoam.OamQuotation;
import com.almabani.common.entity.schema.adminoam.OamQuotationAction;
import com.almabani.common.entity.schema.adminoam.OamQuotationActionType;
import com.almabani.common.entity.schema.adminoam.OamQuotationDocument;
import com.almabani.common.entity.schema.adminoam.OamStockItem;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.common.util.Utils;
import com.almabani.dataaccess.dao.adminoam.OamDocumentTypeDAO;
import com.almabani.dataaccess.dao.adminoam.OamQuotationActionDAO;
import com.almabani.dataaccess.dao.adminoam.OamQuotationActionTypeDAO;
import com.almabani.dataaccess.dao.adminoam.OamQuotationDocumentDAO;
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

	@Autowired
	OamQuotationDocumentDAO oamQuotationDocumentDAO;

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
		Date date =  Utils.getGrenetchTime();
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

		List<OamQuotationDocument> quotationDocuments = handleUpdateQuotationDocument(oamQuotation);

		if (Utils.isNotNull(oamQuotation.getSelectedActionType())
				&& Utils.isNotEmptyList(oamQuotation.getQuotataionActions())) {
			addNewActionType(oamQuotation, commonDriverMap);
		}
		List<OamQuotationAction> actions = oamQuotation.getQuotataionActions();
		oamQuotation.getQuotationDocuments().clear();    
		OamQuotation qoutation = qoutationDAO
				.addOrUpdateQuotation(oamQuotation);
		qoutation.setQuotationDocuments(quotationDocuments);
		qoutation.setQuotataionActions(actions);
		return qoutation;

	}

	private List<OamQuotationDocument> handleUpdateQuotationDocument(
			OamQuotation oamQuotation) {

		List<OamQuotationDocument> oamQoutationDocuments = new ArrayList();

		for (FileHolder fileHolder : oamQuotation.getQuotationFilesHolderList()) {
			
			OamQuotationDocument oamDocumentType = fileHolderToQuotationDocument(
					oamQuotation, fileHolder);
			oamQoutationDocuments.add(oamDocumentType);
		}

		for (OamQuotationDocument oamQuotationDocument : oamQoutationDocuments) {

			OamQuotationDocument freshlyPersistedQuotationDocument = oamQuotationDocumentDAO
					.addOrUpdateQuotationDocument(oamQuotationDocument);

			oamQuotation.getQuotationDocuments().add(
					freshlyPersistedQuotationDocument);
		}
		
		if (Utils.isEmptyList(oamQoutationDocuments)) {
			deleteQuotationRelatedDocuments(oamQuotation);
		} else {
			deleteUnnededQuotationDocuments(oamQuotation, oamQoutationDocuments);

		}

	
		return oamQuotation.getQuotationDocuments();

	}

	private void deleteUnnededQuotationDocuments(OamQuotation oamQuotation,
			List<OamQuotationDocument> oamQoutationDocuments) {
		deleteQuotationRelatedDocumentsExcept(oamQuotation,
				oamQoutationDocuments);

	}

	private void deleteQuotationRelatedDocumentsExcept(
			OamQuotation oamQuotation,
			List<OamQuotationDocument> oamQoutationDocuments) {
		oamQuotationDocumentDAO.deleteQuotationRelatedDocumentsExcept(
				oamQuotation, oamQoutationDocuments);

	}

	private void deleteQuotationRelatedDocuments(OamQuotation oamQuotation) {

		oamQuotationDocumentDAO.deleteQuotationRelatedDocuments(oamQuotation);
	}

	private void validateQuotationItems(OamQuotation oamQuotation)
			throws AlmabaniException {
		Integer numberOfItemQuotaiton = qoutationItemDAO
				.getNumberOfItemQuotation(oamQuotation);
		if (numberOfItemQuotaiton == null || numberOfItemQuotaiton == 0) {
			throw new AlmabaniException(
					MessagesKeyStore.ALMABANI_QUOTATION_HAS_NO_ITEMS_TO_CHANGE_ITS_STATUS);
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
			Date date =  Utils.getGrenetchTime();
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
		Date date =  Utils.getGrenetchTime();
		if (oamQuotation.getSelectedActionType().equals(
				oamQuotation.getQuotataionActions().get(
						oamQuotation.getQuotataionActions().size() - 1).getOamTypesQuotActions()) == false) {
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
		Date date =  Utils.getGrenetchTime();
		oamQuotation.setCreationDate(date);
		oamQuotation.setInsertRowDate(date);
		oamQuotation.setLastModificationDate(date);
		oamQuotation.setInsertLoginCode(commonDriverMap.getCurrentUserCode());
		oamQuotation.setModificationLoginCode(commonDriverMap
				.getCurrentUserCode());

		List<FileHolder> fileHolderList = oamQuotation
				.getQuotationFilesHolderList();

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

		addQuotationUploadedDocuments(oamQuotation, fileHolderList);

		oamQuotationAction = oamQuotationActionDAO
				.addOrUpdateQuotationAction(oamQuotationAction);
		oamQuotation.getQuotataionActions().add(oamQuotationAction);

		return oamQuotation;
	}

	private void addQuotationUploadedDocuments(OamQuotation oamQuotation,
			List<FileHolder> fileHolderList) {
		oamQuotation.getQuotationDocuments().clear();
		for (FileHolder fileHolder : fileHolderList) {
			OamQuotationDocument quotationDocument = fileHolderToQuotationDocument(
					oamQuotation, fileHolder);

			OamQuotationDocument oamQuotationDocument = oamQuotationDocumentDAO
					.addOrUpdateQuotationDocument(quotationDocument);
			oamQuotation.getQuotationDocuments().add(oamQuotationDocument);
		}
	}

	private OamQuotationDocument fileHolderToQuotationDocument(
			OamQuotation oamQuotation, FileHolder fileHolder) {
		OamQuotationDocument quotationDocument = new OamQuotationDocument();
		quotationDocument.setDocumentName(Utils.getFirstCharactersOf(fileHolder.getFileName(), 30));
		
		quotationDocument.setId(fileHolder.getId() > 0 ? fileHolder.getId()
				: null);
		quotationDocument.setCodLoginInsert(oamQuotation
				.getModificationLoginCode());
		quotationDocument.setInsertionDate(Utils.getGrenetchTime());
		quotationDocument.setDocumentType(fileHolder.getDocumentType());
		quotationDocument.setQuotation(oamQuotation);
		quotationDocument.setImgQuotation(Utils.inputStreamToBlob(fileHolder
				.getInputStream()));
		return quotationDocument;
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
