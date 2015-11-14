package com.almabani.dataaccess.dao.adminoamImpl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.admincor.Project;
import com.almabani.common.entity.schema.adminoam.AllocationType;
import com.almabani.dataaccess.dao.adminoam.AllocationTypeDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class AllocationTypeDAOImpl extends AbstractDAO implements AllocationTypeDAO {
	
	private static final long serialVersionUID = -1639272880814635175L;

	@SuppressWarnings("unchecked")
	@Override
	public List<AllocationType> getAllAllocationTypes() {
		return super.getAllEntities(AllocationType.class);
	}

	@Override
	public AllocationType getAllocationType(Long id) {
		return (AllocationType) super.getEntity(AllocationType.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AllocationType> getAllocationTypes(Company company) {
		
		Query query = getCurrentSession().createQuery("select at from AllocationType at where at.project.company =:company");
		query.setParameter("company", company);
		return query.list();
	}

	@Override
	public List<AllocationType> getAllocationType(Project selectedproject) {
		Query query = getCurrentSession().createQuery("select at from AllocationType at where at.project =:project");
		query.setParameter("project", selectedproject);
		return query.list();
	}
	
}
