package kr.co.mlec.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.mlec.repository.mapper.LoginMapper;
import kr.co.mlec.repository.vo.MemberVO;

@Controller
public class LoginController {
	
	@Autowired
	private LoginMapper dao;

	@RequestMapping("/login/logout.do")
	public String logout(HttpSession session) throws Exception {
		//세션을 삭제한 후 main.jsp 페이지로 이동시킨다.
		session.invalidate();//세션삭제
		return "redirect:/main/main.do";
	}
	
	@RequestMapping("/login/login.do")
	public String login(
			String id, String password, HttpSession session,
			RedirectAttributes attr) throws Exception {

		MemberVO member = dao.getMemberInfo(id);
		if(member == null) {
			attr.addAttribute("msg", "입력하신 정보가 올바르지 않습니다.");
			return "redirect:/login/loginForm.do";
		}
		
		if(id.equals(member.getUserId()) && password.equals(member.getPassword())) {
			
			MemberVO login = new MemberVO();
			login.setUserId(member.getUserId());
			login.setPassword(member.getPassword());
			login.setEmail(member.getEmail());
			
			session.setAttribute("user", member);
			return "redirect:/main/main.do";
		}
		else {
			attr.addAttribute("msg", "입력하신 정보가 올바르지 않습니다.");
			return "redirect:/login/loginForm.do";
		}
	}
}












