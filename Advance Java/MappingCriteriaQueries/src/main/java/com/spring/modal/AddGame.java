package com.spring.modal;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddGame {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		
		List<Game> games = new ArrayList<Game>();
		games.add(new Game(1, new Team(1), new Team(2)));
		games.add(new Game(2, new Team(1), new Team(2)));
		games.add(new Game(3, new Team(1), new Team(2)));
		games.add(new Game(4, new Team(1), new Team(2)));
		games.add(new Game(5, new Team(1), new Team(2)));
		games.add(new Game(6, new Team(1), new Team(2)));
		games.add(new Game(7, new Team(1), new Team(2)));
		games.add(new Game(8, new Team(1), new Team(2)));
		games.add(new Game(9, new Team(1), new Team(2)));
		games.add(new Game(10, new Team(1), new Team(2)));
		
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		for (Game game : games) {
			session.save(game);
		}
		
		txn.commit();
		session.close();
		System.out.println("Done...");
	}

}
