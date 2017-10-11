package kr.co.mlec.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.mlec.form.MemberVO;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO)session.getAttribute("user");
		if (member != null) {
			return true;
		}
		System.out.println("인터셉터에서 걸렸음");
		// 실 사용시에는 정확한 컨텍스트 경로를 포함한 로그인 경로를 설정해야 함
		response.sendRedirect("loginForm.do");
		return false;
	}
}
