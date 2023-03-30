package com.tushar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class role {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(length=29)
	private String name;

	public role(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public role() {
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
