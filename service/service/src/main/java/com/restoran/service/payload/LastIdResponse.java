package com.restoran.service.payload;

public class LastIdResponse {
 
	private int lastId;
	private String message;
	
	public LastIdResponse(int lastId,String message) {
	    this.lastId = lastId;
	    this.message= message;
	  }

	public int getLastId() {
		return lastId;
	}

	public void setLastId(int lastId) {
		this.lastId = lastId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
