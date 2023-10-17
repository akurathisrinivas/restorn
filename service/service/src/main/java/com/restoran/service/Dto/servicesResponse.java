package com.restoran.service.Dto;

import java.util.Date;

public class servicesResponse {
	
	private Long id;
	private String title;
	private String short_description;
	private String long_description;
	private Date created_date;
	private com.restoran.service.Enum.status status;
	private String iconurl;
	private String icon_class;
	
	public servicesResponse(Long id,String title,String short_description,String long_description,Date created_date,com.restoran.service.Enum.status status,String iconurl,String icon_class) {
		
		this.id=id;
		this.title=title;
		this.short_description=short_description;
		this.long_description=long_description;
		this.created_date=created_date;
		this.status=status;
		this.iconurl=iconurl;
		this.icon_class=icon_class;
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

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public com.restoran.service.Enum.status getStatus() {
		return status;
	}

	public void setStatus(com.restoran.service.Enum.status status) {
		this.status = status;
	}

	public String getIconurl() {
		return iconurl;
	}

	public void setIconurl(String iconurl) {
		this.iconurl = iconurl;
	}



	public String getIcon_class() {
		return icon_class;
	}


	public void setIcon_class(String icon_class) {
		this.icon_class = icon_class;
	}
}
