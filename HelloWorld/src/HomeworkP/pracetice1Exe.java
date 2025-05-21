package HomeworkP;

import java.util.Scanner;

public class pracetice1Exe {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
//
//		System.out.println("값을 입력해주세요");
//  
//		int plus = Integer.parseInt(scn.nextLine());
//		int plus1 = Integer.parseInt(scn.nextLine());
//
		practice1 pract = new practice1(); // 인스턴스 생성
//	
//		System.out.printf("두 수의 합은 %d", pract.addNum(plus, plus1));

//		 System.out.println(pract.str("안녕", " 하세요"));
		
		System.out.println("값을 두개 입력해주세요");
		int no1 = Integer.parseInt(scn.nextLine());
		int no2 = Integer.parseInt(scn.nextLine());
		System.out.printf("최대값은 %d", pract.max(no1, no2)); 
	} // end of main

} // end of class