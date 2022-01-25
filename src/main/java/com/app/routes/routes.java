package com.app.routes;

import java.sql.Connection;

import java.sql.SQLException;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.controllers.loginController;
import com.app.model.Course;
import com.app.model.Student;
import com.app.sqlconnection.MysqlConnect;

@EnableJpaRepositories
@RestController
public class routes {
	Connection conn;

	@GetMapping("/")
	public String loginPage() {
		// build here the login page
		return "";
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/loginAuth")
	public ResponseEntity<String> loginAuth(@RequestBody Student student) throws SQLException {
		conn = new MysqlConnect().connect();
		Boolean loogedIn = new loginController(conn).login(student);
		if (loogedIn) {
			// send to courses page the student 
			return new  ResponseEntity<>(HttpStatus.OK);
		} else {
			//maybe here throw exception
			return new ResponseEntity<>("Password/ID is not valid", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/myProfile")
	@CrossOrigin(origins = "http://localhost:4200")
	public void profilePage(@RequestBody Student student) throws SQLException {
		System.err.println("asd");
	}
	
	@PostMapping("/editProfile")
	public void editProfile(@RequestBody Student student) throws SQLException {
		System.err.println("asd");
	}
	
	@DeleteMapping("/editProfile")
	public void cancelCourse(@RequestBody Course course) throws SQLException {
		System.err.println("asd");
	}
}
