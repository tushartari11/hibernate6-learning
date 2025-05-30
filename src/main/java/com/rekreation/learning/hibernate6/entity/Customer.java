package com.rekreation.learning.hibernate6.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name = "customer_info")
public class Customer {

	@Id
	@Column(name = "customer_id")
	private Long id;

	@Column(name = "customer_name")
	private String name;
	private String email;

	@OneToOne
	private Address address; // One-to-One mapping

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Long id, String name, String email, Address address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + "]";
	}

}