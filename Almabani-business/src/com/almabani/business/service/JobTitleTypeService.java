package com.almabani.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.almabani.common.entity.schema.admincor.JobTitleType;

@Service
public interface JobTitleTypeService {
	
	List<JobTitleType> getJobTitleTypes(); 
	
}
