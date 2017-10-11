package day02.quiz;

public class Quiz01 {
	public static void main(String[] args) 
	{
		
		// i변수에 값을 할당하는 것은 try 블럭에서 해야만 한다.
		// 오류가 나지 않도록 코드를 수정하시오..
		int i = 0;
		try 
		{
			i = 100;
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		} 
		finally 
		{
			System.out.println(i);
		}
	}
}
