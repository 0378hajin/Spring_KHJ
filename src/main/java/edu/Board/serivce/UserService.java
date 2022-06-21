package edu.Board.serivce;

import edu.Board.vo.UserVo;

public interface UserService {
	
	int insertUser(UserVo vo);
	UserVo selectByLogin(UserVo vo);
	UserVo selectByMypage(int midx);
	int modify(UserVo vo);
}
	