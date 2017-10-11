package day16;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test09 {
	public static void main(String[] args) {
		// Kalimba.mp3 : 40.491, (8,414,449 바이트)
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream("data/kalimba.mp3");
			fos = new FileOutputStream("data/kalimba3.mp3");
			byte[] buffer = new byte[32 * 1024];
			while (true) {
				int ch = fis.read(buffer);
				if (ch == -1)
					break;
				fos.write(buffer, 0, ch);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}
}
