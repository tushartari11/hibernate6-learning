package com.rekreation.learning.hibernate6.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.SelectionQuery;

import com.rekreation.learning.hibernate6.entity.Student;
import com.rekreation.learning.hibernate6.utility.HibernateUtility;

public class StudentList {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		Session session = sessionFactory.openSession();

		SelectionQuery<Student> selectionQuery = session.createSelectionQuery("from Student ", Student.class);

		List<Student> studentsList = selectionQuery.list();

		studentsList.forEach(s -> System.out.println(s)); // using lambda
		studentsList.forEach(System.out::println); // using method Reference

		session.close();
	}
}
