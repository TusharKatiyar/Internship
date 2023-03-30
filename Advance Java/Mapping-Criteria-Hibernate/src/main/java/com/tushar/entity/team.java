package com.tushar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class team {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(length=19)
	private String name;
	
	public team(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	public team() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
