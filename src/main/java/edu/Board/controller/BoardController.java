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
		//searchvo�� ���� ��� �׻� �� ���� �����ϱ� ������ null���� ���� �ʴ´�.
		List<BoardVo> list = boardService.list(searchvo);
		
		model.addAttribute("searchVo", searchvo);
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@RequestMapping(value = "/write.do", method = RequestMethod.GET)
	public String write() {
		
		return "board/write";
	}
	
	//HttpServletResponse response�� ����ϸ� ȭ�鿡���� alert�� ��� �� ����
	@RequestMapping(value = "/write.do", method = RequestMethod.POST)
	public void write(BoardVo vo, HttpServletRequest request, HttpSession session, HttpServletResponse response) throws IOException {
		//request�� session�� �α��� ������ �޾ƿ��� �Ű�����
		session = request.getSession();
		UserVo login = (UserVo)session.getAttribute("login");
		
		vo.setMidx(login.getMidx());
		
		int result = boardService.boardWrite(vo);
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter pw = response.getWriter();
		
		if(result <= 0) {
			//����� ����� �̷������ ����
			pw.append("<script>alert('�ۼ��� ���������� ��ϵ��� ���߽��ϴ�. �ٽ� �ۼ����ּ���.');location.href = 'list.do'</script>");
			
			pw.flush();
		} else {
			pw.append("<script>alert('�ۼ��� ���������� ����� �Ǿ����ϴ�.');location.href = 'list.do'</script>");
			
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
