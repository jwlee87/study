package day03;

public class Test04 {
	public static void main(String[] args) {
		/*
			if (조건식) 
			    실행할 문장(조건식이 참일 경우)
			    
			주의사항.
			if 문에 블럭을 같아 사용하지 않을 경우에는 한문장만을 대상으로 처리합니다.    
			2문장이상을 if문의 대상으로 하려면 반드시 블럭({})과 같이 사용해야 한다.	
		*/
		/*
		int a = 4;
		if (a > 5)
			System.out.println("a는 5보다 크다");
		
		if (a > 5) {
			System.out.println("a는 5보다 크다"); 
			System.out.println("a는 " + a);
		}
			
		// a가 짝수일 경우 "짝수입니다"를 화면에 출력
		if (a % 2 == 0)
			System.out.println("짝수입니다.");
		
		// a가 짝수일 경우 "짝수입니다"를 홀수일 경우에는 "홀수입니다"를 화면에 출력
		int a = 10;
		if (a % 2 == 0)
			System.out.println("짝수입니다.");
		
		if (a % 2 == 1)
			System.out.println("홀수입니다.");
		 */
		
		/*
		 	2가지 상황일 경우
		 	if (조건식)
		 		참일 경우 실행할 문장
		 	else 
		 		참이 아닐 경우에 실행할 문장
		 */
		/*
		if (a % 2 == 0)
			System.out.println("짝수입니다.");
		else
			System.out.println("홀수입니다.");

		if (a % 2 == 0) {
			System.out.println("짝수입니다.");
		} else {
			System.out.println("홀수입니다.");
		}
		
		if (a % 2 == 0) {
			System.out.println("짝수입니다.");
			System.out.println("a는 " + a);
		} else
			System.out.println("홀수입니다.");
		*/
		
		
		int a = 10;
		// a는 5보다 크다, a는 5이다, a는 5보다 작다
		if (a > 5) {
			System.out.println("a는 5보다 크다");
		} else {
			if (a == 5) {
				System.out.println("a는 5이다");
			} else {
				System.out.println("a는 5보다 작다");
			}
		}
		
		/*
		 *   if (조건식) {
		 *   	참일 경우 수행
		 *   } else if (조건식) {
		 *   	참일 경우 수행
		 *   } else if (조건식) {
		 *   	참일 경우 수행
		 *   } else {
		 *   
		 *   }
		 */
		if (a > 5) {
			System.out.println("a는 5보다 크다");
		} else if (a == 5) {
			System.out.println("a는 5이다");
		} else {
			System.out.println("a는 5보다 작다");
		}
	}
}












