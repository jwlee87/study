package day11;

public class Person {
//	private String name;  // 접근제한자를 막으면 상속시에도 접근이 불가능하다.
	String name;
	int age;
	
	public Person() {
		
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
//		System.out.printf("name=%s, age=%d", name, age);
		return String.format("name=%s, age=%d", name, age);
	}
}








