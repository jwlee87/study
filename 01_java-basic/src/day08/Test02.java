package day08;

public class Test02 {
	public static void main(String[] args) {
		System.out.println("시간 측정 시작");
		
		String s1 = "a";
		// StringBuffer, StringBuilder는 자기 자신의 공간 값을 변경
		// 차이점 : StringBuffer(동기화), StringBuilder(비동기화) 
		StringBuffer s2 = new StringBuffer("a");
		//  1.5
		StringBuilder s3 = new StringBuilder("a");
		
		long s = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			s1 += i;
		}
		long e = System.currentTimeMillis();
		double time = (e - s) / 1000.0;
		System.out.println("String : " + time);
		
		s = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			s2.append(i);
		}
		e = System.currentTimeMillis();
		time = (e - s) / 1000.0;
		System.out.println("StringBuffer : " + time);
	}
}











