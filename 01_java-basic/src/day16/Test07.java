package day16;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test07 {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("data/a.txt");
			fw = new FileWriter("data/add.txt");
			while (true) {
				int ch = fr.read();
				if (ch == -1)
					break;
				fw.write(ch);
			}
			System.out.println("복사 완료");

		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();

		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
