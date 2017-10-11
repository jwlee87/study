package network.server;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class AppClientTest03 {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("192.168.0.100", 10001);
			// 서버에서 전송된 데이터 읽기
			InputStream in = s.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			String msg = dis.readUTF();
			System.out.println("서버에서 전송된 데이터 : " + msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}




