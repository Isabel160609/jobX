package com.init.jobX.segurity.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Pattern;

public class NewUser {

	// private String name;

	private String username;

	@Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message = "invalid mail")
	private String email;
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[AZ])(?=\\S+$).{8,20}$", message = "invalid password")
	private String password;
	private Set<String> roles = new HashSet<>();

//
//	    public String getName() {
//			return name;
//		}
//
//		public void setName(String name) {
//			this.name = name;
//		}

	public String getUserName() {
		return username;
	}

	public NewUser(String username, String email, String password, Set<String> roles) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public NewUser() {
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
}
