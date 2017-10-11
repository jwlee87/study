package network.api;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test02 {
	public static void main(String[] args) {
		String requestUrl = "https://apis.daum.net/search/blog";
		String parameter  = "?apikey=yourApikey&q=java&result=3&output=xml";
		
		String apiUrl = requestUrl + parameter;
		System.out.println(apiUrl);
		try {
			URL url = new URL(apiUrl);
			InputStream in = url.openStream();
			
			// Dom Parser에게 입력 스트림 처리를 넘기기
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document dom = builder.parse(in);
			
			NodeList list = dom.getElementsByTagName("item");
			int len = list.getLength();
			
			List<BlogItemVO> blogs = new ArrayList<>();
			for (int i = 0; i < len; i++) {
				BlogItemVO blogVO = new BlogItemVO();
				
				Node cNode = list.item(i);
				NodeList chList = cNode.getChildNodes();
				int chLen = chList.getLength();
				for (int j = 0; j < chLen; j++) {
					Node chNode = chList.item(j);
					String chName = chNode.getNodeName();
					if ("#text".equals(chName)) continue;
					
					String value = chNode.getTextContent();
					switch (chName) {
					case "title": blogVO.setTitle(value); break;
					case "description": blogVO.setDescription(value); break;
					case "link": blogVO.setLink(value); break;
					case "author": blogVO.setAuthor(value); break;
					case "comment": blogVO.setComment(value); break;
					case "pubDate": blogVO.setPubDate(value); break;
					}
				}
				
				blogs.add(blogVO);
			}
			
			System.out.println("---------------------------");
			System.out.println("블로그 검색 결과");
			for (BlogItemVO blog : blogs) {
				System.out.println("---------------------------");
				System.out.println(blog.getTitle());
				System.out.println(blog.getDescription());
				System.out.println(blog.getLink());
				System.out.println(blog.getAuthor());
				System.out.println(blog.getComment());
				System.out.println(blog.getPubDate());
			}
			System.out.println("---------------------------");			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}












