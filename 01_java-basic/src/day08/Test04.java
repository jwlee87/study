package day08;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Test04 {
	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("data/day08/test04.txt");
		Scanner sc = new Scanner(f);
		while (sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
	}
}
