package com.yedam.api;

public class Member extends Object {
	public String memberName;
	int age;

	public Member() {
	}

	public Member(String memberName, int age) {
		this.memberName = memberName;
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		return age;
	}
	
	
	
	

	// 이름, 점수 => 같으면 논리적으로 동등한지
	@Override
	public boolean equals(Object obj) { // 논리적으로 동등한지 정의하고 싶을때 equals사용

		// obj라는 값이 Member클래스의 인스턴스 유형이 아니면 false
		if (obj instanceof Member) { // 매개값의 유형이 Member임
			Member member = (Member) obj; // 캐스팅
			return this.memberName == member.memberName // 이름도 같아야하고
					&& this.age == member.age; // 나이도 같아야 같은걸로 인정한다고 선언할때 사용하는게 equals
		}
		return false;
	}
	
	@Override
	public String toString() { 
		return "이름: " + memberName + " 나이: " + age;
	}

}
