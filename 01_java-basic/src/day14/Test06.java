package day14;

import java.util.ArrayList;
import java.util.HashMap;

public class Test06 {
	public static void main(String[] args) {
		Box01 b = new Box01();
		b.setData("test");
		String data = b.getData();
		System.out.println("data : " + data);
		
		Box02 b2 = new Box02();
		b2.setData("test");
		String data2 = (String)b2.getData();
		System.out.println("data2 : " + data2);
		
		b2.setData(100);
		Integer data3 = (Integer)b2.getData();
		System.out.println("data3 : " + data3);
		
		Box03<String> b3 = new Box03<String>();
		b3.setData("test");
		String data4 = b3.getData();
		System.out.println(data4);
		
		Box03<Integer> b4 = new Box03<Integer>();
		
//		Box04<String, String> box04 = 
//				new Box04<String, String>("apple", "사과");
		Box04<String, String> box04 = new Box04<>("apple", "사과");
		System.out.println(box04.getKey());
		System.out.println(box04.getValue());
		
	}
}


























