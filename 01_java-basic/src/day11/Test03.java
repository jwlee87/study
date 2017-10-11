package day11;

import java.util.ArrayList;
import java.util.Random;

class Dog {
	String name;
	int age;
	
	Dog() {
		this("이름없음", -1);
	}
	Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// public String toString()
	public String toString() {
		return String.format("Dog[name=%s, age=%d]", name, age);
	}
}

public class Test03 {
	public static void main(String[] args) {
		Dog d  = new Dog();
		Dog d2 = new Dog("메리", 2);
		System.out.println(d.toString());  // Object.toString()
		// toString() 메서드는 객체 자체를 어떤식에 대입할때 자동 호출됨
		// 대표적인 케이스
		System.out.println(d);  // d.toString() 과 같다.
		System.out.println(d2);  // d2.toString() 과 같다.
		
		int[] arr = {1, 2, 3};
		System.out.println(arr.toString());
		System.out.println(arr);
		
		Random r = new Random();
		System.out.println(r.toString());
		System.out.println(r);
		
		ArrayList list = new ArrayList<>();
		System.out.println(list.toString());
		System.out.println(list);
		
		String str = "aaa";
		System.out.println(str.toString());
		System.out.println(str);
	}
}










