package web.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dao.face.User_basicDao;
import web.dao.face.User_detailDao;
import web.dao.impl.User_basicDaoImpl;
import web.dao.impl.User_detailDaoImpl;
import web.dbutil.JDBCTemplate;
import web.dto.User_basic;
import web.dto.User_detail;
import web.service.face.User_basicService;

public class User_basicServiceImpl implements User_basicService {
	
	private User_basicDao user_basicDao = new User_basicDaoImpl();
	private User_detailDao user_detailDao = new User_detailDaoImpl();
	private User_basic user_basic = new User_basic();
	private User_detail user_detail = new User_detail();
	
	@Override
	public void insertUser_basic(HttpServletRequest req) {
		
	}
	
	// 회원가입 전 사번,이름 확인
	@Override
	public int user_basicCheck(User_basic user_basic) {
		
		return user_basicDao.selectCntUserByIdName(user_basic);
	}
	
	// 로그인
	@Override
	public boolean userLogin(User_detail user_detail) {
		
		
		if(user_detailDao.selectCntByuserIdPw(user_detail) > 0) {
			return true;
		} else {
			return false;
		}
		
		
	}
	
	
	@Override
	public User_basic selectAllByUserid(User_basic user_basic) {
		
		return user_basicDao.selectById(user_basic);
	}
	
	@Override
	public User_basic getUser_basic(HttpServletRequest req) {
		
		// 파싱
		if(req.getParameter("userid")!=null && !"".equals(req.getParameter("userid"))) {
			user_basic.setUserid(Integer.parseInt(req.getParameter("userid")));
		}
		
		if(req.getParameter("username")!=null && !"".equals(req.getParameter("username"))) {
			user_basic.setUsername(req.getParameter("username"));
		}
		
		if(req.getParameter("userrank")!=null && !"".equals(req.getParameter("userrank"))) {
			user_basic.setUserrank(req.getParameter("userrank"));
		}
		
		if(req.getParameter("deptno")!=null && !"".equals(req.getParameter("deptno"))) {
			user_basic.setUserrank(req.getParameter("deptno"));
		}
		
		return user_basic;
	}
	
	@Override
	public void modifyUser_basic(User_basic user_basic) {
		
		
	}
	@Override
	public void deleteUser(User_basic user_basic) {
		
		
	}
	@Override
	public List<User_basic> selectUser_basic(HttpServletRequest req) {
		
		return null;
	}

}