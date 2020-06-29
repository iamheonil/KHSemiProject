package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.dao.face.AdminAddressDao;
import web.dbutil.JDBCTemplate;
import web.dto.User_basic_detail;
import web.dto.User_detail;
import web.util.ad_Paging;

public class AdminAddressDaoImpl implements AdminAddressDao {

	private Connection conn = null; //DB연결 객체
	private PreparedStatement ps = null; //SQL수행 객체
	private ResultSet rs = null; //SQL조회 결과 객체

	@Override
	public List<User_detail> selectAll() {
		
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
		
		//SQL 작성
		String sql = "";
		sql += "SELECT * FROM user_detail";
		sql += " ORDER BY usernum DESC";
		
		//결과 저장할 List
		List<User_detail> detailList = new ArrayList<>();
		
		try {
			//SQL 수행객체
			ps = conn.prepareStatement(sql);
			
			//SQL 수행 및 결과 집합 저장
			rs = ps.executeQuery();
			
			//조회 결과 처리
			while(rs.next()) {
				User_detail U = new User_detail();
				
				//결과값 한 행 처리
				U.setUsernum(rs.getInt("usernum"));
				U.setUserid(rs.getInt("userid"));
				U.setUserphoto_origin(rs.getString("userphoto_origin"));
				U.setUserphoto_rename(rs.getString("userphoto_rename"));
				U.setUserpw(rs.getString("userpw"));
				U.setUserbirth(rs.getNString("userbirth"));
				U.setUsergender(rs.getString("usergender"));
				U.setUserphone(rs.getString("userphone"));
				U.setUseraddr(rs.getString("useraddr"));
				
				//리스트에 결과값 저장
				detailList.add(U);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		return detailList;
	}

	@Override
	public int selectCntAll() {
		
		conn = JDBCTemplate.getConnection(); //DB연결
		
		//SQL 작성
		String sql = "";
		sql += "SELECT count(*) FROM user_detail";
		
		//최종 결과값
		int cnt = 0;
		
		try {
			//SQL 수행객체
			ps = conn.prepareStatement(sql);
			
			//SQL수행 및 결과집합 반환
			rs = ps.executeQuery();
			
			//조회결과 처리
			while(rs.next()) {
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return cnt;
	}

	@Override
	public int selectCntAll(String search) {
		
		conn = JDBCTemplate.getConnection(); //DB연결
		
		//SQL 작성
		String sql = "";
		sql += "SELECT count(*) cnt FROM (";
		sql += "		SELECT";
		sql += "   		 UB.userid, username, userrank, dept";
		sql += "		    , usernum, userphoto_origin, userphoto_rename";
		sql += "		    , userpw, userbirth, usergender, userphone, useraddr";
		sql += "		 FROM user_basic UB, user_detail UD";
		sql += "		 WHERE UB.userid = UD.userid";
		if( null != search && !"".equals(search) ) {
			sql += "       	AND username LIKE ?";
		}
		sql += " )";
		
		//최종 결과값
		int cnt = 0;
		
		try {
			//SQL 수행객체
			ps = conn.prepareStatement(sql);
			
			if( null != search && !"".equals(search) ) {
			ps.setString(1, "%"+search+"%");
			}
				
			//SQL수행 및 결과집합 반환
			rs = ps.executeQuery();
			
			//조회결과 처리
			while(rs.next()) {
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return cnt;
	}

	@Override
	public List<User_basic_detail> selectAll(ad_Paging paging) {
		
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
		
		//SQL 작성
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, R.* FROM (";
		sql += "		SELECT";
		sql += "   		 UB.userid, username, userrank, dept";
		sql += "		    , usernum, userphoto_origin, userphoto_rename";
		sql += "		    , userpw, userbirth, usergender, userphone, useraddr";
		sql += "		 FROM user_basic UB, user_detail UD";
		sql += "		 WHERE UB.userid = UD.userid";
		if( null != paging.getSearch() && !"".equals(paging.getSearch()) ) {
		sql += "       	AND username LIKE ?";
		}
		sql += "		 ORDER BY UB.userid DESC";
		sql += "    )R";
		sql += " ) RES";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		//결과 저장할 List
		List<User_basic_detail> userList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL 수행객체
		
			int index = 1;
			
			if( null != paging.getSearch() && !"".equals(paging.getSearch()) ) {
			ps.setString(index++, "%" + paging.getSearch() + "%");
			}
			ps.setInt(index++, paging.getStartNo());	//페이징 게시글 시작 번호
			ps.setInt(index++, paging.getEndNo());	//페이징 게시글 끝 번호
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			while(rs.next()) {
				User_basic_detail D = new User_basic_detail(); //결과값 저장 객체
				
				D.setDept(rs.getString("dept"));
				D.setUserrank(rs.getString("userrank"));
				D.setUsername(rs.getString("username"));
				D.setUsergender(rs.getString("usergender"));
				D.setUserphone(rs.getString("userphone"));
				D.setUseraddr(rs.getString("useraddr"));
				
				//리스트에 결과값 저장
				userList.add(D);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		return userList;
		
	}
	
	

}
