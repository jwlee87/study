package day16;

import java.io.File;

public class Test02 {
	public static void main(String[] args) {
		File f = new File("data");
		File[] fList = f.listFiles();
		for (File sub : fList) {
//			String type = "";
//			if (sub.isDirectory()) {
//				type = "D";
//			} else {
//				type = "F";
//			}
			
//			String type = sub.isDirectory() ? "D" : "F";
//			System.out.println(type + ":" + sub.getName());
			
			System.out.printf("%s:%s\n", sub.isDirectory() ? "D" : "F", sub.getName());
		}
		
		
		
//		String[] list = f.list();
//		for (String name : list) {
//			File temp = new File("data/" + name);
//			String type = "";
//			if (temp.isDirectory()) {
//				type = "D";
//			} 
//			else if (temp.isFile()) {
//				type = "F";
//			}
//			System.out.println(type + ":" + name);
//		}
		
		
		
		
		
		
	}
}
