/*
 *  ����Ŭ���� : �ֻ��� Ŭ������ ���Ե� Ŭ����
 *  ����Ǵ� ��ġ�� ����� ���� 4���� ������ ����
 *  class TopClass {
 *  	class Inner {}
 *      // Ŭ���� ����
 *  	�޼��� () {
 *  		// �޼��� ����	
 *      }
 *  }
 *  
 *  1. ����Ŭ����(InnerClass)  
 *     : ��Ŭ��¡ Ŭ������ ������ ������ �� ����
 *     : static�� �������� Ŭ���� ������ ����� Ŭ����
 *     : �ν��Ͻ� ����
 *     : Ŭ�������� ���� �����ϰ� �������̽����� ������ �Ұ�����
 *     : �ܺο��� ������ - ��Ŭ��¡ Ŭ������ �̸�.�̳� Ŭ���� �̸�     
 *     : ��Ŭ��¡ �ܺο��� �̳� Ŭ������ ��ü �����ϱ� - Cart.Item item = cart.new Item();                   
 *  2. ��������Ŭ����(StaticInnerClass) 
 *     : static�� ���� Ŭ���� ������ ����� Ŭ����
 *     : Ŭ���� ����
 *     : static ������ �޼��带 ������ �� ����
 *     
 *  3. ��������Ŭ����(LocalInnerClass) 
 *     : �޼��� �ȿ� ����Ǵ� ���� ������ Ŭ����
 *     
 *  4. InnerAnnoymous(�͸�) : Ŭ����, �޼��� ������ �����, �̸��� ����
 *                          : �ΰ��� ���� ó�� (Ŭ���� ����, ��ü ����)
 *     * �޼��� �ȿ� ����� Ŭ������ �޼����� ���������� ������ ����
 *       final�� ����� ������ ��� ������
 *     
 *  5. �������� �������̽�
 *     - ���� �������̽��� ���� ���� �������̽� �������� ������  
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
 *      	new Random[����Ŭ����, �������̽�]() { }
 *      }
 *  }
 */
package _16_innerClass;

abstract class Parent {
	abstract public void call();
}

class Child extends Parent {
	public void call() {
		System.out.println("��������");
	}
}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println("test");
	}
}

public class InnerTest {
	public void call(Runnable r) {
	}
	
	public void test() {
		
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
		
		Runnable r = new MyRunnable();
		Thread t = new Thread(r);
		
		Parent p = new Child();
		p.call();
		
		Parent p2 = new Parent() {
			public void call() {
				System.out.println("��������");
			}
		};
		p2.call();
		
		// �͸�Ŭ���� ����
		// new ����Ŭ����[�������̽�]( ) {
		//     �޼��� ..
		// }
		
		final int val = 100;
		class InnerLocal {
			public void call() {
				// �޼��忡 ����� �������� �� final ������ ���� ����
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
//		static int val2 = 200;  // ���� 
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
//			System.out.println(data);  // ���� �Ұ���
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
	static interface Player {  // �ڵ����� static �� �ٴ´�.
		void play();
		void call();
		interface Address {
			String addr = "a";
		}
	}
}












