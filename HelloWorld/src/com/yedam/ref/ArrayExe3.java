package com.yedam.ref;
/*
 * 배열 + 기본타입: 정수, 실수
 * 배열 + 참조타입(클래스=데이터): 학생이름, 점수 
 */
public class ArrayExe3 {
	
	static Student[] stdAry; //static 붙여야됨 , 변수 선언
	
	
	public static void main(String[] args) {
		init();
		
		int sum = 0;
		double max = 0;
//		String maxName = "";
		Student maxStd =new Student(); // 인스턴스 생성.
		
		// 배열의 값을 출력.
		for (int i = 0; i < stdAry.length; i++) {
			System.out.printf("이름:%s 점수:%d \n", stdAry[i].studentName, stdAry[i].score);
			sum += stdAry[i].score;
			
			if(max < stdAry[i].height) { //가장큰 키, 키큰학생.
				max = stdAry[i].height;
				maxStd.studentName = stdAry[i].studentName; //maxStd 에 이름값 담고
				maxStd.score = stdAry[i].score;     //maxStd에 점수값 담고 ...........
				maxStd.height = stdAry[i].height;   // maxStd에 키도 담고....
				maxStd.gender = stdAry[i].gender;   // 성별도 담고 ......
			}
		}
		double avg = 1.0 * sum / stdAry.length;
		String strFmt = "키큰학생:%s, 점수:%d, 키:.1f% 평균: %.2f";
		System.out.printf(strFmt, maxStd.studentName, maxStd.score, maxStd.height, avg);
		
	}//end of main.
	
	public static void init() {
		
		Student s1 = new Student(); // 인스턴스 생성. => 값을 담기위함
		s1.studentName = "홍길동";
		s1.score = 80;
		s1.height = 170.8;
		s1.gender = Gender.MALE;

				
		Student s2 = new Student();
		s2.studentName = "김민선";
		s2.score = 85;
		s2.height = 165.3;
		s1.gender = Gender.FEMALE;
		
		
		Student s3 = new Student();
		s3.studentName = "박철민";
		s3.score = 90;
		s3.height = 180.3;
		s1.gender = Gender.MALE;
		
		
		stdAry = new Student[] { s1, s2, s3 }; // stuAry라는 배열에 {s1,s2,s3} 값을 할당.
	}

	public static void test() {
		
		//홍길동, 80점
		int num1 = 90;
		
		// student가 데이터타입 . 변수이름은 s1
		Student s1 = new Student();  // 인스턴스 생성.(값을 담을수있는것). 인스턴스 생성 안하면 값담기가 불가능
		s1.studentName = "홍길동";
		s1.score = 80;
		
		// 김민규, 85점 => s2에 저장
		Student s2 = new Student();
		s2.studentName = "김민규";
		s2.score = 85;
		
		// 홍길동으 점수를 90으로 변경.
		s1.score = 90; 
		
		// 학생정보를 배열에 저장하겠따
		Student[] students = { s1, s2 }; // s1과 s2를 students 에 담겠다
		students[0].studentName = "홍길도"; //students[0]가 s1 = s1의 홍길동을 홍길도로 변경하겠다
		
		System.out.printf("이름: %s, 점수: %d\n", s1.studentName, s1.score);
		
		
		
		
	}
	
} // end of class
