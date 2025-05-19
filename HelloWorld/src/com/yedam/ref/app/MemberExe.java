package com.yedam.ref.app;

import java.util.Scanner;

/*
 * 회원추가, 수정,삭제, 조회기능.
 * 1)추가
 *  - 아이디, 이름, 전화번호, 포인트
 *  2)수정
 *   - 아이디
 *   - 전화번호(바뀔항목)
 *   3)삭제
 *    - 삭제할 아이디를 넣고 "찾는아이디가 없습니다"
 *    4)조회
 *     - 이름(조회) */
public class MemberExe {

	public static void main(String[] args) {

		boolean run = true;


		Scanner scanner = new Scanner(System.in);
		
		Member[] members = new Member[100]; 

		while (run) {
			System.out.println("1.회원추가 2. 수정 3. 삭제 4. 조회 5. 종료");
			System.out.println("입력>> ");

			int selectNo = Integer.parseInt(scanner.nextLine());
			if (selectNo == 2 || selectNo == 3 || selectNo == 4) {
				if (members == null) { // 회원정보가 null 일때 처음으로 돌아감
					System.out.println("회원정보를 입력하세요");
					continue;
				}
			}
			
			if (selectNo == 1) { // 아이디, 이름, 전화번호, 포인트 입력

				System.out.println("아이디를 입력하세요");
				String id = scanner.nextLine();
								
				System.out.println("이름 입력하세요");
				String name = scanner.nextLine();
				
				System.out.println("전화번호를 입력하세요");
				String phone = scanner.nextLine();
				
				System.out.println("포인트를 입력하세요");
				int point = Integer.parseInt(scanner.nextLine());
				
				// 배열 담기, 값을 담을 하나의 변수를 m으로 지정
				Member m = new Member();
				m.id = id;
				m.name = name;
				m.phone = phone;
				m.point = point;
				
				for (int i = 0; i < members.length; i++) { // idNum 크기만큼 반복
					if (members[i] == null) {
						members[i] = m; //  지금 조건이 없으면 덮어씌워짐,,
						break;						
					}
				} // end of for.

			} else if (selectNo == 2) { // 수정 => 아이디, 전화번호 변경
				System.out.println("수정할 아이디를 입력하세요.");
				String name1 = scanner.nextLine();

				for (int i = 0; i < members.length; i++) {
//					System.out.println("abcd");
					if (members[i].id.equals(name1)) {
						System.out.println("전화번호를 입력하세요");
						String phone2 = scanner.nextLine();
						members[i].phone = phone2;
						break;
					}
				}

			} else if (selectNo == 3) { // 아이디 입력했을 때 삭제
				System.out.println("아이디를 입력하면 삭제됩니다.");
				String delete = scanner.nextLine();

				for (int i = 0; i < members.length; i++) {
					if (members[i].id.equals(delete)) {
						members[i].id = null;
						break;
					}
				}
			} else if (selectNo == 4) { // 이름 입력했을 때 조회
				System.out.println("이름을 입력해주세요");
				String name2 = scanner.nextLine();
				
				for (int i = 0; i < members.length; i++) {
					if (members[i] != null && members[i].name.equals(name2)) {
						System.out.printf("아이디: %s, 이름: %s, 전화번호: %s, 포인트: %d\n", members[i].id, members[i].name, members[i].phone,members[i].point );
						break;
					}
				}
			} else if (selectNo == 5) {
				run = false;
				break;
			}

		} // end of while

	}// end of main

} // end of class.
