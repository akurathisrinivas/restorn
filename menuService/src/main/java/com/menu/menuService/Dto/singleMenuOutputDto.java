package com.menu.menuService.Dto;

import java.sql.Date;
import java.util.List;

import com.menu.menuService.Enum.categoryType;

public class singleMenuOutputDto {
	
	private Long id;
	private String title;
	private String shot_desc;
	private String type;
	private Double price;
	private categoryType category;

	
	private List<menuImagesDto> menuImages;
	public singleMenuOutputDto(Long id, Double price, String shot_desc, String title, String type,
			categoryType category, List<menuImagesDto> menuImages) {
		// TODO Auto-generated constructor stub
		super();
		this.id=id;
		this.price=price;
		this.shot_desc=shot_desc;
		this.title=title;
		this.type=type;
		this.category=category;
		
		this.menuImages=menuImages;
		
		
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public categoryType getCategory() {
		return category;
	}
	public void setCategory(categoryType category) {
		this.category = category;
	}
	
	
	public List<menuImagesDto> getMenuImages() {
		return menuImages;
	}
	public void setMenuImages(List<menuImagesDto> menuImages) {
		this.menuImages = menuImages;
	}
	
	

}
