package day16;

import java.io.FileReader;
import java.io.IOException;

public class Test05 {
	public static void main(String[] args) {
		FileReader fis = null;
		try {
			fis = new FileReader("data/a.txt");
			while (true) {
				int ch = fis.read();
				if (ch == -1) break;
				System.out.print((char)ch);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}









