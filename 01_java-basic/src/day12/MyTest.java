package day12;

abstract class Animal{
	abstract int test();
	
}
class Dog extends Animal {
	 int test() {
		 return 1;
	 }
}
public class MyTest {
	public static void main(String[] args) {
		Animal ani = new Dog();
		int result = ani.test();
		System.out.println(result);

		System.out.println(ani.test());
	}
}
