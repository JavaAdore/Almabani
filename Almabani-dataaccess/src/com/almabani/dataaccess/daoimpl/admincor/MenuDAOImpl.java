package com.almabani.dataaccess.daoimpl.admincor;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.almabani.common.dto.menu.Module;
import com.almabani.common.util.Utils;
import com.almabani.dataaccess.dao.admincor.MenuDAO;

@Repository
public class MenuDAOImpl implements MenuDAO {

	@Autowired
	private DefaultSqlSessionFactory defaultSqlSessionFactory;

	@Override
	public List<Module> getUserModules(String userName) {

		SqlSession sqlSession = null;
		try {
			sqlSession = defaultSqlSessionFactory.openSession();
			MenuDAO menuDAO = sqlSession.getMapper(MenuDAO.class);
			List<Module> result = menuDAO.getUserModules(userName);
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ArrayList<Module>();
		} finally {
			if (Utils.isNotNull(sqlSession)) {
				sqlSession.close();
			}
		}

	}

}
