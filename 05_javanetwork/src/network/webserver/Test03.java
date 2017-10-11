package network.webserver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

public class Test03 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(10001);
			while (true) {
				Socket client = server.accept();
				System.out.println("클라이언트 접속됨...");
				
				// 요청 포멧 형식 출력하기(REQUEST)
				// 클라이언트 -> 서버
				/*
				   시작라인
				   헤더
				   
				   바디
				*/
				InputStream in = client.getInputStream();
				InputStreamReader isr = new InputStreamReader(in);
				BufferedReader br = new BufferedReader(isr);
				String reqStartLine = br.readLine();

				System.out.println("========================================");
				System.out.println("요청시작라인 : " + reqStartLine);
				System.out.println("========================================");
				// 요청시작라인 : GET /test?id=aaa&pass=1111 HTTP/1.1
				
				// 방식 : GET
				// URI  : /test
				// QueryString : id=aaa&pass=1111
				// id : aaa
				// pass : 1111
				
				// 요청시작라인 : GET /test?id=aaa&pass=1111 HTTP/1.1
				
				// http://localhost:8080/test
				// http://localhost:8080/test?id=aaa
				// http://localhost:8080/test?id=aaa&pass=1111
				String[] sArr = reqStartLine.split(" ");
				String[] uriArr = sArr[1].split("\\?");

				System.out.println("method : " + sArr[0]);
				System.out.println("uri : " + uriArr[0]);

				if (uriArr.length == 2) {
					String queryString = uriArr[1];
					System.out.println("QueryString : " + queryString);
					
					String[] params = queryString.split("&");
					for (String param : params) {
						String[] pArr = param.split("=");
						System.out.println(pArr[0] + " : " + pArr[1]);
					}
				}
				
				// 서버 -> 클라이언트 (RESPONSE)
				String msg = "성공";
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String startLine = "HTTP/1.1 200 OK\r\n";
				String headers = "Cache-Control: no-cache\r\n"
						       + "Content-Type: text/html; charset=UTF-8\r\n"
						       + "Content-Length: " + msg.getBytes().length + "\r\n\r\n";
				String body = msg;
				String data = startLine + headers + body;
				
				OutputStream out = client.getOutputStream();
				out.write(data.getBytes());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}












