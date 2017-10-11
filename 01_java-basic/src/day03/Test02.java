package day03;

public class Test02 {
	public static void main(String[] args) {
		/*
		int classPersonCount = 17;
		System.out.println(classPersonCount);
		
		classPersonCount = 18;
		System.out.println(classPersonCount);
		 */
		
		final int CLASS_PERSON_COUNT = 17;
		System.out.println(CLASS_PERSON_COUNT);
		
		// CLASS_PERSON_COUNT = 18;  // final 변수는 변경이 불가능(상수)
		System.out.println(CLASS_PERSON_COUNT);
		
		
		// 문자열 상수 테스트
		System.out.println("c:\test 는 파일이 저장된 폴더입니다.");
		System.out.println("c:\\test 는 파일이 저장된 폴더입니다.");
		System.out.println("톨스토이는 이렇게 이야기 합니다. \"책은 마음의 양식\"이라고... ");
//		System.out.println("c:\java90");   // 컴파일 오류 발생함...
	}
}


















