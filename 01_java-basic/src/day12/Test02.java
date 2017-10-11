package day12;
interface InterA {
	public void a();
}
interface InterB extends InterA {
	public void b();
}
interface InterSuper {
	// 인터페이스에 선언되는 변수에는 public static final 키워드가 자동으로 삽입된다.
	// public static final int PORT
	int PORT = 8000;
	
	// public abstract void call();
	void call();
	void print();
	default void test() {
		System.out.println("default");
	}
	static void test2() {
		System.out.println("static");
	}
}
class InterSub implements InterSuper, InterB {
	public void a() {
		System.out.println("InterA 의 메서드 재정의");
	}
	public void b() {
		System.out.println("InterB 의 메서드 재정의");
	}
	public void call() {
		System.out.println("재정의된 call()");
	}
	public void print() {
		System.out.println("재정의된 print()");
	}
}
class StaClz {
	static int i = 100;
}

public class Test02 {
	public static void main(String[] args) {
		StaClz sc = new StaClz();
		System.out.println(sc.i);

		System.out.println(StaClz.i);
		
		
//		InterSuper iSuper = new InterSuper();
		InterSuper iSuper = new InterSub();
		iSuper.call();
		iSuper.print();
		InterB ib = new InterSub();
		InterA ia = new InterSub();
		
		System.out.println(InterSuper.PORT);
		System.out.println(iSuper.PORT);  // static 개념이기 때문에 클래스.변수로 접근
//		InterSuper.PORT = 9000;   // final 개념이기 때문에 벼눗에 값 할당이 안됨(오류발생)
	}
}












