package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.dao.face.AdminBoardDao;
import web.dbutil.JDBCTemplate;
import web.dto.Board;
import web.util.ad_B_Paging;

public class AdminBoardDaoImpl implements AdminBoardDao {
	
	private Connection conn = null; //DB연결
	private PreparedStatement ps = null; //SQL수행객체
	private ResultSet rs = null; //조회 결과반환 객체

	@Override
	public int selectCntAll() {
		
		conn = JDBCTemplate.getConnection(); //DB연결
		
		//SQL
		String sql = "";
		sql += "SELECT COUNT(*) from board";
		
		//결과 저장 int 생성
		int totalCount = 0;
		
		try {
			ps = conn.prepareStatement(sql); //sql 수행객체
			rs=ps.executeQuery(); 
			
			while(rs.next()) {
				totalCount = rs.getInt(1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		return totalCount;
		
	}

	@Override
	public int selectCntAll(String search) {
		
		conn = JDBCTemplate.getConnection(); //DB연결
		
		//SQL
		String sql = "";
		sql += "SELECT COUNT(*) from (";
		sql += "  SELECT";
		sql += "   		category, b_num, b_title";
		sql += "  	, b_content, b_date, hits, userid, username, userrank, dept";
		sql += "    FROM board";
		sql += "       WHERE 1=1";
		if( null != search && !"".equals(search)) {
		sql += "       AND b_title LIKE ?";
		}
		sql += " )";
		
		
		//결과 저장 int 생성
		int totalCount = 0;
		
		try {
			ps = conn.prepareStatement(sql); //sql 수행객체
			if( null != search && !"".equals(search)) {
			ps.setString(1, "%"+search+"%");
			}
			rs=ps.executeQuery(); 
			
			while(rs.next()) {
				totalCount = rs.getInt(1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		return totalCount;
		
	}
	@Override
	public List<Board> selectAll(ad_B_Paging paging) {
		System.out.println("selectAll - " + paging);
		conn = JDBCTemplate.getConnection(); //DB연결
		
		//SQL 작성
		String sql = "";
		sql += "SELECT * FROM(";
		sql += " SELECT rownum rnum, B.* FROM (";
		sql += "  SELECT";
		sql += "   		category, b_num, b_title";
		sql += "  	, b_content, b_date, hits, userid, username, userrank, dept";
		sql += "    FROM board";
		sql += "       WHERE 1=1";
		if( null != paging.getSearch() && !"".equals(paging.getSearch())) {
		sql += "       AND b_title LIKE ?";
		}
		sql += "	ORDER BY b_num DESC";
		sql += "    ) B";
		sql += "     ORDER BY rnum";
		sql += "  ) BOARD";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		//쿼리 결과 저장 list 생성
		List<Board> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			int index = 1;
			if( null != paging.getSearch() && !"".equals(paging.getSearch())) {
			ps.setString(index++, "%"+paging.getSearch()+"%");
			}
			ps.setInt(index++, paging.getStartNo());
			ps.setInt(index++, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Board board = new Board();
				
				//조회결과 담기
				board.setCategory(rs.getNString("category"));
				board.setB_num(rs.getInt("b_num"));
				board.setB_title(rs.getString("b_title"));
				board.setB_content(rs.getNString("b_content"));
				board.setB_date(rs.getDate("b_date"));
				board.setHits(rs.getInt("hits"));
				board.setUserid(rs.getInt("userid"));
				board.setUsername(rs.getNString("username"));
				board.setUserrank(rs.getString("userrank"));
				board.setDept(rs.getString("dept"));
				
				list.add(board);
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return list;
		
	}

	@Override
	public List<Board> selectNotice(ad_B_Paging paging) {
		
		conn = JDBCTemplate.getConnection(); //DB연결
		
		//SQL 작성
		String sql = "";
		sql += "SELECT * FROM(";
		sql += " SELECT rownum rnum, B.* FROM (";
		sql += "  SELECT";
		sql += "   		category, b_num, b_title";
		sql += "  	, b_content, b_date, hits, userid, username, userrank, dept";
		sql += "    FROM board";
		sql += "       WHERE category='공지사항' AND b_title LIKE '%'||?||'%'";
		sql += "	ORDER BY b_num DESC";
		sql += "    ) B";
		sql += "     ORDER BY rnum";
		sql += "  ) BOARD";
		sql += " WHERE rnum BETWEEN ? AND ?";
		//쿼리 결과 저장 list 생성
		List<Board> list = new ArrayList<>();
		
			try {
				ps=conn.prepareStatement(sql);
				
				ps.setString(1, paging.getSearch());
				ps.setInt(2, paging.getStartNo());
				ps.setInt(3, paging.getEndNo());
				
				rs= ps.executeQuery();
				while(rs.next()) {
					Board board = new Board();
					
					//조회 결과담기
					board.setCategory(rs.getNString("category"));
					board.setB_num(rs.getInt("b_num"));
					board.setB_title(rs.getString("b_title"));
					board.setB_content(rs.getNString("b_content"));
					board.setB_date(rs.getDate("b_date"));
					board.setHits(rs.getInt("hits"));
					board.setUserid(rs.getInt("userid"));
					board.setUsername(rs.getNString("username"));
					board.setUserrank(rs.getString("userrank"));
					board.setDept(rs.getString("dept"));
					
					list.add(board);
					
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
	public void deleteList(String names) {
		
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "DELETE FROM board WHERE b_num IN ( "+names+" )";
		
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

