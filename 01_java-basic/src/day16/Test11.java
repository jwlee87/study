package day16;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test11 {
	public static void main(String[] args) {
		try (
			FileInputStream fis = new FileInputStream("data/kalimba.mp3");
			FileOutputStream fos = new FileOutputStream("data/kalimba4.mp3");
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
		) {
			System.out.println("파일 복사 시작");
			while (true) {
				int ch = bis.read();
				if (ch == -1)
					break;
				bos.write(ch);
			}
			System.out.println("파일 복사 성공");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
