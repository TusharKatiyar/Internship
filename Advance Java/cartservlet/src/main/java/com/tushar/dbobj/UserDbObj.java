package com.tushar.dbobj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tushar.model.User;

public class UserDbObj {
	private Connection connection;
	private String query;
	private PreparedStatement pStatement;
	private ResultSet rSet;

	public UserDbObj(Connection connection) {
		this.connection = connection;
	}

	public User userLogin(String email, String password) {
		User user = null;

		try {
			query = "select * from users where email=? and password=?";
			pStatement = this.connection.prepareStatement(query);
			pStatement.setString(1, email);
			pStatement.setString(2, password);
			rSet = pStatement.executeQuery();
			if (rSet.next()) {
				user = new User();
				user.setEmployeeID(rSet.getInt("employeeID"));
				user.setFirstName(rSet.getString("firstName"));
				user.setLastName(rSet.getString("lastName"));
				user.setDesignation(rSet.getString("designation"));
				user.setContactNumber(rSet.getString("contactNumber"));
				user.setEmail(rSet.getString("email"));
				user.setDob(rSet.getString("dob"));
				user.setAddress(rSet.getString("address"));
				user.setProfilePicture(rSet.getString("profilePicture"));
				user.setLink(rSet.getString("link"));
				user.setLanguage(rSet.getString("language"));
//				user.setPassword(rSet.getString("password"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return user;
	}

	public boolean userSignup(User user) {
		boolean set = false;

		try {
			query = "insert into users value (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			pStatement = this.connection.prepareStatement(query);
			pStatement.setInt(1, user.getEmployeeID());
			pStatement.setString(2, user.getFirstName());
			pStatement.setString(3, user.getLastName());
			pStatement.setString(4, user.getDesignation());
			pStatement.setString(5, user.getContactNumber());
			pStatement.setString(6, user.getEmail());
			pStatement.setString(7, user.getDob());
			pStatement.setString(8, user.getAddress());
			pStatement.setString(9, user.getProfilePicture());
			pStatement.setString(10, user.getLink());
			pStatement.setString(11, user.getLanguage());
			pStatement.setString(12, user.getPassword());
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

	public boolean updateUser(Integer empID, String fName, String lName, String desgName, String address, String contNo,
			String email, String link, String lang, String pic) {
		boolean flag = false;

		try {
			query = "update users " + 
					" set firstName = ?, lastName = ?, designation = ?, contactNumber = ?, email = ?, address = ?, " + 
					" profilePicture = ?, link = ?, language = ? where employeeID = ?";

			pStatement = this.connection.prepareStatement(query);
			pStatement.setString(1, fName);
			pStatement.setString(2, lName);
			pStatement.setString(3, desgName);
			pStatement.setString(4, contNo);
			pStatement.setString(5, email);
			pStatement.setString(6, address);
			pStatement.setString(7, pic);
			pStatement.setString(8, link);
			pStatement.setString(9, lang);
			pStatement.setInt(10, empID);
			pStatement.executeUpdate();

			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println(e.getMessage());
			return flag;
		}

		return flag;
	}
	
	public User getUser(Integer empID) {
		User user = new User();
		
		try {
			query = "select * from users where employeeID = ?";
			pStatement = this.connection.prepareStatement(query);
			pStatement.setInt(1, empID);
			rSet = pStatement.executeQuery();
			if (rSet.next()) {
				user.setEmployeeID(rSet.getInt("employeeID"));
				user.setFirstName(rSet.getString("firstName"));
				user.setLastName(rSet.getString("lastName"));
				user.setDesignation(rSet.getString("designation"));
				user.setContactNumber(rSet.getString("contactNumber"));
				user.setEmail(rSet.getString("email"));
				user.setDob(rSet.getString("dob"));
				user.setAddress(rSet.getString("address"));
				user.setProfilePicture(rSet.getString("profilePicture"));
				user.setLink(rSet.getString("link"));
				user.setLanguage(rSet.getString("language"));
//				user.setPassword(rSet.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return user;
	}
}
