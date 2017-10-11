package day05;

import java.util.Arrays;
import java.util.Random;

public class Test03 {
	public static void main(String[] args) {
		// 배열에 입력된 요소를 확인하는 방법
		int[] iArr = {10, 20, 30};
		
		// 1번 방법
		System.out.println("1번 방법");
		for (int i = 0; i < iArr.length; i++) {
			System.out.println(iArr[i]);
		}
		System.out.println("---------------------");
		
		// 2번 방법 : 향상된 for문(1.5 이후 가능)
		System.out.println("2번 방법");
		for (int i : iArr) {
			System.out.println(i);
		}
		System.out.println("---------------------");
		
		boolean [] bArr = {true, false, true};
		for (boolean i : bArr) {
			System.out.println(i);
		}
		
		char [] cArr = {'a', 'b', 'c'};
		
		Random[] rArr = {null, null, null};
		for (Random r : rArr) {
			
		}
		
		// 3번 방식 : 단순히 배열의 요소값만을 확인
		System.out.println("3번 방법");
		String data = Arrays.toString(iArr);
		System.out.println(data);
		
		System.out.println(Arrays.toString(iArr));
		
		
	}
}

























