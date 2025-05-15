package com.yedam.condition;

import java.util.Scanner;

public class LoopExe {

	// "가위(1)","바위(2)","보(3)"
	// 1,2,3의 값 <==> 가위(1), 바위(2), 보(3), 종료(4) 라고 생각하고 값입력
	// "You lost", "You win", "Same"
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int randomValue = (int) (Math.random() * 3) + 1;  //시스템이 낸 값
//		System.out.println(randomValue);
		while (true) {
			System.err.println("입력하세요");
			int num = Integer.parseInt(scn.nextLine());  //내가 입력하는 값

			if (randomValue == num) {
				System.out.println("Same");
				continue; // 아래 코드를 실행하지 않고 반복문의 처음으로.
			} else if (num == 1) {
				if (randomValue == 2) {
					System.out.println("You win");
				} else if (randomValue == 3) {
					System.out.println("You lost");
				}
			} else if (num == 2) {
				if (randomValue == 1) {
					System.out.println("You lost");
				} else if (randomValue == 3) {
					System.out.println("You win");
				}
			} else if (num == 3) {
				if (randomValue == 1) {
					System.out.println("You win");
				} else if (randomValue == 2) {
					System.out.println("You lost");
				}
			} 
			else if(num ==4) {
			System.out.println("종료");
			break;
		}
		} // end of while

	} // end of main

	public static void test() {
		// while vs. do.. while
		boolean run = false;

//		while(run = !run) {
//			System.out.println("while문");
//		} //조건맞으면 실행됨

		// 블럭안에 있는걸 반드시 실행하고 싶으면 DO WHILE 실행
		do {
			System.out.println("while문"); // 먼저 실행하고
		} while (run = !run); // 조건 걸린다

		System.out.println("end of prog");

	} // end of test
}// end of class
