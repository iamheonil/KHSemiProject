package web.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.dao.face.BoardDao;
import web.dbutil.JDBCTemplate;
import web.dto.Board;
import web.util.B_Paging;

public class BoardDaoImpl implements BoardDao{

	private Connection conn = null; //DB연결
	private PreparedStatement ps = null; //SQL수행객체
	private ResultSet rs = null; //조회 결과반환 객체
	
	
	@Override
	public List<Board> selectAll() {
		
		conn = JDBCTemplate.getConnection(); //DB연결
		
		
		//SQL 작성
		String sql = "";
		sql += "SELECT * FROM board";
		sql += " ORDER BY b_num DESC";
		
		//쿼리 결과를 저장할 list 생성
		List<Board> list = new ArrayList<>();
		
		try {
			ps= conn.prepareStatement(sql);
			rs = ps.executeQuery(); //SQL수행 및 결과 반환
			
			while(rs.next()) {
				Board board = new Board();
				
				board.setCategory(rs.getString("category"));
				board.setB_num(rs.getInt("b_num"));
				board.setB_title(rs.getString("b_title"));
				board.setB_date(rs.getDate("b_date"));
				board.setHits(rs.getInt("hits"));
				board.setUserid(rs.getInt("userid"));
				board.setUsername(rs.getString("username"));
				
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
	public List<Board> selectNotice() {
		
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "SELECT * FROM board";
		sql += " WHERE category = '공지사항'";
		sql += " ORDER BY b_num DESC";
		
		List<Board> N_list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				
				board.setCategory(rs.getString("category"));
				board.setB_num(rs.getInt("b_num"));
				board.setB_title(rs.getString("b_title"));
				board.setB_date(rs.getDate("b_date"));
				board.setHits(rs.getInt("hits"));
				board.setUserid(rs.getInt("userid"));
				board.setUsername(rs.getString("username"));
				
				N_list.add(board);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
			JDBCTemplate.close(rs);
		}
		
		return N_list;
	}

	
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
	public List<Board> selectAll(B_Paging paging) {
		
		conn = JDBCTemplate.getConnection(); //DB연결
		
		//SQL 작성
		String sql = "";
		sql += "SELECT * FROM(";
		sql += " SELECT rownum rnum, B.* FROM (";
		sql += "  SELECT";
		sql += "   		category, b_num, b_title";
		sql += "  	, b_content, b_date, hits, userid, username, userrank, dept";
		sql += "    FROM board";
		sql += "	ORDER BY b_num DESC";
		sql += "    ) B";
		sql += "  ) BOARD";
		sql += " WHERE rnum BETWEEN ? AND ?";
		//쿼리 결과 저장 list 생성
		List<Board> list = new ArrayList<>();
		
			try {
				ps=conn.prepareStatement(sql);
				
				ps.setInt(1, paging.getStartNo());
				ps.setInt(2, paging.getEndNo());
				
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
	public Board selectBoardByBoardno(Board boardnum) {
		
		//DB연결
		
		conn = JDBCTemplate.getConnection();
		
		//sql쿼리 작성
		String sql = "";
		sql += "SELECT * FROM board";
		sql += " WHERE b_num = ?";
		
		//조회 결과 저장
		Board viewBoard = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardnum.getB_num());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				viewBoard = new Board();
				
				viewBoard.setCategory(rs.getString("category"));
				viewBoard.setB_num(rs.getInt("b_num"));
				viewBoard.setB_title(rs.getString("b_title"));
				viewBoard.setB_content(rs.getString("b_content"));
				viewBoard.setHits(rs.getInt("hits"));
				viewBoard.setUserid(rs.getInt("userid"));
				viewBoard.setUsername(rs.getString("username"));
				viewBoard.setUserrank(rs.getString("userrank"));
				viewBoard.setDept(rs.getString("dept"));
				viewBoard.setB_date(rs.getDate("b_date"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		
		return viewBoard;
	}


	@Override
	public void updateHit(Board boardnum) {
		
		//DB연결
		conn = JDBCTemplate.getConnection();
		
		//SQL 작성
		String sql = "";
		sql += "UPDATE board";
		sql += " SET hits = hits + 1";
		sql += " WHERE b_num = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardnum.getB_num());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(ps);
		}
		
		
	}


	@Override
	public String selectNameByUserid(Board viewBoard) {
		
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "SELECT username FROM user_basic";
		sql += " WHERE userid = ?";
		
		String username = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, viewBoard.getUserid());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
					username = rs.getString("username");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(ps);
			JDBCTemplate.close(rs);
			
		}
		
		return username;
	}


	@Override
	public int selectBoardno() {
		
		//DB연결
		conn = JDBCTemplate.getConnection();
		
		//SQL 작성
		String sql = "";
		sql += " SELECT board_seq.nextval FROM dual";
		
		//결과 저장할 변수
		int boardnum = 0;
		
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
				
				
				while(rs.next()) {
					boardnum = rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
				
			}
			
		return boardnum;
	}


	@Override
	public void insertBoard(Board board) {
		
		//DB연결
		conn = JDBCTemplate.getConnection();
		
		//SQL 작성
		String sql = "";
		sql += "INSERT INTO board( cateogory, userid, b_num, b_title, b_content, hits)";
		sql += "VALUES ( ?, ?, ?, ?, 0)";
		
		try {
			ps = conn.prepareStatement(sql);
			
			//글쓰기 정보 삽입
			ps.setString(1, board.getCategory());
			ps.setInt(2, board.getUserid());
			ps.setInt(3, board.getB_num());
			ps.setString(4, board.getB_title());
			ps.setString(5, board.getB_content());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}


	@Override
	public void deleteBoard(Board board) {
		
		conn = JDBCTemplate.getConnection();
		
		String sql ="";
		sql += "DELETE FROM board WHERE b_num=?";
		
			try {
				ps= conn.prepareStatement(sql);
				
				ps.setInt(1, board.getB_num());
				
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				
				try {
					JDBCTemplate.close(ps);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}


	@Override
	public void boardUpdate(Board board) {
		
		//DB연결
		conn = JDBCTemplate.getConnection();
		
		//다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "UPDATE board";		
		sql += " SET b_title = ?,";
		sql += " category = ?,";
		sql += " b_content = ?";
		sql += " WHERE b_num = ?";
		
		//DB객체
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, board.getB_title());
			ps.setString(2,  board.getB_content());
			ps.setInt(3, board.getB_num());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally{
			JDBCTemplate.close(ps);
		}
	}


}
