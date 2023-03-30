package com.tushar.dbobj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tushar.model.Courses;
import com.tushar.model.Order;

public class OrderDBObj {
	private Connection connection;
	private String query;
	private PreparedStatement pStatement;
	private ResultSet rSet;
	
	public OrderDBObj(Connection connection) {
		this.connection = connection;
	}
	
	public List<Order> userOrders(int id) {
		List<Order> list = new ArrayList<>();
		
		try {
			query = "select * from orders where employeeID=? order by orders.orderID desc";
			pStatement = this.connection.prepareStatement(query);
			pStatement.setInt(1, id);
			rSet = pStatement.executeQuery();
			while(rSet.next()) {
				Order order = new Order();
				CourseDBObj courseDBObj = new CourseDBObj(this.connection);
				int courseID = rSet.getInt("courseID");
				Courses course = courseDBObj.getSingleCourse(courseID);
				order.setOrderId(rSet.getInt("orderID"));
				order.setCourseID(courseID);
				order.setUserId(rSet.getInt("employeeID"));
				order.setName(course.getName());
				order.setCategory(course.getCategory());
				order.setPrice(course.getPrice() * rSet.getInt("quantity"));
				order.setDate(rSet.getString("date"));
				order.setQunatity(rSet.getInt("quantity"));
				list.add(order);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return list;
	}
	
	public boolean insertOrder(Order order) {
		boolean set = false;
		
		try {
			query = "insert into orders (courseID, employeeID, quantity, date) value (?, ?, ?, ?)";
			
			pStatement = this.connection.prepareStatement(query);
			pStatement.setInt(1, order.getCourseID());
			pStatement.setInt(2, order.getUserId());
			pStatement.setInt(3, order.getQunatity());
			pStatement.setString(4, order.getDate());
			pStatement.executeUpdate();
			
			set = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
			return set;
		}
		return set;
	}
	
	public void cancelOrder(int id) {
		try {
			query = "delete from orders where orderID=?";
			pStatement = this.connection.prepareStatement(query);
			pStatement.setInt(1, id);
			pStatement.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}
}
