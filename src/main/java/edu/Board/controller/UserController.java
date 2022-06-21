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

//�����θ� �������ش�.
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
		//ȭ�鿡 �ڷḦ ������ ���� �ݵ�� model�� �Ű������� ������ �־���Ѵ�.
		// �Ķ���͸� �޼���� ���� �޴� ����� �Ű������� ���� �Ķ���� Ű�� ���ߴ� �����
		// �Ű����� Vo�� �ʵ� ���� ���ߴ� ����� �ִ�.
		// �Ѱܾ��� ���� ���� ��� Vo�� �ѹ��� ���� �ް� �� Vo�� �Ű������� �޾ƿ´�.
		
		//model.addAttribute("name", name);
		//model.addAttribute("age", age);
		//model.addAttribute("addr", addr);
		//model.addAttribute("phone", phone);
		
		model.addAttribute("vo", vo);
		
		
		return "user/info";
	}
	//�޼��尡 �����ε� �Ǿ� ���� �� ��ũ�� ������ ���� ������ get����� ���� ȣ��ȴ�.
	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public String join() {
		
		return "user/join";
	} 
	//ȸ������ ��ư�� ������ �� post ������� �ѱ�Ƿ� post�޼��忡 �ش��ϴ� ������ ����ȴ�.
	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	public String join(UserVo vo) {
		
		int result = userService.insertUser(vo);
		
		return "redirect:/";
		//redirect �� ���� ���� ���ڿ��� redirect : Ű���� �ڷ� url��� ���� �ش�.
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	//session�� �Ű������� �޾ƿ;��Ѵ�.
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVo vo, HttpServletRequest request, HttpSession session) {
		
		UserVo user = userService.selectByLogin(vo); 
		
		if(user != null) {
			
			session = request.getSession();
			
			//���ǿ� ���� �α��� ��ü ����
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
		
		//�α��� ��ü�� ��������
		UserVo login  = (UserVo)session.getAttribute("login");
		//�α��� ��ü�� ������ �����ϱ�
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


