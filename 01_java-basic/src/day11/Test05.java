package day11;

class Food {
}
class Tonkatsu extends Food {
}
class Pizza extends Food {
}
public class Test05 {
	public static void main(String[] args) {
//		Tonkatsu ton = new Food();   // 컴파일시 오류 발생
//		Tonkatsu ton = (Tonkatsu)new Food();   // 실행시 오류 발생
		// 올바른 명시적 형변환은 묵시적인 형변환이 이루어진 객체를 대상으로 함
		
		// 묵시적 형변환 객체
		Food f = new Tonkatsu();
		
		// 명시적 형변환
		Tonkatsu ton = (Tonkatsu)f;
		Pizza p = (Pizza)f;  // 실행시 오류 발생
	}
}













