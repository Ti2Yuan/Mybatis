/**
 * 
 */
package com.chen.mybatis.mapinterface;

import java.util.List;

import com.chen.mybatis.po.OrderCustom;
import com.chen.mybatis.po.Orders;

/**
 * @author chenti
 *
 */
public interface OrdersMapperCustom {

	public List<OrderCustom> findOrdersUser();
	
	//public OrderCustom findOrdersUser();
	public List<Orders> findOrdersUserResultMap();
	
	public List<Orders> findOrdersAndOrderDetailResultMap();
}
