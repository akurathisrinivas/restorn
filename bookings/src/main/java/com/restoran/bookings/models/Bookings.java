package com.restoran.bookings.models;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(	name = "bookings", 
uniqueConstraints = { 
	@UniqueConstraint(columnNames = "bookingId")
	
})
public class Bookings {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 20)
	@Column(name = "name")
	private String name;
	
	@NotBlank
	@Column(name = "bookingId")
	private String bookingId;
	
	
	@NotBlank
	@Column(name = "email")
	private String email;
	
	@NotBlank
	@Column(name = "datetime")
	private String datetime;
	
	@Column(name = "people")
	private String people;
	
	@Column(name = "specialrequest")
	private String specialrequest;
	
	@CreationTimestamp
	@Column(name = "createdDate")
	private Date createdDate;

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

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
	}

	public String getSpecialrequest() {
		return specialrequest;
	}

	public void setSpecialrequest(String specialrequest) {
		this.specialrequest = specialrequest;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}
