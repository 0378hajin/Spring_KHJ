package edu.Board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.Board.serivce.BoardService;
import edu.Board.vo.BoardVo;
import edu.Board.vo.SearchVo;
import edu.Board.vo.UserVo;

@RequestMapping (value = "/board")
@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/list.do")
	public String list(Model model, SearchVo searchvo) {
		//searchvo는 값이 없어도 항상 빈 값을 리턴하기 때문에 null값을 가지 않는다.
		List<BoardVo> list = boardService.list(searchvo);
		
		model.addAttribute("searchVo", searchvo);
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@RequestMapping(value = "/write.do", method = RequestMethod.GET)
	public String write() {
		
		return "board/write";
	}
	
	//HttpServletResponse response을 사용하면 화면에서도 alert를 띄울 수 있음
	@RequestMapping(value = "/write.do", method = RequestMethod.POST)
	public void write(BoardVo vo, HttpServletRequest request, HttpSession session, HttpServletResponse response) throws IOException {
		//request와 session은 로그인 정보를 받아오는 매개변수
		session = request.getSession();
		UserVo login = (UserVo)session.getAttribute("login");
		
		vo.setMidx(login.getMidx());
		
		int result = boardService.boardWrite(vo);
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter pw = response.getWriter();
		
		if(result <= 0) {
			//등록이 제대로 이루어지지 않음
			pw.append("<script>alert('작성이 정상적으로 등록되지 못했습니다. 다시 작성해주세요.');location.href = 'list.do'</script>");
			
			pw.flush();
		} else {
			pw.append("<script>alert('작성이 정상적으로 등록이 되었습니다.');location.href = 'list.do'</script>");
			
			pw.flush();
		}
		
	
	}
	@RequestMapping(value = "/view.do")
	public String view(int bidx, Model model) {
		
		BoardVo vo = boardService.selectOne(bidx);
		model.addAttribute("vo", vo);
		
		return "board/view";
	}
}
