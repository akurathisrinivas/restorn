package com.menu.menuService.payload.request;

import jakarta.validation.constraints.NotBlank;

public class MenuRequest {

	
	@jakarta.validation.constraints.NotBlank
    @jakarta.validation.constraints.Size(min = 50)
    private String title;
	
	@NotBlank
	 private String shot_desc;

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
}
