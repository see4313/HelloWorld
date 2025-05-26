package com.yedam.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class StreamExe2 {
	public static void main(String[] args) {
		//파일 읽어들이기
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("c:/temp/writer.txt"));
			while(true) {
				String data = scanner.nextLine();  // 한라인을 읽어오는 nextLine
				data.split(" "); // 홍길동 다음 공백을 말함
				String[] strAry = data.split(" ");  // split 은 구분자를 기준으로 배열을 만들어줌
				System.out.println(strAry[0] + ", " + strAry[1]);
//				System.out.println(data);	
			}
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			scanner.close();
		}
		System.out.println("end of prog");
		
	} // end of main

	public static void reader() {
		// char기반의 입력스트림.
		try {
			Reader reader = new FileReader("c:/temp/writer.txt");
			while (true) {
				int data = reader.read();// 2바이씩 읽어옴
				if (data == -1) {
					break;
				}
				System.out.println((char) data); // char 타입을 빼면 숫자타입으로 출력되고 char를 입력하면 문자타입으로 출력됨
			}
			reader.close();
			System.out.println(); // 줄바꿈용도

		} catch (IOException e) {
			e.printStackTrace();
		}

	} // end of reader

	public static void write() {
		// 문자기반 ( = char기반의 출력스트림)]
		// 출력스트림은 Writer 사용
		try {
			Writer wr = new FileWriter("c:/temp/writer.txt");
			wr.write('A');
			wr.write('B');
			wr.write('C');
			wr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog");

	}// end of write

} // end of class
