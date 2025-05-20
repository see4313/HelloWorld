package com.yedam;

import com.yedam.member.Member;

/*
 * 메소드 연습
 * 1) 메소드의 선언
 * 2) 매개변수
 * 3) 반환유형
 */

public class Calculator {
	// 필드
	// 생성자
	// 메소드

	// 메소드 선언 (void= 반환을 안하겠다)
	String printStar(int times, String shape) { // 매개변수(times, shape) 선언, 매개변수 필요한만큼 사용
		String str = " ";
		for (int i = 1; i <= times; i++) {
//			System.out.println(shape);
			str += shape + "\n";
			
		}
		return str;	
	} // end of printStar
	
	//메소드 오버로딩. (똑같은 이름의 메소드를 여러번 중복해서 사용함, 똑같은 타입은 의미x, 타입을 달리하거나 갯수를 다르게 하거나)
	int add(int num1, int num2) {
		return num1 + num2;
	}
	
	double add(double num1, double num2) {
		return num1 + num2;
	}
	//정수배열을 매개값으로 받는 add, 반환유형은 double
	
	
	double add(int[] num) {
		int result = 0;
		
		for (int i = 0; i < num.length; i++) {
			result += num[i];
		}
		return result; 
	}
	
	// 배열 값 중에서 point가 젤 큰사람을 찾아서 반환
	Member getMaxPoint(Member[] memberAry) {
		//결과값.
		Member max = null; // 아이디, 이름, 연락처, 포인트  
		int maxPoint = 0; // 배열 요소의 포인트를 비교하기 위한 변수.
		
		for (int i = 0; i < memberAry.length; i++) {
			if(maxPoint < memberAry[i].getPoint()) {
				maxPoint = memberAry[i].getPoint(); // 최대값을 구하기위한 반복문
				max = memberAry[i]; // 찾는것은 포인트지만 불러오는건 전체목록을 다 불러옴 그래서 getpoint가 아님
				//max 에 최대포인트를 가진 회원의 정보를 저장.
			}
		}
		return max; // 위에서 나온 결과값인 max를 출력하겠다 의미ㅣ  
	}//end of getMaxPoint
	
	// 전체 포인트의 평균을 구하세요
	int getAvgPoint(Member[] memberAry1) {
		int sumPoint = 0; 
		int avgPoint = 0;
		for (int i = 0; i < memberAry1.length; i++) {
			sumPoint += memberAry1[i].getPoint();
		} avgPoint = sumPoint / memberAry1.length; 
			return avgPoint; 
	}
	
} // end of class
