package com.yedam.api;

import java.util.HashSet;
import java.util.Set;

public class ObjectExe {
	public static void main(String[] args) {
		// 배열 [여러건 저장] => 컬렉션(1. List컬렉션 2. Set 컬렉션(아무값이나 받아줄수 있고 중복된는 값은 받지 않음) 2.
		// Map컬렉션
		int[] ary = new int[5];
		// 확장된 for.
		for (int num : ary) { // () = ary배열에 들어있는만큼만 반복하겠다 의미
			System.out.println(num);
		}

		// Set컬렉션은 저장순서와 중복된 값은 출력X
		Set<Integer> set = new HashSet<Integer>(); //
		set.add(10); // 추가할려고하면 add사용 => 추가할 값 입력
		set.add(20);
		set.add(30);
		set.add(10);
		for (Integer num : set) {
			System.out.println(num);

		}
		
		// 사용자가 선언하는 클래스. Member
		Set<Member> members = new HashSet<Member>();
		members.add(new Member("홍길동", 10));
		members.add(new Member("김민석", 12));
		members.add(new Member("홍길동", 10));
		
		for (Member num : members) {
			System.out.println(num.toString());
		}

	}// end of main

	public static void exe1() {
		int num1 = 10, num2 = 20;
		System.out.println(num1 == num2); // 숫자 타입을 비교할때는 비교연산자 사용해야 값이 true

		String str1 = new String("Hello");
		String str2 = new String("Hello");
		System.out.println(str1 == str2); // 문자열비교할때 연산자를 사용하면 그건 false 같은 값일수가 없다
		System.out.println(str1.equals(str2)); // 문자열 비교 할때는 equals사용해야 true

		Member mem1 = new Member(); // 인스턴스
		mem1.memberName = "홍길동";
		mem1.age = 10;

		Member mem2 = new Member(); // 만들어진 인스턴스의 주소 비교
		mem2.memberName = "홍길동";
		mem2.age = 10;

		System.out.println(mem1 == mem2);
		// mem1과 mem2의 주속 다르지만 동등하게 정의하고 싶을때 equals 사용
		System.out.println(mem1.equals(mem2)); // 멤버클래스에서 재정의
	} // end of exe1
}// end of class
