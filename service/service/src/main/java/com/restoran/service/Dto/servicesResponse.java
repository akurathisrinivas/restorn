package com.restoran.service.Dto;

import java.util.Date;

public class servicesResponse {
	
	private Long id;
	private String title;
	private String short_description;
	private String long_description;
	private Date created_date;
	private com.restoran.service.Enum.status status2;
	private String iconurl;
	
	public servicesResponse(Long id,String title,String short_description,String long_description,Date created_date,com.restoran.service.Enum.status status2,String iconurl) {
		
		this.id=id;
		this.title=title;
		this.short_description=short_description;
		this.long_description=long_description;
		this.created_date=created_date;
		this.status2=status2;
		this.iconurl=iconurl;
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

	public com.restoran.service.Enum.status getStatus2() {
		return status2;
	}

	public void setStatus2(com.restoran.service.Enum.status status2) {
		this.status2 = status2;
	}

	public String getIconurl() {
		return iconurl;
	}

	public void setIconurl(String iconurl) {
		this.iconurl = iconurl;
	}
}
