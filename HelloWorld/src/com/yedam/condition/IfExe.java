package com.yedam.condition;

import java.util.Scanner;

public class IfExe {
	
	public static void main(String[] args) {
		//1~1000 사이의 임의의 값을 생성. 임의의 값 (randomValue = 567)
		//500입력하면 "입력값보다 큽니다", "입력값보다 작습니다"
		//"정답입니다" 뜨면 프로그램 종료.
		// 시도한 회수 넣기.
		Scanner scn = new Scanner(System.in);
		int randomValue = (int)(Math.random() * 1000) + 1;
//		System.out.println(randomValue);
		int count =0;
		while(true) {
			System.out.print("숫자를 입력하세요:");
			int num = Integer.parseInt(scn.nextLine());
		 if(randomValue > num) {
			System.out.println("입력값보다 큽니다");
			count++;
		} else if(randomValue < num) {
			System.out.println("이력값보다 작습니다");
			count++;
		}else if(randomValue== num){
			count++;
			System.out.printf("정답입니다%d 번만에 맞췄습니다. ", count );
			break;
		}
		
		
		} // emd of while
	}  //end of main
	
		
	public static void test() {
		int score = 87;

		// if. if조건 외에 나머지는 else
//		if (score >= 90) {
//			System.out.println("A학점");
//		} else if (score >= 80) {
//			System.out.println("B학점");
//		} else if (score >= 70) {
//			System.out.println("C학점");
//		} else {
//			System.out.println("불합격");
//		}// end of if

		
		//switch 
		score = score / 10;  //9
		switch(score ) {
		case 10:
		case 9:
			System.out.println("A학점");
			break;
		case 8:
			System.out.println("B학점");
			break;
		case 7:
			System.out.println("C학점");
			break;
		default:
			System.out.println("불합격");
			break;
		}// end of switch
		
		
		
		
		
	} // and of test
} // end of class
