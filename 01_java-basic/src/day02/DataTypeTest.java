package day02;

public class DataTypeTest {
	public static void main(String[] args) {
		// 기본형은 8가지이고 소문자로 시작한다.
		// 논리형, 문자형, 숫자
		boolean bool = true;
		System.out.println(bool);
		bool = false;
		
		char ch = '가';
		char ch2 = 97;
		char ch3 = '\u0061';
		System.out.println(ch);
		System.out.println(ch2);
		System.out.println(ch3);
		
		// 숫자형
		byte b = 127;
		short s = 1;
		int i = 1;
		long l = 1l;
		l = 1L;
		
		// float은 반드시 실수형 숫자 뒤에 f, F를 붙여야 한다.
		float f = 1.1f;
		f = 1.1F;
		
		double d = 1.1;
	}
}











