package com.almabani.dataaccess.dao.admincor;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.JobTitleType;
import com.almabani.dataaccess.dao.AbstractDAOInt;

@Repository
public interface JobTitleTypeDAO extends AbstractDAOInt {

	List<JobTitleType> getJobTitleTypes();
	
}
