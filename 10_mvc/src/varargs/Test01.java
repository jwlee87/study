package varargs;

public class Test01 {
	/*
	public static void call() {
		System.out.println("call1");
	}
	public static void call(int i) {
		System.out.println("call2");
	}
	public static void call(int i, int j) {
		System.out.println("call3");
	}
	public static void call(int i, int j, int k) {
		System.out.println("call4");
	}
	public static void call(int[] arr) {
		System.out.println("call5");
	}
	*/
	
	public Object invoke(Object obj, Object...arr) {
		return null;
	}
	
	public static void call(int...arr) {
		
	}
	
	public static void main(String[] args) {
		call();
		call(1);
		call(new int[] {1});
		call(2, 3);
		call(4, 5, 6);
	}
}













