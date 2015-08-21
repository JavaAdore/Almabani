package com.almabani.business.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.JobTitleTypeService;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.JobTitleType;
import com.almabani.dataaccess.dao.admincor.JobTitleTypeDAO;

@Service
public class JobTitleTypeServiceImp implements JobTitleTypeService {
	
	
	@Autowired
	private JobTitleTypeDAO jobTitleTypeDAO;
	
	@Override
	public JobTitleType getJobTitle(Long id) {
		return jobTitleTypeDAO.getJobTitle(id);
	}

	@Override
	public List<JobTitleType> getJobTitleTypes(Company company) {
		return jobTitleTypeDAO.getJobTitleTypes(company);
	}

	@Override
	public List<JobTitleType> getAllJobTitleTypes() {
		return jobTitleTypeDAO.getJobTitleTypes();
	}
	
}
