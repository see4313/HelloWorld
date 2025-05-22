package com.yedam.exception;

import java.util.Scanner;


public class ExceptionExe2 {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		boolean run = true;

		while (run) {
			System.out.println("1.메뉴 2. 종료");
			System.out.println("선택>> ");

			int menu = 0;
			// 예외 걸기
			while (true) {  // 적절한 값을 입력할때 까지 계속 반복하곘다는 의미
				try {
					menu = Integer.parseInt(scn.nextLine());
				} catch (NumberFormatException e) { // 숫자를 받아야와야되는데 받은값이 숫자형식이 아니다의미 == 데이터타입이 다르다
					System.out.println("1.메뉴 2.종료");
					System.out.println("메뉴를 다시 선택하세요");
					continue; // 프로그램이 정상적으로 실행될수 있도록 continue;
				} 
					
				break;  // 정상적인 코드를 넣으면 while문 break; 의미 
				
			} // end of while
			
			
			switch (menu) {
			case 1:
				백업();
				break;
			case 2:
				break;
			default:
				System.out.println("없는 메뉴를 선택해서 종료합니다");
				run = false;

			}

		}
		System.out.println("end of prog");
		scn.close();
	}// end of main

	public static void 백업() {
		// NullPointException
		// NumberFormatException
		// ClassCastException
		// ArryIndexOutOfBoundsException

		Scanner scanner = new Scanner(System.in);
//		Resource leak: 'scanner' is never closed (사용하고있는 메모리들이 누수가 되고 있으니 유심히 봐야된다는...)

		String str = scanner.nextLine();
		try {
			System.out.println(str.toString());
			int num = Integer.parseInt("a");

			// catch 구문이 길어질수 있고 여러번 들어갈 수 있음
		} catch (NullPointerException | NumberFormatException e) {
			System.out.println("Null 값을 참조");
		} // catch (NumberFormatException e) {
//			System.out.println("포맷이 비정상");
//		}
		finally {
			// 정상실행, 예외발생 시 반드시 실행해야 할 코드는 finally에 넣음
//			scanner.close(); // 리소스를 환원

		}
		System.out.println("end of prog");

	} // end of 백업

} // end of class
