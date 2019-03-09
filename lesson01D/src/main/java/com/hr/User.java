package com.hr;

public class User {
	private String u_id;
	private String name;
	private String password;
	
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", name=" + name + ", password=" + password + "]";
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
