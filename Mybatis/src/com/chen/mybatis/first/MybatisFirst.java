/**
 * 
 */
package com.chen.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.chen.mybatis.mapinterface.OrdersMapperCustom;
import com.chen.mybatis.po.OrderCustom;
import com.chen.mybatis.po.Orders;
import com.chen.mybatis.po.User;

/**
 * @author chenti
 *
 */
public class MybatisFirst {

	@Test
	public void testFindOrdersUser() throws IOException {
		// Mybatis配置文件
		String resource = "config/SqlMapConfig.xml";

		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，传入Mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建OrdersMapperCustom对象，mybatis自动生成代理对象
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		
		//List<OrderCustom> orderCustomList = ordersMapperCustom.findOrdersUser();
		
		//List<Orders> ordersList = ordersMapperCustom.findOrdersUserResultMap();
		
		List<Orders> ordersList = ordersMapperCustom.findOrdersAndOrderDetailResultMap();
		
		System.out.println(ordersList.toString());
		
		sqlSession.close();
	}

	/**
	 * 
	 * TODO 根据id查询用户信息，得到用户的一条记录
	 * 
	 * @throws IOException
	 *             void
	 */
	@Test
	public void findUserByIdTest() throws IOException {

		// Mybatis配置文件
		String resource = "config/SqlMapConfig.xml";

		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，传入Mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		/**
		 * 通过SqlSession操作数据库
		 */
		// User user = sqlSession.selectOne("test.findUserByID",10);

		// List<User> userList =
		// sqlSession.selectList("test.findUserByUsername","小明");

		User user = new User();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		user.setId(29);
		user.setUsername("徐媛");
		user.setSex("女");
		try {
			user.setBirthday(sdf.parse("1992-09-27"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setAddress("江西上饶");

		sqlSession.update("test.updateUserById", user);
		sqlSession.commit();

		System.out.println(user.getId());

		// 释放资源
		sqlSession.close();

	}

}
