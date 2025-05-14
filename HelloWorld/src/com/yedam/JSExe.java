package com.yedam;

public class JSExe {
	public static void main(String[] args) {
		test2();
	}// and of main

	public static void test2() {
		// 임의의 수를 생성해주는 mathrandom.
		// 1~100 사시의 임의의 값 생성.
		int sum = 0;
		for (int i = 1; i <= 5; i++) {
			int reuslt = (int) (Math.random() * 100) + 1; // 1 <= x < 11
			sum += reuslt;
		}
		System.out.println("결과: " + sum);
	} // end of test2

	public static void test() {
		int sum = 0;
		// 1 ~ 10 까지의 누적하는 반문
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1) {
				sum += i;
			}
		}
		System.out.println("결과: " + sum);
	}
} // end of class
