package com.yedam.collection;

import java.util.ArrayList;
import java.util.List;

import com.yedam.api.Member;

/*
 * 인덱스를 사용해서 객체를 관리
 * 순서를 가지고 중복된 값도 반환가능
 * 리스트를 정리하는데 유용함
 * 
 */
class Student {
	private int studentNo; // 1001,1002,1003 ~ 1010
	private int score;

	public Student(int studentNo, int score) {
		this.studentNo = studentNo;
		this.score = score;
	}

	public int getScore() {
		return score;
	}

}

public class ListExe {
	public static void main(String[] args) {
		exe4();
	}// end of main

//	public static void exe3() {
//		// 10~100점 점수를 임의의 값으로 생성. 정수 10개 생성
//		// 정수담기
////		List<> numbers = new ??<>();
//
//		List<Integer> numbers = new ArrayList<>();
//
//		for (int i = 0; i <= 10; i++) {
//			int num = (int) (Math.random() * 91) + 10;
//			numbers.add()
//		}
//
//		// 10개의 점수의 합, 평균 출력ㄱㄱㄱㄱㄱ
//
//	}// end of exe3

	public static void exe4() { // exe3 교수님답
		List<Student> numbers = new ArrayList<Student>();

		for (int i = 0; i < 10; i++) {
			int num = (int) (Math.random() * 91) + 10;
			numbers.add(new Student(1000 + i, num));
		}
		
		// 10 개의 합
		int sum = 0;
		double avg = 0;
		for (int i = 0; i < numbers.size(); i++) {
			sum += numbers.get(i).getScore(); // Student(no, score)
		}
		
		avg = (sum * 1.0) / numbers.size();
		
		System.out.printf("%d, %.2f", sum, avg);
	} // end of exe4

	public static void exe2() {
		List<Member> members = new ArrayList<>();
		Member member = new Member("김홍동", 20);
		members.add(new Member("홍길동", 10));
		members.add(member);
		members.add(new Member("김홍도", 30));

		// 삭제
//		members.remove(member);  //2번째에 있는 member삭제 => member안에는 김홍동있ㅎ슴

		// 다른 삭제방법
		String search = "김홍동";
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).memberName.equals(search)) {
				members.remove(i);
			}
		}

		// 목록출력
		for (int i = 0; i < members.size(); i++) {
			System.out.println(members.get(i).toString());
		}

	}// end of exe2

	public static void exe1() {
//		int[] ary = {10, 20, 30.4};

		// 인터페이스 -구현클래스
		List<String> list = new ArrayList<String>(); // 데이터를 저장하는곳인데 아무값이나 가능
		list.add("10");
		list.add(new String("Hello"));

		// 계속 추가가능, 특정 위치지정 가능, 지우기도 가능
		// 위치 지정, 특정 위치지정
		list.add(1, "20"); // 인덱스 값기준 1번쨰니까 2번쨰에 20이 들어감

		// 삭제기능
		list.remove(0); // 인덱스값 기준 0번째니까 첫번째 숫자 지우기

		// 변경 가능
		list.set(1, "world"); // 인덱스 첫번째값에 월드로 변경

		for (int i = 0; i < list.size(); i++) { // size를 가지고와서
			System.out.println(list.get(i));

		}

		for (Object item : list) {
//			String result = (String)item;
			System.out.println(item);
		}
	}

}
