package edu.Board.serivce;

import java.util.List;

import edu.Board.vo.BoardVo;
import edu.Board.vo.SearchVo;

//interface�� ������̼��� ���� �ʴ´�.
public interface BoardService {
	public List<BoardVo> list(SearchVo searchvo);
	public int boardWrite(BoardVo vo);
	public BoardVo selectOne(int bidx);
}
