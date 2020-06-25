package web.service.impl;

import javax.servlet.http.HttpServletRequest;

import web.dao.face.AdminDao;
import web.dao.impl.AdminDaoImpl;
import web.dto.Admin;
import web.service.face.AdminService;

public class AdminServiceImpl implements AdminService {
	
	private AdminDao adminDao = new AdminDaoImpl();
	private Admin admin = null;
	
	@Override
	public Admin getLoginAdmin(HttpServletRequest req) {

		admin = new Admin();
		
		if(req.getParameter("adminid") != null && !"".equals(req.getParameter("adminid"))) {
			admin.setAdminid(req.getParameter("adminid"));;
		}
		if(req.getParameter("adminpw") != null && !"".equals(req.getParameter("adminpw"))) {
			admin.setAdminpw(req.getParameter("adminpw"));;
		}
		
		return admin;
	}

	@Override
	public boolean login(Admin admin) {
		
		if(adminDao.selectCntAdminByAdminnumAdminpw(admin) > 0) {
			return true; // 관리자 로그인 성공
		} else {
			return false; // 관리자 로그인 실패
		}
	}

	@Override
	public Admin info(Admin adminnum) {
		// TODO Auto-generated method stub
		return null;
	}

}
