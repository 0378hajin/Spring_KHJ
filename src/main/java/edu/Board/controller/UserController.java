package edu.Board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.Board.serivce.UserService;
import edu.Board.vo.UserVo;

//공통경로를 선언해준다.
@RequestMapping(value = "/user")
@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/register.do", method = RequestMethod.GET)
	public String register(Model model) {
		
		
		
		return "user/register";
	}
	
	@RequestMapping(value = "/info.do", method = RequestMethod.POST)
	public String info(UserVo vo, Model model) {
		//화면에 자료를 전송할 때는 반드시 model을 매개변수로 가지고 있어야한다.
		// 파라미터를 메서드로 전달 받는 방법은 매개변수의 명을 파라미터 키와 맞추는 방법과
		// 매개변수 Vo의 필드 명을 맞추는 방법이 있다.
		// 넘겨야할 값이 많을 경우 Vo로 한번에 값을 받고 그 Vo를 매개변수로 받아온다.
		
		//model.addAttribute("name", name);
		//model.addAttribute("age", age);
		//model.addAttribute("addr", addr);
		//model.addAttribute("phone", phone);
		
		model.addAttribute("vo", vo);
		
		
		return "user/info";
	}
	//메서드가 오버로딩 되어 있을 때 링크로 들어오는 것은 무조건 get방식이 먼저 호출된다.
	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public String join() {
		
		return "user/join";
	} 
	//회원가입 버튼을 눌렀을 때 post 방식으로 넘기므로 post메서드에 해당하는 구문이 실행된다.
	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	public String join(UserVo vo) {
		
		int result = userService.insertUser(vo);
		
		return "redirect:/";
		//redirect 할 때는 리턴 문자열에 redirect : 키워드 뒤로 url경로 값을 준다.
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	//session은 매개변수로 받아와야한다.
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVo vo, HttpServletRequest request, HttpSession session) {
		
		UserVo user = userService.selectByLogin(vo); 
		
		if(user != null) {
			
			session = request.getSession();
			
			//세션에 담을 로그인 객체 색성
			UserVo login = new UserVo();
			login.setMidx(user.getMidx());
			login.setId(user.getId());
			login.setName(user.getName());
			 
			session.setAttribute("login", login);
			return "redirect:/";
		}else {
			return "redirect:/user/login.do";
		}
		
	}
	
	@RequestMapping(value = "/logout.do")
	public String logout(HttpServletRequest request, HttpSession session) {
		
		request.getSession();
		session.invalidate();
		
		/*
		UserVo vo = (UserVo)session.getAttribute("login");
		int midx = vo.getMidx();
		*/
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/mypage.do")
	public String myPage(HttpServletRequest request, HttpSession session, Model model) {
		

		session = request.getSession();
		
		//로그인 객체를 꺼내오기
		UserVo login  = (UserVo)session.getAttribute("login");
		//로그인 객체의 상세정보 추출하기
		UserVo vo = userService.selectByMypage(login.getMidx());
		
		model.addAttribute("vo", vo);
		
		return "user/mypage";
	}
	
	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public String modify(int midx, Model model) {
		
		UserVo vo = userService.selectByMypage(midx);
		
		model.addAttribute("vo", vo);
		
		return "user/modify";
	}
	
	@RequestMapping(value = "/modify.do", method = RequestMethod.POST)
	public String modify(UserVo vo) {
		
		int result = userService.modify(vo);
		
		return "redirect:/user/mypage.do";
	}
}


