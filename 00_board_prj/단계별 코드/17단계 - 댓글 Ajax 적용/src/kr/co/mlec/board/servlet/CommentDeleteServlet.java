package kr.co.mlec.board.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.mlec.board.dao.BoardDAO;

@WebServlet("/board/commentDelete")
public class CommentDeleteServlet extends HttpServlet {

	private BoardDAO dao;
	public CommentDeleteServlet() {
		this.dao = new BoardDAO();
	}
	
	@Override
	public void service(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int no = Integer.parseInt(request.getParameter("no"));
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		
		dao.deleteBoardComment(commentNo);
		
		response.setContentType("text/json; charset=utf-8"); 
		PrintWriter out = response.getWriter();
		
		out.println(new Gson().toJson(dao.selectBoardCommentByNo(no)));
	}
}



















