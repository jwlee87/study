package day05.quiz;

/*
 *   출력형식 > 
 *   배열의 모든 요소가 홀수 입니다.
 *   
 *   배열의 모든 요소가 홀수는 아닙니다.
 */
public class Quiz03 {
	public static void main(String[] args) {
		int [] arr = {6, 8, 3, 9, 7, 4};
		
		int i = 0;
		for ( ; i < arr.length; i++) 
			if (arr[i] % 2 == 0) break;

		System.out.printf("배열의 모든 요소가 %s", 
				          i == arr.length? "홀수 입니다." : "홀수는 아닙니다.");
		/*
		boolean flag = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				flag = true;
				break;
			}
		}
		System.out.printf("배열의 모든 요소가 %s", 
				          flag == false ? "홀수 입니다." : "홀수는 아닙니다.");
		*/
		
//		String msg = "홀수는 아닙니다.";
//		if (flag == false) {
//			msg = "홀수 입니다.";
//		} 
//		System.out.println("배열의 모든 요소가 " + msg);
		
		
		
	}
}











