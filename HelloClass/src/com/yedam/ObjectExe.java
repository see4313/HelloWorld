package com.yedam;

import java.util.Scanner;

public class ObjectExe {
	// 호출페이지
	
	public static void main(String[] args) {
		Calendar.showMonth();
		
		Scanner scn = new Scanner(System.in);
		int year = 0;

		while (true) {
			System.out.println("년도를 입력하세요");
			String msg = scn.nextLine();
			try {
				year = Integer.parseInt(msg);
			} catch (NumberFormatException e) {
				if (msg.equals("quit")) {
					System.out.println("--- 윤년계산 끝 ---");
					break;
				}
				System.out.println("년도를 숫자로 다시 입력하세요");
				continue; // 숫자를 입력할때까지 계속해서 실행하세요의미
			}
			if (!Calendar.isLeapYear(year)) {
				System.out.printf("%d년은 윤년이아닙니다", year);
			} else {
				System.out.printf("%d년은 윤년입니다", year);
			}
		} // end of while

	} // end of main

} // end of class
