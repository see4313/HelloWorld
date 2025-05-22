package com.yedam.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

/*
 * Calendar: 날짜, 시간 관련
 * Date: 날짜, 시간,
 */
public class CalendarExe {
	public static void main(String[] args) {
		makeCalendar(2025, 9);
	}

	public static void cal() {
		// Calendar 클래스
		Calendar now = Calendar.getInstance(); // 캘린더 호출하는 메소드

		// 시간변경
		now.set(2025, 0, 1); // (년, 월, 일)
		now.set(Calendar.YEAR, 2024); // 년도만 2024년으로 변경

		// 요일
		int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
		switch (dayOfWeek) {
		case 1:
			System.out.println("일요일");
			break;
		case 2:
			System.out.println("월요일");
			break;
		case 3:
			System.out.println("화요일");
			break;

		}

		System.out.printf("년도 %d, 월: %d, 날짜: %d, 요일: %d, 말일: %d", //
				now.get(Calendar.YEAR)// //get 메소드(1은 년 2는 월등 ~)
				, now.get(Calendar.MONTH)// //월
				, now.get(Calendar.DATE) // //날짜
				, now.get(Calendar.DAY_OF_WEEK)// //지금 현재 날짜의 요일
				, now.getActualMaximum(Calendar.DATE)// //달의 마지막날을 알려줌
		);

	}// end of cal

	public static void Date() {
		Date today = new Date();
//		System.out.println(today.toGMTString());
//		System.out.println(today.toLocaleString());
		System.out.println(today.toString());

		// 우리가 주로 쓰는 2025년 05월 22일 17시 55분 18초 출력하고 싶을때
		// 생성자의 매개값으로 포맷
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 DD일 HH시 mm분 ss초");
		String timeStr = sdf.format(today); // Date타입을 원하는 String타입을 바꿔주는것
		System.out.println(timeStr);

		try {
			today = sdf.parse("2025년 08월 01일 09시 00분 00초"); // String타입을 Date타입으로 바꿔주는 것
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(today);
	} // end of date

	public static void makeCalendar(int year, int month) {

		// "월" 정보를 입력하면 말일을 알려주는메소드 getLastDate(월)

		Calendar now = Calendar.getInstance();
		now.set(year, month - 1, 1); // 날짜 지정
		System.out.println(" Sun Mon Tue Wen Thu Fri Sat");

		for (int i = 1; i < now.get(Calendar.DAY_OF_WEEK); i++) {
			System.out.printf("%4s", " "); //공백 출력
		}
		for (int i = 1; i <= now.getActualMaximum(Calendar.DATE) ; i++) {
			System.out.printf("%4d", i);
			if((i + now.get(Calendar.DAY_OF_WEEK)-1) % 7 == 0) {
				System.out.println();
			}
		}
		
		
	} // end of makeCalendar

} // end of class
