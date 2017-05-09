/**
 * 
 */
package com.chen.mybatis.first;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chen.mybatis.mapinterface.UserTypeDAO;
import com.chen.mybatis.mapinterface.UserTypeDAOImpl;
import com.chen.mybatis.po.User;

/**
 * @author chenti
 *
 */
public class MybatisSpringTest {

	@Test
	public void test(){
		//初始化容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config/ApplicationContext.xml");
		//获得bean
		UserTypeDAO userTypeDAO = ctx.getBean("userTypeDao",UserTypeDAO.class);
		//访问数据库
		List<User> users = userTypeDAO.getAllUser();
		for (User user : users) {
			System.out.println(user.toString());
		}
	}
	
	@Test
	public void test2(){
		//初始化容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config/ApplicationContext.xml");
		//获得bean
		UserTypeDAOImpl userTypeDAOImpl = (UserTypeDAOImpl) ctx.getBean("userTypeDaoImpl");
		//访问数据库
		List<User> users = userTypeDAOImpl.getAllUser();
		for (User user : users) {
			System.out.println(user.toString());
		}
	}
}

