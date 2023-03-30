package com.spring.modal;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestMain {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();

		
		Team team1 = new Team();
		team1.setId(1);
		team1.setName("India Cricket Team");
		
		Role bat = new Role();
		bat.setId(1);
		bat.setName("Batsman");
		
		Role bowl = new Role();
		bowl.setId(2);
		bowl.setName("Bowler");
		
		List<Player> players1 = new ArrayList<Player>();
		players1.add( new Player(1, "Virat Kholi", team1, bat) );
		players1.add( new Player(2, "Rohit Sharma", team1, bat) );
		players1.add( new Player(3, "Sachin Tendulkar", team1, bat) );
		players1.add( new Player(4, "Ravindra Jadega", team1, bowl) );
		players1.add( new Player(5, "Mhd. Shami", team1, bowl) );
		players1.add( new Player(6, "Jasprit Bhumra", team1, bowl) );
		team1.setPlayers(players1);
		
		// team 2
		Team team2 = new Team();
		team2.setId(2);
		team2.setName("Australia");
		
		players1 = new ArrayList<Player>();
		players1.add( new Player(7, "Steve Smith", team2, bat) );
		players1.add( new Player(8, "David Warner", team2, bat) );
		players1.add( new Player(9, "Shane Warne", team2, bowl) );
		players1.add( new Player(10, "Glen Maxwell", team2, bat) );
		players1.add( new Player(11, "Pat Cummins", team2, bowl) );
		players1.add( new Player(12, "Michel Starc", team2, bowl) );
		team2.setPlayers(players1);

		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();

		session.save(bowl);
		session.save(bat);
		session.save(team1);
		session.save(team2);

		txn.commit();
		session.close();
		System.out.println("Done...");
	}

}
