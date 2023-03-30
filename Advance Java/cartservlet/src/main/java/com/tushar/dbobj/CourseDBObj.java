package com.tushar.dbobj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tushar.model.Cart;
import com.tushar.model.Courses;

public class CourseDBObj {
	private Connection connection;
	private String query;
	private PreparedStatement pStatement;
	private ResultSet rSet;
	private int totalItem;
	private double totalPrice;
	
	public CourseDBObj(Connection connection) {
		this.connection = connection;
	}
	
	public int getTotalItem() {
		return totalItem;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public List<Courses> getAllCourses() {
		List<Courses> courses = new ArrayList<>();
		
		try {
			query = "select * from courses";
			pStatement = this.connection.prepareStatement(query);
			rSet = pStatement.executeQuery();
			while(rSet.next()) {
				Courses course = new Courses();
				course.setCourseID(rSet.getInt("courseID"));
				course.setName(rSet.getString("name"));
				course.setCategory(rSet.getString("category"));
				course.setPrice(rSet.getDouble("price"));
				course.setImage(rSet.getString("image"));
				
				courses.add(course);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return courses;
	}
	
	public Courses getSingleCourse(int id) {
		Courses course = null;
		try {
			query = "select * from courses where courseID=?";
			pStatement = this.connection.prepareStatement(query);
			pStatement.setInt(1, id);
			rSet = pStatement.executeQuery();
			
			while(rSet.next()) {
				course = new Courses();
				course.setCourseID(rSet.getInt("courseID"));
				course.setName(rSet.getString("name"));
				course.setCategory(rSet.getString("category"));
				course.setPrice(rSet.getDouble("price"));
				course.setImage(rSet.getString("image"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return course;
	}
	
	public List<Cart> getCartCourses(ArrayList<Cart> cartList) {
		List<Cart> courses = new ArrayList<Cart>();
		totalItem = 0;
		totalPrice = 0;
		try {
			if(cartList.size() > 0) {
				for(Cart cart : cartList) {
					query = "select * from courses where courseID=?";
					pStatement = this.connection.prepareStatement(query);
					pStatement.setInt(1, cart.getCourseID());
					rSet = pStatement.executeQuery();
					while(rSet.next()) {
						Cart item = new Cart();
						item.setCourseID(rSet.getInt("courseID"));
						item.setName(rSet.getString("name"));
						item.setCategory(rSet.getString("category"));
						item.setPrice(rSet.getDouble("price"));
						totalPrice += item.getPrice() * cart.getQuantity();
						item.setImage(rSet.getString("image"));
						item.setQuantity(cart.getQuantity());
						totalItem += cart.getQuantity();
						
						courses.add(item);
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return courses;
	}
}
