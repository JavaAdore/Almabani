package com.almabani.dataaccess.daoimpl.admincor;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.JobTitleType;
import com.almabani.dataaccess.dao.admincor.JobTitleTypeDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class JobTitleTypeDAOImp extends AbstractDAO implements JobTitleTypeDAO {
	
	private static final long serialVersionUID = 7036085972983276544L;

	@Override
	public JobTitleType getJobTitle(Long id) {
		return (JobTitleType) super.getEntity(JobTitleType.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JobTitleType> getJobTitleTypes(Company company) {
		
		Query query = getCurrentSession().createQuery("select jtt from JobTitleType jtt where jtt.company =:company");
		query.setParameter("company", company);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<JobTitleType> getJobTitleTypes() {
		return super.getAllEntities(JobTitleType.class);
	}	
	
}
