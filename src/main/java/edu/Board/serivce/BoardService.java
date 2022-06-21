package edu.Board.serivce;

import java.util.List;

import edu.Board.vo.BoardVo;
import edu.Board.vo.SearchVo;

//interface는 어노테이션을 달지 않는다.
public interface BoardService {
	public List<BoardVo> list(SearchVo searchvo);
	public int boardWrite(BoardVo vo);
	public BoardVo selectOne(int bidx);
}
