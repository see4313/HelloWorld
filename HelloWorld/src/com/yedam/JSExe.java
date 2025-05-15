package com.yedam;

import java.util.Scanner;

public class JSExe {

	public static void main(String[] args) {
		int num1 = 20;
		int num2 = 20;
//		System.out.println(num1 == num2);

		String str1 = new String("Hello");
		String str2 = new String("Hello");
//		System.out.println(str1);
//		System.out.println(str2);

		// "30" 과 30
		String str3 = "30";
		int num3 = 30;

//		System.out.println(str3.equals("" + num3)); // ""문자열이라는 의미
		int num4 = Integer.parseInt(str3); // 문자열숫자를 정수타입으로 변경해주는 것(interger)
//		System.out.println(num3 == num4); // 문자열숫자와 숫자를 비교할때. "30" => 30
		// 문자값을 비교할땐 메소드(equals) 사용 메소드 사용 안하면 결과값이 false가 나옴

//		System.out.println(str1.equals(str2)); // 1과 2 비교연산자(==)사용하면 => false

		// test();
		// test2();
		// test3(); // 평균을 구하기(소수점까지 출력
//		 test4();
		 test5();
	}// and of main
	
	
	
	
	public static void test5() {
		//printf("형식문자열", 값1, 값2...)\
		System.out.printf("%s %d\n", "문자", 30); // \n 은 줄바꿈
		System.out.println("문자");
		
		//"홍길동", 100, 23.9 을 출력
		System.out.printf("%s %d %.1f", "홍길동", 100, 23.9);  //%.1에서 뒤의 숫자는 소숫점 뒤의 자리수를 의미한다(두자지를 원하면 %.2f)
		// %s "문자열", %d 정수, %.nf 실수 
		// \n 줄바꿈
		
		//안녕하세요. 이름은 손이영입니다.
		//나이는 28세입니다.
		//몸무게는 50.4입니다.
		System.out.printf(" \n 안녕하세요. 이름은 %s 입니다 \n 나이는 %d 세입니다 \n몸무게는 %.1f 입니다 ", "손이영", 28, 50.4 );
	}

	public static void test4() {

		Scanner scn = new Scanner(System.in);
		String str = "";
		while (true) {
			System.out.println("친구이름 입력. 종료하려면 quit>");
			String msg = scn.nextLine();
			
			// equals(문자값을 비교)로 비교.
			if (msg.equals("quit")) {
				str += " 입니다";  // += 의미는 누적하겠다
				break;
			}
			else if(str.equals("")) {
				str+=msg;
			}
			else {
				str += ", " + msg;
			}//친구 목록에서 맨 뒤의 ,는 없애기위해 조건문 추가
//			System.out.println("친구 목록은 " + msg);
//			str +=  msg + (", ") ;
		}
		// 홍길동, 김민규, 최석영 입력 => 친구 목록은 홍,김,최 입니다. 출력되게 입력 
		System.out.println("친구목록은" + str);
		System.out.println("end of prog.");
	} // end of test4

	public static void test3() {
		// 사용자의 입력값을 읽어들이기
		Scanner scn = new Scanner(System.in); // (system.in)은 키보드를의미,키보드의값을통해 외부 파일을 스캔해줌, system.out=모니터로 내보내주는것
		int sum = 0;
		for (int i = 1; i <= 3; i++) {
//			System.out.println("학생의 점수를 입력>>");
			String value = scn.nextLine(); // 입력값을 문자열형태로 반환해줌
			int score = Integer.parseInt(value);
			sum += score;
		}

		double avg = sum / 3.0; // avg는 반올림 의미 //3으로 나눈다
		avg = Math.round(avg * 100) / 100.0;
//		System.out.println("평균: " + sum + ",평균: " + avg);

	} // end of test3

	public static void test2() {

		// 임의의 수를 생성해주는 mathrandom.

		// 30~100 사이의 임의의 값 생성.
		// 평균: 173/5 => 34.6
		int sum = 0;
		for (int i = 1; i <= 3; i++) {
			int result = (int) (Math.random() * 71) + 30; // 30 <= x < 101
//			System.out.println();
			sum += result;
		}
		double avg = sum / 3.0; // avg는 반올림 의미 //3으로 나눈다
		avg = Math.round(avg * 100) / 100.0;
//		System.out.println("평균: " + sum + ",평균: " + avg);

		// System.out.println(Math.round(23.678*100)/100.0);

	} // end of test2

	public static void test() {
		int sum = 0;
		// 1 ~ 10 까지의 누적하는 반문
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1) {
				sum += i;
			}
		}
//		System.out.println("결과: " + sum);
	}  //end of test1
	

} // end of class
