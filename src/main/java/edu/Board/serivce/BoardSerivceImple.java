package edu.Board.serivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.Board.dao.BoardDAO;
import edu.Board.vo.BoardVo;
import edu.Board.vo.SearchVo;

@Service
public class BoardSerivceImple implements BoardService {

	@Autowired
	BoardDAO boardDao;
	
	@Override
	public List<BoardVo> list(SearchVo searchvo) {

		return boardDao.selectAll(searchvo);
	}

	@Override
	public int boardWrite(BoardVo vo) {
		return boardDao.boardWrite(vo);
	}

	@Override
	public BoardVo selectOne(int bidx) {
		
		return boardDao.selectOne(bidx);
	}

}
