package day13;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test05 {
	private static void a() throws FileNotFoundException {
		FileReader fr = new FileReader("a.txt");
	}
	private static void b() {
		System.out.println(1 / 0);
	}
	
	public static void main(String[] args) {
		try {
			a();
			b();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
