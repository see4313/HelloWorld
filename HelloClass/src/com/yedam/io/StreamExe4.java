package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * 객체 입출력 스트림
 * 기본타입 - 참조타입
 * int num = 10;
 * Member member = new Member();
 * 직렬화 (Serialization) : 객체를 기본타입으로 변경
 * 역직렬화 (Deserialization) : 기본타입을 객체타입으로 변경
 * 아무 개체나 되는게 아니고 Serializable 인터페이스를 구현하는 클래스에만 가능
 */
class Product implements Serializable {
	String prodCode;

	public Product(String prodCode) {
		this.prodCode = prodCode;
	}
} // end of class Serializable

public class StreamExe4 {

	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("c:/temp/object.db");
			ObjectInputStream ois = new ObjectInputStream(is);

			List<Product> list = (List<Product>) ois.readObject();
			for (Product product : list) {
				System.out.println("상품코드: " + product.prodCode);
			}

//			ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end of main

	static void serial() {

		List<Product> list = new ArrayList<>();
		list.add(new Product("P001"));
		list.add(new Product("P002"));

		try {
			// 기본스트림
			OutputStream os = new FileOutputStream("c:/temp/object.db");
			// 객체 입출력 보조 스트림
			ObjectOutputStream oos = new ObjectOutputStream(os);

			oos.writeObject(list); // 객체를 기본타입으로 변경
			oos.close();
			os.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog");

	} // end of serial

} // end of class StreamExe4
