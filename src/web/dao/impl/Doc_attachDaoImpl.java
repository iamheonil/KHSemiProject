package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web.dao.face.Doc_attachDao;
import web.dbutil.JDBCTemplate;
import web.dto.Doc_attach;
import web.dto.Document;

public class Doc_attachDaoImpl implements Doc_attachDao {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public void insertDoc_attach(Doc_attach doc_attach) {
		conn = JDBCTemplate.getConnection(); //DB 연결

		//다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "INSERT INTO doc_attach(attach_num, doc_num, attach_originname, attach_rename, attach_ext, attach_size)";
		sql += " VALUES ( doc_attach_seq.nextval, ?, ?, ?, ?, ? )";
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);

			ps.setInt(1, doc_attach.getDoc_num());
			ps.setString(2, doc_attach.getAttach_originname());
			ps.setString(3, doc_attach.getAttach_rename());
			ps.setString(4, doc_attach.getAttach_ext());
			ps.setInt(5, doc_attach.getAttach_size());

			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
	}
	
	
	
	@Override
	public void updateDoc_attach(Doc_attach doc_attach) {
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "UPDATE doc_attach SET attach_originname = ?";
		sql += " , attach_rename = ?, attach_ext = ?, attach_size = ?";
		sql += " WHERE doc_num = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, doc_attach.getAttach_originname());
			ps.setString(2, doc_attach.getAttach_rename());
			ps.setString(3, doc_attach.getAttach_ext());
			ps.setInt(4, doc_attach.getAttach_size());
			ps.setInt(5, doc_attach.getDoc_num());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
	}



	@Override
	public Doc_attach selectDoc_attachByDoc(Document doc) {

		//DB연결 객체
		conn = JDBCTemplate.getConnection();
		
		
		String sql = "";
		sql += "select * FROM doc_attach";
		sql += "	where doc_num = ?";
		
		Doc_attach d = null;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			ps.setInt(1, doc.getDoc_num());
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				d = new Doc_attach(); //결과값 저장 객체
				
				//결과값 한 행 처리
				d.setAttach_num(rs.getInt("attach_num"));
				d.setDoc_num(rs.getInt("doc_num"));
				d.setAttach_originname(rs.getString("attach_originname"));
				d.setAttach_rename(rs.getString("attach_rename"));
				d.setAttach_ext(rs.getString("attach_ext"));
				d.setAttach_size(rs.getInt("attach_size"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return d;
	}
}