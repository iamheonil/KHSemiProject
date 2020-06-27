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
		
		
			System.out.println("가입하는 정보" + user_detail);
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
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "UPDATE user_detail SET userpw = ?";
		if(user_detail.getUserphoto_rename() != null && !"".equals(user_detail.getUserphoto_rename())) {
			sql += " , userphoto_rename = ?";
		}
		if(user_detail.getUseraddr() != null && !"".equals(user_detail.getUseraddr())) {
			sql += " , useraddr = ?";
		}
		if(user_detail.getUserphone() != null && !"".equals(user_detail.getUserphone())) {
			sql += " , userphone = ?";
		}
		sql += " WHERE userid = ?";
		
		
		int index = 1;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(index++, user_detail.getUserpw());
			if(user_detail.getUserphoto_rename() != null && !"".equals(user_detail.getUserphoto_rename())) {
				ps.setString(index++, user_detail.getUserphoto_rename());
			}
			if(user_detail.getUseraddr() != null && !"".equals(user_detail.getUseraddr())) {
				ps.setString(index++, user_detail.getUseraddr());
			}
			if(user_detail.getUserphone() != null && !"".equals(user_detail.getUserphone())) {
				ps.setString(index++, user_detail.getUserphone());
			}
			ps.setInt(index++, user_detail.getUserid());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
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

	@Override
	public User_detail selectUser_detailById(User_detail user_detail) {
		conn = JDBCTemplate.getConnection();
		
		String sql = "SELECT * FROM user_detail WHERE userid = ?";
		
		System.out.println("올까?");
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, user_detail.getUserid());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				user_detail.setUserid(rs.getInt("userid"));
				user_detail.setUserphoto_rename(rs.getString("userphoto_rename"));
				user_detail.setUserbirth(rs.getString("userbirth"));
				user_detail.setUsergender(rs.getString("usergender"));
				user_detail.setUserphone(rs.getString("userphone"));
				user_detail.setUseraddr(rs.getString("useraddr"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return user_detail;
	}
}