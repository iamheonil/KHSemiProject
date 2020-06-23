package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import web.dao.face.User_detailDao;
import web.dbutil.JDBCTemplate;
import web.dto.User_detail;

public class User_detailDaoImpl implements User_detailDao {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public int selectCntByuserIdPw(User_detail user_detail) {
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "SELECT count(*) FROM user_detail";
		sql += " WHERE userid = ?";
		sql += " AND userpw = ?";
		
		// 조회결과
		int cnt = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, user_detail.getUserid());
			ps.setString(2, user_detail.getUserpw());
			
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return cnt;
	}

	@Override
	public void insertUser_detail(User_detail user_detail) {
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "INSERT INTO user_detail(usernum, userid, userphoto_origin, userphoto_rename, userpw, userbirth, usergender, userphone, useraddr)";
		sql += " VALUES(user_detail_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, user_detail.getUserid());
			ps.setString(2, user_detail.getUserphoto_origin());
			ps.setString(3, user_detail.getUserphoto_rename());
			ps.setString(4, user_detail.getUserpw());
			ps.setString(5, user_detail.getUserbirth());
			ps.setString(6, user_detail.getUsergender());
			ps.setString(7, user_detail.getUserphone());
			ps.setString(8, user_detail.getUseraddr());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
	}

	@Override
	public void updateUser_detail(User_detail user_detail) {
		
	}

	@Override
	public void deleteUser_detail(User_detail user_detail) {
		
	}

	@Override
	public List<User_detail> selectUser_detail() {
		
		return null;
	}
	
	@Override
	public void updatePassword(User_detail user_detail) {
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "UPDATE user_detail SET userpw = ? WHERE userid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user_detail.getUserpw());
			ps.setInt(2, user_detail.getUserid());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
	}

}