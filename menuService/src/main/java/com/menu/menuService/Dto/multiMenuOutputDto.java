package com.menu.menuService.Dto;

import java.util.List;

public class multiMenuOutputDto {

	private List<singleMenuOutputDto> popularMenuList;
	private List<singleMenuOutputDto> speacialMenuList;
	private List<singleMenuOutputDto> lovelyMenuList;
	
	
	public multiMenuOutputDto(List<singleMenuOutputDto> popularMenuList,List<singleMenuOutputDto> speacialMenuList,List<singleMenuOutputDto> lovelyMenuList) {
		
		this.popularMenuList=popularMenuList;
		this.speacialMenuList=speacialMenuList;
		this.lovelyMenuList=lovelyMenuList;

		
	}
	
	public List<singleMenuOutputDto> getPopularMenuList() {
		return popularMenuList;
	}
	public void setPopularMenuList(List<singleMenuOutputDto> popularMenuList) {
		this.popularMenuList = popularMenuList;
	}
	public List<singleMenuOutputDto> getSpeacialMenuList() {
		return speacialMenuList;
	}
	public void setSpeacialMenuList(List<singleMenuOutputDto> speacialMenuList) {
		this.speacialMenuList = speacialMenuList;
	}
	public List<singleMenuOutputDto> getLovelyMenuList() {
		return lovelyMenuList;
	}
	public void setLovelyMenuList(List<singleMenuOutputDto> lovelyMenuList) {
		this.lovelyMenuList = lovelyMenuList;
	}
}
