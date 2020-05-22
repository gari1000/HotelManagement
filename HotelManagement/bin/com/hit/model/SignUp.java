package com.hit.model;

import java.sql.*;
import java.util.Calendar;

public class SignUp {

	private String user;
	private String email;
	private String password;
	private String myDriver;
	private String myUrl;
	private String query;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
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

	public String getMyDriver() {
		return myDriver;
	}

	public void setMyDriver(String myDriver) {
		this.myDriver = myDriver;
	}

	public String getMyUrl() {
		return myUrl;
	}

	public void setMyUrl(String myUrl) {
		this.myUrl = myUrl;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public void newUser(String user, String email, String password, String myDriver, String myUrl, String query) {

		try {
			
			// create a mysql database connection
//	      String myDriver = "com.mysql.jdbc.Driver";
//	      String myUrl = "jdbc:mysql://localhost/HotelManagement";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "newuser", "password");

			// create a sql date object so we can use it in our INSERT statement
			Calendar calendar = Calendar.getInstance();
			java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

			// the mysql insert statement
//	      String query = " insert into users (username, email,password, create_time)"
//	        + " values (?, ?, ?, ?)";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, user);
			preparedStmt.setString(2, email);
			preparedStmt.setString(3, password);
			preparedStmt.setDate(4, startDate);

			// execute the preparedstatement
			preparedStmt.execute();

			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}

	public boolean Login(String user, String password, String myDriver, String myUrl, String query) {

		boolean usernameExists = false;

		try {

			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "newuser", "password");

			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, user);
			preparedStmt.setString(2, password);

			ResultSet res = preparedStmt.executeQuery();
			String usernameCounter;
			String passCounter;

			while (res.next()) {
				usernameCounter = res.getString("username");
				passCounter = res.getString("password");

				if (usernameCounter.equals(user))
					usernameExists = true;

			}

			// execute the preparedstatement
			preparedStmt.execute();

			conn.close();

		}

		catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());

		}
		return usernameExists;

	}

}
