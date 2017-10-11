package day13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) throws FileNotFoundException {
		// 실행시점 예외 : ArithmeticException
//		System.out.println(1 / 0);
		
		// 컴파일시점 발생 예외(Checked Exception) : FileNotFoundException
		FileReader fr = new FileReader("a.txt");
		
		Scanner sc = new Scanner(new File("a.txt"));
		
	}
}
