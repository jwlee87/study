package network.server;

import java.io.InputStream;
import java.net.Socket;

public class AppClientTest02 {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("192.168.0.100", 10001);
			// 서버에서 전송된 데이터 읽기
			InputStream in = s.getInputStream();
			byte[] buffer = new byte[1024];
			int count = in.read(buffer);
			String msg = new String(buffer, 0, count);
			System.out.println("서버에서 전송된 데이터 : " + msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}




