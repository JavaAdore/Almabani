package com.almabani.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.JobTitleType;

@Service
public interface JobTitleTypeService {
	
	JobTitleType getJobTitle(Long id);

	List<JobTitleType> getJobTitleTypes(Company company);
	
	List<JobTitleType> getAllJobTitleTypes();
	
}
