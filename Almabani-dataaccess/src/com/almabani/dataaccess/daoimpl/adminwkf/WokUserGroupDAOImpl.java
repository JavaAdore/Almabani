package com.almabani.dataaccess.daoimpl.adminwkf;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminsec.SecUser;
import com.almabani.common.entity.schema.adminwkf.WokTypeProfile;
import com.almabani.common.entity.schema.adminwkf.WokUserGroup;
import com.almabani.common.entity.schema.adminwkf.WokWorkingGroup;
import com.almabani.dataaccess.dao.adminwkf.WokUserGroupDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class WokUserGroupDAOImpl extends AbstractDAO implements WokUserGroupDAO {

	private static final long serialVersionUID = 1L;

	@Override
	public List<WokUserGroup> getUserGroups(WokTypeProfile wokTypeProfile,
			WokWorkingGroup workingGroup, SecUser user) {
		Query query = getCurrentSession().createQuery("select x from WokUserGroup x ,Employee e , SecUser u where x.workingGroup =:workingGroup and u.employee = e and x.typeProfiles =:typeProfiles and u =:user");
		query.setParameter("workingGroup", workingGroup);
		query.setParameter("user", user);
		query.setParameter("typeProfiles", wokTypeProfile);
		return query.list();
	}
 
	@Override
	public WokUserGroup getWokUserGroup(Long id) {
		return (WokUserGroup) super.getEntity(WokUserGroup.class, id);
	}

	

}
