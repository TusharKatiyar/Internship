package com.spring.modal;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddResult {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
//		Game game = new Game();
//		game.setId(1);
//		game.setTeam1(new Team(1));
//		game.setTeam2(new Team(2));
		
		List<Result> results = new ArrayList<Result>();
		results.add(new Result(1, new Game(1), new Team(1), new Team(2), new Player(3))); // india, sachin
		results.add(new Result(2, new Game(2), new Team(1), new Team(2), new Player(1))); // india, virat
		results.add(new Result(3, new Game(3), new Team(2), new Team(1), new Player(7))); // aus, steave
		results.add(new Result(4, new Game(4), new Team(1), new Team(2), new Player(4))); // ind, ravindra
		results.add(new Result(5, new Game(5), new Team(1), new Team(2), new Player(3))); // ind, sachin
		results.add(new Result(6, new Game(6), new Team(1), new Team(2), new Player(5))); // ind, shami
		results.add(new Result(7, new Game(7), new Team(1), new Team(2), new Player(5))); // ind, shami
		results.add(new Result(8, new Game(8), new Team(2), new Team(1), new Player(12))); // aus, starc
		results.add(new Result(9, new Game(9), new Team(1), new Team(2), new Player(4))); // ind, ravindra
		results.add(new Result(10, new Game(10), new Team(1), new Team(2), new Player(6))); // ind, Bhumra
		
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		for (Result result : results) {
			session.save(result);
		}
		
		txn.commit();
		session.close();
		System.out.println("Done...");
	}

}
