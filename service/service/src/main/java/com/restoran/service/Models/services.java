package com.restoran.service.Models;

import java.sql.Date;

import javax.persistence.*;
//import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="services", uniqueConstraints = { 
		@UniqueConstraint(columnNames = "title")
		
	})
public class services {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Title not be empty")
    @Size(min = 3, max = 20)
	@Column(name = "title")
	private String title;
    
	@NotBlank(message = "Short description not be empty")
	@Column(name = "short_description")
	private String short_description;
	
	@NotBlank(message = "Long description not be empty")
	@Column(name = "long_description")
	private String long_description;
	
	@CreationTimestamp
	private Date createdDate;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "status") 
	private com.restoran.service.Enum.status  status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShort_description() {
		return short_description;
	}

	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}

	public String getLong_description() {
		return long_description;
	}

	public void setLong_description(String long_description) {
		this.long_description = long_description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public com.restoran.service.Enum.status getStatus() {
		return status;
	}

	public void setStatus(com.restoran.service.Enum.status status) {
		this.status = status;
	}
	
}
