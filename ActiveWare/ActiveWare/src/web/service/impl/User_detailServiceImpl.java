package web.service.impl;

import javax.servlet.http.HttpServletRequest;

import web.dao.face.User_basicDao;
import web.dao.face.User_detailDao;
import web.dao.impl.User_basicDaoImpl;
import web.dao.impl.User_detailDaoImpl;
import web.dto.User_detail;
import web.service.face.User_detailService;

public class User_detailServiceImpl implements User_detailService {

	private User_basicDao user_basicDao = new User_basicDaoImpl();
	private User_detailDao user_detailDao = new User_detailDaoImpl();
	
	@Override
	public User_detail getUser_detail(HttpServletRequest req) {
		
		return null;
	}
	@Override
	public void joinUser_detail(User_detail user_detail) {
		
		
	}
	@Override
	public void modifyUser_detail(User_detail user_detail) {
		
	}
}