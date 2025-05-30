package com.rekreation.learning.hibernate6.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.SelectionQuery;

import com.rekreation.learning.hibernate6.entity.Student;
import com.rekreation.learning.hibernate6.utility.HibernateUtility;

public class StudentDelete {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		// Method 1

//		Student studentToDelete = new Student();
//		studentToDelete.setSno(111);
//
//		session.remove(studentToDelete);

//		// method 2
//		Student studentToDelete = session.get(Student.class, 222);
//		session.remove(studentToDelete);

		// method 3 : deleting multiple objects using query

		SelectionQuery<Student> query = session.createSelectionQuery("from Student where marks >= :marks",
				Student.class);
		query.setParameter("marks", 700.0);

		List<Student> studList = query.list();
		for (Student student : studList) {
			session.remove(student);
		}

		tx.commit();
		session.close();
	}
}
