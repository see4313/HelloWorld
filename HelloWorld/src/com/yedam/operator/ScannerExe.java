package com.yedam.operator;

import java.util.Scanner;

public class ScannerExe {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		//while문 ( 값을 저장하고 빼는 기능)
		int balance = 0;  //계좌의 금액.
		int money = 0;  // 추가로 변경되는 금액
		//조건추가.. 10만원을 초과(x), 마이너스금액(x)
		while (true) {
			System.out.println("1.입급 2.출금 3.잔액 4.종료");
			int menu = Integer.parseInt(scn.nextLine());// Integer.parseInt("30"); 정수 30으로 바꿔주는 기능
			
			if (menu == 1) {
				System.out.print("입금액을 입력하세요.");
				money = Integer.parseInt(scn.nextLine());
				if(balance+money > 100000) {
					System.out.println("100000원 이상 초과되었습니다.");
				} else {
					balance += money; // 기본값에서 돈을 더한금액이 누적되서 출력하겠다
				}
				//입금기능구현.			
			} else if (menu == 2) {
				System.out.println("출금액을 입력하세요.");
				//출금기능구현
				if(balance < money) {
					System.out.println("잔액부족");
				} else {
					balance -= money; //기본값에서 돈을 뺀금액이 누적되서 출력하겠다
				}
			} else if (menu == 3) {
				System.out.println("잔액을 확인하세요." + balance);
				
			} 
			else if (menu == 4) {
				System.out.print("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("1~4번중에 선택하세요.");
			}
		} // end of while
		System.out.println("end of prog");
	}
}// end of class
