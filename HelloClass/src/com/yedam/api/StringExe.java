package com.yedam.api;

import java.io.UnsupportedEncodingException;

public class StringExe {
	public static void main(String[] args) {
		str3();
	}

	public static void str1() {

		String strVar1 = new String("신민철");
		String strVar2 = "신민철";

		if (strVar1.equals(strVar2)) {
			System.out.println("같음");
		} else {
			System.out.println("다름");
		}
	}// end of str1

	public static void str2() {
		String ssn = "980405-268135";
		char sex = ssn.charAt(7);
		switch (sex) {
		case '1':
		case '3':
			System.out.println("남자입니다");
			break;
		case '2':
		case '4':
			System.out.println("여자입니다");
			break;
		}
	} // end of str2

	public static void str3() {
		String str = "안녕하세요";

		byte[] bytes1 = str.getBytes();
		System.out.println("bytes1.length: " + bytes1.length);
		String str1 = new String(bytes1);
		System.out.println("bytes1 -> String: " + str1);
		
		try {
			byte[] bytes2 = str.getBytes("EUC-KR");
			System.out.println("bytes2.length: " + bytes2.length);
			String str2 = new String(bytes2, "EUC-KR");
			System.out.println("bytes2 -> String: " + str2);
			
			byte[] bytes3 = str.getBytes("UTF-8");
			System.out.println("bytes3.length: " + bytes3.length);
			String str3 = new String(bytes3, "UTF-8");
			System.out.println("bytes3 -> String: " + str3);
			
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	
	}// end of str3

	public static void str() {
		String str1 = new String("Hello"); // 생성자 만드는 방식
//		str1 = new String(new byte[] { 72, 101, 108, 108, 111 }, 0, 2 ); // {H = 72, e= 101, l = 108 ~}

		System.out.println(str1);
		System.out.println(str1.charAt(0)); // "", '' 0번쨰 문자 가지고오겠다의미 그래서 H
		System.out.println(str1.charAt(1));

		System.out.println(str1.indexOf("o")); // 인덱스에 o 가 있으면 반환해주고 없으면 -1로 반환
		System.out.println(str1.indexOf("s")); // 값이 없으니 -1 출력

	}// end of main

}// end of class
