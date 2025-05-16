package com.yedam.ref;

import java.util.Scanner;

public class ArrayExe {
	public static void main(String[] args) {
		friendApp();
	}

	public static void friendApp() {
		Scanner scn = new Scanner(System.in);
		// 배열선언
		String[] friendApp = new String[10];

		boolean run = true;
		while (run) {
			System.out.println("1.추가 2.목록 3.삭제 4.종료");
			System.out.println("선택>>");
			// 메뉴선택
			int menu = Integer.parseInt(scn.nextLine());
			//
			switch (menu) {
			case 1: // 추가.
				System.out.println("이름을 입력하세요>>");
				String name = scn.nextLine();
				
				// 배열에 추가.
				for (int i = 0; i < friendApp.length; i++) {
					if (friendApp[i] == null) {
						friendApp[i] = name;
						
						// 동일한 이름이 있는지 확인하고 "추가하시겠습니까?" 확인 후 추가(1), 취소(2)
						if(name==friendApp[i]) {
							System.out.println("추가하시겠습니까?");
						} else if(friendApp[i] == null ) {
							System.out.println("추가(1), 취소(2)");
						}
					}
					break;
					
					}break; //case에 대해서도 break해줘야 한번만이름입력하라고 뜸
				
			case 2: // 목록

				for (int i = 0; i < friendApp.length; i++) {
					if (friendApp[i] != null) {
						System.out.printf("이름: %s\n", friendApp[i]);
					}
				}break;
				
			case 3: // 삭제
				
				System.out.println("이름을 입력하세요>>");
				String name1 = scn.nextLine();
				
				
				for (int i = 0; i < friendApp.length; i++) {
					if (friendApp[i] != null && friendApp[i].equals(name1)) {
						friendApp[i] = null; // 삭제
					}
					//삭제시 찾는 이름이 없을 경우 "찾는이름이 없습니다"
					else if(name1 != null) {
						System.out.println("찾는 이름이 없습니다");
						break;
					}
					
				} break;
				
			case 4: // 종료
			run = false;
			System.out.println("종료");
				
				
			
		}// end of switch
		} // end of while
	System.out.println("end of prog");

	} // end of friendApp

	// 문자열배열.
	public static void strAry() {
		Scanner scn = new Scanner(System.in);

		// 배열선언. (배열은 대체적으로 값을 저장하기위해 사용)
		String[] stringAry = new String[10]; // 입력값을 저장. ==> 10개를 지정하면 초기값이 null값으로 입력된다
		while (true) {
			System.out.println("이름을 입력>>");
			String name = scn.nextLine();
			if (name.equals("quit")) {
				break; // while문 종료
			} // quit를 안하며 밑에 반복문으로 내려가서 반복한다

			for (int i = 0; i < stringAry.length; i++) {
				if (stringAry[i] == null) { // 빈공간(null)이 있는지 확인하고
					stringAry[i] = name; // 이름적어서 추가
					System.out.println("입력성공.");
					break; // 한건만 입력하고 break 안하면 10개가 다 똑같은걸로 채워짐
				}

			} // end of for.
		} // end of while

		// 입력값 출력
		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null) {
				System.out.printf("dblAry[%d]번째의 값: %s\n", i, stringAry[i]);
			}
		}
		System.out.println("end of prog"); // 위에 while문을 종료해줘야 에러 안뜸
	}

	// 목록 삭제
	public static void deleteAry() {
		Scanner scn = new Scanner(System.in);
		// 배열선언.
		String[] stringAry = new String[10];
		stringAry[0] = "홍길동";
		stringAry[1] = "김친구";
		stringAry[2] = "김태완";
		stringAry[3] = "홍왕구";

		System.out.println("삭제할 친구 이름>>");
		String name = scn.nextLine();

		// 삭제할 친구 이름.
		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null && stringAry[i].equals(name)) {
				stringAry[i] = null; // 삭제
			}
		}
		// 입력값 출력.
		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null) {
				System.out.printf("dblAry[%d]번째의 값: %s\n", i, stringAry[i]);
			}
		}

	}// and of main

} // end of class
