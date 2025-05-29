package com.vo;

public class Member {

	private String memberId;
	private String memberName;
	private String phone;
	private String memberDate;
	private String classLevel;
	private String classTime;

	// 생성자
	public Member() {
	}

	public Member(String memberId, String memberName, String phone, String memberDate, String classLevel,
			String classTime) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.phone = phone;
		this.memberDate = memberDate;
		this.classLevel = classLevel;
		this.classTime = classTime;

	}
	
	public Member(String memberId, String memberName, String phone, String classLevel,
			String classTime) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.phone = phone;
		this.classLevel = classLevel;
		this.classTime = classTime;

	}

	// 기본정보 생성자
	public Member(String memberId, String memberName, String phone, String memberDate) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.phone = phone;
		this.memberDate = memberDate;
	}

	public Member(String memberId, String memberName, String phone) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.phone = phone;

	}
	
	public Member(String memberId) {
		this.memberId = memberId;
	}

	// getter, setter

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMemberDate() {
		return memberDate;
	}

	public void setMemberDate(String memberDate) {
		this.memberDate = memberDate;
	}

	public String getClassLevel() {
		return classLevel;
	}

	public void setClassLevel(String classLevel) {
		this.classLevel = classLevel;
	}

	public String getClassTime() {
		return classTime;
	}

	public void setClassTime(String classTime) {
		this.classTime = classTime;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberName=" + memberName + ", phone=" + phone + ", memberDate="
				+ memberDate + ", classLevel=" + classLevel + ", classTime=" + classTime + "]";
	}

} // end of class
