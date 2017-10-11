package network.server;

import java.net.Socket;

public class AppClientTest01 {
	public static void main(String[] args) {
		// 192.168.0.100
		try {
			Socket s = new Socket("localhost", 10001);
			System.out.println("접속 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
