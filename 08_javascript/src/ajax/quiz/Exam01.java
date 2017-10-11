package ajax.quiz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/11_ajax/quiz/exam01")
public class Exam01 extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/plain; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			Exam01VO exam = new Exam01DAO().selectMemberById(request.getParameter("id"));
			out.println(
				exam == null ? "사용가능한 아이디 입니다." 
						     : "이미 사용중인 아이디 입니다."
			);
			out.close();
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
}