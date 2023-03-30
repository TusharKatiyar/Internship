package com.spring.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "team1_id")
	private Team team1;

	@OneToOne
	@JoinColumn(name = "team2_id")
	private Team team2;

	public Game() {
		super();
	}
	
	

	public Game(int id) {
		super();
		this.id = id;
	}



	public Game(int id, Team team1, Team team2) {
		super();
		this.id = id;
		this.team1 = team1;
		this.team2 = team2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Team getTeam1() {
		return team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", team1=" + team1 + ", team2=" + team2 + "]";
	}
}
