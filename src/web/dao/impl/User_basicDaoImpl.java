package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.dao.face.User_basicDao;
import web.dbutil.JDBCTemplate;
import web.dto.User_basic;
import web.dto.User_detail;

public class User_basicDaoImpl implements User_basicDao {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public void insertUser_basic(User_basic user_basic) {
		
		   
		conn = JDBCTemplate.getConnection();

		// 다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "INSERT INTO User_basic(basicnum, userid, username, userrank, dept) ";
		sql += " VALUES (User_basic_seq.nextval, ?, ?, ?, ?)";

		try {
			// DB작업
			ps = conn.prepareStatement(sql);

			ps.setInt(1, user_basic.getUserid());
			ps.setString(2, user_basic.getUsername());
			ps.setString(3, user_basic.getUserrank());
			ps.setString(4, user_basic.getDept());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB객체 닫기
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public int selectCntUserByIdName(User_basic user_basic) {
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "SELECT count(*) FROM user_basic WHERE userid = ? AND username = ?";
		
		int cnt = 0; // 조회 개수
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, user_basic.getUserid());
			ps.setString(2, user_basic.getUsername());
			
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
	public User_basic selectCntFindId(User_basic user_basic) {
		
		return null;
	}

	@Override
	public User_basic updateUser_basic(User_basic user_basic) {
		
		conn = JDBCTemplate.getConnection();
	
		String sql = "";
		sql += "UPDATE User_basic SET";
		sql += "	username =?";
		sql += "	,userrank =?";
		sql += "	,dept =?";
		sql += " 	WHERE userid =?";
		

		try {
			// DB작업
			ps = conn.prepareStatement(sql);

			ps.setString(1, user_basic.getUsername());
			ps.setString(2, user_basic.getUserrank());
			ps.setString(3, user_basic.getDept());
			ps.setInt(4, user_basic.getUserid());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB객체 닫기
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		return user_basic;
		
		
	}

	@Override
	public void deleteUser_basic(User_detail User_detail) {
		
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "DELETE FROM USER_DETAIL WHERE USERID = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, User_detail.getUserid());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
	}

	@Override
	public List<User_basic> selectUser_basic(String search) {
		

		conn = JDBCTemplate.getConnection();
		List<User_basic> list = new ArrayList<>();
		
		User_basic user_basic = null;
		
		String sql = "";
		sql += "SELECT userid, username, userrank, dept FROM user_basic";
		sql += " WHERE 1=1";
		if( search != null && !"".equals(search)) {
		sql += " AND username LIKE ?";
		}
		sql += "	ORDER BY userid";
		
		try {
			ps = conn.prepareStatement(sql);
			
			if( search != null && !"".equals(search)) {
			ps.setString(1, "%"+search+"%");
			}
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				user_basic = new User_basic();
				
				user_basic.setUserid(rs.getInt("userid"));
				user_basic.setUsername(rs.getString("username"));
				user_basic.setUserrank(rs.getString("userrank"));
				user_basic.setDept(rs.getString("dept"));
				
				list.add(user_basic);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return list;
	}

	@Override
	public User_basic selectById(User_basic user_basic) {
		
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "SELECT * FROM user_basic WHERE userid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, user_basic.getUserid());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				user_basic = new User_basic();
				
//				user_basic.setBasicnum(rs.getInt("basicnum"));
				user_basic.setUserid(rs.getInt("userid"));
				user_basic.setUsername(rs.getString("username"));
				user_basic.setUserrank(rs.getString("userrank"));
				user_basic.setDept(rs.getString("dept"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		return user_basic;
	}

	@Override
	public void deleteUser_DetailList(User_detail user_detail) {
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "DELETE FROM User_detail WHERE userid =?";

		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, user_detail.getUserid());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	

		
	}

	@Override
	public int nextBasicnum() {
		// DB연결 객체
		conn = JDBCTemplate.getConnection();

		// SQL 작성
		String sql = "";
		sql += "SELECT User_basic_seq.nextval FROM dual";

		// 베이직 넘버 번호
		int basicnum = 0;

		try {
			ps = conn.prepareStatement(sql); // SQL수행 객체
			rs = ps.executeQuery(); // SQL 수행 및 결과집합 저장

			// 조회 결과 처리
			while (rs.next()) {
				basicnum = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		// 최종 결과 반환
		return basicnum;
	}

}