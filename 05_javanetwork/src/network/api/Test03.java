package network.api;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;

public class Test03 {
	public static void main(String[] args) {
		String requestUrl = "https://apis.daum.net/search/blog";
		String parameter  = "?apikey=yourApikey&q=java&result=3&output=json";
		
		String apiUrl = requestUrl + parameter;
		System.out.println(apiUrl);
		try {
			URL url = new URL(apiUrl);
			InputStream in = url.openStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			String json = "";
			while (true) {
				String line = br.readLine();
				if (line == null) break;
				
				json += line;
			}
			System.out.println(json);
			
			Gson gson = new Gson();
			BlogJsonVO jsonVO = gson.fromJson(json, BlogJsonVO.class);
			
			List<BlogJsonItemVO> item = jsonVO.getChannel().getItem();
			System.out.println("=====================================");
			System.out.println("다음 블로그 정보");
			for (BlogJsonItemVO blogVO : item) {
				System.out.println("=====================================");
				System.out.println(blogVO.getTitle());
				System.out.println(blogVO.getLink());
			}
			System.out.println("=====================================");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}












