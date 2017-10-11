/*
 *  자바 클래스를 웹에서 호출가능하게 하려면
 *  Servlet 인터페이스의 타입으로 만들어야 한다.
 */
package servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Test01 implements Servlet {
	@Override
	public void destroy() { 
		System.out.println("서블릿이 메모리에서 해제될 때 호출");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("최초 한번만 호출되는 메서드 : init()");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("사용자 요청시마다 호출되는 메서드 : service()");
	}
}






