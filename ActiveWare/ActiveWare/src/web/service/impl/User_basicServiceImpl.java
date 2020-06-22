package web.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dao.face.User_basicDao;
import web.dao.face.User_detailDao;
import web.dao.impl.User_basicDaoImpl;
import web.dao.impl.User_detailDaoImpl;
import web.dto.User_basic;
import web.service.face.User_basicService;

public class User_basicServiceImpl implements User_basicService {
	
	private User_basicDao user_basicDao = new User_basicDaoImpl();
	private User_detailDao user_detailDao = new User_detailDaoImpl();
	
	@Override
	public void insertUser_basic(User_basic user_basic) {
		
	}
	@Override
	public int user_basicCheck(User_basic user_basic) {
		
		return 0;
	}
	@Override
	public boolean userLogin(HttpServletRequest req) {
		
		return false;
	}
	@Override
	public User_basic findId(User_basic user_basic) {
		
		return null;
	}
	@Override
	public User_basic getUser_basic(HttpServletRequest req) {
		
		return null;
	}
	@Override
	public void modifyUser_basic(User_basic user_basic) {
		
		
	}
	@Override
	public void deleteUser(User_basic user_basic) {
		
		
	}
	@Override
	public List<User_basic> selectUser_basic() {
		
		return null;
	}

}