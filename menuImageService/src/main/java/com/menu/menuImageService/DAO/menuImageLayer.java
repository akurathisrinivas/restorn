package com.menu.menuImageService.DAO;

public class menuImageLayer {
 
	  private Long id;
	  private String menuId;
	  private String link;

	  public menuImageLayer(Long id, String menuId,String link) {
		  this.setId(id);
	    this.setMenuId(menuId);
	    this.setLink(link);
	  }

	

	

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}



	public String getMenuId() {
		return menuId;
	}



	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}





	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}
}
