package com.vo;

public class SwimClass {
	private String classLevel;
	private String teacher;
	private String subject;
	
	
	
	
	public SwimClass() {}
	public SwimClass(String classLevel, String teacher, String subject) {
		super();
		this.classLevel = classLevel;
		this.teacher = teacher;
		this.subject = subject;
	}
	
	
	
	
	public String getClassLevel() {
		return classLevel;
	}
	public void setClassLevel(String classLevel) {
		this.classLevel = classLevel;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	
	
}
