package com.moneyware.digital.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.moneyware.digital.enums.Status;

@Entity
@Table(name="mwfncrp_customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUST_ID", updatable = false, nullable = false)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "EMAIL")
	private String email;
	
	
	/*@Column(name="PHONE")
	private String phone;
	
	@Column(name = "ADDRESS")
	private String address1;
	
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATE")
	private String state;
	@Column(name = "POSTAL_CODE")
	private String postalCode;
	
	@Column(name = "COUNTRY")
	private String country;*/
	@Column(name="STATUS")
	private Status status;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DOC_ID_FK")
	private Document document;
	
	


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(String firstName, String lastName, String email,Status status, Document document) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.status = status;
		this.document = document;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public Document getDocument() {
		return document;
	}


	public void setDocument(Document document) {
		this.document = document;
	}
	
	
	
	
	

}
