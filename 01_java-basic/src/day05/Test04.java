package day05;

import java.util.Arrays;

public class Test04 {
	public static void main(String[] args) {
		String[] arr = {"치킨", "피자", "콜라", "스파게티"};
		
		String[] dest = new String[arr.length];
		
		// arr 배열의 내용을 dest 배열에 복사
//		for (int i = 0; i < arr.length; i++) {
//			dest[i] = arr[i];
//		}
//		for (int i = 0; i < 3; i++) {
//			dest[i + 1] = arr[i];
//		}
//		for (int i = 0; i < 3; i++) {
//			dest[i] = arr[i + 1];
//		}
		
		System.arraycopy(arr, 0, dest, 1, 3);
		
		System.out.println(Arrays.toString(dest));
	}
}








