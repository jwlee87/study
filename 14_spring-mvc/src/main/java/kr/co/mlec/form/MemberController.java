package kr.co.mlec.form;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/form")
public class MemberController {
	@RequestMapping("/joinForm.do")
	public String joinForm() {
		return "form/joinForm";
	}

	/*
	 * @RequestMapping("/join.do") public String join(HttpServletRequest
	 * request) { String id = request.getParameter("id"); String password =
	 * request.getParameter("password"); String name =
	 * request.getParameter("name"); MemberVO member = new MemberVO();
	 * member.setId(id); member.setPassword(password); member.setName(name);
	 * request.setAttribute("member", member); return "form/memberInfo"; }
	 */

	/*
	 * @RequestMapping("/join.do") public String join(HttpServletRequest
	 * request, @RequestParam("id") String id, @RequestParam("password") String
	 * pass,
	 * 
	 * @RequestParam("name") String name) { MemberVO member = new MemberVO();
	 * member.setId(id); member.setPassword(pass); member.setName(name);
	 * request.setAttribute("member", member); return "form/memberInfo"; }
	 */

	/*
	 * @RequestMapping("/join.do") public String join(MemberVO member) {
	 * System.out.println(member.getId());
	 * System.out.println(member.getPassword());
	 * System.out.println(member.getName()); return "form/memberInfo"; }
	 */

	/*
	 * @RequestMapping("/join.do") public String join(@ModelAttribute("member")
	 * MemberVO member) { System.out.println(member.getId());
	 * System.out.println(member.getPassword());
	 * System.out.println(member.getName()); return "form/memberInfo"; }
	 */

	/*
	 * @RequestMapping("/join.do") public ModelAndView join(MemberVO member) {
	 * ModelAndView mav = new ModelAndView();
	 * mav.setViewName("form/memberInfo"); mav.addObject("member", member);
	 * return mav; }
	 */
	
	/*
	@RequestMapping("/join.do")
	public String join(MemberVO member, Model model) {
		System.out.println(member.getId());
		System.out.println(member.getPassword());
		System.out.println(member.getName());
		model.addAttribute("msg", "가입이 완료되었습니다.");
		// return "form/joinForm";
		return "redirect:/form/joinForm.do";
	}
	 */
	
	@RequestMapping("/join.do")
	public String join(MemberVO member, RedirectAttributes attr) {
		System.out.println(member.getId());
		System.out.println(member.getPassword());
		System.out.println(member.getName());
		attr.addFlashAttribute("msg", "가입이 완료되었습니다.");
		return "redirect:/form/joinForm.do";
	}
}










