package com.yedam.board;

import java.util.Iterator;
import java.util.Scanner;

/*
 * user: 아이디, 비밀번호, 이름
 */
class User {
	private String userId;
	private String passwd;
	private String userName;

	// 생성자
	public User(String userId, String passwd, String userName) {
		super();
		this.userId = userId;
		this.passwd = passwd;
		this.userName = userName;
	}

	// getter
	public String getUserId() {
		return userId;
	}

	public String getPasswd() {
		return passwd;
	}

	public String getUserName() {
		return userName;
	}

}

public class UserExe {
	static User[] users = { new User("holy", "1111", "김영광")//
			, new User("cutie", "2222", "홍예쁨")//
			, new User("guest", "3333", "밤손님") };

	// 아이디, 비밀번호 =>
	public static boolean login(String id, String pw) {
		for (int i = 0; i < users.length; i++) {
			if (users[i].getUserId().equals(id) && users[i].getPasswd().equals(pw)) {
				return true;  
			}

		}
		return false;
	}

//	static boolean login(String uname, String passwd) {
//		Scanner scn = new Scanner(System.in);
//
//		// code Here
//		for (int j = 0; j < 3; j++) {
//			System.out.println("아이디를 입력하세요");
//			uname = scn.nextLine();
//			
//			for (int i = 0; i < users.length; i++) {
//				//로그인 성공했으면 다음
//				if (users[i] != null && users[i].getUserId().equals(uname)) {
//					System.out.println("비밀번호를 입력하세요");
//					passwd = scn.nextLine();
//					//비밀번호를 틀렸을때 
//					if (users[i].getPasswd().equals(passwd)) {
//						System.out.println("성공");	
//						return true;  // 아이디 비밀번호 정확
//					}
//				}
//				
//			}
//			System.out.println("로그인 실패");
//		}
//		
//		return false; // 찾는 값이 없음
//		
//	}// end of login
} // end of userExe
