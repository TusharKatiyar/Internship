package com.tushar.model;

public class User {
	
	private int employeeID;
	private String firstName;
	private String lastName;
	private String designation;
	private String contactNumber;
	private String email;
	private String dob;
	private String address;
	private String profilePicture;
	private String link;
	private String language;
	private String password;
	
	
	public User() {
		
	}
	
	public User(int employeeID, String firstName, String lastName, String designation, String contactNumber,
			String email, String dob, String address, String profilePicture, String link, String language,
			String password) {
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.contactNumber = contactNumber;
		this.email = email;
		this.dob = dob;
		this.address = address;
		this.profilePicture = profilePicture;
		this.link = link;
		this.language = language;
		this.password = password;
	}


	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", designation=" + designation + ", contactNumber=" + contactNumber + ", email=" + email + ", dob="
				+ dob + ", address=" + address + ", profilePicture=" + profilePicture + ", link=" + link + ", language="
				+ language + ", password=" + password + "]";
	}
}
