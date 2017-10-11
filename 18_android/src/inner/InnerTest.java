/*
 *  내부클래스 : 최상위 클래스에 포함된 클래스
 *  선언되는 위치와 방법에 따라서 4가지 종류로 구분
 *  class TopClass {
 *  	class Inner {}
 *      // 클래스 영역
 *  	메서드 () {
 *  		// 메서드 영역	
 *      }
 *  }
 *  
 *  1. 내부클래스(InnerClass)  
 *     : 인클로징 클래스의 변수를 접근할 수 있음
 *     : static이 붙지않은 클래스 영역에 선언된 클래스
 *     : 인스턴스 변수
 *     : 클래스에만 선언 가능하고 인터페이스에는 선언이 불가능함
 *     : 외부에서 참조시 - 인클로징 클래스의 이름.이너 클래스 이름     
 *     : 인클로징 외부에서 이너 클래스의 객체 생성하기
 *     	  Cart cart = new Cart(); 
 *        Cart.Item item = cart.new Item();
 *                        
 *  2. 정적내부클래스(StaticInnerClass) 
 *     : static이 붙은 클래스 영역에 선언된 클래스
 *     : 클래스 변수
 *     : static 변수나 메서드를 선언할 수 있음
 *     
 *  3. 지역내부클래스(LocalInnerClass) 
 *     : 메서드 안에 선언되는 내부 가지는 클래스
 *     
 *  4. InnerAnnoymous(익명) : 클래스, 메서드 영역에 선언됨, 이름이 없음
 *                          : 두가지 동시 처리 (클래스 선언, 객체 생성)
 *                          
 *     * 메서드 안에 선언된 클래스가 메서드의 지역변수를 참조할 때는
 *       final로 선언된 변수만 사용 가능함
 *     
 *  5. 정적내부 인터페이스
 *     - 내부 인터페이스는 정적 내부 인터페이스 한종류만 가능함  
 *     
 *  class Top {
 *      class InnerMember { }
 *      static class StaticMember {}
 *      public void test () {
 *      	final int val = 100;
 *      	class InnerLocalNamed {
 *      	    public void print() {
 *                  System.out.println(val);
 *              }
 *      	}
 *      	new Random[상위클래스, 인터페이스]() { }
 *      }
 *  }
 */
package inner;

abstract class Parent {
	abstract public void call();
}

class Child extends Parent {
	public void call() {
		System.out.println("재정의함");
	}
}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println("test");
	}
}
public class InnerTest {
	public void call(Parent p) {
	}
	public void call(Runnable r) {
	}
	public void test() {
		
		call(new Parent() {
			public void call() {
				System.out.println("재정의함");
			}
		});
		
		
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("111");
			}
		};
		call(r1);
		
		call(new Runnable() {
			@Override
			public void run() {
				System.out.println("111");
			}
		});
		
		Thread t2 = new Thread(r1);
		
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("111");
			}
		});
		
		
		
		
		/*
			class B extends Test      // 클래스 정의
			{
				int i = 1;
				public void call() {}
			}
		 
		 	Test t = new B();     // 객체 생성
		 
		 	-->
		 	익명클래스 :  객체 생성 + 클래스 정의
		 	Test t = new Test() 
		 	{
				int i = 1;
				public void call() {}
			};
		 
		 
		 	class Child1 extends Parent {
		 		public void call() {}
		 	}
		 	Parent p = new Child1();
		 	
		 	-->
		 	Parent p = new Parent() {
		 		public void call() {}
		 	};
		 
		 
		 
		 
		 
		 */
		
		Runnable r = new MyRunnable();
		Thread t = new Thread(r);
		
		Parent p = new Child();
		p.call();
		
		Parent p2 = new Parent() {
			public void call() {
				System.out.println("재정의함");
			}
		};
		p2.call();
		
		// 익명클래스 형태
		// new 상위클래스[인터페이스]( ) {
		//     메서드 ..
		// }
		
		final int val = 100;
		class InnerLocal {
			public void call() {
				// 메서드에 선언된 지역변수 중 final 변수만 접근 가능
				System.out.println(val);
			}
		}
		InnerLocal local = new InnerLocal();
	}
	
	public static void main(String[] args) {
		Top top = new Top();
		Top.InnerMember innerMember = top.new InnerMember(); 
		
		System.out.println(Top.StaticMember.val2);
		Top.StaticMember.call();
		Top.StaticMember innerStatic = new Top.StaticMember();
		System.out.println(innerStatic.val);
	}
}
class Top {
	String data;
	static String data2;
	
	class InnerMember {
		int val = 100;
//		static int val2 = 200;  // 오류 
		public void call() {
			System.out.println("InnerMember");
		}
		public void getEnclosing() {
			System.out.println(data);
			System.out.println(data2);
		}
	}
	static class StaticMember {
		int val = 100;
		static int val2 = 200; 
		public static void call() {
			System.out.println("StaticMember");
		}
		
		public void getEnclosing() {
//			System.out.println(data);  // 접근 불가능
			System.out.println(data2);
		}
	}
}

class TopInterface {
	interface Player {
		void play();
		void call();
	}
}

interface Top2Interface {
	static interface Player {  // 자동으로 static 가 붙는다.
		void play();
		void call();
		interface Address {
			String addr = "a";
		}
	}
}












