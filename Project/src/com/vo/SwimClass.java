package com.vo;

public class SwimClass {
	private String classLevel;
	private String teacher;
	private String subject;
	private String chsubject;
	
	
	
	
	public SwimClass() {}
	public SwimClass(String classLevel, String teacher, String subject, String chsubject) {
		super();
		this.classLevel = classLevel;
		this.teacher = teacher;
		this.subject = subject;
		this.chsubject = chsubject;
	}
	
	public SwimClass(String subject) {
		this.subject = subject;
	}
	
	public SwimClass(String classLevel, String subject, String chsubject) {
		this.classLevel = classLevel;
		this.subject = subject;
		this.chsubject = chsubject;
		
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
	
	public String getChsubject() {
		return chsubject;
	}
	public void setChsubject(String chsubject) {
		this.chsubject = chsubject;
	}
	
	@Override
	public String toString() {
		return "SwimClass [classLevel=" + classLevel + ", teacher=" + teacher + ", subject=" + subject + ", chsubject="
				+ chsubject + "]";
	}
	
	
}
