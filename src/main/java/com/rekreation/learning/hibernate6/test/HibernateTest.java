package com.rekreation.learning.hibernate6.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rekreation.learning.hibernate6.utility.HibernateUtility;

public class HibernateTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		String version = (String) session.createNativeQuery("Select version()").getSingleResult();
		System.out.println("MySQL version : " + version);
	}
}
