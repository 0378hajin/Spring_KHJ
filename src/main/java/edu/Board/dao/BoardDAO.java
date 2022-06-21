package edu.Board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.Board.vo.BoardVo;
import edu.Board.vo.SearchVo;

@Repository
//�ܺο� �ִ� �ڿ��� �����Ѵٶ�� ���� ������ �ִ�.
public class BoardDAO {

	//������ �ڵ����� ��������ִ� sqlSession
	@Autowired
	SqlSession sqlSession;

	private static final String namespace = "edu.Board.mapper.boardMapper";
	
	public List<BoardVo> selectAll(SearchVo searchvo){
		
		return sqlSession.selectList(namespace + ".selectAll",searchvo);
		
	}
	//insert, select, update�� int�� �� �� �ִ�.
	public int boardWrite(BoardVo vo) {

		return sqlSession.insert(namespace + ".boradWrite", vo);
	}
	
	public BoardVo selectOne(int bidx) {
		
		return sqlSession.selectOne(namespace + ".selectOne", bidx);
	}
}
