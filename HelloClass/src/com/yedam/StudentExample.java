package com.yedam;
/*
 * 실행클래스.
 */
public class StudentExample { //실행클래스
	public static void main(String[] args) {
		//한글 = 객체, 영어 = , 
		// 첫번쨰 Student =class, 두번째 student 변수, 마지막 Student 인스턴스 생성
		Student student = new Student(); 
//		student.studentNo = 1001;
		student.setStudentNo(1001);
//		student.studentName = "홍길동";
		student.setStudentName("홍길동");
//		student.engScore = 80;  // 속성값에 대입
		student.setEngScore(80);  // 메소드의 매개값. 매개값에 전달()안에 값 입력
//		student.mathScore = 85;
		student.setMathScore(85);
		student.study(); 
		student.introduce();
		
		System.out.println("이름: " + student.getStudentName()//
				+ " 영어: " + student.getEngScore()
				+ " 수학: " + student.getMathScore());
		
		Student student2 = new Student(1003, "홍삼동"); 
//		student.studentNo = 1002;  //study= 필드,studentNo= 메소드
//		student2.engScore = -50;
		student.setEngScore(-50);
//		student2.mathScore = -60;
		student.setMathScore(-60);
		student2.study(); 
		student2.introduce();
		
		student2.setStudentName("김삼동"); // 값을 바꿀때 편리
		student2.introduce();
	} //end of main
}//end of class
