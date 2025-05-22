package com.yedam.interfaces;
/*
 * 인터페이스 : 필드(상수)
 */
public interface RemoteControl {
	public int MAX_VOLUME = 10; // 상수역할
	
	//선언하기만하면 다 추상메소드
	public abstract void turnOn();
	public abstract void turnOff();

}
