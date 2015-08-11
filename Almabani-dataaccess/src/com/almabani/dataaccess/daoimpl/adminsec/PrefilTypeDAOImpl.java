package com.almabani.dataaccess.daoimpl.adminsec;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.adminsec.SecTypesPerfil;
import com.almabani.common.util.Utils;
import com.almabani.dataacceess.dao.adminsec.PrefilTypeDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class PrefilTypeDAOImpl extends AbstractDAO implements PrefilTypeDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public SecTypesPerfil getTypePrefil(String profileCode) {
		
		Query query = super.getCurrentSession().createQuery("select x from SecTypesPerfil x where x.profileCode =:profileCode ");
		query.setParameter("profileCode", profileCode);
		List result = query.list();
		if(Utils.isNotEmptyList(result))
		{
			return (SecTypesPerfil) result.get(0);
		}
		return null;
	}

	@Override
	public List<SecTypesPerfil> getAllPrefilTypes() {
		return super.getAllEntities(SecTypesPerfil.class);
	}

	

}
