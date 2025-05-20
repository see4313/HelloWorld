package com.yedam;
/*
 * 라이브러리 클래스.
 * 
 */
public class Student { // static이 없는 것들은 반드시 인스턴스를 생성해줘야 실행가능, 인스턴스는 studyExample 에서 생성
	// 필드는 속성을 담기위함 = 필드(속성)
	private int studentNo; // private 는 접근제어, 외부에서 접근 못하게 막음
	private String studentName;
	private double height;
	private int engScore;
	private int mathScore;
	
	// 생성자(객체:instance의 초기화) , 생성자는 설정안하면 기본생성자가 생긴다
	public Student() {
		// 매개값이 없는 생성자=> 기본생성자
		// 컴파일러가 그냥 생성해준다
		// 생성자는 없을수 없고 반드시 있다.
	}
	
	public Student(int studentNo, String studentName) { // 괄호 안이 매개값 (studentNo,Name)
		this.studentNo = studentNo;  // 척번째 매개값은 학생번호를 할당
		this.studentName = studentName;  // 두번째 매개값은 학생이름 할당
	}
	
	public Student (int studentNo, int engScore, int mathScore) {
		this.studentNo = studentNo;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}
	
	// 메소드(기능)
	void study() {  
		System.out.println("공부를 합니다.");
	}
	void introduce() {
		System.out.printf("학번은 %d 이고 이름은 %s\n", studentNo, studentName);
	}
	
	//영어, 수학 점수
	void setEngScore(int engScore) {
		if(engScore <0 || engScore > 100) {
			return;
		}
		this.engScore = engScore; // this = setEngScore
	}
	int getEngScore() {
		return engScore;
	}
	void setMathScore(int mathScore) {
		if(mathScore <0 || mathScore > 100) {
			return;
		}
		this.mathScore = mathScore;
	}
	int getMathScore() {
		return mathScore;
	}
	
	//학번, 학생이름 메소드 만들기 (setter, getter)
	void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}  // void는 반환값 없고, 기능만 있음
	
	void setStudentName(String studentName) {
		this.studentName = studentName;
	} 
	
	int getStudentNo() {
		return studentNo;
	} // 정수타입의 반환값 
	
	String getStudentName() {
		return studentName;
	}
	
	
	
	
}// end of class
