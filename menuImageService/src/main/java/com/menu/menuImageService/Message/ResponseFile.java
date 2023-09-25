package com.menu.menuImageService.Message;

public class ResponseFile {
	
	private String name;
	  private String url;
	  private String type;
	  private long size;
	  private String menuId;

	  public ResponseFile(String menuId,String name, String url, String type) {
	    this.menuId=menuId;
		this.name = name;
	    this.url = url;
	    this.type = type;
	   // this.size = size;
	  }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	

		  
}
