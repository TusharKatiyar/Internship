package com.spring.MappingCriteriaQueries_Main;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Query query = session.createQuery("select r.game.id\r\n"
				+ "from Result r\r\n"
				+ "inner join Team t\r\n"
				+ "on r.lossTeam.id = t.id\r\n"
				+ "and t.name = 'Australia'\r\n"
				+ "inner join Player p\r\n"
				+ "on r.player.id = p.id\r\n"
				+ "and p.name = 'Sachin Tendulkar'");
		
		List<Integer> result = query.getResultList();
		
		System.out.println("Sachin was Man of The Match in :");
		for(Integer res : result) {
			System.out.println("Game " + res.toString());
		}
		
		query = session.createQuery("select p.name as playerName,\r\n"
				+ "	   r.game.id as gameId\r\n"
				+ "from Result r\r\n"
				+ "inner join Player p\r\n"
				+ "on r.player.id = p.id\r\n"
				+ "inner join Role ro\r\n"
				+ "on p.role.id = ro.id\r\n"
				+ "and ro.name = 'Bowler'\r\n"
				+ "inner join Team t\r\n"
				+ "on p.team.id = t.id\r\n"
				+ "and t.name = 'India Cricket Team'\r\n"
				+ "order by playerName");
		
		List<Object []> result1 = query.getResultList();
		System.out.println("Indian bowler was player of the Match order alphabetically by player names: ");
		for (Object[] objects : result1) {
			System.out.println(Arrays.toString(objects));
		}
		
		session.close();
		factory.close();
    }
}
