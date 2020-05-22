package com.hit.controller;
import com.hit.model.*;

public class SignUpController {
	
	private String user;
	private String password;
	private String email;
	private boolean userExists;
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public SignUpController(String user, String email, String password,String myDriver,String myUrl,String query) {
		SignUp signup = new SignUp();
		signup.newUser(user, password, email,myDriver,myUrl, query);
	}
	
	public SignUpController(String user, String password,String myDriver,String myUrl,String query) {
		SignUp signup = new SignUp();
		this.userExists = signup.Login(user, password, myDriver, myUrl, query);
	}

	public boolean isUserExists() {
		return userExists;
	}

	public void setUserExists(boolean userExists) {
		this.userExists = userExists;
	}
	
}












