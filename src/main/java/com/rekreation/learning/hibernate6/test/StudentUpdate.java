package com.rekreation.learning.hibernate6.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;

import com.rekreation.learning.hibernate6.utility.HibernateUtility;

public class StudentUpdate {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		// Method 1 : using session object
//		Student student = session.get(Student.class, 111);
////		if (student == null) {
////			System.out.println("Student not found");
////
////		} else {
//		student.setSname("Rajesh");
//		student.setMarks(550.0);
//		session.merge(student);
//		}

		/*
		 * Old hibernate version Hibernate 5
		 * 
		 * Student stud = (Session)session.get(Student.class, 111);
		 * stud.setMarks(550.0); session.update(stud);
		 * 
		 */

		// Method 2 : Using HQL - which is applied to model Class

		MutationQuery query = session.createMutationQuery("update Student set marks = :marks where sname = :sname");
		query.setParameter("marks", 650.0);
		query.setParameter("sname", "Suma");
		query.executeUpdate();
		
		/*
		 * Old hibernate version Hibernate 5
		 * 
		 * Query query = session.createQuery("update Student set marks = :marks where sname = :sname");
		 * query.setParameter("marks", 650.0);
		 * query.setParameter("sname", "Suma");
		 * query.executeUpdate();
		 */
		
		tx.commit();
		session.close();
	}
}
