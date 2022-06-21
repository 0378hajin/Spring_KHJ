package edu.Board.serivce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.Board.dao.UserDAO;
import edu.Board.vo.UserVo;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	UserDAO userDao;
	
	@Override
	public int insertUser(UserVo vo) {
		int result = userDao.insert(vo);
		return result;
	}

	@Override
	public UserVo selectByLogin(UserVo vo) {
		
		
		return userDao.selectByLogin(vo);
	}

	@Override
	public UserVo selectByMypage(int midx) {
		
		return userDao.selectByMypage(midx);
	}

	@Override
	public int modify(UserVo vo) {

		return userDao.modify(vo);
	}




}
