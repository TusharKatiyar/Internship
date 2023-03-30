package com.tushar.model;

public class Cart extends Courses {
	private int quantity;
	
	public Cart() {}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Courses [courseID=" + getCourseID() + ", name=" + getName() + ", category=" + getCategory() + ", price=" + getPrice()
				+ ", image=" + getImage() + ", quantity=" + getQuantity() +"]";
	}
	
}
