package com.yedam.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
 * Map컬렉션
 * {키 : 값}추가
 * 키와 값에 들어가는 값을 선언해줘야됨
 */

//학생정보 (이름, 점수)
class Student2 {
	private String studentName;
	private int score;

	// 생성자
	public Student2(String studentName, int score) {
		this.studentName = studentName;
		this.score = score;
	}

	// hashcode 와 equals메소드 => 이름, 객체같으면 동등객체
	@Override
	public int hashCode() {
		return score;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student2) { // obj 와 student2와 타입맞는지

			// 타입 맞으면 casting 해주는 것 ( casting은 행변환)
			Student2 std = (Student2) obj;
			return this.studentName.equals(std.getStudentName())//
					&& this.score == std.getScore();

		}
		return false;
	}

	// getter
	public String getStudentName() {
		return studentName;
	}

	public int getScore() {
		return score;
	}

} // end of class Student2

public class MapExe {
	public static void main(String[] args) {
		// 학생, n 반
		Map<Student2, String> map;
		map = new HashMap<Student2, String>();

		// 추가
		map.put(new Student2("홍길동", 70), "1반");
		map.put(new Student2("김민규", 80), "2반");

		map.put(new Student2("박철승", 95), "1반");
		map.put(new Student2("아리동", 98), "2반");

		// 반복문( 값을 찾기 위해)
		String keyword = "홍길동";
		int score = 70;
		
		// 객체를 비교연산자(==) 로 비교할경우 false;
		System.out.println(new Student2(keyword, score) == new Student2(keyword, score));  // 다른 두개의 주소값을 비교하면 false 나옴
		
		if(map.containsKey(new Student2(keyword, score))) {  //new~ 다른 주소값을 가진 값들이 생성 
			System.out.println("반:" //
					+ map.get(new Student2(keyword, score)));  //논리적으로느 같은 값이라고 key에 담았지만 동등한 객체로 보는게 hashcode와 equals.
		}
		
		
		
		
		
//		Set<Student2> set = map.keySet();
//		
//		// for문도 사용 가능
////		for(Student2 std : set) { // set컬렉션안에 있는 값만큼 반복
////		}
//		
//
//		Iterator<Student2> iter = set.iterator();
//
//		while (iter.hasNext()) {
//			Student2 std = iter.next(); // 한건 가지고 오겠다의미 !가지고 올 순서는 알수가 없다!
//			if (std.getStudentName().equals(keyword)) { // 키워드와 이름이 같은지
////				System.out.println("점수: " + std.getScore()); // 여기까지 사람의 이름과 score을 알수 있음
//
//				// 이름, score
//				String cls = map.get(std);
//				System.out.printf("이름: %s, 점수: %d, 반: %s\n", // 이어서
//						std.getStudentName(), std.getScore(), cls);
//			}
//
//		} // end of while

	} // end of main
	
	
	public static void exe2() {
		// Map <String, String> = 키도 값도 다 String타입
		Map<String, String> map;
		map = new HashMap<String, String>();

		map.put("user01", "1111");
		map.put("user02", "2222");
		map.put("user03", "3333");

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("아이디를 입력>> ");
			String id = scanner.nextLine();
			System.out.println("비밀번호 입력>> ");
			String pw = scanner.nextLine();

			if (map.containsKey(id)) { // containsKey = key 값이 true인지 false인지 확인(= id값 있는지 확인하는것)
				// 키가 존재 => 비밀번호 체크
				if (map.get(id).equals(pw)) {
					System.out.println("로그인되었습니다.");
					break;
				}
				System.out.println("비밀번호가 일치하지 않습니다.");

			} else {
				System.out.println("입력하신 아이디가 없습니다.");
			}
		} // end of while

		// 자바객체 (map) => Json문자열 출력.
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(map);
		System.out.println(json);
	}

	public static void exe() {

		Map<String, Integer> map = new HashMap<String, Integer>();
		// 키는 String 타입의 값은 Integer로 받겠다

		// 추가(put)
		map.put("홍길동", 80);
		map.put("김민수", 70);
		map.put("홍길동", 85); // 동일한 키값을 넣어주면 나중값으로 변경됨(덮어씌워짐)
		map.put("박철민", 90);

		// 자바객체(map) => JSON 문자열 출력.
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(map);
		System.out.println(json);

		// 삭제 (remove)
		map.remove("홍길동");

		// 조회(키 -> 값)
		Integer score = map.get("김민수");
		score = map.get("홍길동");
		System.out.println(score); // 추가에서 85가 나중에 입력되서 80점이 아닌 85점이 출력됨

		// 반복
		Set<String> keyset = map.keySet(); // 키를 Set에 반환.

		// 반복자
		Iterator<String> iter = keyset.iterator(); // 반복자 생성
		while (iter.hasNext()) {
			String key = iter.next(); // 반복요소 획득 //키를 알면 value를 가져올수 있음
			Integer value = map.get(key);
			System.out.printf("키: %s, 값: %d\n", key, value);
		}

		// 키{키 : 값} 반환 = map.entry 타입
		Set<Entry<String, Integer>> entryset = map.entrySet();
		Iterator<Entry<String, Integer>> iter2 = entryset.iterator();

		while (iter2.hasNext()) { // 반복되는지 학인하기 위해 hasNext()
			Entry<String, Integer> entry = iter2.next();
			System.out.printf("키: %s, 값: %d\n", entry.getKey(), entry.getValue());
		}
	} // end of exe

} // end of class

// maven repository 사용