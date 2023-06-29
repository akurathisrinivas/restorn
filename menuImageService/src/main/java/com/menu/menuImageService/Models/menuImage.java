package com.menu.menuImageService.Models;

import java.sql.Date;
import java.util.stream.Stream;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.context.annotation.ApplicationScope;

import jakarta.persistence.*;

@Entity
@Table(name="menu_images", schema="public")
//@Table(name = "menu_images", schema = "public")
//@NamedQuery(name = "menu_images.findAll", query = "SELECT t FROM menu_images t")
//@ApplicationScope
public class menuImage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;

    @Column(name = "type")
	private String type;
    
    @Column(name = "data")
	//@Lob
	private byte[] data;
	 
	/*
	 * @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 * 
	 * @JoinColumn(name = "menu_id", nullable = false)
	 * 
	 * @OnDelete(action = OnDeleteAction.CASCADE)
	 * 
	 * @JsonIgnore
	 */
	 private String menuId;
	
	 @CreationTimestamp
	 private Date createdDate;
	 
	 public  menuImage() {
	  }

	  public  menuImage(String name, String type, byte[] data,String menuId) {
		  super();
	    this.name = name;
	    this.type = type;
	    this.data = data;
	    this.menuId = menuId;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	
}
