package day04;

public class Test01 {
	public static void main(String[] args) {
		/*
		 *   for ( 초기값; 조건식; 증감 )
		 *       실행문장;
		 * 
		 *   for (1. 초기값; 2. 조건식; 3. 증감) {
		 *       4. 
		 *       실행문장;
		 *       실행문장;
		 *   }
		 *   5. 
		 *   
		 *   1 -> 2(참일 경우) -> 4 -> 3
		 *     -> 2(참일 경우) -> 4 -> 3
		 *     ..... 
		 *     ..... 
		 *     -> 2(거짓일 경우) -> 반복문 종료(5)
		 *     
		 *   참고.
		 *   1, 2, 3 번 항목 모두를 비워 둘 수 있다.  
		 *   
		 *   for (1. 초기값; ; 3. 증감)
		 *   for (1. 초기값; ; )
		 *   for ( ; ; )
		 *   for ( ; 2. 조건식; )
		 */
		int i = 0;
		for (i = 1; i <= 10; i++) {
//			if (i % 3 == 0)
//				System.out.println(i);
//			else 
//				System.out.println(i * 2);
			
			int val = i;
			if (i % 3 != 0) val = i * 2;
			System.out.println(val);
		}
		
		/*
		int val = 1;
		// 무한반복 실행됨...
		for (;;) {
			System.out.println(val++);
		}
		*/
		
		/*
		int dan = 2;
		System.out.printf("%d * %d = %d\n", dan, 1, dan * 1);
		System.out.printf("%d * %d = %d\n", dan, 2, dan * 2);
		System.out.printf("%d * %d = %d\n", dan, 3, dan * 3);
		System.out.printf("%d * %d = %d\n", dan, 4, dan * 4);
		System.out.printf("%d * %d = %d\n", dan, 5, dan * 5);
		System.out.printf("%d * %d = %d\n", dan, 6, dan * 6);
		System.out.printf("%d * %d = %d\n", dan, 7, dan * 7);
		System.out.printf("%d * %d = %d\n", dan, 8, dan * 8);
		System.out.printf("%d * %d = %d\n", dan, 9, dan * 9);
		*/
	}
}
