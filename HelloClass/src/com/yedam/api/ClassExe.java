package com.yedam.api;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassExe {
	public static void main(String[] args) {
		try {
			Class cls = Class.forName("com.yedam.api.Member"); // 클래스.포네임이 클래스를 불러오는것

			Member member = new Member();
			cls = member.getClass();

			System.out.println(cls.getName());

			// 선언된 필드
			Field[] fieldAry = cls.getDeclaredFields(); // 필드로 배열
			for (Field field : fieldAry) {
				System.out.println(field.getName()); // 필드명을 볼수있음
			}
			// 메소드
			Method[] methodAry = cls.getDeclaredMethods();
			for (Method method : methodAry) {
				System.out.println(method.getName());
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // 위에 주소에 정보가 없으면
		}
	}
}
