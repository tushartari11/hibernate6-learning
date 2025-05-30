package com.rekreation.learning.hibernate6.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.rekreation.learning.hibernate6.entity.Employee;
import com.rekreation.learning.hibernate6.utility.HibernateUtility;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class CriteriaDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		Session session = sessionFactory.openSession();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cr = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> root = cr.from(Employee.class);
		// select all employees
//		cr.select(root);

		// List employees whose salary greate than 10000
//		cr.select(root).where(criteriaBuilder.gt(root.get("empSalary"), 10000));

		// List employees whose salary less than 10000
//		cr.select(root).where(criteriaBuilder.lt(root.get("empSalary"), 10000));

		// List employees whose name start with R
//		cr.select(root).where(criteriaBuilder.like(root.get("empName"), "R%"));

		// List employees whose name ends with u
//		cr.select(root).where(criteriaBuilder.like(root.get("empName"), "%u"));

		// List employees whose name has third character is m
//		cr.select(root).where(criteriaBuilder.like(root.get("empName"), "__m%"));

		// List employees whose name contains exactly 4 characters
//		cr.select(root).where(criteriaBuilder.like(root.get("empName"), "____"));

		// List employees whose name contains character a
		cr.select(root).where(criteriaBuilder.like(root.get("empName"), "%a%"));

		Query query = session.createQuery(cr);
		List<Employee> empList = query.getResultList();
		empList.forEach(System.out::println);

		/*
		 * Prior to Hibernate 6 Criteria cr = session.createCriteria(Employee.class);
		 * List<Employee> emplist = cr.list(); empList.forEach(System.out::println);
		 * 
		 */

	}

}
