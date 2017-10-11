package network.api;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Test01 {
	public static void main(String[] args) {
		String requestUrl = "https://apis.daum.net/search/blog";
		String parameter  = "?apikey=yourApikey&q=java&result=3&output=xml";
		
		String apiUrl = requestUrl + parameter;
		try {
			URL url = new URL(apiUrl);
			InputStream in = url.openStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			while (true) {
				String line = br.readLine();
				if (line == null) break;
				
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}












