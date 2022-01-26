package com.app.controllers;

import java.sql.Connection;
import java.util.List;

import com.app.model.Course;

public class CoursesController {
	Connection conn;
	public CoursesController(Connection conn) {
		this.conn = conn ;
	}
	
	public List<Course> getCourses(int id) {
		
		return null;
	}

}
