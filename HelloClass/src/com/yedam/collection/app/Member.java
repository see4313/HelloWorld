package com.yedam.collection.app;

public class Member {
	// 필드
	private String memberId;
	private String memberName;
	private String phone;
	private int point;

	// 생성자
	
	
	//전체필드를 매개값으로 갖는 생성자 => 우클릭 source => constructor using field
public Member(String memberId, String memberName, String phone, int point) {
	this.memberId = memberId;
	this.memberName = memberName;
	this.phone = phone;
	this.point = point;
} 

// 메소드(getter, setter) => 우클릭 source => getters and setters클릭해서 원하는거 체크하고 만들기
public String getMemberId() {
	return memberId;
}

void setMemberId(String memberId) {
	this.memberId = memberId;
}

public String getMemberName() {
	return memberName;
}

void setMemberName(String memberName) {
	this.memberName = memberName;
}

public String getPhone() {
	return phone;
}

void setPhone(String phone) {
	this.phone = phone;
}

public int getPoint() {
	return point;
}

void setPoint(int point) {
	this.point = point;
}
public void showInfo() { // 패키지가 다르더라도 접근가능하게 하려면 public 붙여주기
		System.out.printf("이름은 %s, 연락처는 %s, 포인트 %d\n", memberName, phone, point);
	}
	

}// end of class
