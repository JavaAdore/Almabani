package com.almabani.dataaccess.dao.adminoamImpl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminoam.OamDocumentType;
import com.almabani.dataaccess.dao.adminoam.OamDocumentTypeDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class OamDocumentTypeDAOImpl extends AbstractDAO implements
		OamDocumentTypeDAO {

	private static final long serialVersionUID = -1639272880814635175L;

	@Override
	public List<OamDocumentType> getDocuemtTypeList(Company company) {
		Query query = super.getCurrentSession().createQuery(
				"select x from OamDocumentType x where x.company =:company");
		query.setParameter("company", company);
		return query.list();
	}

	@Override
	public OamDocumentType getDocumentType(Long id) {
		return (OamDocumentType) super.getEntity(OamDocumentType.class, id);
	}

}
