package jsp.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/jsp/session/logout")
public class Logout extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션을 삭제 한 후 main.jsp 페이지로 이동시킨다.
		HttpSession session = request.getSession();
		session.invalidate();
		
		response.sendRedirect("main.jsp");
	}
	
}











