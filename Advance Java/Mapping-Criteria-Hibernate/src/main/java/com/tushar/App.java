package com.tushar;

import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		System.out.println("Project started..");
		
		Configuration cfg
		cfg.configure("hibernate.cfg.xml"); 
		
	}
}
