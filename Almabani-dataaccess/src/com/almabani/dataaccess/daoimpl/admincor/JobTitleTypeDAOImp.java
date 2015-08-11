package com.almabani.dataaccess.daoimpl.admincor;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.JobTitleType;
import com.almabani.dataaccess.dao.admincor.JobTitleTypeDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class JobTitleTypeDAOImp extends AbstractDAO implements JobTitleTypeDAO {
	
	private static final long serialVersionUID = 7036085972983276544L;

	@SuppressWarnings("unchecked")
	@Override
	public List<JobTitleType> getJobTitleTypes() {
		return super.getAllEntities(JobTitleType.class);
	}
	
	
}
