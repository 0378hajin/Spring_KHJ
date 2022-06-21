package edu.Board.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.Board.vo.UserVo;

@Repository
public class UserDAO {

	@Autowired
	SqlSession sqlSession;
	
	public int insert(UserVo vo) {
		
		int result = sqlSession.insert("edu.Board.mapper.UserMapper.insert", vo);
		
		
		return result;
	}
	
	public UserVo selectByLogin(UserVo vo) {
		
		
		
		// ���࿡ �������� ��ȸ �Ǹ� ������ �߻��Ѵ�. �ݵ�� �ѰǸ� ��ȸ�� �Ǿ���Ѵ�.
		return sqlSession.selectOne("edu.Board.mapper.UserMapper.selectByLogin", vo);
	}
	
	public UserVo selectByMypage(int midx) {
		
		return sqlSession.selectOne("edu.Board.mapper.UserMapper.selectByMypage", midx);
	}
	
	public int modify(UserVo vo) {
		
		return sqlSession.update("edu.Board.mapper.UserMapper.modify", vo);
	}
}
