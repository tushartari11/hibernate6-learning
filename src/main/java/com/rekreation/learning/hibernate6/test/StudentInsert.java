package com.rekreation.learning.hibernate6.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rekreation.learning.hibernate6.entity.Student;
import com.rekreation.learning.hibernate6.utility.HibernateUtility;

public class StudentInsert {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		Student student = new Student(113, "Ramu", 900.0);
		session.persist(student);
		tx.commit();
		session.close();
	}
}
