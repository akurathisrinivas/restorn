package com.auth.loginService.response;

public class signinResponse {
	
	private String message;
	private String jwtToken;
	
	public signinResponse(String message, String jwtToken) {
		// TODO Auto-generated constructor stub
		this.message=message;
		this.jwtToken=jwtToken;
	}

	/*
	 * public void singinResponse(String message,String jwtToken) {
	 * this.setMessage(message); this.setJwtToken(jwtToken);
	 * 
	 * }
	 */

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

}
