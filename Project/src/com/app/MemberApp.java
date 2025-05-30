package com.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.common.ClassDAO;
import com.common.MemberDAO;
import com.vo.Member;
import com.vo.SwimClass;

public class MemberApp {

	boolean run = true;

	public void execute() {
		Scanner scn = new Scanner(System.in);
		MemberDAO dao = new MemberDAO();
		
		ClassDAO cdao = new ClassDAO();
	
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
				System.out.println("-------------------------------------------");
				System.out.println("                    💡회원관리                 ");
				System.out.println("  1. 회원수정       2. 회원삭제       3. 회원목록   ");
				System.out.println("--------------------------------------------");
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
							if (dao.update(member2) == 1) {
								System.out.println("수정완료");
							} else {
//								System.out.println("입력한 아이디가 없습니다😊");
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
					System.out.println("-----------------------------------------");
					System.out.println("                💡 회원 정보 목록             ");
					System.out.println("-------------------------------------------");

					System.out.println("🔎조회할회원의 아이디를 입력하세요 >>");
					id = scn.nextLine();

					List<Member> list1 = dao.list(id);

					if (list1.isEmpty()) {
						System.out.println("입력한 아이디가 없습니다😊");
						break;
					}
					for (int i = 0; i < list1.size(); i++) {
						System.out.printf("아이디: %s, 이름: %s, 전화번호: %s, 생년월일: %s, 레벨: %s, 수업시간: %s\n",
								list1.get(i).getMemberId(), list1.get(i).getMemberName(), list1.get(i).getPhone(),
								list1.get(i).getMemberDate(), list1.get(i).getClassLevel(),
								list1.get(i).getClassTime());
					}
					break;

				} // end of switch(membermenu)
				break;

			case 3:
				System.out.println("------------------------------------------------");
				System.out.println("                   💡 수업 관리                    ");
				System.out.println(" 1. 수업목록    2. 수업등록   3. 수업수정   4. 수업삭제    ");
				System.out.println("-------------------------------------------------");
				System.out.println("수업관리 번호를 선택하세요>>");

				int classmenu = Integer.parseInt(scn.nextLine());

				switch (classmenu) {
				case 1:
					System.out.println("------------------------------------------");
					System.out.println("                 💡 수업 목록                 ");
					System.out.println("-------------------------------------------");
					
					System.out.println("🔎 조회할 수업의 레벨을 선택하세요");
					System.out.println("💡(초급, 중급, 고급, 마스터, 연수) 중 택 1하세요 >>");
					String level = scn.nextLine();
					
					List<SwimClass> classlist = cdao.list(level);
					
					if(classlist.isEmpty()) {
						System.out.println("입력한 레벨이 없습니다😊");
						break;
					}
					for (int i = 0; i < classlist.size(); i++) {
						System.out.printf("레벨: %s, 강사이름: %s, 수업: %s\n", 
								classlist.get(i).getClassLevel(), classlist.get(i).getTeacher(), classlist.get(i).getSubject());
					} break;
					
				case 2:
					System.out.println("------------------------------------------");
					System.out.println("                 💡 수업 등록                 ");
					System.out.println("-------------------------------------------");
					
					System.out.println("🔎 과목을 등록할 레벨을입력하세요");
					System.out.println("💡(초급, 중급, 고급, 마스터, 연수) 중 택 1하세요 >>");
					level = scn.nextLine();
					
					System.out.println("🔎 선택한 레벨의 강사이름을 입력하세요 >>");
					String teacher = scn.nextLine();
					
					System.out.println("🔎 추가할 수업을 입력하세요 >> ");
					String subject = scn.nextLine();
					
					SwimClass swimclass = new SwimClass();
					swimclass.setClassLevel(level);
					swimclass.setTeacher(teacher);
					swimclass.setSubject(subject);
					
					cdao.insert(swimclass);
					
//					SwimClass swimclass = new SwimClass(level, teacher, subject);
//					if(cdao.insert(swimclass)) {
//						
						System.out.println("수업이 등록되었습니다😊");
//					} else {
//						System.out.println("수업 등록에 실패했습니다😥");
//					}
//					
					break;
					
				case 3:
					System.out.println("------------------------------------------");
					System.out.println("                 💡 수업 수정                 ");
					System.out.println("-------------------------------------------");
					
					System.out.println("🔎 레벨을 입력하세요 >>");
					level = scn.nextLine();
					
					System.out.println("🔎 수업을 입력하세요 >>");
					subject = scn.nextLine();
					
					System.out.println("🔎 변경할 수업을 입력하세요 >>");
					String chsub = scn.nextLine();
					
					
					SwimClass swimclass1 = new SwimClass();
					swimclass1.setClassLevel(level);
					swimclass1.setSubject(subject);
					swimclass1.setChsubject(chsub);
					
					if(cdao.update(swimclass1) == 1) {
						System.out.println("수업이 변경되었습니다😊");
						break;
					} else {
						System.out.println("변경에 실패했습니다😥");
					} break;
					
				case 4:
					System.out.println("------------------------------------------");
					System.out.println("                 💡 수업 삭제                 ");
					System.out.println("-------------------------------------------");
					
					System.out.println("🔎 삭제할 레벨을 입력하세요");
					System.out.println("💡(초급, 중급, 고급, 교정, 연수, 마스터) 중 택 1하세요 >>");
					level = scn.nextLine();
					
					System.out.println("🔎 삭제할 수업을 입력하세요");
					subject = scn.nextLine();
					
					SwimClass swimclass2 = new SwimClass(subject);
					if(cdao.delete(swimclass2) != 0) {
						System.out.println("수업이 삭제되었습니다😊");
					} else {
						System.out.println("삭제 실패했습니다😊");
					} break;

				} // end of switch (classmenu)
				
				break;
			case 4: // 종료
				System.out.println("------------------------------------");
				System.out.println("     밤스아쿠아를 이용해주셔서 감사합니다💙     ");
				System.out.println("------------------------------------");
				
				run = false;
				break;
			}// end of switch (menu)
		
		} // end of while

	} // end of execute

}// end of class