package com.tushar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class player {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(length=139)
	private String name;
	private int teamId;
	private int roleId;
	
	
}
