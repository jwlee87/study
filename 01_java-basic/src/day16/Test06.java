package day16;

import java.io.FileWriter;
import java.io.IOException;

public class Test06 {
	public static void main(String[] args) {
		FileWriter fos = null;
		try {
			fos = new FileWriter("data/a2.txt", true);
			fos.write(97); 
			fos.write('a');
			fos.write('가');
			System.out.println("파일 쓰기 성공");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
