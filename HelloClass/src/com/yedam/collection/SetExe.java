package com.yedam.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExe {
	public static void main(String[] args) {
		//Set 컬렉션.
		Set<String> set = new HashSet<>();
		set.add("홍길동");
		set.add("월요일");
		set.add("금요일");
		
		//삭제
		if (set.contains("홍길동")) {
			System.out.println(set.remove("홍길동"));			
		}
		
		// 추가(add), 삭제(remove), 
		//수정은 X
		
		//반복
		Iterator<String> iter = set.iterator();  //반복자에 순번 붙임
		while(iter.hasNext()) {  // 반복요소의 여부체크
			String result = iter.next();  // next = 끄집어 내겠다
			// 요소를 다 가지고와서 그중에 하나씩 끄집어 내서 찾아야해서 반복문 사용
			System.out.println(result);
		}
		
		
	} // end of main
}// end of class
