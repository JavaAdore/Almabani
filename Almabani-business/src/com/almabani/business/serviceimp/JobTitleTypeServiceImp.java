package com.almabani.business.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.almabani.business.service.JobTitleTypeService;
import com.almabani.common.entity.schema.admincor.JobTitleType;
import com.almabani.dataaccess.dao.admincor.JobTitleTypeDAO;

@Service
public class JobTitleTypeServiceImp implements JobTitleTypeService {
	
	
	@Autowired
	private JobTitleTypeDAO jobTitleTypeDAO;

	@Override
	public List<JobTitleType> getJobTitleTypes() {
		return jobTitleTypeDAO.getJobTitleTypes();
	}
	
}
