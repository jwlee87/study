package day07;

import java.util.Arrays;

public class Test03 {
	public static void main(String[] args) {
		Sub03 s03 = new Sub03();
		int result = s03.add(200, 100);
		System.out.println(result);
		
		System.out.println(s03.sub(200, 100));
		System.out.println(s03.mul(200, 100));
		System.out.println(s03.div(200, 100));
		
		int val = s03.cal(1, 10, 20);
		System.out.println(val);
		
		int[] arr = s03.makeNumbers();
		System.out.println(Arrays.toString(arr));
				
		System.out.println(Arrays.toString(s03.makeNumbers(10)));
		
		System.out.println(Arrays.toString(s03.makeNumbers(6, 45)));
	}
}















