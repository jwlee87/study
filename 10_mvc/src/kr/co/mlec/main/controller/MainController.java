package kr.co.mlec.main.controller;

import org.springframework.mvc.Controller;
import org.springframework.mvc.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/main/main.do")
	public void main() throws Exception {}
}