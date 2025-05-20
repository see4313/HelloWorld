package HomeworkP;

import java.util.Scanner;

public class pracetice1Exe {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("값을 입력해주세요");
  
		int plus = Integer.parseInt(scn.nextLine());
		int plus1 = Integer.parseInt(scn.nextLine());

		practice1 pract = new practice1();

		System.out.printf("두 수의 합은 %d", pract.addNum(plus, plus1));

	} // end of main

} // end of class