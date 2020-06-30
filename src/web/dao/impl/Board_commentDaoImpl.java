package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdk.nashorn.internal.scripts.JD;
import web.dao.face.Board_commentDao;
import web.dbutil.JDBCTemplate;
import web.dto.Board;
import web.dto.Board_comment;
import web.dto.Comment_comment;

public class Board_commentDaoImpl implements Board_commentDao{

	//DB 연결 객체
	private Connection conn = null;
	
	//JDBC 객체
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public List<Board_comment> selectComment(Board board) {
		
		conn = JDBCTemplate.getConnection(); //DB연결
		
		String sql = "";
		sql += " SELECT * FROM ("
							  + "SELECT rownum rnum, B.*FROM ("
							  + "	SELECT"
							  + " 			c_num,"
							  + "			b_num,"
							  + "			userid,"
							  + "           username,"
							  + "			c_content,"
							  + "           c_date,"
							  + "           userrank,"
							  + "           dept"
							  + " 	FROM board_comment"
							  + "   WHERE b_num = ?"
							  + "   ORDER BY c_date"
							  + "   ) B"
							  + ") ORDER BY rnum";
		List commentList = new ArrayList();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, board.getB_num());
			
			// rs 반환
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Board_comment comment = new Board_comment();
				
				comment.setRnum(rs.getInt("rnum"));
				comment.setB_num(rs.getInt("b_num"));
				comment.setC_num(rs.getInt("c_num"));
				comment.setUserid(rs.getInt("userid"));
				comment.setUsername(rs.getString("username"));
				comment.setC_content(rs.getString("c_content"));
				comment.setC_date(rs.getDate("c_date"));
				comment.setUserrank(rs.getString("userrank"));
				comment.setDept(rs.getString("dept"));
				commentList.add(comment);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		System.out.println("댓글리스트" + commentList);
		return commentList;
	}
	
//	@Override
//	public List<Comment_comment> selectC_Comment(Board_comment comment) {
//		
//		conn = JDBCTemplate.getConnection();
//		
//		String sql = "";
//		sql += " SELECT * FROM (SELECT rownum rnum, B.*FROM (SELECT c_num, c_cnum, userid, username, c_ccontent, userrank, dept FROM comment_comment WHERE c_num = ? ORDER BY c_cdate) B) ORDER BY rnum";
//		
//		List c_commentList = new ArrayList();
//		
//			try {
//				ps = conn.prepareStatement(sql);
//				
//				ps.setInt(1, comment.getC_num());
//				
//				rs = ps.executeQuery();
//				
//				while(rs.next()) {
//					Comment_comment c_comment = new Comment_comment();
//					
//					c_comment.setRnum(rs.getInt("rnum"));
//					c_comment.setC_num(rs.getInt("c_num"));
//					c_comment.setC_cnum(rs.getInt("c_cnum"));
//					c_comment.setUserid(rs.getInt("userid"));
//					c_comment.setUsername(rs.getString("username"));
//					c_comment.setC_ccontent(rs.getString("c_ccontent"));
//					c_comment.setC_cdate(rs.getDate("c_cdate"));
//					c_comment.setUserrank(rs.getNString("userrank"));
//					c_comment.setDept(rs.getString("dept"));
//					
//					c_commentList.add(c_comment);
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				try {
//					if(rs!=null)	rs.close();
//					if(ps!=null) 	ps.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//					
//				}
//			} 
//			System.out.println("댓글리스트 : " + c_commentList);
//		return c_commentList;
//	}
	
	@Override
	public void insertComment(Board_comment comment) {
		
		conn  = JDBCTemplate.getConnection();
		
		String sql = "";
			   sql += "INSERT INTO board_comment( c_num, b_num, userid, c_content, username, userrank, dept )";
			   sql += "		VALUES ( board_comment_seq.nextval, ?, ?, ?, ?, ?, ?)";
				try {
					ps = conn.prepareStatement(sql);
					
					ps.setInt(1, comment.getB_num());
					ps.setInt(2, comment.getUserid());
					ps.setString(3, comment.getC_content());
					ps.setString(4, comment.getUsername());
					ps.setString(5, comment.getUserrank());
					ps.setString(6, comment.getDept());
					
					ps.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if(ps!=null) 	ps.close();
						
					}catch (SQLException e) {
							e.printStackTrace();
					}
					
				}
				System.out.println("댓글번호" + comment.getC_num()); //들어감
				System.out.println("게시판 번호" + comment.getB_num()); //들어감
				System.out.println("아이디" +comment.getUserid()); //들어감
				System.out.println(comment.getC_content());
				System.out.println(comment.getUsername()); //들어감
				System.out.println(comment.getUserrank());
				System.out.println(comment.getDept()); //들어감
	}

	@Override
	public void deleteComment(Board_comment comment) {

			conn = JDBCTemplate.getConnection();
			
			String sql = "";
			sql += "DELETE board_comment";
			sql += " WHERE c_num = ?";
			
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, comment.getC_num());
				
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
	public int countComment(Board_comment comment) {
		
		conn = JDBCTemplate.getConnection();
		
		String sql = "SELECT COUNT(*) FROM board_comment";
			   sql +=" WHERE c_num=?";
				
		int cnt = 0;
		
			try {
				ps=conn.prepareStatement(sql);
				ps.setInt(1, comment.getC_num());
				rs = ps.executeQuery();
				rs.next();
				cnt = rs.getInt(1);
			} catch (SQLException e) {
				
				e.printStackTrace();
			
			} finally {
				JDBCTemplate.close(ps);
				JDBCTemplate.close(rs);
			}
		
		return cnt;
	}

//	@Override
//	public Board_comment selectCommentByCommentno(Board_comment commentnum) {
//		
//		//DB연결
//		
//		conn = JDBCTemplate.getConnection();
//		
//		String sql = "";
//		sql += "SELECT * FROM board_comment";
//		sql += " WHERE c_num = ?";
//		
//		//조회 결과 저장
//		Board_comment viewComment = null; 
//		
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, commentnum.getC_num());
//			
//			rs = ps.executeQuery();
//			
//			while(rs.next()) {
//				
//				viewComment = new Board_comment();
//				
//				viewComment.setB_num(rs.getInt("b_num"));
//				viewComment.setC_num(rs.getInt("c_num"));
//				viewComment.setC_content(rs.getString("c_content"));
//				viewComment.setC_date(rs.getDate("c_date"));
//				viewComment.setDept(rs.getString("dept"));
//				viewComment.setRnum(rs.getInt("rnum"));
//				viewComment.setUserid(rs.getInt("userid"));
//				viewComment.setUsername(rs.getString("username"));
//				viewComment.setUserrank(rs.getString("userrank"));
//				
//				
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(ps);
//			
//		}
//		
//		System.out.println("???!!?!?" + viewComment);
//		
//		return viewComment;
//	}



}
