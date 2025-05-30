package com.rekreation.learning.hibernate6.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rekreation.learning.hibernate6.entity.Address;
import com.rekreation.learning.hibernate6.entity.Customer;
import com.rekreation.learning.hibernate6.utility.HibernateUtility;

public class OneToOneMappingTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		// Create Customer and Address instances
		Customer customer = new Customer();
		customer.setId(112L);
		customer.setName("Max Mustermann");
		customer.setEmail("max.mustermann@example.com");

		Address address = new Address();
		address.setId(102L);
		address.setStreet("123 Shleisheimerstr");
		address.setCity("Munich");
		address.setState("BY");
		address.setZipCode("80334");

		// Set references for one-to-one mapping
		customer.setAddress(address);

		session.persist(address);
		session.persist(customer);
		tx.commit();
		session.close();
	}
}
