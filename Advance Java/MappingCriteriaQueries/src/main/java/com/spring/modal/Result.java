package com.spring.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "result")
public class Result {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "gameId")
	private Game game;

	@ManyToOne
	@JoinColumn(name = "winningTeamId")
	private Team winTeam;

	@ManyToOne
	@JoinColumn(name = "losingTeamId")
	private Team lossTeam;

	@ManyToOne
	@JoinColumn(name = "playerOfTheMatchId")
	private Player player;

	public Result() {
		super();
	}

	public Result(int id, Game gameId, Team winTeam, Team lossTeam, Player player) {
		super();
		this.id = id;
		this.game = gameId;
		this.winTeam = winTeam;
		this.lossTeam = lossTeam;
		this.player = player;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Game getGameId() {
		return game;
	}

	public void setGameId(Game gameId) {
		this.game = gameId;
	}

	public Team getWinTeam() {
		return winTeam;
	}

	public void setWinTeam(Team winTeam) {
		this.winTeam = winTeam;
	}

	public Team getLossTeam() {
		return lossTeam;
	}

	public void setLossTeam(Team lossTeam) {
		this.lossTeam = lossTeam;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return "Result [id=" + id + ", game=" + game + ", winTeam=" + winTeam + ", lossTeam=" + lossTeam + ", player="
				+ player + "]";
	}
}
