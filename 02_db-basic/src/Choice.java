import java.util.Random;

public class Choice {
	public static void main(String[] args) throws Exception {
		System.out.print("선택.... : ");
		Thread.sleep(2000);
		System.out.println(new Random().nextInt(15) + 1);
//		Thread.sleep(2000);
//		int [] arr = {3, 7};
//		System.out.print("문제 번호 : " + arr[new Random().nextInt(2)]);
	}
}