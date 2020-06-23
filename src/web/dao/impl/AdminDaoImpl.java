package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import web.dao.face.AdminDao;
import web.dto.Admin;
import web.dao.face.AdminDao;
import web.dao.impl.AdminDaoImpl;

public class AdminDaoImpl implements AdminDao {
	
	private Connection conn = null; //DB연결 객체
	private PreparedStatement ps = null; //SQL수행 객체
	private ResultSet rs = null; //SQL조회 결과 객체



	@Override
	public Admin selectAdminByAdminnum(Admin adminnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectCntAdminByAdminnumAdminpw(Admin adminnum) {
		// TODO Auto-generated method stub
		return 0;
	}

}
