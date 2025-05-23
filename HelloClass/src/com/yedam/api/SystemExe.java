package com.yedam.api;

import java.util.Iterator;

public class SystemExe {
	public static void main(String[] args) {

		long now = System.currentTimeMillis(); // 현재시간을 1/1000초
		System.out.println(now);

		// 1747964906 => "초" => 몇일, 몇시간, 몇분, 몇초로 반환하는 코드작성
		// 60 * 60 * 24 => 1일
		// 60 * 60 => 1시간
		// 60 => 1시간
		// 나머지가 초
		// 계산
		long time = 1747964906;
		long years = time / (60 * 60 * 24 * 365); // 년계산

		long days = (time) % (60 * 60 * 24 * 365); // 일계산
		days = days / (60 * 60 * 24);

		long hours = time % (60 * 60 * 24); // 시간 계산

//		System.out.println(day);
		long hour = ((time) / 60 * 60);
		System.out.println(hour);

	}

	public static void exe() {
		//
		long start = System.nanoTime(); // 현재 시스템시간을 long 타입으로 보여줌
		int sum = 0;
		for (int i = 0; i < 100000000; i++) {
			sum += i;
		}
		long end = System.nanoTime();
		System.out.printf("합께 %d, 걸린시간 %d\n", sum, (end - start));
	} // end of exe

} // end of class
