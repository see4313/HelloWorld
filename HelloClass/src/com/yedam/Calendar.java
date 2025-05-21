package com.yedam;

import java.util.Scanner;

public class Calendar {
	Scanner scn = new Scanner(System.in);
	
	public static void showMonth() { 
		//Sun Mon Tue Wen Thu Fri Sat
		//===================================
		//                 1    2   3
		// 4   5   6   7   8    9   10
//		System.out.println(" Sun  Mon  Tue  Wen  Thu  Fri  Sat ");
//		System.out.println(" =====================================");
//		System.out.println("  1    2    3    4    5    6    7");
//		System.out.println("  8    9    10   11   12   13    14");
//		System.out.println("  15   16   17   18   19  20    21");
//		System.out.println("  22   23   24   25   26  27    28");
//		System.out.println("  29   30");
		
		int mon = 5;
		System.out.printf("%d", mon);
		System.out.println(" Sun  Mon  Tue  Wen  Thu  Fri  Sat ");
		System.out.println(" =====================================");
		int space = 4;
		int lastDate = 31;
		
		for (int i = 0; i < space; i++) {
			System.out.printf("%4s", " ");
		}
		for (int i = 1; i < lastDate; i++) {
			System.out.printf("%4d", i);
			if ((i + space) % 7 == 0) {
				System.out.println();
			}
		}
	} // 
}//end of class
