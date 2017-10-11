package kr.co.mlec.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/interceptor")
public class MyPage {
	@RequestMapping("/myPage.do")
	public void info(Model model) {
		model.addAttribute("msg", "반갑습니다");
	}
}
