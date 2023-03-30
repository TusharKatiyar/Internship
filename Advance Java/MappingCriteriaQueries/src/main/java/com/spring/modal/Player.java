package com.spring.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Player {
	@Id
	private int id;
	
	@Column(length = 139)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "teamId")
	private Team team;
	
	@OneToOne
	@JoinColumn(name = "roleId")
	private Role role;

	public Player() {
		super();
	}

	public Player(int id) {
		super();
		this.id = id;
	}

	public Player(int id, String name, Team team, Role role) {
		super();
		this.id = id;
		this.name = name;
		this.team = team;
		this.role = role;
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

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", team=" + team + ", role=" + role + "]";
	}
}
