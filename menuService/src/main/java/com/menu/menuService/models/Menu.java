package com.menu.menuService.models;


import java.sql.Date;
import java.util.Optional;

import org.hibernate.annotations.CreationTimestamp;

import com.menu.menuService.Dto.menuImagesDto;
import com.menu.menuService.Enum.categoryType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(	name = "menu", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "title")
			
		})
public class Menu {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 20)
	@Column(name = "title")
	private String title;
    
	@NotBlank
	@Column(name = "shot_desc")
    private String shot_desc;
	
	@NotBlank
	@Column(name = "type")
	private String type;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "category")
	@Enumerated(EnumType.STRING)
	private categoryType category;
	
	@CreationTimestamp
	@Column(name = "createdDate")
	private Date createdDate;
	
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "Status")
	private com.menu.menuService.Enum.Status Status;
	
	
	public Menu() {
		
	}
	public Menu(String title,String shot_desc) {
		super();
		this.title=title;
		this.shot_desc=shot_desc;
		
	}

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

	public String getShot_desc() {
		return shot_desc;
	}

	public void setShot_desc(String shot_desc) {
		this.shot_desc = shot_desc;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public categoryType getCategory() {
		return category;
	}
	public void setCategory(categoryType category) {
		this.category = category;
	}
	
	public com.menu.menuService.Enum.Status getStatus() {
		return Status;
	}
	public void setStatus(com.menu.menuService.Enum.Status status) {
		Status = status;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
