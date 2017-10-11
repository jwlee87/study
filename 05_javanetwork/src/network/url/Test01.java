package network.url;

import java.net.URL;

public class Test01 {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.naver.com:8000/test?msg=hello");
			System.out.println(url.getProtocol());
			System.out.println(url.getDefaultPort());
			System.out.println(url.getPort());
			System.out.println(url.getHost());
			System.out.println(url.getFile());
			System.out.println(url.getPath());
			System.out.println(url.getQuery());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}













