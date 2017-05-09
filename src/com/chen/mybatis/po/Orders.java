/**
 * 
 */
package com.chen.mybatis.po;

import java.util.Date;
import java.util.List;

/**
 * @author chenti
 *
 */
public class Orders {

	private Integer id;
	private Integer userId;
	private String count;
	private Date createtime;
	private String note;
	//用户信息
	private User user;
	//订单明细
	private List<Orderdetail> orderdetails;
	
	//getter and setter
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Orderdetail> getOrderdetails() {
		return orderdetails;
	}
	public void setOrderdetails(List<Orderdetail> orderdetails) {
		this.orderdetails = orderdetails;
	}
	
	
	
	
}
