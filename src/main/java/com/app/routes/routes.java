package com.app.routes;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.controllers.CoursesController;
import com.app.controllers.LoginController;
import com.app.model.Course;
import com.app.model.Student;
import com.app.sqlconnection.MysqlConnect;

@EnableJpaRepositories
@RestController
public class Routes {
	Connection conn;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/loginAuth")
	public ResponseEntity<Object> loginAuth(@RequestBody Student student) throws SQLException {
		conn = new MysqlConnect().connect();
		Boolean loogedIn = new LoginController(conn).login(student.getId(), student.getPassword());
		if (loogedIn) {
			// send to courses page the student 
			List<Course> studentCourses = new CoursesController(conn).getCourses(student.getId());
			return new ResponseEntity<>(studentCourses, HttpStatus.OK);
		} else {
			//maybe here throw exception
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/myProfile")
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
