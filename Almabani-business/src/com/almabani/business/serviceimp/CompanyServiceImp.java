package com.almabani.business.serviceimp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.CompanyService;
import com.almabani.common.constant.MessagesKeyStore;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.exception.AlmabaniException;
import com.almabani.common.util.Utils;
import com.almabani.dataaccess.dao.admincor.CompanyDAO;

@Service
public class CompanyServiceImp implements CompanyService {
	
	 
	@Autowired
	private CompanyDAO companyDAO;


	@Override
	public List<Company> loadCompanies(Integer first, Integer pageSize, String sortField, boolean assending, Map<String, Object> filters){
		return companyDAO.loadMCompanies(first,pageSize,sortField,assending,filters);
	}

	
	@Override 
	public Company addCompany(Company company) throws AlmabaniException {
		Company result = companyDAO.getCompany(company.getFederalIdentityCode());
		if(Utils.isNull(result))
		{
			try
			{
				return companyDAO.addCompany(company);
			}catch(Exception ex)
			{
				AlmabaniException almabaniException = new AlmabaniException(MessagesKeyStore.ALMABANI_GENERAL_NOT_ABLE_TO_ADD);
				almabaniException.attachParameter(MessagesKeyStore.ALMABANI_GENERAL_COMPANY);
				throw almabaniException;
			}
		}else
		{
			throw new AlmabaniException(MessagesKeyStore.ALMABANI_ADD_COMPANY_DUPLICATED_FEDRAIL_IDENTIFIER);
 
		}
	}

	@Override
	public Company getCompany(Long id) {
		return companyDAO.getCompany(id);
	}

	    
	@Override
	public Company updateCompany(Company company) throws AlmabaniException {
	
		Company result = companyDAO.getCompany(company.getFederalIdentityCode());
		
		String fedralIdentifierCode =company.getFederalIdentityCode();
		if(Utils.isNull(result) ||company.getId() == result.getId())
		{ 
			try 
			{
				return companyDAO.addCompany(company);
			}catch(Exception ex)
			{
				AlmabaniException almabaniException = new AlmabaniException(MessagesKeyStore.ALMABANI_GENERAL_NOT_ABLE_TO_UPDATE);
				almabaniException.attachParameter(MessagesKeyStore.ALMABANI_GENERAL_COMPANY);
				throw almabaniException;
			}
		}else
		{  
			company.setFederalIdentityCode(fedralIdentifierCode);
			throw new AlmabaniException(MessagesKeyStore.ALMABANI_ADD_COMPANY_DUPLICATED_FEDRAIL_IDENTIFIER);
		}
		
		
	}

	@Override
	public Integer getCountOfCompany(Map<String, Object> filters) {
		return companyDAO.getCountOfCompany( filters);
	}

	@Override
	public List<Company> getAllCompanies() {
		return companyDAO.getAllCompanies();
	}

	
	

}
