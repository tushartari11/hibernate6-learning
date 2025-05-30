package com.rekreation.learning.hibernate6.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rekreation.learning.hibernate6.entity.Employee;
import com.rekreation.learning.hibernate6.utility.HibernateUtility;

public class EmployeeTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		Employee employee = new Employee();
		employee.setEmpName("Golu");
		employee.setEmpSalary(9999);
		session.persist(employee);
		tx.commit();
		session.close();
	}

}
