package ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/11_ajax/exam06")
public class Exam06 extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String json = "";
		json += "[";
		json += "	{\"name\": \"윤균상\", \"age\": 33},";
		json += "	{\"name\": \"김상중\", \"age\": 57}";
		json += "]";
		out.println(json);
		out.close();
	}
	
}













