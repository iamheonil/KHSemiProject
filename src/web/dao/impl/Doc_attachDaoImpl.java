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
		
	}

	@Override
	public void deleteDoc_attach(Document doc) {
		
	}

	@Override
	public Doc_attach selectDoc_attachByDoc(Document doc) {

		//DB연결 객체
		conn = JDBCTemplate.getConnection();
		
		//SQL 작성 - 직접 작성한 문서는 아니고 수신자 경로에 자신이 있으면 조회함
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
				d.setAttach_originname(rs.getString("attach_originname"));
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