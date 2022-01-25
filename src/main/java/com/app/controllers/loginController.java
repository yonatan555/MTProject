package com.app.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.app.model.Student;

public class loginController {
	Connection conn;

	public loginController(Connection conn) {
		this.conn = conn;
	}

	public boolean login(Student student) throws SQLException {
		Boolean isAllowed;
		if(student == null) return false;
		Integer id = student.getId();
		// if id is valid
		// Boolean idIsValid = validate(id); // add to 23 line
		// if id is exist
		Boolean studentIdExist = verifyId(id);
		// validate if password is ok
		Boolean passwordAllow = verifyPassword(student.getPassword());
		isAllowed = passwordAllow && studentIdExist; // --> passwordAllow && studentIdExist && idIsValid
		return isAllowed;
	}

	private Boolean validate(Integer id) {
		// add more validations
		String idStr = "" + id;
		return id != null && idStr.length() == 9;
	}

	private Boolean verifyId(Integer id) throws SQLException {
		String queryId = "SELECT * FROM students WHERE studentId=" + id + ";";
		System.err.println(queryId);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(queryId);
		if (!rs.next())
			return false;
		String studentId = rs.getString("studentId");
		return studentId.equals(id+"");
	}
	
	private Boolean verifyPassword(String password) throws SQLException {
		//add more validations in password
		String queryPass = "SELECT * FROM students WHERE password=" + password + ";";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(queryPass);
		if (!rs.next())
			return false;
		String PasswordDB = rs.getString("password");
		return PasswordDB.equals(password);
	}

}
