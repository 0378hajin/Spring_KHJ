package edu.Board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.Board.vo.BoardVo;
import edu.Board.vo.SearchVo;

@Repository
//외부에 있는 자원과 연결한다라는 뜻을 가지고 있다.
public class BoardDAO {

	//쿼리를 자동으로 실행시켜주는 sqlSession
	@Autowired
	SqlSession sqlSession;

	private static final String namespace = "edu.Board.mapper.boardMapper";
	
	public List<BoardVo> selectAll(SearchVo searchvo){
		
		return sqlSession.selectList(namespace + ".selectAll",searchvo);
		
	}
	//insert, select, update는 int로 둘 수 있다.
	public int boardWrite(BoardVo vo) {

		return sqlSession.insert(namespace + ".boradWrite", vo);
	}
	
	public BoardVo selectOne(int bidx) {
		
		return sqlSession.selectOne(namespace + ".selectOne", bidx);
	}
}
