package day15;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test01 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");

		// 리스트의 데이터 확인하기
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		for (int i = 0, size = list.size(); i < size; i++) {
			System.out.println(list.get(i));
		}
		
		Iterator<String> ite = list.iterator();
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}
		
		for (String s : list) {
			System.out.println(s);
		}
		
		
		
		/*
		// get(int index)
		System.out.println(list.get(1));
		list.remove(0);
		System.out.println(list.get(1));
		list.remove("three");
		System.out.println(list);
		
		list.add(0, "one");
		list.add("three");
		System.out.println(list);
		
		list.clear();
		System.out.println(list);
		list.add("one");
		
		List<String> sub = new ArrayList<>();
		sub.add("two");
		sub.add("three");
		
		list.addAll(sub);
		System.out.println(list);
		
		System.out.println(list.isEmpty());
		
		System.out.println(list.contains("one"));
		System.out.println(list.indexOf("one"));
		System.out.println(list.indexOf("four"));
		*/
	}
}






















