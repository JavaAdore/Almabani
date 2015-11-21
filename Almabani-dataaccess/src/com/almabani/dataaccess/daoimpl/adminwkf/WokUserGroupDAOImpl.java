package com.almabani.dataaccess.daoimpl.adminwkf;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.almabani.common.constant.DataAccessConstants;
import com.almabani.common.entity.schema.admincor.Calendar;
import com.almabani.common.entity.schema.admincor.Company;
import com.almabani.common.entity.schema.adminsec.SecUser;
import com.almabani.common.entity.schema.adminwkf.WokTypeProfile;
import com.almabani.common.entity.schema.adminwkf.WokUserGroup;
import com.almabani.common.entity.schema.adminwkf.WokWorkingGroup;
import com.almabani.common.util.Utils;
import com.almabani.dataaccess.dao.adminwkf.WokUserGroupDAO;
import com.almabani.dataaccess.daoimpl.AbstractDAO;

@Repository
public class WokUserGroupDAOImpl extends AbstractDAO implements WokUserGroupDAO {

	private static final long serialVersionUID = 1L;

	@Override
	public List<WokUserGroup> getUserGroups(WokTypeProfile wokTypeProfile,
			WokWorkingGroup workingGroup, SecUser user) {
		Query query = getCurrentSession().createQuery("select t1 from WokUserGroup t1 , SecUser t2 , Employee t3  where t1.workingGroup =:workingGroup and t1.user =t2 and t2.employee = t3 and t1.typeProfiles =:typeProfiles and   ( CURRENT_DATE() between t1.validityBeginDate and coalesce(t1.validityEndDate,CURRENT_DATE()+1))  ");
		query.setParameter("workingGroup", workingGroup);
		query.setParameter("typeProfiles", wokTypeProfile);
		//query.setParameter("begindate", Utils.getTodayInHourZero());  
		java.util.Calendar endDate = java.util.Calendar.getInstance();
		endDate.setTime(Utils.getTodayInHour24());
		endDate.add(java.util.Calendar.DAY_OF_MONTH, 1);
		//query.setParameter("endDate", endDate.getTime());  
		return query.list();
	}
  
	@Override
	public WokUserGroup getWokUserGroup(Long id) {
		return (WokUserGroup) super.getEntity(WokUserGroup.class, id);
	}

	@Override
	public List<WokUserGroup> getInteractionOccurenceUserGroups(
			WokTypeProfile wokTypeProfile, WokWorkingGroup workingGroup,
			SecUser secUser) {
		Query query = getCurrentSession().createQuery("select t1 from WokUserGroup t1 , SecUser t2 ,  Employee t3  where t1.workingGroup =:workingGroup and t1.user =t2 and t2.employee = t3 and t1.typeProfiles =:typeProfiles  and t1.indInteractionOccurrences =:status  and   ( CURRENT_DATE() between t1.validityBeginDate and coalesce(t1.validityEndDate,CURRENT_DATE()+1))  ");
		query.setParameter("workingGroup", workingGroup);
		query.setParameter("typeProfiles", wokTypeProfile);
		//query.setParameter("begindate", Utils.getTodayInHourZero());
		query.setParameter("status", DataAccessConstants.IND_ACTIVE);   
		java.util.Calendar endDate = java.util.Calendar.getInstance();
		endDate.setTime(Utils.getTodayInHour24());
		endDate.add(java.util.Calendar.DAY_OF_MONTH, 1);
	//	query.setParameter("endDate", endDate.getTime());  
  		return query.list();
	}

	

}
