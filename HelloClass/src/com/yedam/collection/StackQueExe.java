package com.yedam.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueExe {
	public static void main(String[] args) {
		
		// 먼저 들어간 순서대로 먼저 나옴 (FirstInFirstOut)
		Queue<String> orders = new LinkedList<String>();
		orders.offer("카페라떼");
		orders.offer("아메리카노");
		orders.offer("녹차라뗴");
		
		while(!orders.isEmpty()) {
			System.out.println(orders.poll());
		}
		
		// 들어간 순서 반대로 나옴 (LastInFirshOut)
		Stack<String> books = new Stack<String>();
		// LastInFirshOut 구조
		books.push("이것이 자바다");
		books.push("HTML,CSS");
		books.push("자바스크립트기초");
		
		while(!books.isEmpty()) {
			System.out.println(books.pop());
		}
		
		
	} // end of main
	
} // end of class
