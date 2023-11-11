package com.auth.loginService.response;

public class signinResponse {
	
	private String message;
	private String jwtToken;
	private int id;
	private String email;
	private String name;
	private String roles;
	
	public signinResponse(int id,String name,String email,String roles,String message, String jwtToken) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
		this.email=email;
		this.roles=roles;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

}
