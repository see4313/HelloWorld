package com.yedam.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamExe {

	public static void main(String[] args) {
		// orgin2.PNG -> copy2.PNG
		try {
			InputStream is = new FileInputStream("c:/temp/origin2.PNG");
			// outputstream
			OutputStream os = new FileOutputStream("c:/temp/copy3.PNG");

			// 보조스트림에 연결
			BufferedInputStream bis = new BufferedInputStream(is); // 보조스트림의 생성자의 매개값으로 input으로 연결
			BufferedOutputStream bos = new BufferedOutputStream(os);

			// 읽기 - 쓰기를 한번에
			while (true) {
				int data = bis.read();
				if (data == -1) {
					break;
				}
				bos.write(data);
			}
			bos.close(); bis.close();
			os.close(); is.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("end of prog");
	}// end of main

	// 복사.
	public static void copy() {
		// 입력stream => 출력stream
		try {
			// 입력스트림(original.PNG)
			InputStream is = new FileInputStream("c:/temp/origin2.PNG");
			// 출력스트림(copy.PNG)
			OutputStream os = new FileOutputStream("c:/temp/copy2.PNG");

			// 한번에 읽어들이는 크기를 크게하기 위해서 배열선언
			// 한번에 읽고 쓰기 byte[] 만큼 한번에 처리
			byte[] buf = new byte[10]; // 밑에는 일바이트씩 읽어주는데
			long start = System.currentTimeMillis(); // 시작시점.

			while (true) {
				int data = is.read(buf); // 1바이트를 읽어줌
				if (data == -1) {
					break;
				}
				os.write(buf);// 1바이트를 쓴다
			} // end of while
			os.close();
			is.close();
			long end = System.currentTimeMillis(); // 종료시점.
			System.out.println("걸린시간: " + (end - start));

		} catch (IOException e) {
			e.printStackTrace();
		}
	} // end of copy

	public static void read() {
		// 입력stream - 바이트기반
		try {
			InputStream is = new FileInputStream("c:/temp/os1.db");
			// read() 1바이트씩 읽기 (더이상 읽을 값이 없다느 -1로 반환됨)
			while (true) {
				int data = is.read();
				if (data == -1) {
					break;
				}
				System.out.println(data); // 1바이트가 10 or 20 or 30

			} // end of while
			is.close();
			;
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("end of prog");

	}// end of read

	public static void write() {
		// 출력 stream (외부 파일에 출력) - 바이트 기반
		try {
			OutputStream os = new FileOutputStream("c:/temp/os1.db");
			byte b1 = 10;
			byte b2 = 20;
			byte b3 = 30;
			os.write(b1);
			os.write(b2);
			os.write(b3);
			// 파일안에 위에있는 데이터들을 저장
			os.close();

		} catch (IOException e) { // IOException이 fileoutput 보다 상위요소
			e.printStackTrace();
		}
		System.out.println("end of prog");

	}// end of write

} // end of class
