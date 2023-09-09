package com.restoran.bookings.dao;

import java.sql.Date;

public class BookingsDao {

	 private Long id;
	 private String name;
	 private String bookingId;
	 private String email;
	 private String datetime;
	 private String people;
	 private String specialrequest;
	 private Date createdDate;
	 
	public BookingsDao(Long id, String bookingId, String datetime, Date createdDate, String email, String name,
			String people, String specialrequest) {
		// TODO Auto-generated constructor stub
		
		this.id= id;
		this.bookingId= bookingId;
		this.createdDate= createdDate;
		this.datetime= datetime;
		this.people=people;
		this.specialrequest=specialrequest;
		this.email=email;
		this.name=name;
		
		
	}
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
