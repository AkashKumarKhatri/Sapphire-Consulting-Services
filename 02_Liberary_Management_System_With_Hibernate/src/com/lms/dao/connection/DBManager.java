package com.lms.dao.connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class DBManager {
	private static SessionFactory sessionFactory = null;
	
	public static SessionFactory getConnection() {
		if(sessionFactory == null) {
			sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
			System.out.println("Connection Established");
		}
		return sessionFactory;
	}
	
	public static void main(String[] args) {
		DBManager.getConnection();
	}
}
