package com.almabani.business.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.WokOccurencyTypeService;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.CompanyParameter;
import com.almabani.common.entity.schema.admincor.GenericParameter;
import com.almabani.common.entity.schema.adminwkf.WokOccurrenceType;
import com.almabani.common.util.Utils;
import com.almabani.dataaccess.dao.admincor.ParameterDAO;
import com.almabani.dataaccess.dao.adminwkf.WokOccurencyTypeDAO;

@Service
public class WokOccurencyTypeServiceImpl implements WokOccurencyTypeService {

	@Autowired
	WokOccurencyTypeDAO wokOccurencyTypeDAO;

	@Autowired
	ParameterDAO parameterDAO;

	@Override
	public List<WokOccurrenceType> getWokOccurrenceTypeList(Company company) {
		return wokOccurencyTypeDAO.getWokOccurrenceTypeList(company);
	}

	@Override
	public Object getOperatorsParamValue(Company company) {
		CompanyParameter companyParameter = parameterDAO.getCompanyParameter(
				GenericParameter.OPERATOR, company);
		if (Utils.isNotNull(companyParameter)) {
			return companyParameter.getValuedParam();
		}
		return null;

	}

	@Override
	public Object getCommuincatorsParamValue(Company company) {

		CompanyParameter companyParameter = parameterDAO.getCompanyParameter(
				GenericParameter.COMMUNICATOR, company);
		if (Utils.isNotNull(companyParameter)) {
			return companyParameter.getValuedParam();
		}
		return null;
	}

	@Override
	public Object getSafetyAgentsParamValue(Company company) {

		CompanyParameter companyParameter = parameterDAO.getCompanyParameter(
				GenericParameter.SAFETY, company);
		if (Utils.isNotNull(companyParameter)) {
			return companyParameter.getValuedParam();
		}
		return null;
	}

	@Override
	public Object getTechniciansParamValue(Company company) {

		CompanyParameter companyParameter = parameterDAO.getCompanyParameter(
				GenericParameter.TECHNICIAN, company);
		if (Utils.isNotNull(companyParameter)) {
			return companyParameter.getValuedParam();
		}
		return null;
	}

	@Override
	public WokOccurrenceType getOccurenceType(Long id) {
		return wokOccurencyTypeDAO.getOccurenceType( id);
	}

}
