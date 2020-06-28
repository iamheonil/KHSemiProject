package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import web.dao.face.AdminBoardDao;
import web.dao.face.AdminDocumentDao;
import web.dbutil.JDBCTemplate;
import web.dto.Board;
import web.util.SearchPaging;
import web.util.ad_B_Paging;
import web.util.ad_D_paging;

public class AdminDocumentDaoImpl implements AdminDocumentDao {
	
	private Connection conn = null; //DB연결
	private PreparedStatement ps = null; //SQL수행객체
	private ResultSet rs = null; //조회 결과반환 객체


	@Override
	public int selectDocumentSearchCntAll(String search, String startDate, String endDate) {
		conn = JDBCTemplate.getConnection();
		
		// 임시저장함(검색) 조회 개수 조회
		String sql = "";
		sql += "SELECT count(*) FROM document";
		sql += " WHERE NOT doc_state = '임시저장'";
		if(search != null && !"".equals(search)) { // 검색어 값에 따른 쿼리
		sql += " AND doc_title  LIKE ?";
		}
		if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
		sql += " AND document.doc_date BETWEEN ? AND ?";
		}
		
		int cnt = 0; // 결과조회개수
		
		int index = 1;
		try {
			ps = conn.prepareStatement(sql);
			
			if(search != null && !"".equals(search)) {
			ps.setString(index++, "%"+search+"%");
			}
			if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
				ps.setString(index++, startDate);
				ps.setString(index++, endDate);
			}
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("문서등록대장 검색 조회 결과 개수" + cnt);
		return cnt;
	}
	
	
	@Override
	public ArrayList<Map<String, Object>> selectDocumentAll(ad_D_paging paging, String startDate, String endDate) {
		conn = JDBCTemplate.getConnection();
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		// 문서등록대장
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, D.doc_num, D.doc_date, D.doc_title, D.dept, D.userrank, D.username, D.doc_state, D.doc_emergency FROM (";
		sql += "	SELECT * FROM document";
		sql += "	JOIN user_basic U on U.userid = document.userid";
		sql += "	WHERE NOT doc_state = '임시저장'";
		if(paging.getSearch() != null && !"".equals(paging.getSearch())) {
		sql += "	AND document.doc_title  LIKE ?";
		}
		if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
		sql += "			AND document.doc_date BETWEEN ? AND ?";
		}
		sql += "	ORDER BY document.doc_num DESC";
		sql += " 	)D";
		sql += " )";
		sql += "WHERE rnum BETWEEN ? AND ?";
		
		int index=1;
		try {
			ps = conn.prepareStatement(sql);
			
			if(paging.getSearch() != null && !"".equals(paging.getSearch())) {
				ps.setString(index++, "%"+paging.getSearch()+"%");
			}
			if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
				ps.setString(index++, startDate);
				ps.setString(index++, endDate);
			}
			ps.setInt(index++, paging.getStartNo());
			ps.setInt(index++, paging.getEndNo());
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Map<String, Object> d = new HashMap<String, Object>(); //결과값 저장 객체
		 		
				
				//결과값 한 행 처리
				d.put("doc_num", rs.getInt("doc_num"));
				d.put("doc_date", rs.getDate("doc_date"));
				d.put("doc_title", rs.getString("doc_title"));
				d.put("dept", rs.getString("dept"));
				d.put("userrank", rs.getString("userrank"));
				d.put("username", rs.getString("username"));
				d.put("doc_state", rs.getString("doc_state"));
				d.put("doc_emergency", rs.getString("doc_emergency"));
				
				//리스트에 결과값 저장
				list.add(d);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
			
		return list;
	}
	

	@Override
	public void deleteDocumentList(String names) {
		
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "DELETE FROM Document WHERE doc_num IN ( "+names+" )";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
	}


	@Override
	public void deleteDocList(String names) {
conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "DELETE FROM document WHERE doc_num IN ( "+names+" )";
		

		try {
			ps = conn.prepareStatement(sql);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
	}
}

