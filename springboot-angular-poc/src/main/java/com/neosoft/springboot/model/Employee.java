package com.neosoft.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
@Table(name = "poc_employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeId;
	
	@Column(name = "first_name",nullable = false)
	//@Pattern(regexp="^[a-zA-Z]*$",message="First name should contain characters only")
	private String firstName;

	@Column(name = "last_name",nullable = false)
	//@Pattern(regexp="^[a-zA-Z]*$",message="Last name should contain characters only")
	private String lastName;
	
	@Column(name = "email_id",nullable = false)
	//@Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message="Enter valid email id")
	private String emailId;
	
	@Column(name = "mobile_no",nullable = false)
	//@Pattern(regexp="^[a-zA-Z0-9]{10}",message="Enter valid mobile number with 10 digits")
	private long mobileNo;
	
	@Column(name = "city",nullable = false)
	//@Pattern(regexp="^[a-zA-Z]*$",message="City name should contain characters only")
	private String city;
	
	@Column(name = "country",nullable = false)
	//@Pattern(regexp="^[a-zA-Z]*$",message="Country name should contain characters only")
	private String country;
	
	
	public Employee() {
		
	}


	public Employee(String firstName, String lastName, String emailId, long mobileNo, String city, String country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.city = city;
		this.country = country;
	}


	public Integer getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
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


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public long getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}
	
	/*
	 * public Employee(String firstName, String lastName, String emailId) { super();
	 * this.firstName = firstName; this.lastName = lastName; this.emailId = emailId;
	 * } public long getId() { return id; } public void setId(long id) { this.id =
	 * id; } public String getFirstName() { return firstName; } public void
	 * setFirstName(String firstName) { this.firstName = firstName; } public String
	 * getLastName() { return lastName; } public void setLastName(String lastName) {
	 * this.lastName = lastName; } public String getEmailId() { return emailId; }
	 * public void setEmailId(String emailId) { this.emailId = emailId; }
	 */
}
