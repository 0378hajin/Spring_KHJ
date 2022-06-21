package edu.Board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.Board.serivce.BoardService;
import edu.Board.serivce.UserService;
import edu.Board.vo.BoardVo;
import edu.Board.vo.SearchVo;
import edu.Board.vo.UserVo;

@RequestMapping(value = "/ajax")
@Controller
public class AjaxController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/sample.do")
	public String sample() {
		
		return "ajax/sample";
	}
	
	//@ResponseBody은 응답하려는 곳에 응답 데이터를 보내라는 어노테이션, dispatcherServlet으로 돌아가면 안된다.
	@ResponseBody
	@RequestMapping(value = "/userInfo.do", produces = "application/json;charset=utf8")
	public UserVo userInfo(HttpServletRequest request, HttpSession session) {
		
		session = request.getSession();
		UserVo login = (UserVo)session.getAttribute("login");
		
		UserVo vo = userService.selectByMypage(login.getMidx());
		
		/*
		String result = "유저정보=> id : " + vo.getId()+ ", password : " + vo.getPassword() + ", name : " + vo.getName() + ", midx : " + vo.getMidx();
		
		return result;
		*/
		
		return vo;
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/goText.do", produces = "application/text;charset=utf8")
	public String goText(String text) {
		
		return text+" / ???:누구냐 넌";
	}
	@ResponseBody
	@RequestMapping(value = "/boardList.do", produces = "application/json;charset=utf8")
	public List<BoardVo> boardList(SearchVo vo){
		
		
		
		return boardService.list(vo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/BoardView.do", produces = "application/json;charset=utf8")
	public BoardVo BoardView(int bidx, Model model) {
		
		return boardService.selectOne(bidx);
	}
	
}
