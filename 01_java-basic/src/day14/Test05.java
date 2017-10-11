package day14;

import kr.co.mlec.util.MyArrayList;

public class Test05 {
	public static void main(String[] args) {
		// Wrapper 클래스
		// 기본형에 대한 참조타입 클래스
		/*
		 *   byte     -> Byte
		 *   short    -> Short
		 *   int      -> Integer
		 *   long     -> Long
		 *   float    -> Float
		 *   double   -> Double
		 *   boolean  -> Boolean
		 *   char     -> Character
		 */
		int i = 100;
		
		// 기본형을 참조형
		Integer iObj = new Integer( i );
		
		// 참조형을 기본타입 값으로..
		int val = iObj.intValue();
		
		MyArrayList list = new MyArrayList();
		list.add(new Integer(val));
		
		
		// 1.5버전 부터
		// auto boxing    :  기본형 -> 참조형
		int i2 = 100;
		Integer iObj2 = i2;   //  Integer iObj2 = new Integer( i2 ); 
		
		// auto unboxing  :  참조형 -> 기본형
		int i3 = iObj2;   // iObj2.intValue();
		list.add(i3);
		// Object obj = i3;  // Object obj = new Integer(i3);
		
		Object obj  = 100;
		Object obj2 = "100";
		
		System.out.println( obj  instanceof Integer );
		System.out.println( obj2 instanceof Integer );
		System.out.println( obj2 instanceof String );
	}
}














