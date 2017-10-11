package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/test05")
public class Test05 extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 응답하려는 Content에 대한 타입을 설정
//		response.setContentType("text/html");  // 한글 깨짐
		
		// 1단계.  응답데이터에 대한 타입 설정
		response.setContentType("text/html; charset=utf-8");
		
		// 2단계. 사용자에게 데이터를 출력하기 위한 객체 얻기
//		OutputStream out = response.getOutputStream();  // byte 처리 : 이미지, 음악파일 등등..
		PrintWriter out = response.getWriter();
		
		// 3단계. 내용 출력
		out.println("<html>");
		out.println("<body>");
		out.println("	<h1>응답 성공</h1>");
		out.println("</body>");
		out.println("</html>");
		
		// 4단계. 출력객체 닫기
		out.close();
	}
}






















