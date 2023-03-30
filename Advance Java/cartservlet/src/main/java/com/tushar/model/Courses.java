package com.tushar.model;

public class Courses {
	private int courseID;
	private String name;
	private String category;
	private Double price;
	private String image;
	
	public Courses() {
		
	}

	public Courses(int courseID, String name, String category, Double price, String image) {
		this.courseID = courseID;
		this.name = name;
		this.category = category;
		this.price = price;
		this.image = image;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double string) {
		this.price = string;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Courses [courseID=" + courseID + ", name=" + name + ", category=" + category + ", price=" + price
				+ ", image=" + image + "]";
	}
}
