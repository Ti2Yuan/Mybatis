/**
 * 
 */
package com.chen.mybatis.mapinterface;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.chen.mybatis.po.User;

/**
 * @author chenti
 *
 */
public class UserTypeDAOImpl implements UserTypeDAO {
	
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<User> getAllUser() {
		return sqlSession.selectList("com.chen.mybatis.mapinterface.UserTypeDAO.getAllUser");
	}

}
