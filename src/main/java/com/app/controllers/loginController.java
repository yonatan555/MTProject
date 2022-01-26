package com.app.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.app.model.Student;

public class LoginController {
	Connection conn;

	public LoginController(Connection conn) {
		this.conn = conn;
	}

	public boolean login(Integer id,String password) throws SQLException {
		Boolean isAllowed;
		String strId = id.toString();
		// if id is valid
		Boolean idIsValid = validate(strId); 
		// if id is exist
		Boolean studentIdExist = verifyId(strId);
		// validate if password is ok
		Boolean passwordAllow = verifyPassword(password,strId);
		isAllowed = passwordAllow && studentIdExist && idIsValid; // --> passwordAllow && studentIdExist && idIsValid
		return isAllowed;
	}

	private Boolean validate(String id) {
		// add more validations
		boolean isMatches = id.matches("[0-9]+");
		return id != null && id.length() == 9 && isMatches;
	}

	private Boolean verifyId(String id) throws SQLException {
		String queryId = "SELECT * FROM students WHERE studentId=" + id + ";";
		System.err.println(queryId);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(queryId);
		if (!rs.next())
			return false;
		String studentId = rs.getString("studentId");
		return studentId.equals(id+"");
	}
	
	private Boolean verifyPassword(String password,String id) throws SQLException {
		//add more validations in password
		String queryPass = "SELECT password FROM students WHERE password=" + "'"+password +"'"+ "and studentId="+id+ ";";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(queryPass);
		if (!rs.next())
			return false;
		String PasswordDB = rs.getString("password");
		return PasswordDB.equals(password);
	}

}
