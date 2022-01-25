package com.app.model;

import java.util.Date;

public class Course {

	String courseId;
	int year;
	String courseName;
	Date startDate;
	Date finalDate;
	
	public Course() {}
	public Course(String courseId, int year, String courseName, Date startDate, Date finalDate) {
		super();
		this.courseId = courseId;
		this.year = year;
		this.courseName = courseName;
		this.startDate = startDate;
		this.finalDate = finalDate;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}
}
