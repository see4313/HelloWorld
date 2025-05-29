package com.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.common.MemberDAO;
import com.vo.Member;

public class MemberApp {

	boolean run = true;

	public void execute() {
		Scanner scn = new Scanner(System.in);
		MemberDAO dao = new MemberDAO();
		List<Member> list = new ArrayList<>();
		
		while (run) {
			System.out.println("=============================================");
			System.out.println("================🏊‍밤스 아쿠아 🏊‍================");
			System.out.println("=============================================");
			System.out.println(" 1.회원가입 2.회원관리 3.수업관리 4.종료 ");
			System.out.println(" 메뉴를 선택하세요>>");

			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				System.out.println("아이디를 입력하세요>>");
				String id = scn.nextLine();

				System.out.println("이름을 입력하세요>>");
				String name = scn.nextLine();

				System.out.println("전화번호를 입력하세요>>");
				String phone = scn.nextLine();

				System.out.println("생년월일 6자리로 입력하세요>>");
				String date = scn.nextLine();

				Member member = new Member(id, name, phone, date);
				dao.insert(member);
				System.out.println("성공적으로 등록되었습니다😊");

				break;

			case 2: // 회원관리
				System.out.println("-------------------------------------");
				System.out.println("               💡회원관리               ");
				System.out.println(" 1. 회원수정    2. 회원삭제     3. 회원목록  ");
				System.out.println("--------------------------------------");
				System.out.println("메뉴를 선택하세요>>");

				int membermenu = Integer.parseInt(scn.nextLine());

				switch (membermenu) {
				case 1:
					System.out.println("--------------------------------------");
					System.out.println("             💡 회원 정보 수정             ");
					System.out.println("---------------------------------------");

					System.out.println("🔎수정할회원의 아이디를 입력하세요 >>");
					id = scn.nextLine();

					list = dao.select();


					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getMemberId().equals(id)) {
							System.out.println("🔎변경할 이름을 입력하세요 >>");
							name = scn.nextLine();

							System.out.println("🔎변경할 전화번호를 입력하세요 >>");
							phone = scn.nextLine();
							
							System.out.println("🔎변경할 레벨을 입력하세요 >>");
							String level = scn.nextLine();
							
							System.out.println("🔎변경할 수업시간을 입력하세요 >>");
							String time = scn.nextLine();

							Member member2 = new Member(id, name, phone, level, time);
							if (MemberDAO.update(member2) == 1) {
								System.out.println("수정완료");
							}
						}
					} // end of for
					break;
				case 2:
					System.out.println("--------------------------------------");
					System.out.println("             💡 회원 정보 삭제             ");
					System.out.println("---------------------------------------");

					System.out.println("🔎삭제할회원의 아이디를 입력하세요 >>");
					id = scn.nextLine();

					Member dmember = new Member(id);
					if (dao.delete(dmember) != 0) {
						System.out.println("삭제 되었습니다😊");
					} else {
						System.out.println("삭제 실패했습니다😊");
					}
					break;

				case 3: // 회원목록보기
					System.out.println("--------------------------------------");
					System.out.println("             💡 회원 정보 목록             ");
					System.out.println("---------------------------------------");

					System.out.println("🔎조회할회원의 아이디를 입력하세요 >>");
					id = scn.nextLine();
					
					List<Member> list1 = dao.list(id);
					
					if(list1.isEmpty()) {
						System.out.println("입력한 아이디가 없습니다😊");
						break;
					}
					for (int i = 0; i < list1.size(); i++) {
							System.out.printf("아이디: %s, 이름: %s, 전화번호: %s, 생년월일: %s, 레벨: %s, 수업시간: %s\n", 
									list1.get(i).getMemberId(), list1.get(i).getMemberName(),list1.get(i).getPhone(), list1.get(i).getMemberDate(),list1.get(i).getClassLevel(),list1.get(i).getClassTime());	
					}
					break;

				} // end of switch(membermenu)
				break;
			}// end of (switchmenu)
		} // end of while
	} // end of execute

}// end of class