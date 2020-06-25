package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import web.dao.face.Doc_commentDao;
import web.dbutil.JDBCTemplate;
import web.dto.Doc_comment;
import web.dto.Document;

public class Doc_commentDaoImpl implements Doc_commentDao {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public void deleteDoc_comment(Document doc) {
		
	}

	@Override
	public ArrayList<Map<String, Object>> selectDoc_commentByDocno(Document doc) {
		
		//DB연결 객체
		conn = JDBCTemplate.getConnection();
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		//SQL 작성 - 직접 작성한 문서는 아니고 수신자 경로에 자신이 있으면 조회함
		String sql = "";
		sql += "select";
		sql += "    C.comm_content, C.receiver_id, C.comm_date, U.username, R.report_type, U.userrank";
		sql += "    from doc_comment C";
		sql += "        inner join document D on D.doc_num = C.doc_num";
		sql += "        inner join user_basic U on U.userid = C.receiver_id";
		sql += "        inner join report_link R on R.doc_num = D.doc_num";
		sql += "		where D.doc_num = ?";
		sql += "        and r.receiver_id = c.receiver_id";
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			ps.setInt(1, doc.getDoc_num());
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Map<String, Object> c = new HashMap<String, Object>(); //결과값 저장 객체
		 		
				//결과값 한 행 처리
				c.put("comm_content", rs.getString("comm_content"));
				c.put("comm_date", rs.getDate("comm_date"));
				c.put("receiver_id", rs.getString("receiver_id"));
				c.put("username", rs.getString("username"));
				c.put("report_type", rs.getString("report_type"));
				c.put("userrank", rs.getString("userrank"));
				
				list.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return list;
		
		
	}

	@Override
	public void insertDoc_comment(Doc_comment doc_comment) {
		
	}
}