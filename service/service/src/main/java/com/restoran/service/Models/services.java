package com.restoran.service.Models;

//import java.sql.Date;
import java.util.Date;
//import java.util.Calendar;

import javax.persistence.*;
//import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;

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
    
	@Column(name = "icon")
	private String icon;
	
	@NotBlank(message = "Short description not be empty")
	@Column(name = "short_description")
	private String short_description;
	
	@NotBlank(message = "Long description not be empty")
	@Column(name = "long_description")
	private String long_description;
	
	@Column(name = "icon_class")
	private String icon_class;
	
	@CreationTimestamp
	private Date createdDate;
	
	/*
	 * @Basic(optional = false)
	 * 
	 * @Column(name = "updated_datetime", insertable = false, updatable = false)
	 * 
	 * @Temporal(TemporalType.TIME) private Date updated_datetime;
	 */
	
	//@CreationTimestamp
	//private Date updatedDate;
	
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIcon_class() {
		return icon_class;
	}

	public void setIcon_class(String icon_class) {
		this.icon_class = icon_class;
	}

	
	
}
