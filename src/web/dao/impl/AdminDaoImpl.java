package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web.dao.face.AdminDao;
import web.dto.Admin;
import web.dao.face.AdminDao;
import web.dao.impl.AdminDaoImpl;
import web.dbutil.JDBCTemplate;

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
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "SELECT count(*) FROM admin WHERE adminid = ? AND adminpw = ?";
		
		int cnt = 0; // 조회 개수
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, adminnum.getAdminid());
			ps.setString(2, adminnum.getAdminpw());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
			JDBCTemplate.close(rs);
		}
		return cnt;
	}

}
