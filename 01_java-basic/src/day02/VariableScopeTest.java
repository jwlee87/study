package day02;

public class VariableScopeTest 
{
	public static void main(String[] args) 
	{
//		int a = 10;
		{
			// 선언전에는 사용이 불가능하다.
	//		System.out.println(a);   // 에러 발생
			int a = 10;
			// 선언된 이후로는 사용이 가능
			System.out.println(a);
		}
		int a = 20;
		System.out.println(a);
	}
}