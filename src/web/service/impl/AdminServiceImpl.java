package web.service.impl;

import javax.servlet.http.HttpServletRequest;

import web.dao.face.AdminDao;
import web.dao.impl.AdminDaoImpl;
import web.dto.Admin;
import web.service.face.AdminService;

public class AdminServiceImpl implements AdminService {
	
	private AdminDao adminDao = new AdminDaoImpl();

	@Override
	public Admin getLoginAdmin(HttpServletRequest req) {
		
		Admin admin = new Admin();
		
		
		return admin;
	}

	@Override
	public boolean login(Admin adminnum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Admin info(Admin adminnum) {
		// TODO Auto-generated method stub
		return null;
	}

}
