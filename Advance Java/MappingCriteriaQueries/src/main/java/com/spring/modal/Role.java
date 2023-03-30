package com.spring.modal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Role {
	@Id
	private int id;
	
	@Column(length = 29)
	private String name;
	
	@OneToOne(mappedBy = "role",  fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Player player;

	public Role() {
		super();
	}

	public Role(int id, String name, Player player) {
		super();
		this.id = id;
		this.name = name;
		this.player = player;
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

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", player=" + player + "]";
	}
}
