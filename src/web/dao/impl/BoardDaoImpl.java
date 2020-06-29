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
	public List<Board> selectFree() {
		
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "SELECT * FROM board";
		sql += " WHERE category = '사내게시판'";
		sql += " ORDER BY b_num DESC";
		
		List<Board> F_list = new ArrayList<>();
		
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
				
				F_list.add(board);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
			JDBCTemplate.close(rs);
		}
		
		return F_list;
	}

	@Override
	public List<Board> selectStudy() {
		
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "SELECT * FROM board";
		sql += " WHERE category = '스터디모집'";
		sql += " ORDER BY b_num DESC";
		
		List<Board> S_list = new ArrayList<>();
		
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
				board.setC_cnt(rs.getInt("c_cnt"));
				
				S_list.add(board);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
			JDBCTemplate.close(rs);
		}
		
		return S_list;
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
	public int selectCntAll(String search) {

		      conn = JDBCTemplate.getConnection(); //DB연결
		      
		      //SQL
		      String sql = "";
		      sql += "SELECT COUNT(*) from (";
		      sql += "  SELECT";
		      sql += "         category, b_num, b_title";
		      sql += "     , b_content, b_date, hits, userid, username, userrank, dept, c_cnt";
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
	public int selectNoticeCntAll(String search, int search2) {
		
		conn = JDBCTemplate.getConnection(); //DB연결
		
		//SQL
		String sql = "";
		sql += "SELECT COUNT(*) from board";
		sql += " WHERE category='공지사항'";
		
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
	public int selectStudyCntAll() {
		
		
		conn = JDBCTemplate.getConnection(); //DB연결
		
		//SQL
		String sql = "";
		sql += "SELECT COUNT(*) from board";
		sql += " WHERE category='스터디모집'";
		
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
	public int selectFreeCntAll() {
	
		
		conn = JDBCTemplate.getConnection(); //DB연결
		
		//SQL
		String sql = "";
		sql += "SELECT COUNT(*) from board";
		sql += " WHERE category='사내게시판'";
		
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
		sql += "  	, b_content, b_date, hits, userid, username, userrank, dept, c_cnt";
		sql += "    FROM board";
		sql += "       WHERE 1=1";
		if( null != paging.getSearch() && !"".equals(paging.getSearch())) {
		sql += "       AND b_title Like ?";
		}
		sql += "	ORDER BY b_num DESC";
		sql += "    ) B";
		sql += "     ORDER BY rnum";
		sql += "  ) BOARD";
		sql += " WHERE rnum BETWEEN ? AND ?";
		//쿼리 결과 저장 list 생성
		List<Board> list = new ArrayList<>();
		
			try {
				ps=conn.prepareStatement(sql);
				int index = 1;
				if( null != paging.getSearch() && !"".equals(paging.getSearch())) {
				ps.setString(index++, "%" + paging.getSearch()+"%");
				}
				ps.setInt(index++, paging.getStartNo());
				ps.setInt(index++, paging.getEndNo());
				
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
					board.setC_cnt(rs.getInt("c_cnt"));
					
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
	public List<Board> selectNotice(B_Paging paging) {
			conn = JDBCTemplate.getConnection(); //DB연결
			
			//SQL 작성
			String sql = "";
			sql += "SELECT * FROM(";
			sql += " SELECT rownum rnum, B.* FROM (";
			sql += "  SELECT";
			sql += "   		category, b_num, b_title";
			sql += "  	, b_content, b_date, hits, userid, username, userrank, dept";
			sql += "    FROM board";
			sql += " 	WHERE category='공지사항'";
			
			if(paging.getValue() == 1) {
			sql += "    AND b_title LIKE ?";
			} else if(paging.getValue() == 2) {
			sql += "    AND b_content LIKE ?";	
			} else if(paging.getValue() == 3) {
			sql += "    AND username LIKE ?";	
			}
			
			sql += "	ORDER BY b_num DESC";
			sql += "    ) B";
			sql += "     ORDER BY rnum";
			sql += "  ) BOARD";
			sql += " WHERE rnum BETWEEN ? AND ?";
			
			
//			//SQL 작성
//			String sql = "";
//			sql += "SELECT * FROM(";
//			sql += " SELECT rownum rnum, B.* FROM (";
//			sql += "  SELECT";
//			sql += "   		category, b_num, b_title";
//			sql += "  	, b_content, b_date, hits, userid, username, userrank, dept";
//			sql += "    FROM board";
//			sql += "       WHERE category='공지사항' AND b_title LIKE '%'||?||'%'";
//			sql += "	ORDER BY b_num DESC";
//			sql += "    ) B";
//			sql += "     ORDER BY rnum";
//			sql += "  ) BOARD";
//			sql += " WHERE rnum BETWEEN ? AND ?";
			//쿼리 결과 저장 list 생성
			List<Board> list = new ArrayList<>();
			
			int index = 1;
				try {
					ps=conn.prepareStatement(sql);
					
					if(paging.getValue() == 1 || paging.getValue() == 2 || paging.getValue() == 3) {
						
						ps.setString(index++, "%" + paging.getSearch() + "%");
					}
//					ps.setString(1, paging.getSearch());
					ps.setInt(index++, paging.getStartNo());
					ps.setInt(index++, paging.getEndNo());
					
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
	public List<Board> selectFree(B_Paging paging) {
			conn = JDBCTemplate.getConnection(); //DB연결
			
			//SQL 작성
			String sql = "";
			sql += "SELECT * FROM(";
			sql += " SELECT rownum rnum, B.* FROM (";
			sql += "  SELECT";
			sql += "   		category, b_num, b_title";
			sql += "  	, b_content, b_date, hits, userid, username, userrank, dept";
			sql += "    FROM board";
			sql += "       WHERE category='사내게시판' AND b_title LIKE '%'||?||'%'";
			sql += "	ORDER BY b_num DESC";
			sql += "    ) B";
//			sql += "     WHERE b_title LIKE '%'||?||'%'";
			sql += "    ORDER BY rnum";
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
	public List<Board> selectStudy(B_Paging paging) {
		conn = JDBCTemplate.getConnection(); //DB연결
		
		//SQL 작성
		String sql = "";
		sql += "SELECT * FROM(";
		sql += " SELECT rownum rnum, B.* FROM (";
		sql += "  SELECT";
		sql += "   		category, b_num, b_title";
		sql += "  	, b_content, b_date, hits, userid, username, userrank, dept";
		sql += "    FROM board";
		sql += "       WHERE category='스터디모집' AND b_title LIKE '%'||?||'%'";
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
		sql += "INSERT INTO board( category, b_num, b_title, b_content, hits, userid, username, userrank, dept)";
		sql += " VALUES ( ?, board_seq.nextval, ?, ?, 0, ?, ?, ?, ?)";
		
		try {
			ps = conn.prepareStatement(sql);
			
			//글쓰기 정보 삽입
			ps.setString(1, board.getCategory());
			ps.setString(2, board.getB_title());
			ps.setString(3, board.getB_content());
			ps.setInt(4, board.getUserid());
			ps.setString(5, board.getUsername());
			ps.setString(6, board.getUserrank());
			ps.setString(7, board.getDept());
						
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
		sql += " UPDATE board";		
		sql += " SET category = ?,";
		sql += " b_title = ?,";
		sql += " b_content = ?";
		sql += " WHERE b_num = ?";
		
		//DB객체
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, board.getCategory());
			ps.setString(2, board.getB_title());
			ps.setString(3,  board.getB_content());
			ps.setInt(4, board.getB_num());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally{
			
			try {
				JDBCTemplate.close(ps);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(board.getCategory());
		System.out.println(board.getB_title());
		System.out.println(board.getB_content());
		System.out.println(board.getB_num());
		
		
		
	}


	@Override
	public void updateCoCnt(int b_num) {
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "update board b set b.c_cnt = (select count(*) from board_comment where b_num = b.b_num) WHERE b.b_num = ?";
	
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, b_num);
			
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




	


}
