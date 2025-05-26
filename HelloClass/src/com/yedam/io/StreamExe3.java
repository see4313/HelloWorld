package com.yedam.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.yedam.collection.Student;

/*
 * 학생정보(추가, 수정, 삭제, 목록, 종료) - c:/ temp/ studentList.txt 
 * add (추가: 학생번호, 점수입력)
 * modify(수정: 이름, 점수수정)
 * remove(삭제: 이름 입력하면 삭제)
 * list(목록)
 * 종료 시 외부파일에 저장.
 */
public class StreamExe3 {

	static Scanner scn = new Scanner(System.in); // 정적필드. //static 정적 메소드 안에서 사용해야해서 static
	static List<Student> studentList = new ArrayList<>();

	public static void main(String[] args) {

		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			// 파일의 끝부분에서 더이상 읽을 값이 없음.

		}

		boolean run = true;

		while (run) {
			System.out.println("1.추가 2.수정 3.삭제 4.목록 5.종료");
			System.out.println("선택 >>");
			int menu = Integer.parseInt(scn.nextLine());// 사용자가 입력한 값을 담을 변수 menu
			// 조건문
			switch (menu) {
			case 1: // 추가
				add();
				break;
				
			case 2:
				modify();
				break;
				
			case 3:
				remove();
				break;
				
			case 4:
				list();
				break;

			case 5: // 종료
				run = false;
				save();
			}

		} // end of while
		System.out.println("end of prog");

	}// end of main

	static void add() {
		System.out.println("학생번호: ");
		String sno = scn.nextLine();

		System.out.println("점수: ");
		String score = scn.nextLine();

		Student student = new Student(Integer.parseInt(sno), Integer.parseInt(score));
		if (studentList.add(student)) {
			System.out.println("저장완료");
		}
	} // end of add.

	static void modify() {
		System.out.println("학생번호: ");
		int sno = scn.nextInt();

		System.out.println("점수: ");
		int score = scn.nextInt(); // 50 엔터
		scn.nextLine();

		// 컬렉션에서 검색
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getStudentNo() == sno) {
				studentList.get(i).setScore(score);
				System.out.println("수정완료");
			}
		}

	} // end of modify.
	
	//삭제
	static void remove() {
		System.out.println("학생번호: ");
		int sno = scn.nextInt();
		scn.nextLine(); // 엔터처리
		
		for (int i = 0; i < studentList.size(); i++) {
			if(studentList.get(i).getStudentNo() == sno) {
				studentList.remove(i);
				System.out.println("삭제완료");
			}
		}
		
	}//  end of remove

	// 추가
	static void save() {
		// 문자기반의 출력스트림을 생성
		try {
			Writer writer = new FileWriter("c:/temp/studentList.txt");
			// 학생번호 1001 점수가 70
			// 컴파일 students
			for (Student student : studentList) { // 스슈던트 리스트컬렉션에 들어있는 만큼만 반복하겠다의미
				String txt = student.getStudentNo() + " " + student.getScore() + "\n";
				writer.write(txt); // writer메소드 출력

			}
			writer.close(); // 다 작업하면 닫기
			// 메소드들은 반드시 close 해줘야됨

		} catch (IOException e) {
			e.printStackTrace();
		}

	} // end of save
	
	// 목록
	static void list() {
		for (int i = 0; i < studentList.size(); i++) {
			System.out.printf("번호: %d, 점수: %d\n", studentList.get(i).getStudentNo(), studentList.get(i).getScore());
			
		}
		System.out.println("");
	} // end of list

	// 초기화
	static void init() throws IOException, NoSuchElementException { // throws 예외발생하면 떠넘기겠다..
		Scanner scan = new Scanner(new File("c:/temp/studentList.txt"));

		while (true) {
			String txt = scan.nextLine(); // 한라인 읽겠다 (학생번호와 점수가 한 라인)
			String[] strAry = txt.split(" "); // 1001 70 앞에 번호와 뒤에 점수를 배열에 담아줌
			// studentList컬렉션에 계속 추가 . strAry[0] == 첫ㅂ번째값
			studentList.add(new Student(Integer.parseInt(strAry[0])//
					, Integer.parseInt(strAry[1]))//
			);
		} // end of while

	} // end of init

} // end of class

