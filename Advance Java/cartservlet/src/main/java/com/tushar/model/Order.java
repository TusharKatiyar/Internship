package com.tushar.model;

public class Order extends Courses {
	private int orderId;
	private int userId;
	private int qunatity;
	private String date;
		
	public Order() {
		super();
	}
	
	public Order(int userId, int qunatity, String date) {
		super();
		this.userId = userId;
		this.qunatity = qunatity;
		this.date = date;
	}


	public Order(int orderId, int userId, int qunatity, String date) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.qunatity = qunatity;
		this.date = date;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getQunatity() {
		return qunatity;
	}
	public void setQunatity(int qunatity) {
		this.qunatity = qunatity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", uid=" + userId + ", courseID=" + super.getCourseID() + ", qunatity=" + qunatity + ", date=" + date + "]";
	}
	
	
}
